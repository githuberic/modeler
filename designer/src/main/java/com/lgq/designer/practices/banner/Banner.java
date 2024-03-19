package com.lgq.designer.practices.banner;

/**
 * @author lgq
 */
public class Banner {
    private String id;
    private String imageUrl;
    private String linkUrl;

    public Banner() {
    }

    public Banner(String id, String imageUrl, String linkUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.linkUrl = linkUrl;
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
}
