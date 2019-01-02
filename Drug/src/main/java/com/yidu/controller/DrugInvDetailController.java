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
import com.yidu.service.QcService;
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
	@Resource
	private    QcService  qcService;



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
	/**
	 * 增加库存和库存明细
	 * @param qc
	 * @return
	 */
	@RequestMapping("addAll")
	@ResponseBody
	public   Message   addAll(Qc  qc ) { 
		//返回一个提示信息
		Message  message  =new  Message() ;
		//根据质检的Id查出所有的信息
		List<QcDetail> list = qcdetaService.selectQcId(qc.getQcId());
		//定义一个rows 看是否增加成功
		int  rows =0;
		//将集合遍历
		for (QcDetail qcDetail : list) {
			//创建一个库存接收对象
			DrugInve   drugInve  =new DrugInve();
			//创建一个库存明细接收对象
			DrugInvDetail  drugInvDetail  = new  DrugInvDetail();
			//这个是库存的UUID 用于增加
			 String    string= UUID.randomUUID().toString().replaceAll("-", "");
			 //这是库存明细的UUID  也是用于增加
			String     str= UUID.randomUUID().toString().replaceAll("-", "");
			//判断库存有没有这个药品
			List<DrugInve> drugList = drugInvService.selectDrugId(qcDetail.getQdetFkId());
			//如果集合为空     就在库存里加一行  如果不为空  就直接加数量
			if (!drugList.isEmpty()) {
				// 用库存对象接收值然后增加。。
				//药品ID 
				drugInve.setDrugId(qcDetail.getQdetFkId());
				//库存数量    用 查出来的质检总数  减去未通过的数量
				int  sum=qcDetail.getQdetAmount()-qcDetail.getQdetFail();
				//应该入库的数量
				drugInve.setDiAmount(sum);
				//增加库存数量
				drugInvService.updateamount(drugInve);
				//这是增加库存明细
				//使用UUID
				drugInvDetail.setDidId(str);
				//这是外键
				for (DrugInve drugInve2 : drugList) {
					//库存明细的外键是库存的主键
					drugInvDetail.setDiId(drugInve2.getDiId());
				}
				//入库了多少个药品
				int  sums=qcDetail.getQdetAmount()-qcDetail.getQdetFail();
				drugInvDetail.setDiAmount(sums);
				//默认为入库 
				drugInvDetail.setRemarks(0);
				//增加一条库存明细
				drugInvDetailService.insert(drugInvDetail);
			//否则的话就是没有这条信息
			} else {
				//商家ID
				drugInve.setComId("0");
				//增加的药品ID
				drugInve.setDrugId(qcDetail.getQdetFkId());
				//库存数量    用 查出来的质检总数  减去未通过的数量
				int  sum=qcDetail.getQdetAmount()-qcDetail.getQdetFail();
				drugInve.setDiAmount(sum);
				//
				drugInve.setDiComtype("0");
				drugInve.setDiId(string);
				rows = drugInvService.insert(drugInve);
				drugInvDetail.setDidId(str);
				drugInvDetail.setDiId(string);
				int  sums=qcDetail.getQdetAmount()-qcDetail.getQdetFail();
				drugInvDetail.setDiAmount(sums);
				drugInvDetail.setRemarks(0);
				drugInvDetailService.insert(drugInvDetail);
			} 
		}

		Qc  qc2  = new  Qc();
		qc2.setQcId(qc.getQcId());
		qc2.setQcPut("1");
		qcService.updateByPrimaryKeySelective(qc2);


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