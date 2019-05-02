package com.bectran.b2b.supplier.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.bectran.matrix.framework.email.EmailMsgBean;

public class SignOnSecurityBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long supplierId;
    private String ssoKey;
    private String ssoValue;
    private Date lastUpdate;
    private String userId;
    private String ipAddress;
    private Date expirationDate;
    private String aesSalt;
    //
    private String verficationCode;
    private Date lastVcodeDate;
    //
    private EmailMsgBean emailBean;
    private boolean resend = false;
    //
    Set<SignOnSecurityActivityBean> activitySet;

    //
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
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

    public Set<SignOnSecurityActivityBean> getActivitySet() {
        return activitySet;
    }

    public void setActivitySet(Set<SignOnSecurityActivityBean> activitySet) {
        this.activitySet = activitySet;
    }

    public String getAesSalt() {
        return aesSalt;
    }

    public void setAesSalt(String aesSalt) {
        this.aesSalt = aesSalt;
    }

    public String getVerficationCode() {
        return verficationCode;
    }

    public void setVerficationCode(String verficationCode) {
        this.verficationCode = verficationCode;
    }

    public Date getLastVcodeDate() {
        return (Date) (lastVcodeDate == null ? null : lastVcodeDate.clone());
    }

    public void setLastVcodeDate(Date lastVcodeDate) {
        this.lastVcodeDate = (Date) (lastVcodeDate == null ? null : lastVcodeDate.clone());
    }

    public EmailMsgBean getEmailBean() {
        return emailBean;
    }

    public void setEmailBean(EmailMsgBean emailBean) {
        this.emailBean = emailBean;
    }

    public boolean isResend() {
        return resend;
    }

    public void setResend(boolean resend) {
        this.resend = resend;
    }
}
