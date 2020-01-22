package com.muxin.service.impl;

import com.muxin.enums.YesOrNo;
import com.muxin.mapper.AddressMapper;
import com.muxin.pojo.UserAddress;
import com.muxin.pojo.bo.AddressBO;
import com.muxin.service.AddressService;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

  @Autowired
  private AddressMapper addressMapper;

  @Autowired
  private Sid sid;

  @Transactional(propagation = Propagation.SUPPORTS)
  @Override
  public List<UserAddress> queryAll(String userId) {
    UserAddress ua = new UserAddress();
    ua.setUserId(userId);

    return addressMapper.select(ua);
  }

  @Transactional(propagation = Propagation.REQUIRED)
  @Override
  public void addNewUserAddress(AddressBO addressBO) {

    // 1. 判断当前用户是否存在地址，如果没有，则新增为'默认地址'
    Integer isDefault = 0;
    List<UserAddress> addressList = this.queryAll(addressBO.getUserId());
    if(addressList == null || addressList.isEmpty() || addressList.size() == 0) {
      isDefault = 1;
    }

    String addressId = sid.nextShort();

    // 2. 保存到数据库
    UserAddress newAddress = new UserAddress();
    BeanUtils.copyProperties(addressBO, newAddress);

    newAddress.setId(addressId);
    newAddress.setIsDefault(isDefault);
    newAddress.setCreatedTime(new Date());
    newAddress.setUpdatedTime(new Date());

    addressMapper.insert(newAddress);
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  @Override
  public void updateUserAddress(AddressBO addressBO) {
    String addressId = addressBO.getAddressId();

    UserAddress pendingAddress = new UserAddress();
    BeanUtils.copyProperties(addressBO, pendingAddress);

    pendingAddress.setId(addressId);
    pendingAddress.setUpdatedTime(new Date());

    addressMapper.updateByPrimaryKeySelective(pendingAddress);
  }

  @Transactional(propagation = Propagation.REQUIRED)
  @Override
  public void deleteUserAddress(String userId, String addressId) {
    UserAddress address = new UserAddress();
    address.setId(addressId);
    address.setUserId(userId);

    addressMapper.delete(address);
  }

  @Transactional(propagation = Propagation.REQUIRED)
  @Override
  public void updateUserAddressToBeDefault(String userId, String addressId) {

    // 1. 查找默认地址,设置为不默认
    UserAddress queryAddress = new UserAddress();
    queryAddress.setUserId(userId);
    queryAddress.setIsDefault(YesOrNo.YES.type);
    List<UserAddress> list = addressMapper.select(queryAddress);
    for (UserAddress ua : list) {
      ua.setIsDefault(YesOrNo.NO.type);
      addressMapper.updateByPrimaryKeySelective(ua);
    }

    // 2. 根据地址id修改为默认的地址
    UserAddress defaultAddress = new UserAddress();
    defaultAddress.setId(addressId);
    defaultAddress.setUserId(userId);
    defaultAddress.setIsDefault(YesOrNo.YES.type);
    addressMapper.updateByPrimaryKeySelective(defaultAddress);
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  @Override
  public UserAddress queryUserAddress(String userId, String addressId) {

    UserAddress singleAddress = new UserAddress();
    singleAddress.setId(addressId);
    singleAddress.setUserId(userId);

    return addressMapper.selectOne(singleAddress);
  }
}
