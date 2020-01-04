package com.muxin.pojo.vo;

/**
 * @program: foodie
 * @description: 6 个最新商品的简单数据类型
 * @author: Mr.Wang
 * @create: 2020-04 12:04
 */
public class SimpleItemVO {

    private String rootCatName;
    private String itemId;
    private String itemName;
    private String itemUrl;

    public String getRootCatName() {
        return rootCatName;
    }

    public void setRootCatName(String rootCatName) {
        this.rootCatName = rootCatName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }
}
