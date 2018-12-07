package com.yidu.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.MaterialList;
import com.yidu.service.MaterialListService;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 物料清单 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/materialList")
public class MaterialListController {
	
	@Resource
	private MaterialListService materialListService;
	
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList(MaterialList record,Integer page,Integer limit) {
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		List<MaterialList> list = materialListService.findAll(record,pageUtil);
		int rows = materialListService.findCount(record);
		
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
}

