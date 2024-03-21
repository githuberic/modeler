package com.lgq.designer.practices.jira_2678;

import com.google.common.base.Strings;
import com.lgq.designer.practices.jira_2678.https.HttpClient;
import com.lgq.designer.practices.jira_2678.https.HttpHeaderUtil;
import com.lgq.designer.practices.jira_2678.stat.CookieStat;
import com.lgq.designer.practices.jira_2678.stat.StatInfo;
import com.lgq.designer.practices.jira_2678.utils.FileUtil;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lgq.designer.practices.jira_2678.utils.LoggingUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author lgq
 */
public class Jira2678 {

    static final String COOKIE_PATH = "/Users/guoqingliu/job/pingpong/jira_2687/US_90001.cookie";
    static final String PRODUCT_PATH = "/Users/guoqingliu/job/pingpong/jira_2687/products.txt";
    static final String USER_AGETN_PATH = "/Users/guoqingliu/job/pingpong/jira_2687/user_agents.txt";
    static final String RESULT_FILE = "abuyun_buybox_mt_log.txt";

    static final int MAX_COOKIE_FAILURES = 3;
    private static final int THREAD_POOL_SIZE = 1;

    private static Queue<CookieStat> readCookie() throws MyException {
        // 从文件中读取Cookies
        List<String> cookies = FileUtil.readFileByLines(COOKIE_PATH);
        // 加工成Queue
        Queue<CookieStat> statQueue = new ArrayDeque<>(cookies.size());
        for (String cookie : cookies) {
            statQueue.add(new CookieStat(cookie));
        }
        return statQueue;
    }

    private static List<String> readProduct() throws MyException {
        return FileUtil.readFileByLines(PRODUCT_PATH);
    }

    private static List<String> readUserAgent() throws MyException {
        return FileUtil.readFileByLines(USER_AGETN_PATH);
    }

    private static void scrape(String asin, Queue<CookieStat> cookieQueue, StatInfo statInfo) throws MyException {
        asin = asin.replace("\"", "");
        String url = String.format("https://www.amazon.com/dp/%s?th=1&psc=1", asin);

        CookieStat cookieStat = cookieQueue.poll();
        assert cookieStat != null;
        if (cookieStat.getFailureCount() >= MAX_COOKIE_FAILURES) {
            return;
        }

        List<String> userAgents = readUserAgent();
        Random random = new Random();
        String userAgent = userAgents.get(random.nextInt(userAgents.size()));
        Map<String, String> mapHeaders = HttpHeaderUtil.assemblyHeader(cookieStat.getCookie(), userAgent);

        String resResult = null;
        // 请求&获取结果
        statInfo.incrTotal();
        try {
            String resContent = HttpClient.doGet(url, mapHeaders);

            // 保存结果
            FileUtil.write(resContent, RESULT_FILE);

            // 解析结果
            resResult = parseRes(resContent);
            if (!Strings.isNullOrEmpty(resResult)) {
                statInfo.incrSuccessCount();
            }
        } catch (MyException ex) {
            statInfo.incrFailCount();
            //cookieQueue.add();
        }

        // 记录日志
        LoggingUtil.logging(asin, resResult, statInfo, null);
    }

    private static String parseRes(String resContent) throws MyException {
        Document doc = Jsoup.parse(resContent);

        Element btn_buy_now = doc.getElementById("submit.buy-now-announce");
        Element btn_add_to_ubb_cart = doc.getElementById("submit.add-to-cart-ubb-announce");
        Element btn_add_to_cart = doc.getElementById("submit.add-to-cart-announce");
        Element btn_setup_now = doc.getElementById("rcx-subscribe-submit-button-announce");

        String strRet = null;
        if (btn_buy_now != null) {
            strRet = btn_buy_now.text();
        } else if (btn_add_to_ubb_cart != null) {
            strRet = btn_add_to_ubb_cart.text();
        } else if (btn_add_to_cart != null) {
            strRet = btn_add_to_cart.text();
        } else if (btn_setup_now != null) {
            strRet = btn_setup_now.text();
        }

        return strRet;
    }

    public static void main(String[] args) throws MyException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        List<String> products = readProduct();

        Queue<CookieStat> queueCookies = readCookie();

        StatInfo statInfo = new StatInfo();

        for (String asin : products) {
            try {
                scrape(asin, queueCookies, statInfo);
            } catch (MyException e) {
                throw new RuntimeException(e);
            }
        }

        /*
        products.stream().map(asin -> {
            return executor.submit(() -> {
                try {
                    scrape(asin, queueCookies, statInfo);
                } catch (MyException e) {
                    throw new RuntimeException(e);
                }
            });
        }).toArray(Future<?>[]::new);;*/
    }
}
