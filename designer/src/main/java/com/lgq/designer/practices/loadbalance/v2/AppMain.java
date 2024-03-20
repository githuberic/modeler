package com.lgq.designer.practices.loadbalance.v2;

import java.util.List;

/**
 * @author lgq
 */
public class AppMain {
    public static void main(String[] args) {
        dispatch();
    }

    private static void dispatch() {
        ServerMashine serverMashine = new ServerImpl();
        List<Server> serverList = serverMashine.loadServer();

        Scheduler scheduler = new Random();
        String server = scheduler.getServer(serverList);
        System.out.println(">>>Random dispatch,Server=" + server);

        scheduler = new RoundRobin();
        server = scheduler.getServer(serverList);
        System.out.println(">>>RoundRobin dispatch,Server=" + server);
    }
}
