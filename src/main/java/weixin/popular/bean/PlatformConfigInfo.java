package weixin.popular.bean;

public class PlatformConfigInfo {
	private String appid;
	private String secret;
	private String ticket;
	
	public String getAppid() {
		return appid;
	}
	
	public PlatformConfigInfo setAppid(String appid) {
		this.appid = appid;
		return this;
	}
	
	public String getSecret() {
		return secret;
	}
	
	public PlatformConfigInfo setSecret(String secret) {
		this.secret = secret;
		return this;
	}
	
	public String getTicket() {
		return ticket;
	}
	
	public PlatformConfigInfo setTicket(String ticket) {
		this.ticket = ticket;
		return this;
	}
	
	
}
