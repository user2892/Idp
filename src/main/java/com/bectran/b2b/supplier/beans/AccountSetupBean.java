package com.bectran.b2b.supplier.beans;

import com.bectran.b2b.constants.MatrixConstants;

public class AccountSetupBean {
    private Long id; // same as supplier id.
    private String companyInfoStatus = MatrixConstants.ANSWER_NO;
    private String logoStatus = MatrixConstants.ANSWER_NO;
    private String termStatus = MatrixConstants.ANSWER_NO;
    private String adminPolicyStatus = MatrixConstants.ANSWER_NO;
    //
    private String supportMsg;

    public AccountSetupBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyInfoStatus() {
        return companyInfoStatus;
    }

    public void setCompanyInfoStatus(String companyInfoStatus) {
        this.companyInfoStatus = companyInfoStatus;
    }

    public String getLogoStatus() {
        return logoStatus;
    }

    public void setLogoStatus(String logoStatus) {
        this.logoStatus = logoStatus;
    }

    public String getTermStatus() {
        return termStatus;
    }

    public void setTermStatus(String termStatus) {
        this.termStatus = termStatus;
    }

    public String getAdminPolicyStatus() {
        return adminPolicyStatus;
    }

    public void setAdminPolicyStatus(String adminPolicyStatus) {
        this.adminPolicyStatus = adminPolicyStatus;
    }

    public boolean isCompanyInfoPending() {
        return this.companyInfoStatus.trim().equals(MatrixConstants.ANSWER_NO)
                ? true : false;
    }


    public boolean isLogoPending() {
        return this.logoStatus.trim().equals(MatrixConstants.ANSWER_NO) ? true
                : false;
    }

    public boolean isTermPending() {
        return this.termStatus.trim().equals(MatrixConstants.ANSWER_NO) ? true
                : false;
    }

    public boolean isAdminPolicyPending() {
        return this.adminPolicyStatus.trim().equals(MatrixConstants.ANSWER_NO)
                ? true : false;
    }

    public String getSupportMsg() {
        return supportMsg;
    }

    public void setSupportMsg(String supportMsg) {
        this.supportMsg = supportMsg;
    }
}
