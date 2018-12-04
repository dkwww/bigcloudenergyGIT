package com.yidu.dao;

import com.yidu.domain.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(String adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
     * 查询用户名密码是否存在
     * @param admin
     * @return
     */
	public Admin queryNameOrPwd(Admin admin);
}