package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.dao.DrugInveMapper;
import com.yidu.domain.Drug;
import com.yidu.domain.DrugInve;
import com.yidu.service.DrugInvService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 药品库存 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/drugInv")
public class DrugInvController {
	
	
	@Resource 
	
	private   DrugInvService   drugInvService;
	@RequestMapping("qureyAll")
	@ResponseBody
	public   Map<String, Object>  qureyAll(DrugInve  drugInve,Integer page,Integer limit){
	//分页
	PageUtil pageUtil = new PageUtil();
	//前台取过来的分页值
	pageUtil.setCurPage(page);
	pageUtil.setRows(limit);
		
	List<DrugInve> list = drugInvService.qureyAll(drugInve,pageUtil);
	  int   rows  =drugInvService.selectCountBySelective(drugInve);
	for (DrugInve drugInves : list) {
		System.out.println("----------------------"+drugInves.getComName());
	}
		
		Map<String, Object>  map  =new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return  map;
	}

}

