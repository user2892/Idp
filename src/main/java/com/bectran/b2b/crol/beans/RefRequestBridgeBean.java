package com.bectran.b2b.crol.beans;

import java.util.Date;

import com.bectran.b2b.customer.beans.PastCreditAppBean;
import com.bectran.b2b.customer.beans.RefForRequestBean;

/**
 * @author LOUIS IFEGUNI
 */
public class RefRequestBridgeBean {
    private Long id;
    private Long refForReqId;
    private Long crolRefReqId;
    private Long creditAppId;
    private String status;
    private Date dateCreated;
    private Date dateClosed;
    private int reminderCount;
    private String callStatus;
    private Date lastActivity;
    private String customerAcctNum;
    private Long supplierId;
    private RefForRequestBean refForRequest;
    CrolRequestBean crolRequest;
    private PastCreditAppBean creditApp;

    public RefRequestBridgeBean() {
    }

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public Long getCreditAppId() {
        return creditAppId;
    }

    public void setCreditAppId(Long creditAppId) {
        this.creditAppId = creditAppId;
    }

    public Long getCrolRefReqId() {
        return crolRefReqId;
    }

    public void setCrolRefReqId(Long crolRefReqId) {
        this.crolRefReqId = crolRefReqId;
    }

    public Date getDateClosed() {
        return (Date) (dateClosed == null ? null : dateClosed.clone());
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = (Date) (dateClosed == null ? null : dateClosed.clone());
    }

    public Date getDateCreated() {
        return (Date) (dateCreated == null ? null : dateCreated.clone());
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = (Date) (dateCreated == null ? null : dateCreated.clone());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastActivity() {
        return (Date) (lastActivity == null ? null : lastActivity.clone());
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = (Date) (lastActivity == null ? null : lastActivity.clone());
    }

    public Long getRefForReqId() {
        return refForReqId;
    }

    public void setRefForReqId(Long refForReqId) {
        this.refForReqId = refForReqId;
    }

    public int getReminderCount() {
        return reminderCount;
    }

    public void setReminderCount(int reminderCount) {
        this.reminderCount = reminderCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerAcctNum() {
        return customerAcctNum;
    }

    public void setCustomerAcctNum(String customerAcctNum) {
        this.customerAcctNum = customerAcctNum;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public RefForRequestBean getRefForRequest() {
        return refForRequest;
    }

    public void setRefForRequest(RefForRequestBean refForRequest) {
        this.refForRequest = refForRequest;
    }

    public PastCreditAppBean getCreditApp() {
        return creditApp;
    }

    public void setCreditApp(PastCreditAppBean creditApp) {
        this.creditApp = creditApp;
    }

    public CrolRequestBean getCrolRequest() {
        return crolRequest;
    }

    public void setCrolRequest(CrolRequestBean crolRequest) {
        this.crolRequest = crolRequest;
    }
}
