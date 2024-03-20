package com.lgq.designer.practices.loadbalance.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 * 轮训调度
 */
public class RoundRobin implements Scheduler {

    private static Integer pos = 0;

    @Override
    public String getServer(List<Server> serverList) {
        // 重建一个List，避免服务器的上下线导致的并发问题
        List<Server> serverListNew = new ArrayList<>(serverList.size());
        serverListNew.addAll(serverList);

        Server server = null;
        synchronized (pos) {
            if (pos > serverListNew.size() - 1) {
                pos = 0;
            }
            server = serverListNew.get(pos);
            pos++;
        }
        return server.getIp();
    }
}
