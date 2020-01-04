package com.muxin.service;

import com.muxin.pojo.Category;
import com.muxin.pojo.vo.CategoryVO;
import java.util.List;

public interface CategoryService {

    /**
     * 查询所有一级分类
     *
     * @return
     */
    public List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类id查询子分类信息
     *
     * @param rootCatId
     * @return
     */
    public List<CategoryVO> getSubCatList(Integer rootCatId);


    /**
     * 查询首页每个一级分类下的6条最新商品数据
     *
     * @param rootCatId
     * @return
     */
    public List getSixNewItemsLazy(Integer rootCatId);

}
