package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.BuyDetail;

public interface BuyDetailMapper {
    int deleteByPrimaryKey(String bdetId);

    int insert(BuyDetail record);

    int insertSelective(BuyDetail record);

    List<BuyDetail> selectByPrimaryKey(String bdetId);

    int updateByPrimaryKeySelective(BuyDetail record);

    int updateByPrimaryKey(BuyDetail record);
    
    /**
     * 显示列表
     * @return
     */
    List<BuyDetail> findAll();
    
    /**
     * 根据id查询所有
     * @param deta
     * @author 邓康威
     * @return
     */
    List<BuyDetail> showListId(Map<String,Object> map);
    
    /**
     * 查询所有行数
     * @param detail
     * @return
     */
    int selectCount(BuyDetail detail);
    
    /**
     * 根据id查询
     * @param id
     * @author 郑有宏
     * @return
     */
    List<BuyDetail> findById(String id);
    
    
    
    int deleteByPrimaryKeys(String buyId);
    
    /**
     * 根据id查询所有
     * @param deta
     * @author 邓康威
     * @return
     */
    List<BuyDetail> showListIds(Map<String,Object> map);
    
    /**
     * 根据id查询所有
     * @param buyId
     * @author 邓康威
     * @return
     */
	List<BuyDetail> findBuyId(String buyId);

	int updateByBuyId(BuyDetail detail);
}