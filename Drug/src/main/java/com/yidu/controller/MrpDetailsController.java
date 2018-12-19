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
	
	@RequestMapping("update")
	@ResponseBody
	
	public   int   update(MrpDetails  mrpDetails) {
		//传过来的数据
		  String   name = mrpDetails.getShujuName(); 
		  
		  //拆分数据
		  String   nameOne[]=name.split("#");
		  
		  
		  for (int i = 0; i < nameOne.length; i++) {
			  MrpDetails   mrpDetails2 =new   MrpDetails();
			  mrpDetails2.setMrpId(mrpDetails.getMrpId());
			//拆分成一个字段
			  String   nametow[] = nameOne[i].split(",");
			    //拆分后药品ID
			     String drugId = nametow[0];
			     mrpDetails2.setDrugId(drugId);
			     //计划数量
			     String num = nametow[1];
			     
 			      mrpDetails2.setMdPlan(Integer.valueOf(1)-Integer.valueOf(num));
			   //已完成的数量
 			     String    oknum =nametow[2];
 			     
 			     //增加的数量
 			     String    addnum =nametow[3];
 			     
 			     
 			    
			     
			     
			     
		}
		  
		  
		  
		  
		return 0;
	}
	
	
}

