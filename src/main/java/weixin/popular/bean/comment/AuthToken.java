package weixin.popular.bean.comment;

import java.util.Date;

public class AuthToken {
	
	private String platformAppId;
	private String refreshToken;
	private String authToken;
	private int expiresIn;
	private long startTime;
	
	public String getPlatformAppId() {
		return platformAppId;
	}
	public AuthToken setPlatformAppId(String platformAppId) {
		this.platformAppId = platformAppId;
		return this;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public AuthToken setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
		return this;
	}
	public String getAuthToken() {
		return authToken;
	}
	public AuthToken setAuthToken(String authToken) {
		this.authToken = authToken;
		return this;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public AuthToken setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
		return this;
	}
	public long getStartTime() {
		return startTime;
	}
	public AuthToken setStartTime(long startTime) {
		this.startTime = startTime;
		return this;
	}
	public boolean isExpired() {
		return ((new Date()).getTime() - startTime)/1000 >= expiresIn;
	}
	
}
