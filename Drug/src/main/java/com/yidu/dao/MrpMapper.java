package com.yidu.dao;

import com.yidu.domain.Mrp;

public interface MrpMapper {
    int deleteByPrimaryKey(String mrpId);

    int insert(Mrp record);

    int insertSelective(Mrp record);

    Mrp selectByPrimaryKey(String mrpId);

    int updateByPrimaryKeySelective(Mrp record);

    int updateByPrimaryKey(Mrp record);
}