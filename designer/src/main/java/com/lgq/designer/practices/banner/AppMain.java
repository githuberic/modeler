package com.lgq.designer.practices.banner;

import com.lgq.designer.practices.banner.dispatch.RandomScheduler;
import com.lgq.designer.practices.banner.entity.Banner;
import com.lgq.designer.practices.banner.entity.Sponsor;
import com.lgq.designer.practices.banner.service.BannerAggregator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        // 获取所有的 Sponsor
        Map<String, Sponsor> sponsors = new HashMap<>();
        for (Banner banner : bannerList) {
            String sponsorId = banner.getSponsor().getId();
            if (!sponsors.containsKey(sponsorId)) {
                sponsors.put(sponsorId, banner.getSponsor());
            }
        }

        List<Sponsor> sponsorList = new ArrayList<>();
        for (Map.Entry<String, Sponsor> entry : sponsors.entrySet()) {
            sponsorList.add(entry.getValue());
        }

        RandomScheduler randomScheduler = new RandomScheduler(sponsorList);
        Sponsor sponsor = randomScheduler.getNextServer();

        List<Banner> subBannerList = bannerList.stream().filter(item -> item.getSponsor().getId().equals(sponsor.getId())).collect(Collectors.toList());
        for (Banner banner : subBannerList) {
            String strBanner = String.format("Id=%s\tImage=%s\turl=%s", banner.getId(), banner.getImageUrl(), banner.getLinkUrl());
            System.out.println(strBanner);
        }
    }
}
