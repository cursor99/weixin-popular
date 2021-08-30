package weixin.popular.bean.card.paygift;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

public class FailMerchant extends BaseResult {
	private String mchid;
	
	@JSONField(name = "occupy_rule_id")
	private Integer occupyRuleId;
	
	@JSONField(name = "occupy_appid")
	private String occupyAppid;

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public Integer getOccupyRuleId() {
		return occupyRuleId;
	}

	public void setOccupyRuleId(Integer occupyRuleId) {
		this.occupyRuleId = occupyRuleId;
	}

	public String getOccupyAppid() {
		return occupyAppid;
	}

	public void setOccupyAppid(String occupyAppid) {
		this.occupyAppid = occupyAppid;
	}
	
	
}
