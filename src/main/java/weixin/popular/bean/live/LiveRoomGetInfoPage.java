package weixin.popular.bean.live;

public class LiveRoomGetInfoPage {

	private Integer start;		//0-表示从第一个开始拉
	private Integer limit;		//建议100以内
	
	public LiveRoomGetInfoPage(Integer start, Integer limit) {
		this.start = start;
		this.limit = limit;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
