package com.yidu.dao;

import com.yidu.domain.DrugType;

public interface DrugTypeMapper {
    int deleteByPrimaryKey(String dtId);

    int insert(DrugType record);

    int insertSelective(DrugType record);

    DrugType selectByPrimaryKey(String dtId);

    int updateByPrimaryKeySelective(DrugType record);

    int updateByPrimaryKey(DrugType record);
}