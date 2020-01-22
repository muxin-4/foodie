package com.muxin.controller;

import com.muxin.enums.PayMethod;
import com.muxin.pojo.bo.SubmitOrderBO;
import com.muxin.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2019-25 21:53
 */
@Api(value = "订单相关", tags = {"订单相关的api接口"})
@RequestMapping("orders")
@RestController
public class OrdersController {


  @ApiOperation(value = "用户下单", notes = "用户下单", httpMethod = "POST")
  @PostMapping("/create")
  public JSONResult create(@RequestBody SubmitOrderBO submitOrderBO) {

    if (submitOrderBO.getPayMethod() != PayMethod.WEIXIN.type
        && submitOrderBO.getPayMethod() != PayMethod.ALIPAY.type) {
      return JSONResult.errorMsg("支付方式不支持!");
    }

    System.out.println(submitOrderBO.toString());

    // 1. 创建订单

    // 2. 移除购物车中已结算（已提交）的商品

    // 3. 向支付中心发送当前订单，用于保存支付中心的订单数据

    return JSONResult.ok();
  }

}
