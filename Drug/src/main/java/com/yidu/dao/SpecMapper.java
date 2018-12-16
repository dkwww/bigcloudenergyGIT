package com.yidu.dao;

import com.yidu.domain.Spec;

public interface SpecMapper {
    int deleteByPrimaryKey(String drugId);

    int insert(Spec record);

    int insertSelective(Spec record);

    Spec selectByPrimaryKey(String specId);

    int updateByPrimaryKeySelective(Spec record);

    int updateByPrimaryKey(Spec record);
}