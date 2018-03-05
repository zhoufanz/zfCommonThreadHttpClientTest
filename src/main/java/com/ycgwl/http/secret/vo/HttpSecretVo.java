package com.ycgwl.http.secret.vo;

import com.ycky.app.util.SecurityUtil;

/**
 * Created by Administrator on 2018/2/6.
 */
public class HttpSecretVo {
    private String appKey;
    private String appSecret;

    public HttpSecretVo(String appKey, String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
    public String getDigest(String params){
        return SecurityUtil.getDigest(params + appKey + appSecret);
    }
}
