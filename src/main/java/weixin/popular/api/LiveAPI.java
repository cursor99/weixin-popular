package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.live.LiveAuditResult;
import weixin.popular.bean.live.LiveGetApprovedGoodResult;
import weixin.popular.bean.live.LiveGetGoodsWarehouseResult;
import weixin.popular.bean.live.LiveGoodUpdateInfo;
import weixin.popular.bean.live.LiveGoodsAddInfo;
import weixin.popular.bean.live.LiveGoodsAddResult;
import weixin.popular.bean.live.LiveGoodsIdArrayInfo;
import weixin.popular.bean.live.LiveGoodsInfo;
import weixin.popular.bean.live.LiveGoodsResetauditInfo;
import weixin.popular.bean.live.LivePageInfo;
import weixin.popular.bean.live.LiveRoomCreateInfo;
import weixin.popular.bean.live.LiveRoomCreateResult;
import weixin.popular.bean.live.LiveRoomGetInfoPage;
import weixin.popular.bean.live.LiveRoomListInfo;
import weixin.popular.bean.live.RoomAddGoodsInfo;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

public class LiveAPI extends BaseAPI{

	/*
	 * 小程序直播间创建接口 
	 * add by wrs 20200731
	 * */
	public static LiveRoomCreateResult room_create(String access_token, LiveRoomCreateInfo params) throws Exception{
		String str = JsonUtil.toJSONString(params);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxaapi/broadcast/room/create")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(str,Charset.forName("utf-8")))
				.build();
		
		return LocalHttpClient.executeJsonResult(httpUriRequest,LiveRoomCreateResult.class);
	}
	
	
	/*
	 * 删除直播间
	 * 
	 * */
	public static BaseResult room_delete(Integer room_id, String access_token) throws Exception{
		String paramJson = "{\"id\":"+room_id+"}";
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxaapi/broadcast/room/deleteroom")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(paramJson,Charset.forName("utf-8")))
				.build();
		
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	
	/*
	 * 
	 * 获取直播房间列表
	 * */
	
	public static LiveRoomListInfo getliveinfo(String access_token, LiveRoomGetInfoPage params) throws Exception{
		
		String str = JsonUtil.toJSONString(params);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/business/getliveinfo")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(str,Charset.forName("utf-8")))
				.build();
		
		return LocalHttpClient.executeJsonResult(httpUriRequest,LiveRoomListInfo.class);
	}
	
	/*
	 * 往指定直播间导入已入库的商品
	 * 
	 * */
	public static BaseResult room_add_goods(String access_token, RoomAddGoodsInfo params) throws Exception{
		String str = JsonUtil.toJSONString(params);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxaapi/broadcast/room/addgoods")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(str,Charset.forName("utf-8")))
				.build();
		
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	
	/*
	 * 
	 * 添加商品到直播商品库并审核
	 * 
	 * **/
	public static LiveGoodsAddResult add_goods(String access_token, LiveGoodsAddInfo params) throws Exception{
		String str = JsonUtil.toJSONString(params);
		String paramJson = "{\"goodsInfo\":"+str+"}";
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxaapi/broadcast/goods/add")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(paramJson,Charset.forName("utf-8")))
				.build();
		
		return LocalHttpClient.executeJsonResult(httpUriRequest,LiveGoodsAddResult.class);
	}
	
	/*
	 * 撤回直播商品的提审申请
	 * goods/resetaudit
	 * */
	public static BaseResult goods_resetaudit(String access_token, LiveGoodsResetauditInfo params) throws Exception{
		
		String str = JsonUtil.toJSONString(params);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxaapi/broadcast/goods/resetaudit")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(str,Charset.forName("utf-8")))
				.build();
		
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/*
	 * 对已撤回提审的商品再次发起提审申请
	 * 
	 * 
	 * */
	public static LiveAuditResult audit(String access_token, LiveGoodsInfo params) throws Exception{
		
		String str = JsonUtil.toJSONString(params);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxaapi/broadcast/goods/audit")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(str,Charset.forName("utf-8")))
				.build();
		
		return LocalHttpClient.executeJsonResult(httpUriRequest,LiveAuditResult.class);
	}
	
	/*
	 * 
	 * 删除【小程序直播】商品库中的商品，删除后直播间上架的该商品也将被同步删除，不可恢复；
	 * */
	public static BaseResult goods_delete(String access_token, LiveGoodsInfo params) throws Exception{
		
		String str = JsonUtil.toJSONString(params);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxaapi/broadcast/goods/delete")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(str,Charset.forName("utf-8")))
				.build();
		
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/*
	 * 
	 * 更新商品
	 * 调用此接口可以更新商品信息，审核通过的商品仅允许更新价格类型与价格，
	 * 审核中的商品不允许更新，未审核的商品允许更新所有字段， 只传入需要更新的字段。
	 * 
	 * */
	public static BaseResult goods_update(String access_token, LiveGoodUpdateInfo params) throws Exception{
		
		String str = JsonUtil.toJSONString(params);
		String paramJson = "{\"goodsInfo\":"+str+"}";
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxaapi/broadcast/goods/update")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(paramJson,Charset.forName("utf-8")))
				.build();
		
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/*
	 * 
	 * 获取商品的信息与审核状态
	 * */
	public static LiveGetGoodsWarehouseResult get_goods_warehouse(String access_token, LiveGoodsIdArrayInfo params) throws Exception{
		
		String str = JsonUtil.toJSONString(params);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/business/getgoodswarehouse")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(str,Charset.forName("utf-8")))
				.build();
		
		return LocalHttpClient.executeJsonResult(httpUriRequest,LiveGetGoodsWarehouseResult.class);
	}	
	
	/*
	 * 
	 * 获取商品列表
	 * */
	public static LiveGetApprovedGoodResult get_approved_goods(String access_token, LivePageInfo pageInfo) throws Exception{
		
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxaapi/broadcast/goods/getapproved")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.addParameter("offset", String.valueOf(pageInfo.getOffset()))
				.addParameter("limit", String.valueOf(pageInfo.getLimit()))
				.addParameter("status", String.valueOf(pageInfo.getStatus()))
				.build();
		
		return LocalHttpClient.executeJsonResult(httpUriRequest,LiveGetApprovedGoodResult.class);
	}		
	
	
}
