package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Provider;
import com.yidu.service.ProviderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 原料供应商 前端控制器
 * </p>
 *
 * @author dengkangwei
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/provider")
public class ProviderController {
	
	@Resource
	private ProviderService service;
	
	/**
	 * 查询所有
	 * @param pro
	 * @return
	 */
	@RequestMapping("showList")
	@ResponseBody
	public Map<String, Object> showList(Provider pro){
		List<Provider> list=service.showList(pro);
		
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 10);
		map.put("data", list);
		
		return map;
		
		
		
	}
}

