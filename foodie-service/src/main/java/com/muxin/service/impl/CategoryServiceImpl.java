package com.muxin.service.impl;

import com.muxin.enums.ProductCategory;
import com.muxin.mapper.CategoryMapper;
import com.muxin.pojo.Category;
import com.muxin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

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

    @Override
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", ProductCategory.firstLevel.type);

        List<Category> result = categoryMapper.selectByExample(example);

        return result;
    }
}
