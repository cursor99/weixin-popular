package weixin.popular.bean.live;

import java.util.List;

import weixin.popular.bean.BaseResult;

public class LiveRoomListInfo extends BaseResult{

	private List<LiveRoomInfo> room_info;

	public List<LiveRoomInfo> getRoom_info() {
		return room_info;
	}

	public void setRoom_info(List<LiveRoomInfo> room_info) {
		this.room_info = room_info;
	}
}
