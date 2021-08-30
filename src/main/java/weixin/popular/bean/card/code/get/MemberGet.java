package weixin.popular.bean.card.code.get;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 查询会员信息接口－请求参数
 * 
 * @author zhongmin
 *
 */
public class MemberGet {
	
	/**
	 * 卡券ID代表一类卡券。自定义code卡券必填。
	 */
	@JSONField(name = "card_id")
	private String cardId;
	
	/**
	 * 单张卡券的唯一标准。<br>
	 * 必填：是
	 */
	private String code;
	
	/**
	 * 卡券ID代表一类卡券。自定义code卡券必填。
	 * @return 卡券ID
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 卡券ID代表一类卡券。自定义code卡券必填。
	 * @param cardId 卡券ID
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return 单张卡券的唯一标准
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 单张卡券的唯一标准。<br>
	 * 必填：是
	 * @param code 单张卡券的唯一标准
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
