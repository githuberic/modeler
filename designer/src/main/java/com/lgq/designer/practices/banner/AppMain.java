package com.lgq.designer.practices.banner;

import java.util.List;

/**
 * @author lgq
 */
public class AppMain {
    public static void main(String[] args) {
        showBanner();
    }


    private static void showBanner() {
        BannerAggregator bannerAggregator = new BannerAggregator();
        List<Banner> bannerList = bannerAggregator.getAllBanners();
        for (Banner banner : bannerList) {
            String strBanner = String.format("Id=%s,Image=%s,url=%s", banner.getId(), banner.getImageUrl(), banner.getLinkUrl());
            System.out.println(strBanner);
        }
    }
}
