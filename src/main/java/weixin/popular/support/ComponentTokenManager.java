package weixin.popular.support;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weixin.popular.api.ComponentAPI;
import weixin.popular.bean.PlatformConfigInfo;
import weixin.popular.bean.comment.AuthToken;
import weixin.popular.bean.component.AuthorizerAccessToken;
import weixin.popular.bean.component.ComponentAccessToken;

/*
 * 微信第三方平台token管理
 * componentToken--根据appId和secret获取 2小时过期
 * authToken-调用业务接口使用的。通过refreshToken和componentToken获取 
* */
public class ComponentTokenManager {

	private static final Logger logger = LoggerFactory.getLogger(ComponentTokenManager.class);
	private static ScheduledExecutorService scheduledExecutorService;

	//平台访问令牌accessToken缓存
	private static Map<String, ComponentAccessToken> accessTokenCacheMap = new ConcurrentHashMap<String,ComponentAccessToken>();
	//平台配置缓存
	private static Map<String,PlatformConfigInfo> platformConfig = new ConcurrentHashMap<String,PlatformConfigInfo>();
	
	//授权的小程序访问令牌及刷新令牌缓存
	private static final Map<String,AuthToken> authTokenMap = new LinkedHashMap<String,AuthToken>();

	private static final Map<String,ScheduledFuture<?>> futureMap = new HashMap<String, ScheduledFuture<?>>();

	private static int poolSize = 2;
	
	private static boolean daemon = Boolean.TRUE;
	
	/**
	 * 设置线程池
	 * @param poolSize poolSize
	 */
	public static void setPoolSize(int poolSize){
		ComponentTokenManager.poolSize = poolSize;
	}
	
	/**
	 * 设置线程方式
	 * @param daemon daemon
	 */
	public static void setDaemon(boolean daemon) {
		ComponentTokenManager.daemon = daemon;
	}
	
	public static String getTicket(String appId) {
		PlatformConfigInfo conf = platformConfig.get(appId);
		if(conf == null)
			return null;
		else
			return conf.getTicket();
	}
	
	public static void cacheTicket(String appId, String secret, String ticket) {
		PlatformConfigInfo conf = platformConfig.get(appId);
		if(conf == null) {
			conf = new PlatformConfigInfo().setAppid(appId).setSecret(secret).setTicket(ticket);
			platformConfig.put(appId, conf);
		} else {
			conf.setTicket(ticket);
		}
	}
		
	/**
	 * 初始化 scheduledExecutorService
	 */
	private static void initScheduledExecutorService(){
		logger.info("daemon:{},poolSize:{}",daemon,poolSize);
		scheduledExecutorService =  Executors.newScheduledThreadPool(poolSize,new ThreadFactory() {
			@Override
			public Thread newThread(Runnable arg0) {
				Thread thread = Executors.defaultThreadFactory().newThread(arg0);
				//设置守护线程
				thread.setDaemon(daemon);
				return thread;
			}
		});
	}
	
