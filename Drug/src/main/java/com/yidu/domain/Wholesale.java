package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Wholesale {
    private String wholId;

    private String comId;

    private Integer wholAmount;

    private Double wholPrice;

    private Date optime;
    
    private String optimes;

	private String isva;

    private String oper;

    private String sort;
    
    private String comName;
    
    private String audState;

    
    public String getOptimes() {
		return optimes;
	}

	public void setOptimes(String optimes) {
		this.optimes = optimes;
	}
    public String getAudState() {
		return audState;
	}

	public void setAudState(String audState) {
		this.audState = audState;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

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

    public Double getWholPrice() {
        return wholPrice;
    }

    public void setWholPrice(Double wholPrice) {
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