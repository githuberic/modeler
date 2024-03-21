package com.lgq.designer.practices.jira_2678.https;

import com.lgq.designer.practices.jira_2678.MyException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author lgq
 */
public class HttpClient {
    private static HttpClient httpClient = null;

    /**
     * 以get方式调用第三方接口
     *
     * @param url
     * @return
     */
    public static String doGet(String url, Map<String, String> headers) throws MyException {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);

        String res = null;
        try {
            for (Map.Entry<String, String> item : headers.entrySet()) {
                get.addHeader(item.getKey(), item.getValue());
            }
            HttpResponse response = httpClient.execute(get);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                res = EntityUtils.toString(response.getEntity());
            }
        } catch (IOException e) {
            throw new MyException("doGet error");
        }
        return res;
    }
}
