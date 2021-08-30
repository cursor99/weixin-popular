package weixin.popular.bean.live;

import java.util.List;

import weixin.popular.bean.BaseResult;

public class LiveGetApprovedGoodResult extends BaseResult {

	private Integer total;
	private List<LiveGoodsAllInfo2> goods;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<LiveGoodsAllInfo2> getGoods() {
		return goods;
	}
	public void setGoods(List<LiveGoodsAllInfo2> goods) {
		this.goods = goods;
	}
}
