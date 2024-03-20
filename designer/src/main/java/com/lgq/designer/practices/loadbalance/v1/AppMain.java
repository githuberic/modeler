package com.lgq.designer.practices.loadbalance.v1;

/**
 * @author lgq
 */
public class AppMain {
    public static void main(String[] args) {
        String server = Random.getServer();
        System.out.println(">>>Server=" + server);

        server = RoundRobin.getServer();
        System.out.println(">>>Server=" + server);

        server = WeighRoundRobin.getServer();
        System.out.println(">>>Server=" + server);

        server = WeightRandom.getServer();
        System.out.println(">>>Server=" + server);
    }
}
