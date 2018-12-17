package com.yidu.domain;

import java.util.Date;

public class Audit {
    private String audId;

    private String audFkId;

    private String audComtype;

    private String qcFkId;

    private Date audTime;

    private String audTimes;

    private String audState;

    private String audStates;

    private String audIdea;

    private String audName;

    private String audMes;

    private String isva;

    private Date optime;

    private String optimes;

    private String oper;

    private String sort;

    
    
    public String getAudStates() {
		return audStates;
	}

	public void setAudStates(String audStates) {
		this.audStates = audStates;
	}

	public String getAudTimes() {
		return audTimes;
	}

	public void setAudTimes(String audTimes) {
		this.audTimes = audTimes;
	}

	public String getOptimes() {
		return optimes;
	}

	public void setOptimes(String optimes) {
		this.optimes = optimes;
	}

	public String getAudId() {
        return audId;
    }

    public void setAudId(String audId) {
        this.audId = audId == null ? null : audId.trim();
    }

    public String getAudFkId() {
        return audFkId;
    }

    public void setAudFkId(String audFkId) {
        this.audFkId = audFkId == null ? null : audFkId.trim();
    }

    public String getAudComtype() {
        return audComtype;
    }

    public void setAudComtype(String audComtype) {
        this.audComtype = audComtype == null ? null : audComtype.trim();
    }

    public String getQcFkId() {
        return qcFkId;
    }

    public void setQcFkId(String qcFkId) {
        this.qcFkId = qcFkId == null ? null : qcFkId.trim();
    }

    public Date getAudTime() {
        return audTime;
    }

    public void setAudTime(Date audTime) {
        this.audTime = audTime;
    }

    public String getAudState() {
        return audState;
    }

    public void setAudState(String audState) {
        this.audState = audState == null ? null : audState.trim();
    }

    public String getAudIdea() {
        return audIdea;
    }

    public void setAudIdea(String audIdea) {
        this.audIdea = audIdea == null ? null : audIdea.trim();
    }

    public String getAudName() {
        return audName;
    }

    public void setAudName(String audName) {
        this.audName = audName == null ? null : audName.trim();
    }

    public String getAudMes() {
        return audMes;
    }

    public void setAudMes(String audMes) {
        this.audMes = audMes == null ? null : audMes.trim();
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