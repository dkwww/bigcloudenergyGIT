package com.yidu.dao;

import com.yidu.domain.Wholesale;

public interface WholesaleMapper {
    int deleteByPrimaryKey(String wholId);

    int insert(Wholesale record);

    int insertSelective(Wholesale record);

    Wholesale selectByPrimaryKey(String wholId);

    int updateByPrimaryKeySelective(Wholesale record);

    int updateByPrimaryKey(Wholesale record);
}