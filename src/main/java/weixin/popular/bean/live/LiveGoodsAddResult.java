package weixin.popular.bean.live;

import weixin.popular.bean.BaseResult;

public class LiveGoodsAddResult extends BaseResult {

	private Integer goodsId;
	private Integer auditId;
	
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getAuditId() {
		return auditId;
	}
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}
}
