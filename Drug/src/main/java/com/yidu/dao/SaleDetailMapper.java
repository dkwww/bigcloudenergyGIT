package com.yidu.dao;

import com.yidu.domain.SaleDetail;

public interface SaleDetailMapper {
    int deleteByPrimaryKey(String sdId);

    int insert(SaleDetail record);

    int insertSelective(SaleDetail record);

    SaleDetail selectByPrimaryKey(String sdId);

    int updateByPrimaryKeySelective(SaleDetail record);

    int updateByPrimaryKey(SaleDetail record);
}