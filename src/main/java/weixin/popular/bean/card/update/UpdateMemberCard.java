package weixin.popular.bean.card.update;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.card.Member;

/**
 * 会员卡更新参数
 * 
 * @author zhongmin
 *
 */
public class UpdateMemberCard extends AbstractUpdate {

	@JSONField(name = "member_card")
	private Member memberCard;

	public Member getMemberCard() {
		return memberCard;
	}

	public void setMemberCard(Member memberCard) {
		this.memberCard = memberCard;
	}
	
}
