package com.yidu.service.impl;

 
import com.yidu.dao.AdminMapper;
import com.yidu.domain.Admin;
import com.yidu.domain.Company;
import com.yidu.service.AdminService;
import com.yidu.util.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台登陆管理员 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class AdminServiceImpl  implements AdminService {

	@Resource
	private AdminMapper mapper;
	
	
	/**
	 * 查询用户名和密码是否存在
	 */
	@Override
	public Admin queryNameOrPwd(Admin admin) {
		return mapper.queryNameOrPwd(admin);
	}


	@Override
	public List<Admin> findAll(Admin admin) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("admin", admin);
		return mapper.selectAll(map);
	}
}
