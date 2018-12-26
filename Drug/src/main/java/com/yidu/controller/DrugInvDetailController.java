package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.DrugInvDetail;
import com.yidu.domain.DrugInve;
import com.yidu.domain.Qc;
import com.yidu.domain.QcDetail;
import com.yidu.service.DrugInvDetailService;
import com.yidu.service.DrugInvService;
import com.yidu.service.QcDetailService;
import com.yidu.util.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

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
	 DrugInvService   drugInvService;
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
		int  rows =0;
		for (QcDetail qcDetail : list) {
			DrugInve   drugInve  =new DrugInve();
			DrugInvDetail  drugInvDetail  = new  DrugInvDetail();
			String    string= UUID.randomUUID().toString().replaceAll("-", "");
			String     str= UUID.randomUUID().toString().replaceAll("-", "");
			  List<DrugInve> drugList = drugInvService.selectDrugId(qcDetail.getQdetFkId());
			 
			if (!drugList.isEmpty()) {
					drugInve.setDrugId(qcDetail.getQdetFkId());
					int  sum=qcDetail.getQdetAmount()-qcDetail.getQdetFail();
					drugInve.setDiAmount(sum);
				  drugInvService.updateamount(drugInve);
				//==============================分界线=======================
					drugInvDetail.setDidId(str);
					for (DrugInve drugInve2 : drugList) {
						drugInvDetail.setDiId(drugInve2.getDiId());
			 
					}
					
					int  sums=qcDetail.getQdetAmount()-qcDetail.getQdetFail();
					drugInvDetail.setDiAmount(sums);
					drugInvDetail.setRemarks(0);
				 drugInvDetailService.insert(drugInvDetail);
			} else { 
				drugInve.setDiId(string);
				drugInve.setComId("0");
				drugInve.setDrugId(qcDetail.getQdetFkId());
				int  sum=qcDetail.getQdetAmount()-qcDetail.getQdetFail();
				drugInve.setDiAmount(sum);
				drugInve.setDiComtype("0");
			  rows = drugInvService.insert(drugInve);
			//==============================分界线=======================
				drugInvDetail.setDidId(str);
				drugInvDetail.setDiId(string);
				int  sums=qcDetail.getQdetAmount()-qcDetail.getQdetFail();
				drugInvDetail.setDiAmount(sums);
				drugInvDetail.setRemarks(0);
			 drugInvDetailService.insert(drugInvDetail);
				
			} 
		}
		if (rows>0) {
			message.setStatus(1);
			message.setMsg("保存成功");
		}else {
			message.setStatus(0);
			message.setMsg("保存失败");
		}
		
	 
		return  message;
	}
	
}

