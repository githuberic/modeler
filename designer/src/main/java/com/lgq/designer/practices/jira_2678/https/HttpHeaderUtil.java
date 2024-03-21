package com.lgq.designer.practices.jira_2678.https;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lgq
 */
public class HttpHeaderUtil {
    public static Map<String, String> assemblyHeader(String cookie, String userAgent) {
        Map<String, String> map = new HashMap<>();
        map.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        map.put("accept-language", "zh-CN,zh;q=0.9");
        map.put("cache-control", "max-age=0");
        map.put("device-memory", "8");
        map.put("downlink", "1.3");
        map.put("dpr", "1.8");
        map.put("ect", "3g");
        map.put("rtt", "500");
        map.put("sec-ch-device-memory", "8");
        map.put("sec-ch-dpr", "1.8");
        map.put("sec-ch-ua", "Not A(Brand\";v=\"99\", \"Google Chrome\";v=\"121\", \"Chromium\";v=\"121\"");
        map.put("sec-ch-ua-mobile", "?0");
        map.put("sec-ch-ua-platform", "macOS");
        map.put("sec-ch-viewport-width", "1600");
        map.put("sec-fetch-dest", "document");
        map.put("sec-fetch-mode", "navigate");
        map.put("sec-fetch-site", "none");
        map.put("sec-fetch-user", "?1");
        map.put("sec-gpc", "1");
        map.put("upgrade-insecure-requests", "1");
        map.put("viewport-width", "1600");
        map.put("user-agent", userAgent);
        map.put("cookie", cookie);
        return map;
    }
}
