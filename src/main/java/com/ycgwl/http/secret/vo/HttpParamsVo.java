package com.ycgwl.http.secret.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/6.
 */
public class HttpParamsVo implements Serializable{
    private String params;
    private String digest;
    private String timestamp;
    private String appkey;

    public HttpParamsVo(HttpSecretVo httpSecretVo, String params) {
        this.appkey = httpSecretVo.getAppKey();
        this.timestamp = this.getTimestamp();
        this.digest = httpSecretVo.getDigest(params);
        this.params = params;

    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getTimestamp() {
        return System.currentTimeMillis() + "";
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis()+"");
    }
}
