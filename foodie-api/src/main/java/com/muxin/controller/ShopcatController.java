package com.muxin.controller;

import com.muxin.enums.YesOrNo;
import com.muxin.pojo.Carousel;
import com.muxin.pojo.Category;
import com.muxin.pojo.bo.ShopcartBO;
import com.muxin.pojo.vo.CategoryVO;
import com.muxin.pojo.vo.NewItemsVO;
import com.muxin.service.CarouselService;
import com.muxin.service.CategoryService;
import com.muxin.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2019-25 21:53
 */
@Api(value = "购物车接口controller", tags={ "购物车接口相关的api"})
@RequestMapping("shopcart")
@RestController
public class ShopcatController {

    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    @PostMapping("/add")
    public JSONResult add(
          @RequestParam String userId,
          @RequestBody ShopcartBO shopcartBO,
          HttpServletRequest request,
          HttpServletResponse response
      ) {
        if (StringUtils.isBlank(userId)) {
          return JSONResult.errorMsg("");
        }

        // TODO 前端用户在登录的情况下,添加商品到购物车，会同时在后端同步购物车到redis缓存

        return JSONResult.ok();
    }

  @ApiOperation(value = "从购物车中删除商品", notes = "从购物车中删除商品", httpMethod = "POST")
  @PostMapping("/del")
  public JSONResult del(
    @RequestParam String userId,
    @RequestBody String itemSpecId,
    HttpServletRequest request,
    HttpServletResponse response
  ) {
    if (StringUtils.isBlank(userId) || StringUtils.isBlank(itemSpecId)) {
      return JSONResult.errorMsg("参数不能为空");
    }

    // TODO 用户在删除购物车中的商品数据，如果此时用户已经登录，则需同步删除后端购物车中的商品

    return JSONResult.ok();
  }
}
