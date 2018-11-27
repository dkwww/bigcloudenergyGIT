package com.yidu.dao;

import com.yidu.domain.BuyDetail;

public interface BuyDetailMapper {
    int deleteByPrimaryKey(String bdetId);

    int insert(BuyDetail record);

    int insertSelective(BuyDetail record);

    BuyDetail selectByPrimaryKey(String bdetId);

    int updateByPrimaryKeySelective(BuyDetail record);

    int updateByPrimaryKey(BuyDetail record);
}