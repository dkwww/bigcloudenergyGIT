package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BranchSale {
    private String bsId;

    private String comId;

    private String menId;

    private String sdId;

    private Integer bsAmount;

    private BigDecimal bsPrice;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;

    public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
        this.bsId = bsId == null ? null : bsId.trim();
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    public String getMenId() {
        return menId;
    }

    public void setMenId(String menId) {
        this.menId = menId == null ? null : menId.trim();
    }

    public String getSdId() {
        return sdId;
    }

    public void setSdId(String sdId) {
        this.sdId = sdId == null ? null : sdId.trim();
    }

    public Integer getBsAmount() {
        return bsAmount;
    }

    public void setBsAmount(Integer bsAmount) {
        this.bsAmount = bsAmount;
    }

    public BigDecimal getBsPrice() {
        return bsPrice;
    }

    public void setBsPrice(BigDecimal bsPrice) {
        this.bsPrice = bsPrice;
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