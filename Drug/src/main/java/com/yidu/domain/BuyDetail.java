package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BuyDetail {
    private String bdetId;						//采购订单编号

    private String buyId;						//采购订单编号

    private Integer bdetAmount;					//数量

    private BigDecimal bdetPrice;				//单价

    private BigDecimal bdetTotal;				//小计

    private String bdetFkId;					//业务编号（采购商品编号）

    private String bdetFkName;
    
    private String mes;

    private String isva;

    private Date optime;

    private String optimes;

    private String oper;

    private String sort;
    
    private String matName;						//材料名
    
    private String matAmount;					//材料数量
    
    private String matPrice;					//材料单价

    private String drugName;
    
    private BigDecimal buyMoney;				//总金额
    
    private String provId;						//供应商外键
    
    private String provName;					//供应商名
    
    
    
    public BigDecimal getBuyMoney() {
		return buyMoney;
	}

	public void setBuyMoney(BigDecimal buyMoney) {
		this.buyMoney = buyMoney;
	}

	public String getProvId() {
		return provId;
	}

	public void setProvId(String provId) {
		this.provId = provId;
	}

	public String getProvName() {
		return provName;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	public String getMatAmount() {
		return matAmount;
	}

	public void setMatAmount(String matAmount) {
		this.matAmount = matAmount;
	}

	public String getMatPrice() {
		return matPrice;
	}

	public void setMatPrice(String matPrice) {
		this.matPrice = matPrice;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getBdetFkName() {
		return bdetFkName;
	}

	public void setBdetFkName(String bdetFkName) {
		this.bdetFkName = bdetFkName;
	}

	public String getOptimes() {
		return optimes;
	}

	public void setOptimes(String optimes) {
		this.optimes = optimes;
	}

	public String getBdetId() {
        return bdetId;
    }

    public void setBdetId(String bdetId) {
        this.bdetId = bdetId == null ? null : bdetId.trim();
    }

    public String getBuyId() {
        return buyId;
    }

    public void setBuyId(String buyId) {
        this.buyId = buyId == null ? null : buyId.trim();
    }

    public Integer getBdetAmount() {
        return bdetAmount;
    }

    public void setBdetAmount(Integer bdetAmount) {
        this.bdetAmount = bdetAmount;
    }

    public BigDecimal getBdetPrice() {
        return bdetPrice;
    }

    public void setBdetPrice(BigDecimal bdetPrice) {
        this.bdetPrice = bdetPrice;
    }

    public BigDecimal getBdetTotal() {
        return bdetTotal;
    }

    public void setBdetTotal(BigDecimal bdetTotal) {
        this.bdetTotal = bdetTotal;
    }

    public String getBdetFkId() {
        return bdetFkId;
    }

    public void setBdetFkId(String bdetFkId) {
        this.bdetFkId = bdetFkId == null ? null : bdetFkId.trim();
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