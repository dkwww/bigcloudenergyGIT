package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Material {
    private String matId;				//原材料编号

    private String mtId;				//药材类型编号

    private String miId;				//原料库存编号

    private String matName;				//药材名称

    private Integer matAmount;			//数量

    private BigDecimal matPrice;		//单价

    private String matUnit;				//药品单位（个、粒、克）
    
    private String matEffect;			//功效

    private String isva;				//是否有效

    private Date optime;				//操作时间

    private String oper;				//操作人

    private String sort;				//排序
    
    private String mtName;				//药材类型名
    
    
    public String getMatEffect() {
		return matEffect;
	}

	public void setMatEffect(String matEffect) {
		this.matEffect = matEffect;
	}

	public String getMtName() {
		return mtName;
	}

	public void setMtName(String mtName) {
		this.mtName = mtName;
	}

	public String getMatId() {
        return matId;
    }

    public void setMatId(String matId) {
        this.matId = matId == null ? null : matId.trim();
    }

    public String getMtId() {
        return mtId;
    }

    public void setMtId(String mtId) {
        this.mtId = mtId == null ? null : mtId.trim();
    }

    public String getMiId() {
        return miId;
    }

    public void setMiId(String miId) {
        this.miId = miId == null ? null : miId.trim();
    }

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName == null ? null : matName.trim();
    }

    public Integer getMatAmount() {
        return matAmount;
    }

    public void setMatAmount(Integer matAmount) {
        this.matAmount = matAmount;
    }

    public BigDecimal getMatPrice() {
        return matPrice;
    }

    public void setMatPrice(BigDecimal matPrice) {
        this.matPrice = matPrice;
    }

    public String getMatUnit() {
        return matUnit;
    }

    public void setMatUnit(String matUnit) {
        this.matUnit = matUnit == null ? null : matUnit.trim();
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