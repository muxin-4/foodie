package com.muxin.enums;

/**
 * @program: foodie
 * @description: 商品评价等级枚举
 * @author: Mr.Wang
 * @create: 2020-02 11:29
 */
public enum CommentLevel {
    GOOD(1, "好评"),
    NORMAL(2, "中评"),
    BAD(3, "差评");

    public final Integer type;
    public final String value;

    CommentLevel(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

}
