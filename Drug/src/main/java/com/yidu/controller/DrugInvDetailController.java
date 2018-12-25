package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.DrugInvDetail;
import com.yidu.domain.DrugInve;
import com.yidu.domain.Qc;
import com.yidu.domain.QcDetail;
import com.yidu.service.DrugInvDetailService;
import com.yidu.service.QcDetailService;
import com.yidu.util.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 药品库存明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/drugInvDetail")
public class DrugInvDetailController {

	
	@Resource
	
	private   DrugInvDetailService   drugInvDetailService;
	@Resource
	private QcDetailService qcdetaService;
	
	
	
	@RequestMapping("findById")
	@ResponseBody
	public   Map<String , Object>  findById(DrugInvDetail drugInvDetail){
		
		List<DrugInvDetail> list = drugInvDetailService.findById(drugInvDetail.getDiId());
		int    rows=drugInvDetailService.selectcount(drugInvDetail.getDiId());
		Map<String, Object>  map  =new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return  map;
	}
	
	@RequestMapping("addAll")
	@ResponseBody
	public   Message   addAll(Qc  qc) {
		Message  message  =new  Message() ;
		List<QcDetail> list = qcdetaService.selectQcId(qc.getQcId());
		
		for (QcDetail qcDetail : list) {
			DrugInve   drugInve  =new DrugInve();
			DrugInvDetail  drugInvDetail  = new  DrugInvDetail();
			String    string= UUID.randomUUID().toString().replaceAll("-", "");
			String     str= UUID.randomUUID().toString().replaceAll("-", "");
			drugInve.setDiId(string);
			drugInve.setDrugId(qcDetail.getQdetFkId());
			drugInve.setComId("0");
			int  sum=qcDetail.getQdetAmount()-qcDetail.getQdetFail();
			drugInve.setDiAmount(sum);
			drugInve.setDiComtype("0");
			//==============================分界线=======================
			drugInvDetail.setDidId(str);
			drugInvDetail.setDiId(string);
			drugInvDetail.setDiAmount(sum);
			drugInvDetail.setRemarks(1);
			
			
		}
		
		
	 
		return  message;
	}
	
}

