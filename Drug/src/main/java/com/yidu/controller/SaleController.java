package com.yidu.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Buy;
import com.yidu.domain.Sale;
import com.yidu.service.SaleService;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

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
	 * @param buy
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList(Sale sale,Integer page,Integer limit) {
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		List<Sale> list = service.showList(sale,pageUtil);
		int rows = service.findCount(sale);
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		return m;
	}
}

