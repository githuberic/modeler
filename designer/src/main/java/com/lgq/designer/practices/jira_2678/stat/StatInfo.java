package com.lgq.designer.practices.jira_2678.stat;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lgq
 */
public class StatInfo {

    private final AtomicInteger totalCount;
    private final AtomicInteger successCount;
    private final AtomicInteger failCount;

    public StatInfo() {
        totalCount = new AtomicInteger(0);
        successCount = new AtomicInteger(0);
        failCount = new AtomicInteger(0);
    }

    public StatInfo(AtomicInteger totalCount, AtomicInteger successCount, AtomicInteger failCount) {
        this.totalCount = totalCount;
        this.successCount = successCount;
        this.failCount = failCount;
    }

    public int getTotal() {
        return totalCount.get();
    }

    public int getSuccessCount() {
        return successCount.get();
    }

    public int getFailCount() {
        return failCount.get();
    }

    public void incrTotal() {
        totalCount.incrementAndGet();
    }

    public void incrSuccessCount() {
        successCount.incrementAndGet();
    }

    public void incrFailCount() {
        failCount.incrementAndGet();
    }
}
