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
		Spec spec = specService.findById(drugId);
		
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
		int rows = specService.addOrUpdate(record);
		Message mes = new Message();
		if (rows > 0) {
			mes.setStatus(1);
			mes.setMsg("操作成功！");
		} else {
			mes.setStatus(0);
			mes.setMsg("操作失败！");
		}
		return mes;
	}
	
}

