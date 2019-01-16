package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Audit {
    private String audId;					//审核编号

    private String audFkId;					//业务编号

    private String audComtype;				//厂家（0总公司、1分公司）

    private String qcFkId;					//业务编号（公司编号）

    private Date audTime;					//审核时间

    private String audTimes;				//审核时间

    private String audState;				//审核状态

    private String audStates;				//审核状态

    private String audIdea;					//审核意见说明

    private String audName;					//审核人

    private String audMes;					//备注

    private String isva;

    private Date optime;

    private String optimes;

    private String oper;

    private String sort;
    
    private String auName;
    
    private Integer wholAmount;

    private Double wholPrice;
    
    private BigDecimal buyMoney;
    
    private String comId;		//分店id
    
    private String comparyName;
    
    private Double zongjia;
    
    
    public Double getZongjia() {
		return zongjia;
	}

	public void setZongjia(Double zongjia) {
		this.zongjia = zongjia;
	}

	public String getComparyName() {
		return comparyName;
	}

	public void setComparyName(String comparyName) {
		this.comparyName = comparyName;
	}

	public String getComId() {
		return comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
	}

	public BigDecimal getBuyMoney() {
		return buyMoney;
	}

	public void setBuyMoney(BigDecimal buyMoney) {
		this.buyMoney = buyMoney;
	}

	public Integer getWholAmount() {
		return wholAmount;
	}

	public void setWholAmount(Integer wholAmount) {
		this.wholAmount = wholAmount;
	}

	public Double getWholPrice() {
		return wholPrice;
	}

	public void setWholPrice(Double wholPrice) {
		this.wholPrice = wholPrice;
	}

	public String getAuName() {
		return auName;
	}

	public void setAuName(String auName) {
		this.auName = auName;
	}

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