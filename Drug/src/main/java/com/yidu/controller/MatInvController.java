package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.MatInv;
import com.yidu.service.MatInvService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 原材料库存 前端控制器
 * </p>
 *
 * @author dengkagnwei
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/matInv")
public class MatInvController {
	//原材料库存service
	@Resource
	private MatInvService matinvservice;
	
	/**
	 * 查询所有
	 * @param matinv
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("showList")
	@ResponseBody
	public Map<String, Object> showList(MatInv matinv,Integer page,Integer limit){
		//得到分页对象
		PageUtil PageUtil = new PageUtil();
		//判断页数不等于空 且 行数不等于空
		if(page!=null && limit!=null) {
			//赋值前台传来的页数
			PageUtil.setCurPage(page);
			//赋值前台传来的行数
			PageUtil.setRows(limit);
		}
		
		//查询库存集合
		List<MatInv> list=matinvservice.showList(matinv, PageUtil);
		//查询总行数
		int rows=matinvservice.selectCount(matinv);
		
		//创建map集合
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		
		return map;
		
	}
}

