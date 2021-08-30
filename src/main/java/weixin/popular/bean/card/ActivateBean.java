package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

public class ActivateBean {
	
	@JSONField(name = "card_id")
	private String cardId;
	
	@JSONField(name = "membership_number")
	private String membershipNumber;
	
	private String code;
	
	@JSONField(name = "background_pic_url")
	private String backgroundPicUrl;
	
	@JSONField(name = "activate_begin_time")
	private Long activateBeginTime;
	
	@JSONField(name = "activate_end_time")
	private Long activateEndTime;
	
	@JSONField(name = "init_bonus")
	private Integer initBonus;
	
	@JSONField(name = "init_bonus_record")
	private String initBonusRecord;
	
	@JSONField(name = "init_balance")
	private Integer initBalance;
	
	@JSONField(name = "init_custom_field_value1")
	private String initCustomFieldValue1;
	
	@JSONField(name = "init_custom_field_value2")
	private String initCustomFieldValue2;
	
	@JSONField(name = "init_custom_field_value3")
	private String initCustomFieldValue3;

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getMembershipNumber() {
		return membershipNumber;
	}

	public void setMembershipNumber(String membershipNumber) {
		this.membershipNumber = membershipNumber;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBackgroundPicUrl() {
		return backgroundPicUrl;
	}

	public void setBackgroundPicUrl(String backgroundPicUrl) {
		this.backgroundPicUrl = backgroundPicUrl;
	}

	public Long getActivateBeginTime() {
		return activateBeginTime;
	}

	public void setActivateBeginTime(Long activateBeginTime) {
		this.activateBeginTime = activateBeginTime;
	}

	public Long getActivateEndTime() {
		return activateEndTime;
	}

	public void setActivateEndTime(Long activateEndTime) {
		this.activateEndTime = activateEndTime;
	}

	public Integer getInitBonus() {
		return initBonus;
	}

	public void setInitBonus(Integer initBonus) {
		this.initBonus = initBonus;
	}

	public String getInitBonusRecord() {
		return initBonusRecord;
	}

	public void setInitBonusRecord(String initBonusRecord) {
		this.initBonusRecord = initBonusRecord;
	}

	public Integer getInitBalance() {
		return initBalance;
	}

	public void setInitBalance(Integer initBalance) {
		this.initBalance = initBalance;
	}

	public String getInitCustomFieldValue1() {
		return initCustomFieldValue1;
	}

	public void setInitCustomFieldValue1(String initCustomFieldValue1) {
		this.initCustomFieldValue1 = initCustomFieldValue1;
	}

	public String getInitCustomFieldValue2() {
		return initCustomFieldValue2;
	}

	public void setInitCustomFieldValue2(String initCustomFieldValue2) {
		this.initCustomFieldValue2 = initCustomFieldValue2;
	}

	public String getInitCustomFieldValue3() {
		return initCustomFieldValue3;
	}

	public void setInitCustomFieldValue3(String initCustomFieldValue3) {
		this.initCustomFieldValue3 = initCustomFieldValue3;
	}
	
	
}
