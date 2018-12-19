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
    
    private   Date   mrpEndtime;
    
    private   String   mrpEndtimeName;
    private String   stateName;
    
    private   String  comName;
     
    
     
    
    
    
    public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	private  String  ideaName;
      
    private  String  drugName;  //药品名称
    
    private  String  optimeName;   //操作时间转换用的
    
    private   String  mrpOptimeName;   //开始时间转换用的
    
    private  String  pmcId;   // 这是外键但是
    
    private  String  pdId;   //这也是外键
    
    private  Integer  mrpNum;  //这是生产数量
    
    
    private   Date   pmcStart;  
    
    private   String    pmcStartName;
    
    	private   Date   pmcEnd;
    	private  String  pmcEndName;
    
    	
    	
    
    

	public Date getMrpEndtime() {
			return mrpEndtime;
		}

		public void setMrpEndtime(Date mrpEndtime) {
			this.mrpEndtime = mrpEndtime;
		}

		public String getMrpEndtimeName() {
			return mrpEndtimeName;
		}

		public void setMrpEndtimeName(String mrpEndtimeName) {
			this.mrpEndtimeName = mrpEndtimeName;
		}

	public Date getPmcStart() {
			return pmcStart;
		}

		public void setPmcStart(Date pmcStart) {
			this.pmcStart = pmcStart;
		}

		public String getPmcStartName() {
			return pmcStartName;
		}

		public void setPmcStartName(String pmcStartName) {
			this.pmcStartName = pmcStartName;
		}

		public Date getPmcEnd() {
			return pmcEnd;
		}

		public void setPmcEnd(Date pmcEnd) {
			this.pmcEnd = pmcEnd;
		}

		public String getPmcEndName() {
			return pmcEndName;
		}

		public void setPmcEndName(String pmcEndName) {
			this.pmcEndName = pmcEndName;
		}

	public String getPmcId() {
		return pmcId;
	}

	public void setPmcId(String pmcId) {
		this.pmcId = pmcId;
	}

	public String getPdId() {
		return pdId;
	}

	public void setPdId(String pdId) {
		this.pdId = pdId;
	}

	public Integer getMrpNum() {
		return mrpNum;
	}

	public void setMrpNum(Integer mrpNum) {
		this.mrpNum = mrpNum;
	}

	public String getOptimeName() {
		return optimeName;
	}

	public void setOptimeName(String optimeName) {
		this.optimeName = optimeName;
	}

	public String getMrpOptimeName() {
		return mrpOptimeName;
	}

	public void setMrpOptimeName(String mrpOptimeName) {
		this.mrpOptimeName = mrpOptimeName;
	}

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