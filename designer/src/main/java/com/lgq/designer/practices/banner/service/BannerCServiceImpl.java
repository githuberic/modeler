package com.lgq.designer.practices.banner.service;

import com.lgq.designer.practices.banner.entity.Banner;
import com.lgq.designer.practices.banner.entity.Sponsor;

import java.util.ArrayList;
import java.util.List;

/**
 * @@author lgq
 */
public class BannerCServiceImpl implements BannerService {
    @Override
    public List<Banner> getBanners() {
        List<Banner> bannerList = new ArrayList<>();
        Sponsor sponsorC = new Sponsor("SP_C_001", "Sponsor_C", 5);
        bannerList.add(new Banner("C001", "https//www.coupon.com/imgs/zh/C0001.jpg", "https//www.coupon.com/prod/detail/C001", sponsorC));
        bannerList.add(new Banner("C002", "https//www.coupon.com/imgs/zh/C0002.jpg", "https//www.coupon.com/prod/detail/C002", sponsorC));
        bannerList.add(new Banner("C003", "https//www.coupon.com/imgs/zh/C0003.jpg", "https//www.coupon.com/prod/detail/C003", sponsorC));
        return bannerList;
    }
}
