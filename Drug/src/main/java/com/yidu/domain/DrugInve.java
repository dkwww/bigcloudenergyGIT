package com.yidu.domain;

import java.util.Date;

public class DrugInve {
    private String diId;

    private String comId;

    private String drugId;

    private Integer diAmount;

    private String diComtype;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;

    public String getDiId() {
        return diId;
    }

    public void setDiId(String diId) {
        this.diId = diId == null ? null : diId.trim();
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId == null ? null : drugId.trim();
    }

    public Integer getDiAmount() {
        return diAmount;
    }

    public void setDiAmount(Integer diAmount) {
        this.diAmount = diAmount;
    }

    public String getDiComtype() {
        return diComtype;
    }

    public void setDiComtype(String diComtype) {
        this.diComtype = diComtype == null ? null : diComtype.trim();
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