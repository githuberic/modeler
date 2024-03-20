package com.lgq.designer.practices.loadbalance.v2;

import java.util.List;

/**
 * @author lgq
 * 负载均衡调度接口
 */
public interface Scheduler {
    /**
     * 获取服务器IP地址
     *
     * @param serverList 服务器列表
     * @return 服务器IP地址
     */
    public String getServer(List<Server> serverList);
}
