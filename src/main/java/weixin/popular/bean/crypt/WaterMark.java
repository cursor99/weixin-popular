package weixin.popular.bean.crypt;

import com.alibaba.fastjson.annotation.JSONField;

public class WaterMark {
	@JSONField(name = "appid")
	private String appId;
	@JSONField(name = "timestamp")
	private String timeStamp;
	
	public String getAppId() {
		return appId;
	}
	public WaterMark setAppId(String appId) {
		this.appId = appId;
		return this;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public WaterMark setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
		return this;
	}
	
	
	
}
