package com.lgq.designer.practices.loadbalance.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 * 加权轮询调度
 */
public class WeightRoundRobin implements Scheduler {
    private static Integer pos = 0;

    @Override
    public String getServer(List<Server> serverList) {
        // 重建一个List，避免服务器的上下线导致的并发问题
        List<Server> serverListNew = new ArrayList<>(serverList.size());
        serverListNew.addAll(serverList);

        List<String> listServer = new ArrayList<>();
        for (Server server : serverListNew) {
            int weight = server.getWeight();
            for (int i = 0; i < weight; i++) {
                listServer.add(server.getIp());
            }
        }

        String server = null;
        synchronized (pos) {
            if (pos > listServer.size() - 1) {
                pos = 0;
            }
            server = listServer.get(pos);
            pos++;
        }
        return server;
    }
}
