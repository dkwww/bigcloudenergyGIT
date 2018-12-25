package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.QcDetail;
import com.yidu.service.QcDetailService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 材料质检明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/qcDetail")
public class QcDetailController {
	
	@Resource
	private QcDetailService qcdetaService;
	
	/**
	 * 根据id查询
	 * @param qcdetail
	 * @return
	 */
	@RequestMapping("findById")
	@ResponseBody
	public Map<String, Object> findById(QcDetail qcdetail){
		
		System.err.println("========="+qcdetail+"==========");
		List <QcDetail> list=qcdetaService.findById(qcdetail);
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 0);
		map.put("data", list);
		
		
		return map;
		
	}
}

