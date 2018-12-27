package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
           































import com.yidu.domain.Mrp;
import com.yidu.domain.MrpDetails;
import com.yidu.domain.Qc;
import com.yidu.domain.QcDetail;
import com.yidu.service.MrpDetailsService;
import com.yidu.service.MrpService;
import com.yidu.service.QcDetailService;
import com.yidu.service.QcService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 制造计划明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/mrpDetails")
public class MrpDetailsController {
	@Resource   
	private  MrpDetailsService  mrpDetailService; 
	@Resource   
	private  MrpService  mrpService; 
	@Resource
	private QcDetailService   qcDetailService;
	@Resource
	private   QcService   qcService;
	@RequestMapping("findById")
	@ResponseBody
	public   Map<String, Object>  findById(MrpDetails  mrpDetails,Integer page,Integer limit){
		//分页
		PageUtil pageUtil = new PageUtil();
		//前台取过来的分页值
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		List<MrpDetails> list = mrpDetailService.findById(mrpDetails, pageUtil); 
		int rows = mrpDetailService.findBycount(mrpDetails);
		//layui前台格式
		Map<String, Object>  map  = new  HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return  map;
	}
	@RequestMapping("update")
	@ResponseBody
	public   Message   update(MrpDetails  mrpDetails) {
		//传过来的数据
		String   name = mrpDetails.getShujuName(); 
		Message   message = new   Message();
		//拆分数据
		String   nameOne[]=name.split("#");
		int rows =0;   
		for (int i = 0; i < nameOne.length; i++) {
			String   str=UUID.randomUUID().toString().replaceAll("-", "");
			MrpDetails   mrpDetails2 =new   MrpDetails();
			mrpDetails2.setMrpId(mrpDetails.getMrpId());
			mrpDetails2.setMdId(str);
			//拆分成一个字段
			String   nametow[] = nameOne[i].split(",");
			//拆分后药品ID
			String drugId = nametow[0];
			mrpDetails2.setDrugId(drugId);
			//计划数量
			String num = nametow[1];
			Integer max = Integer.valueOf(num);
			//已完成的数量
			String    oknum =nametow[2];
			//增加的数量
			String    addnum =nametow[3];
			//未完成数量
			mrpDetails2.setMdRough(max-(Integer.valueOf(oknum)+Integer.valueOf(addnum)));
			//计划任务
			mrpDetails2.setMdPlan(max-Integer.valueOf(oknum));
			//本次完成的数量
			mrpDetails2.setMdAmount(Integer.valueOf(addnum)); 
			int  a = Integer.valueOf(oknum)+Integer.valueOf(addnum);  
			if (a==Integer.valueOf(num)) {
				mrpDetails2.setMdState(0);
			}else {
				mrpDetails2.setMdState(1); 
			} 
			if (a==Integer.valueOf(num)) {
				mrpDetails2.setMdView(0);
			}else {
				mrpDetails2.setMdView(1); 
			}
			Date   date  = new  Date();
			mrpDetails2.setMdTime(date);
			if (Integer.valueOf(addnum)>0.1) {
				rows= mrpDetailService.add(mrpDetails2);
			} 
		} 
		Mrp  mrp  = new   Mrp();
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(1); 
		int   Percentage =  mrpDetailService.findPercentage(mrpDetails);
		int     sum =  mrpDetailService.findmax(mrpDetails);
		String   progress  =   numberFormat.format((float) Percentage  /   (float)sum *100);
		mrp.setMrpId(mrpDetails.getMrpId());
		mrp.setMrpRate(progress);
		if (Percentage>0.1) {
			mrpService.Modifyprogress(mrp);
		} 
		Double  stt= 100.0;
		Double ii = Double.valueOf(progress);
		if(ii==stt) {
			mrp.setMrpId(mrpDetails.getMrpId());
			mrp.setMrpState(1);
			mrp.setMrpIdea(1);
			mrpService.Modifyprogresss(mrp);
		} 
		if (rows>0) {
			message.setStatus(1);
		}else {
			message.setStatus(0);
		}
		return message;
	}
	
	
	
	@RequestMapping("Preservation")
	@ResponseBody
	public  Message    Preservation(MrpDetails  mrpDetails) {
		Message   message  =new   Message();
		String   name = mrpDetails.getShujuName(); 
		String   nameOne[]=name.split("#");
		int  rows= 1;
		int   jj =0;
		int  kk=0;
		String  qcid=null;
		for (int i = 0; i < nameOne.length; i++) {
			QcDetail    qcDetali=new QcDetail();
			//拆分成一个字段
			String   nametow[] = nameOne[i].split(",");
			//药品ID
			String   drugId= nametow[0];
			qcDetali.setQdetFkId(drugId);
			//主键ID
			String  qcdID= nametow[1];
			qcDetali.setQdetId(qcdID);
			//质检总数量
			String   drugnum= nametow[2];
			kk=kk+Integer.valueOf(drugnum);
			qcDetali.setQdetAmount(Integer.valueOf(drugnum));
			//质检ID
			qcid = nametow[3];
			qcDetali.setQcId(qcid);
			//通过率
			String   qdetrate= nametow[4];
			qcDetali.setQdetRate(qdetrate);
			//未通过数
			String   qdetfail= nametow[5]; 
			qcDetali.setQdetFail(Integer.valueOf(qdetfail));
			int number =  Integer.valueOf(qdetfail);
			jj = jj+number; 
			rows = qcDetailService.updateByPrimaryKeySelective(qcDetali);
		}
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2); 
		Qc   qc  = new  Qc();
		qc.setQcFail(jj);
		String   progress  =   numberFormat.format((float) jj  /   (float)kk *100);
		qc.setQcRate(progress);
		Date  date   =new   Date();
		qc.setQcOptime(date);
		qc.setQcId(qcid);
		qc.setQcState("1");
		qc.setQcPut("0");
		rows= qcService.updateByPrimaryKeySelective(qc);
		if (rows>0) {
			message.setStatus(1);
		}else {
			message.setStatus(0);
		}
		return   message;  
	} 
}

