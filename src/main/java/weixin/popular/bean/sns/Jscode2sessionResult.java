package weixin.popular.bean.sns;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

public class Jscode2sessionResult extends BaseResult {

	@JSONField(name = "openid")
	private String openId;

	@JSONField(name = "session_key")
	private String sessionKey;

	@JSONField(name = "expires_in")
	private Integer expiresIn;

	@JSONField(name = "unionid")
	private String unionId; // 2.8.16

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openid) {
		this.openId = openid;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionid) {
		this.unionId = unionid;
	}

}
