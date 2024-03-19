package com.lgq.designer.practices.banner.service;

import com.lgq.designer.practices.banner.entity.Banner;
import com.lgq.designer.practices.banner.entity.Sponsor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 */
public class BannerAServiceImpl implements BannerService {
    @Override
    public List<Banner> getBanners() {
        List<Banner> bannerList = new ArrayList<>();
        Sponsor sponsorA = new Sponsor("SP_A_001", "Sponsor_A", 1);
        bannerList.add(new Banner("A001", "https//www.coupon.com/imgs/zh/A0001.jpg", "https//www.coupon.com/prod/detail/A001", sponsorA));
        bannerList.add(new Banner("A002", "https//www.coupon.com/imgs/zh/A0002.jpg", "https//www.coupon.com/prod/detail/A002", sponsorA));
        bannerList.add(new Banner("A003", "https//www.coupon.com/imgs/zh/A0003.jpg", "https//www.coupon.com/prod/detail/A003", sponsorA));
        return bannerList;
    }
}
