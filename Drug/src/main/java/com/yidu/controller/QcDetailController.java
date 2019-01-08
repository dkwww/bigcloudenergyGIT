package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.QcDetail;
import com.yidu.service.QcDetailService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

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
 * @author dengkangwei
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
		for (QcDetail qcDetail2 : list) {
				qcDetail2.setSjName(TimeUtil.dateToString(qcDetail2.getQdetOptime(), "yyyy-mm-dd"));
		}
		int  rows  = qcdetaService.selectbycount(qcdetail);
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list); 
		return map;
	} 
	/**
	 * 
	 * 方法说明：根据质检id查看质检明细
	 * @param qcdetail 质检明细对象
	 * @param page	页数
	 * @param limit	行数
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月8日
	 */
	@RequestMapping("findBuyId")
	@ResponseBody
	public Map<String, Object> findBuyId(QcDetail qcdetail,Integer page,Integer limit){
		//得到分页工具对象
		PageUtil pageUtil = new PageUtil();
		//判断页数不等于空 且 行数不等于空
		if(page!=null && limit!=null) {
			//赋值页数
			pageUtil.setCurPage(page);
			//赋值行数
			pageUtil.setRows(limit);
		}
		//查询质检明细集合
		List <QcDetail> list=qcdetaService.findByIds(qcdetail,pageUtil);
		//查询质检明细总行数
		int rows=qcdetaService.findByIdselectCount(qcdetail);
		//创建map对象
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

