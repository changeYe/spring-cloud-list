/**
 * @author yuantongqin
 * 2019/5/7
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yit.openapi.sdk.client.ApiAccessor;
import com.yit.openapi.sdk.client.ApiContext;
import com.yit.openapi.sdk.client.BaseRequest;
import com.yit.openapi.sdk.client.SDKConfig;
import com.yit.openapi.sdk.client.ServerResponse;
import com.yit.openapi.sdk.client.api.request.LogisticsOpenApi_ConfirmDownload;
import com.yit.openapi.sdk.client.api.request.LogisticsOpenApi_GetOrderByPeriod;
import com.yit.openapi.sdk.client.api.request.LogisticsOpenApi_GetUnDownloadedPendingDeliveryOrderByLastId;
import com.yit.openapi.sdk.client.api.request.LogisticsOpenApi_SendLogisticsByItemId;
import com.yit.openapi.sdk.client.api.request.LogisticsOpenApi_SendLogisticsByVendorSkuCode;
import com.yit.openapi.sdk.client.api.resp.Api_LOGISTICSOPENAPI_SearchOrderParam;
import com.yit.openapi.sdk.client.api.resp.Api_LOGISTICSOPENAPI_YitOrderInfo;
import com.yit.openapi.sdk.client.api.resp.Api_LOGISTICSOPENAPI_YitSendLogisticsByVendorSkuInfo;
import com.yit.openapi.sdk.client.api.resp.Api_LOGISTICSOPENAPI_YitSendLogisticsInfo;
import com.yit.openapi.sdk.client.util.RsaHelper;
import org.junit.Test;
import org.springframework.http.converter.json.GsonBuilderUtils;

public class testSdk {


    public static final String privateKey = "MIICWwIBAAKBgQDOw5HI+Oe4ZQeucTUWEtBW+orwOush4wMsNJ3UwVxJMftJEm1c" +
                                            "H4ETlpnVoiM0WL38Za6KqyaGblaJAzhAhOZijd/5zOCFjdnjJh49+P7sRHIQOXww" +
                                            "CT33RU0kY4vi6ULcAOhGkdkYxn0Lr4OzSX7iM0MPlz81WYAxxbC6Lx/ojQIDAQAB" +
                                            "AoGANo08yoR5RppJQ4oU0oUWOMyTmbxBy0gEz0X2mmqFub4ZKXdWKScavBtQ7R+B" +
                                            "IE+FmLEPMwDjAjbcV/vkfIlT6xUYzHu0l+zjLkQWqMZbSmuuxfdinTWaeFz+vyBR" +
                                            "BrJr/u8HXQyb1IdzfXeoBWC0hAQGSWZ0IktZQOgY0APSeTUCQQD0hrYbzCTNQgwo" +
                                            "Nyb3A0anvG3zUAvnwGDm4NUmwj7YibnbgTpSP/0nXfM3sGtXRxiqvn+UgpS2SNcG" +
                                            "mssfBcq/AkEA2HdAZb+m882rgR+8wPyCSXDtYSdwY+H36iecV84kOpy3cXun4hL/" +
                                            "pmfKj1gGkdJUfRkwBDHUqBQ/Qy77n48bswJAICeexuT/aeZnhtpJy22o2uHSa455" +
                                            "Ik6P74xdOy2L6hmiURUbQDmd5pFaLFaMpvt4aOuIB1VsjNPjQsEUOM4gLQJAC9/G" +
                                            "xY4Uz2zpyoR+Kyvuza6HJvwt2xzLJ6oSlnJ1ZE2ydmQtGmamZW9uGhzfB2K9Rbt6" +
                                            "+c/t9WZe7gWGwgLspwJALahUjiWowFntqZfwk+RjFl7UWFj5r3cqDsBHVkFSdQ9O" +
                                            "AHknqMz4pa0SQiuMlNhEDm3lzf8mviDFEaAz1MqlPA==";

    public static final String tpId = "889041f11443377c";



//    public static final String tpId = "afc26891388c0a70";

    /**
     * 接口调用流程简单说明
     */
    @Test
    public void readme() {
        //1.1 下载订单，指定数据开始坐标。
        int lastId = 0;
        List<Api_LOGISTICSOPENAPI_YitOrderInfo> list = getUnDownloadedPendingDeliveryOrderByLastId(lastId);
        //1.2  确认已下载到的订单
        int[] ids = new int[list.size()];
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ids[i] = list.get(i).id;
        }
        confirmDownload(ids);

        //2。线下快递发货

        //3。线上将快递信息传给一条 两种方式二选一，
        test_sendLogisticsByItemId();
        test_sendLogisticsByVenderSkuCode();

        //4。（正常发货流程不需要调这个接口）根据时间段下载订单，忽略是否已下载过，可以用于定时补偿检查，以免漏处理订单
        getOrderByPeriod();
    }

    /**
     *logisticsOpenApi.getUnDownloadedPendingDeliveryOrderByLastId
     * 查询订单id大于lastId，且未下载过的待发货订单，每次最多返回200条订单数据，
     * 当返回条数不足200条时说明没有更多的未下载的待发货订单
     * @return
     */

    /**
     *
     logisticsOpenApi.getUnDownloadedPendingDeliveryOrder
     查询未下载过的待发货订单，每次最多返回200条订单数据，
     当返回条数不足200条时说明没有更多的未下载的待发货订单
     * @return
     */

    /**
     *
     * @return
     */


    private ApiAccessor getApiAccessor() {
        ApiContext context = ApiContext.getCurrent();
        SDKConfig.isDebug = true;
        context.setThirdPartyId(tpId);
        context.setClientPK("", privateKey);
        ApiAccessor apiAccessor = new ApiAccessor(context, 3000, 3000, "https://open-test.yit.com/apigw/m.api");
        return apiAccessor;
    }

    private void sendLogisticsByItemId(List<Api_LOGISTICSOPENAPI_YitSendLogisticsInfo> list) {
        LogisticsOpenApi_SendLogisticsByItemId sendLogisticsByItemId = new LogisticsOpenApi_SendLogisticsByItemId(list);
        ApiAccessor apiAccessor = getApiAccessor();
        ServerResponse serverResponse = apiAccessor.fillApiResponse(new BaseRequest<?>[]{sendLogisticsByItemId});
        System.out.print(JSON.toJSONString(serverResponse));
        System.out.print(JSON.toJSONString(sendLogisticsByItemId.getResponse()));
        System.out.println(sendLogisticsByItemId.getResponse());
    }

    private void sendLogisticsByVenderSkuCode(List<Api_LOGISTICSOPENAPI_YitSendLogisticsByVendorSkuInfo> list) {
        LogisticsOpenApi_SendLogisticsByVendorSkuCode sendLogisticsByVendorSkuCode = new LogisticsOpenApi_SendLogisticsByVendorSkuCode(list);
        ApiAccessor apiAccessor = getApiAccessor();
        ServerResponse serverResponse = apiAccessor.fillApiResponse(new BaseRequest<?>[]{sendLogisticsByVendorSkuCode});
        System.out.println(JSON.toJSONString(serverResponse));
        System.out.println(JSON.toJSONString(sendLogisticsByVendorSkuCode.getResponse()));
    }

    private List<Api_LOGISTICSOPENAPI_YitOrderInfo> getUnDownloadedPendingDeliveryOrderByLastId(int lastId) {
        LogisticsOpenApi_GetUnDownloadedPendingDeliveryOrderByLastId getUnDownloadedPendingDeliveryOrder = new LogisticsOpenApi_GetUnDownloadedPendingDeliveryOrderByLastId(lastId);
        ApiAccessor apiAccessor = getApiAccessor();
        ServerResponse serverResponse = apiAccessor.fillApiResponse(new BaseRequest<?>[]{getUnDownloadedPendingDeliveryOrder});
        System.out.println(JSON.toJSONString(serverResponse));

        List<Api_LOGISTICSOPENAPI_YitOrderInfo> list = getUnDownloadedPendingDeliveryOrder.getResponse().value;
        List<String> ids = new ArrayList<>();
        for (Api_LOGISTICSOPENAPI_YitOrderInfo info : list) {
            ids.add(String.valueOf(info.id));
        }
        System.out.println(ids);
        System.out.println(ids.size());
        System.out.println(JSON.toJSONString(list));
        return list;
    }

    private boolean confirmDownload(int[] ids) {
        LogisticsOpenApi_ConfirmDownload confirmDownload = new LogisticsOpenApi_ConfirmDownload(ids);
        ApiAccessor apiAccessor = getApiAccessor();
        ServerResponse serverResponse = apiAccessor.fillApiResponse(new BaseRequest<?>[]{confirmDownload});
        System.out.println(JSON.toJSONString(serverResponse));
        System.out.println(JSON.toJSONString(confirmDownload.getResponse()));
        return confirmDownload.getResponse().value;
    }

    /**
     * 根据时间间隔下载
     * /订单状态, 不想指定状态时为空或null CANCEL 已取消, CONFIRMED 已确认,
     * SIGNED 已签收, STOCK_OUT 已发货, WAIT_DELIVERY 待发货
     */
    @Test
    public void getOrderByPeriod() {


        Api_LOGISTICSOPENAPI_SearchOrderParam param = new Api_LOGISTICSOPENAPI_SearchOrderParam();
        param.lastId = 0;
        param.size = 20;
        Calendar calendar = Calendar.getInstance();

//        2018-11-02 12:37:45

        calendar.set(2018,10,1);

        param.startDate = calendar.getTime();
        System.out.println(calendar.getTime());
//        calendar.set(2018,11,29);
//        System.out.println(calendar.getTime());
//        param.endDate = calendar.getTime();  //最多查询30天时间间隔
        param.status = "CONFIRMED";
        LogisticsOpenApi_GetOrderByPeriod getOrderByPeriod = new LogisticsOpenApi_GetOrderByPeriod(param);
        ApiContext context = ApiContext.getCurrent();
        context.setThirdPartyId(tpId);
        context.setClientPK("", privateKey);
        ApiAccessor apiAccessor = getApiAccessor();

        ServerResponse serverResponse = apiAccessor.fillApiResponse(new BaseRequest<?>[]{getOrderByPeriod});
        System.out.println(JSON.toJSONString(serverResponse));
        System.out.println(JSON.toJSONString(getOrderByPeriod.getResponse()));
    }

    /**
     * 根据一条SKU发货
     */
    @Test
    public void test_sendLogisticsByItemId() {
        List<Api_LOGISTICSOPENAPI_YitSendLogisticsInfo> list = new ArrayList<>();
        for (int i = 0; i < 109; i++) {
            Api_LOGISTICSOPENAPI_YitSendLogisticsInfo info = new Api_LOGISTICSOPENAPI_YitSendLogisticsInfo();
            info.companyName = "SF";  //支持的快递公司间业务接口文档
            info.itemId = 9449515;    //Api_LOGISTICSOPENAPI_YitProductInfo.itemId
            info.logisticsCode = "987622545";    //快递单号
            info.subOrderNo = "11112132-0001"; //Api_LOGISTICSOPENAPI_YitOrderDetailInfo.subOrderNo
            list.add(info);
        }
        sendLogisticsByItemId(list);
    }

    /**
     * 根据供应商SKU发货
     */
    @Test
    public void test_sendLogisticsByVenderSkuCode() {
        List<Api_LOGISTICSOPENAPI_YitSendLogisticsByVendorSkuInfo> list = new ArrayList<>();
        Api_LOGISTICSOPENAPI_YitSendLogisticsByVendorSkuInfo info = new Api_LOGISTICSOPENAPI_YitSendLogisticsByVendorSkuInfo();
        info.companyName = "SF"; //支持的快递公司间业务接口文档
        info.vendorSkuCode = "ceshi001"; //Api_LOGISTICSOPENAPI_YitProductInfo.vendorSku
        info.logisticsCode = "9876545"; //快递单号
        info.subOrderNo = "11111114-0001";//Api_LOGISTICSOPENAPI_YitOrderDetailInfo.subOrderNo
        Api_LOGISTICSOPENAPI_YitSendLogisticsByVendorSkuInfo info2 = new Api_LOGISTICSOPENAPI_YitSendLogisticsByVendorSkuInfo();
        info2.companyName = "SF";
        info2.vendorSkuCode = "ceshi002";
        info2.logisticsCode = "9876523325";
        info2.subOrderNo = "11111122-0001";
        list.add(info2);
        sendLogisticsByVenderSkuCode(list);
    }

    @Test
    public  void ss() {
        String a = "{\"id\":8477228,\"yitLogisticsInfos\":[],\"yitOrderDetailInfo\":{\"hasInvoice\":false,\"note\":[],\"orderPayTime\":\"2018-11-07 11:03:23\",\"routeName\":\"北京大朴至向家居设计有限公司仓-自发货\",\"status\":\"WAIT_DELIVERY\",\"subOrderNo\":\"11111329-0001\",\"vendorName\":\"测试渠道-请勿使用和修改\"},\"yitPayDeclareInfo\":null,\"yitPayInfo\":null,\"yitProductInfo\":{\"actualPaiedUnitPrice\":9900,\"customerNoteValue\":\"\",\"isGift\":false,\"itemId\":9448712,\"optionText\":\"\",\"productName\":\"男士高棉袜三双装 大朴\",\"quantity\":1,\"totalPrice\":9900,\"unitPrice\":9900,\"vendorSku\":\"C6W0310200100\"},\"yitReceiverInfo\":{\"city\":\"深圳市\",\"fullAddress\":\"田面邨設計之都11棟5A\",\"phone\":\"93823334005\",\"province\":\"广东省\",\"recipient\":\"高少康\",\"region\":\"福田区\"}}";

        Gson gson = new GsonBuilder().create();
        Api_LOGISTICSOPENAPI_YitOrderInfo info = gson.fromJson(a, Api_LOGISTICSOPENAPI_YitOrderInfo.class);

        System.out.println(info.id);
        //订单信息
        System.out.println(gson.toJson(info.yitOrderDetailInfo));
        //商品信息
        System.out.println(gson.toJson(info.yitProductInfo));
        //收货人信息
        System.out.println(gson.toJson(info.yitReceiverInfo));
        //物流
        System.out.println(gson.toJson(info.yitLogisticsInfos));
        //支付人信息
        System.out.println(gson.toJson(info.yitPayInfo));
        //支付流程信息
        System.out.println(gson.toJson(info.yitPayDeclareInfo));


    }

}
