package com.muxin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.muxin.enums.CommentLevel;
import com.muxin.mapper.*;
import com.muxin.pojo.*;
import com.muxin.pojo.vo.CommentLevelCountsVO;
import com.muxin.pojo.vo.ItemCommentVO;
import com.muxin.pojo.vo.ShopcartVO;
import com.muxin.service.ItemService;
import com.muxin.utils.DesensitizationUtil;
import com.muxin.utils.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2020-01 22:47
 */
@Service
public class ItemServiceImpl implements ItemService {

  @Autowired
  private ItemsMapper itemsMapper;
  @Autowired
  private ItemsImgMapper itemsImgMapper;
  @Autowired
  private ItemsSpecMapper itemsSpecMapper;
  @Autowired
  private ItemsParamMapper itemsParamMapper;
  @Autowired
  private ItemsCommentsMapper itemsCommentsMapper;
  @Autowired
  private ItemsCustomMapper itemsCustomMapper;

  @Transactional(propagation = Propagation.SUPPORTS)
  @Override
  public Items queryItemById(String itemId) {
    return itemsMapper.selectByPrimaryKey(itemId);
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  @Override
  public List<ItemsImg> queryItemImgList(String itemId) {
    Example itemsImgExp = new Example(ItemsImg.class);
    Example.Criteria criteria = itemsImgExp.createCriteria();
    criteria.andEqualTo("itemId", itemId);

    return itemsImgMapper.selectByExample(itemsImgExp);
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  @Override
  public List<ItemSpec> queryItemSpecList(String itemId) {
    Example itemsSpecExp = new Example(ItemSpec.class);
    Example.Criteria criteria = itemsSpecExp.createCriteria();
    criteria.andEqualTo("itemId", itemId);

    return itemsSpecMapper.selectByExample(itemsSpecExp);
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  @Override
  public ItemParams queryItemParam(String itemId) {
    Example itemsParamExp = new Example(ItemParams.class);
    Example.Criteria criteria = itemsParamExp.createCriteria();
    criteria.andEqualTo("itemId", itemId);

    return itemsParamMapper.selectOneByExample(itemsParamExp);
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  @Override
  public CommentLevelCountsVO queryCommentCounts(String itemId) {

    Integer goodCounts = getCommentCounts(itemId, CommentLevel.GOOD.type);
    Integer normalCounts = getCommentCounts(itemId, CommentLevel.NORMAL.type);
    Integer badCounts = getCommentCounts(itemId, CommentLevel.BAD.type);
    Integer totalCounts = goodCounts + normalCounts + badCounts;

    CommentLevelCountsVO countsVO = new CommentLevelCountsVO();
    countsVO.setTotalCounts(totalCounts);
    countsVO.setGoodCounts(goodCounts);
    countsVO.setNormalCounts(normalCounts);
    countsVO.setBadCounts(badCounts);

    return countsVO;
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  Integer getCommentCounts(String itemId, Integer level) {
    ItemsComments condition = new ItemsComments();
    condition.setItemId(itemId);
    if (level != null) {
      condition.setCommentLevel(level);
    }

    return itemsCommentsMapper.selectCount(condition);
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  @Override
  public PagedGridResult queryPagedComment(String itemId,
                                           Integer level,
                                           Integer page,
                                           Integer pageSize) {

    Map<String, Object> map = new HashMap<>();
    map.put("itemId", itemId);
    map.put("level", level);

    // mybatis-pagehelper

    /**
     * page: 第几页
     * pageSize: 每页显示条数
     */
    PageHelper.startPage(page, pageSize);

    List<ItemCommentVO> list = itemsCustomMapper.queryItemComments(map);

    for (ItemCommentVO vo : list) {
      vo.setNickname(DesensitizationUtil.commonDisplay(vo.getNickname()));
    }

    return setterPagedGrid(list, page);
  }

  private PagedGridResult setterPagedGrid(List<?> list, Integer page) {
    PageInfo<?> pageList = new PageInfo<>(list);
    PagedGridResult grid = new PagedGridResult();
    grid.setPage(page);
    grid.setRows(list);
    grid.setTotal(pageList.getPages());
    grid.setRecords(pageList.getTotal());
    return grid;
  }


  @Transactional(propagation = Propagation.SUPPORTS)
  @Override
  public List<ShopcartVO> queryItemsBySpecIds(String specIds) {

    String ids[] = specIds.split(",");
    List<String> specIdsList = new ArrayList<>();
    Collections.addAll(specIdsList, ids);

    return itemsCustomMapper.queryItemsBySpecIds(specIdsList);
  }

}
