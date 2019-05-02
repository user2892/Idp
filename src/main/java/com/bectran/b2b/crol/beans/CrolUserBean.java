package com.bectran.b2b.crol.beans;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.bectran.b2b.crol.constants.CrolConstants;

/**
 * @author LOUIS IFEGUNI
 */
public class CrolUserBean {
    protected String firstName = "";
    protected String lastName = "";
    protected String corpID = "";
    protected String orgPassCode = "";
    protected String email = "";
    protected String salutation = "";
    // protected String userId = "";
    protected String encryptedPassword = "";
    protected String clearPassword = "";
    protected String clearPasswordConfirm = "";
    protected String accountStatus = "";
    protected Timestamp lastUpdate;
    protected String userType = "";
    //
    protected String workTitle = "";
    protected String workPhone = "";
    protected String workPhone2 = "";
    protected String cellPhone = "";
    //
    protected String securityQuestionDetail = "";
    //
    protected String securityQuestionId = "";
    protected String securityAnswer = "";
    protected String agreedToTerms = "";
    protected String readPrivacyPolicy = "";
    //
    protected Date todaysDate = new Date();
    protected String registrationStatus = ""; // COMPANY REGISTERED ALREADY OR
                                              // NOT
    protected String userComment = "";
    // FOR DISPLAY PURPOSE
    protected String userName_ = "";
    //
    protected String pageFlowToken = "";
    protected String userNameCompany = ""; // displayed on the page header
    /* analytics variables */
    protected int analyticsUsageLevel;
    protected int numberOfCreditRefs;
    protected List crolCustomers;
    /*
     * ADMIN CODE
     */
    protected String adminCode;
    protected String subscriptionFlag = "";
    protected String unsubscribeReasonCode = "";
    protected String unsubscribeFeedback = "";
    //
    private CorpBean userCompany; // hibernate mapping
    private Long id;
    private boolean existingUser;
    /*
     * subscription
     */
    private boolean subscriptionExpired;

    /**
     * DEFAULT CONSTRUCTOR
     */
    public CrolUserBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isExistingUser() {
        return existingUser;
    }

    public void setExistingUser(boolean existingUser) {
        this.existingUser = existingUser;
    }

    public boolean isSubscriptionExpired() {
        return subscriptionExpired;
    }

    public void setSubscriptionExpired(boolean subscriptionExpired) {
        this.subscriptionExpired = subscriptionExpired;
    }

    /**
     * @return Returns the accountStatus.
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     * @param accountStatus
     *            The accountStatus to set.
     */
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * @return Returns the corpID.
     */
    public String getCorpID() {
        return corpID;
    }

    /**
     * @param corpID
     *            The corpID to set.
     */
    public void setCorpID(String corpID) {
        this.corpID = corpID;
    }

    /**
     * @return Returns the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Returns the firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            The firstName to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return Returns the lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            The lastName to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Returns the clearPassword.
     */
    public String getClearPassword() {
        return clearPassword;
    }

    /**
     * @param clearPassword
     *            The clearPassword to set.
     */
    public void setClearPassword(String clearPassword) {
        this.clearPassword = clearPassword;
    }

    /**
     * @return Returns the encryptedPassword.
     */
    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    /**
     * @param encryptedPassword
     *            The encryptedPassword to set.
     */
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    /**
     * @return Returns the lastUpdate.
     */
    public Timestamp getLastUpdate() {
        return (Timestamp) (lastUpdate == null ? null : lastUpdate.clone());
    }

