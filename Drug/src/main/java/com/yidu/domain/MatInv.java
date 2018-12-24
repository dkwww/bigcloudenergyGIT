package com.yidu.domain;

import java.util.Date;

public class MatInv {
    private String miId;

    private Integer miAmount;

    private String matId;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;
    
    private String matName;		//药材名称
    
    private String mtName;		//药材类型名称
    
    private String mtId;		//类型id
    
    private String qdetFkId;	//质检业务id
    
    
    
    
    
    

    public String getQdetFkId() {
		return qdetFkId;
	}

	public void setQdetFkId(String qdetFkId) {
		this.qdetFkId = qdetFkId;
	}

	public String getMtName() {
		return mtName;
	}

	public void setMtName(String mtName) {
		this.mtName = mtName;
	}

	public String getMtId() {
		return mtId;
	}

	public void setMtId(String mtId) {
		this.mtId = mtId;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	

	public String getMiId() {
        return miId;
    }

    public void setMiId(String miId) {
        this.miId = miId == null ? null : miId.trim();
    }

    public Integer getMiAmount() {
        return miAmount;
    }

    public void setMiAmount(Integer miAmount) {
        this.miAmount = miAmount;
    }

    public String getMatId() {
        return matId;
    }

    public void setMatId(String matId) {
        this.matId = matId == null ? null : matId.trim();
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