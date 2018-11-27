package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BuyDetail {
    private String bdetId;

    private String buyId;

    private Integer bdetAmount;

    private BigDecimal bdetPrice;

    private BigDecimal bdetTotal;

    private String bdetFkId;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;

    public String getBdetId() {
        return bdetId;
    }

    public void setBdetId(String bdetId) {
        this.bdetId = bdetId == null ? null : bdetId.trim();
    }

    public String getBuyId() {
        return buyId;
    }

    public void setBuyId(String buyId) {
        this.buyId = buyId == null ? null : buyId.trim();
    }

    public Integer getBdetAmount() {
        return bdetAmount;
    }

    public void setBdetAmount(Integer bdetAmount) {
        this.bdetAmount = bdetAmount;
    }

    public BigDecimal getBdetPrice() {
        return bdetPrice;
    }

    public void setBdetPrice(BigDecimal bdetPrice) {
        this.bdetPrice = bdetPrice;
    }

    public BigDecimal getBdetTotal() {
        return bdetTotal;
    }

    public void setBdetTotal(BigDecimal bdetTotal) {
        this.bdetTotal = bdetTotal;
    }

    public String getBdetFkId() {
        return bdetFkId;
    }

    public void setBdetFkId(String bdetFkId) {
        this.bdetFkId = bdetFkId == null ? null : bdetFkId.trim();
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