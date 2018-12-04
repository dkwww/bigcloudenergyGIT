package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.DrugInvDetail;
import com.yidu.service.DrugInvDetailService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 药品库存明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/drugInvDetail")
public class DrugInvDetailController {

	
	@Resource
	
	private   DrugInvDetailService   drugInvDetailService;
	
	@RequestMapping("findById")
	@ResponseBody
	public   Map<String , Object>  findById(DrugInvDetail drugInvDetail){
		
		List<DrugInvDetail> list = drugInvDetailService.findById(drugInvDetail.getDiId());
		int    rows=drugInvDetailService.selectcount(drugInvDetail.getDiId());
		Map<String, Object>  map  =new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return  map;
	 
		
	}
}

