package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Qc {
    private String qcId;

    private String comId;

    private Integer qcAmount;

    private Integer qcFail;

    private BigDecimal qcRate;

    private Date qcOptime;

    private String qcConpany;

    private String qcType;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;

    public String getQcId() {
        return qcId;
    }

    public void setQcId(String qcId) {
        this.qcId = qcId == null ? null : qcId.trim();
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    public Integer getQcAmount() {
        return qcAmount;
    }

    public void setQcAmount(Integer qcAmount) {
        this.qcAmount = qcAmount;
    }

    public Integer getQcFail() {
        return qcFail;
    }

    public void setQcFail(Integer qcFail) {
        this.qcFail = qcFail;
    }

    public BigDecimal getQcRate() {
        return qcRate;
    }

    public void setQcRate(BigDecimal qcRate) {
        this.qcRate = qcRate;
    }

    public Date getQcOptime() {
        return qcOptime;
    }

    public void setQcOptime(Date qcOptime) {
        this.qcOptime = qcOptime;
    }

    public String getQcConpany() {
        return qcConpany;
    }

    public void setQcConpany(String qcConpany) {
        this.qcConpany = qcConpany == null ? null : qcConpany.trim();
    }

    public String getQcType() {
        return qcType;
    }

    public void setQcType(String qcType) {
        this.qcType = qcType == null ? null : qcType.trim();
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