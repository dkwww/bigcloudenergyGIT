package com.yidu.dao;

import java.util.List;
import java.util.Map;

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

	/**
	 * 查询
	 * @param map
	 * @return
	 */
	List<Admin> selectAll(Map<String, Object> map);

	int selectCount(Admin admin);
}