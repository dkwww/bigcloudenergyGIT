package com.yidu.dao;

import com.yidu.domain.Pmc;

public interface PmcMapper {
    int deleteByPrimaryKey(String pmcId);

    int insert(Pmc record);

    int insertSelective(Pmc record);

    Pmc selectByPrimaryKey(String pmcId);

    int updateByPrimaryKeySelective(Pmc record);

    int updateByPrimaryKey(Pmc record);
}