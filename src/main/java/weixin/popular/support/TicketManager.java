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

import weixin.popular.api.TicketAPI;
import weixin.popular.bean.AppConfigInfo;
import weixin.popular.bean.ticket.Ticket;
import weixin.popular.client.LocalHttpClient;

/**
 * TicketManager ticket(jsapi | wx_card) 自动刷新
 * @author LiYi
 *
 */
public class TicketManager {
	
	private static final Logger logger = LoggerFactory.getLogger(TicketManager.class);

	private static ScheduledExecutorService scheduledExecutorService;

	private static Map<String,Ticket> ticketMap = new ConcurrentHashMap<String,Ticket>();

	private static Map<String,ScheduledFuture<?>> futureMap = new ConcurrentHashMap<String, ScheduledFuture<?>>();

	private static int poolSize = 2;
	
	private static boolean daemon = Boolean.TRUE;
	
	private static String firestAppid;
	
	private static final String KEY_JOIN = "__";
	
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
		TicketManager.poolSize = poolSize;
	}

	/**
	 * 设置线程方式
	 * @param daemon daemon
	 */
	public static void setDaemon(boolean daemon) {
		TicketManager.daemon = daemon;
	}
	
	/**
	 * 初始化ticket(jsapi) 刷新，每119分钟刷新一次。<br>
	 * 依赖TokenManager
	 * @param appid appid
	 */
	public static void init(final String appid){
		init(appid,0,60*119);
	}
	
	/**
	 * 初始化ticket 刷新，每119分钟刷新一次。<br>
	 * 依赖TokenManager
	 * @since 2.8.2 
	 * @param appid appid
	 * @param types [jsapi,wx_card]
	 */
	public static void init(final String appid,String... types){
		init(appid,0,60*119,types);
	}
	
	/**
	 * 初始化ticket(jsapi) 刷新 
	 * 依赖TokenManager
	 * @since 2.6.1
	 * @param appid appid
	 * @param initialDelay 首次执行延迟（秒）
	 * @param delay 执行间隔（秒）
	 */
	public static void init(final String appid,int initialDelay,int delay){
		init(appid,initialDelay, delay,"jsapi");
	}
	
	/**
	 * 初始化ticket 刷新
	 * 依赖TokenManager
	 * @since 2.8.2
	 * @param appid appid
	 * @param initialDelay 首次执行延迟（秒）
	 * @param delay 执行间隔（秒）
	 * @param types ticket 类型  [jsapi,wx_card]
	 */
	public static void init(final String appid,int initialDelay,int delay,String... types){
		if(firestAppid == null){
			firestAppid = appid;
		}
		for(final String type : types){
			final String key = getKey(appid, type);
			if(scheduledExecutorService == null){
				initScheduledExecutorService();
			}
			if(futureMap.containsKey(key)){
				futureMap.get(key).cancel(true);
			}
			//立即执行一次
			if(initialDelay == 0){
				doRun(appid, type, key);
			}
			ScheduledFuture<?> scheduledFuture =  scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
				@Override
				public void run() {
					doRun(appid, type, key);
				}
			},initialDelay == 0 ? delay : initialDelay,delay,TimeUnit.SECONDS);
			futureMap.put(key,scheduledFuture);
		}
	}
		
	private static void doRun(final String appid, final String type, final String key) {
		try {
			String access_token = TokenManager.getToken(appid);
			AppConfigInfo config = TokenManager.getConfig(appid);
			Ticket ticket;
			if(config.getProxy() == 1 && config.getTicketUrl() != null && !config.getTicketUrl().equals("")) 
				ticket = proxyTicket(appid,config,type);
			else {
				ticket = TicketAPI.ticketGetticket(access_token,type);
				ticket.setStartTime(new Date().getTime());
			}
			ticketMap.put(key,ticket);
			logger.info("TICKET refurbish with appid:{} type:{}",appid,type);
		} catch (Exception e) {
			logger.error("TICKET refurbish error with appid:{} type:{}",appid,type);
			logger.error("", e);
		}
	}
	
	private static String getKey(String appid, String type) {
		return appid + KEY_JOIN + type;
	}
	
	private static Ticket proxyTicket(String appid,AppConfigInfo config,String type) throws ClientProtocolException, IOException {
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri(config.getTicketUrl())
				.addParameter("grant_type","client_credential")
				.addParameter("appid", appid)
				.addParameter("secret", config.getSecret())
				.addParameter("type", type)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Ticket.class);
	}
	
	/**
	 * 取消 ticket 刷新
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
		destroyed(appid,"jsapi","wx_card");
	}
	
	/**
	 * 取消刷新
	 * @param appid appid
	 * @param types ticket 类型  [jsapi,wx_card]
	 */
	public static void destroyed(String appid,String... types){
		for(String type : types){
			String key = getKey(appid, type);
			if(futureMap.containsKey(key)){
				futureMap.get(key).cancel(true);
				logger.info("destroyed appid:{} type:{}",appid,type);
			}
		}
	}

	/**
	 * 获取 ticket(jsapi)
	 * @param appid appid
	 * @return ticket
	 * @throws Exception 
	 */
	public static String getTicket(final String appid) throws Exception{
		return getTicket(appid ,"jsapi");
	}
		
	/**
	 * 获取 ticket
	 * @param appid appid
	 * @param type jsapi or wx_card
	 * @return ticket
	 */
	public static String getTicket(final String appid,String type) throws Exception{
		String key = getKey(appid, type);
		Ticket ticket = ticketMap.get(key);
		int maxRetries = 10,retries = 0;
		while((ticket == null || ticket.isExpired()) && retries < maxRetries) {
			doRun(appid,type,key);
			ticket = ticketMap.get(key);
			if(ticket != null && !ticket.isExpired())
				break;
			
			retries++;
			Thread.sleep(100);
		}
		
		if(ticket == null || ticket.isExpired())
			throw new Exception("Get token exception");
			
		return ticket.getTicket();
	}
	

	/**
	 * 获取第一个appid 的第一个类型的 ticket
	 * 适用于单一微信号
	 * @return ticket
	 * @throws Exception 
	 */
	public static String getDefaultTicket(String type) throws Exception{
		return getTicket(firestAppid);
	}

}
