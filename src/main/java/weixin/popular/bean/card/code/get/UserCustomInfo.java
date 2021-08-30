package weixin.popular.bean.card.code.get;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class UserCustomInfo {
	
	@JSONField(name = "common_field_list")
	private List<Field> commonFieldList;
	@JSONField(name = "custom_field_list")
	private List<Field> customFieldFist;
	
	public List<Field> getCommonFieldList() {
		return commonFieldList;
	}
	public List<Field> getCustomFieldFist() {
		return customFieldFist;
	}
		
}
