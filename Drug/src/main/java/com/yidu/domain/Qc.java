package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Qc {
    private String qcId;

    private String pmcId;				//业务id

    private Integer qcAmount;			//质检总数

    private Integer qcFail;				//未通过数

    private String qcRate;				//总通过率

    private Date qcOptime;

    private String qcConpany;

    private Integer qcType;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;
    
    private String buyAmount;
    
    

    public String getBuyAmount() {
		return buyAmount;
	}

	public void setBuyAmount(String buyAmount) {
		this.buyAmount = buyAmount;
	}

	public String getQcId() {
        return qcId;
    }

    public void setQcId(String qcId) {
        this.qcId = qcId == null ? null : qcId.trim();
    }

   

     
	public String getPmcId() {
		return pmcId;
	}

	public void setPmcId(String pmcId) {
		this.pmcId = pmcId;
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

     

    public String getQcRate() {
		return qcRate;
	}

	public void setQcRate(String qcRate) {
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

    

    public Integer getQcType() {
		return qcType;
	}

	public void setQcType(Integer qcType) {
		this.qcType = qcType;
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