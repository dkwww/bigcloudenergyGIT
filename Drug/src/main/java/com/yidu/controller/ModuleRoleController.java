package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.controller.vo.Ztree;
import com.yidu.domain.ModuleRole;
import com.yidu.domain.Role;
import com.yidu.service.ModuleRoleService;
import com.yidu.util.Message;
import com.yidu.util.Tools;

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
	/**
	 * 查询所有节点
	 * @param drugId 传递的参数
	 * @return
	 */
	@RequestMapping("queryIdModule")
	@ResponseBody
	public List<Ztree> queryIdModule(String drugId){
		List<Ztree> list=moroService.queryList(drugId);
		return list;
	}
}

