package com.yidu.dao;

import com.yidu.domain.MatInvDetail;

public interface MatInvDetailMapper {
    int deleteByPrimaryKey(String midId);

    int insert(MatInvDetail record);

    int insertSelective(MatInvDetail record);

    MatInvDetail selectByPrimaryKey(String midId);

    int updateByPrimaryKeySelective(MatInvDetail record);

    int updateByPrimaryKey(MatInvDetail record);
}