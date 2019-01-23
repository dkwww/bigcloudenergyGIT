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
 * @author LiuLongRong
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	/**
	 * 定义一个私有的service对象
	 */
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
		//创建一个分页的对象
		PageUtil pageUtil = new PageUtil();
		
		//将传入的参数赋值给分页的对象
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		//List集合
		List<Admin> list = service.findAll(admin,pageUtil);
		
		//查询分页的行
		int rows = service.selectCount(admin);
		
		//创建一个map集合
		Map<String , Object> map = new HashMap<>();
		map.put("code",0);
		map.put("msg","");
		map.put("count", rows);
		map.put("data", list);
		//返回一个map
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
		//调用修改和增加的方法
		int rows = service.addOrUpdate(admin);
		
		//创建message对象
		Message mes = new Message();
		
		//如果大于0
		if(rows>0) {
			//给他赋值为1
			mes.setStatus(1);
			mes.setMsg("操作成功");
		}else {
			//给他赋值为0
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
		//调用删除的方法
		int rows = service.delete(admin);
		
		//创建一个Message对象
		Message mes = new Message();
		
		//如果大于0
		if(rows>0) {
			//删除成功
			mes.setStatus(1);
			mes.setMsg("操作成功");
		}else {
			//否则删除失败
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		//返回一个值mes
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
		//创建一个变量，接受调用图片的方法
		String fileName = UploadUtil.upload(req);
		
		//创建一个Message
		Message mes = new Message();
		
		//如果图片不等于空
		if(fileName!=null) {
			//那么将值服给mes，上传成功
			mes.setStatus(1);
			mes.setObj(fileName);
			mes.setMsg("上传成功");
		}else {
			//否则上传失败
			mes.setStatus(0);
			mes.setMsg("服务器错误，请稍后重试！");
		}
		//返回一个mes
		return mes;
	}
	
	
	/**
	 * 批量删除
	 * @return 返回提示信息
	 */
	@RequestMapping("/bulkUpdate")
	@ResponseBody
	public Message bulkUpdate(@RequestBody List<String> ids) {
		//调用批量删除的方法
		int rows = service.bulkUpdate(ids);
		
		//创建一个Message对象
		Message mes = new Message();
		
		//如果大于0
		if(rows>0) {
			//删除成功
			mes.setStatus(1);
			mes.setMsg("操作成功");
		}else {
			//否则删除失败
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		//返回一个mes
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
		//调用查询用户名或者密码的方法
		Admin admin2 = service.queryNameOrPwd(admin);
		
		//创建一个Message对象
		Message msg = new Message();
		
		//如果对象等于空
		if(admin2==null) {
			//那么登录失败
			msg.setStatus(0);
			msg.setMsg("登录失败");
		}else {
			//否则登录成功，将对象传到session
			msg.setStatus(1);
			msg.setMsg("登录成功");
			session.setAttribute("admin", admin2);
		}
		//返回一个msg
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
		//调用根据用户id查询角色，然后返回
		return service.findByRole(adminId);
	}
	
	
	/**
	 * 根据id查询
	 */
	@RequestMapping("/showId")
	@ResponseBody
	public Admin showId(HttpSession session) {
		//创建一个admin对象，将对象放入session
		Admin admin=(Admin) session.getAttribute("admin");
		
		//返回调用根据id查询方法
		return service.findById(admin.getAdminId());
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
		//取session
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
		//清空session
		session.removeAttribute("admin");
		
		//给它返回一个数值
		return 1; 
	}
	
	
	/**
	 * 修改的方法
	 * @param admin 用户对象
	 * @return 返回提示信息
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Message update(@RequestBody Admin admin) {
		//定义一个变量，调用修改的方法
		int rows = service.update(admin);
		
		//创建一个Message对象
		Message mes = new Message();
		
		//如果大于0
		if(rows>0) {
			//修改成功，并且跳到登录页面
			mes.setStatus(1);
			mes.setMsg("修改成功");
			mes.setUrl("pages/admin/login.html");
		}else {
			//修改失败
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		
		//返回mes
		return mes;
	}
}

