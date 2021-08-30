package weixin.popular.bean.live;

public class LivePageInfo {

	private Integer offset;
	private Integer limit;
	private Integer status;
	
	public LivePageInfo(Integer offset, Integer limit, Integer status) {
		this.offset = offset;
		this.limit = limit;
		this.status = status;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
