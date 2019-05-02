package com.bectran.b2b.crol.beans;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.crol.constants.CrolConstants;
import com.bectran.b2b.supplier.beans.SupplierCompanyBean;
import com.bectran.b2b.supplier.beans.SupplierUserBean;

/**
 * @author LOUIS IFEGUNI
 */
public class CrolRequestBean {
    //
    public static final Comparator DESCENDING_ORDER_DATE_RECEIVED = new Comparator() {
        public int compare(Object o1, Object o2) {
            CrolRequestBean r1 = (CrolRequestBean) o1;
            CrolRequestBean r2 = (CrolRequestBean) o2;
            return r2.getDateReceived().compareTo(r1.getDateReceived());
        }
    };
    public static final Comparator ASCENDING_ORDER_DATE_RECEIVED = new Comparator() {
        public int compare(Object o1, Object o2) {
            CrolRequestBean r1 = (CrolRequestBean) o1;
            CrolRequestBean r2 = (CrolRequestBean) o2;
            return r1.getDateReceived().compareTo(r2.getDateReceived());
        }
    };
    private String requestSource;
    private Long id;
    private String requestID = "";
    private String fromCorpId = "";
    private String fromCorpName = "";
    private String fromCorpNameInbox = "";
    private String toCorpId = "";
    private String toCorpName = "";
    private String customerCorpId = "";
    private String customerCorpName = "";
    private String originatingCorpId = "";
    private String originatingCorpName = "";
    private String onetRequestId = ""; // identifier for ONET request
    /* ...hibernate mapping .. */
    private CorpBean toCorp;
    private CorpBean customerCorp;
    private CorpBean originatingCorp;
    // LOUIS: 03-05-2010
    private SupplierCompanyBean fromCorp;
    private SupplierUserBean requestor;
    /* ...hibernate mapping .. */
    private Date dateSent;
    private Date dateOfResponse;
    private Date dateReceived;
    private Date lastReminderDate;
    //
    private String inOrOutNetFlag = "";
    //
    private String requestorId = "";
    private String requestType = CrolConstants.REFERENCE_TYPE_TRADE;
    private String signedRequest = "";
    private int daysInProcess;
    //
    private String requestStatus = "";
    private String requestStatusAction = "";
    private String requestComment = "";
    // e-mail tracking
    private String emailSentStatus = "";
    private int emailSentTrial;
    //
    //
    private String reasonForRequest = "";
    private double amountRequested; // specified if customer is new
    private String acctOpenedForCode = "";
    // protected String acctOpenedForLabel="";
    private double hiCredit;
    private double balanceOwing;
    private String paymentExperience = "NONE";
    // protected String paymentExperienceLabel="";
    private String termsCode = "NONE";
    // protected String termsLabel="";
    private int reminderCount;
    private String requestOriginator = CrolConstants.REQUEST_ORIGINATOR_CREDITOR; // initialized
                                                                                  // to
                                                                                  // creditor
    // private boolean reasonIsNotNewCustomer=false;
    //
    //
    private boolean displayNewAccountPanel = false;
    private boolean displayExistingAccountPanelTrade = false;
    private boolean displayExistingAccountPanelBank = false;
    //
    //
    private String inboxSubject = "";
    private String inboxSubjectID = "";
    //
    private String currency = "";
    // account open for how long list
    // protected List acctAgeList;
    private CorpBean refereeCompany;
    // reference request specifics
    private String internalAcctNum;
    private String accountType;
    private String signatory;
    private String reminderFlag; // YES or NO.
    private String creditAppIdLabel;
    private Long creditAppId;
    // private String refResponseLink;
    // private String emailMsg;
    /*
     * added 1:27:2010
     */
    private String refEmail;
    private Long refUserId;
    /*
     * ADDED : MARCH 19, 2009 DEFAULT VALUE - REGULAR
     */
    private String requestMode = CrolConstants.REQUEST_MODE_REGULAR; // MANUAL
                                                                     // OR
                                                                     // REGULAR
    /*
     * ADDED : FEB 5, 2011 GROUP ACCOUNT PROCESSING VARIABLES
     */
    private String groupRequestFlag = CrolConstants.NO;
    private Long groupId;
    protected boolean requestIsGroup;
    /// \\\
    private String noRefCallFlag = MatrixConstants.ANSWER_NO;

