//package yitiao; /**
// * @author yuantongqin
// * 2019/5/7
// */
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import com.alibaba.fastjson.JSON;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.yit.openapi.sdk.client.ApiAccessor;
//import com.yit.openapi.sdk.client.ApiContext;
//import com.yit.openapi.sdk.client.BaseRequest;
//import com.yit.openapi.sdk.client.SDKConfig;
//import com.yit.openapi.sdk.client.ServerResponse;
//import com.yit.openapi.sdk.client.api.request.LogisticsOpenApi_ConfirmDownload;
//import com.yit.openapi.sdk.client.api.request.LogisticsOpenApi_GetOrderByPeriod;
//import com.yit.openapi.sdk.client.api.request.LogisticsOpenApi_GetUnDownloadedPendingDeliveryOrderByLastId;
//import com.yit.openapi.sdk.client.api.request.LogisticsOpenApi_SendLogisticsByItemId;
//import com.yit.openapi.sdk.client.api.request.LogisticsOpenApi_SendLogisticsByVendorSkuCode;
//import com.yit.openapi.sdk.client.api.resp.Api_LOGISTICSOPENAPI_SearchOrderParam;
//import com.yit.openapi.sdk.client.api.resp.Api_LOGISTICSOPENAPI_YitOrderInfo;
//import com.yit.openapi.sdk.client.api.resp.Api_LOGISTICSOPENAPI_YitOrderInfo_ArrayResp;
//import com.yit.openapi.sdk.client.api.resp.Api_LOGISTICSOPENAPI_YitSendLogisticsByVendorSkuInfo;
//import com.yit.openapi.sdk.client.api.resp.Api_LOGISTICSOPENAPI_YitSendLogisticsInfo;
//import org.junit.Test;
//
//public class testSdk2 {
//
//
//    public static final String privateKey = SecretKeyUtils.privateKeyProduct;
//    public static final String publicKey = SecretKeyUtils.publicKeyProduct;
//
//
//    public static final String tpIdTest = "889041f11443377c";
//    public static final String tpIdProduct = "74a3487e5e5fd051";
//    public static final String tpId = tpIdProduct;
//    public static final String urlTest = "https://open-test.yit.com/apigw/m.api";
//    public static final String urlProduct = "https://open.yit.com/apigw/m.api";
//    public static final String url = urlProduct;
//
//
//
//
//    private ApiAccessor getApiAccessor() {
//        int b = 0;
//        ApiContext context = ApiContext.getCurrent();
//        SDKConfig.isDebug = true;
//        context.setThirdPartyId(tpIdProduct);
//        context.setClientPK(publicKey, privateKey);
//        ApiAccessor apiAccessor = new ApiAccessor(context, 10000, 10000, url);
//        return apiAccessor;
//    }
//
//    /**
//     * 根据时间间隔下载
//     * /订单状态, 不想指定状态时为空或null CANCEL 已取消, CONFIRMED 已确认,
//     * SIGNED 已签收, STOCK_OUT 已发货, WAIT_DELIVERY 待发货
//     */
//    @Test
//    public void getOrderByPeriod() {
//        int a = 0;
//        Api_LOGISTICSOPENAPI_SearchOrderParam param = new Api_LOGISTICSOPENAPI_SearchOrderParam();
//        param.lastId = 0;
//        param.size = 120;
//        Calendar calendar = Calendar.getInstance();
//        Date initDate = new Date(1559318400088L);
//        calendar.set(2019,5,19, 20,28,13);
//        param.startDate = calendar.getTime();
//        calendar.set(2019,5,21,0,0,0);
//        System.out.println(calendar.getTime());
//        Calendar calendar1 = Calendar.getInstance();
//        param.endDate = calendar.getTime();  //最多查询30天时间间隔
////        param.endDate = new Date(1562815894316L);  //最多查询30天时间间隔
//        param.status = null;
////        param.lastId = 13310311;
//        LogisticsOpenApi_GetOrderByPeriod getOrderByPeriod = new LogisticsOpenApi_GetOrderByPeriod(param);
//        ApiContext context = ApiContext.getCurrent();
//        context.setThirdPartyId(tpId);
//        context.setClientPK(publicKey, privateKey);
//        ApiAccessor apiAccessor = getApiAccessor();
//
//        ServerResponse serverResponse = apiAccessor.fillApiResponse(new BaseRequest<?>[]{getOrderByPeriod});
//        System.out.println("请求编码："+JSON.toJSONString(serverResponse));
//        System.out.println("返回结果"+JSON.toJSONString(getOrderByPeriod.getResponse()));
//        Api_LOGISTICSOPENAPI_YitOrderInfo_ArrayResp response = getOrderByPeriod.getResponse();
//        if(response != null){
//            int length = response.value == null?0:response.value.size();
//            System.out.println("长度"+length);
//
//        }
//    }
//}
