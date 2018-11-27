package com.yidu.domain;

public class AdminRole {
    private String arId;

    private String adminId;

    private String roleId;

    public String getArId() {
        return arId;
    }

    public void setArId(String arId) {
        this.arId = arId == null ? null : arId.trim();
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}