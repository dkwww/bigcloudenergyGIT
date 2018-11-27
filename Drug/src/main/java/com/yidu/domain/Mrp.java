package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Mrp {
    private String mrpId;

    private String drugId;

    private Date mrpOptime;

    private Integer mrpPlan;

    private BigDecimal mrpRate;

    private String mrpState;

    private String mrpIdea;

    private Integer mrpAmount;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;

    public String getMrpId() {
        return mrpId;
    }

    public void setMrpId(String mrpId) {
        this.mrpId = mrpId == null ? null : mrpId.trim();
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId == null ? null : drugId.trim();
    }

    public Date getMrpOptime() {
        return mrpOptime;
    }

    public void setMrpOptime(Date mrpOptime) {
        this.mrpOptime = mrpOptime;
    }

    public Integer getMrpPlan() {
        return mrpPlan;
    }

    public void setMrpPlan(Integer mrpPlan) {
        this.mrpPlan = mrpPlan;
    }

    public BigDecimal getMrpRate() {
        return mrpRate;
    }

    public void setMrpRate(BigDecimal mrpRate) {
        this.mrpRate = mrpRate;
    }

    public String getMrpState() {
        return mrpState;
    }

    public void setMrpState(String mrpState) {
        this.mrpState = mrpState == null ? null : mrpState.trim();
    }

    public String getMrpIdea() {
        return mrpIdea;
    }

    public void setMrpIdea(String mrpIdea) {
        this.mrpIdea = mrpIdea == null ? null : mrpIdea.trim();
    }

    public Integer getMrpAmount() {
        return mrpAmount;
    }

    public void setMrpAmount(Integer mrpAmount) {
        this.mrpAmount = mrpAmount;
    }

    public String getIsva() {
        return isva;
    }

    public void setIsva(String isva) {
        this.isva = isva == null ? null : isva.trim();
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
        this.oper = oper == null ? null : oper.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }
}