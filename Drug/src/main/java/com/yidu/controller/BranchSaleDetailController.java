package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.BranchSale;
import com.yidu.domain.BranchSaleDetail;
import com.yidu.service.BranchSaleDetailService;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 分店销售明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/branchSaleDetail")
public class BranchSaleDetailController {
	@Resource
	private BranchSaleDetailService service;
	
	@RequestMapping("insertAdd")
	public int inserAdd(BranchSaleDetail branchSaleDetail) {
		
		return  service.insertSelective(branchSaleDetail);
		
	}
	
	/**
	 * 显示列表
	 * @param page
	 * @param limit
	 * @param sale
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(String page,String limit,BranchSaleDetail saleDetail){
		PageUtil util=new PageUtil();
		util.setCurPage(Integer.valueOf(page));
		util.setRows(Integer.valueOf(limit));
		List<BranchSaleDetail> list=new ArrayList<>();
		List<BranchSaleDetail> lists=service.query(util,saleDetail);
		int rows=service.findCount(saleDetail);
		for (BranchSaleDetail branchSale2 : lists) {
			branchSale2.setOptimestr(Tools.getTimeStr(branchSale2.getOptime()));
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
}

