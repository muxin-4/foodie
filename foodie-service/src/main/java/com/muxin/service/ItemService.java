package com.muxin.service;

import com.muxin.pojo.Items;
import com.muxin.pojo.ItemsImg;
import com.muxin.pojo.ItemParams;
import com.muxin.pojo.ItemsSpec;
import com.muxin.pojo.vo.CommentLevelCountsVO;
import com.muxin.pojo.vo.ShopcartVO;
import com.muxin.utils.PagedGridResult;

import java.util.List;


/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2020-01 20:51
 */
public interface ItemService {

  /**
   * 根据商品id查询详情
   *
   * @param id
   * @return
   */
  public Items queryItemById(String id);

  /**
   * 根据商品id查询商品图片列表
   *
   * @param itemId
   * @return
   */
  public List<ItemsImg> queryItemImgList(String itemId);


  /**
   * 根据商品id查询商品规格
   *
   * @param itemId
   * @return
   */
  public List<ItemsSpec> queryItemSpecList(String itemId);


  /**
   * 根据商品id查询商品参数
   *
   * @param itemId
   * @return
   */
  public ItemParams queryItemParam(String itemId);


  /**
   * 根据商品id查询商品的评价等级数量
   *
   * @param itemId
   */
  public CommentLevelCountsVO queryCommentCounts(String itemId);

  /**
   * 根据商品id查询商品的评价（分页）
   *
   * @param itemId
   * @param level
   * @return
   */
  public PagedGridResult queryPagedComment(String itemId, Integer level,
                                           Integer page, Integer pageSize);

  /**
   * 根据规格ids查询最新的购物车中商品数据（用于刷新渲染购物车中的商品数据）
   *
   * @param specIds
   * @return
   */
  public List<ShopcartVO> queryItemsBySpecIds(String specIds);

  /**
   * 根据商品规格id获取规格对象的具体信息
   *
   * @param specId
   * @return
   */
  public ItemsSpec queryItemSpecById(String specId);


  public String queryItemMainImgById(String itemId);

  /**
   * 减少库存
   *
   * @param specId
   * @param buyCounts
   */
  public void decreaseItemSpecStock(String specId, int buyCounts);
}
