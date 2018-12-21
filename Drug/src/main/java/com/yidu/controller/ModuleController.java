package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Admin;
import com.yidu.domain.DrugType;
import com.yidu.domain.Module;
import com.yidu.domain.Role;
import com.yidu.service.ModuleService;
import com.yidu.service.RoleService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 模块管理 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/module")
public class ModuleController {
	@Resource
	private ModuleService moduService;
	@RequestMapping("queryList")
	@ResponseBody
	public Map<String,Object> queryList(Module module,Integer page,Integer limit){
		PageUtil pageUtil=new PageUtil();
		if(page !=null && limit !=null){
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		List<Module> list=moduService.queryList(module,pageUtil);
		int rows=moduService.queryCount(module);
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	@RequestMapping("updateId")
	@ResponseBody
	public Message updateId(HttpServletRequest request,@RequestBody Module module) {
		System.out.println("测试++++++"+module.getModeId());
		Message mes=new Message();
		int rows=0;
		HttpSession session=request.getSession();
		Admin user=(Admin) session.getAttribute("user");
		if(user!=null&&!"".equals(user)) {
			module.setOper(user.getAdminName());
		}
		if(module.getModeId()!=null&&!"".equals(module.getModeId())) {
			rows=moduService.updateId(module);
		}else {
			rows=moduService.insert(module);
		}
		if(rows!=0) {
			mes.setMsg("操作成功");
			mes.setStatus(1);
		}else {
			mes.setMsg("操作失败");
			mes.setStatus(0);
		}
		return mes;
	}
	@RequestMapping("queryId")
	@ResponseBody
	public List<Module> queryId(){
		List<Module> list=moduService.queryId();
		return list;
	}
	@RequestMapping("findByModule")
	@ResponseBody
	public List<Module> findByModule(String adminId){
		return moduService.findByModule(adminId);
	}
	@RequestMapping("findByZiModule")
	@ResponseBody
	public List<Module> findByZiModule(String modeId){
		return moduService.findByZiModule(modeId);
	}
}

