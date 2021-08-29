package weixin.popular.bean;

public class AppConfigInfo {
	private String appid;
	private int proxy;
	private String ticketUrl;
	private String tokenUrl;
	private String secret;
	
	public int getProxy() {
		return proxy;
	}
	public AppConfigInfo setProxy(int proxy) {
		this.proxy = proxy;
		return this;
	}
	
	public String getTicketUrl() {
		return ticketUrl;
	}
	public AppConfigInfo setTicketUrl(String ticketUrl) {
		this.ticketUrl = ticketUrl;
		return this;
	}
	public String getTokenUrl() {
		return tokenUrl;
	}
	public AppConfigInfo setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
		return this;
	}
	public String getAppid() {
		return appid;
	}
	public AppConfigInfo setAppid(String appid) {
		this.appid = appid;
		return this;
	}
	public String getSecret() {
		return secret;
	}
	public AppConfigInfo setSecret(String secret) {
		this.secret = secret;
		return this;
	}
	
}
