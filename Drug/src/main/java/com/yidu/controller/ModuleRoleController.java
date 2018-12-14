package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.controller.vo.Ztree;
import com.yidu.service.ModuleRoleService;
import com.yidu.util.Message;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 模块角色表 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/moduleRole")
public class ModuleRoleController {
	@Resource
	private ModuleRoleService moroService;
	
	@RequestMapping("queryIdModule")
	@ResponseBody
	public List<Ztree> queryIdModule(String drugId){
		List<Ztree> list=moroService.queryList(drugId);
		return list;
	}
	public Message updateId(String moduleId){
		Message mes=new Message();
		
		return mes;
	}
}

