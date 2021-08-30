package weixin.popular.bean.card.code.get;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

/**
 * 查询会员信息接口－响应参数
 * 
 * @author zhongmin
 *
 */
public class MemberGetResult extends BaseResult {
	
	/**
	 * 用户openid
	 */
	private String openid;
	
	private String nickname;
	
	private String code;
	
	private String cardId;
	/*
	 * 线下会员号
	 */
	@JSONField(name = "membership_number")
	private String membershipNumber;
	
	/**
	 * 当前code对应卡券的状态: <br>
	 * NORMAL 正常 <br>
	 * CONSUMED 已核销 <br>
	 * EXPIRE 已过期 <br>
	 * GIFTING 转赠中<br>
	 * GIFT_TIMEOUT 转赠超时<br>
	 * DELETE 已删除<br>
	 * UNAVAILABLE 已失效 <br>
	 * code未被添加或被转赠领取的情况则统一报错：invalid serial code
	 */
	@JSONField(name = "user_card_status")
	private String userCardStatus;
	
	/*
	 * 积分
	 */
	private Double bonus;
	
	/*
	 * 性别
	 */
	private String sex;
	
	/*
	 * 用户自定义信息
	 */
	@JSONField(name = "user_info")
	private UserCustomInfo userInfo;

	/**
	 * @return 用户openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid 用户openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}


	/**
	 * 当前code对应卡券的状态: <br>
	 * NORMAL 正常 <br>
	 * CONSUMED 已核销 <br>
	 * EXPIRE 已过期 <br>
	 * GIFTING 转赠中<br>
	 * GIFT_TIMEOUT 转赠超时<br>
	 * DELETE 已删除<br>
	 * UNAVAILABLE 已失效 <br>
	 * code未被添加或被转赠领取的情况则统一报错：invalid serial code
	 * @return 卡券的状态
	 */
	public String getUserCardStatus() {
		return userCardStatus;
	}

	/**
	 * 当前code对应卡券的状态: <br>
	 * NORMAL 正常 <br>
	 * CONSUMED 已核销 <br>
	 * EXPIRE 已过期 <br>
	 * GIFTING 转赠中<br>
	 * GIFT_TIMEOUT 转赠超时<br>
	 * DELETE 已删除<br>
	 * UNAVAILABLE 已失效 <br>
	 * code未被添加或被转赠领取的情况则统一报错：invalid serial code
	 * @param userCardStatus 卡券的状态
	 */
	public void setUserCardStatus(String userCardStatus) {
		this.userCardStatus = userCardStatus;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public UserCustomInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserCustomInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
}
