package com.yidu.domain;

import java.util.Date;

import javax.mail.search.StringTerm;

public class MrpDetails {
   	 private  String   mdId;  //主键  ID
	 private  String   mrpId  ; //  制造计划ID  无关联外键
	 private  String  comId ;  //计划厂家 
	 private  String  drugId ;   //药品ID  外键
	 private  Integer    mdPlan ;  //计划任务
	 private  Double    mdRate  ;  //进度 
	 private   String  mdState ;    //  状态
	 private   Integer  mdRough;    //未完成部分
	 private   String  mdView  ;    //  处理意见
	 private Integer mrpAmount  ;  //制造次数
	 private  String    Isva ;   //是否有效
	 private   Date  optime ;    //操作时间
	 private   String   oper;	  //操作人
	 private   String  sort;	//排序 
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
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	public String getDrugId() {
		return drugId;
	}
	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}
	public Integer getMdPlan() {
		return mdPlan;
	}
	public void setMdPlan(Integer mdPlan) {
		this.mdPlan = mdPlan;
	}
	public Double getMdRate() {
		return mdRate;
	}
	public void setMdRate(Double mdRate) {
		this.mdRate = mdRate;
	}
	public String getMdState() {
		return mdState;
	}
	public void setMdState(String mdState) {
		this.mdState = mdState;
	}
	public Integer getMdRough() {
		return mdRough;
	}
	public void setMdRough(Integer mdRough) {
		this.mdRough = mdRough;
	}
	public String getMdView() {
		return mdView;
	}
	public void setMdView(String mdView) {
		this.mdView = mdView;
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