package com.imooc.mapper;

import com.imooc.my.mapper.MyMapper;
import com.imooc.pojo.Carousel;

public interface CarouselMapper extends MyMapper<Carousel> {
    @Override
    Carousel selectByPrimaryKey(Object o);
}
