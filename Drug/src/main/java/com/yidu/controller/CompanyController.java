package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Company;
import com.yidu.service.CompanyService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 店铺（分店、总店） 前端控制器
 * </p>
 *
 * @author liuwenxuan
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Resource
	private CompanyService companyService;
	/**
	 * 分店的查询
	 * @param company 传入company
	 * @param page 传入page
	 * @param limit 传入limit
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(Company company,Integer page,Integer limit) {
		
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}

		//创建一个map
		HashMap<String , Object> map = new HashMap<>();
		//创建一个list并调用分店查询所有的方法
		List<Company> list = companyService.findAll(company,pageUtil);
		
		List<Company>lis=new ArrayList<>();
		for (Company list2 : list) {
			System.err.println("sssssssssssssssssssssssssssssssssssssssssssssssssssssss"+list2.getIsva());
			if(list2.getIsva().equals("0")) {
				list2.setIsva("未加盟");
			}else {
				list2.setIsva("已加盟");
			}
			lis.add(list2);
		}
		
		//查询总共多少条数据
		int rows=companyService.selectCount(company);
		//map
		map.put("code", 0);
		map.put("msg", "");
		//总共多少条数据
		map.put("count",rows);
		//list
		map.put("data", lis);
		
		return map;
	}
	
	/**
	 * 审核的查询
	 * @param company 传入company
	 * @param page 传入page
	 * @param limit 传入limit
	 * @return
	 */
	@RequestMapping("/checkfindAll")
	@ResponseBody
	public Map<String, Object> checkfindAll(Company company,Integer page,Integer limit) {
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		//创建一个map
		HashMap<String , Object> map = new HashMap<>();
		//创建一个list并调用分店查询所有的方法
		List<Company> list = companyService.checkfindAll(company, pageUtil);
		
		List<Company>lis=new ArrayList<>();
		for (Company list2 : list) {
			if(list2.getIsva().equals("0")) {
				list2.setIsva("未加盟");
			}else {
				list2.setIsva("已加盟");
			}
			lis.add(list2);
		}
		//查询总共多少条数据
		int rows=companyService.checkselectCount(company);
		//map
		map.put("code", 0);
		map.put("msg", "");
		//总共多少条数据
		map.put("count",rows);
		//list
		map.put("data", list);
		
		return map;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Message insertUpdate(@RequestBody Company com) {
		Message mes=new Message();
		System.err.println("进入了增加修改的方法");
		
		int rows = companyService.addOrUpdate(com);
		System.err.println(com.getComName());
		if(rows>0) {
			mes.setStatus(1);
			mes.setMsg("操作成功");
		}else {
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		
		return mes;
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/companyUpdate")
	@ResponseBody
	public Message companyUpdate(@RequestBody List<String> ids) {
		int rows = companyService.companyUpdate(ids);
		Message mes = new Message();
		if (rows>0) {
			mes.setStatus(1);
			mes.setMsg("删除成功");
		} else {
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		return mes;
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/checkcompanyUpdate")
	@ResponseBody
	public Message checkcompanyUpdate(@RequestBody List<String> ids) {
		int rows = companyService.checkcompanyUpdate(ids);
		Message mes = new Message();
		if (rows>0) {
			mes.setStatus(1);
			mes.setMsg("删除成功");
		} else {
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		return mes;
	}
}

