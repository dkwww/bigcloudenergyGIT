package com.yidu.dao;

import com.yidu.domain.ModuleRole;

public interface ModuleRoleMapper {
    int deleteByPrimaryKey(String mrId);

    int insert(ModuleRole record);

    int insertSelective(ModuleRole record);

    ModuleRole selectByPrimaryKey(String mrId);

    int updateByPrimaryKeySelective(ModuleRole record);

    int updateByPrimaryKey(ModuleRole record);
}