package com.yidu.service.impl;

 
import com.yidu.dao.AdminMapper;
import com.yidu.domain.Admin;
import com.yidu.service.AdminService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;
import com.yidu.util.Tools;

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

	/**
	 * 查询所有，分页
	 */
	@Override
	public List<Admin> findAll(Admin admin,PageUtil pageUtil) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("admin", admin);
		map.put("pageUtil", pageUtil);
		List<Admin> list = mapper.selectAll(map);
		for (Admin admin2 : list) {
			admin2.setOptimestring(Tools.getTimeStr(admin2.getOptime()));
		}
		return list;
	}


	@Override
	public int selectCount(Admin admin) {
		return mapper.selectCount(admin);
	}

	@Override
	public int addOrUpdate(Admin admin) {
		if(admin.getAdminId()!=null && !"".equals(admin.getAdminId())) {
			return mapper.updateByPrimaryKeySelective(admin);
		}else {
			admin.setIsva("1");
			admin.setSort(TimeUtil.getStrDate());
			return mapper.insertSelective(admin);
		}
	}
	/**
	 * 批量删除
	 */
	@Override
	public int bulkUpdate(List<String> ids) {
		return mapper.bulkDeleteByPrimaryKeySelective(ids);
	}
}