    public String getRequestStatusDescription() {
        Map<String, String> mp = new HashMap<String, String>(17);
        mp.put("0", "No response yet");
        mp.put("1", "No response yet - First Reminder sent on "
                + this.getLastReminderDate());
        mp.put("2", "No response yet - Second Reminder sent on "
                + this.getLastReminderDate());
        mp.put("3", "No response yet - Third Reminder sent on "
                + this.getLastReminderDate());
        mp.put("4", "No response yet - Fourth Reminder sent on "
                + this.getLastReminderDate());
        mp.put("5", "No response yet - Fifth and Final Reminder sent on "
                + this.getLastReminderDate());
        int reminder = this.reminderCount;
        if (reminder > 5 || reminder < 0) {
            reminder = 5;
        }
        return (String) mp.get(String.valueOf(reminder));
    }


    /**
     * DEFAULT CONSTRUCTOR
     */
    public CrolRequestBean() {
        // initialize currency
    }

    /**
     * @return Returns the customerCorpId.
     */
    public String getCustomerCorpId() {
        return customerCorpId;
    }

    /**
     * @param customerCorpId
     *            The customerCorpId to set.
     */
    public void setCustomerCorpId(String customerCorpId) {
        this.customerCorpId = customerCorpId;
    }

    /**
     * @return Returns the dateOfResponse.
     */
    public Date getDateOfResponse() {
        return (Date) (dateOfResponse == null ? null : dateOfResponse.clone());
    }

    /**
     * @param dateOfResponse
     *            The dateOfResponse to set.
     */
    public void setDateOfResponse(Date dateOfResponse) {
        this.dateOfResponse = (Date) (dateOfResponse == null ? null : dateOfResponse.clone());
    }

    /**
     * @return Returns the dateSent.
     */
    public Date getDateSent() {
        return (Date) (dateSent == null ? null : dateSent.clone());
    }

    /**
     * @param dateSent
     *            The dateSent to set.
     */
    public void setDateSent(Date dateSent) {
        this.dateSent = (Date) (dateSent == null ? null : dateSent.clone());
    }

    /**
     * @return Returns the fromCorpId.
     */
    public String getFromCorpId() {
        return fromCorpId;
    }

    /**
     * @param fromCorpId
     *            The fromCorpId to set.
     */
    public void setFromCorpId(String fromCorpId) {
        this.fromCorpId = fromCorpId;
    }

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
     * @return Returns the originatingCorpId.
     */
    public String getOriginatingCorpId() {
        return originatingCorpId;
    }

    /**
     * @param originatingCorpId
     *            The originatingCorpId to set.
     */
    public void setOriginatingCorpId(String originatingCorpId) {
        this.originatingCorpId = originatingCorpId;
    }

    /**
     * @return Returns the toCorpId.
     */
    public String getToCorpId() {
        return toCorpId;
    }

    /**
     * @param toCorpId
     *            The toCorpId to set.
     */
    public void setToCorpId(String toCorpId) {
        this.toCorpId = toCorpId;
    }

    /**
     * @return Returns the requestorId.
     */
    public String getRequestorId() {
        return requestorId;
    }

    /**
     * @param requestorId
     *            The requestorId to set.
     */
    public void setRequestorId(String requestorId) {
        this.requestorId = requestorId;
    }

    /**
     * @return Returns the requestType.
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * @param requestType
     *            The requestType to set.
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    /**
     * @return Returns the daysInProcess.
     */
    public int getDaysInProcess() {
        return daysInProcess;
    }

    /**
     * @param daysInProcess
     *            The daysInProcess to set.
     */
    public void setDaysInProcess(int daysInProcess) {
        this.daysInProcess = daysInProcess;
    }

