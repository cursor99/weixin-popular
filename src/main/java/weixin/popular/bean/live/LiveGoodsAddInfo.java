package weixin.popular.bean.live;

public class LiveGoodsAddInfo {

	private String coverImgUrl;
	private String name;
	private Integer priceType;
	private Double price;
	private Double price2;
	private String url;
	
	public String getCoverImgUrl() {
		return coverImgUrl;
	}
	public LiveGoodsAddInfo setCoverImgUrl(String coverImgUrl) {
		this.coverImgUrl = coverImgUrl;
		return this;
	}
	public String getName() {
		return name;
	}
	public LiveGoodsAddInfo setName(String name) {
		this.name = name;
		return this;
	}
	public Integer getPriceType() {
		return priceType;
	}
	public LiveGoodsAddInfo setPriceType(Integer priceType) {
		this.priceType = priceType;
		return this;
	}
	public Double getPrice() {
		return price;
	}
	public LiveGoodsAddInfo setPrice(Double price) {
		this.price = price;
		return this;
	}
	public Double getPrice2() {
		return price2;
	}
	public LiveGoodsAddInfo setPrice2(Double price2) {
		this.price2 = price2;
		return this;
	}
	public String getUrl() {
		return url;
	}
	public LiveGoodsAddInfo setUrl(String url) {
		this.url = url;
		return this;
	}
}
