package com.yidu.domain;

import java.util.Date;

public class MaterialList {
    private String mlId;

    private String matId;

    private String drugId;

    private Integer mlAmount;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;
    
    private String drugName;
    
    private String matName;
    
    private Integer matPrice;
    
    private String mtName;
    
    private String matEffect;

    public String getMlId() {
        return mlId;
    }

    public void setMlId(String mlId) {
        this.mlId = mlId == null ? null : mlId.trim();
    }

    public String getMatId() {
        return matId;
    }

    public void setMatId(String matId) {
        this.matId = matId == null ? null : matId.trim();
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId == null ? null : drugId.trim();
    }

    public Integer getMlAmount() {
        return mlAmount;
    }

    public void setMlAmount(Integer mlAmount) {
        this.mlAmount = mlAmount;
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
		this.drugName = drugName;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	public Integer getMatPrice() {
		return matPrice;
	}

	public void setMatPrice(Integer matPrice) {
		this.matPrice = matPrice;
	}

	public String getMtName() {
		return mtName;
	}

	public void setMtName(String mtName) {
		this.mtName = mtName;
	}

	public String getMatEffect() {
		return matEffect;
	}

	public void setMatEffect(String matEffect) {
		this.matEffect = matEffect;
	}
    
}