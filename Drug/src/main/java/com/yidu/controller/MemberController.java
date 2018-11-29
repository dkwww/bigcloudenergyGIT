package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Member;
import com.yidu.service.MemberService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;
import com.yidu.util.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
		//map集合
		Map<String,Object> maps=new HashMap<>();
		//将会员对象包装到map
		maps.put("member", member);
		//将分页对象包装到map
		maps.put("util", util);
		//调用service查询所有的方法
		List<Member> lists=service.query(maps);
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
		map.put("count", "10");
		map.put("data", list);
		//返回map
		return map;
	}
	
	/**
	 * 修改
	 * @param member model
	 * @return service里面修改的方法
	 */
	@RequestMapping("/update")
	@ResponseBody
	public int update(String menId) {
		//返回service里面修改的方法
		return service.update(menId);
	}
}