    /**
     * @param lastUpdate
     *            The lastUpdate to set.
     */
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = (Timestamp) (lastUpdate == null ? null : lastUpdate.clone());
    }

    /**
     * @return Returns the userType.
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType
     *            The userType to set.
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return Returns the cellPhone.
     */
    public String getCellPhone() {
        return cellPhone;
    }

    /**
     * @param cellPhone
     *            The cellPhone to set.
     */
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    /**
     * @return Returns the workTitle.
     */
    public String getWorkTitle() {
        return workTitle;
    }

    /**
     * @param workTitle
     *            The workTitle to set.
     */
    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    /**
     * @return Returns the workPhone.
     */
    public String getWorkPhone() {
        return workPhone;
    }

    /**
     * @param workPhone
     *            The workPhone to set.
     */
    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    /**
     * @return Returns the workPhone2.
     */
    public String getWorkPhone2() {
        return workPhone2;
    }

    /**
     * @param workPhone2
     *            The workPhone2 to set.
     */
    public void setWorkPhone2(String workPhone2) {
        this.workPhone2 = workPhone2;
    }

    /**
     * @return Returns the agreedToTerms.
     */
    public String getAgreedToTerms() {
        return agreedToTerms;
    }

    /**
     * @param agreedToTerms
     *            The agreedToTerms to set.
     */
    public void setAgreedToTerms(String agreedToTerms) {
        this.agreedToTerms = agreedToTerms;
    }

    /**
     * @return Returns the readPrivacyPolicy.
     */
    public String getReadPrivacyPolicy() {
        return readPrivacyPolicy;
    }

    /**
     * @param readPrivacyPolicy
     *            The readPrivacyPolicy to set.
     */
    public void setReadPrivacyPolicy(String readPrivacyPolicy) {
        this.readPrivacyPolicy = readPrivacyPolicy;
    }

    /**
     * @return Returns the securityAnswer.
     */
    public String getSecurityAnswer() {
        return securityAnswer;
    }

    /**
     * @param securityAnswer
     *            The securityAnswer to set.
     */
    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    /**
     * @return Returns the securityQuestionId.
     */
    public String getSecurityQuestionId() {
        return securityQuestionId;
    }

    /**
     * @param securityQuestionId
     *            The securityQuestionId to set.
     */
    public void setSecurityQuestionId(String securityQuestionId) {
        this.securityQuestionId = securityQuestionId;
    }

    /**
     * @return Returns the orgPassCode.
     */
    public String getOrgPassCode() {
        return orgPassCode;
    }

    /**
     * @param orgPassCode
     *            The orgPassCode to set.
     */
    public void setOrgPassCode(String orgPassCode) {
        this.orgPassCode = orgPassCode;
    }

    /**
     * @return Returns the todaysDate.
     */
    public Date getTodaysDate() {
        return (Date) (todaysDate == null ? null : todaysDate.clone());
    }

    /**
     * @param todaysDate
     *            The todaysDate to set.
     */
    public void setTodaysDate(Date todaysDate) {
        this.todaysDate = (Date) (todaysDate == null ? null : todaysDate.clone());
    }

    /**
     * @return Returns the registrationStatus.
     */
    public String getRegistrationStatus() {
        return registrationStatus;
    }

    /**
     * @param registrationStatus
     *            The registrationStatus to set.
     */
    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    /**
     * @return Returns the userNameCompany.
     */
    public String getUserNameCompany() {
        return userNameCompany;
    }

    /**
     * @param userNameCompany
     *            The userNameCompany to set.
     */
    public void setUserNameCompany(String userNameCompany) {
        this.userNameCompany = userNameCompany;
    }

    /**
     * @return Returns the salutation.
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * @param salutation
     *            The salutation to set.
     */
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    /**
     * @return Returns the userName_.
     */
    public String getUserName_() {
        return userName_;
    }

    /**
     * @param userName_
     *            The userName_ to set.
     */
    public void setUserName_(String userName_) {
        this.userName_ = userName_;
    }

    /**
     * @return Returns the userComment.
     */
    public String getUserComment() {
        return userComment;
    }

    /**
     * @param userComment
     *            The userComment to set.
     */
    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    /**
     * @return Returns the pageFlowToken.
     */
    public String getPageFlowToken() {
        return pageFlowToken;
    }

    /**
     * @param pageFlowToken
     *            The pageFlowToken to set.
     */
    public void setPageFlowToken(String pageFlowToken) {
        this.pageFlowToken = pageFlowToken;
    }

    /**
     * @return Returns the adminCode.
     */
    public String getAdminCode() {
        return adminCode;
    }

    /**
     * @param adminCode
     *            The adminCode to set.
     */
    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    /**
     * @return Returns the analyticsUsageLevel.
     */
    public int getAnalyticsUsageLevel() {
        return analyticsUsageLevel;
    }

    /**
     * @param analyticsUsageLevel
     *            The analyticsUsageLevel to set.
     */
    public void setAnalyticsUsageLevel(int analyticsUsageLevel) {
        this.analyticsUsageLevel = analyticsUsageLevel;
    }

    /**
     * @return Returns the anlyticsAuthorized.
     */
    public boolean isAnlyticsAuthorized() {
        if (this.analyticsUsageLevel >= CrolConstants.ANALYTICS_USAGE_LEVEL_1) {
            return true;
        }
        return false;
    }

    /**
     * @return Returns the numberOfCreditRefs.
     */
    public int getNumberOfCreditRefs() {
        return numberOfCreditRefs;
    }

    /**
     * @param numberOfCreditRefs
     *            The numberOfCreditRefs to set.
     */
    public void setNumberOfCreditRefs(int numberOfCreditRefs) {
        this.numberOfCreditRefs = numberOfCreditRefs;
    }

    /**
     * @return Returns the crolCustomers.
     */
    public List getCrolCustomers() {
        return crolCustomers;
    }

    /**
     * @param crolCustomers
     *            The crolCustomers to set.
     */
    public void setCrolCustomers(List crolCustomers) {
        this.crolCustomers = crolCustomers;
    }

    /**
     * @return Returns the clearPasswordConfirm.
     */
    public String getClearPasswordConfirm() {
        return clearPasswordConfirm;
    }

    /**
     * @param clearPasswordConfirm
     *            The clearPasswordConfirm to set.
     */
    public void setClearPasswordConfirm(String clearPasswordConfirm) {
        this.clearPasswordConfirm = clearPasswordConfirm;
    }

    /**
     * @return Returns the subscriptionFlag.
     */
    public String getSubscriptionFlag() {
        return subscriptionFlag;
    }

    /**
     * @param subscriptionFlag
     *            The subscriptionFlag to set.
     */
    public void setSubscriptionFlag(String subscriptionFlag) {
        this.subscriptionFlag = subscriptionFlag;
    }

    public String getUnsubscribeFeedback() {
        return unsubscribeFeedback;
    }

    public void setUnsubscribeFeedback(String unsubscribeFeedback) {
        this.unsubscribeFeedback = unsubscribeFeedback;
    }

    public String getUnsubscribeReasonCode() {
        return unsubscribeReasonCode;
    }

    public void setUnsubscribeReasonCode(String unsubscribeReasonCode) {
        this.unsubscribeReasonCode = unsubscribeReasonCode;
    }

    public String getSecurityQuestionDetail() {
        return securityQuestionDetail;
    }

    public void setSecurityQuestionDetail(String securityQuestionDetail) {
        this.securityQuestionDetail = securityQuestionDetail;
    }

    public CorpBean getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(CorpBean userCompany) {
        this.userCompany = userCompany;
    }

    public String getName() {
        return this.getFirstName().trim() + " " + this.getLastName().trim();
    }

}
