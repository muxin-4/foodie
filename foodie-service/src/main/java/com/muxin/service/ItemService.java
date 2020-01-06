package com.muxin.service;

import com.muxin.pojo.Items;
import com.muxin.pojo.ItemsImg;
import com.muxin.pojo.ItemParams;
import com.muxin.pojo.ItemSpec;
import com.muxin.pojo.vo.CommentLevelCountsVO;
import com.muxin.pojo.vo.ItemCommentVO;
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
    public List<ItemSpec> queryItemSpecList(String itemId);


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
     * @param itemId
     * @param level
     * @return
     */
    public PagedGridResult queryPagedComment(String itemId, Integer level,
                                             Integer page, Integer pageSize);

}
