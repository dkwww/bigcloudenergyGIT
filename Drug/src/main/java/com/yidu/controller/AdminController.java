package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Admin;
import com.yidu.domain.Member;
import com.yidu.service.AdminService;
import com.yidu.util.Message;
import com.yidu.util.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String,Object> findAll(Admin admin){
		//List集合
		List<Admin> list=new ArrayList<>();
		List<Admin> list2 = service.findAll(admin);
		for (Admin admin2 : list2) {
			admin2.setOptimestring(Tools.getTimeStr(admin2.getOptime()));
			list.add(admin2);
		}
		Map<String , Object> map = new HashMap<>();
		map.put("code",0);
		map.put("msg","");
		map.put("data", list);
		return map;
	}
	/**
	 * 查询登录的用户名密码是否存在
	 * @param admin
	 * @return
	 */
	@RequestMapping("/queryNameOrPwd")
	@ResponseBody
	public Message queryNameOrPwd(Admin admin,HttpServletRequest request) {
		Admin admin2 = service.queryNameOrPwd(admin);
		Message msg = new Message();
		if(admin2==null) {
			msg.setStatus(0);
			msg.setMsg("登录失败");
		}else {
			msg.setStatus(1);
			msg.setMsg("登录成功");
			HttpSession session=request.getSession();
			session.setAttribute("user", admin2);
		}
		return msg;
	}
	
	/**
	 * 获取Seesion
	 * @param request
	 * @return
	 */
	@RequestMapping("/getSessions")
	@ResponseBody
	public Admin getSessions(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Admin admin=(Admin) session.getAttribute("user");
		
		System.out.println("Seesion==="+admin);
		if(admin != null) {
			return admin;
		}else {
			return admin = new Admin();
		}
	}
	/**
	 * 取session
	 */
	@RequestMapping("/sessionuser")
	@ResponseBody
	public Admin sessionuser(HttpServletRequest request) {
		System.out.println("userseesion");
		HttpSession session=request.getSession();
		Admin admin=(Admin) session.getAttribute("user");
			return admin;
	}
}

