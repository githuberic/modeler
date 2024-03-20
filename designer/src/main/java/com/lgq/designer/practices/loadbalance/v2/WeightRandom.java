package com.lgq.designer.practices.loadbalance.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author lgq
 * 加权随机调度
 */
public class WeightRandom implements Scheduler {
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

        Random random = new Random();
        int randomPos = random.nextInt(listServer.size());
        return listServer.get(randomPos);
    }
}
