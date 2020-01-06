package com.muxin.controller;

import com.muxin.pojo.*;
import com.muxin.pojo.vo.CommentLevelCountsVO;
import com.muxin.pojo.vo.ItemInfoVO;
import com.muxin.service.ItemService;
import com.muxin.utils.JSONResult;
import com.muxin.utils.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
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
@Api(value = "商品接口", tags = {"商品信息展示的相关接口"})
@RestController
@RequestMapping("items")
public class ItemsController extends BaseController {

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
        List<ItemsImg> itemImgList = itemService.queryItemImgList(itemId);
        List<ItemSpec> itemSpecList = itemService.queryItemSpecList(itemId);
        ItemParams itemParams = itemService.queryItemParam(itemId);


        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItem(item);
        itemInfoVO.setItemImgList(itemImgList);
        itemInfoVO.setItemSpecList(itemSpecList);
        itemInfoVO.setItemParams(itemParams);

        return JSONResult.ok(itemInfoVO);
    }

    @ApiOperation(value = "查询商品评价等级", notes = "查询商品评价等级", httpMethod = "GET")
    @GetMapping("/commentLevel")
    public JSONResult commentLevel(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @RequestParam String itemId) {

        if (StringUtils.isBlank(itemId)) {
            return JSONResult.errorMsg(null);
        }

        CommentLevelCountsVO countsVO = itemService.queryCommentCounts(itemId);

        return JSONResult.ok(countsVO);
    }

    @ApiOperation(value = "查询商品评论", notes = "查询商品评论", httpMethod = "GET")
    @GetMapping("/comments")
    public JSONResult comments(
      @ApiParam(name = "itemId", value = "商品id", required = true)
      @RequestParam String itemId,
      @ApiParam(name = "level", value = "评价等级", required = false)
      @RequestParam Integer level,
      @ApiParam(name = "page", value = "当前第几页", required = false)
      @RequestParam Integer page,
      @ApiParam(name = "pageSize", value = "分页页数", required = false)
      @RequestParam Integer pageSize) {

      if (StringUtils.isBlank(itemId)) {
        return JSONResult.errorMsg(null);
      }

      if (page == null) {
          page = 1;
      }

      if (pageSize == null) {
          pageSize = COMMENT_PAGE_SIZE;
      }

      PagedGridResult grid = itemService.queryPagedComment(itemId, level, page, pageSize);

      return JSONResult.ok(grid);
    }
}
