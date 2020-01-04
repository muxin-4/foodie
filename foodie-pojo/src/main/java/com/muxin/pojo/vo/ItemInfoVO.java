package com.muxin.pojo.vo;

import com.muxin.pojo.ItemParam;
import com.muxin.pojo.Items;
import com.muxin.pojo.ItemsImg;
import com.muxin.pojo.ItemSpec;

import java.util.List;

/**
 * @program: foodie
 * @description: 商品详情VO
 * @author: Mr.Wang
 * @create: 2020-04 12:04
 */
public class ItemInfoVO {

    private Items item;
    private List<ItemsImg> itemsImgList;
    private List<ItemSpec> itemSpecList;
    private ItemParam itemParam;

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public List<ItemsImg> getItemsImgList() {
        return itemsImgList;
    }

    public void setItemsImgList(List<ItemsImg> itemsImgList) {
        this.itemsImgList = itemsImgList;
    }

    public List<ItemSpec> getItemSpecList() {
        return itemSpecList;
    }

    public void setItemSpecList(List<ItemSpec> itemSpecList) {
        this.itemSpecList = itemSpecList;
    }

    public ItemParam getItemParam() {
        return itemParam;
    }

    public void setItemParam(ItemParam itemParam) {
        this.itemParam = itemParam;
    }
}
