package weixin.popular.bean.token;

import java.util.Date;

import weixin.popular.bean.BaseResult;

public class Token extends BaseResult {

	private String access_token;
	private int expires_in;
	private long startTime;
	
	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String accessToken) {
		access_token = accessToken;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expiresIn) {
		expires_in = expiresIn;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	
	public boolean isExpired() {
		return (new Date()).getTime() - startTime >= expires_in;
	}
}
