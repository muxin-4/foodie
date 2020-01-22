package com.muxin.service.impl;

import com.muxin.enums.YesOrNo;
import com.muxin.mapper.OrdersMapper;
import com.muxin.pojo.Orders;
import com.muxin.pojo.UserAddress;
import com.muxin.pojo.bo.SubmitOrderBO;
import com.muxin.service.AddressService;
import com.muxin.service.OrderService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrdersMapper ordersMapper;

  @Autowired
  private AddressService addressService;

  @Autowired
  private Sid sid;

  @Transactional(propagation = Propagation.REQUIRED)
  @Override
  public void createOrder(SubmitOrderBO submitOrderBO) {
    String userId = submitOrderBO.getUserId();
    String addressId = submitOrderBO.getAddressId();
    String itemSpecIds = submitOrderBO.getItemSpecIds();
    Integer payMethod = submitOrderBO.getPayMethod();
    String leftMsg = submitOrderBO.getLeftMsg();
    // 包邮费用设置为0
    Integer postAmount = 0;

    String orderId = sid.nextShort();

    UserAddress address = addressService.queryUserAddress(userId, addressId);

    // 1. 新订单数据保存
    Orders newOrder = new Orders();
    newOrder.setId(orderId);
    newOrder.setUserId(userId);

    newOrder.setReceiverName(address.getReceiver());
    newOrder.setReceiverMobile(address.getMobile());
    newOrder.setReceiverAddress(address.getProvince() + " " +
                                address.getCity() + " " +
                                address.getDistrict() + " " +
                                address.getDetail());

//    newOrder.setTotalAmount();
//    newOrder.setRealPayAmount();
    newOrder.setPostAmount(postAmount);

    newOrder.setPayMethod(payMethod);
    newOrder.setLeftMsg(leftMsg);

    newOrder.setIsComment(YesOrNo.NO.type);
    newOrder.setIsDelete(YesOrNo.NO.type);
    newOrder.setCreatedTime(new Date());
    newOrder.setUpdatedTime(new Date());

    // 2. 循环根据itemSpecIds保存订单商品信息表


    // 3. 保存订单状态表

  }
}
