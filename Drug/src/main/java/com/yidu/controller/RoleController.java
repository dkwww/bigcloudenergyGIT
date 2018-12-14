package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.controller.vo.Ztree;
import com.yidu.domain.Module;
import com.yidu.domain.Role;
import com.yidu.service.ModuleRoleService;
import com.yidu.service.RoleService;
import com.yidu.util.PageUtil;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	@Resource
	private RoleService roleService;
	/**
	 * 查询所有角色
	 * @param role 角色模型
	 * @param page 当前页数
	 * @param limit 显示行数
	 * @return
	 */
	@RequestMapping("queryList")
	@ResponseBody
	public Map<String,Object> queryList(Role role,Integer page,Integer limit){
		PageUtil pageUtil=new PageUtil();
		if(page !=null && limit !=null){
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		List<Role> list=roleService.queryList(role,pageUtil);
		int rows=roleService.queryCount(role);
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	@RequestMapping("queryModule")
	@ResponseBody
	public List<Ztree> queryModule(){
		List<Ztree> list=roleService.queryModule();
		return list;
	}
}

