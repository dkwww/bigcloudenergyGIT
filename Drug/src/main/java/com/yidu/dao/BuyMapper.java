package com.yidu.dao;

import com.yidu.domain.Buy;

public interface BuyMapper {
    int deleteByPrimaryKey(String buyId);

    int insert(Buy record);

    int insertSelective(Buy record);

    Buy selectByPrimaryKey(String buyId);

    int updateByPrimaryKeySelective(Buy record);

    int updateByPrimaryKey(Buy record);
}