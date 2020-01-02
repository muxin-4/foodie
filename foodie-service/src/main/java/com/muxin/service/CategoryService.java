package com.muxin.service;

import com.muxin.pojo.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 查询所有一级分类
     *
     * @return
     */
    public List<Category> queryAllRootLevelCat();
}
