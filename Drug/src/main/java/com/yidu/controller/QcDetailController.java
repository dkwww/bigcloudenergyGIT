package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.QcDetail;
import com.yidu.service.QcDetailService;
import com.yidu.util.PageUtil;

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
	private QcDetailService   qcDetailService;
	
	@RequestMapping("/qureyById")
	@ResponseBody 
	public   Map<String, Object>  qureyById(QcDetail  qcDetail, Integer  page , Integer  limit){
		//分页
		PageUtil pageUtil = new PageUtil();
		//前台取过来的分页值
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		List<QcDetail> list = qcDetailService.selectbyId(qcDetail, pageUtil);
		int  rows=qcDetailService.selectbycount(qcDetail);
		Map<String , Object>  map  =new  HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return  map; 
	}
	

}

