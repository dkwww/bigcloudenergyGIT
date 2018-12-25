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
		
		//创建list
		List<DebtyDetail>lis=new ArrayList<>();
		for (DebtyDetail list2 : list) {
			//将查询出来的0装换为未加盟否则就是已加盟
			if(list2.getIsva().equals("0")) {
				list2.setIsva("无效");
			}else {
				list2.setIsva("有效");
			}
			//将结果添加到lis
			lis.add(list2);
		}
	
		//查询总共多少条数据
		int rows=debtyDetailService.selectCount(Debty);
		//map
		map.put("code", 0);
		map.put("msg", "");
		//总共多少条数据
		map.put("count",rows);
		//list
		map.put("data", lis);
		
		return map;
	}
	
	
}

