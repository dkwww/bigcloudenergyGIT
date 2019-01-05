package com.yidu.domain;

import java.util.Date;

public class Module {
    private String modeId;

    private String druModeId;

    private String modeUrl;

    private String modeName;

    private String modeCode;

    private String modeExplain;
    
    private String modeNames;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;
    
    private String adminId;

    
    public String getModeNames() {
		return modeNames;
	}

	public void setModeNames(String modeNames) {
		this.modeNames = modeNames;
	}

	public String getModeId() {
        return modeId;
    }

    public void setModeId(String modeId) {
        this.modeId = modeId == null ? null : modeId.trim();
    }

    public String getDruModeId() {
        return druModeId;
    }

    public void setDruModeId(String druModeId) {
        this.druModeId = druModeId == null ? null : druModeId.trim();
    }

    public String getModeUrl() {
        return modeUrl;
    }

    public void setModeUrl(String modeUrl) {
        this.modeUrl = modeUrl == null ? null : modeUrl.trim();
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName == null ? null : modeName.trim();
    }

    public String getModeCode() {
        return modeCode;
    }

    public void setModeCode(String modeCode) {
        this.modeCode = modeCode == null ? null : modeCode.trim();
    }

    public String getModeExplain() {
        return modeExplain;
    }

    public void setModeExplain(String modeExplain) {
        this.modeExplain = modeExplain == null ? null : modeExplain.trim();
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

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
}