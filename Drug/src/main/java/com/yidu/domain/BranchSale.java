package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.aspectj.weaver.AjAttribute.PrivilegedAttribute;

public class BranchSale {
    private String bsId;

    private String comId;

    private String menId;

    private Integer bsAmount;
    private Integer bsAmount2;
    

    private String bsPrice;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;
    
    private String optimeStr;
    
    private String priceMin;
    
    private String priceMax;
    
    private String comName;
    
    private String menName;

    
    
    /**
	 * @return the bsAmount2
	 */
	public Integer getBsAmount2() {
		return bsAmount2;
	}

	/**
	 * @param bsAmount2 the bsAmount2 to set
	 */
	public void setBsAmount2(Integer bsAmount2) {
		this.bsAmount2 = bsAmount2;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getMenName() {
		return menName;
	}

	public void setMenName(String menName) {
		this.menName = menName;
	}

	public String getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(String priceMin) {
		this.priceMin = priceMin;
	}

	public String getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(String priceMax) {
		this.priceMax = priceMax;
	}

	public String getOptimeStr() {
		return optimeStr;
	}

	public void setOptimeStr(String optimeStr) {
		this.optimeStr = optimeStr;
	}

	public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
        this.bsId = bsId == null ? null : bsId.trim();
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    public String getMenId() {
        return menId;
    }

    public void setMenId(String menId) {
        this.menId = menId == null ? null : menId.trim();
    }


    public Integer getBsAmount() {
        return bsAmount;
    }

    public void setBsAmount(Integer bsAmount) {
        this.bsAmount = bsAmount;
    }

    public String getBsPrice() {
        return bsPrice;
    }

    public void setBsPrice(String bsPrice) {
        this.bsPrice = bsPrice;
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