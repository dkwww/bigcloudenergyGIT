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
 * 分店零售明细 前端控制器
 *
 * @author liuyi
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/branchSaleDetail")
public class BranchSaleDetailController {
	/**
	 * 注入零售明细service
	 */
	@Resource
	private BranchSaleDetailService service;
	
	/**
	 * 增加
	 * @param branchSaleDetail model
	 * @return service里面增加的方法
	 */
	@RequestMapping("insertAdd")
	public int inserAdd(BranchSaleDetail branchSaleDetail) {
		//调用service里面增加的方法
		return  service.insertSelective(branchSaleDetail);
	}
	
	/**
	 * 显示列表
	 * @param page 当前页数
	 * @param limit 每页多少行
	 * @param saleDetail 零售明细model
	 * @return map
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(String page,String limit,BranchSaleDetail saleDetail){
		//创建分页模型类
		PageUtil util=new PageUtil();
		//得到页数
		util.setCurPage(Integer.valueOf(page));
		//得到行数
		util.setRows(Integer.valueOf(limit));
		//创建一个List集合
		List<BranchSaleDetail> list=new ArrayList<>();
		//调用service里面查询所有的方法
		List<BranchSaleDetail> lists=service.query(util,saleDetail);
		//调用service里面分页的方法
		int rows=service.findCount(saleDetail);
		//循环
		for (BranchSaleDetail branchSale2 : lists) {
			//时间转换
			branchSale2.setOptimestr(Tools.getTimeStr(branchSale2.getOptime()));
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
		//返回map
		return map;
	}
}