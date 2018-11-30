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
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/member")
public class MemberController {
	@Resource
	private MemberService service;
	
	/**
	 * 查询所有
	 * @param page 当前页数
	 * @param limit 每页多少行
	 * @param member model
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(String page,String limit,Member member){
		//分页类
		PageUtil util=new PageUtil();
		//得到页数
		util.setCurPage(Integer.valueOf(page));
		//得到行数
		util.setRows(Integer.valueOf(limit));
		//List集合
		List<Member> list=new ArrayList<>();
		//调用service查询所有的方法
		List<Member> lists=service.query(util,member);
		//调用service分页的方法
		int rows=service.findCount(member);
		//循环
		for (Member member2 : lists) {
			member2.setOptimeString(Tools.getTimeStr(member2.getOptime()));
			list.add(member2);
		}
		//map集合
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		//打印
		map.put("msg", "");
		//总行数
		map.put("count", rows);
		map.put("data", list);
		//返回map
		return map;
	}
	
	/**
	 * 上传文件
	 * @param req
	 * @return msg
	 * @throws Exception 异常
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Message upload(HttpServletRequest req) throws Exception {
		String fileName=UploadUtil.upload(req);
		Message msg=new Message();
		if(fileName!=null) {
			msg.setStatus(1);
			msg.setObj(fileName);
			msg.setMsg("上传成功");
		}else {
			msg.setStatus(0);
			msg.setMsg("上传失败");
		}
		return msg;
	}
	
	/**
	 * 增加会员
	 * @param record model
	 * @return 返回msg
	 */
	@RequestMapping("/addMember")
	@ResponseBody
	public Message addMember(@RequestBody Member record) {
		int rows=service.addOrUpdate(record);
		Message msg=new Message();
		if(rows>0) {
			msg.setStatus(1);
			msg.setMsg("操作成功");
		}else {
			msg.setStatus(0);
			msg.setMsg("操作失败");
		}
		return msg;
	}
	
	/**
	 * 删除
	 * @param menId 会员ID
	 * @return 返回rows
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public int delete(String menId) {
		//调用service里面删除的方法
		int rows=service.delete(menId);
		//返回rows
		return rows;
	}
	
	//批量删除
	@RequestMapping("/bulkUpdate")
	@ResponseBody
	public Message bulkUpdate(@RequestBody List<String> ids) {
		int rows=service.bulkUpdate(ids);
		Message msg=new Message();
		if(rows>0) {
			msg.setStatus(1);
			msg.setMsg("删除成功");
		}else {
			msg.setStatus(0);
			msg.setMsg("删除失败");
		}
		return msg;
	}
}

