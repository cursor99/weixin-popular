package weixin.popular.bean.live;

import java.util.List;

import weixin.popular.bean.BaseResult;

public class LiveGetGoodsWarehouseResult extends BaseResult{

	private Integer total;
	
	private List<LiveGoodsAllInfo> goods;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<LiveGoodsAllInfo> getGoods() {
		return goods;
	}

	public void setGoods(List<LiveGoodsAllInfo> goods) {
		this.goods = goods;
	}
}
