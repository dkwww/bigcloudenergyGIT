package com.yidu.dao;

import com.yidu.domain.Audit;

public interface AuditMapper {
    int deleteByPrimaryKey(String audId);

    int insert(Audit record);

    int insertSelective(Audit record);

    Audit selectByPrimaryKey(String audId);

    int updateByPrimaryKeySelective(Audit record);

    int updateByPrimaryKey(Audit record);
}