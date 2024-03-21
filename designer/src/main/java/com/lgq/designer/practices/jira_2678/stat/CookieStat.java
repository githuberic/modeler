package com.lgq.designer.practices.jira_2678.stat;

/**
 * @author lgq
 */
public class CookieStat {
    private String cookie;
    private int failureCount;

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
}
