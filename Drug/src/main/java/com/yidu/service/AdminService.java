package com.yidu.service;

import com.yidu.domain.Admin;

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

}
