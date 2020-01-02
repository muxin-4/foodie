package com.muxin.service;

import com.muxin.pojo.Carousel;

import java.util.List;

/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2020-01 20:51
 */
public interface CarouselService  {

    /**
     * 查询所有轮播图列表
     *
     * @param isShow
     * @return
     */
    public List<Carousel> queryAll(Integer isShow);


}
