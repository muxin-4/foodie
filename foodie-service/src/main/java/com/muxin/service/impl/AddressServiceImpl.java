package com.muxin.service.impl;

import com.muxin.mapper.UserAddressMapper;
import com.muxin.pojo.UserAddress;
import com.muxin.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

  @Autowired
  private UserAddressMapper userAddressMapper;

  public List<UserAddress> queryAll(String userId) {
    UserAddress ua = new UserAddress();
    ua.setUserId(userId);

    return userAddressMapper.select(ua  );
  }


}
