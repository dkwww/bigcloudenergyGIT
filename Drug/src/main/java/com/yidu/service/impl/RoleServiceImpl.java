package com.yidu.service.impl;

 
import com.yidu.controller.vo.Ztree;
import com.yidu.dao.ModuleMapper;
import com.yidu.dao.RoleMapper;
import com.yidu.domain.Module;
import com.yidu.domain.Role;
import com.yidu.service.RoleService;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class RoleServiceImpl   implements RoleService {
	@Resource
	private RoleMapper rolemapper;
	@Resource
	private ModuleMapper moMapper;
	@Override
	public List<Role> queryList(Role role, PageUtil pageUtil) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("role",role);
		map.put("page",pageUtil);
		return rolemapper.queryList(map);
	}

	@Override
	public int queryCount(Role role) {
		return rolemapper.queryCount(role);
	}

	@Override
	public List<Ztree> queryModule() {
		return moMapper.selectList();
	}

	@Override
	public List<Ztree> selectZtree(String id) {
		return moMapper.selectZtree(id);
	}

	@Override
	public int updateId(Role role) {
		role.setOptime(new Date());
		return rolemapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public int insert(Role role) {
		role.setOptime(new Date());
		role.setRoleId(Tools.getRandomString());
		role.setIsva("是");
		return rolemapper.insertSelective(role);
	}

	@Override
	public int batchdelete(List<String> ids) {
		return rolemapper.batchdelete(ids);
	}

	
}
