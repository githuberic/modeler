package com.lgq.designer.practices.jira_2678;

import com.lgq.designer.practices.jira_2678.stat.CookieStat;
import com.lgq.designer.practices.jira_2678.stat.StatInfo;
import com.lgq.designer.practices.jira_2678.utils.FileUtil;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lgq
 */
public class Jira2678 {

    public static void main(String[] args) throws MyException, InterruptedException {
        // 读取产品列表
        List<String> products = FileUtil.readFileByLines(Constants.PRODUCT_PATH);
        // 读取Cookie列表
        Queue<CookieStat> queueCookies = readCookie();
        StatInfo statInfo = new StatInfo();

        // 核心线程数
        int poolSize = Runtime.getRuntime().availableProcessors() * 2;
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        // 提交任务到线程池
        int chunkSize = products.size() / poolSize;
        for (int i = 0; i < products.size(); i += chunkSize) {
            int end = Math.min(i + chunkSize, products.size());
            List<String> subProducts = products.subList(i, end);
            executor.submit(new ScraperChunk(subProducts, queueCookies, statInfo));
        }

        // 关闭线程池，等待所有任务完成
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);

        /*
        for (String asin : products) {
            try {
                scrape(asin, queueCookies, statInfo);
            } catch (MyException e) {
                throw new RuntimeException(e);
            }
        }*/
    }

    private static Queue<CookieStat> readCookie() throws MyException {
        // 从文件中读取Cookies
        List<String> cookies = FileUtil.readFileByLines(Constants.COOKIE_PATH);

        // 加工成Queue
        Queue<CookieStat> statQueue = new ArrayDeque<>(cookies.size());
        for (String cookie : cookies) {
            statQueue.add(new CookieStat(cookie));
        }
        return statQueue;
    }
}
