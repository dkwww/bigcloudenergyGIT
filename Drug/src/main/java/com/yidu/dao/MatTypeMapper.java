package com.yidu.dao;

import com.yidu.domain.MatType;

public interface MatTypeMapper {
    int deleteByPrimaryKey(String mtId);

    int insert(MatType record);

    int insertSelective(MatType record);

    MatType selectByPrimaryKey(String mtId);

    int updateByPrimaryKeySelective(MatType record);

    int updateByPrimaryKey(MatType record);
}