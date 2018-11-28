package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Member;
import com.yidu.service.MemberService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

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
	
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(String page,String limit,Member member){
		
		PageUtil util=new PageUtil();
		util.setCurPage(Integer.valueOf(page));
		util.setRows(Integer.valueOf(limit));
		
		List<Member> list=new ArrayList<>();
		Map<String,Object> maps=new HashMap<>();
		maps.put("member", member);
		maps.put("util", util);
		List<Member> lists=service.query(maps);
		for (Iterator iterator = lists.iterator(); iterator.hasNext();) {
			Member members = (Member) iterator.next();
			TimeUtil.dateToString(members.getOptime(),"yyy-MM-dd");
			list.add(members);
		}
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", "10");
		map.put("data", list);
		return map;
	}
}

