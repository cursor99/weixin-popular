package weixin.popular.bean.live;

public class LiveRoomCreateInfo {

	private String name;
	private String coverImg;
	private Long startTime;
	private Long endTime;
	private String anchorName;
	private String anchorWechat;
	private String shareImg;
	private String feedsImg;
	private String createrWechat;
	private Integer isFeedsPublic;
	private Integer type;
	private Integer screenType;
	private Integer closeLike;
	private Integer closeGoods;
	private Integer closeComment;
	private Integer closeReplay;
	private Integer closeShare;
	private Integer closeKf;
	
	public String getCreaterWechat() {
		return createrWechat;
	}
	public void setCreaterWechat(String createrWechat) {
		this.createrWechat = createrWechat;
	}
	public String getAnchorWechat() {
		return anchorWechat;
	}
	public LiveRoomCreateInfo setAnchorWechat(String anchorWechat) {
		this.anchorWechat = anchorWechat;
		return this;
	}
	public String getName() {
		return name;
	}
	public LiveRoomCreateInfo setName(String name) {
		this.name = name;
		return this;
	}
	public String getCoverImg() {
		return coverImg;
	}
	public LiveRoomCreateInfo setCoverImg(String coverImg) {
		this.coverImg = coverImg;
		return this;
	}
	public Long getStartTime() {
		return startTime;
	}
	public LiveRoomCreateInfo setStartTime(Long startTime) {
		this.startTime = startTime;
		return this;
	}
	public Long getEndTime() {
		return endTime;
	}
	public LiveRoomCreateInfo setEndTime(Long endTime) {
		this.endTime = endTime;
		return this;
	}
	public String getAnchorName() {
		return anchorName;
	}
	public LiveRoomCreateInfo setAnchorName(String anchorName) {
		this.anchorName = anchorName;
		return this;
	}
	public String getShareImg() {
		return shareImg;
	}
	public LiveRoomCreateInfo setShareImg(String shareImg) {
		this.shareImg = shareImg;
		return this;
	}
	public Integer getType() {
		return type;
	}
	public LiveRoomCreateInfo setType(Integer type) {
		this.type = type;
		return this;
	}
	public Integer getScreenType() {
		return screenType;
	}
	public LiveRoomCreateInfo setScreenType(Integer screenType) {
		this.screenType = screenType;
		return this;
	}
	public Integer getCloseLike() {
		return closeLike;
	}
	public LiveRoomCreateInfo setCloseLike(Integer closeLike) {
		this.closeLike = closeLike;
		return this;
	}
	public Integer getCloseGoods() {
		return closeGoods;
	}
	public LiveRoomCreateInfo setCloseGoods(Integer closeGoods) {
		this.closeGoods = closeGoods;
		return this;
	}
	public Integer getCloseComment() {
		return closeComment;
	}
	public LiveRoomCreateInfo setCloseComment(Integer closeComment) {
		this.closeComment = closeComment;
		return this;
	}
	public String getFeedsImg() {
		return feedsImg;
	}
	public LiveRoomCreateInfo setFeedsImg(String feedsImg) {
		this.feedsImg = feedsImg;
		return this;
	}
	public Integer getIsFeedsPublic() {
		return isFeedsPublic;
	}
	public void setIsFeedsPublic(Integer isFeedsPublic) {
		this.isFeedsPublic = isFeedsPublic;
	}
	public Integer getCloseReplay() {
		return closeReplay;
	}
	public void setCloseReplay(Integer closeReplay) {
		this.closeReplay = closeReplay;
	}
	public Integer getCloseShare() {
		return closeShare;
	}
	public void setCloseShare(Integer closeShare) {
		this.closeShare = closeShare;
	}
	public Integer getCloseKf() {
		return closeKf;
	}
	public void setCloseKf(Integer closeKf) {
		this.closeKf = closeKf;
	}
}
