package com.yidu.controller;


import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
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
	
	@RequestMapping("/findById")
	@ResponseBody
	public Map<String,Object> findById(String drugId) {
		Spec spec = specService.findById(drugId);
		
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 1);
		map.put("data", spec);
		return map;
	}
	
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

