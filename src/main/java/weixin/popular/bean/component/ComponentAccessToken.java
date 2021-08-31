package weixin.popular.bean.component;

import java.util.Date;

import weixin.popular.bean.BaseResult;

public class ComponentAccessToken extends BaseResult{

	private String component_access_token;

	private int expires_in;
	
	private long startTime;
	
	public String getComponent_access_token() {
		return component_access_token;
	}

	public void setComponent_access_token(String component_access_token) {
		this.component_access_token = component_access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	
	public boolean isExpired() {
		return ((new Date()).getTime() - startTime)/1000 >= expires_in;
	}

}
