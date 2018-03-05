package com.ycgwl.http.secret.util;


import com.ycgwl.http.secret.vo.HttpParamsVo;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

import java.util.List;

/**
 * 发 get post请求
 */
public class HttpClientSecretSendUtil {
    private static MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();

    private static final int TIMEOUT = 5 * 1000000;//5 * 1000
    private static final int MAX_HTTP_CONNECTION = 50;
    private static final int MAX_CONNECTION_PER_HOST = 10;// 10

    /**
     * 初始化连接池
     */
    static {
        //HttpClient 连接池属性设置，HOST并发数默认为50, 客户端总并发数为200, TimeOut时间为5s.
        HttpConnectionManagerParams httpConnectionManagerParams = new HttpConnectionManagerParams();
        httpConnectionManagerParams.setMaxTotalConnections(MAX_HTTP_CONNECTION);
        httpConnectionManagerParams.setDefaultMaxConnectionsPerHost(MAX_CONNECTION_PER_HOST);
        // 读取数据超时时间
        httpConnectionManagerParams.setSoTimeout(TIMEOUT);
        // 连接超时时间
        httpConnectionManagerParams.setConnectionTimeout(TIMEOUT);
        connectionManager.setParams(httpConnectionManagerParams);
    }

    /**
     * 发送post请求
     * @param url
     * @return
     */
    public static String post(String url, HttpParamsVo httpParamsVo) {
        HttpClient httpClient = new HttpClient(connectionManager);
        PostMethod postMethod = new PostMethod(url);

        List<NameValuePair> nameValueList = HttpCommonUtils.completeNameValuePairList(httpParamsVo);
        postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        postMethod.setRequestBody(nameValueList.toArray(new NameValuePair[nameValueList.size()]));

        return HttpCommonUtils.execute(httpClient, postMethod);
    }
    /**
     * 发送get请求
     * @param url
     * @return
     */
    public static String get(String url, HttpParamsVo httpParamsVo) {
        HttpClient httpClient = new HttpClient(connectionManager);

        List<NameValuePair> nameValueList = HttpCommonUtils.completeNameValuePairList(httpParamsVo);
        url=url+"?"+HttpCommonUtils.keyValueToString(nameValueList);
        System.err.println("get 请求 地址:\n "+url);

        GetMethod getMethod = new GetMethod(url);

        return HttpCommonUtils.execute(httpClient, getMethod);
    }

}
