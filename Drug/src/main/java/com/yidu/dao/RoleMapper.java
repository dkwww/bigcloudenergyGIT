package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(Role role);

    int updateByPrimaryKey(Role record);
    
    List<Role> queryList(Map<String,Object> map);
    
    int queryCount(Role role);
    int batchdelete(List<String> ids);
}