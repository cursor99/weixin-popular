package weixin.popular.bean.card.paygift;

import com.alibaba.fastjson.annotation.JSONField;

public class RuleInfo {
	private String type = "RULE_TYPE_PAY_MEMBER_CARD";
	
	@JSONField(name = "base_info")
	private RuleBaseInfo baseInfo;
	
	@JSONField(name = "member_rule")
	private MemberRule memberRule;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public RuleBaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(RuleBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public MemberRule getMemberRule() {
		return memberRule;
	}

	public void setMemberRule(MemberRule memberRule) {
		this.memberRule = memberRule;
	}
	
}
