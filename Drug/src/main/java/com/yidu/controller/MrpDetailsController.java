package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.MrpDetails;
import com.yidu.service.MrpDetailsService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 制造计划明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/mrpDetails")
public class MrpDetailsController {
	
	@Resource   
	 private  MrpDetailsService  mrpDetailService; 
	
	
	
	@RequestMapping("findById")
	@ResponseBody
	public   Map<String, Object>  findById(MrpDetails  mrpDetails,Integer page,Integer limit){
			 
				//分页
				PageUtil pageUtil = new PageUtil();
				//前台取过来的分页值
				pageUtil.setCurPage(page);
				pageUtil.setRows(limit);
				List<MrpDetails> list = mrpDetailService.findById(mrpDetails, pageUtil); 
				int rows = mrpDetailService.findBycount(mrpDetails);
				//layui前台格式
				Map<String, Object>  map  = new  HashMap<>();
				map.put("code", 0);
				map.put("msg", "");
				map.put("count", rows);
				map.put("data", list);
				return  map;
	}
	
	
}

