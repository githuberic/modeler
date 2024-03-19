package com.lgq.designer.practices.banner.dispatch;

import com.lgq.designer.practices.banner.entity.Sponsor;

import java.util.List;
import java.util.Random;

/**
 * @author lgq
 */
public class RoundRobinScheduler implements Scheduler {
    private List<Sponsor> servers;
    private int curIndex = 0;

    public RoundRobinScheduler(List<Sponsor> servers) {
        this.servers = servers;
        this.curIndex = 0;
    }

    @Override
    public Sponsor getNextServer() {
        int index = curIndex;
        curIndex = (index + 1) % servers.size();
        return servers.get(index);
    }
}
