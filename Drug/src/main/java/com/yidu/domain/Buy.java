package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Buy {
    private String buyId;

    private String comId;

    private Integer buyAmount;

    private BigDecimal buyMoney;

    private Date buyTime;

    private String buyTimes;

    private String buyCompany;

    private String buyType;

    private String buyAudit;

    private String buyState;

    private String buyQc;

    private String buyPut;

    private String buyMes;

    private String isva;

    private Date optime;
    
    private String optimes;

    private String oper;

    private String sort;

    
    public String getBuyTimes() {
		return buyTimes;
	}

	public void setBuyTimes(String buyTimes) {
		this.buyTimes = buyTimes;
	}

	public String getOptimes() {
		return optimes;
	}

	public void setOptimes(String optimes) {
		this.optimes = optimes;
	}

	public String getBuyId() {
        return buyId;
    }

    public void setBuyId(String buyId) {
        this.buyId = buyId == null ? null : buyId.trim();
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    public Integer getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(Integer buyAmount) {
        this.buyAmount = buyAmount;
    }

    public BigDecimal getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(BigDecimal buyMoney) {
        this.buyMoney = buyMoney;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public String getBuyCompany() {
        return buyCompany;
    }

    public void setBuyCompany(String buyCompany) {
        this.buyCompany = buyCompany == null ? null : buyCompany.trim();
    }

    public String getBuyType() {
        return buyType;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType == null ? null : buyType.trim();
    }

    public String getBuyAudit() {
        return buyAudit;
    }

    public void setBuyAudit(String buyAudit) {
        this.buyAudit = buyAudit == null ? null : buyAudit.trim();
    }

    public String getBuyState() {
        return buyState;
    }

    public void setBuyState(String buyState) {
        this.buyState = buyState == null ? null : buyState.trim();
    }

    public String getBuyQc() {
        return buyQc;
    }

    public void setBuyQc(String buyQc) {
        this.buyQc = buyQc == null ? null : buyQc.trim();
    }

    public String getBuyPut() {
        return buyPut;
    }

    public void setBuyPut(String buyPut) {
        this.buyPut = buyPut == null ? null : buyPut.trim();
    }

    public String getBuyMes() {
        return buyMes;
    }

    public void setBuyMes(String buyMes) {
        this.buyMes = buyMes == null ? null : buyMes.trim();
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