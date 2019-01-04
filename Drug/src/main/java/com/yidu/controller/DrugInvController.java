package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Admin;
import com.yidu.domain.DrugInve;
 
import com.yidu.service.DrugInvService;
 
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

	//库存service
	@Resource 
	private   DrugInvService   drugInvService;
	
	/**
	 * 这是总公司的查询所有的方法
	 * @param drugInve  对象 用于接受前台传过来的值
	 * @param page   layui自带的分页
	 * @param limit  layui自带的分页
	 * @return
	 */
	@RequestMapping("qureyAll")
	@ResponseBody
	public   Map<String, Object>  qureyAll(DrugInve  drugInve,Integer page,Integer limit,HttpSession session){
		//创建分页对象
		PageUtil pageUtil = new PageUtil();
		//前台取过来的分页值
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
			Admin  admin=(Admin) session.getAttribute("admin");
		System.out.println("========公司ID====="+admin.getComId());
		drugInve.setComId(admin.getComId());
		//调用查询所有的方法
		List<DrugInve> list = drugInvService.qureyAll(drugInve,pageUtil);
		//查询行数
		int   rows  =drugInvService.selectCountBySelective(drugInve); 
		//返回layui前台格式
		Map<String, Object>  map  =new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		//返回map
		return  map;
	}  
}

