package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 会员卡
 * 
 * @author zhongmin
 *
 */
public class MemberCard extends AbstractCard {

	@JSONField(name = "member_card")
	private Member memberCard;

	public MemberCard() {
		super("MEMBER_CARD");
	}

	public Member getMemberCard() {
		return memberCard;
	}

	public void setMemberCard(Member memberCard) {
		this.memberCard = memberCard;
	}

	
}
