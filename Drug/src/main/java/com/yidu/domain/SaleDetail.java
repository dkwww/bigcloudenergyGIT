package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SaleDetail {
    private String sdId;

    private String saleId;

    private Integer sdAmount;

    private BigDecimal sdPrice;

    private BigDecimal sdTotal;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;

    public String getSdId() {
        return sdId;
    }

    public void setSdId(String sdId) {
        this.sdId = sdId == null ? null : sdId.trim();
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId == null ? null : saleId.trim();
    }

    public Integer getSdAmount() {
        return sdAmount;
    }

    public void setSdAmount(Integer sdAmount) {
        this.sdAmount = sdAmount;
    }

    public BigDecimal getSdPrice() {
        return sdPrice;
    }

    public void setSdPrice(BigDecimal sdPrice) {
        this.sdPrice = sdPrice;
    }

    public BigDecimal getSdTotal() {
        return sdTotal;
    }

    public void setSdTotal(BigDecimal sdTotal) {
        this.sdTotal = sdTotal;
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