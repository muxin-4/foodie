package com.muxin.service;

import com.muxin.pojo.Category;
import com.muxin.pojo.UserAddress;
import com.muxin.pojo.bo.AddressBO;
import com.muxin.pojo.vo.CategoryVO;
import com.muxin.pojo.vo.NewItemsVO;

import java.util.List;

public interface AddressService {

  /**
   * 根据用户id查询用户的收货地址列表
   *
   * @return
   */
  public List<UserAddress> queryAll(String userId);


  /**
   * 用户新增地址
   *
   * @param addressBO
   */
  public void addNewUserAddress(AddressBO addressBO);

  /**
   * 用户修改地址
   *
   * @param addressBO
   */
  public void updateUserAddress(AddressBO addressBO);


  /**
   * 根据用户id和地址id，删除对应的用户地址信息
   *
   * @param userId
   * @param addressId
   */
  public void deleteUserAddress(String userId, String addressId);
}
