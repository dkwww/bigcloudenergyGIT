package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.MatInvDetail;
import com.yidu.service.MatInvDetailService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 原材料库存明细 前端控制器
 * </p>
 *
 * @author dengkangwei
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/matInvDetail")
public class MatInvDetailController {

	@Resource
	private MatInvDetailService service;
	
	/**
	 * 
	 * 方法说明：根据库存id查询库存明细
	 * @param madetail
	 * @return
	 * @author dengknagwei
	 * @date：2018年12月27日
	 */
	@RequestMapping("findById")
	@ResponseBody
	public Map<String, Object> findById(MatInvDetail madetail){
		
		List <MatInvDetail> list=service.findById(madetail);
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 0);
		map.put("data", list);
		
		return map;
	}
}

