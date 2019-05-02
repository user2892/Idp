package com.bectran.b2b.supplier.beans;

import java.io.Serializable;

import com.bectran.b2b.base.beans.UserBaseBean;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.crol.constants.CrolConstants;

/**
 * @author LOUIS IFEGUNI
 * @DATE Aug 19, 2011 : 9:55:56 PM
 */
public class SupplierUserBean extends UserBaseBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String mainContact; // YES or NO
    private String receiveEmail = CrolConstants.YES; // YES or NO
    private Long supplierId;
    private String securityQuestionDetail;
    private String userLevel; // ADMIN or ORDINARY
    private UserGroupBean userGroup;
    private UserSeatBean userSeat;
    private String emailConfirm;
    protected boolean adminUser;
    protected boolean mainContactUser;
    protected boolean activeUser;
    protected boolean inActiveOrDeseated;
    protected boolean showErrorMsg = false;
    private boolean showPleaseLogin = false;
    //
    private String ssoVerificationCode;
    private String ssoVerificationCodeInput;
    private SignOnSecurityBean ssoBean;
    private boolean fromApprovalLogin = false;
    private boolean fromCLRApprovalLogin = false;
    protected boolean userHasSeat;
    protected boolean userSeatIsCourtesy;
    private SignupExtBean extBean;
    // private Set<UserDocReceiptPreferenceBean> docReceiptPreferenceSet;
    // protected List<UserDocReceiptPreferenceBean> docReceiptPreferenceList;
    protected boolean scopeIsAll;
    private String capchaInput = "";
    private String couponCode = "";
    private boolean acctReviewRptPref = false;
    private boolean excludeTaxExempt = false;
    protected boolean cspackUser;
    protected boolean opsAndCsReassignmentRight;
    // private UserDocReceiptPreferenceBean selectedPref;
    //
    // private UserApprovalAuthorityBean approvalAuthority;
    private String deletedUserStatus = MatrixConstants.ANSWER_NO;

    public SupplierUserBean() {
    }

    public String getMainContact() {
        return mainContact;
    }

    public void setMainContact(String mainContact) {
        this.mainContact = mainContact;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSecurityQuestionDetail() {
        return securityQuestionDetail;
    }

    public void setSecurityQuestionDetail(String securityQuestionDetail) {
        this.securityQuestionDetail = securityQuestionDetail;
    }

    public String getReceiveEmail() {
        return receiveEmail;
    }

    public void setReceiveEmail(String receiveEmail) {
        this.receiveEmail = receiveEmail;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getEmailConfirm() {
        return emailConfirm;
    }

    public void setEmailConfirm(String emailConfirm) {
        this.emailConfirm = emailConfirm;
    }

    public UserGroupBean getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupBean userGroup) {
        this.userGroup = userGroup;
    }

    public boolean isAdminUser() {
        if (this.getUserLevel().trim().equals(MatrixConstants.USER_LEVEL_ADMIN)
                && !this.isCspackUser()) {
            return true;
        }
        return false;
    }

    public void setAdminUser(boolean adminUser) {
        this.adminUser = adminUser;
    }

    public boolean isMainContactUser() {
        if (this.getMainContact() == null) {
            return false;
        }
        if (this.getMainContact().trim().equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public void setMainContactUser(boolean mainContactUser) {
        this.mainContactUser = mainContactUser;
    }

    public boolean isActiveUser() {
        if (this.getStatus() == null) {
            return false;
        }
        if (this.getStatus().trim().equals(MatrixConstants.STATUS_ACTIVE)) {
            return true;
        }
        return false;
    }

    public void setActiveUser(boolean activeUser) {
        this.activeUser = activeUser;
    }

    public void setInActiveOrDeseated(boolean inActiveOrDeseated) {
        this.inActiveOrDeseated = inActiveOrDeseated;
    }

    public boolean isShowErrorMsg() {
        return showErrorMsg;
    }

    public void setShowErrorMsg(boolean loginError) {
        this.showErrorMsg = loginError;
    }

    public boolean isShowPleaseLogin() {
        return showPleaseLogin;
    }

    public void setShowPleaseLogin(boolean showPleaseLogin) {
        this.showPleaseLogin = showPleaseLogin;
    }

    public SignupExtBean getExtBean() {
        return extBean;
    }

    public void setExtBean(SignupExtBean extBean) {
        this.extBean = extBean;
    }

    public String getSsoVerificationCode() {
        return ssoVerificationCode;
    }

    public void setSsoVerificationCode(String ssoVerificationCode) {
        this.ssoVerificationCode = ssoVerificationCode;
    }

    public String getSsoVerificationCodeInput() {
        return ssoVerificationCodeInput;
    }

    public void setSsoVerificationCodeInput(String ssoVerificationCodeInput) {
        this.ssoVerificationCodeInput = ssoVerificationCodeInput;
    }

    public SignOnSecurityBean getSsoBean() {
        return ssoBean;
    }

    public void setSsoBean(SignOnSecurityBean ssoBean) {
        this.ssoBean = ssoBean;
    }

    public boolean isFromApprovalLogin() {
        return fromApprovalLogin;
    }

    public void setFromApprovalLogin(boolean fromApprovalLogin) {
        this.fromApprovalLogin = fromApprovalLogin;
    }

    public UserSeatBean getUserSeat() {
        return userSeat;
    }

    public void setUserSeat(UserSeatBean userSeat) {
        this.userSeat = userSeat;
    }

    public boolean isUserHasSeat() {
        if (this.getUserSeat() == null) {
            return false;
        }
        return true;
    }

    public void setUserHasSeat(boolean userHasSeat) {
        this.userHasSeat = userHasSeat;
    }

    public boolean isUserSeatIsCourtesy() {
        if (this.getUserSeat() != null
                && this.getUserSeat().getMySeat().isSeatIsCourtesy()) {
            return true;
        }
        return false;
    }

    public void setUserSeatIsCourtesy(boolean userSeatIsCourtesy) {
        this.userSeatIsCourtesy = userSeatIsCourtesy;
    }

    public String getCapchaInput() {
        return capchaInput;
    }

    public void setCapchaInput(String capchaInput) {
        this.capchaInput = capchaInput;
    }

    public boolean isFromCLRApprovalLogin() {
        return fromCLRApprovalLogin;
    }

    public void setFromCLRApprovalLogin(boolean fromCLRApprovalLogin) {
        this.fromCLRApprovalLogin = fromCLRApprovalLogin;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public boolean isAcctReviewRptPref() {
        return acctReviewRptPref;
    }

    public void setAcctReviewRptPref(boolean acctReviewRptPref) {
        this.acctReviewRptPref = acctReviewRptPref;
    }

    public boolean isExcludeTaxExempt() {
        return excludeTaxExempt;
    }

    public void setExcludeTaxExempt(boolean excludeTaxExempt) {
        this.excludeTaxExempt = excludeTaxExempt;
    }

    public boolean isCspackUser() {
        if (this.getRoleFlag() == null) {
            return false;
        }
        return this.getRoleFlag().trim()
                .equals(MatrixConstants.USER_TYPE_SALES_CUSTPMER_SERVICE) ? true
                        : false;
    }

    public void setCspackUser(boolean cspackUser) {
        this.cspackUser = cspackUser;
    }

    public String getDeletedUserStatus() {
        return deletedUserStatus;
    }

    public void setDeletedUserStatus(String deletedUserStatus) {
        this.deletedUserStatus = deletedUserStatus;
    }
}
