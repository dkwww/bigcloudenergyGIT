package com.yidu.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.DrugType;
import com.yidu.service.DrugTypeService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

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
	
	/**
	 * 查询所有
	 * @return List<Drug> 药品集合
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String,Object> findAll(DrugType record,Integer page,Integer limit) {
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		List<DrugType> list = drugTypeService.findAll(record,pageUtil);
		int rows = drugTypeService.findCount(record);
		
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 增加或修改
	 * @param record
	 * @return
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public Message addOrUpdate(@RequestBody DrugType record) {
		int rows = drugTypeService.addOrUpdate(record);
		Message mes = new Message();
		if (rows>0) {
			mes.setStatus(1);
			mes.setMsg("操作成功！");
		} else {
			mes.setStatus(0);
			mes.setMsg("操作失败！");
		}
		return mes;
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/bulkUpdate")
	@ResponseBody
	public Message bulkUpdate(@RequestBody List<String> ids) {
		int rows = drugTypeService.bulkUpdate(ids);
		Message mes = new Message();
		if (rows>0) {
			mes.setStatus(1);
			mes.setMsg("删除成功");
		} else {
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		return mes;
	}
}