    /**
     * @return Returns the customerCorpName.
     */
    public String getCustomerCorpName() {
        return customerCorpName;
    }

    /**
     * @param customerCorpName
     *            The customerCorpName to set.
     */
    public void setCustomerCorpName(String customerCorpName) {
        this.customerCorpName = customerCorpName;
    }

    /**
     * @return Returns the fromCorpName.
     */
    public String getFromCorpName() {
        return fromCorpName;
    }

    /**
     * @param fromCorpName
     *            The fromCorpName to set.
     */
    public void setFromCorpName(String fromCorpName) {
        this.fromCorpName = fromCorpName;
    }

    /**
     * @return Returns the originatingCorpName.
     */
    public String getOriginatingCorpName() {
        return originatingCorpName;
    }

    /**
     * @param originatingCorpName
     *            The originatingCorpName to set.
     */
    public void setOriginatingCorpName(String originatingCorpName) {
        this.originatingCorpName = originatingCorpName;
    }

    /**
     * @return Returns the toCorpName.
     */
    public String getToCorpName() {
        return toCorpName;
    }

    /**
     * @param toCorpName
     *            The toCorpName to set.
     */
    public void setToCorpName(String toCorpName) {
        this.toCorpName = toCorpName;
    }

    /**
     * @return Returns the signedRequest.
     */
    public String getSignedRequest() {
        return signedRequest;
    }

    /**
     * @param signedRequest
     *            The signedRequest to set.
     */
    public void setSignedRequest(String signedRequest) {
        this.signedRequest = signedRequest;
    }

    /**
     * @return Returns the requestStatus.
     */
    public String getRequestStatus() {
        return requestStatus;
    }

    /**
     * @param requestStatus
     *            The requestStatus to set.
     */
    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    /**
     * @return Returns the requestStatusAction.
     */
    public String getRequestStatusAction() {
        return requestStatusAction;
    }

    /**
     * @param requestStatusAction
     *            The requestStatusAction to set.
     */
    public void setRequestStatusAction(String requestStatusAction) {
        this.requestStatusAction = requestStatusAction;
    }

    /**
     * @return Returns the emailSentStatus.
     */
    public String getEmailSentStatus() {
        return emailSentStatus;
    }

    /**
     * @param emailSentStatus
     *            The emailSentStatus to set.
     */
    public void setEmailSentStatus(String emailSentStatus) {
        this.emailSentStatus = emailSentStatus;
    }

    /**
     * @return Returns the emailSentTrial.
     */
    public int getEmailSentTrial() {
        return emailSentTrial;
    }

    /**
     * @param emailSentTrial
     *            The emailSentTrial to set.
     */
    public void setEmailSentTrial(int emailSentTrial) {
        this.emailSentTrial = emailSentTrial;
    }

    /**
     * @return Returns the requestComment.
     */
    public String getRequestComment() {
        return requestComment;
    }

    /**
     * @param requestComment
     *            The requestComment to set.
     */
    public void setRequestComment(String requestComment) {
        this.requestComment = requestComment;
    }

    /**
     * @return Returns the acctOpenedForCode.
     */
    public String getAcctOpenedForCode() {
        return acctOpenedForCode;
    }

    /**
     * @param acctOpenedForCode
     *            The acctOpenedForCode to set.
     */
    public void setAcctOpenedForCode(String acctOpenedForCode) {
        this.acctOpenedForCode = acctOpenedForCode;
    }

    /**
     * @return Returns the amountRequested.
     */
    public double getAmountRequested() {
        return amountRequested;
    }

    /**
     * @param amountRequested
     *            The amountRequested to set.
     */
    public void setAmountRequested(double amountRequested) {
        this.amountRequested = amountRequested;
    }

    /**
     * @return Returns the hiCredit.
     */
    public double getHiCredit() {
        return hiCredit;
    }

    /**
     * @param hiCredit
     *            The hiCredit to set.
     */
    public void setHiCredit(double hiCredit) {
        this.hiCredit = hiCredit;
    }

