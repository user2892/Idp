package com.bectran.b2b.enterprise.beans;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.customer.beans.CustomerBean;
import com.bectran.b2b.supplier.beans.SupplierUserBean;

/**
 * @author LOUIS IFEGUNI
 */
public class CrApprovalBean {
    private Long id;
    private Long supplierId;
    private Long requestId;
    private String appId;
    private String rating;
    private BigDecimal approvedLimit;
    private Date approvalDate;
    private String termCodeId = "";
    private String termCode = "";
    private String termDescription;
    private String acctNumId;
    private String acctNum;
    private String bectranAcctNum;
    private String customerName;
    private String transmittedFlag = MatrixConstants.ANSWER_NO; // changed to
                                                                // yes once
                                                                // transmitted
    // private double approvalLimit;
    private String analystComment;
    private String userId;
    private String status;
    private Date setupDate;
    private String requestDescription;
    private int numApprovingOfficer;
    private String riskRating;
    private String riskRatingClass;
    private String trxnBatchControlToken;
    private CustomerBean customer;
    private SupplierUserBean analyst;
    private Set<ApprovingOfficerBean> officerSet;
    private CreditRequestSummaryBean creditRequestSummary;

    public CrApprovalBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public BigDecimal getApprovedLimit() {
        return approvedLimit;
    }

    public void setApprovedLimit(BigDecimal approvedLimit) {
        this.approvedLimit = approvedLimit;
    }

    public Date getApprovalDate() {
        return (Date) (approvalDate == null ? null : approvalDate.clone());
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = (Date) (approvalDate == null ? null : approvalDate.clone());
    }

    public String getTermCode() {
        return termCode;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public String getTermDescription() {
        return termDescription;
    }

    public void setTermDescription(String termDescription) {
        this.termDescription = termDescription;
    }

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTransmittedFlag() {
        return transmittedFlag;
    }

    public void setTransmittedFlag(String transmittedFlag) {
        this.transmittedFlag = transmittedFlag;
    }

    public String getAcctNumId() {
        return acctNumId;
    }

    public void setAcctNumId(String acctNumId) {
        this.acctNumId = acctNumId;
    }

    public String getTermCodeId() {
        return termCodeId;
    }

    public void setTermCodeId(String termCodeId) {
        this.termCodeId = termCodeId;
    }
    // public Set<ApprovingOfficerBean> getOfficerSet() {
    // return officerSet;
    // }
    // public void setOfficerSet(Set<ApprovingOfficerBean> officerSet) {
    // this.officerSet = officerSet;
    // }

    public String getAnalystComment() {
        return analystComment;
    }

    public void setAnalystComment(String analystComment) {
        this.analystComment = analystComment;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBectranAcctNum() {
        return bectranAcctNum;
    }

    public void setBectranAcctNum(String bectranAcctNum) {
        this.bectranAcctNum = bectranAcctNum;
    }
    // public SupplierUserBean getOfficer() {
    // return officer;
    // }

    // public void setOfficer(SupplierUserBean officer) {
    // this.officer = officer;
    // }
    public Date getSetupDate() {
        return (Date) (setupDate == null ? null : setupDate.clone());
    }

    public void setSetupDate(Date setupDate) {
        this.setupDate = (Date) (setupDate == null ? null : setupDate.clone());
    }

    public int getNumApprovingOfficer() {
        return numApprovingOfficer;
    }

    public void setNumApprovingOfficer(int numApprovingOfficer) {
        this.numApprovingOfficer = numApprovingOfficer;
    }

    public String getTrxnBatchControlToken() {
        return trxnBatchControlToken;
    }

    public void setTrxnBatchControlToken(String trxnBatchControlToken) {
        this.trxnBatchControlToken = trxnBatchControlToken;
    }

    public CustomerBean getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBean customer) {
        this.customer = customer;
    }

    /**
     * @return the analyst
     */
    public SupplierUserBean getAnalyst() {
        return analyst;
    }

    /**
     * @param analyst
     *            the analyst to set
     */
    public void setAnalyst(SupplierUserBean analyst) {
        this.analyst = analyst;
    }

    /**
     * @return the officerSet
     */
    public Set<ApprovingOfficerBean> getOfficerSet() {
        return officerSet;
    }

    /**
     * @param officerSet
     *            the officerSet to set
     */
    public void setOfficerSet(Set<ApprovingOfficerBean> officerSet) {
        this.officerSet = officerSet;
    }

    /**
     * @return the riskRating
     */
    public String getRiskRating() {
        return riskRating;
    }

    /**
     * @param riskRating
     *            the riskRating to set
     */
    public void setRiskRating(String riskRating) {
        this.riskRating = riskRating;
    }

    /**
     * @return the riskRatingClass
     */
    public String getRiskRatingClass() {
        return riskRatingClass;
    }

    /**
     * @param riskRatingClass
     *            the riskRatingClass to set
     */
    public void setRiskRatingClass(String riskRatingClass) {
        this.riskRatingClass = riskRatingClass;
    }

    public CreditRequestSummaryBean getCreditRequestSummary() {
        return creditRequestSummary;
    }

    public void setCreditRequestSummary(CreditRequestSummaryBean creditRequestSummary) {
        this.creditRequestSummary = creditRequestSummary;
    }
}
