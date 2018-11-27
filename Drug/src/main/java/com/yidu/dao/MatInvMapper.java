package com.yidu.dao;

import com.yidu.domain.MatInv;

public interface MatInvMapper {
    int deleteByPrimaryKey(String miId);

    int insert(MatInv record);

    int insertSelective(MatInv record);

    MatInv selectByPrimaryKey(String miId);

    int updateByPrimaryKeySelective(MatInv record);

    int updateByPrimaryKey(MatInv record);
}