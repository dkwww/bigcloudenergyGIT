package com.yidu.service.impl;

 
import com.yidu.dao.AdminMapper;
import com.yidu.dao.AdminRoleMapper;
import com.yidu.domain.Admin;
import com.yidu.domain.AdminRole;
import com.yidu.service.AdminService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;
import com.yidu.util.Tools;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
	/**
	 * 创建一个私有的mapper对象
	 */
	private AdminMapper mapper;
	
	@Resource
	/**
	 * 床一个私有的角色对象
	 */
	private AdminRoleMapper roleDao;
	
	/**
	 * 根据用户名和密码查询的方法
	 */
	@Override
	public Admin queryNameOrPwd(Admin admin) {
		//调用并返回查询用户名和密码的方法
		return mapper.queryNameOrPwd(admin);
	}

	/**
	 * 查询所有，分页
	 */
	@Override
	public List<Admin> findAll(Admin admin,PageUtil pageUtil) {
		//创建一个map集合
		Map<String, Object> map = new HashMap<String, Object>();
		
		//将对象admin传到map
		map.put("admin", admin);
		
		//把分页也传入到map
		map.put("pageUtil", pageUtil);
		
		//创建一个集合，调用查询所有的方法
		List<Admin> list = mapper.selectAll(map);
		
		//遍历admin对象
		for (Admin admin2 : list) {
			//时间格式转换
			admin2.setOptimestring(Tools.getTimeStr(admin2.getOptime()));
		}
		//返回一个list
		return list;
	}

	
	/**
	 * 查询行
	 */
	@Override
	public int selectCount(Admin admin) {
		//返回调用查询行的方法
		return mapper.selectCount(admin);
	}
	
	
	/**
	 * 增加修改的方法
	 */
	@Override
	public int addOrUpdate(Admin admin) {
		//如果用户id不为空
		if(admin.getAdminId()!=null && !"".equals(admin.getAdminId())) {
			//调用根据id删除的方法
			mapper.deleteById(admin.getAdminId());
			//定义一个变量，根据@截取
			String[] str = admin.getRoId().split("@");
			//遍历str
			for (int i = 0; i < str.length; i++) {
				//创建一个角色对象
				AdminRole adminRole = new AdminRole();
				//将用户id赋值给角色id
				adminRole.setAdminId(admin.getAdminId());
				//将数组赋值为角色id
				adminRole.setRoleId(str[i]);
				//调用增加角色的方法
				roleDao.insertSelective(adminRole);
			}
			//返回调用修改的方法
			return mapper.updateByPrimaryKeySelective(admin);
		}else {
			//创建一个uuid，将-替换成空
			String UUid = UUID.randomUUID().toString().replaceAll("-", "");
			//将uuid赋值到对象
			admin.setAdminId(UUid);
			//将值isva赋值1
			admin.setIsva("1");
			//默认增加当前时间
			admin.setOptime(new Date());
			//转换时间格式
			admin.setSort(TimeUtil.getStrDate());
			//调用增加的方法
			int row = mapper.insertSelective(admin);
			//创建一个数组根据@符号截取
			String[] str = admin.getRoId().split("@");
			//遍历变量str
			for (int i = 0; i < str.length; i++) {
				//创建一个角色对象
				AdminRole adminRole = new AdminRole();
				//将用户id赋值给角色id
				adminRole.setAdminId(admin.getAdminId());
				//将数组赋值给角色id
				adminRole.setRoleId(str[i]);
				//调用增加的方法
				roleDao.insertSelective(adminRole);
			}
			//返回row
			return row;
		}
	}
	
	
	/**
	 * 修改的方法
	 */
	@Override
	public int update(Admin admin) {
		
		//如果adminId不为空
		if(admin.getAdminId()!=null && !"".equals(admin.getAdminId())) {
			//调用并返回修改的方法
			return mapper.updateByPrimaryKeySelective(admin);
			
		} else {
			//否则返回0
			return 0;
		}
	}
	
	/**
	 * 批量删除
	 */
	@Override
	public int bulkUpdate(List<String> ids) {
		//调用批量删除的方法并返回
		return mapper.bulkDeleteByPrimaryKeySelective(ids);
	}

	
	
	/**
	 * 查询角色的方法
	 */
	@Override
	public List<AdminRole> findByRole(String id) {
		//调用查询角色的方法并返回
		return mapper.findByRole(id);
	}

	
	/**
	 * 删除
	 */
	@Override
	public int delete(Admin admin) {
		//调用修改的方法并返回
		return mapper.updateByPrimaryKeySelective(admin);
	}

	
	/**
	 * 根据id查询的方法
	 */
	@Override
	public Admin findById(String adminId) {
		//创建一个对象，调用根据id查询的方法
		Admin admin = mapper.selectByPrimaryKey(adminId);
		
		//把对象返回出去
		return admin;
	}
}
