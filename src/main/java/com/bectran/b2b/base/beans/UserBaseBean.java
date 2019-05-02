package com.bectran.b2b.base.beans;

import java.sql.Timestamp;
import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.constants.UserDocReceiptPreferenceConstants;

/**
 * @author Louis Ifeguni
 * @date Jan 3, 2007: 9:51:53 AM
 */
public class UserBaseBean {
    //
    // public static final String STATUS_ACTIVE = "ACTIVE";
    // public static final String STATUS_LOCKED = "LOCKED";
    // public static final String STATUS_INACTIVE = "INACTIVE";
    public static final int LOGIN_LIMIT = 5;
    //
    public static final String USER_IS_SYSTEM = "system";
    /**
     * LOGIN COUNTER
     */
    protected int loginCounter = 0;
    // specifically for login to mitigate browser cache conflicts with usage of
    // userId and password
    protected String userIdLogin = "";
    protected String passwordLogin = "";
    //
    protected String homeProcessId = "";
    protected String scopeOfDocReceipt = UserDocReceiptPreferenceConstants.SCOPE_ALL;// receive
                                                                                     // documents
                                                                                     // for
                                                                                     // ALL
                                                                                     // or
                                                                                     // MY-ACCOUNTS
                                                                                     // only
    protected String userId = "";
    protected String password = "";
    protected String encryptedPassword = "";
    protected String vpassword = "";
    protected String role = MatrixConstants.USER_LEVEL_ORDINARY;
    protected String roleFlag = MatrixConstants.USER_TYPE_CREDIT;
    protected String firstName = "";
    protected String lastName = "";
    protected String phone = "";
    protected String email = "";
    protected Timestamp dateCreated;
    protected Timestamp lastLogonDate;
    protected String status = ""; // indicates user's status - active OR
                                  // inactive
    protected String title = "Credit Manager";
    protected String titleCode = "";
    protected String department = "";
    protected String salutation = "";
    protected String agreedToTerm = "";
    private String secQuestion = "";
    private String secQuestionDetail = "";
    private String secAnswer = "";
    private String userClass = "";
    // RISK MANAGER SPECIFIC VARIABLES
    protected String portId = "";
    protected String approvalLevel = "";
    protected double approvalAmount;
    protected Timestamp lastUpdateDate;
    protected String validRange = "";
    private String agreedToTerms;
    private String crolCorpID = "";
    // private CorpBean userCompany;
    protected String homeCurrency = "";
    protected String userInfo = "";
    private Date lastPwdResetDate;
    private String acctNum;
    private byte[] signatureImage; // signature
    private byte[] inputSignature; // signature
    private boolean selected = true;
    private String userConfirm = ""; // answer YES or NO
    private String confirmEmail = "";
    private String opsAdministrator = MatrixConstants.ANSWER_NO;
    private String internalCode = "N/A";
    // protected String salesRepNameWithCode;

    /**
     * @return Returns the dateCreated.
     */
    public Timestamp getDateCreated() {
        return (Timestamp) (dateCreated == null ? null : dateCreated.clone());
    }

    /**
     * @param dateCreated
     *            The dateCreated to set.
     */
    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = (Timestamp) (dateCreated == null ? null : dateCreated.clone());
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
     * @return Returns the lastLogonDate.
     */
    public Timestamp getLastLogonDate() {
        return (Timestamp) (lastLogonDate == null ? null : lastLogonDate.clone());
    }

    /**
     * @param lastLogonDate
     *            The lastLogonDate to set.
     */
    public void setLastLogonDate(Timestamp lastLogonDate) {
        this.lastLogonDate = (Timestamp) (lastLogonDate == null ? null : lastLogonDate.clone());
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
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return Returns the passwordLogin.
     */
    public String getPasswordLogin() {
        return passwordLogin;
    }

    /**
     * @param passwordLogin
     *            The passwordLogin to set.
     */
    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
    }

    /**
     * @return Returns the phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     *            The phone to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return Returns the role.
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     *            The role to set.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return Returns the roleFlag.
     */
    public String getRoleFlag() {
        return roleFlag;
    }

    /**
     * @param roleFlag
     *            The roleFlag to set.
     */
    public void setRoleFlag(String roleFlag) {
        this.roleFlag = roleFlag;
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
     * @return Returns the userIdLogin.
     */
    public String getUserIdLogin() {
        return userIdLogin;
    }

    /**
     * @param userIdLogin
     *            The userIdLogin to set.
     */
    public void setUserIdLogin(String userIdLogin) {
        this.userIdLogin = userIdLogin;
    }

    /**
     * @return Returns the vpassword.
     */
    public String getVpassword() {
        return vpassword;
    }

    /**
     * @param vpassword
     *            The vpassword to set.
     */
    public void setVpassword(String vpassword) {
        this.vpassword = vpassword;
    }

    /**
     * @return Returns the approvalAmount.
     */
    public double getApprovalAmount() {
        return approvalAmount;
    }

    /**
     * @param approvalAmount
     *            The approvalAmount to set.
     */
    public void setApprovalAmount(double approvalAmount) {
        this.approvalAmount = approvalAmount;
    }

    /**
     * @return Returns the approvalLevel.
     */
    public String getApprovalLevel() {
        return approvalLevel;
    }

    /**
     * @param approvalLevel
     *            The approvalLevel to set.
     */
    public void setApprovalLevel(String approvalLevel) {
        this.approvalLevel = approvalLevel;
    }

    /**
     * @return Returns the lastUpdateDate.
     */
    public Timestamp getLastUpdateDate() {
        return (Timestamp) (lastUpdateDate == null ? null : lastUpdateDate.clone());
    }

    /**
     * @param lastUpdateDate
     *            The lastUpdateDate to set.
     */
    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = (Timestamp) (lastUpdateDate == null ? null : lastUpdateDate.clone());
    }

