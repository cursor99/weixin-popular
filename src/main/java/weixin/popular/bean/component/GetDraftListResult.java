package weixin.popular.bean.component;

import java.util.List;

import weixin.popular.bean.BaseResult;

public class GetDraftListResult extends BaseResult {
	
	private List<DraftInfo> draft_list;
	
	public List<DraftInfo> getDraft_list() {
		return draft_list;
	}

	public void setDraft_list(List<DraftInfo> draft_list) {
		this.draft_list = draft_list;
	}

	public static class DraftInfo{
		
		private Integer create_time;
		private String user_version;
		private String user_desc;
		private Integer draft_id;
		
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
		public Integer getDraft_id() {
			return draft_id;
		}
		public void setDraft_id(Integer draft_id) {
			this.draft_id = draft_id;
		}
	}
	
}
