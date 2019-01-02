package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Admin;
import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.domain.Drug;
import com.yidu.service.BuyDetailService;
import com.yidu.service.BuyService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 采购订单 前端控制器
 * </p>
 *
 * @author 郑有宏
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/buy")
public class BuyController {
	
	@Resource
	private BuyService service;
	
	
	
	/**
	 * 显示列表
	 * @param buy
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList(Buy buy,Integer page,Integer limit,HttpSession session) {
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		Admin admin = (Admin) session.getAttribute("user");
		
		List<Buy> list = service.showList(buy,pageUtil,admin);
		int rows = service.findCount(buy);
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		return m;
	}
	
	
}

