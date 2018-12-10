package com.yidu.service;

import java.util.List;

import com.yidu.domain.Admin;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 后台登陆管理员 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface AdminService   {

	
	/**
	 * 查询用户名和密码是否存在
	 * @param admin
	 * @return
	 */
	public Admin queryNameOrPwd(Admin admin);
	
	/**
	 * 查询
	 * @param pageUtil 
	 * @param user
	 * @return
	 */
	public List<Admin> findAll(Admin admin, PageUtil pageUtil);

	public int selectCount(Admin admin);

}
