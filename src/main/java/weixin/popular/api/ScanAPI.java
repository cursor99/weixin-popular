package weixin.popular.api;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.scan.base.ProductGet;
import weixin.popular.bean.scan.crud.ProductCreate;
import weixin.popular.bean.scan.crud.ProductGetlist;
import weixin.popular.bean.scan.crud.ProductGetqrcode;
import weixin.popular.bean.scan.crud.ProductStatus;
import weixin.popular.bean.scan.crud.ProductUpdate;
import weixin.popular.bean.scan.crud.TicketCheck;
import weixin.popular.bean.scan.crud.WhiteUsers;
import weixin.popular.bean.scan.result.MerchantinfoGetResult;
import weixin.popular.bean.scan.result.ProductCreateResult;
import weixin.popular.bean.scan.result.ProductGetResult;
import weixin.popular.bean.scan.result.ProductGetlistResult;
import weixin.popular.bean.scan.result.ProductGetqrcodeResult;
import weixin.popular.bean.scan.result.TicketCheckResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 微信扫一扫
 *
 * @author swang
 * @since 2.8.22
 */
public class ScanAPI extends BaseAPI {

    /**
     * 获取商户信息
     *
     * @param accessToken accessToken
     * @return MerchantinfoGetResult
     */
    public static MerchantinfoGetResult merchantinfoGet(String accessToken) throws ClientProtocolException, IOException {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/scan/merchantinfo/get")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                MerchantinfoGetResult.class);
    }

    /**
     * 创建商品
     *
     * @param accessToken   accessToken
     * @param productCreate productCreate
     * @return ProductCreateResult
     */
    public static ProductCreateResult productCreate(String accessToken, ProductCreate productCreate) throws ClientProtocolException, IOException {
        return productCreate(accessToken, JsonUtil.toJSONString(productCreate));
    }

    /**
     * 创建商品
     *
     * @param accessToken accessToken
     * @param postJson    postJson
     * @return ProductCreateResult
     */
    public static ProductCreateResult productCreate(String accessToken, String postJson) throws ClientProtocolException, IOException {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/scan/product/create")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                ProductCreateResult.class);
    }

    /**
     * 商品发布
     *
     * @param accessToken   accessToken
     * @param productStatus productStatus
     * @return BaseResult
     */
    public static BaseResult productModstatus(String accessToken, ProductStatus productStatus) throws ClientProtocolException, IOException {
        return productModstatus(accessToken, JsonUtil.toJSONString(productStatus));
    }

