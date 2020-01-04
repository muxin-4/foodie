package com.muxin.service;

import com.muxin.pojo.Items;
import com.muxin.pojo.ItemsImg;
import com.muxin.pojo.ItemsParam;
import com.muxin.pojo.ItemsSpec;

import java.util.List;


/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2020-01 20:51
 */
public interface ItemService {

    /**
     * 根据商品id查询详情
     *
     * @param id
     * @return
     */
    public Items queryItemById(String id);

    /**
     * 根据商品id查询商品图片列表
     *
     * @param itemId
     * @return
     */
    public List<ItemsImg> queryItemImgList(String itemId);


    /**
     * 根据商品id查询商品规格
     *
     * @param itemId
     * @return
     */
    public List<ItemsSpec> queryItemSpecList(String itemId);


    /**
     * 根据商品id查询商品参数
     *
     * @param itemId
     * @return
     */
    public List<ItemsParam> queryItemParam(String itemId);

}
