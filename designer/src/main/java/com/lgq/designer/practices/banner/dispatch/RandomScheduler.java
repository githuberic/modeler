package com.lgq.designer.practices.banner.dispatch;

import com.lgq.designer.practices.banner.entity.Sponsor;

import java.util.List;
import java.util.Random;

/**
 * @author lgq;
 */
public class RandomScheduler implements Scheduler {
    private List<Sponsor> servers;
    private Random random;

    public RandomScheduler(List<Sponsor> servers) {
        this.servers = servers;
        random = new Random();
    }

    @Override
    public Sponsor getNextServer() {
        return servers.get(random.nextInt(servers.size()));
    }
}
