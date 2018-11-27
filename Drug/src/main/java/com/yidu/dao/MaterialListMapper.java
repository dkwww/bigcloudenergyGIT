package com.yidu.dao;

import com.yidu.domain.MaterialList;

public interface MaterialListMapper {
    int deleteByPrimaryKey(String mlId);

    int insert(MaterialList record);

    int insertSelective(MaterialList record);

    MaterialList selectByPrimaryKey(String mlId);

    int updateByPrimaryKeySelective(MaterialList record);

    int updateByPrimaryKey(MaterialList record);
}