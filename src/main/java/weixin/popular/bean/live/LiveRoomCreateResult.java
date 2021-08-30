package weixin.popular.bean.live;

import weixin.popular.bean.BaseResult;

public class LiveRoomCreateResult extends BaseResult{
	
	private Integer roomId ;
	private String qrcode_url;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getQrcode_url() {
		return qrcode_url;
	}

	public void setQrcode_url(String qrcode_url) {
		this.qrcode_url = qrcode_url;
	}
}
