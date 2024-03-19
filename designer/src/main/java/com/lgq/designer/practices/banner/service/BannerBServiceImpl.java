package com.lgq.designer.practices.banner.service;

import com.lgq.designer.practices.banner.entity.Banner;
import com.lgq.designer.practices.banner.entity.Sponsor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 */
public class BannerBServiceImpl implements BannerService {
    @Override
    public List<Banner> getBanners() {
        List<Banner> bannerList = new ArrayList<>();
        Sponsor sponsorB = new Sponsor("SP_B_001", "Sponsor_B", 3);
        bannerList.add(new Banner("B001","https//www.coupon.com/imgs/zh/B0001.jpg","https//www.coupon.com/prod/detail/B001",sponsorB));
        bannerList.add(new Banner("B002","https//www.coupon.com/imgs/zh/B0002.jpg","https//www.coupon.com/prod/detail/B002",sponsorB));
        bannerList.add(new Banner("B003","https//www.coupon.com/imgs/zh/B0003.jpg","https//www.coupon.com/prod/detail/B003",sponsorB));
        return bannerList;
    }
}
