package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Mrp {
    private String mrpId;

    private String drugId;

    private Date mrpOptime;

    private Integer mrpPlan;

    private BigDecimal mrpRate;

    private Integer  mrpState;

    private Integer mrpIdea;

    private Integer mrpAmount;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;
    
    
    private String   stateName;
    
    
    private  String  ideaName;
      
    private  String  drugName;
    
    
    
    
    public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getIdeaName() {
		return ideaName;
	}

	public void setIdeaName(String ideaName) {
		this.ideaName = ideaName;
	}

	public String getMrpId() {
        return mrpId;
    }

    public void setMrpId(String mrpId) {
        this.mrpId = mrpId == null ? null : mrpId.trim();
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId == null ? null : drugId.trim();
    }

    public Date getMrpOptime() {
        return mrpOptime;
    }

    public void setMrpOptime(Date mrpOptime) {
        this.mrpOptime = mrpOptime;
    }

    public Integer getMrpPlan() {
        return mrpPlan;
    }

    public void setMrpPlan(Integer mrpPlan) {
        this.mrpPlan = mrpPlan;
    }

    public BigDecimal getMrpRate() {
        return mrpRate;
    }

    public void setMrpRate(BigDecimal mrpRate) {
        this.mrpRate = mrpRate;
    }

    
    
    public Integer getMrpState() {
		return mrpState;
	}

	public void setMrpState(Integer mrpState) {
		this.mrpState = mrpState;
	}

	public Integer getMrpIdea() {
		return mrpIdea;
	}

	public void setMrpIdea(Integer mrpIdea) {
		this.mrpIdea = mrpIdea;
	}

	public Integer getMrpAmount() {
        return mrpAmount;
    }

    public void setMrpAmount(Integer mrpAmount) {
        this.mrpAmount = mrpAmount;
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