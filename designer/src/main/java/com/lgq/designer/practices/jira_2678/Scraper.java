package com.lgq.designer.practices.jira_2678;

import com.google.common.base.Strings;
import com.lgq.designer.practices.jira_2678.https.HttpClient;
import com.lgq.designer.practices.jira_2678.https.HttpHeaderUtil;
import com.lgq.designer.practices.jira_2678.parser.AsyncParser;
import com.lgq.designer.practices.jira_2678.stat.CookieStat;
import com.lgq.designer.practices.jira_2678.stat.StatInfo;
import com.lgq.designer.practices.jira_2678.utils.FileUtil;
import com.lgq.designer.practices.jira_2678.utils.LoggingUtil;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

/**
 * @author lgq
 */
public class Scraper {
    public static void scrape(String asin, Queue<CookieStat> cookieQueue, StatInfo statInfo) throws MyException {
        asin = asin.replace("\"", "");
        String url = String.format("https://www.amazon.com/dp/%s?th=1&psc=1", asin);

        // 获取新的cookie,并判定是否失败次数
        CookieStat cookieStat = cookieQueue.poll();
        if (cookieStat.getFailureCount() >= Constants.MAX_COOKIE_FAILURES) {
            return;
        }

        try {
            // 组装http-request-headers
            Map<String, String> mapHeaders = assemblyReqHeader(cookieStat.getCookie());

            // 发起请求,请求&获取结果
            String resContent = HttpClient.doGet(url, mapHeaders);
            statInfo.incrTotal();

            // 保存响应结果
            if (Strings.isNullOrEmpty(resContent)) {
                statInfo.incrFailCount();
                LoggingUtil.logging(asin, null, statInfo, null);
            } else {
                new AsyncParser(asin, resContent, statInfo).run();
            }
        } catch (MyException ex) {
            statInfo.incrFailCount();
            cookieStat.incrFailCount();
        }
    }

    private static Map<String, String> assemblyReqHeader(String cookie) throws MyException {
        List<String> userAgents = FileUtil.readFileByLines(Constants.USER_AGETN_PATH);

        Random random = new Random();
        String userAgent = userAgents.get(random.nextInt(userAgents.size()));
        return HttpHeaderUtil.assemblyHeader(cookie, userAgent);
    }
}
