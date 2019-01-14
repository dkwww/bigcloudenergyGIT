package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Admin;
import com.yidu.domain.BranchSale;
import com.yidu.domain.BranchSaleDetail;
import com.yidu.service.BranchSaleDetailService;
import com.yidu.service.BranchSaleService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

/**
 * 分店零售 前端控制器
 * @author liuyi
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/branchSale")
public class BranchSaleController {
	/**
	 * 注入零售service
	 */
	@Resource
	private BranchSaleService service;
	/**
	 * 注入零售明细service
	 */
	@Resource
	private BranchSaleDetailService detailService;
	/**
	 * 显示列表
	 * @param page 当前页数
	 * @param limit 每页多少行
	 * @param branchSale 零售model
	 * @return map集合
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(String page,String limit,BranchSale branchSale){
		//分页模型对象
		PageUtil util=new PageUtil();
		//得到页数
		util.setCurPage(Integer.valueOf(page));
		//得到行数
		util.setRows(Integer.valueOf(limit));
		//创建一个List集合
		List<BranchSale> list=new ArrayList<>();
		//调用service查询所有的方法
		List<BranchSale> lists=service.query(util,branchSale);
		//调用service分页的方法
		int rows=service.findCount(branchSale);
		//循环
		for (BranchSale branchSale2 : lists) {
			//时间转换
			branchSale2.setOptimeStr(Tools.getTimeStr(branchSale2.getOptime()));
			//添加到集合
			list.add(branchSale2);
		}
		//创建一个map集合
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
	 * 增加到零售明细
	 * @param sum 和
	 * @param menId 会员ID
	 * @param session
	 * @return service里面增加零售的方法
	 */
	@RequestMapping("addSale")
	@ResponseBody
	public Message addSale(String sum,String menId,HttpSession session) {
		//
		Admin admin=(Admin) session.getAttribute("admin");
		//service里面增加零售的方法
		return service.addSale(sum,menId,admin.getComId());
	}
}