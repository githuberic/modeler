package com.lgq.designer.practices.banner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 */
public class BannerAggregator {
    private List<BannerService> services;

    public BannerAggregator() {
        services = new ArrayList<>();
        services.add(new BannerAServiceImpl());
        services.add(new BannerBServiceImpl());
        services.add(new BannerCServiceImpl());
    }

    public List<Banner> getAllBanners() {
        List<Banner> bannerList = new ArrayList<>();
        for (BannerService service : services) {
            bannerList.addAll(service.getBanners());
        }
        return bannerList;
    }
}
