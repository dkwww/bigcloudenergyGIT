package com.yidu.domain;

import java.util.Date;

public class QcDetail {
    private String qdetId;

    private String qcId;

    private String qdetFkId;

    private Integer qdetAmount;			//数量

    private Integer qdetFail;			//未通过数

    private String qdetRate;			//通过率

    private Date qdetOptime;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;
    
    private String matName;
    
    private String matId;
    
    private String  drugName;
    
    private  String   qdetRateName; 
    
    private   String   qdetOptimeName;
    
    
    
    

    public String getQdetRateName() {
		return qdetRateName;
	}

	public void setQdetRateName(String qdetRateName) {
		this.qdetRateName = qdetRateName;
	}

	public String getQdetOptimeName() {
		return qdetOptimeName;
	}

	public void setQdetOptimeName(String qdetOptimeName) {
		this.qdetOptimeName = qdetOptimeName;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getMatId() {
		return matId;
	}

	public void setMatId(String matId) {
		this.matId = matId;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	public String getQdetId() {
        return qdetId;
    }

    public void setQdetId(String qdetId) {
        this.qdetId = qdetId == null ? null : qdetId.trim();
    }

    public String getQcId() {
        return qcId;
    }

    public void setQcId(String qcId) {
        this.qcId = qcId == null ? null : qcId.trim();
    }

    public String getQdetFkId() {
        return qdetFkId;
    }

    public void setQdetFkId(String qdetFkId) {
        this.qdetFkId = qdetFkId == null ? null : qdetFkId.trim();
    }

    public Integer getQdetAmount() {
        return qdetAmount;
    }

    public void setQdetAmount(Integer qdetAmount) {
        this.qdetAmount = qdetAmount;
    }

    public Integer getQdetFail() {
        return qdetFail;
    }

    public void setQdetFail(Integer qdetFail) {
        this.qdetFail = qdetFail;
    }

     

    public String getQdetRate() {
		return qdetRate;
	}

	public void setQdetRate(String qdetRate) {
		this.qdetRate = qdetRate;
	}

	public Date getQdetOptime() {
        return qdetOptime;
    }

    public void setQdetOptime(Date qdetOptime) {
        this.qdetOptime = qdetOptime;
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