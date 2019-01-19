package com.yidu.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Provider;
import com.yidu.service.ProviderService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

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
	private ProviderService providerService;//注入供应商业务类
	
	/**
	 * 查询所有
	 * @param pro
	 * @return
	 */
	@RequestMapping("showList")
	@ResponseBody
	public Map<String, Object> showList(Provider pro){
		List<Provider> list=providerService.showList(pro);
		
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 10);
		map.put("data", list);
		
		return map;
		
		
		
	}
	
	/**
	 * 查询所有
	 * @param record 供应商模型类
	 * @param page 页数
	 * @param limit 行数
	 * @return map 供应商数组
	 * @author ZhouJun
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String,Object> findAll(Provider record,Integer page,Integer limit) {
		//获得分页工具类
		PageUtil pageUtil = new PageUtil();
		//开始页数赋值
		pageUtil.setCurPage(page);
		//每页行数赋值
		pageUtil.setRows(limit);
		
		//条件查询所有供应商数据
		List<Provider> list = providerService.findAll(record,pageUtil);
		int rows = providerService.findCount(record);
		
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
	 * @param record 供应商模型类
	 * @return mes json信息工具类
	 * @author ZhouJun
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public Message addOrUpdate(@RequestBody Provider record) {
		//进行增加或修改并获得处理行数
		int rows = providerService.addOrUpdate(record);
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
		int rows = providerService.bulkUpdate(ids);
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

