package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Admin;
import com.yidu.domain.Debty;
import com.yidu.service.DebtyService;

import com.yidu.util.Message;
import com.yidu.util.PageUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 财务表 前端控制器
 * </p>
 *
 * @author liuwenxuan
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/debty")
public class DebtyController {
	@Resource
	private DebtyService debtyService;
	/**
	 * 分店的查询
	 * @param Debty 传入Debty
	 * @param page 传入page
	 * @param limit 传入limit
	 * @return 返回map
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(Debty Debty,Integer page,Integer limit,HttpSession session) {
		//page工具类
		PageUtil pageUtil = new PageUtil();
		//判断page和limit不等于空
		if(page!=null && limit!=null) {
			//将page赋值到curpage
			pageUtil.setCurPage(page);
			//将limit赋值到rows
			pageUtil.setRows(limit);
		}
		
		//创建一个map
		HashMap<String , Object> map = new HashMap<>();
		//创建一个list并调用分店查询所有的方法
		List<Debty> list = debtyService.findAll(Debty,pageUtil);
		//创建list
		List<Debty>lis=new ArrayList<>();
		for (Debty list2 : list) {
			//将查询出来的0装换为未加盟否则就是已加盟
			if(list2.getIsva().equals("0")) {
				list2.setIsva("无效");
			}else {
				list2.setIsva("有效");
			}
			//将结果添加到lis
			lis.add(list2);
		}
		
		//查询总共多少条数据
		int rows=debtyService.selectCount(Debty);
		//map
		map.put("code", 0);
		map.put("msg", "");
		//总共多少条数据
		map.put("count",rows);
		//list
		map.put("data", lis);
		
		return map;
	}
	
	
	/**
	 * 增加和修改
	 * @param deb 传入一个财务对象
	 * @return 返回mes
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Message insertUpdate(@RequestBody Debty deb) {
		//Message工具类
		Message mes=new Message();
		//调用增加修改的方法
		int rows = debtyService.addOrUpdate(deb);
		//大于0成否则失败
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
	 *  分店批量删除
	 * @param ids 传入一个ids
	 * @return 返回mes
	 */
	@RequestMapping("/DebtyUpdate")
	@ResponseBody
	public Message DebtyUpdate(@RequestBody List<String> ids) {
		//调用批量修改的方法
		int rows = debtyService.debtyUpdate(ids);
		//创建message
		Message mes = new Message();
		//判断rows大于0就是删除成功，否则就是失败
		if (rows>0) {
			mes.setStatus(1);
			mes.setMsg("删除成功");
		} else {
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		return mes;
	}
	
	
	
}

