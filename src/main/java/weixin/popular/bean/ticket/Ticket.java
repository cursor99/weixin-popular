package weixin.popular.bean.ticket;

import java.util.Date;

import weixin.popular.bean.BaseResult;

public class Ticket extends BaseResult{

	private String ticket;

	private Integer expires_in;

	private long startTime;
	
	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	
	public boolean isExpired() {
		return ((new Date()).getTime() - startTime)/1000 >= expires_in;
	}
	
}
