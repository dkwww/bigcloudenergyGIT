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
		PageUtil PageUtil=new PageUtil();
		if(page!=null && limit!=null) {
			PageUtil.setCurPage(page);
			PageUtil.setRows(limit);
		}
		
		List<MatInv> list=matinvservice.showList(matinv, PageUtil);
		int rows=matinvservice.selectCount(matinv);
		
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		
		return map;
		
	}
}

