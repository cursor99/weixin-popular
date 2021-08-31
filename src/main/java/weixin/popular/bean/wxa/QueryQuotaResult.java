package weixin.popular.bean.wxa;

import weixin.popular.bean.BaseResult;

public class QueryQuotaResult extends BaseResult {
	
	private Integer rest ;
	private Integer limit ;
	private Integer speedup_rest;
	private Integer speedup_limit;
	
	public Integer getRest() {
		return rest;
	}
	public void setRest(Integer rest) {
		this.rest = rest;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getSpeedup_rest() {
		return speedup_rest;
	}
	public void setSpeedup_rest(Integer speedup_rest) {
		this.speedup_rest = speedup_rest;
	}
	public Integer getSpeedup_limit() {
		return speedup_limit;
	}
	public void setSpeedup_limit(Integer speedup_limit) {
		this.speedup_limit = speedup_limit;
	}
	
	
}
