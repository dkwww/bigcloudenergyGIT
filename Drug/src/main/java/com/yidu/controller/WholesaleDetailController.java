package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.WholesaleDetail;
import com.yidu.service.WholesaleDetailService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 分店批发明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/WholesaleDetail")
public class WholesaleDetailController {
	@Resource
	WholesaleDetailService detailService;
	
	
	@RequestMapping("insertAdd")
	public int insertAdd(WholesaleDetail WholesaleDetailDetail) {
		return detailService.insertSelective(WholesaleDetailDetail);
	}
	
	@RequestMapping("/selectAll")
	@ResponseBody
	public Map<String,Object> selectAll(@RequestParam(value = "limit",required = false)Integer limit,
			@RequestParam(value = "page" ,required = false)Integer page, WholesaleDetail record){
		System.err.println("  sdsddddddddddddddddd"+limit+"==================="+page);
		PageUtil pages=new PageUtil();
		if(limit!=null && page!=null) {
			pages.setCurPage(page);
			pages.setRows(limit);
		}
		Map<String, Object> maps=new HashMap<String,Object >();
		maps.put("title",record.getWholId());
		maps.put("kshs", pages.getStartRows());
		maps.put("jshs", pages.getRows());
		
		
 		List<WholesaleDetail> list = detailService.selectdetaiM(maps);
 		int selectCount = detailService.selectCount(maps);
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", selectCount);
		map.put("data", list);
		return map;
	}
}

