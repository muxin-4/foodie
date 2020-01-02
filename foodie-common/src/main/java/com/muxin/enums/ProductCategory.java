package com.muxin.enums;

public enum ProductCategory {
    firstLevel(1, "一级"),
    secondLevel(2, "二级"),
    thirdLevel(3, "三级");

    public final Integer type;
    public final String value;

    ProductCategory(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
