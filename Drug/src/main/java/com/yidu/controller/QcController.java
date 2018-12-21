package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Qc;
import com.yidu.service.QcService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
	@RequestMapping("/add")
	@ResponseBody
	public   Message    add(Qc  qc) {
		Message message  =new   Message();
		String    string= UUID.randomUUID().toString().replaceAll("-", "");
		qc.setQcId(string);
		String   pmcId="d6484a14498b47f78cccc1242f5eab6ewerdfc2d23e78fc9446cf96af250812f923a992";
		qc.setPmcId(pmcId);
		qc.setQcAmount(600);
		qc.setQcRate("50");
		
		int  rows = 1;
		if (rows>0) {
			message.setStatus(1);
		}else {
			message.setStatus(0);
		}
		
		return  message;
	}
	
	
	
	

}

