package com.yidu.domain;

import java.util.Date;

public class Admin {
    private String adminId;

    private String comId;

    private String adminName;

    private String adminPwd;

    private String adminPictrue;

    private String adminMsg;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;

    private String optimestring;
    
    private String comName;
    
	public String getComId() {
		return comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName == null ? null : adminName.trim();
	}

	public String getOptimestring() {
		return optimestring;
	}

	public void setOptimestring(String optimestring) {
		this.optimestring = optimestring;
	}

	public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd == null ? null : adminPwd.trim();
    }

    public String getAdminPictrue() {
        return adminPictrue;
    }

    public void setAdminPictrue(String adminPictrue) {
        this.adminPictrue = adminPictrue == null ? null : adminPictrue.trim();
    }

    public String getAdminMsg() {
        return adminMsg;
    }

    public void setAdminMsg(String adminMsg) {
        this.adminMsg = adminMsg == null ? null : adminMsg.trim();
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
		this.optime = optime ;
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