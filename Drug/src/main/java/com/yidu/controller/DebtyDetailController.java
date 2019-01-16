package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.DebtyDetail;
import com.yidu.service.DebtyDetailService;
import com.yidu.util.PageUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 财物明细 前端控制器
 * </p>
 *
 * @author liuwenxuan
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/debtyDetail")
public class DebtyDetailController {
	
	@Resource
	private DebtyDetailService debtyDetailService;
	/**
	 * 分店的查询
	 * @param Debty 传入Debty
	 * @param page 传入page
	 * @param limit 传入limit
	 * @return 返回map
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(DebtyDetail Debty,Integer page,Integer limit,String debId) {
		//page工具类
		PageUtil pageUtil = new PageUtil();
		//判断page和limit不等于空
		if(page!=null && limit!=null) {
			//将page赋值到curpage
			pageUtil.setCurPage(page);
			//将limit赋值到rows
			pageUtil.setRows(limit);
		}

		//创建一个map
		HashMap<String , Object> map = new HashMap<>();
		//创建一个list并调用分店查询所有的方法
		List<DebtyDetail> list = debtyDetailService.findAll(Debty,pageUtil,debId);
	
		//查询总共多少条数据
		int rows=debtyDetailService.selectCount(Debty);
		//map赋值0
		map.put("code", 0);
		//map赋值空
		map.put("msg", "");
		//map赋值总共多少条数据
		map.put("count",rows);
		//map赋值查询出来的结果
		map.put("data", list);
		
		return map;
	}
	
	
}

