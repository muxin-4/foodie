package com.muxin.mapper;

import com.muxin.pojo.vo.CategoryVO;

import java.util.List;

public interface CategoryMapperCustom {

    public List<CategoryVO> getSubCatList(Integer rootCatId);

}
