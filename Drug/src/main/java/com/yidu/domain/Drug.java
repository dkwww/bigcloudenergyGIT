package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Drug {
    private String drugId;

    private String dtId;
    
    private String comId;

	private String drugName;

    private String drugUnit;

    private String drugProp;

    private String drugPictrue;

    private BigDecimal drugPrice;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;
    
    private String dtName;
    
    private Double priceMin;
    
    private Double priceMax;
    
    private Integer diAmount; 
    
    private String audId;
    
    private String audState;
    
    
    public Integer getDiAmount() {
		return diAmount;
	}

	public void setDiAmount(Integer diAmount) {
		this.diAmount = diAmount;
	}

	public String getComId() {
		return comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
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
        this.drugProp = drugProp == null ? null : drugProp.trim();
    }

    public String getDrugPictrue() {
        return drugPictrue;
    }

    public void setDrugPictrue(String drugPictrue) {
        this.drugPictrue = drugPictrue == null ? null : drugPictrue.trim();
    }

    public BigDecimal getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(BigDecimal drugPrice) {
        this.drugPrice = drugPrice;
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

	public String getDtName() {
		return dtName;
	}

	public void setDtName(String dtName) {
		this.dtName = dtName == null ? null : dtName.trim();
	}

	public Double getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Double priceMin) {
		this.priceMin = priceMin;
	}

	public Double getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(Double priceMax) {
		this.priceMax = priceMax;
	}
	
	public String getAudId() {
		return audId;
	}

	public void setAudId(String audId) {
		this.audId = audId;
	}

	public String getAudState() {
		return audState;
	}

	public void setAudState(String audState) {
		this.audState = audState;
	}
}