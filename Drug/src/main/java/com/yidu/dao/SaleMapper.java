package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Sale;

public interface SaleMapper {
    int deleteByPrimaryKey(String saleId);

    int insert(Sale record);

    int insertSelective(Sale record);

    Sale selectByPrimaryKey(String saleId);

    int updateByPrimaryKeySelective(Sale record);

    int updateByPrimaryKey(Sale record);
}