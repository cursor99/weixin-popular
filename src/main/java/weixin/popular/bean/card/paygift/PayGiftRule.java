package weixin.popular.bean.card.paygift;

import com.alibaba.fastjson.annotation.JSONField;

public class PayGiftRule {
	
	@JSONField(name = "rule_info")
	private RuleInfo ruleInfo;

	public RuleInfo getRuleInfo() {
		return ruleInfo;
	}

	public void setRuleInfo(RuleInfo ruleInfo) {
		this.ruleInfo = ruleInfo;
	}
	
}
