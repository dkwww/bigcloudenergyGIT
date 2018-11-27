package com.yidu.dao;

import com.yidu.domain.DrugInvDetail;

public interface DrugInvDetailMapper {
    int deleteByPrimaryKey(String didId);

    int insert(DrugInvDetail record);

    int insertSelective(DrugInvDetail record);

    DrugInvDetail selectByPrimaryKey(String didId);

    int updateByPrimaryKeySelective(DrugInvDetail record);

    int updateByPrimaryKey(DrugInvDetail record);
}