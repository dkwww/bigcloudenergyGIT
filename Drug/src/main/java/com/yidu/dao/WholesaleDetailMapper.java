package com.yidu.dao;

import com.yidu.domain.WholesaleDetail;

public interface WholesaleDetailMapper {
    int deleteByPrimaryKey(String wdId);

    int insert(WholesaleDetail record);

    int insertSelective(WholesaleDetail record);

    WholesaleDetail selectByPrimaryKey(String wdId);

    int updateByPrimaryKeySelective(WholesaleDetail record);

    int updateByPrimaryKey(WholesaleDetail record);
}