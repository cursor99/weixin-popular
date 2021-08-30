package weixin.popular.bean.card.paygift;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

public class PayGiftResult extends BaseResult {
	
	@JSONField(name = "rule_id")
	private Integer rule_id;
	
	
	@JSONField(name = "fail_mchid_list")
	private List<FailMerchant> failMchidList;
	
	@JSONField(name = "succ_mchid_list")
	private List<String> succMchidList;

	public Integer getRule_id() {
		return rule_id;
	}

	public void setRule_id(Integer rule_id) {
		this.rule_id = rule_id;
	}

	public List<FailMerchant> getFailMchidList() {
		return failMchidList;
	}

	public void setFailMchidList(List<FailMerchant> failMchidList) {
		this.failMchidList = failMchidList;
	}

	public List<String> getSuccMchidList() {
		return succMchidList;
	}

	public void setSuccMchidList(List<String> succMchidList) {
		this.succMchidList = succMchidList;
	}
	
}
