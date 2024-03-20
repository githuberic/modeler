package com.lgq.designer.practices.loadbalance.v1;

import java.util.*;

/**
 * @author lgq
 * 加权轮询
 */
public class WeighRoundRobin {
    private static Integer pos = 0;

    public static String getServer() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        HashMap<String, Integer> map = new HashMap<>();
        map.putAll(IpMap.getServerWeight());

        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();

        List<String> listServer = new ArrayList<>();
        while (iterator.hasNext()) {
            String server = iterator.next().toString();
            int weight = map.get(server);
            for (int i = 0; i < weight; i++) {
                listServer.add(server);
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
