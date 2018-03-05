package com.ycgwl.http.secret.pp;

import com.ycgwl.http.secret.util.HttpClientSecretSendUtil;
import com.ycgwl.http.secret.vo.HttpParamsVo;
import com.ycgwl.http.secret.vo.HttpSecretVo;
import org.junit.Test;

public class PpPriceDiscountRestControllerTest {

    private String appKey = "BOS";
    private String appSecret = "WREW223421FDR134R";
    private String params = "{\"bizType\":\"1\",\"blFlag\":\"false\",\"calcWeight\":\"300\",\"customerCode\":\"XT00114707\",\"customerType\":\"20\",\"desSiteType\":\"\",\"dispatchSiteCode\":\"579J01\",\"fromTime\":\"2018-01-30 09:07:43\",\"goodsName\":\"货物名称\",\"goodsType\":\"18\",\"interfaceType\":\"WBMS\",\"payType\":\"1\",\"pickGoodsType\":\"2\",\"productCode\":\"2\",\"sendSiteCode\":\"517P02\"}";
//    private String url = "http://172.16.36.14:8080/rosefinch-web/ppapi/rest/queryPriceAndDiscount.api";
    private String url = "http://localhost:8082/rosefinch-ppTest-web/ppapi/rest/queryPriceAndDiscount.api";

    @Test
    public void post(){
        HttpParamsVo httpParamsVo = new HttpParamsVo(new HttpSecretVo(appKey,appSecret),params);
        String result = HttpClientSecretSendUtil.post(url, httpParamsVo);
        System.out.println(result);
    }

    @Test
    public void get(){
        HttpParamsVo httpParamsVo = new HttpParamsVo(new HttpSecretVo(appKey,appSecret),params);
        String result = HttpClientSecretSendUtil.get(url, httpParamsVo);
        System.out.println(result);
    }

}
