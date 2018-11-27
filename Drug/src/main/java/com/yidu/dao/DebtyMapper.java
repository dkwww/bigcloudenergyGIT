package com.yidu.dao;

import com.yidu.domain.Debty;

public interface DebtyMapper {
    int deleteByPrimaryKey(String debId);

    int insert(Debty record);

    int insertSelective(Debty record);

    Debty selectByPrimaryKey(String debId);

    int updateByPrimaryKeySelective(Debty record);

    int updateByPrimaryKey(Debty record);
}