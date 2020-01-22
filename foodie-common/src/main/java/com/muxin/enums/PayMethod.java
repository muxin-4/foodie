package com.muxin.enums;

/**
 * @program: foodie
 * @description: 商品评价等级枚举
 * @author: Mr.Wang
 * @create: 2020-02 11:29
 */
public enum PayMethod {
    WEIXIN(1, "微信"),
    ALIPAY(2, "支付宝");

    public final Integer type;
    public final String value;

    PayMethod(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

}
