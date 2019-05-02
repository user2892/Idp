/**
 * 
 */
package com.bectran.sftp.xml.inbound;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @author LOUIS IFEGUNI
 * @date Aug 9, 2012 : 10:13:49 PM
 */
@XmlType(propOrder = {"amountRequested", "analystName", "approvalDate",
        "approvedLimit", "approvigOfficerName", "bectranCustomerId",
        "clientAccountId", "creditTerm", "creditTermCode", "customerName",
        "riskRating", "riskRatingClass", "transactionId", "creditDecision",
        "groupName", "internalGroupCode", "bectranReferenceId", "nextReviewDate"})
public class CustomApprovedCreditXMLBean {
    private BigDecimal amountRequested;
    private String accountId;
    private String transactionId;
    private String riskRating;
    private BigDecimal approvedLimit;
    private String approvalDate;
    private String creditTerm;
    private String creditTermCode;
    private String clientAccountId;
    private String bectranCustomerId;
    private String customerName;
    private String approvigOfficerName;
    private String analystName;
    private String riskRatingClass;
    private String creditDecision;
    //
    private String internalGroupCode;
    private String groupName;
    private String bectranReferenceId;
    //
    private String nextReviewDate;
    //
    /**
     * @return the transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId
     *            the transactionId to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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
     * @return the approvalDate
     */
    public String getApprovalDate() {
        return approvalDate;
    }

    /**
     * @param approvalDate
     *            the approvalDate to set
     */
    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    /**
     * @return the creditTerm
     */
    public String getCreditTerm() {
        return creditTerm;
    }

    /**
     * @param creditTerm
     *            the creditTerm to set
     */
    public void setCreditTerm(String creditTerm) {
        this.creditTerm = creditTerm;
    }

    /**
     * @return the clientAccountId
     */
    public String getClientAccountId() {
        return clientAccountId;
    }

    /**
     * @param clientAccountId
     *            the clientAccountId to set
     */
    public void setClientAccountId(String clientAccountId) {
        this.clientAccountId = clientAccountId;
    }

    /**
     * @return the bectranCustomerId
     */
    public String getBectranCustomerId() {
        return bectranCustomerId;
    }

    /**
     * @param bectranCustomerId
     *            the bectranCustomerId to set
     */
    public void setBectranCustomerId(String bectranCustomerId) {
        this.bectranCustomerId = bectranCustomerId;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName
     *            the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the approvigOfficerName
     */
    public String getApprovigOfficerName() {
        return approvigOfficerName;
    }

    /**
     * @param approvigOfficerName
     *            the approvigOfficerName to set
     */
    public void setApprovigOfficerName(String approvigOfficerName) {
        this.approvigOfficerName = approvigOfficerName;
    }

    /**
     * @return the analystName
     */
    public String getAnalystName() {
        return analystName;
    }

    /**
     * @param analystName
     *            the analystName to set
     */
    public void setAnalystName(String analystName) {
        this.analystName = analystName;
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

    /**
     * @return the approvedLimit
     */
    public BigDecimal getApprovedLimit() {
        return approvedLimit;
    }

    /**
     * @param approvedLimit
     *            the approvedLimit to set
     */
    public void setApprovedLimit(BigDecimal approvedLimit) {
        this.approvedLimit = approvedLimit;
    }

    /**
     * @return the creditDecision
     */
    public String getCreditDecision() {
        return creditDecision;
    }

    /**
     * @param creditDecision
     *            the creditDecision to set
     */
    public void setCreditDecision(String creditDecision) {
        this.creditDecision = creditDecision;
    }

    /**
     * @return the accountId
     */
    @XmlAttribute(name = "account-id")
    public String getAccountId() {
        return accountId;
    }

    /**
     * @param accountId
     *            the accountId to set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmountRequested() {
        return amountRequested;
    }

    public void setAmountRequested(BigDecimal amountRequested) {
        this.amountRequested = amountRequested;
    }

    public String getInternalGroupCode() {
        return internalGroupCode;
    }

    public void setInternalGroupCode(String internalGroupCode) {
        this.internalGroupCode = internalGroupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getBectranReferenceId() {
        return bectranReferenceId;
    }

    public void setBectranReferenceId(String bectranReferenceId) {
        this.bectranReferenceId = bectranReferenceId;
    }

    public String getCreditTermCode() {
        return creditTermCode;
    }

    public void setCreditTermCode(String creditTermCode) {
        this.creditTermCode = creditTermCode;
    }
    
    public String getNextReviewDate() {
        return nextReviewDate;
    }
    public void setNextReviewDate(String nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
    }
}
