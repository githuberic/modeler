package com.lgq.designer.practices.loadbalance.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 * 随机调度
 */
public class Random implements Scheduler {

    @Override
    public String getServer(List<Server> serverList) {
        // 重建一个List，避免服务器的上下线导致的并发问题
        List<Server> serverListNew = new ArrayList<>(serverList.size());
        serverListNew.addAll(serverList);

        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(serverListNew.size());
        Server server = serverListNew.get(randomPos);
        return server.getIp();
    }
}
