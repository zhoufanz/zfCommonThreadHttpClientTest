package com.ycgwl.http.secret.util;

import com.ycgwl.http.secret.vo.HttpParamsVo;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HttpCommonUtils {

    /**
     * 将输入流转化为 字符串
     * @param in
     * @return
     * @throws IOException
     */
    public static String getStringByInputStream(InputStreamReader in) throws IOException {
        BufferedReader reader = new BufferedReader(in);
        StringBuffer stringBuffer = new StringBuffer();
        String str = "";
        while ((str = reader.readLine()) != null) {
            stringBuffer.append(str);
        }
        String ts = stringBuffer.toString();

        return ts;
    }

    /**
     * 将 keyvalue 拼装 xx=xx&xx=xx
     * @param nameValuePairs
     * @return
     */
    public static String keyValueToString(List<NameValuePair> nameValuePairs){
        StringBuilder sb = new StringBuilder();
        int i=0;
        for (NameValuePair nameValuePair : nameValuePairs) {
            if (i == 0) {
                sb.append(nameValuePair.getName() + "=" + nameValuePair.getValue());
            }else{
                sb.append("&"+nameValuePair.getName() + "=" + nameValuePair.getValue());

            }
            i++;
        }
        return sb.toString();

    }

    /**
     * 参数处理
     * @param httpParamsVo
     * @return
     */
    public static List<NameValuePair>  completeNameValuePairList(HttpParamsVo httpParamsVo){
        List<NameValuePair> nameValueList = new ArrayList<NameValuePair>();
        nameValueList.add(new NameValuePair("params", httpParamsVo.getParams()));
        nameValueList.add(new NameValuePair("digest", httpParamsVo.getDigest()));
        nameValueList.add(new NameValuePair("timestamp", httpParamsVo.getTimestamp()));
        nameValueList.add(new NameValuePair("appkey", httpParamsVo.getAppkey()));
        return nameValueList;
    }


    /**
     * 执行 http方法
     * @param httpClient
     * @param httpMethod
     * @return
     */
    public static String execute(HttpClient httpClient, HttpMethod httpMethod) {
        try {
            httpClient.executeMethod(httpMethod);
            InputStreamReader in = new InputStreamReader(httpMethod.getResponseBodyAsStream(), "UTF-8");
            String jsonString = HttpCommonUtils.getStringByInputStream(in);
            if (jsonString == null || "".equals(jsonString)) {
                jsonString = "[{\"msg\":\"获取信息失败！\",\"success\":\"false\"}]";
            }
            return jsonString;
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            if (httpMethod != null)
                httpMethod.releaseConnection();
        }
    }



}
