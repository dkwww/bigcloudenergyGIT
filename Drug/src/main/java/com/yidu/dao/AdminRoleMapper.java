package com.yidu.dao;

import com.yidu.domain.AdminRole;

public interface AdminRoleMapper {
    int deleteByPrimaryKey(String arId);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    AdminRole selectByPrimaryKey(String arId);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);
}