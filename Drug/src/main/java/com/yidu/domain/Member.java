package com.yidu.domain;

import java.util.Date;

public class Member {
    private String menId;

    private String menName;

    private String memPwd;

    private String memPhone;

    private String memAddress;

    private String memPictrue;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;

    public String getMenId() {
        return menId;
    }

    public void setMenId(String menId) {
        this.menId = menId == null ? null : menId.trim();
    }

    public String getMenName() {
        return menName;
    }

    public void setMenName(String menName) {
        this.menName = menName == null ? null : menName.trim();
    }

    public String getMemPwd() {
        return memPwd;
    }

    public void setMemPwd(String memPwd) {
        this.memPwd = memPwd == null ? null : memPwd.trim();
    }

    public String getMemPhone() {
        return memPhone;
    }

    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone == null ? null : memPhone.trim();
    }

    public String getMemAddress() {
        return memAddress;
    }

    public void setMemAddress(String memAddress) {
        this.memAddress = memAddress == null ? null : memAddress.trim();
    }

    public String getMemPictrue() {
        return memPictrue;
    }

    public void setMemPictrue(String memPictrue) {
        this.memPictrue = memPictrue == null ? null : memPictrue.trim();
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