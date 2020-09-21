package com.lgq.modeler.app.html;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Map;

/**
 * Created by eric on 2020/1/11.
 */
public class HttpUtils {
    private static CloseableHttpClient httpclient = HttpClients.createDefault();
    private static final String CHARSET = "UTF-8";

    public static CloseableHttpResponse httpPost(String url, String jsonArg, Map<String, String> header) {
        HttpPost httppost = new HttpPost(url);
        HttpEntity httpEntity = new StringEntity(jsonArg, CHARSET);
        httppost.setEntity(httpEntity);
        if (header != null) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                httppost.setHeader(entry.getKey(), entry.getValue());
            }
        }
        httppost.setHeader("Content-Type", "application/json");
        CloseableHttpResponse response;
        try {
            response = httpclient.execute(httppost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return response;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }


    private static final String URL = "http://127.0.0.1:8080/";

    public static void main(String[] args) {
        for (int i = 1; i <= 200; i++) {
            CloseableHttpResponse response = HttpUtils.httpPost(URL, "",null);
            if (response == null) {
                System.out.println("第" + i + "次-------------请求失败---------");
            } else {
                System.out.println("第" + i + "次" + response.getStatusLine().getStatusCode());
            }
        }
    }
}