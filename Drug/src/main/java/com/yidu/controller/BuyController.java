package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.service.BuyDetailService;
import com.yidu.service.BuyService;
import com.yidu.util.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 采购订单 前端控制器
 * </p>
 *
 * @author 邓康威
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/buy")
public class BuyController {
	
	@Resource
	private BuyService service;
	
	@Resource
	private BuyDetailService detaservice;
	
	
	/**
	 * 显示列表
	 * @return
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList(Buy buy) {
		List<Buy> list = service.showList(buy);
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", 10);
		m.put("data", list);
		return m;
	}
	
	
}

