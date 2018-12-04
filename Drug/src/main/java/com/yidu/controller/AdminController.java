package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Admin;
import com.yidu.service.AdminService;
import com.yidu.util.Message;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 后台登陆管理员 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private AdminService service;
	
	
	/**
	 * 查询登录的用户名密码是否存在
	 * @param admin
	 * @return
	 */
	@RequestMapping("/queryNameOrPwd")
	@ResponseBody
	public Message queryNameOrPwd(Admin admin) {
		Admin admin2 = service.queryNameOrPwd(admin);
		Message msg = new Message();
		if(admin2==null) {
			msg.setStatus(0);
			msg.setMsg("登录失败");
		}else {
			msg.setStatus(1);
			msg.setMsg("登录成功");
		}
		return msg;
	}
}

