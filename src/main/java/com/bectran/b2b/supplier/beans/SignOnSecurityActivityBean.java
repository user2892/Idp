package com.bectran.b2b.supplier.beans;

import java.io.Serializable;
import java.util.Date;

public class SignOnSecurityActivityBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String ssoKey;
    private String ssoValue;
    private Date activityDate;
    private String userId;
    private String ipAddress;
    private Date expirationDate;

    //
    public SignOnSecurityActivityBean() {
    }

    public String getSsoKey() {
        return ssoKey;
    }

    public void setSsoKey(String ssoKey) {
        this.ssoKey = ssoKey;
    }

    public String getSsoValue() {
        return ssoValue;
    }

    public void setSsoValue(String ssoValue) {
        this.ssoValue = ssoValue;
    }

    public Date getActivityDate() {
        return (Date) (activityDate == null ? null : activityDate.clone());
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = (Date) (activityDate == null ? null : activityDate.clone());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Date getExpirationDate() {
        return (Date) (expirationDate == null ? null : expirationDate.clone());
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = (Date) (expirationDate == null ? null : expirationDate.clone());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
