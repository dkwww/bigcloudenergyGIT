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
 * @author Likai
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/WholesaleDetail")
public class WholesaleDetailController {
	@Resource
	WholesaleDetailService detailService;
	
	/**
	 * 添加到批发明细
	 * @param WholesaleDetailDetail
	 * @return
	 */
	@RequestMapping("insertAdd")
	public int insertAdd(WholesaleDetail WholesaleDetailDetail) {
		return detailService.insertSelective(WholesaleDetailDetail);
	}   
	
	
	/**
	 * 查询所有
	 * @param limit
	 * @param page
	 * @param record
	 * @return
	 */
	@RequestMapping("/selectAll")
	@ResponseBody
	public Map<String,Object> selectAll(@RequestParam(value = "limit",required = false)Integer limit,
			@RequestParam(value = "page" ,required = false)Integer page, WholesaleDetail record){
		//调用分页工具
		PageUtil pages=new PageUtil();
		//判断分页的参数是否为空
		if(limit!=null && page!=null) {
			//赋值总页数
			pages.setCurPage(page);
			//赋值行数
			pages.setRows(limit);
		}
		//创建一个map
		Map<String, Object> maps=new HashMap<String,Object >();
		//赋值一个批发ID
		maps.put("title",record.getWholId());
		//map赋值总页数
		maps.put("kshs", pages.getStartRows());
		//map赋值行数
		maps.put("jshs", pages.getRows());
		
		//调用查询批发明细的方法
 		List<WholesaleDetail> list = detailService.selectdetaiM(maps);
 		//调用查看总数的方法
 		int selectCount = detailService.selectCount(maps);
		@SuppressWarnings("unchecked")
		//创建MAp对象
		Map<String,Object> map = new HashedMap();
		//赋值code
		map.put("code", 0);
		//赋值msg
		map.put("msg", "");
		//赋值总数
		map.put("count", selectCount);
		//赋值内容
		map.put("data", list);
		//返回map
		return map;
	}
}

