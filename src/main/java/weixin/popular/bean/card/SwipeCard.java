package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

public class SwipeCard {
	
	/*
	 * 是否设置该会员卡支持拉出微信支付刷卡界面
	 */
	@JSONField(name = "is_swipe_card")
	private boolean isSwipeCard;

	public boolean isSwipeCard() {
		return isSwipeCard;
	}

	public void setSwipeCard(boolean isSwipeCard) {
		this.isSwipeCard = isSwipeCard;
	}
	
}
