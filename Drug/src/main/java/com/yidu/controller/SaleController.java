package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Sale;
import com.yidu.service.SaleService;
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
 * 销售单 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/sale")
public class SaleController {
	/**
	 * 注入销售单接口
	 */
	@Resource
	private SaleService service;
	
	/**
	 * 显示列表
	 * @param page
	 * @param limit
	 * @param sale
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(String page,String limit,Sale sale){
		PageUtil util=new PageUtil();
		util.setCurPage(Integer.valueOf(page));
		util.setRows(Integer.valueOf(limit));
		List<Sale> list=new ArrayList<>();
		List<Sale> lists=service.query(util,sale);
		for (Sale sale2 : lists) {
			System.out.println(sale2.getDrugName());
			sale2.setSaleTimeStr(Tools.getTimeStr(sale2.getOptime()));
			list.add(sale2);
		}
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", list);
		return map;
		
	}
}

