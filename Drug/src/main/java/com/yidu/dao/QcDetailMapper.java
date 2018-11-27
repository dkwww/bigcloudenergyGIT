package com.yidu.dao;

import com.yidu.domain.QcDetail;

public interface QcDetailMapper {
    int deleteByPrimaryKey(String qdetId);

    int insert(QcDetail record);

    int insertSelective(QcDetail record);

    QcDetail selectByPrimaryKey(String qdetId);

    int updateByPrimaryKeySelective(QcDetail record);

    int updateByPrimaryKey(QcDetail record);
}