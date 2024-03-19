package com.lgq.designer.practices.banner.dispatch;

import com.lgq.designer.practices.banner.entity.Sponsor;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * @author lgq
 */
public class HashScheduler implements Scheduler {

    private Map<Sponsor, Integer> serverMap;
    private Random random;

    public HashScheduler(Map<Sponsor, Integer> serverMap) {
        this.serverMap = serverMap;
        this.random = new Random();
    }

    @Override
    public Sponsor getNextServer() {
        int hashCode = random.nextInt();
        int index = Math.abs(hashCode % serverMap.size());
        Iterator<Map.Entry<Sponsor, Integer>> iterator = serverMap.entrySet().iterator();
        for (int i = 0; i < index; i++) {
            iterator.next();
        }
        return iterator.next().getKey();
    }
}
