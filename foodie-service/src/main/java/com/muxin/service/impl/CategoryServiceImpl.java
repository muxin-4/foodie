package com.muxin.service.impl;

import com.muxin.enums.ProductCategory;
import com.muxin.mapper.CategoryMapper;
import com.muxin.mapper.CategoryCustomMapper;
import com.muxin.pojo.Category;
import com.muxin.pojo.vo.CategoryVO;
import com.muxin.pojo.vo.NewItemsVO;
import com.muxin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2020-02 13:50
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryCustomMapper categoryCustomMapper;


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", ProductCategory.firstLevel.type);

        List<Category> result = categoryMapper.selectByExample(example);

        return result;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        return categoryCustomMapper.getSubCatList(rootCatId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId) {

        Map<String, Object> map = new HashMap<>();
        map.put("rootCatId", rootCatId);


        return categoryCustomMapper.getSixNewItemsLazy(map);
    }
}
