package com.lgq.designer.practices.loadbalance.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 * 初始化服务器列表
 */
public class ServerImpl implements ServerMashine {
    @Override
    public List<Server> loadServer() {

        List<Server> serverList = new ArrayList<>();
        serverList.add(new Server("192.168.1.100", 1));
        serverList.add(new Server("192.168.1.101", 1));

        // 权重为2
        serverList.add(new Server("192.168.1.102", 2));
        serverList.add(new Server("192.168.1.103", 2));
        serverList.add(new Server("192.168.1.104", 2));

        // 权重为3
        serverList.add(new Server("192.168.1.105", 3));
        serverList.add(new Server("192.168.1.106", 3));

        // 权重为4
        serverList.add(new Server("192.168.1.107", 4));
        serverList.add(new Server("192.168.1.108", 4));
        serverList.add(new Server("192.168.1.109", 4));
        serverList.add(new Server("192.168.1.110", 4));

        return serverList;
    }
}
