package com.zhangxiang.model;

import java.util.Date;

public class Admin {
    private Integer adminId;

    private String adminName;

    private String adminPassword;

    private String adminEmail;

    private String userPhoto;

    private Date adminRegisterTime;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public Date getAdminRegisterTime() {
        return adminRegisterTime;
    }

    public void setAdminRegisterTime(Date adminRegisterTime) {
        this.adminRegisterTime = adminRegisterTime;
    }
}
