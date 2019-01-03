package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.ResponseBody;

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
 * <p>
 * 分店销售 前端控制器
 * </p>
 *
 * @author liuyi
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/branchSale")
public class BranchSaleController {
	/**
	 * 注入销售单接口
	 */
	@Resource
	private BranchSaleService service;
	
	@Resource
	private BranchSaleDetailService detailService;
	/**
	 * 显示列表
	 * @param page
	 * @param limit
	 * @param sale
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(String page,String limit,BranchSale branchSale){
		PageUtil util=new PageUtil();
		util.setCurPage(Integer.valueOf(page));
		util.setRows(Integer.valueOf(limit));
		List<BranchSale> list=new ArrayList<>();
		List<BranchSale> lists=service.query(util,branchSale);
		int rows=service.findCount(branchSale);
		for (BranchSale branchSale2 : lists) {
			branchSale2.setOptimeStr(Tools.getTimeStr(branchSale2.getOptime()));
			list.add(branchSale2);
		}
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		//总行数
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 增加到零售明细
	 * @param sum
	 * @param menId 会员ID
	 * @param session
	 * @return
	 */
	@RequestMapping("addSale")
	@ResponseBody
	public Message addSale(String sum,String menId,HttpSession session) {
		session.setAttribute("comId", "1");
		String comId=(String) session.getAttribute("comId");
		return service.addSale(sum,menId,comId);
	}
}