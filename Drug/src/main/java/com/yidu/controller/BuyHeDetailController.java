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
	 * @param detail
	 * @param page
	 * @param limit
	 * @author 邓康威
	 * @return
	 */
	@RequestMapping("/showListId")
	@ResponseBody
	public Map<String,Object> showListId(BuyDetail detail,Integer page,Integer limit) {
		
		PageUtil PageUtil=new PageUtil();
		if(page!=null && limit!=null) {
			PageUtil.setCurPage(page);
			PageUtil.setRows(limit);
		}
		List<BuyDetail> list = service.showListId(detail,PageUtil);
		int rows =service.selectCount(detail);
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		return m;
	}
	
}

