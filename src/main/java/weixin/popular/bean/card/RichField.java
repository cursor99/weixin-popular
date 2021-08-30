package weixin.popular.bean.card;

import java.util.ArrayList;
import java.util.List;

public class RichField {
	private String type;
	private String name;
	private List<String> values;
	public String getType() {
		return type;
	}
	public RichField setType(String type) {
		this.type = type;
		return this;
	}
	public String getName() {
		return name;
	}
	public RichField setName(String name) {
		this.name = name;
		return this;
	}
	public List<String> getValues() {
		return values;
	}
	
	public RichField setValues(List<String> values) {
		this.values = values;
		return this;
	}
	
	public RichField addValues(String...values){
		
		if(values == null || values.length == 0)
			return this;
		
		if(this.values == null)
			this.values = new ArrayList<String>();
		
		for(int i = 0;i < values.length;i++){
			this.values.add(values[i]);
		}
		
		return this;
		
	}
	
}
