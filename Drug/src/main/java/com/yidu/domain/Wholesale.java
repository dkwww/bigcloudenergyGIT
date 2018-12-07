package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Wholesale {
    private String wholId;

    private String comId;

    private Integer wholAmount;

    private String wholPrice;

    private Date optime;

    private String isva;

    private String oper;

    private String sort;

    public String getWholId() {
        return wholId;
    }

    public void setWholId(String wholId) {
        this.wholId = wholId == null ? null : wholId.trim();
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    public Integer getWholAmount() {
        return wholAmount;
    }

    public void setWholAmount(Integer wholAmount) {
        this.wholAmount = wholAmount;
    }

    public String getWholPrice() {
        return wholPrice;
    }

    public void setWholPrice(String wholPrice) {
        this.wholPrice = wholPrice;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getIsva() {
        return isva;
    }

    public void setIsva(String isva) {
        this.isva = isva == null ? null : isva.trim();
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