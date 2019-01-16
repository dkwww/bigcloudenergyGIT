package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.service.BuyDetailService;
import com.yidu.service.BuyHeDetailService;
import com.yidu.service.BuyService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 采购明细 前端控制器
 * </p>
 *
 * @author dengkangwei
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/buyheDetail")
public class BuyHeDetailController {
	
	@Resource
	BuyHeDetailService service;	//采购明细service
	
	/**
	 * 根据id显示列表
	 * @param detail 采购明细对象
	 * @param page   页数
	 * @param limit  行数
	 * @author 邓康威
	 * @return
	 */
	@RequestMapping("/showListId")
	@ResponseBody
	public Map<String,Object> showListId(BuyDetail detail,Integer page,Integer limit) {
		//得到分页对象
		PageUtil PageUtil = new PageUtil();
		//判断页数不等于空 且 行数不等于空
		if(page!=null && limit!=null) {
			//赋值前台传来的页数
			PageUtil.setCurPage(page);
			//赋值前台传来的行数
			PageUtil.setRows(limit);
		}
		//查询采购明细集合
		List<BuyDetail> list = service.showListId(detail,PageUtil);
		//查询总行数
		int rows =service.selectCount(detail);
		
		//创建map集合
		Map<String, Object> me = new HashMap<>();
		me.put("code", 0);
		me.put("msg", "");
		me.put("count", rows);
		me.put("data", list);
		return me;
	}
	
}

