package com.muxin.controller;

import com.muxin.pojo.*;
import com.muxin.pojo.vo.ItemInfoVO;
import com.muxin.service.ItemService;
import com.muxin.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2019-25 21:53
 */
@Api(value = "商品接口", tags = {"商品信息展示的相关接口"})
@RestController
@RequestMapping("items")
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public JSONResult info(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @PathVariable String itemId) {

        if (StringUtils.isBlank(itemId)) {
            return JSONResult.errorMsg("商品不存在");
        }

        Items item = itemService.queryItemById(itemId);
        List<ItemsImg> itemsImgList = itemService.queryItemImgList(itemId);
        List<ItemSpec> itemSpecList = itemService.queryItemSpecList(itemId);
        ItemParam itemParam = itemService.queryItemParam(itemId);


        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItem(item);
        itemInfoVO.setItemsImgList(itemsImgList);
        itemInfoVO.setItemSpecList(itemSpecList);
        itemInfoVO.setItemParam(itemParam);

        return JSONResult.ok(itemInfoVO);
    }


}
