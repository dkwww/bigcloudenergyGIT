package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Company;
import com.yidu.service.CompanyService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

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
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Resource
	private CompanyService companyService;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(Company company,Integer page,Integer limit) {
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		HashMap<String , Object> map = new HashMap<>();
		List<Company> list = companyService.findAll(company,pageUtil);
		int rows=companyService.selectCount(company);
		//查询总行数
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",rows);
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
}

