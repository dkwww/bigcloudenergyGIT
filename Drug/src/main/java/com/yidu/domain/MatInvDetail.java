package com.yidu.domain;

import java.util.Date;

public class MatInvDetail {
    private String midId;

    private String miId;

    private Integer midAmount;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;

    public String getMidId() {
        return midId;
    }

    public void setMidId(String midId) {
        this.midId = midId == null ? null : midId.trim();
    }

    public String getMiId() {
        return miId;
    }

    public void setMiId(String miId) {
        this.miId = miId == null ? null : miId.trim();
    }

    public Integer getMidAmount() {
        return midAmount;
    }

    public void setMidAmount(Integer midAmount) {
        this.midAmount = midAmount;
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