package com.yidu.domain;

import java.util.Date;


public class MrpDetails {
   	 private  String   mdId;  //主键  ID
	 private  String   mrpId  ; //  制造计划ID  无关联外键
	 
	 private  String  drugId ;   //药品ID  外键
	 private   String   drugName;
	 private  Integer    mdPlan ;  //计划任务
 
	 private    Integer mdState ;    //  状态
	 private    String   mdStateName;  
	 private   Integer  mdRough;    //未完成部分
	 private   Integer  mdView  ;    //  处理意见
	 private   String   mdViewName;  //处理意见
	 private Integer mrpAmount  ;  //制造次数
	 private  String    Isva ;   //是否有效
	 private   Date  optime ;    //操作时间
	 private   String   oper;	  //操作人
	 private   String  sort;	//排序 
	 private   String   comName;
	 private    Date   mdTime;
	 private  String    mdTimeName;
	 
	 private   Integer   mdAmount;   
	 
	 
	 private   String  shujuName;
	 
	 
	 
	 
	 
	public String getShujuName() {
		return shujuName;
	}
	public void setShujuName(String shujuName) {
		this.shujuName = shujuName;
	}
	public String getDrugId() {
		return drugId;
	}
	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}
	public Integer getMdAmount() {
		return mdAmount;
	}
	public void setMdAmount(Integer mdAmount) {
		this.mdAmount = mdAmount;
	}
	public Date getMdTime() {
		return mdTime;
	}
	public void setMdTime(Date mdTime) {
		this.mdTime = mdTime;
	}
	public String getMdTimeName() {
		return mdTimeName;
	}
	public void setMdTimeName(String mdTimeName) {
		this.mdTimeName = mdTimeName;
	}
	public Integer getMdView() {
		return mdView;
	}
	public void setMdView(Integer mdView) {
		this.mdView = mdView;
	}
	public String getMdViewName() {
		return mdViewName;
	}
	public void setMdViewName(String mdViewName) {
		this.mdViewName = mdViewName;
	}
	public String getMdStateName() {
		return mdStateName;
	}
	public void setMdStateName(String mdStateName) {
		this.mdStateName = mdStateName;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getMdId() {
		return mdId;
	}
	public void setMdId(String mdId) {
		this.mdId = mdId;
	}
	public String getMrpId() {
		return mrpId;
	}
	public void setMrpId(String mrpId) {
		this.mrpId = mrpId;
	}
	
	 
	public Integer getMdPlan() {
		return mdPlan;
	}
	public void setMdPlan(Integer mdPlan) {
		this.mdPlan = mdPlan;
	}
	 
	 
	public Integer getMdState() {
		return mdState;
	}
	public void setMdState(Integer mdState) {
		this.mdState = mdState;
	}
	public Integer getMdRough() {
		return mdRough;
	}
	public void setMdRough(Integer mdRough) {
		this.mdRough = mdRough;
	}
	 
	public Integer getMrpAmount() {
		return mrpAmount;
	}
	public void setMrpAmount(Integer mrpAmount) {
		this.mrpAmount = mrpAmount;
	}
	public String getIsva() {
		return Isva;
	}
	public void setIsva(String isva) {
		Isva = isva;
	}
	public Date getOptime() {
		return optime;
	}
	public void setOptime(Date optime) {
		this.optime = optime;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	   
	 
	 
	 
	 
	 
}