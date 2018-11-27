package com.yidu.domain;

import java.math.BigDecimal;
import java.util.Date;

public class DebtyDetail {
    private String ddetId;

    private String debId;

    private BigDecimal ddetChange;

    private String ddettFkId;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;

    public String getDdetId() {
        return ddetId;
    }

    public void setDdetId(String ddetId) {
        this.ddetId = ddetId == null ? null : ddetId.trim();
    }

    public String getDebId() {
        return debId;
    }

    public void setDebId(String debId) {
        this.debId = debId == null ? null : debId.trim();
    }

    public BigDecimal getDdetChange() {
        return ddetChange;
    }

    public void setDdetChange(BigDecimal ddetChange) {
        this.ddetChange = ddetChange;
    }

    public String getDdettFkId() {
        return ddettFkId;
    }

    public void setDdettFkId(String ddettFkId) {
        this.ddettFkId = ddettFkId == null ? null : ddettFkId.trim();
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