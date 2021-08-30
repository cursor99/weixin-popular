package weixin.popular.bean.card.paygift;

import com.alibaba.fastjson.annotation.JSONField;

public class MemberRule {
	
	@JSONField(name = "card_id")
	private String cardId;
	
	@JSONField(name = "least_cost")
	private Integer leastCost;
	
	@JSONField(name = "max_cost")
	private Integer maxCost;
	
	@JSONField(name = "jump_url")
	private String jumpUrl;

	/*
	 * 商户自定义领卡小程序appid
	 */
	@JSONField(name = "app_brand_id")
	private String appBrandId;
	
	/*
	 * 商户自定义领卡小程序路径
	 */
	@JSONField(name = "app_brand_pass")
	private String appBrandPass;
	
	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public Integer getLeastCost() {
		return leastCost;
	}

	public void setLeastCost(Integer leastCost) {
		this.leastCost = leastCost;
	}

	public Integer getMaxCost() {
		return maxCost;
	}

	public void setMaxCost(Integer maxCost) {
		this.maxCost = maxCost;
	}

	public String getJumpUrl() {
		return jumpUrl;
	}

	public void setJumpUrl(String jumpUrl) {
		this.jumpUrl = jumpUrl;
	}
	
	
	
}
