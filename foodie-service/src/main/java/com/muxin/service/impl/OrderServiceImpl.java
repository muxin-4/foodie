package com.muxin.service.impl;

import com.muxin.enums.YesOrNo;
import com.muxin.mapper.OrderItemsMapper;
import com.muxin.mapper.OrdersMapper;
import com.muxin.pojo.*;
import com.muxin.pojo.bo.SubmitOrderBO;
import com.muxin.service.AddressService;
import com.muxin.service.ItemService;
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
  private OrderItemsMapper orderItemsMapper;

  @Autowired
  private AddressService addressService;

  @Autowired
  private ItemService itemService;

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
    String itemSpecIdArr[] = itemSpecIds.split(",");
    Integer totalAmount = 0; // 商品原价累计
    Integer realPayAmount = 0; // 优惠后实际支付价格累计
    for (String itemSpecId : itemSpecIdArr) {

      // TODO 整合redis后，商品购买的数量重新从redis的购物车中获取
      int buyCounts = 1;

      // 2.1 根据规格id，查询规格的具体信息，主要获取价格
      ItemsSpec itemSpec = itemService.queryItemSpecById(itemSpecId);
      totalAmount += itemSpec.getPriceNormal() * buyCounts;
      realPayAmount += itemSpec.getPriceDiscount() * buyCounts;

      // 2.2 根据规格id，获得商品信息以及商品图片
      String itemId = itemSpec.getItemId();
      Items item = itemService.queryItemById(itemId);
      String imgUrl = itemService.queryItemMainImgById(itemId);

      // 2.3 循环保存订单数据到数据库
      String subOrderId = sid.nextShort();
      OrderItems subOrderItem = new OrderItems();
      subOrderItem.setId(subOrderId);
      subOrderItem.setOrderId(orderId);
      subOrderItem.setItemId(itemId);
      subOrderItem.setItemName(item.getItemName());
      subOrderItem.setItemImg(imgUrl);
      subOrderItem.setBuyCounts(buyCounts);
      subOrderItem.setItemSpecId(itemSpecId);
      subOrderItem.setItemSpecName(itemSpec.getName());
      subOrderItem.setPrice(itemSpec.getPriceDiscount());
      orderItemsMapper.insert(subOrderItem);
    }

    newOrder.setTotalAmount(totalAmount);
    newOrder.setRealPayAmount(realPayAmount);
    ordersMapper.insert(newOrder);

    // 3. 保存订单状态表

  }
}
