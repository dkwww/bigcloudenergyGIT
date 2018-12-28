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
	
	/**
	 * 查询所有，分页
	 * @param admin 用户对象
	 * @param page 分页
	 * @param limit 分页
	 * @return 返回map集合
	 */
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
	/**
	 * 增加和修改的方法
	 * @param admin 用户对象
	 * @return 返回提示信息
	 */
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
	/**
	 * 删除的方法
	 * @param admin 用户
	 * @return 返回提示信息
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Message delete(@RequestBody Admin admin) {
		int rows = service.delete(admin);
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
	 * 图片的方法 
	 * @param req 请求
	 * @return 返回提示信息
	 * @throws Exception 异常
	 */
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
	 * @return 返回提示信息
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
	 * @param admin 用户对象
	 * @return 返回提示信息
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
			session.setAttribute("admin", admin2);
		}
		return msg;
	}
	
	/**
	 * 根据用户ID查询角色
	 * @param adminId角色id
	 * @return 返回查询的角色
	 */
	@RequestMapping("/findByRole")
	@ResponseBody
	public List<AdminRole> findByRole(String adminId) {
		return service.findByRole(adminId);
	}
	
	/**
	 * 方法说明：取session
	 * @param session 对象
	 * @return Admin 用户对象
	 * @author LiuLongRong
	 * @date：2018年12月27日
	 */
	@RequestMapping("/getSession")
	@ResponseBody
	public Admin getSession(HttpSession session) {
		return (Admin) session.getAttribute("admin");
	}
	/**
	 * 点击注销时清空session
	 * @param session
	 * @return
	 */
	@RequestMapping("/clearSession")
	@ResponseBody
	public int clearSession(HttpSession session) {
		System.out.println("清空了session................");
		session.removeAttribute("admin");
		return 1; 
	}
}

