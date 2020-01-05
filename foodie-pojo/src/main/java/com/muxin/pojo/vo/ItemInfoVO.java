package com.muxin.pojo.vo;

import com.muxin.pojo.ItemParams;
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
    private List<ItemsImg> itemImgList;
    private List<ItemSpec> itemSpecList;
    private ItemParams itemParams;

    public ItemParams getItemParams() {
        return itemParams;
    }

    public void setItemParams(ItemParams itemParams) {
        this.itemParams = itemParams;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public List<ItemsImg> getItemImgList() {
        return itemImgList;
    }

    public void setItemImgList(List<ItemsImg> itemImgList) {
        this.itemImgList = itemImgList;
    }

    public List<ItemSpec> getItemSpecList() {
        return itemSpecList;
    }

    public void setItemSpecList(List<ItemSpec> itemSpecList) {
        this.itemSpecList = itemSpecList;
    }

}
