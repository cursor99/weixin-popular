package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

public class CustomField {
	
	@JSONField(name = "name_type")
	private String nameType;
	
	private String name;
	
	private String url;

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
