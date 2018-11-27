package com.yidu.domain;

import java.util.Date;

public class Pmc {
    private String pmcId;

    private Integer pmcAmount;

    private Date pmcStart;

    private Date pmcEnd;

    private String pmcState;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;

    public String getPmcId() {
        return pmcId;
    }

    public void setPmcId(String pmcId) {
        this.pmcId = pmcId == null ? null : pmcId.trim();
    }

    public Integer getPmcAmount() {
        return pmcAmount;
    }

    public void setPmcAmount(Integer pmcAmount) {
        this.pmcAmount = pmcAmount;
    }

    public Date getPmcStart() {
        return pmcStart;
    }

    public void setPmcStart(Date pmcStart) {
        this.pmcStart = pmcStart;
    }

    public Date getPmcEnd() {
        return pmcEnd;
    }

    public void setPmcEnd(Date pmcEnd) {
        this.pmcEnd = pmcEnd;
    }

    public String getPmcState() {
        return pmcState;
    }

    public void setPmcState(String pmcState) {
        this.pmcState = pmcState == null ? null : pmcState.trim();
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