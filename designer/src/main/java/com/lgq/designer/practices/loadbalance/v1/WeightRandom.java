package com.lgq.designer.practices.loadbalance.v1;

import java.util.*;
import java.util.Random;

/**
 * @author lgq
 * 加权随机
 */
public class WeightRandom {
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

        Random random = new Random();
        int randomPos = random.nextInt(listServer.size());
        return listServer.get(randomPos);
    }
}
