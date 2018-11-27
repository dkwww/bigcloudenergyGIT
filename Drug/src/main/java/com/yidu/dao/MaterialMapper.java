package com.yidu.dao;

import com.yidu.domain.Material;

public interface MaterialMapper {
    int deleteByPrimaryKey(String matId);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(String matId);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}