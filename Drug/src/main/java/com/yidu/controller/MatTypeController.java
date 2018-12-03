package com.yidu.controller;


import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.MatType;
import com.yidu.service.MatTypeService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;
import com.yidu.util.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 原材料类型 前端控制器
 * </p>
 *
 * @author 邓康威
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/matType")
public class MatTypeController {
	
	@Resource
	private MatTypeService matTypeService;
	
	/**
	 * 查询所有
	 * @return
	 */
	@RequestMapping("showList")
	@ResponseBody
	public Map<String, Object> showList(MatType type,Integer page,Integer limit){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		
		List<MatType> list=matTypeService.showList(type,pageUtil);
		int rows=matTypeService.selectCount(type);
		
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",rows);
		map.put("data", list);
		
		return map;
	}
	
	
	
	
	/**
	 * 增加或修改
	 * @param type
	 * @return
	 */
	
	@RequestMapping("addorupdate")
	@ResponseBody
	public Message addorupdate(@RequestBody MatType type) {
		matTypeService.addorupdate(type);
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("操作成功");
		return me;
	}
	
	
	/**
	 * 根据id显示修改
	 * @param mtId
	 * @return
	 */
	public MatType showUpdate(String mtId) {
		
		return matTypeService.showUpdate(mtId);
	}
	
	
	/**
	 * 删除
	 * @param mtId
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Message delete(String mtId) {
		matTypeService.delete(mtId);
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("删除成功");
		
		return me;
	}
	
}

