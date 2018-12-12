package com.yidu.domain;

import java.util.Date;

public class WholesaleDetail {
    private String wdId;

    private String wholId;

    private String drugId;

    private Integer wdAmount;

    private String wdPrice;

    private String wdTotal;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;
    
    private String drugName;
    
    public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

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

    public String getWdPrice() {
        return wdPrice;
    }

    public void setWdPrice(String wdPrice) {
        this.wdPrice = wdPrice;
    }

    public String getWdTotal() {
        return wdTotal;
    }

    public void setWdTotal(String wdTotal) {
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