package com.muxin.service;

import com.muxin.pojo.Category;
import com.muxin.pojo.UserAddress;
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

}
