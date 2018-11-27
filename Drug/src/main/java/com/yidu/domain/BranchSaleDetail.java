package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BranchSaleDetail {
    private String bsdId;

    private String bsId;

    private String drugId;

    private Integer bsdAmount;

    private BigDecimal bsdPrice;

    private BigDecimal bsdTotal;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;

    public String getBsdId() {
        return bsdId;
    }

    public void setBsdId(String bsdId) {
        this.bsdId = bsdId == null ? null : bsdId.trim();
    }

    public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
        this.bsId = bsId == null ? null : bsId.trim();
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId == null ? null : drugId.trim();
    }

    public Integer getBsdAmount() {
        return bsdAmount;
    }

    public void setBsdAmount(Integer bsdAmount) {
        this.bsdAmount = bsdAmount;
    }

    public BigDecimal getBsdPrice() {
        return bsdPrice;
    }

    public void setBsdPrice(BigDecimal bsdPrice) {
        this.bsdPrice = bsdPrice;
    }

    public BigDecimal getBsdTotal() {
        return bsdTotal;
    }

    public void setBsdTotal(BigDecimal bsdTotal) {
        this.bsdTotal = bsdTotal;
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