package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.DrugType;
import com.yidu.service.DrugTypeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 药品类型 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/drugType")
public class DrugTypeController {
	
	@Resource
	private DrugTypeService drugTypeService;
	
	/**
	 * 显示所有
	 * @return
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList() {
		Map<String,Object> map = new HashMap<String,Object>();
		List<DrugType> list = drugTypeService.showList();
		map.put("types", list);
		return map;
	}
}

