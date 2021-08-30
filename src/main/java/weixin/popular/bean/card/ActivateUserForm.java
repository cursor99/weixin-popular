package weixin.popular.bean.card;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class ActivateUserForm {
	
	@JSONField(name = "can_modify")
	private boolean canModify;
	
	@JSONField(name = "rich_field_list")
	private List<RichField> richFieldList;
	
	@JSONField(name = "common_field_id_list")
	private List<String> commonFieldIdList;
	
	@JSONField(name = "custom_field_list")
	private List<String> customFieldList;

	public boolean isCanModify() {
		return canModify;
	}

	public ActivateUserForm setCanModify(boolean canModify) {
		this.canModify = canModify;
		return this;
	}

	public List<RichField> getRichFieldList() {
		return richFieldList;
	}

	public ActivateUserForm setRichFieldList(List<RichField> richFieldList) {
		this.richFieldList = richFieldList;
		return this;
	}

	public ActivateUserForm addRichField(RichField richField){
		
		if(this.richFieldList == null)
			this.richFieldList = new ArrayList<RichField>();
		
		this.richFieldList.add(richField);
		
		return this;
		
	}
	
	public List<String> getCommonFieldIdList() {
		return commonFieldIdList;
	}

	public ActivateUserForm setCommonFieldIdList(List<String> commonFieldIdList) {
		this.commonFieldIdList = commonFieldIdList;
		return this;
	}

	public ActivateUserForm addCommonField(String field){
		
		if(this.commonFieldIdList == null)
			this.commonFieldIdList = new ArrayList<String>();
		
		this.commonFieldIdList.add(field);
		
		return this;
	}
	
	public List<String> getCustomFieldList() {
		return customFieldList;
	}

	public ActivateUserForm setCustomFieldList(List<String> customFieldList) {
		this.customFieldList = customFieldList;
		return this;
	}
	
	public ActivateUserForm addCustomerField(String field){
		
		if(this.customFieldList == null)
			this.customFieldList = new ArrayList<String>();
		
		this.customFieldList.add(field);
		
		return this;
		
	}
		
}
