package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Mrp;
import com.yidu.service.MrpService;
import com.yidu.util.TimeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 制造计划 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/mrp")
public class MrpController {
	@Resource
	private  MrpService   mrpService ;
	
	
	/**
	 * 查询所有的方法
	 * @param mrp
	 * @return
	 */
	@RequestMapping("qureyAll")
	@ResponseBody
	public  Map<String, Object>  qureyAll(Mrp  mrp){
		List<Mrp> lists=new ArrayList<Mrp>();
		List<Mrp> list = mrpService.qureyAll(); 
		for (Mrp mrp2 : list) {
			System.out.println("-----------"+mrp2.getStateName());
		}
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Mrp mrp2 = (Mrp) iterator.next();
			TimeUtil.dateToString(mrp2.getOptime(), "yyyy-mm-dd");
			lists.add(mrp2);
		} 
		Map<String, Object>  map  = new  HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 10);
		map.put("data", lists);
		return  map;
	}

}

