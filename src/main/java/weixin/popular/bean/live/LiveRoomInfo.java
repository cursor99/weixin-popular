package weixin.popular.bean.live;

import java.util.List;
import java.util.Map;

public class LiveRoomInfo {
	
	private String name;
	private Integer roomid;
	private String cover_img;
	private String share_img;
	private String feeds_img;
	private Integer live_status;
	private Long start_time;
	private Long end_time;
	private String anchor_name;
	private List<Map<String,Object>> goods;
	private Integer total;
	
	public String getFeeds_img() {
		return feeds_img;
	}
	public void setFeeds_img(String feeds_img) {
		this.feeds_img = feeds_img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRoomid() {
		return roomid;
	}
	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}
	public String getCover_img() {
		return cover_img;
	}
	public void setCover_img(String cover_img) {
		this.cover_img = cover_img;
	}
	public String getShare_img() {
		return share_img;
	}
	public void setShare_img(String share_img) {
		this.share_img = share_img;
	}
	public Integer getLive_status() {
		return live_status;
	}
	public void setLive_status(Integer live_status) {
		this.live_status = live_status;
	}
	public Long getStart_time() {
		return start_time;
	}
	public void setStart_time(Long start_time) {
		this.start_time = start_time;
	}
	public Long getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Long end_time) {
		this.end_time = end_time;
	}
	public String getAnchor_name() {
		return anchor_name;
	}
	public void setAnchor_name(String anchor_name) {
		this.anchor_name = anchor_name;
	}
	public List<Map<String, Object>> getGoods() {
		return goods;
	}
	public void setGoods(List<Map<String, Object>> goods) {
		this.goods = goods;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
}
