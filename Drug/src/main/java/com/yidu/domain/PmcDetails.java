package com.yidu.domain;

import java.util.Date;

public class PmcDetails {
    private String pdId;

    private String pmcId;

    private String drugId;
    
    private  String   drugName;

    private Integer pdAmount;

    private String pdState;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;
    
    private   Date   pmcStart;  //开始时间
    
    private  Date  pmcEnd ;  //结束时间
    
    
     private  String pmcStartName;  //用于开始转换时间
     private   String  pmcEndName;   //用于结束转换时间
     
     private   String   drugUnit;  //药品单位   
     
       private   String    mrpIdea ;   //进度
       
       private   Integer   hangName;   //已完成数量
       
       private     String   shujuName;
       
       
       
       
       
     
     
     
     
    
 

	public String getShujuName() {
		return shujuName;
	}

	public void setShujuName(String shujuName) {
		this.shujuName = shujuName;
	}

	public Integer getHangName() {
		return hangName;
	}

	public void setHangName(Integer hangName) {
		this.hangName = hangName;
	}

	public String getMrpIdea() {
		return mrpIdea;
	}

	public void setMrpIdea(String mrpIdea) {
		this.mrpIdea = mrpIdea;
	}

	public String getDrugUnit() {
		return drugUnit;
	}

	public void setDrugUnit(String drugUnit) {
		this.drugUnit = drugUnit;
	}

	public Date getPmcStart() {
		return pmcStart;
	}

	public void setPmcStart(Date pmcStart) {
		this.pmcStart = pmcStart;
	}

	public Date getPmcEnd() {
		return pmcEnd;
	}

	public void setPmcEnd(Date pmcEnd) {
		this.pmcEnd = pmcEnd;
	}

	public String getPmcStartName() {
		return pmcStartName;
	}

	public void setPmcStartName(String pmcStartName) {
		this.pmcStartName = pmcStartName;
	}

	public String getPmcEndName() {
		return pmcEndName;
	}

	public void setPmcEndName(String pmcEndName) {
		this.pmcEndName = pmcEndName;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

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

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId == null ? null : drugId.trim();
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
}