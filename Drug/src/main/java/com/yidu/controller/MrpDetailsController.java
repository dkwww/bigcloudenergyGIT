package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Mrp;
import com.yidu.domain.MrpDetails;
import com.yidu.domain.Qc;
import com.yidu.domain.QcDetail;
import com.yidu.service.MatInvService;
import com.yidu.service.MaterialListService;
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
	//制造明细service
	@Resource   
	private  MrpDetailsService  mrpDetailService; 
	//制造计划service
	@Resource   
	private  MrpService  mrpService; 
	//质检明细service
	@Resource
	private QcDetailService   qcDetailService;
	//质检service
	@Resource
	private QcService qcService;
	//物料清单
	@Resource
	private MaterialListService materialListService;
	//原材料库存service
	@Resource
	private MatInvService matinvservice;
	
	
	/**
	 * 根据ID查询制造详细
	 * @param mrpDetails  制造详细对象
	 * @param page  layui自带的分页
	 * @param limit  layui自带的分页
	 * @return
	 * @author Pngjiangping
	 */
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
	
	/**
	 * 增加制造详细
	 * @param mrpDetails
	 * @return
	 * @author Pngjiangping
	 * @date：2019年1月8日 
	 */
	@RequestMapping("update")
	@ResponseBody
	public   Message   update(MrpDetails  mrpDetails) {
		//传过来的数据
		String   name = mrpDetails.getShujuName();  
		//返回提示信息
		Message   message = new   Message();
		//将传过来的数据拆分为数组
		String   nameOne[]=name.split("#");
		int rows =0;   
		//循环拆分的数组
		for (int i = 0; i < nameOne.length; i++) {
			String   str=UUID.randomUUID().toString().replaceAll("-", "");
			//定义一个对象用于接受下面的拆分值 增加
			MrpDetails   mrpDetails2 =new   MrpDetails();
			//制造计划的外键
			mrpDetails2.setMrpId(mrpDetails.getMrpId());
			//制造计划的主键
			mrpDetails2.setMdId(str);
			//拆分成一个字段
			String   nametow[] = nameOne[i].split(",");
			//药品ID
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
			//a是已经完成和本次完成的
			int  a = Integer.valueOf(oknum)+Integer.valueOf(addnum); 
			//判断是否和计划任务相等
			if (a==Integer.valueOf(num)) {
				//改变状态
				mrpDetails2.setMdState(0);
			}else {
				//否则就不更改
				mrpDetails2.setMdState(1); 
			} 
			//当完成了计划数量
			if (a==Integer.valueOf(num)) {
				//将制作详细的意见改为停止
				mrpDetails2.setMdView(0);
			}else {
				//否则设为继续
				mrpDetails2.setMdView(1); 
			}
			//创建一个当前时间
			Date   date  = new  Date();
			//设置一个制造时间
			mrpDetails2.setMdTime(date);
			//当制造数量大于1个时才增加制造详细
			if (Integer.valueOf(addnum)>0.1) {
				//增加制造详情
				rows= mrpDetailService.add(mrpDetails2);
			} 
		} 
		//创建一个制造计划的对象
		Mrp  mrp  = new   Mrp();
		//使用求百分比的方法
		NumberFormat numberFormat = NumberFormat.getInstance();
		//不需要小数位
		numberFormat.setMaximumFractionDigits(0); 
		//将制作详情查出
		int   Percentage =  mrpDetailService.findPercentage(mrpDetails);
		//查询最大的值
		int     sum =  mrpDetailService.findmax(mrpDetails);
		//计算出百分比
		String   progress  =   numberFormat.format((float) Percentage  /   (float)sum *100);
		//质检明细的ID
		mrp.setMrpId(mrpDetails.getMrpId());
		//进度
		mrp.setMrpRate(progress);
		//如果制造大于0.1就改变制造进度
		if (Percentage>0.1) {
			//根据ID改变制造进度
			mrpService.Modifyprogress(mrp);
		} 
		//将百分比的值转换为数字类型
		Integer ii = Integer.valueOf(progress);
		//判断  如果百分比等于100的话就将状态改为停止 
		if(ii==100) {
			//将这条信息的状态改为停止
			mrp.setMrpId(mrpDetails.getMrpId());
			//0未未入库
			mrp.setMrpState(0);
			//0未停止制造
			mrp.setMrpIdea(0);
			//修改状态
			mrpService.Modifyprogresss(mrp);
		 
		}
		if (rows>0) {
			message.setStatus(1);
		}else {
			message.setStatus(0);
		}
		//返回提示信息
		return message;
	}
	
	/**
	 * 提交质检
	 * @param mrpDetails  制造明细对象
	 * @return
	 * @author Pngjiangping
	 * @date：2019年1月10日 
	 */
	
	@RequestMapping("Preservation")
	@ResponseBody
	public  Message    Preservation(MrpDetails  mrpDetails) {
		//提示信息对象
		Message   message  =new   Message();
		//前台穿过来的封装数据
		String   name = mrpDetails.getShujuName(); 
		//将数据拆分
		String   nameOne[]=name.split("#");
		//定义变量
		int  rows= 1;
		//定义变量
		int   jj =0;
		//定义变量
		int  kk=0;
		//
		String  qcid=null;
		for (int i = 0; i < nameOne.length; i++) {
			QcDetail qcDetali=new QcDetail();
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
			//质检药品数量 
			qcDetali.setQdetFail(Integer.valueOf(qdetfail));
			//将质检药品数量转成数字型
			int number =  Integer.valueOf(qdetfail);
			//将所有的药品数量相加计算百分率
			jj = jj+number; 
			//修改质检详细
			rows = qcDetailService.updateByPrimaryKeySelective(qcDetali);
		}
		//工具类  用于计算百分率的
		NumberFormat numberFormat = NumberFormat.getInstance();
		//保留小数
		numberFormat.setMaximumFractionDigits(0); 
		//质检对象
		Qc   qc  = new  Qc();
		//质检的总数量
		qc.setQcFail(jj);
		//计算百分率
		String   progress  =   numberFormat.format(100-(float) jj  /   (float)kk   *100);
		//质检百分比
		qc.setQcRate(progress);
		//创建一个当前时间
		Date  date   =new   Date();
		//质检时间
		qc.setQcOptime(date);
		//根据QcId修改
		qc.setQcId(qcid);
		//状态改为已质检
		qc.setQcState("1");
		//未入库
		qc.setQcPut("0");
		//修改质检状态和
		rows= qcService.updateByPrimaryKeySelective(qc);
		if (rows>0) {
			message.setStatus(1);
		}else {
			message.setStatus(0);
		}
		//返回提示信息
		return   message;  
	} 
}

