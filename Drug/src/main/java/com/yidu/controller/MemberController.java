package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Member;
import com.yidu.service.MemberService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;
import com.yidu.util.Tools;
import com.yidu.util.UploadUtil;

import antlr.RecognitionException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 会员 前端控制器
 * </p>
 *
 * @author Liuyi
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/member")
public class MemberController {
	/**
	 * 注入会员service
	 */
	@Resource
	private MemberService service;
	
	/**
	 * 查询所有
	 * @param page 当前页数
	 * @param limit 每页多少行
	 * @param member 会员model
	 * @return map 集合
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(String page,String limit,Member member){
		//创建分页模型对象
		PageUtil util=new PageUtil();
		//得到页数
		util.setCurPage(Integer.valueOf(page));
		//得到行数
		util.setRows(Integer.valueOf(limit));
		//创建List集合
		List<Member> list=new ArrayList<>();
		//调用service查询所有的方法
		List<Member> lists=service.query(util,member);
		//调用会员service里面分页的方法
		int rows=service.findCount(member);
		//循环
		for (Member member2 : lists) {
			//时间转换
			member2.setOptimeString(Tools.getTimeStr(member2.getOptime()));
			//添加到集合
			list.add(member2);
		}
		//创建map集合
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		//打印
		map.put("msg", "");
		//总行数
		map.put("count", rows);
		map.put("data", list);
		//返回map集合
		return map;
	}
	
	/**
	 * 上传文件
	 * @param req 请求
	 * @return msg 打印
	 * @throws Exception 异常
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Message upload(HttpServletRequest req) throws Exception {
		String fileName=UploadUtil.upload(req);
		//创建Message
		Message msg=new Message();
		//如果文件名为空
		if(fileName!=null) {
			//1
			msg.setStatus(1);
			msg.setObj(fileName);
			//提示上传成功
			msg.setMsg("上传成功");
		}else {
			//0
			msg.setStatus(0);
			//提示上传成功
			msg.setMsg("上传失败");
		}
		//返回msg
		return msg;
	}
	
	/**
	 * 增加会员
	 * @param record model
	 * @return msg 打印
	 */
	@RequestMapping("/addMember")
	@ResponseBody
	public Message addMember(@RequestBody Member record) {
		//调用service里面增加修改的方法
		int rows=service.addOrUpdate(record);
		//创建Message
		Message msg=new Message();
		//如果rows大于零
		if(rows>0) {
			//1
			msg.setStatus(1);
			//提示操作成功
			msg.setMsg("操作成功");
		}else {
			//0
			msg.setStatus(0);
			//提示操作失败
			msg.setMsg("操作失败");
		}
		//返回msg
		return msg;
	}
	
	/**
	 * 删除
	 * @param menId 会员ID
	 * @return rows
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public int delete(String menId) {
		//调用service里面删除的方法
		int rows=service.delete(menId);
		//返回rows
		return rows;
	}
	
	/**
	 * 批量删除
	 * @param ids id
	 * @return msg 打印
	 */
	@RequestMapping("/bulkUpdate")
	@ResponseBody
	public Message bulkUpdate(@RequestBody List<String> ids) {
		//调用seivice里面批量删除的方法
		int rows=service.bulkUpdate(ids);
		//创建Message
		Message msg=new Message();
		//rows大于0
		if(rows>0) {
			//1
			msg.setStatus(1);
			//提示删除成功
			msg.setMsg("删除成功");
		}else {
			//0
			msg.setStatus(0);
			//删除失败
			msg.setMsg("删除失败");
		}
		//返回msg
		return msg;
	}
	
	/**
	 * 根据ID查询
	 * @param menId
	 * @return service里面根据ID查询的方法
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public Member findById(String menId) {
		//返回service里面根据ID查询的方法
		return service.findById(menId);
	}
	/**
	 * 根据会员名查询
	 * @param menName
	 * @return service里面根据会员名查询的方法
	 */
	@RequestMapping("/findMenName")
	@ResponseBody
	public int findMenName(String menName) {
		//返回service里面根据会员名查询的方法
		return service.findMenName(menName);
	}
}