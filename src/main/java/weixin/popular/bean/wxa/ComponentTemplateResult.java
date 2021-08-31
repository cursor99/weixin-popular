package weixin.popular.bean.wxa;

import java.util.List;

import weixin.popular.bean.BaseResult;

public class ComponentTemplateResult extends BaseResult {

	private List<ComponentTemplateInfo> template_list;

	public List<ComponentTemplateInfo> getTemplate_list() {
		return template_list;
	}

	public void setTemplate_list(List<ComponentTemplateInfo> template_list) {
		this.template_list = template_list;
	}
	
	public static class ComponentTemplateInfo{
		
		private Integer create_time;
		private String user_version;
		private String user_desc;
		private String template_id;
		private String source_miniprogram_appid;
		private String source_miniprogram;
		private String developer;
		
		public Integer getCreate_time() {
			return create_time;
		}
		public void setCreate_time(Integer create_time) {
			this.create_time = create_time;
		}
		public String getUser_version() {
			return user_version;
		}
		public void setUser_version(String user_version) {
			this.user_version = user_version;
		}
		public String getUser_desc() {
			return user_desc;
		}
		public void setUser_desc(String user_desc) {
			this.user_desc = user_desc;
		}
		public String getTemplate_id() {
			return template_id;
		}
		public void setTemplate_id(String template_id) {
			this.template_id = template_id;
		}
		public String getSource_miniprogram_appid() {
			return source_miniprogram_appid;
		}
		public void setSource_miniprogram_appid(String source_miniprogram_appid) {
			this.source_miniprogram_appid = source_miniprogram_appid;
		}
		public String getSource_miniprogram() {
			return source_miniprogram;
		}
		public void setSource_miniprogram(String source_miniprogram) {
			this.source_miniprogram = source_miniprogram;
		}
		public String getDeveloper() {
			return developer;
		}
		public void setDeveloper(String developer) {
			this.developer = developer;
		}		
	}
}