    /**
     * @return Returns the termsCode.
     */
    public String getTermsCode() {
        return termsCode;
    }

    /**
     * @param termsCode
     *            The termsCode to set.
     */
    public void setTermsCode(String termsCode) {
        this.termsCode = termsCode;
    }

    /**
     * @return Returns the paymentExperience.
     */
    public String getPaymentExperience() {
        return paymentExperience;
    }

    /**
     * @param paymentExperience
     *            The paymentExperience to set.
     */
    public void setPaymentExperience(String paymentExperience) {
        this.paymentExperience = paymentExperience;
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
     * @return Returns the requestOriginator.
     */
    public String getRequestOriginator() {
        return requestOriginator;
    }

    /**
     * @param requestOriginator
     *            The requestOriginator to set.
     */
    public void setRequestOriginator(String requestOriginator) {
        this.requestOriginator = requestOriginator;
    }

    /**
     * @return Returns the reasonForRequest.
     */
    public String getReasonForRequest() {
        return reasonForRequest;
    }

    /**
     * @param reasonForRequest
     *            The reasonForRequest to set.
     */
    public void setReasonForRequest(String reasonForRequest) {
        this.reasonForRequest = reasonForRequest;
    }

    /**
     * @return Returns the balanceOwing.
     */
    public double getBalanceOwing() {
        return balanceOwing;
    }

    /**
     * @param balanceOwing
     *            The balanceOwing to set.
     */
    public void setBalanceOwing(double balanceOwing) {
        this.balanceOwing = balanceOwing;
    }

    /**
     * @return Returns the processed.
     */
    public boolean isProcessed() {
        if (this.requestStatus.trim()
                .equals(CrolConstants.REQUEST_STATUS_PROCESSED)) {
            return true;
        }
        return false;
    }

    /**
     * @return Returns the requestID.
     */
    public String getRequestID() {
        return requestID;
    }

    /**
     * @param requestID
     *            The requestID to set.
     */
    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    /**
     * @return Returns the reasonIsExistingAcct.
     */
    public boolean isReasonIsExistingAcct() {
        if (this.reasonForRequest.trim()
                .equals(CrolConstants.ESTABLISHED_CUSTOMER)) {
            return true;
        }
        return false;
    }

        /**
     * @return Returns the reasonIsNewCustomer.
     */
    public boolean isReasonIsNewCustomer() {
        if (this.reasonForRequest.trim().equals(CrolConstants.NEW_ACCOUNT)) {
            return true;
        }
        return false;
    }


    /**
     * @return Returns the reasonIsUpdatingFile.
     */
    public boolean isReasonIsUpdatingFile() {
        if (this.reasonForRequest.trim().equals(CrolConstants.UPDATING_FILE)) {
            return true;
        }
        return false;
    }

    /**
     * @return Returns the requestorComment.
     */
    public boolean isRequestorComment() {
        if (this.requestComment.trim().length() < 1) {
            return false;
        }
        return true;
    }

    /**
     * @return Returns the displayExistingAccountPanelBank.
     */
    public boolean isDisplayExistingAccountPanelBank() {
        return displayExistingAccountPanelBank;
    }

    /**
     * @param displayExistingAccountPanelBank
     *            The displayExistingAccountPanelBank to set.
     */
    public void setDisplayExistingAccountPanelBank(boolean displayExistingAccountPanelBank) {
        this.displayExistingAccountPanelBank = displayExistingAccountPanelBank;
    }

    /**
     * @return Returns the displayExistingAccountPanelTrade.
     */
    public boolean isDisplayExistingAccountPanelTrade() {
        return displayExistingAccountPanelTrade;
    }

    /**
     * @param displayExistingAccountPanelTrade
     *            The displayExistingAccountPanelTrade to set.
     */
    public void setDisplayExistingAccountPanelTrade(boolean displayExistingAccountPanelTrade) {
        this.displayExistingAccountPanelTrade = displayExistingAccountPanelTrade;
    }

    /**
     * @return Returns the displayNewAccountPanel.
     */
    public boolean isDisplayNewAccountPanel() {
        return displayNewAccountPanel;
    }

    /**
     * @param displayNewAccountPanel
     *            The displayNewAccountPanel to set.
     */
    public void setDisplayNewAccountPanel(boolean displayNewAccountPanel) {
        this.displayNewAccountPanel = displayNewAccountPanel;
    }

    /**
     * @return Returns the dateReceived.
     */
    public Date getDateReceived() {
        return (Date) (dateReceived == null ? null : dateReceived.clone());
    }

    /**
     * @param dateReceived
     *            The dateReceived to set.
     */
    public void setDateReceived(Date dateReceived) {
        this.dateReceived = (Date) (dateReceived == null ? null : dateReceived.clone());
    }

    /**
     * @return Returns the inboxSubject.
     */
    public String getInboxSubject() {
        return inboxSubject;
    }

    /**
     * @param inboxSubject
     *            The inboxSubject to set.
     */
    public void setInboxSubject(String inboxSubject) {
        this.inboxSubject = inboxSubject;
    }

    /**
     * @return Returns the requestProcessed.
     */
    public boolean isRequestProcessed() {
        if (this.requestStatus.trim()
                .equals(CrolConstants.REQUEST_STATUS_PROCESSED)) {
            return true;
        }
        return false;
    }

    /**
     * @return Returns the inboxSubjectID.
     */
    public String getInboxSubjectID() {
        return inboxSubjectID;
    }

    /**
     * @param inboxSubjectID
     *            The inboxSubjectID to set.
     */
    public void setInboxSubjectID(String inboxSubjectID) {
        this.inboxSubjectID = inboxSubjectID;
    }

    /**
     * @return Returns the inOrOutNetFlag.
     */
    public String getInOrOutNetFlag() {
        return inOrOutNetFlag;
    }

    /**
     * @param inOrOutNetFlag
     *            The inOrOutNetFlag to set.
     */
    public void setInOrOutNetFlag(String inOrOutNetFlag) {
        this.inOrOutNetFlag = inOrOutNetFlag;
    }

    /**
     * @return Returns the currency.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency
     *            The currency to set.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return Returns the fromCorpNameInbox.
     */
    public String getFromCorpNameInbox() {
        return fromCorpNameInbox;
    }

    /**
     * @param fromCorpNameInbox
     *            The fromCorpNameInbox to set.
     */
    public void setFromCorpNameInbox(String fromCorpNameInbox) {
        this.fromCorpNameInbox = fromCorpNameInbox;
    }

    /**
     * @return Returns the customerCorp.
     */
    public CorpBean getCustomerCorp() {
        return customerCorp;
    }

    /**
     * @param customerCorp
     *            The customerCorp to set.
     */
    public void setCustomerCorp(CorpBean customerCorp) {
        this.customerCorp = customerCorp;
    }

    public SupplierCompanyBean getFromCorp() {
        return fromCorp;
    }

    public void setFromCorp(SupplierCompanyBean fromCorp) {
        this.fromCorp = fromCorp;
    }

    /**
     * @return Returns the originatingCorp.
     */
    public CorpBean getOriginatingCorp() {
        return originatingCorp;
    }

    /**
     * @param originatingCorp
     *            The originatingCorp to set.
     */
    public void setOriginatingCorp(CorpBean originatingCorp) {
        this.originatingCorp = originatingCorp;
    }

    /**
     * @return Returns the toCorp.
     */
    public CorpBean getToCorp() {
        return toCorp;
    }

    /**
     * @param toCorp
     *            The toCorp to set.
     */
    public void setToCorp(CorpBean toCorp) {
        this.toCorp = toCorp;
    }

    /**
     * @return Returns the onetRequestId.
     */
    public String getOnetRequestId() {
        return onetRequestId;
    }

    /**
     * @param onetRequestId
     *            The onetRequestId to set.
     */
    public void setOnetRequestId(String onetRequestId) {
        this.onetRequestId = onetRequestId;
    }

    /**
     * @return Returns the requestSource.
     */
    public String getRequestSource() {
        return requestSource;
    }

    /**
     * @param requestSource
     *            The requestSource to set.
     */
    public void setRequestSource(String requestSource) {
        this.requestSource = requestSource;
    }

    public SupplierUserBean getRequestor() {
        return requestor;
    }

    public void setRequestor(SupplierUserBean requestor) {
        this.requestor = requestor;
    }

    public Date getLastReminderDate() {
        return (Date) (lastReminderDate == null ? null : lastReminderDate.clone());
    }

    public void setLastReminderDate(Date lastReminderDate) {
        this.lastReminderDate = (Date) (lastReminderDate == null ? null : lastReminderDate.clone());
    }

    public String getRequestMode() {
        return requestMode;
    }

    public void setRequestMode(String requestMode) {
        this.requestMode = requestMode;
    }

    public boolean isModeIsManual() {
        if (this.requestMode != null && this.requestMode.trim()
                .equals(CrolConstants.REQUEST_MODE_MANUAL)) {
            return true;
        }
        return false;
    }

    public CorpBean getRefereeCompany() {
        return refereeCompany;
    }

    public void setRefereeCompany(CorpBean refereeCompany) {
        this.refereeCompany = refereeCompany;
    }

    public boolean isOutNetwork() {
        if (this.inOrOutNetFlag.trim()
                .equals(CrolConstants.NETWORK_STATUS_OUT)) {
            return true;
        }
        return false;
    }

    public String getRefEmail() {
        return refEmail;
    }

    public void setRefEmail(String refEmail) {
        this.refEmail = refEmail;
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

    public boolean isBankReference() {
        if (this.getRequestType().trim()
                .equals(CrolConstants.REFERENCE_TYPE_BANK)) {
            return true;
        }
        return false;
    }

    public String getReminderFlag() {
        return reminderFlag;
    }

    public void setReminderFlag(String reminderFlag) {
        this.reminderFlag = reminderFlag;
    }

    public String getCreditAppIdLabel() {
        return creditAppIdLabel;
    }

    public void setCreditAppIdLabel(String creditAppId) {
        this.creditAppIdLabel = creditAppId;
    }

    public Long getCreditAppId() {
        return creditAppId;
    }

    public void setCreditAppId(Long creditAppId) {
        this.creditAppId = creditAppId;
    }

    public Long getRefUserId() {
        return refUserId;
    }

    public void setRefUserId(Long refUserId) {
        this.refUserId = refUserId;
    }

    public String getGroupRequestFlag() {
        return groupRequestFlag;
    }

    public void setGroupRequestFlag(String groupRequestFlag) {
        this.groupRequestFlag = groupRequestFlag;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public boolean isRequestIsGroup() {
        return requestIsGroup;
    }

    public void setRequestIsGroup(boolean requestIsGroup) {
        this.requestIsGroup = requestIsGroup;
    }

    public boolean isIndoGroupRequest() {
        return this.getReasonForRequest().trim()
                .equals(CrolConstants.REASON_FOR_REQUEST_INDO_GROUP_INQUIRY)
                        ? true : false;
    }

    public boolean isSupplierFileUpdateRequest() {
        return this.getReasonForRequest().trim().equals(
                CrolConstants.REASON_FOR_REQUEST_UPDATE_FILE) ? true : false;
    }

    public boolean isNewAccountRequest() {
        return this.getReasonForRequest().trim().equals(
                CrolConstants.REASON_FOR_REQUEST_NEW_ACCOUNT) ? true : false;
    }

    public String getNoRefCallFlag() {
        return noRefCallFlag;
    }

    public void setNoRefCallFlag(String noRefCallFlag) {
        this.noRefCallFlag = noRefCallFlag;
    }

    public boolean isRefCallNotRequired() {
        if (this.getNoRefCallFlag() == null) {
            return false;
        }
        return this.getNoRefCallFlag().trim().equals(MatrixConstants.ANSWER_YES)
                ? true : false;
    }

}
