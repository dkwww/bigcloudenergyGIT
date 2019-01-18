package com.yidu.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Spec;
import com.yidu.service.SpecService;
import com.yidu.util.Message;

/**
 * <p>
 * 说明书 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/spec")
public class SpecController {
	
	@Resource
	private SpecService specService;
	
	/**
	 * 根据药品显示说明书
	 * @param drugId 药品id
	 * @return map 说明书
	 * @author ZhouJun
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public Map<String,Object> findById(String drugId) {
		//根据药品id查询说明书
		Spec spec = specService.findById(drugId);
		
		//获得一个map对象并赋值
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 1);
		map.put("data", spec);
		return map;
	}
	
	/**
	 * 增加或修改
	 * @param record 说明书模型类
	 * @return mes json工具类
	 * @author ZhouJun
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public Message addOrUpdate(@RequestBody Spec record) {
		//增加或修改并获得处理的行数
		int rows = specService.addOrUpdate(record);
		//获得json信息工具类
		Message mes = new Message();
		//如果处理的行数大于零
		if (rows > 0) {
			//赋值成功信息
			mes.setStatus(1);
			mes.setMsg("操作成功！");
		} else {
			//赋值失败信息
			mes.setStatus(0);
			mes.setMsg("操作失败！");
		}
		return mes;
	}
	
}

