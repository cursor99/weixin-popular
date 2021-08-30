package weixin.popular.bean.user;

import weixin.popular.bean.crypt.WaterMark;

public class MinaUser {
	private String openId;
	private String unionId;
	private String nickName;
	private String avatarUrl;
	private Integer gender;
	private String country;
	private String province;
	private String city;
	private String language;
	private WaterMark waterMark;
	public String getOpenId() {
		return openId;
	}
	public MinaUser setOpenId(String openId) {
		this.openId = openId;
		return this;
	}
	public String getUnionId() {
		return unionId;
	}
	public MinaUser setUnionId(String unionId) {
		this.unionId = unionId;
		return this;
	}
	public String getNickName() {
		return nickName;
	}
	public MinaUser setNickName(String nickName) {
		this.nickName = nickName;
		return this;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public MinaUser setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
		return this;
	}
	public Integer getGender() {
		return gender;
	}
	public MinaUser setGender(Integer gender) {
		this.gender = gender;
		return this;
	}
	public String getCountry() {
		return country;
	}
	public MinaUser setCountry(String country) {
		this.country = country;
		return this;
	}
	public String getProvince() {
		return province;
	}
	public MinaUser setProvince(String province) {
		this.province = province;
		return this;
	}
	public String getCity() {
		return city;
	}
	public MinaUser setCity(String city) {
		this.city = city;
		return this;
	}
	public String getLanguage() {
		return language;
	}
	public MinaUser setLanguage(String language) {
		this.language = language;
		return this;
	}
	public WaterMark getWaterMark() {
		return waterMark;
	}
	public MinaUser setWaterMark(WaterMark waterMark) {
		this.waterMark = waterMark;
		return this;
	}
	
	
}
