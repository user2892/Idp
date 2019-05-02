package com.bectran.b2b.customer.beans;

import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 * @Date Feb 25, 2007:12:09:31 PM
 */
public class RefForRequestBean {
    private Long id;
    private Long requestId;
    private long refereeContactId;
    private long refereeId;
    private String acctNum;
    private String referenceType;
    private String processId;
    private String userId;
    private Date dateCreated;
    private String callComment = "";
    private String autoOrManual = "";
    RefereeBean referee; // hibernate
    RefContactBean refereeContact; // hibernate
    /* crol */
    private int reminderCount;
    private long crolRequestId;
    private String callStatus = MatrixConstants.REFERENCE_CALL_STATUS_NOT_CALLED;
    private Date lastActivity;
    private String internalAcctNum = "";
    private String accountType = "";
    private String signatory = "";

    /**
     * @return Returns the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * DEFAULT CONSTRUCTOR
     */
    public RefForRequestBean() {
    }

    /**
     * @return Returns the refContactId.
     */
    public long getRefereeContactId() {
        return refereeContactId;
    }

    /**
     * @param refContactId
     *            The refContactId to set.
     */
    public void setRefereeContactId(long refContactId) {
        this.refereeContactId = refContactId;
    }

    /**
     * @return Returns the requestId.
     */
    public Long getRequestId() {
        return requestId;
    }

    /**
     * @param requestId
     *            The requestId to set.
     */
    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    /**
     * @return Returns the dateCreated.
     */
    public Date getDateCreated() {
        return (Date) (dateCreated == null ? null : dateCreated.clone());
    }

    /**
     * @param dateCreated
     *            The dateCreated to set.
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = (Date) (dateCreated == null ? null : dateCreated.clone());
    }

    /**
     * @return Returns the acctNum.
     */
    public String getAcctNum() {
        return acctNum;
    }

    /**
     * @param acctNum
     *            The acctNum to set.
     */
    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    /**
     * @return Returns the callStatus.
     */
    public String getCallStatus() {
        return callStatus;
    }

    /**
     * @return Returns the callStatusDisplay.
     */
    public String getCallStatusDisplay() {
        if (this.callStatus.trim()
                .equals(MatrixConstants.REFERENCE_CALL_STATUS_REMINDER)) {
            return this.callStatus + "-" + this.reminderCount;
        }
        return callStatus;
    }


    /**
     * @param callStatus
     *            The callStatus to set.
     */
    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    /**
     * @return Returns the lastActivity.
     */
    public Date getLastActivity() {
        return (Date) (lastActivity == null ? null : lastActivity.clone());
    }

    /**
     * @param lastActivity
     *            The lastActivity to set.
     */
    public void setLastActivity(Date lastActivity) {
        this.lastActivity = (Date) (lastActivity == null ? null : lastActivity.clone());
    }

    /**
     * @return Returns the referenceType.
     */
    public String getReferenceType() {
        return referenceType;
    }

    /**
     * @param referenceType
     *            The referenceType to set.
     */
    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    /**
     * @return Returns the refereeId.
     */
    public long getRefereeId() {
        return refereeId;
    }

    /**
     * @param refereeId
     *            The refereeId to set.
     */
    public void setRefereeId(long refereeId) {
        this.refereeId = refereeId;
    }

    /**
     * @return Returns the referee.
     */
    public RefereeBean getReferee() {
        return referee;
    }

    /**
     * @param referee
     *            The referee to set.
     */
    public void setReferee(RefereeBean referee) {
        this.referee = referee;
    }

    /**
     * @return Returns the refereeContact.
     */
    public RefContactBean getRefereeContact() {
        return refereeContact;
    }

    /**
     * @param refereeContact
     *            The refereeContact to set.
     */
    public void setRefereeContact(RefContactBean refereeContact) {
        this.refereeContact = refereeContact;
    }

    /**
     * @return Returns the reminderCount.
     */
    public int getReminderCount() {
        return reminderCount;
    }

    /**
     * @param reminderCount
     *            The reminderCount to set.
     */
    public void setReminderCount(int reminderCount) {
        this.reminderCount = reminderCount;
    }

    /**
     * @return Returns the crolRequestId.
     */
    public long getCrolRequestId() {
        return crolRequestId;
    }

    /**
     * @param crolRequestId
     *            The crolRequestId to set.
     */
    public void setCrolRequestId(long crolRequestId) {
        this.crolRequestId = crolRequestId;
    }

    /**
     * @return Returns the processId.
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * @param processId
     *            The processId to set.
     */
    public void setProcessId(String processId) {
        this.processId = processId;
    }

    /**
     * @return Returns the called.
     */
    public boolean isCalled() {
        if (!(this.callStatus.trim()
                .equals(MatrixConstants.REFERENCE_CALL_STATUS_NOT_CALLED))) {
            return true;
        }
        return false;
    }

    /**
     * @return Returns the userId.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            The userId to set.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return Returns the callComment.
     */
    public String getCallComment() {
        return callComment;
    }

    /**
     * @param callComment
     *            The callComment to set.
     */
    public void setCallComment(String callComment) {
        this.callComment = callComment;
    }

    /**
     * @return Returns the makeCall.
     */
    public boolean isMakeCall() {
        if (this.callStatus.trim()
                .equals(MatrixConstants.REFERENCE_CALL_STATUS_NOT_CALLED)) {
            return true;
        }
        return false;
    }

    /**
     * @return Returns the enableCancel.
     */
    public boolean isEnableCancel() {
        if (this.callStatus.trim()
                .equals(MatrixConstants.REFERENCE_CALL_STATUS_NOT_CALLED)
                || this.callStatus.trim()
                        .equals(MatrixConstants.REFERENCE_CALL_STATUS_CALLED)
                || this.callStatus.trim()
                        .equals(MatrixConstants.REFERENCE_CALL_STATUS_REMINDER)
                || this.callStatus.trim().equals(
                        MatrixConstants.REFERENCE_CALL_STATUS_REMINDER_LIMIT)) {
            return true;
        }
        return false;
    }

    /**
     * @return Returns the autoOrManual.
     */
    public String getAutoOrManual() {
        return autoOrManual;
    }

    /**
     * @param autoOrManual
     *            The autoOrManual to set.
     */
    public void setAutoOrManual(String autoOrManual) {
        this.autoOrManual = autoOrManual;
    }

    /**
     * @return Returns the enableManual.
     */
    public boolean isEnableManual() {
        if (!(this.callStatus.trim()
                .equals(MatrixConstants.REFERENCE_CALL_STATUS_RECEIVED)
                || this.callStatus.trim().equals(
                        MatrixConstants.REFERENCE_CALL_STATUS_CANCELED))) {
            return true;
        }
        return false;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getInternalAcctNum() {
        return internalAcctNum;
    }

    public void setInternalAcctNum(String internalAcctNum) {
        this.internalAcctNum = internalAcctNum;
    }

    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }

    public boolean isReferenceReceived() {
        if (this.getCallStatus().trim()
                .equals(MatrixConstants.REFERENCE_CALL_STATUS_RECEIVED)) {
            return true;
        }
        return false;
    }

    public boolean isReadyForCall() {
        if (this.getCallStatus().trim()
                .equals(MatrixConstants.REFERENCE_CALL_STATUS_NOT_CALLED)) {
            return true;
        }
        return false;
    }

    public boolean isManualRefType() {
        if (this.getAutoOrManual() != null && this.getAutoOrManual().trim()
                .equals(MatrixConstants.MANUAL)) {
            return true;
        }
        return false;
    }

}
