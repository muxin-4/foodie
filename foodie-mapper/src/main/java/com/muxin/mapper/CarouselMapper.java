package com.muxin.mapper;

import com.muxin.my.mapper.MyMapper;
import com.muxin.pojo.Carousel;

public interface CarouselMapper extends MyMapper<Carousel> {
    @Override
    Carousel selectByPrimaryKey(Object o);
}
