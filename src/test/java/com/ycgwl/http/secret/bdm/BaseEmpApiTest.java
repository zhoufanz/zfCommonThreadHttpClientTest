package com.ycgwl.http.secret.bdm;

import com.ycgwl.http.secret.util.HttpClientSecretSendUtil;
import com.ycgwl.http.secret.vo.HttpParamsVo;
import com.ycgwl.http.secret.vo.HttpSecretVo;
import org.junit.Test;

public class BaseEmpApiTest {


    private String appKey = "BOS";
    private String appSecret = "WREW223421FDR134R";
    private String url = "http://172.16.36.12:8083/rosefinch-web/baseapi/rest/queryEmployee.api";
    private String params = "{\"employeeCode\":\"108251\"}";

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
