package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Admin;
import com.yidu.domain.AdminRole;

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
	/**
	 * 查询行
	 * @param admin
	 * @return
	 */
	int selectCount(Admin admin);
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	int bulkDeleteByPrimaryKeySelective(List<String> ids);
	
	/**
	 * 根据用户ID查询角色
	 * @param id
	 * @return
	 */
	List<AdminRole> findByRole(String id);
	
	/**
	 * 根据用户ID删除角色
	 * @param adminId
	 * @return
	 */
	int deleteById(String adminId);
}