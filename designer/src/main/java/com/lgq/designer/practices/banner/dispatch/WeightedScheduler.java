package com.lgq.designer.practices.banner.dispatch;

import com.lgq.designer.practices.banner.entity.Sponsor;

import java.util.List;
import java.util.Random;

/**
 * @author lgq
 */
public class WeightedScheduler implements Scheduler {

    private List<Sponsor> servers;
    private Random random;
    private int totalWeight;

    public void WeightedScheduler(List<Sponsor> servers) {
        this.servers = servers;
        this.random = new Random();
        this.totalWeight = 0;
        for (Sponsor sponsor : servers) {
            totalWeight += sponsor.getWeight();
        }
    }

    @Override
    public Sponsor getNextServer() {
        int randWeight = random.nextInt(totalWeight);
        int index = servers.size() - 1;
        for (int i = 0; i < servers.size(); i++) {
            randWeight -= servers.get(i).getWeight();
            if (randWeight < 0) {
                index = i;
                break;
            }
        }
        return servers.get(index);
    }
}
