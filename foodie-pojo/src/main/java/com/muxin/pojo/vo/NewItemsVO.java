package com.muxin.pojo.vo;

import java.util.List;

/**
 * 最新商品VO
 */
public class NewItemsVO {

        private Integer rootCatId;
        private Integer rootCatName;
        private Integer slogan;
        private Integer catImage;
        private Integer bgColor;

        private List<SimpleItemVO> simpleItemList;

    public Integer getRootCatId() {
        return rootCatId;
    }

    public void setRootCatId(Integer rootCatId) {
        this.rootCatId = rootCatId;
    }

    public Integer getRootCatName() {
        return rootCatName;
    }

    public void setRootCatName(Integer rootCatName) {
        this.rootCatName = rootCatName;
    }

    public Integer getSlogan() {
        return slogan;
    }

    public void setSlogan(Integer slogan) {
        this.slogan = slogan;
    }

    public Integer getCatImage() {
        return catImage;
    }

    public void setCatImage(Integer catImage) {
        this.catImage = catImage;
    }

    public Integer getBgColor() {
        return bgColor;
    }

    public void setBgColor(Integer bgColor) {
        this.bgColor = bgColor;
    }

    public List<SimpleItemVO> getSimpleItemList() {
        return simpleItemList;
    }

    public void setSimpleItemList(List<SimpleItemVO> simpleItemList) {
        this.simpleItemList = simpleItemList;
    }
}
