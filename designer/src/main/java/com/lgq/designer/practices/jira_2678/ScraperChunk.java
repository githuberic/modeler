package com.lgq.designer.practices.jira_2678;

import com.lgq.designer.practices.jira_2678.stat.CookieStat;
import com.lgq.designer.practices.jira_2678.stat.StatInfo;
import com.lgq.designer.practices.jira_2678.utils.LoggingUtil;

import java.util.List;
import java.util.Queue;

/***
 * @author lgq
 */
public class ScraperChunk implements Runnable {
    private final List<String> products;
    private Queue<CookieStat> cookieQueue;
    private StatInfo statInfo;

    public ScraperChunk(List<String> products, Queue<CookieStat> cookieQueue, StatInfo statInfo) {
        this.products = products;
        this.cookieQueue = cookieQueue;
        this.statInfo = statInfo;
    }

    @Override
    public void run() {
        for (String asin : products) {
            try {
                Scraper.scrape(asin, cookieQueue, statInfo);
            } catch (MyException e) {
                try {
                    LoggingUtil.logging(asin, null, statInfo, e);
                } catch (MyException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
