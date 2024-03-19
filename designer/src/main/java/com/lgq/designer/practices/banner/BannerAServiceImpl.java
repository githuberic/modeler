package com.lgq.designer.practices.banner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 */
public class BannerAServiceImpl implements BannerService {
    @Override
    public List<Banner> getBanners() {
        List<Banner> bannerList = new ArrayList<>();
        bannerList.add(new Banner("A001","https//www.coupon.com/imgs/zh/A0001.jpg","https//www.coupon.com/prod/detail/A001"));
        bannerList.add(new Banner("A002","https//www.coupon.com/imgs/zh/A0002.jpg","https//www.coupon.com/prod/detail/A002"));
        bannerList.add(new Banner("A003","https//www.coupon.com/imgs/zh/A0003.jpg","https//www.coupon.com/prod/detail/A003"));
        return bannerList;
    }
}
