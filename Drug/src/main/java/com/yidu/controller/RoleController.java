package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.controller.vo.Ztree;
import com.yidu.domain.Admin;
import com.yidu.domain.Module;
import com.yidu.domain.ModuleRole;
import com.yidu.domain.Role;
import com.yidu.service.ModuleRoleService;
import com.yidu.service.RoleService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	@Resource
	private ModuleRoleService moroService;
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
	/**
	 * 角色表和角色模块表增加修改的方法
	 * @param request
	 * @param role
	 * @param moduleId
	 * @return
	 */
	@RequestMapping("updateId")
	@ResponseBody
	public Message updateId(HttpServletRequest request,@RequestBody Role role) {
		System.out.println("测试+++++++++++++"+role.getModuleId());
		HttpSession session=request.getSession();
		ModuleRole moduleRoler=new ModuleRole();
		int rows=0;
		//定义一个随机字符串用于角色模块表的增加赋值
		String roleId=Tools.getRandomString();
		//根据，拆分模块id
		String[] split=role.getModuleId().split(",");
		//获取到当前登陆用户的对象
		Admin user=(Admin) session.getAttribute("admin");
		if(user!=null&&!"".equals(user)) {
			//给操作人赋予当前登陆用户的名称
			role.setOper(user.getAdminName());
		}
		//根据角色Id是否为空来判断修改或增加
		if(role.getRoleId()!=null&&!"".equals(role.getRoleId())) {
			//根据角色ID删除和他关联的模块
			int dele=moroService.deleteId(role.getRoleId());
			//判断模块id不为空
			if(role.getModuleId()!=null&&!"".equals(role.getModuleId())) {
				//循环拆分的模块数组
				for (int i = 0; i < split.length; i++) {
					moduleRoler.setModeId(split[i]);
					moduleRoler.setRoleId(role.getRoleId());
					moduleRoler.setMrId(Tools.getRandomString());
					//增加模块
					int add=moroService.insert(moduleRoler);
				}
			}

			//修改角色
			rows=roleService.updateId(role);
		}else {
			//给角色Id赋随机值
			role.setRoleId(roleId);
			//增加角色
			rows=roleService.insert(role);
			//判断模块id不能为空
			if(role.getModuleId()!=null&&!"".equals(role.getModuleId())) {
				//根据增加的角色Id循环增加角色模块
				for (int i = 0; i < split.length; i++) {
					moduleRoler.setModeId(split[i]);
					moduleRoler.setRoleId(role.getRoleId());
					moduleRoler.setMrId(Tools.getRandomString());
					int add=moroService.insert(moduleRoler);
				}
			}
		}
		Message mes=new Message();
		if(rows==0) {
			mes.setStatus(0);
			mes.setMsg("操作失败");
		}else {
			mes.setStatus(1);
			mes.setMsg("操作成功");
		}
		return mes;
	}
	@RequestMapping("delete")
	@ResponseBody
	public Message delete(@RequestBody Role role) {
		int rows=roleService.updateId(role);
		Message mes=new Message();
		if(rows!=0) {
			mes.setStatus(1);
			mes.setMsg("删除成功");
		}else {
			mes.setStatus(0);
			mes.setMsg("删除失败");
		}
		return mes;
	}
	@RequestMapping("batchdelete")
	@ResponseBody
	public Message batchdelete(@RequestBody List<String> ids) {
		int rows = roleService.batchdelete(ids);
		Message mes = new Message();
		if (rows>0) {
			mes.setStatus(1);
			mes.setMsg("删除成功");
		} else {
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		return mes;
	}
}

