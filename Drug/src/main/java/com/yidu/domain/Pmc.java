package com.yidu.domain;

import java.util.Date;

public class Pmc {
    private String pmcId;

    private Integer pmcAmount;

    private Date pmcStart;

    private Date pmcEnd;

    private String pmcState;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;
    
    private String strStartTime;
    
    private String strEndTime;
    
    private Date startTime;
    
    private Date endTime;
    
    private Date startTimes;
    
    private Date endTimes;
    
    private Integer maxAmount;
    
    private Integer minAmount;
    
    
    private  String   comId;
    
    
    
    
    public String getComId() {
		return comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
	}

	public String getPmcId() {
        return pmcId;
    }

    public void setPmcId(String pmcId) {
        this.pmcId = pmcId == null ? null : pmcId.trim();
    }

    public Integer getPmcAmount() {
        return pmcAmount;
    }

    public void setPmcAmount(Integer pmcAmount) {
        this.pmcAmount = pmcAmount;
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

    public String getPmcState() {
        return pmcState;
    }

    public void setPmcState(String pmcState) {
        this.pmcState = pmcState == null ? null : pmcState.trim();
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

	public String getStrStartTime() {
		return strStartTime;
	}

	public void setStrStartTime(String strStartTime) {
		this.strStartTime = strStartTime;
	}

	public String getStrEndTime() {
		return strEndTime;
	}

	public void setStrEndTime(String strEndTime) {
		this.strEndTime = strEndTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartTimes() {
		return startTimes;
	}

	public void setStartTimes(Date startTimes) {
		this.startTimes = startTimes;
	}

	public Date getEndTimes() {
		return endTimes;
	}

	public void setEndTimes(Date endTimes) {
		this.endTimes = endTimes;
	}

	public Integer getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(Integer maxAmount) {
		this.maxAmount = maxAmount;
	}

	public Integer getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(Integer minAmount) {
		this.minAmount = minAmount;
	}
}