package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class WholesaleDetail {
    private String wdId;

    private String wholId;

    private String drugId;

    private Integer wdAmount;

    private BigDecimal wdPrice;

    private BigDecimal wdTotal;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;
    public String getWdId() {
        return wdId;
    }

    public void setWdId(String wdId) {
        this.wdId = wdId == null ? null : wdId.trim();
    }

    public String getWholId() {
        return wholId;
    }

    public void setWholId(String wholId) {
        this.wholId = wholId == null ? null : wholId.trim();
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId == null ? null : drugId.trim();
    }

    public Integer getWdAmount() {
        return wdAmount;
    }

    public void setWdAmount(Integer wdAmount) {
        this.wdAmount = wdAmount;
    }

    public BigDecimal getWdPrice() {
        return wdPrice;
    }

    public void setWdPrice(BigDecimal wdPrice) {
        this.wdPrice = wdPrice;
    }

    public BigDecimal getWdTotal() {
        return wdTotal;
    }

    public void setWdTotal(BigDecimal wdTotal) {
        this.wdTotal = wdTotal;
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