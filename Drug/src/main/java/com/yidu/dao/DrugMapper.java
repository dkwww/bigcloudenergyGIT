package com.yidu.dao;

import java.util.List;

import com.yidu.domain.Drug;

public interface DrugMapper {
    int deleteByPrimaryKey(String drugId);

    int insert(Drug record);

    int insertSelective(Drug record);

    Drug selectByPrimaryKey(String drugId);

    int updateByPrimaryKeySelective(Drug record);

    int updateByPrimaryKey(Drug record);
    
    List<Drug> selectBySelective(Drug record);
}