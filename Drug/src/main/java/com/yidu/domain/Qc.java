package com.yidu.domain;

import java.util.Date;

public class Qc {
    private String qcId;

    private String pmcId;				//业务id

    private Integer qcAmount;			//质检总数

    private Integer qcFail;				//未通过数

    private String qcRate;				//总通过率

    private Date qcOptime;				//质检时间

    private String qcConpany;			//分店id
    
    private String comName;				//分店名字

    private Integer qcType;

    private String isva;

    private Date optime;				//时间
	
    private String optimes;				//显示时间

    private String oper;

    private String sort;
    
    private String buyAmount;
    
    private   String   qcRateName;   //通过率  
    
    
    private  String   qcOptiemName;
    
    
    private String qcState;		//质检状态
    
    private String qcStates;	//质检
    
    private String qcPut;		//入库状态
    
    private String qcPuts; 		//入库
    
    
    private String  mrpId;		  //这个	 属性对我很重要 请不要删除
    
    
    
    


	public String getOptimes() {
		return optimes;
	}

	public void setOptimes(String optimes) {
		this.optimes = optimes;
	}

	public String getMrpId() {
		return mrpId;
	}

	public void setMrpId(String mrpId) {
		this.mrpId = mrpId;
	}

	public String getQcState() {
		return qcState;
	}

	public void setQcState(String qcState) {
		this.qcState = qcState;
	}

	public String getQcStates() {
		return qcStates;
	}

	public void setQcStates(String qcStates) {
		this.qcStates = qcStates;
	}

	public String getQcPut() {
		return qcPut;
	}

	public void setQcPut(String qcPut) {
		this.qcPut = qcPut;
	}

	public String getQcPuts() {
		return qcPuts;
	}

	public void setQcPuts(String qcPuts) {
		this.qcPuts = qcPuts;
	}

	public String getQcOptiemName() {
		return qcOptiemName;
	}

	public void setQcOptiemName(String qcOptiemName) {
		this.qcOptiemName = qcOptiemName;
	}

	public String getQcRateName() {
		return qcRateName;
	}

	public void setQcRateName(String qcRateName) {
		this.qcRateName = qcRateName;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getBuyAmount() {
		return buyAmount;
	}

	public void setBuyAmount(String buyAmount) {
		this.buyAmount = buyAmount;
	}

	public String getQcId() {
        return qcId;
    }

    public void setQcId(String qcId) {
        this.qcId = qcId == null ? null : qcId.trim();
    }

   

     
	public String getPmcId() {
		return pmcId;
	}

	public void setPmcId(String pmcId) {
		this.pmcId = pmcId;
	}

	public Integer getQcAmount() {
        return qcAmount;
    }

    public void setQcAmount(Integer qcAmount) {
        this.qcAmount = qcAmount;
    }

    public Integer getQcFail() {
        return qcFail;
    }

    public void setQcFail(Integer qcFail) {
        this.qcFail = qcFail;
    }

     

    public String getQcRate() {
		return qcRate;
	}

	public void setQcRate(String qcRate) {
		this.qcRate = qcRate;
	}

	public Date getQcOptime() {
        return qcOptime;
    }

    public void setQcOptime(Date qcOptime) {
        this.qcOptime = qcOptime;
    }

    public String getQcConpany() {
        return qcConpany;
    }

    public void setQcConpany(String qcConpany) {
        this.qcConpany = qcConpany == null ? null : qcConpany.trim();
    }

    

    public Integer getQcType() {
		return qcType;
	}

	public void setQcType(Integer qcType) {
		this.qcType = qcType;
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