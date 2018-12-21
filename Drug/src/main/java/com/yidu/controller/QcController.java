package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Pmc;
import com.yidu.domain.PmcDetails;
import com.yidu.domain.Qc;
import com.yidu.domain.QcDetail;
import com.yidu.service.PmcDetailsService;
import com.yidu.service.PmcService;
import com.yidu.service.QcDetailService;
import com.yidu.service.QcService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 质检表 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/qc")
public class QcController {
	@Resource
	private   QcService   qcService;
	@Resource
	private PmcService pmcService;
	@Resource
	private PmcDetailsService pmcDetailsService;
	@Resource
	private QcDetailService   qcDetailService;
	//查询 药品质检

	@RequestMapping("/qureyAll")
	@ResponseBody
	public   Map<String , Object>  qureyAll(Qc  qc  , Integer  page , Integer  limit){
		//分页
		PageUtil pageUtil = new PageUtil();
		//前台取过来的分页值
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);

		List<Qc> list = qcService.selectqctype(qc, pageUtil);
		int rows = qcService.selectCountBySelective(qc);
		Map<String , Object>  map  =new  HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return  map;
	} 


	@RequestMapping("/add")
	@ResponseBody
	public   Message    add(Qc  qc) {
		String    string= UUID.randomUUID().toString().replaceAll("-", "");
		String    strings= UUID.randomUUID().toString().replaceAll("-", "");
		//分页
		 
		Message message  =new   Message();
		Pmc pmc = pmcService.selectById(qc.getPmcId());
		PmcDetails  pmcDetails=new   PmcDetails();
		
		pmcDetails.setPmcId(qc.getPmcId());
		List<PmcDetails> list = pmcDetailsService.findAll(pmcDetails, null);
		for (PmcDetails pmcDetails2 : list) {
			QcDetail  qcDetail=  new   QcDetail();
			qcDetail.setQcId(string);
			qcDetail.setQdetId(strings);
			qcDetail.setQdetAmount(pmcDetails2.getPdAmount());
			qcDetail.setQdetFail(0);
			qcDetail.setQdetRate("0%");
			
		} 
		qc.setQcId(string);
		qc.setPmcId(pmc.getPmcId());
		qc.setQcAmount(pmc.getPmcAmount());
		qc.setQcRate("0");
		qc.setQcFail(0);
		qc.setQcConpany("目前不知道是啥工厂");
		qc.setQcType(0); 
		Date   date =new Date();
		qc.setOptime(date);
		int rows= qcService.add(qc); 
		if (rows>0) {
			message.setStatus(1);
		}else {
			message.setStatus(0);
		}

		return  message;
	} 

}

