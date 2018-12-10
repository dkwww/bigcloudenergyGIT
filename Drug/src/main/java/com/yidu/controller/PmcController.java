package com.yidu.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Pmc;
import com.yidu.service.PmcService;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 生产计划单 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/pmc")
public class PmcController {

	@Resource
	private PmcService pmcService;
	
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList(Pmc record,Integer page,Integer limit) {
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		List<Pmc> list = pmcService.findAll(record,pageUtil);
		int rows = pmcService.findCount(record);
		
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
}

