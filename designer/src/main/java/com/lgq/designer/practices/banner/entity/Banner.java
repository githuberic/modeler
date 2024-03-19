package com.lgq.designer.practices.banner.entity;

/**
 * @author lgq
 */
public class Banner {
    private String id;
    private String imageUrl;
    private String linkUrl;
    private Sponsor sponsor;

    public Banner() {
    }

    public Banner(String id, String imageUrl, String linkUrl, Sponsor sponsor) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.linkUrl = linkUrl;
        this.sponsor = sponsor;
    }

    public String getId() {
        return this.id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public Sponsor getSponsor() {
        return this.sponsor;
    }
}
