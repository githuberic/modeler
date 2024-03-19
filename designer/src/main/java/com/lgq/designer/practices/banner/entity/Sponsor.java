package com.lgq.designer.practices.banner.entity;

/**
 * @author lgq
 * 广告主;
 */
public class Sponsor {
    public String id;
    private String name;
    private int weight;

    public Sponsor() {
    }

    public Sponsor(String id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }
}
