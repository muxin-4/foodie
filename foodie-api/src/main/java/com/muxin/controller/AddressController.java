package com.muxin.controller;

import com.muxin.pojo.UserAddress;
import com.muxin.service.AddressService;
import com.muxin.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2019-25 21:53
 */
@Api(value = "地址相关", tags={ "地址相关的api接口"})
@RequestMapping("address")
@RestController
public class AddressController {

  /**
   * 用户在确认订单页面，可以针对收货地址做如下操作：
   * 1. 查询用户的所有收货地址列表
   * 2. 新增收货地址
   * 3. 删除收货地址
   * 4. 修改收货地址
   * 5. 设置默认地址
   *
   */

  @Autowired
  private AddressService addressService;

  @ApiOperation(value = "根据用户id查询收货地址列表", notes = "根据用户id查询收货地址列表", httpMethod = "POST")
  @PostMapping("/list")
  public JSONResult list(
    @RequestParam String userId) {

    if (StringUtils.isBlank(userId)) {
      return JSONResult.errorMsg("");
    }

    List<UserAddress> list = addressService.queryAll(userId);
    return JSONResult.ok(list);
  }

}
