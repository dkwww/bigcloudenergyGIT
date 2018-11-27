package com.yidu.dao;

import com.yidu.domain.DebtyDetail;

public interface DebtyDetailMapper {
    int deleteByPrimaryKey(String ddetId);

    int insert(DebtyDetail record);

    int insertSelective(DebtyDetail record);

    DebtyDetail selectByPrimaryKey(String ddetId);

    int updateByPrimaryKeySelective(DebtyDetail record);

    int updateByPrimaryKey(DebtyDetail record);
}