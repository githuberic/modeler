package com.lgq.designer.practices.loadbalance.v2;

import java.util.List;

/**
 * @author lgq
 * 服务器接口
 */
public interface ServerMashine {
    /**
     * 加载服务器
     *
     * @return 服务器列表
     */
    public List<Server> loadServer();
}
