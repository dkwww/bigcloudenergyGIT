package com.yidu.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
	 * @return map 药品类型数组
	 * @author ZhouJun
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList() {
		//获得一个map对象
		Map<String,Object> map = new HashMap<String,Object>();
		//查询所有的药品类型
		List<DrugType> list = drugTypeService.showList();
		//添加到map里
		map.put("types", list);
		//返回map对象
		return map;
	}
	
	/**
	 * 查询所有
	 * @param record 药品类型模型类
	 * @param page 页数
	 * @param limit 行数
	 * @return map 药品类型数组
	 * @author ZhouJun
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String,Object> findAll(DrugType record,Integer page,Integer limit) {
		//获得分页工具类
		PageUtil pageUtil = new PageUtil();
		//开始页数赋值
		pageUtil.setCurPage(page);
		//每页行数赋值
		pageUtil.setRows(limit);
		
		//条件查询所有药品类型数据
		List<DrugType> list = drugTypeService.findAll(record,pageUtil);
		int rows = drugTypeService.findCount(record);
		
		//获得一个map对象并赋值
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 增加或修改
	 * @param record 药品类型模型类
	 * @return mes json信息工具类
	 * @author ZhouJun
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public Message addOrUpdate(@RequestBody DrugType record) {
		//进行增加或修改并获得处理行数
		int rows = drugTypeService.addOrUpdate(record);
		//json信息工具类
		Message mes = new Message();
		//如果处理行数大于零
		if (rows>0) {
			//赋值成功信息
			mes.setStatus(1);
			mes.setMsg("操作成功！");
		} else {
			//赋值失败信息
			mes.setStatus(0);
			mes.setMsg("操作失败！");
		}
		//返回json信息类
		return mes;
	}
	
	/**
	 * 批量删除
	 * @param ids id集合
	 * @return mes json信息工具类
	 * @author ZhouJun
	 */
	@RequestMapping("/bulkUpdate")
	@ResponseBody
	public Message bulkUpdate(@RequestBody List<String> ids) {
		//进行批量删除并获得处理行数
		int rows = drugTypeService.bulkUpdate(ids);
		//json信息工具类
		Message mes = new Message();
		//如果处理的行数大于零
		if (rows>0) {
			//赋值成功信息
			mes.setStatus(1);
			mes.setMsg("删除成功");
		} else {
			//赋值失败信息
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		return mes;
	}
}

