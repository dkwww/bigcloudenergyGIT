package com.yidu.dao;

import com.yidu.domain.PmcDetails;

public interface PmcDetailsMapper {
    int deleteByPrimaryKey(String pdId);

    int insert(PmcDetails record);

    int insertSelective(PmcDetails record);

    PmcDetails selectByPrimaryKey(String pdId);

    int updateByPrimaryKeySelective(PmcDetails record);

    int updateByPrimaryKey(PmcDetails record);
}