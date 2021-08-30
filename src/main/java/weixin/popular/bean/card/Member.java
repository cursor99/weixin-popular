package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 折扣券
 * 
 * @author Moyq5
 *
 */
public class Member extends AbstractInfo {

	/*
	 * 卡面图片url
	 */
	@JSONField(name = "background_pic_url")
	private String backgroundPicUrl;
	
	/*
	 * 会员卡特权说明,限制1024汉字。
	 */
	private String prerogative;
	
	//设置为true时用户领取会员卡后系统自动将其激活，无需调用激活接口，详情见 自动激活 。
	@JSONField(name = "auto_activate")
	private boolean autoActivate;
	
	/*
	 * 设置为true时会员卡支持一键开卡，不允许同时传入activate_url字段，否则设置wx_activate失效。
	 * 填入该字段后仍需调用接口设置开卡项方可生效，详情见 一键开卡 。
	 */
	@JSONField(name = "wx_activate")
	private boolean wxActivate;
	
	/*
	 * 显示积分，填写true或false，如填写true，积分相关字段均为必 填 若设置为true则后续不可以被关闭。
	 */
	@JSONField(name = "supply_bonus")
	private boolean supplyBonus;
	
	/*
	 * 设置跳转外链查看积分详情。仅适用于积分无法通过激活接口同步的情况下使用该字段。
	 */
	@JSONField(name = "bonus_url")
	private String bonusUrl;
	
	/*
	 * 是否支持储值，填写true或false。如填写true，储值相关字段均为必 填 若设置为true则后续不可以被关闭。
	 * 该字段须开通储值功能后方可使用， 详情见： 获取特殊权限
	 */
	@JSONField(name = "supply_balance")
	private boolean supplyBalance;
	
	/*
	 * 设置跳转外链查看余额详情。仅适用于余额无法通过激活接口同步的情况下使用该字段。
	 */
	@JSONField(name = "balance_url")
	private String balanceUrl;
	
	@JSONField(name = "custom_field1")
	private CustomField customField1;
	
	@JSONField(name = "custom_field2")
	private CustomField customField2;
	
	@JSONField(name = "custom_field3")
	private CustomField customField3;
	
	/*
	 * 	string（128）	积分规则。
	 */
	@JSONField(name = "bonus_rules")
	private String bonusRules;
	
	/*
	 * 储值说明。
	 */
	@JSONField(name = "balance_rules")
	private String balanceRules;
	
	/*
	 * 	string（128）	积分清零规则。
	 */
	@JSONField(name = "bonus_cleared")
	private String bonusCleared;
	
	
	/*
	 * 激活会员卡的url。
	 */
	@JSONField(name = "activate_url")
	private String activateUrl;
	
	/*
	 * 激活会原卡url对应的小程序user_name，仅可跳转该公众号绑定的小程序
	 */
	@JSONField(name = "activate_app_brand_user_name")
	private String activateAppBrandUserName;
	
	/*
	 * 激活会原卡url对应的小程序path
	 */
	@JSONField(name = "activate_app_brand_pass")
	private String activateAppBrandPass;
	
	
	/**
	 * 表示打折额度（百分比）。填30就是七折。<br>
	 * 添加必填，不支持修改 
	 */
	private Integer discount;

	
	/**
	 * 表示打折额度（百分比）。填30就是七折。
	 */
	public Integer getDiscount() {
		return discount;
	}

	/**
	 * 表示打折额度（百分比）。填30就是七折。<br>
	 * 添加必填，不支持修改 
	 */
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getBackgroundPicUrl() {
		return backgroundPicUrl;
	}

	public void setBackgroundPicUrl(String backgroundPicUrl) {
		this.backgroundPicUrl = backgroundPicUrl;
	}

	public String getPrerogative() {
		return prerogative;
	}

	public void setPrerogative(String prerogative) {
		this.prerogative = prerogative;
	}

	public boolean isAutoActivate() {
		return autoActivate;
	}

	public void setAutoActivate(boolean autoActivate) {
		this.autoActivate = autoActivate;
	}

	public boolean isWxActivate() {
		return wxActivate;
	}

	public void setWxActivate(boolean wxActivate) {
		this.wxActivate = wxActivate;
	}

	public boolean isSupplyBonus() {
		return supplyBonus;
	}

	public void setSupplyBonus(boolean supplyBonus) {
		this.supplyBonus = supplyBonus;
	}

	public String getBonusUrl() {
		return bonusUrl;
	}

	public void setBonusUrl(String bonusUrl) {
		this.bonusUrl = bonusUrl;
	}

	public boolean isSupplyBalance() {
		return supplyBalance;
	}

	public void setSupplyBalance(boolean supplyBalance) {
		this.supplyBalance = supplyBalance;
	}

	public String getBalanceUrl() {
		return balanceUrl;
	}

	public void setBalanceUrl(String balanceUrl) {
		this.balanceUrl = balanceUrl;
	}

	public CustomField getCustomField1() {
		return customField1;
	}

	public void setCustomField1(CustomField customField1) {
		this.customField1 = customField1;
	}

	public CustomField getCustomField2() {
		return customField2;
	}

	public void setCustomField2(CustomField customField2) {
		this.customField2 = customField2;
	}

	public CustomField getCustomField3() {
		return customField3;
	}

	public void setCustomField3(CustomField customField3) {
		this.customField3 = customField3;
	}

	public String getBonusRules() {
		return bonusRules;
	}

	public void setBonusRules(String bonusRules) {
		this.bonusRules = bonusRules;
	}

	public String getBalanceRules() {
		return balanceRules;
	}

	public void setBalanceRules(String balanceRules) {
		this.balanceRules = balanceRules;
	}

	public String getBonusCleared() {
		return bonusCleared;
	}

	public void setBonusCleared(String bonusCleared) {
		this.bonusCleared = bonusCleared;
	}

	public String getActivateUrl() {
		return activateUrl;
	}

	public void setActivateUrl(String activateUrl) {
		this.activateUrl = activateUrl;
	}

	public String getActivateAppBrandUserName() {
		return activateAppBrandUserName;
	}

	public void setActivateAppBrandUserName(String activateAppBrandUserName) {
		this.activateAppBrandUserName = activateAppBrandUserName;
	}

	public String getActivateAppBrandPass() {
		return activateAppBrandPass;
	}

	public void setActivateAppBrandPass(String activateAppBrandPass) {
		this.activateAppBrandPass = activateAppBrandPass;
	}


}
