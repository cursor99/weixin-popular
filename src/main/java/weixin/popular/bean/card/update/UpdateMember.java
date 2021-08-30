package weixin.popular.bean.card.update;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 会员信息更新
 * 
 * @author zhongmin
 *
 */
public class UpdateMember extends AbstractUpdate {

	@JSONField(name = "code")
	private String code;
	
	@JSONField(name = "background_pic_url")
	private String backgroundPicUrl;
	
	@JSONField(name = "record_bonus")
	private String recordBonus;
	
	@JSONField(name = "bonus")
	private Integer bonus;
	
	@JSONField(name = "add_bonus")
	private Integer addBonus;
	
	@JSONField(name = "balance")
	private Integer balance;
	
	@JSONField(name = "add_balance")
	private Integer addBalance;
	
	@JSONField(name = "record_balance")
	private String recordBalance;
	
	@JSONField(name = "custom_field_value1")
	private String customFieldValue1;
	
	@JSONField(name = "custom_field_value2")
	private String customFieldValue2;
	
	@JSONField(name = "notify_optional")
	private Map<String,Object> notifyOptional = new HashMap<String,Object>();

	public String getCode() {
		return code;
	}

	public UpdateMember setCode(String code) {
		this.code = code;
		return this;
	}

	public String getBackgroundPicUrl() {
		return backgroundPicUrl;
	}

	public UpdateMember setBackgroundPicUrl(String backgroundPicUrl) {
		this.backgroundPicUrl = backgroundPicUrl;
		return this;
	}

	public String getRecordBonus() {
		return recordBonus;
	}

	public UpdateMember setRecordBonus(String recordBonus) {
		this.recordBonus = recordBonus;
		return this;
	}

	public Integer getBonus() {
		return bonus;
	}

	public UpdateMember setBonus(Integer bonus) {
		this.bonus = bonus;
		return this;
	}

	public Integer getAddBonus() {
		return addBonus;
	}

	public UpdateMember setAddBonus(Integer addBonus) {
		this.addBonus = addBonus;
		return this;
	}

	public Integer getBalance() {
		return balance;
	}

	public UpdateMember setBalance(Integer balance) {
		this.balance = balance;
		return this;
	}

	public Integer getAddBalance() {
		return addBalance;
	}

	public UpdateMember setAddBalance(Integer addBalance) {
		this.addBalance = addBalance;
		return this;
	}

	public String getRecordBalance() {
		return recordBalance;
	}

	public UpdateMember setRecordBalance(String recordBalance) {
		this.recordBalance = recordBalance;
		return this;
	}

	public String getCustomFieldValue1() {
		return customFieldValue1;
	}

	public UpdateMember setCustomFieldValue1(String customFieldValue1) {
		this.customFieldValue1 = customFieldValue1;
		return this;
	}

	public String getCustomFieldValue2() {
		return customFieldValue2;
	}

	public UpdateMember setCustomFieldValue2(String customFieldValue2) {
		this.customFieldValue2 = customFieldValue2;
		return this;
	}

	public Map<String, Object> getNotifyOptional() {
		return notifyOptional;
	}

	public UpdateMember setNotifyOptional(Map<String, Object> notifyOptional) {
		this.notifyOptional = notifyOptional;
		return this;
	}

	public UpdateMember setIsNotifyBonus(boolean isNotifyBonus) {
		this.notifyOptional.put("is_notify_bonus", isNotifyBonus);
		return this;
	}

	public UpdateMember setIsNotifyBalance(boolean isNotifyBalance) {
		this.notifyOptional.put("is_notify_balance", isNotifyBalance);
		return this;
	}
	
	
}