    /**
     * 商品发布
     *
     * @param accessToken accessToken
     * @param postJson    postJson
     * @return BaseResult
     */
    public static BaseResult productModstatus(String accessToken, String postJson) throws ClientProtocolException, IOException {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/scan/product/modstatus")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }

    /**
     * 设置测试人员白名单
     *
     * @param accessToken accessToken
     * @param whiteUsers  whiteUsers
     * @return BaseResult
     */
    public static BaseResult testwhitelistSet(String accessToken, WhiteUsers whiteUsers) throws ClientProtocolException, IOException {
        return testwhitelistSet(accessToken, JsonUtil.toJSONString(whiteUsers));
    }

    /**
     * 设置测试人员白名单
     *
     * @param accessToken accessToken
     * @param postJson    postJson
     * @return BaseResult
     */
    public static BaseResult testwhitelistSet(String accessToken, String postJson) throws ClientProtocolException, IOException {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/scan/testwhitelist/set")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }

    /**
     * 获取商品二维码
     *
     * @param accessToken      accessToken
     * @param productGetqrcode productGetqrcode
     * @return ProductGetqrcodeResult
     */
    public static ProductGetqrcodeResult productGetqrcode(String accessToken, ProductGetqrcode productGetqrcode) throws ClientProtocolException, IOException {
        return productGetqrcode(accessToken, JsonUtil.toJSONString(productGetqrcode));
    }

    /**
     * 获取商品二维码
     *
     * @param accessToken accessToken
     * @param postJson    postJson
     * @return ProductGetqrcodeResult
     */
    public static ProductGetqrcodeResult productGetqrcode(String accessToken, String postJson) throws ClientProtocolException, IOException {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/scan/product/getqrcode")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                ProductGetqrcodeResult.class);
    }

    /**
     * 查询商品信息
     *
     * @param accessToken accessToken
     * @param productGet  productGet
     * @return ProductGetResult
     */
    public static ProductGetResult productGet(String accessToken, ProductGet productGet) throws ClientProtocolException, IOException {
        return productGet(accessToken, JsonUtil.toJSONString(productGet));
    }

    /**
     * 查询商品信息
     *
     * @param accessToken accessToken
     * @param postJson    postJson
     * @return ProductGetResult
     */
    public static ProductGetResult productGet(String accessToken, String postJson) throws ClientProtocolException, IOException {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/scan/product/get")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                ProductGetResult.class);
    }

    /**
     * 批量查询商品信息
     *
     * @param accessToken    accessToken
     * @param productGetlist productGetlist
     * @return ProductGetlistResult
     */
    public static ProductGetlistResult productGetlist(String accessToken, ProductGetlist productGetlist) throws ClientProtocolException, IOException {
        return productGetlist(accessToken, JsonUtil.toJSONString(productGetlist));
    }

    /**
     * 批量查询商品信息
     *
     * @param accessToken accessToken
     * @param postJson    postJson
     * @return ProductGetlistResult
     */
    public static ProductGetlistResult productGetlist(String accessToken, String postJson) throws ClientProtocolException, IOException {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/scan/product/getlist")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                ProductGetlistResult.class);
    }

    /**
     * 更新商品信息
     *
     * @param accessToken   accessToken
     * @param productUpdate productUpdate
     * @return ProductCreateResult
     */
    public static ProductCreateResult productUpdate(String accessToken, ProductUpdate productUpdate) throws ClientProtocolException, IOException {
        return productUpdate(accessToken, JsonUtil.toJSONString(productUpdate));
    }

    /**
     * 更新商品信息
     *
     * @param accessToken accessToken
     * @param postJson    postJson
     * @return ProductCreateResult
     */
    public static ProductCreateResult productUpdate(String accessToken, String postJson) throws ClientProtocolException, IOException {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/scan/product/update")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                ProductCreateResult.class);
    }

    /**
     * 清除商品信息
     *
     * @param accessToken accessToken
     * @param productGet  productGet
     * @return BaseResult
     */
    public static BaseResult productClear(String accessToken, ProductGet productGet) throws ClientProtocolException, IOException {
        return productClear(accessToken, JsonUtil.toJSONString(productGet));
    }

    /**
     * 清除商品信息
     *
     * @param accessToken accessToken
     * @param postJson    postJson
     * @return BaseResult
     */
    public static BaseResult productClear(String accessToken, String postJson) throws ClientProtocolException, IOException {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/scan/product/clear")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }

    /**
     * 检查wxticket参数
     *
     * @param accessToken accessToken
     * @param ticket      ticket
     * @return TicketCheckResult
     */
    public static TicketCheckResult ticketCheck(String accessToken, String ticket) throws ClientProtocolException, IOException {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/scan/scanticket/check")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .addParameter("ticket", ticket)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                TicketCheckResult.class);
    }

    /**
     * 清除扫码记录
     *
     * @param accessToken accessToken
     * @param ticketCheck ticketCheck
     * @return BaseResult
     */
    public static BaseResult clearTicketCheck(String accessToken, TicketCheck ticketCheck) throws ClientProtocolException, IOException {
        return clearTicketCheck(accessToken, JsonUtil.toJSONString(ticketCheck));
    }

    /**
     * 清除扫码记录
     *
     * @param accessToken accessToken
     * @param postJson    postJson
     * @return BaseResult
     */
    public static BaseResult clearTicketCheck(String accessToken, String postJson) throws ClientProtocolException, IOException {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/scan/scanticket/check")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }
}
