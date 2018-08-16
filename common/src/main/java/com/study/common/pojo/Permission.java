package com.study.common.pojo;

import java.util.Date;

public class Permission {
    private Long permissionId;

    private String permissionName;

    private String permissionCode;

    private String permissionDesc;

    private Boolean permissionNavi;

    private String permissionUrl;

    private Date permissionCreateTime;

    private Date permissionLastModifyTime;

    private Byte permissionValid;

    public Permission(Long permissionId, String permissionName, String permissionCode, String permissionDesc, Boolean permissionNavi, String permissionUrl, Date permissionCreateTime, Date permissionLastModifyTime, Byte permissionValid) {
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.permissionCode = permissionCode;
        this.permissionDesc = permissionDesc;
        this.permissionNavi = permissionNavi;
        this.permissionUrl = permissionUrl;
        this.permissionCreateTime = permissionCreateTime;
        this.permissionLastModifyTime = permissionLastModifyTime;
        this.permissionValid = permissionValid;
    }

    public Permission() {
        super();
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc == null ? null : permissionDesc.trim();
    }

    public Boolean getPermissionNavi() {
        return permissionNavi;
    }

    public void setPermissionNavi(Boolean permissionNavi) {
        this.permissionNavi = permissionNavi;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl == null ? null : permissionUrl.trim();
    }

    public Date getPermissionCreateTime() {
        return permissionCreateTime;
    }

    public void setPermissionCreateTime(Date permissionCreateTime) {
        this.permissionCreateTime = permissionCreateTime;
    }

    public Date getPermissionLastModifyTime() {
        return permissionLastModifyTime;
    }

    public void setPermissionLastModifyTime(Date permissionLastModifyTime) {
        this.permissionLastModifyTime = permissionLastModifyTime;
    }

    public Byte getPermissionValid() {
        return permissionValid;
    }

    public void setPermissionValid(Byte permissionValid) {
        this.permissionValid = permissionValid;
    }
}