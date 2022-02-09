package com.lgq.jpool.chapter01.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lgq
 */
@ConfigurationProperties(prefix = PoolProperties.PROJECT_PREFIX)
public class PoolProperties {
    public static final String PROJECT_PREFIX = "project.object";
    /**
     * 最大空闲
     */
    private int maxIdle = 5;
    /**
     * 最大总数
     */
    private int maxTotal = 20;
    /**
     * 最小空闲
     */
    private int minIdle = 2;
    /**
     * 初始化连接数
     */
    private int initialSize = 3;

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }
}
