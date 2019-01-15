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
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		List<PmcDetails> list = pmcDetailsService.findAll(record, pageUtil); 
		int rows = pmcDetailsService.selectCountBySelective(record);
		
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
		int rows = pmcDetailsService.addOrUpdate(record);
		Message mes = new Message();
		if (rows > 0) {
			mes.setStatus(1);
			mes.setMsg("操作成功！");
		} else {
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
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		List<PmcDetails> list = pmcDetailsService.findByPmc(record, pageUtil, mrpId); 
		int rows = pmcDetailsService.selectCountBySelective(record);
		
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
		return pmcDetailsService.checkInv(drugId);
	}
}

