package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.BuyDetail;

public interface BuyDetailMapper {
    int deleteByPrimaryKey(String bdetId);

    int insert(BuyDetail record);

    int insertSelective(BuyDetail record);

    BuyDetail selectByPrimaryKey(String bdetId);

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
    
}