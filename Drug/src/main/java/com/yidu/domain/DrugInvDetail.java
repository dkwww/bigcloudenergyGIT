package com.yidu.domain;

import java.util.Date;

public class DrugInvDetail {
    private String didId;

    private String diId;

    private Integer diAmount;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;

    public String getDidId() {
        return didId;
    }

    public void setDidId(String didId) {
        this.didId = didId == null ? null : didId.trim();
    }

    public String getDiId() {
        return diId;
    }

    public void setDiId(String diId) {
        this.diId = diId == null ? null : diId.trim();
    }

    public Integer getDiAmount() {
        return diAmount;
    }

    public void setDiAmount(Integer diAmount) {
        this.diAmount = diAmount;
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