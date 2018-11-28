package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Drug;
import com.yidu.domain.Wholesale;
import com.yidu.service.WholesaleService;
import com.yidu.util.TimeUtil;

import java.util.ArrayList;
import java.util.Iterator;
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
@RequestMapping("/wholesaleDetail")
public class WholesaleDetailController {
	@Resource
	private WholesaleService service;
	
	@RequestMapping("/selectAll")
	@ResponseBody
	public Map<String,Object> selectAll(Wholesale record){
		List<Wholesale> lists=new ArrayList<>();
		List<Wholesale> list = service.selectAll(record);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Wholesale wholesale = (Wholesale) iterator.next();
			TimeUtil.dateToString(wholesale.getOptime(), "yyyy-MM-dd");
			lists.add(wholesale);
		}
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 10);
		map.put("data", lists);
		return map;
	}
	
	@RequestMapping("/updateisva")
	@ResponseBody
	public int updateisva(Wholesale wholesale){
		return service.updateisva(wholesale);
	}
}

