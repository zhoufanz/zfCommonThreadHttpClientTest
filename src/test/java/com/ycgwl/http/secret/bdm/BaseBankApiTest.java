package com.ycgwl.http.secret.bdm;

import com.ycgwl.http.secret.util.HttpClientSecretSendUtil;
import com.ycgwl.http.secret.vo.HttpParamsVo;
import com.ycgwl.http.secret.vo.HttpSecretVo;
import org.junit.Test;

public class BaseBankApiTest{

    private String appKey = "BOS";
    private String appSecret = "WREW223421FDR134R";
    private String url = "http://localhost:8081/rosefinch-baseTest-web/baseapi/rest/queryBaseBank.api";
    private String params = "{\"bankType\":1,\"createTimeBegin\":1515168000000,\"createTimeEnd\":1517932799000,\"modifyTimeBegin\":1515168000000,\"modifyTimeEnd\":1517932799000}";


    @Test
    public void post(){
        HttpParamsVo httpParamsVo = new HttpParamsVo(new HttpSecretVo(appKey,appSecret),params);
        String result = HttpClientSecretSendUtil.post(url, httpParamsVo);
        System.out.println(result);
    }

    @Test
    public void get() {
        HttpParamsVo httpParamsVo = new HttpParamsVo(new HttpSecretVo(appKey,appSecret),params);
        String result = HttpClientSecretSendUtil.get(url, httpParamsVo);
        System.out.println(result);
    }
}
