package weixin.popular.bean.live;

import weixin.popular.bean.BaseResult;

public class GoodsAddResult extends BaseResult {

	private Integer goodsId;
	private Long auditId;
	
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Long getAuditId() {
		return auditId;
	}
	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}
}
