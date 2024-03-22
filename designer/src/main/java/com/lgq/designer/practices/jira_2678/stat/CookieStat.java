package com.lgq.designer.practices.jira_2678.stat;

/**
 * @author lgq
 */
public class CookieStat {
    private String cookie;
    private static int failureCount = 0;

    public CookieStat(String cookie) {
        CookieStat(cookie, 0);
    }

    public void CookieStat(String cookie, int failureCount) {
        this.cookie = cookie;
        this.failureCount = failureCount;
    }

    public int getFailureCount() {
        return this.failureCount;
    }

    public String getCookie() {
        return this.cookie;
    }

    public void incrFailCount() {
        failureCount++;
    }
}
