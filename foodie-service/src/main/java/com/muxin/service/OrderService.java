package com.muxin.service;

import com.muxin.pojo.Carousel;
import com.muxin.pojo.bo.SubmitOrderBO;

import java.util.List;

/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2020-01 20:51
 */
public interface OrderService {

  /**
   * 用于创建订单相关信息
   *
   * @param submitOrderBO
   * @return
   */
  public String createOrder(SubmitOrderBO submitOrderBO);
}
