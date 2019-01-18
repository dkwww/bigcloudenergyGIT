package com.yidu.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.PmcDetails;
import com.yidu.service.PmcDetailsService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 生产计划明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/pmcDetails")
public class PmcDetailsController {
	@Resource
	private PmcDetailsService pmcDetailsService;
	
	/**
	 * 根据生产计划显示生产明细
	 * @param record 生产明细模型类
	 * @param page 页数
	 * @param limit 行数
	 * @return map 生产明细数据
	 * @author ZhouJun
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(PmcDetails record,Integer page, Integer limit){
		//获得分页工具类
		PageUtil pageUtil = new PageUtil();
		//开始页数赋值
		pageUtil.setCurPage(page);
		//每页行数赋值
		pageUtil.setRows(limit);
		
		//条件查询生产计划明细
		List<PmcDetails> list = pmcDetailsService.findAll(record, pageUtil); 
		//获得条件查询生产计划明细的总行数
		int rows = pmcDetailsService.selectCountBySelective(record);
		
		//获得一个map对象并赋值
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return  map;
	}
	
	
	/**
	 * 怎加或修改
	 * @param record 生产明细模型类
	 * @return mes json工具类
	 * @author ZhouJun
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public Message addOrUpdate(@RequestBody PmcDetails record) {
		//增加或修改并或的处理的行数
		int rows = pmcDetailsService.addOrUpdate(record);
		//json信息工具类
		Message mes = new Message();
		//如果处理的行数大于零
		if (rows > 0) {
			//赋值成功信息
			mes.setStatus(1);
			mes.setMsg("操作成功！");
		} else {
			//赋值失败信息
			mes.setStatus(0);
			mes.setMsg("操作失败，请稍后重试！");
		}
		return mes;
	}
	
	/**
	 * 显示带制造完成度的生产明细
	 * @param record 生产明细模型类
	 * @param page 页数
	 * @param limit 行数
	 * @param mrpId 制造计划id
	 * @return map 生产计划数据
	 * @author ZhouJun
	 */
	@RequestMapping("/findByPmc")
	@ResponseBody
	public Map<String, Object> findByPmc(PmcDetails record,Integer page, Integer limit, String mrpId){
		//获得分页工具类
		PageUtil pageUtil = new PageUtil();
		//开始页数赋值
		pageUtil.setCurPage(page);
		//每页的行数赋值
		pageUtil.setRows(limit);
		
		//条件查询生产计划
		List<PmcDetails> list = pmcDetailsService.findByPmc(record, pageUtil, mrpId); 
		//获得条件查询生产计划的总行数
		int rows = pmcDetailsService.selectCountBySelective(record);
		//获得一个map对象并赋值
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return  map;
	}
	
	/**
	 * 查询药品原材料库存
	 * @param drugId 药品id
	 * @return list 原材料库存
	 * @author ZhouJun
	 */
	@RequestMapping("/checkInv")
	@ResponseBody
	public List<PmcDetails> checkInv(String drugId) {
		//根据药品查询原材料库存
		return pmcDetailsService.checkInv(drugId);
	}
}

