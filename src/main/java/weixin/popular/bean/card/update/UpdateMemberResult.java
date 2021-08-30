/**
 * 
 */
package weixin.popular.bean.card.update;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

/**
 * 微信卡券－卡券管理－更改会员信息接口－响应参数
 * @author 钟敏
 * @date 2019年3月5日
 */
public class UpdateMemberResult extends BaseResult {
	
	@JSONField(name = "result_bonus")
	private Integer  resultBonus;
	
	@JSONField(name = "result_balance")
	private Integer  resultBalance;
	
	@JSONField(name = "openid")
	private String  openId;

	public Integer getResultBonus() {
		return resultBonus;
	}

	public UpdateMemberResult setResultBonus(Integer resultBonus) {
		this.resultBonus = resultBonus;
		return this;
	}

	public Integer getResultBalance() {
		return resultBalance;
	}

	public UpdateMemberResult setResultBalance(Integer resultBalance) {
		this.resultBalance = resultBalance;
		return this;
	}

	public String getOpenId() {
		return openId;
	}

	public UpdateMemberResult setOpenId(String openId) {
		this.openId = openId;
		return this;
	}
	
	
	
}
