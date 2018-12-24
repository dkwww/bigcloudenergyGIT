package com.yidu.domain;

import java.util.Date;

public class PmcDetails {
    private String pdId;

    private String pmcId;
    
    private String pmcName;

    private String drugId;
    
    private String dtId;
    
    private Integer pdAmount;

    private String pdState;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;
    
    private String drugName;
    
    private String drugUnit;
    
    private String drugProp;
    
    private Integer finisded;
    
    private String dtName;

	public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId == null ? null : pdId.trim();
    }

    public String getPmcId() {
        return pmcId;
    }

    public void setPmcId(String pmcId) {
        this.pmcId = pmcId == null ? null : pmcId.trim();
    }
    
    public String getPmcName() {
        return pmcName;
    }

    public void setPmcName(String pmcName) {
        this.pmcName = pmcName == null ? null : pmcName.trim();
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId == null ? null : drugId.trim();
    }
    
    public String getDtId() {
        return dtId;
    }

    public void setDtId(String dtId) {
        this.dtId = dtId == null ? null : dtId.trim();
    }

    public Integer getPdAmount() {
        return pdAmount;
    }

    public void setPdAmount(Integer pdAmount) {
        this.pdAmount = pdAmount;
    }

    public String getPdState() {
        return pdState;
    }

    public void setPdState(String pdState) {
        this.pdState = pdState == null ? null : pdState.trim();
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

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName == null ? null : drugName.trim();
	}

	public String getDrugUnit() {
		return drugUnit;
	}

	public void setDrugUnit(String drugUnit) {
		 this.drugUnit = drugUnit == null ? null : drugUnit.trim();
	}

	public String getDrugProp() {
		return drugProp;
	}

	public void setDrugProp(String drugProp) {
		this.drugProp = drugProp;
	}

	public Integer getFinisded() {
		return finisded;
	}

	public void setFinisded(Integer finisded) {
		this.finisded = finisded;
	}

	public String getDtName() {
		return dtName;
	}

	public void setDtName(String dtName) {
		this.dtName = dtName;
	}
}