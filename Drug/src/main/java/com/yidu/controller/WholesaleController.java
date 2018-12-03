package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidu.domain.Drug;
import com.yidu.domain.Wholesale;
import com.yidu.service.WholesaleService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 分店批发 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/wholesale")
public class WholesaleController {
	@Resource
	private WholesaleService service;
	
	@RequestMapping("/selectAll")
	@ResponseBody
	public Map<String,Object> selectAll(@RequestParam(value = "limit",required = false)Integer limit,
			@RequestParam(value = "page" ,required = false)Integer page, Wholesale record){
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
		
		List<Wholesale> lists=new ArrayList<>();
 		List<Wholesale> list = service.selectAll(maps);
 		int selectCount = service.selectCount(maps);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Wholesale wholesale = (Wholesale) iterator.next();
			TimeUtil.dateToString(wholesale.getOptime(), "yyyy-MM-dd");
			lists.add(wholesale);
		}
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", selectCount);
		map.put("data", lists);
		return map;
	}
	
	@RequestMapping("/updateisva")
	@ResponseBody
	public int updateisva(Wholesale wholesale){
		return service.updateisva(wholesale);
	}	
	
	/**
	 * 增加或修改
	 * @return Message json信息类
	 */
	@RequestMapping("/addorupdate")
	@ResponseBody
	public Message addorupdate(@RequestBody Wholesale record) {
		int rows = service.addOrUpdate(record);
		Message mes = new Message();
		if (rows>0) {
			mes.setStatus(1);
			mes.setMsg("操作成功");
		} else {
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		return mes;
	}
}

