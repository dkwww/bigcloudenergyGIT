package com.yidu.dao;

import java.util.List;

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
    public List<BuyDetail> showList(BuyDetail deta);
}