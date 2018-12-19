package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Admin;
import com.yidu.domain.AdminRole;
import com.yidu.service.AdminService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.UploadUtil;

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
	public Map<String,Object> findAll(Admin admin,Integer page,Integer limit){
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		//List集合
		List<Admin> list = service.findAll(admin,pageUtil);
		//查询分页的行
		int rows = service.selectCount(admin);
		
		
		Map<String , Object> map = new HashMap<>();
		map.put("code",0);
		map.put("msg","");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	@RequestMapping("/addAdmin")
	@ResponseBody
	public Message addAdmin(@RequestBody Admin admin) {
		int rows = service.addOrUpdate(admin);
		Message mes = new Message();
		if(rows>0) {
			mes.setStatus(1);
			mes.setMsg("操作成功");
		}else {
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		return mes;
	}
	@RequestMapping("/upload")
	@ResponseBody
	public Message upload(HttpServletRequest req) throws Exception {
		String fileName = UploadUtil.upload(req);
		Message mes = new Message();
		if(fileName!=null) {
			mes.setStatus(1);
			mes.setObj(fileName);
			mes.setMsg("上传成功");
		}else {
			mes.setStatus(0);
			mes.setMsg("服务器错误，请稍后重试！");
		}
		return mes;
	}
	/**
	 * 批量删除
	 * @return
	 */
	@RequestMapping("/bulkUpdate")
	@ResponseBody
	public Message bulkUpdate(@RequestBody List<String> ids) {
		int rows = service.bulkUpdate(ids);
		Message mes = new Message();
		if(rows>0) {
			mes.setStatus(1);
			mes.setMsg("操作成功");
		}else {
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		return mes;
	}
	/**
	 * 查询登录的用户名密码是否存在
	 * @param admin
	 * @return
	 */
	@RequestMapping("/queryNameOrPwd")
	@ResponseBody
	public Message queryNameOrPwd(Admin admin,HttpSession session) {
		Admin admin2 = service.queryNameOrPwd(admin);
		Message msg = new Message();
		if(admin2==null) {
			msg.setStatus(0);
			msg.setMsg("登录失败");
		}else {
			msg.setStatus(1);
			msg.setMsg("登录成功");
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
		HttpSession session=request.getSession();
		Admin admin=(Admin) session.getAttribute("user");
			return admin;
	}
	
	/**
	 * 根据用户ID查询角色
	 * @param adminId
	 * @return
	 */
	@RequestMapping("/findByRole")
	@ResponseBody
	public List<AdminRole> findByRole(String adminId) {
		return service.findByRole(adminId);
	}
}

