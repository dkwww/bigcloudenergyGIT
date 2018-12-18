package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.PmcDetails;
import com.yidu.service.PmcDetailsService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 生产计划明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/pmcDetails")
public class PmcDetailsController {
	@Resource
	private    PmcDetailsService   pmcDetailsService  ;
	
	
	@RequestMapping("/findById")
	@ResponseBody
	public   Map<String, Object>   findById(PmcDetails  pmcDetails   ,Integer  page , Integer  limit){
				//分页
				PageUtil pageUtil = new PageUtil();
				//前台取过来的分页值
				pageUtil.setCurPage(page);
				pageUtil.setRows(limit);
				List<PmcDetails> list = pmcDetailsService.findById(pmcDetails, pageUtil); 
				 int rows = pmcDetailsService.selectCountBySelective(pmcDetails);
				Map<String , Object>  map  =new  HashMap<>();
				map.put("code", 0);
				map.put("msg", "");
				map.put("count", rows);
				map.put("data", list);
				return  map;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Message update(PmcDetails  pmcDetails) {
	System.out.println("===============jin================");
		Message  message =new   Message();
		 
		  String   name = pmcDetails.getShujuName();
		  int rows=0;
		  String   nameOne[]=name.split("#");
		  PmcDetails  pmcDetailss =null;
		  for (int i = 0; i < nameOne.length; i++) {
			  pmcDetailss=  new  PmcDetails();
			  String   nametow[] = nameOne[i].split(",");
			  pmcDetailss.setDrugId(nametow[0]);
			  pmcDetailss.setHangName(Integer.valueOf(nametow[1]));
			  rows = pmcDetailsService.updateHang(pmcDetailss);
			  
		}
		
		 if(rows>0) {
			 message.setMsg("保存成功");
			 message.setStatus(1);
		 }else{
			 message.setMsg("保存失败");
			 message.setStatus(0);
			 
		 }
	
		 return message;
	}
	
	/**
	 * 增加或修改
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public Message addOrUpdate(@RequestBody PmcDetails record) {
		int rows = pmcDetailsService.addOrUpdate(record);
		Message mes = new Message();
		if (rows > 0) {
			mes.setStatus(1);
			mes.setMsg("操作成功！");
		} else {
			mes.setStatus(0);
			mes.setMsg("操作失败，请稍后重试！");
		}
		return mes;
	}
}

