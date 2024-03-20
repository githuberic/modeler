package com.lgq.designer.practices.loadbalance.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author lgq
 */
public class Random {
    public static String getServer() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        HashMap<String, Integer> map = new HashMap<>();
        map.putAll(IpMap.getServerWeight());

        Set keySet = map.keySet();
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(keySet);

        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(arrayList.size());
        return arrayList.get(randomPos);
    }
}
