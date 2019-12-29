package com.muxin.enums;

/**
 * @program: foodie
 * @description: 性别 枚举
 * @author: Mr.Wang
 * @create: 2019-28 22:47
 */
public enum Sex {
    woman(0, "女"),
    man(1, "男"),
    secret(2, "保密");

    public final Integer type;
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
