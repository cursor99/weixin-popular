package weixin.popular.bean.live;

public class LiveGoodsAllInfo {
	
	private Integer goods_id;
	private String name;
	private String cover_img_url;
	private String url;
	private Integer priceType;
	private Double price;
	private Double price2;
	private Integer audit_status;
	private Integer third_party_tag;
	
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCover_img_url() {
		return cover_img_url;
	}
	public void setCover_img_url(String cover_img_url) {
		this.cover_img_url = cover_img_url;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getPriceType() {
		return priceType;
	}
	public void setPriceType(Integer priceType) {
		this.priceType = priceType;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPrice2() {
		return price2;
	}
	public void setPrice2(Double price2) {
		this.price2 = price2;
	}
	public Integer getAudit_status() {
		return audit_status;
	}
	public void setAudit_status(Integer audit_status) {
		this.audit_status = audit_status;
	}
	public Integer getThird_party_tag() {
		return third_party_tag;
	}
	public void setThird_party_tag(Integer third_party_tag) {
		this.third_party_tag = third_party_tag;
	}
}
