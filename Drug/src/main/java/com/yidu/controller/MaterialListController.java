package com.yidu.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	/**
	 * 显示所有物料清单
	 * @param record 物料清单模型类
	 * @param page 页数
	 * @param limit 行数
	 * @return map 物料清单
	 * @author ZhouJun
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList(MaterialList record,Integer page,Integer limit) {
		//获得分页工具类
		PageUtil pageUtil = new PageUtil();
		//开始页数赋值
		pageUtil.setCurPage(page);
		//每页行数赋值
		pageUtil.setRows(limit);
		
		//条件查询所有的物料清单数据
		List<MaterialList> list = materialListService.findAll(record,pageUtil);
		int rows = materialListService.findCount(record);
		
		//获得一个map对象并赋值
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 增加或修改
	 * @param record 物料清单模型类
	 * @return 修改的行数
	 * @author ZhouJun
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public int addOrUpdate(@RequestBody MaterialList record) {
		//进行增加或修改并返回处理的行数
		return materialListService.addOrUpdate(record);
	}
}

