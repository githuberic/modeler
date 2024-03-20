package com.lgq.designer.practices.loadbalance.v2;

/**
 * @author lgq
 * 服务器业务
 */
public class Server {
    private String ip;
    private int weight;

    public Server() {
    }

    public Server(String ip, int weight) {
        this.ip = ip;
        this.weight = weight;
    }

    public String getIp() {
        return this.ip;
    }

    public int getWeight() {
        return this.weight;
    }
}
