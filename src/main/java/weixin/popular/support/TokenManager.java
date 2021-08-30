package weixin.popular.support;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weixin.popular.api.TokenAPI;
import weixin.popular.bean.AppConfigInfo;
import weixin.popular.bean.token.Token;
import weixin.popular.client.LocalHttpClient;

/**
 * TokenManager token 自动刷新
 * @author LiYi
 *
 */
public class TokenManager{

	private static final Logger logger = LoggerFactory.getLogger(TokenManager.class);
	
	private static ScheduledExecutorService scheduledExecutorService;

	private static Map<String,Token> tokenMap = new ConcurrentHashMap<String,Token>();

	private static Map<String,ScheduledFuture<?>> futureMap = new ConcurrentHashMap<String, ScheduledFuture<?>>();

	private static int poolSize = 2;
	
	private static boolean daemon = Boolean.TRUE;
	
	private static String firestAppid;

	private static Map<String,AppConfigInfo> configMap = new ConcurrentHashMap<String,AppConfigInfo>();
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

	/**
	 * 设置线程池
	 * @param poolSize poolSize
	 */
	public static void setPoolSize(int poolSize){
		TokenManager.poolSize = poolSize;
	}
	
	/**
	 * 设置线程方式
	 * @param daemon daemon
	 */
	public static void setDaemon(boolean daemon) {
		TokenManager.daemon = daemon;
	}
	
	public static void init(final String appid,final String secret,int proxy,String tokenUrl,String ticketUrl){
		init(appid, secret, 0, 60*118, proxy, tokenUrl, ticketUrl);
	}
	
	/**
	 * 初始化token 刷新，每118分钟刷新一次。
	 * @param appid appid
	 * @param secret secret
	 */
	public static void init(final String appid,final String secret){
		init(appid, secret, 0, 60*118, 0, null,null);
	}

	/**
	 * 初始化token 刷新，每118分钟刷新一次。
	 * @param appid appid
	 * @param secret secret
	 * @param initialDelay 首次执行延迟（秒）
	 * @param delay 执行间隔（秒）
	 */
	public static void init(final String appid,final String secret,int initialDelay,int delay,int proxy,String tokenUrl,String ticketUrl){
		if(scheduledExecutorService == null){
			initScheduledExecutorService();
		}
		if(firestAppid == null){
			firestAppid = appid;
		}
		if(futureMap.containsKey(appid)){
			futureMap.get(appid).cancel(true);
		}
		configMap.put(appid, new AppConfigInfo().setAppid(appid).setSecret(secret).setProxy(proxy).setTokenUrl(tokenUrl).setTicketUrl(ticketUrl));
		
		//立即执行一次
		if(initialDelay == 0){
			doRun(appid);
		}
		ScheduledFuture<?> scheduledFuture =  scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				doRun(appid);
			}
		},initialDelay == 0 ? delay : initialDelay,delay,TimeUnit.SECONDS);
		futureMap.put(appid, scheduledFuture);
		logger.info("appid:{}",appid);
	}
	
	private static void doRun(final String appid) {
		try {
			Token token = null;
			AppConfigInfo config = configMap.get(appid);
			if(config.getProxy() == 1 && config.getTokenUrl() != null && !config.getTokenUrl().equals("")) 
				token = proxyToken(appid,config);
			else {
				token = TokenAPI.token(appid,config.getSecret());
				token.setStartTime(new Date().getTime());
			}
			tokenMap.put(appid,token);
			logger.info("ACCESS_TOKEN refurbish with appid:{}",appid);
		} catch (Exception e) {
			logger.error("ACCESS_TOKEN refurbish error with appid:{}",appid);
			logger.error("", e);
		}
	}

	private static Token proxyToken(String appid,AppConfigInfo config) throws ClientProtocolException, IOException {
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri(config.getTokenUrl())
				.addParameter("grant_type","client_credential")
				.addParameter("appid", appid)
				.addParameter("secret", config.getSecret())
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Token.class);
	}
	
	public static AppConfigInfo getConfig(String appid) {
		return configMap.get(appid);
	}
	/**
	 * 取消 token 刷新
	 */
	public static void destroyed(){
		if(scheduledExecutorService != null)
			scheduledExecutorService.shutdownNow();
		logger.info("destroyed");
	}
	
	/**
	 * 取消刷新
	 * @param appid appid
	 */
	public static void destroyed(String appid){
		if(futureMap.containsKey(appid)){
			futureMap.get(appid).cancel(true);
			logger.info("destroyed appid:{}",appid);
		}
	}

	/**
	 * 获取 access_token
	 * @param appid appid
	 * @return token
	 * @throws InterruptedException 
	 */
	public static String getToken(String appid) throws Exception{
		Token token = tokenMap.get(appid);
		int maxRetries = 10,retries = 0;
		while((token == null || token.isExpired()) && retries < maxRetries) {
			if(retries > 0)
				Thread.sleep(100);
			
			doRun(appid);
			token = tokenMap.get(appid);
			retries++;
		}
		if(token == null)
			throw new Exception("Get token exception");
		
		return token.getAccess_token();
	}

	/**
	 * 获取第一个appid 的 access_token
	 * 适用于单一微信号
	 * @return token
	 */
	public static String getDefaultToken() throws Exception{
		return getToken(firestAppid);
	}

}
