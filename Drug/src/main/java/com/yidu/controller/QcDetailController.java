package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.QcDetail;
import com.yidu.service.QcDetailService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 材料质检明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/qcDetail")
public class QcDetailController {
	
	@Resource
	private QcDetailService qcdetaService;
	
	/**
	 * 根据id查询
	 * @param qcdetail
	 * @return
	 */
	@RequestMapping("findById")
	@ResponseBody
	public Map<String, Object> findById(QcDetail qcdetail, Integer  page , Integer  limit){
		PageUtil pageUtil = new PageUtil();
		//前台取过来的分页值
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		List <QcDetail> list=qcdetaService.selectbyId(qcdetail,pageUtil);
		int  rows  = qcdetaService.selectbycount(qcdetail);
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list); 
		return map;
	} 
	/**
	 * 根据质检id查看质检明细
	 * @param qcdetail
	 * @author 邓康威
	 * @return
	 */
	@RequestMapping("findBuyId")
	@ResponseBody
	public Map<String, Object> findBuyId(QcDetail qcdetail){
		List <QcDetail> list=qcdetaService.findByIds(qcdetail.getQcId());
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 0);
		map.put("data", list);
		
		return map;
	}
	/**
	 * 根据质检id查看质检明细
	 * @param qcdetail
	 * @author zhengyouhong
	 * @return
	 */
	@RequestMapping("findBuyIds")
	@ResponseBody
	public Map<String, Object> findBuyIds(QcDetail qcdetail){
		List <QcDetail> list=qcdetaService.findByIdss(qcdetail.getQcId());
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 0);
		map.put("data", list);
		
		return map;
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@RequestMapping("/findByQcId")
	@ResponseBody
	public List<QcDetail> findByQcId(String id){
		return qcdetaService.findByQcId(id);
	}
}

