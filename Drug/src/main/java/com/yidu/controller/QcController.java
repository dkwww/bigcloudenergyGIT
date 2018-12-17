package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Qc;
import com.yidu.service.QcService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 质检表 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/qc")
public class QcController {
	 @Resource
	 private   QcService   qcService;
	//查询 药品质检
	
	@RequestMapping("/qureyAll")
	@ResponseBody
	 public   Map<String , Object>  qureyAll(Qc  qc  , Integer  page , Integer  limit){
		//分页
		PageUtil pageUtil = new PageUtil();
		//前台取过来的分页值
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		List<Qc> list = qcService.selectqctype(qc, pageUtil);
		 int rows = qcService.selectCountBySelective(qc);
		 Map<String , Object>  map  =new  HashMap<>();
			map.put("code", 0);
			map.put("msg", "");
			map.put("count", rows);
			map.put("data", list);
			return  map;
	} 
	
	
	

}

