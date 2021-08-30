package weixin.popular.bean.card.paygift;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class RuleBaseInfo {
	
	@JSONField(name = "mchid_list")
	private List<String> mchidList;
	
	@JSONField(name = "begin_time")
	private long beginTime;
	
	@JSONField(name = "end_time")
	private long endTime;

	public List<String> getMchidList() {
		return mchidList;
	}

	public void setMchidList(List<String> mchidList) {
		this.mchidList = mchidList;
	}

	public long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	
	
	
}