	public static void startRefreshComponent(final String appId,final String secret,final String ticket) {
		
		if(scheduledExecutorService == null){
			initScheduledExecutorService();
		}
		
		if(futureMap.containsKey(appId)){
			futureMap.get(appId).cancel(true);
		}
		
		platformConfig.put(appId, new PlatformConfigInfo().setAppid(appId).setSecret(secret).setTicket(ticket));
		
		try {
			doRunRefreshComponentAccessToken(appId, secret, ticket);
		} catch (ClientProtocolException e) {
			logger.error(e.getMessage(),e);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}
								
		ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				try {
					doRunRefreshComponentAccessToken(appId, secret, ticket);
				} catch (ClientProtocolException e) {
					logger.error(e.getMessage(),e);
				} catch (IOException e) {
					logger.error(e.getMessage(),e);
				}
			}
		}, 118, 118, TimeUnit.MINUTES);
		
		futureMap.put(appId, scheduledFuture);
	}
	
	private static void doRunRefreshComponentAccessToken(String appId,String secret,String ticket) throws ClientProtocolException, IOException {
						
		ComponentAccessToken componentToken = ComponentAPI.api_component_token(appId, secret, ticket);
		if(!componentToken.isSuccess()) 
			throw new ClientProtocolException("COMPONENT_TOKEN FUN ERROR!errcode:" + componentToken.getErrcode() + " errMsg:" + componentToken.getErrmsg());

		componentToken.setStartTime(new Date().getTime());
		accessTokenCacheMap.put(appId, componentToken);

	}

	public static void startRefreshAuthAppAccessToken(final String appId,final String authAppId,final String authAppRefreshToken) {
		
		if(scheduledExecutorService == null){
			initScheduledExecutorService();
		}
		
		if(futureMap.containsKey(authAppId)){
			futureMap.get(authAppId).cancel(true);
		}
		
		try {
			doRunRefreshAuthAppAccessToken(appId, authAppId, authAppRefreshToken);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				try {
					doRunRefreshAuthAppAccessToken(appId, authAppId, authAppRefreshToken);
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}
		}, 0, 118, TimeUnit.MINUTES);
		
		futureMap.put(appId, scheduledFuture);
	}
	
	private static void doRunRefreshAuthAppAccessToken(String appId,String authAppId,String refreshToken) throws Exception {
		//获取authToken
		String componentTokenString = getComponentTokenString(appId);
		if(componentTokenString == null || componentTokenString.equals("")) 
			throw new Exception("平台accessToken为空，无法刷新");
		
		AuthorizerAccessToken authorizerTokenResult = ComponentAPI.api_authorizer_token(componentTokenString, appId, authAppId, refreshToken);
		if(!authorizerTokenResult.isSuccess())
			throw new Exception("AUTH_TOKEN FUN ERROR! errcode:" + authorizerTokenResult.getErrcode() + " errmsg:" + authorizerTokenResult.getErrmsg() + " appid:" + authAppId);

		authTokenMap.put(authAppId, new AuthToken()
				.setRefreshToken(refreshToken)
				.setAuthToken(authorizerTokenResult.getAuthorizer_access_token())
				.setExpiresIn(authorizerTokenResult.getExpires_in())
				.setStartTime(new Date().getTime())
				.setPlatformAppId(appId)
				);
	}
	
	public static AuthToken getAuthToken(String authAppId)  throws Exception{
		AuthToken token = authTokenMap.get(authAppId);
		if(token == null)
			throw new Exception("AuthToken is not initialized. AuthAppId" + authAppId);
		
		int maxRetries = 10,retries = 0;
		while((token == null || token.isExpired()) && retries < maxRetries) {
			doRunRefreshAuthAppAccessToken(token.getPlatformAppId(), authAppId, token.getRefreshToken());
			token = authTokenMap.get(authAppId);
			if(token != null && !token.isExpired())
				break;
			
			retries++;
			Thread.sleep(100);
		}
		
		if(token.isExpired())
			throw new Exception("Get authToken timeout.");
		
		return token;
	}

	public static String getAuthTokenString(String authAppId) throws Exception {
		return getAuthToken(authAppId).getAuthToken();
	}

	public static String getComponentTokenString(String appId) throws Exception{
		ComponentAccessToken token = accessTokenCacheMap.get(appId);
		int maxRetries = 10,retries = 0;
		while((token == null || token.isExpired()) && retries < maxRetries) {
			
			PlatformConfigInfo conf = platformConfig.get(appId);
			if(conf == null)
				throw new Exception("Platform is not initialized. Platform appid = " + appId);
			
			doRunRefreshComponentAccessToken(appId,conf.getSecret(),conf.getTicket());
			token = accessTokenCacheMap.get(appId);
			if(token != null && !token.isExpired())
				break;
			
			retries++;
			Thread.sleep(100);
			
		}
		
		if(token == null || token.isExpired())
			throw new Exception("Get token exception");
		
		return token.getComponent_access_token();
	}
	
}