    /**
     * @return Returns the portId.
     */
    public String getPortId() {
        return portId;
    }

    /**
     * @param portId
     *            The portId to set.
     */
    public void setPortId(String portId) {
        this.portId = portId;
    }

    /**
     * @return Returns the validRange.
     */
    public String getValidRange() {
        return validRange;
    }

    /**
     * @param validRange
     *            The validRange to set.
     */
    public void setValidRange(String validRange) {
        this.validRange = validRange;
    }

    /**
     * @return Returns the status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     *            The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return Returns the homeProcessId.
     */
    public String getHomeProcessId() {
        return homeProcessId;
    }

    /**
     * @param homeProcessId
     *            The homeProcessId to set.
     */
    public void setHomeProcessId(String homeProcessId) {
        this.homeProcessId = homeProcessId;
    }

    /**
     * @return Returns the scopeOfDocReceipt.
     */
    public String getScopeOfDocReceipt() {
        return scopeOfDocReceipt;
    }

    /**
     * @param scopeOfDocReceipt
     *            The scopeOfDocReceipt to set.
     */
    public void setScopeOfDocReceipt(String riskMgrFlag) {
        this.scopeOfDocReceipt = riskMgrFlag;
    }

    /**
     * @return Returns the userName.
     */
    public String getUserName() {
        return this.firstName + " " + this.lastName;
    }

    
    /**
     * @return Returns the department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department
     *            The department to set.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return Returns the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return Returns the secAnswer.
     */
    public String getSecAnswer() {
        return secAnswer;
    }

    /**
     * @param secAnswer
     *            The secAnswer to set.
     */
    public void setSecAnswer(String secAnswer) {
        this.secAnswer = secAnswer;
    }

    /**
     * @return Returns the secQuestion.
     */
    public String getSecQuestion() {
        return secQuestion;
    }

    /**
     * @param secQuestion
     *            The secQuestion to set.
     */
    public void setSecQuestion(String secQuestion) {
        this.secQuestion = secQuestion;
    }

    /**
     * @return Returns the secQuestionDetail.
     */
    public String getSecQuestionDetail() {
        return secQuestionDetail;
    }

    /**
     * @param secQuestionDetail
     *            The secQuestionDetail to set.
     */
    public void setSecQuestionDetail(String secQuestionDetail) {
        this.secQuestionDetail = secQuestionDetail;
    }

    /**
     * @return Returns the userClass.
     */
    public String getUserClass() {
        return userClass;
    }

    /**
     * @param userClass
     *            The userClass to set.
     */
    public void setUserClass(String userClass) {
        this.userClass = userClass;
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
     * @return Returns the agreedToTerm.
     */
    public String getAgreedToTerm() {
        return agreedToTerm;
    }

    /**
     * @param agreedToTerm
     *            The agreedToTerm to set.
     */
    public void setAgreedToTerm(String agreedToTerm) {
        this.agreedToTerm = agreedToTerm;
    }

    public String getLastFirstNameLabel() {
        return this.lastName + ", " + this.firstName + "(" + this.salutation
                + ")";
    }

    public String getAgreedToTerms() {
        return agreedToTerms;
    }

    public void setAgreedToTerms(String agreedToTerms) {
        this.agreedToTerms = agreedToTerms;
    }

    public String getCrolCorpID() {
        return crolCorpID;
    }

    public void setCrolCorpID(String corpID) {
        this.crolCorpID = corpID;
    }

    public int getLoginCounter() {
        return loginCounter;
    }

    public void setLoginCounter(int loginCounter) {
        this.loginCounter = loginCounter;
    }

    public String getHomeCurrency() {
        return homeCurrency;
    }

    public void setHomeCurrency(String homeCurrency) {
        this.homeCurrency = homeCurrency;
    }

    public Date getLastPwdResetDate() {
        return (Date) (lastPwdResetDate == null ? null : lastPwdResetDate.clone());
    }

    public void setLastPwdResetDate(Date lastPwdResetDate) {
        this.lastPwdResetDate = (Date) (lastPwdResetDate == null ? null : lastPwdResetDate.clone());
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public byte[] getSignatureImage() {
        return signatureImage == null ? null : signatureImage.clone();
    }

    public void setSignatureImage(byte[] signatureImage) {
        this.signatureImage = signatureImage == null ? null : signatureImage.clone();
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getUserConfirm() {
        return userConfirm;
    }

    public void setUserConfirm(String userConfirm) {
        this.userConfirm = userConfirm;
    }

    public String getUserNameWithSalutation() {
        // return this.firstName +" "+this.lastName+"("+this.salutation+")";
        return this.firstName + " " + this.lastName;
    }

    public boolean isHasSignature() {
        if (this.getSignatureImage() == null) {
            return false;
        }
        return true;
    }

    public byte[] getInputSignature() {
        return inputSignature == null ? null : inputSignature.clone();
    }

    public void setInputSignature(byte[] inputSignature) {
        this.inputSignature = inputSignature == null ? null : inputSignature.clone();
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public String getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getOpsAdministrator() {
        return opsAdministrator;
    }

    public void setOpsAdministrator(String opsAdministrator) {
        this.opsAdministrator = opsAdministrator;
    }
}
