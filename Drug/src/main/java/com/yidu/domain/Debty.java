package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Debty {
	private String strTime;
    private String debId;

    private String comId;

    private BigDecimal debMoney;

    private Date optime;

    private String isva;

    private String oper;

    private String sort;

    
    public String getStrTime() {
		return strTime;
	}

	public void setStrTime(String strTime) {
		this.strTime = strTime;
	}

	public String getDebId() {
        return debId;
    }

    public void setDebId(String debId) {
        this.debId = debId == null ? null : debId.trim();
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    public BigDecimal getDebMoney() {
        return debMoney;
    }

    public void setDebMoney(BigDecimal money) {
        this.debMoney = money;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getIsva() {
        return isva;
    }

    public void setIsva(String isva) {
        this.isva = isva == null ? null : isva.trim();
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