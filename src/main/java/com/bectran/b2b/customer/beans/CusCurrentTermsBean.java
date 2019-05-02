/**
 * 
 */
package com.bectran.b2b.customer.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LOUIS IFEGUNI
 *
 * @DATE Aug 18, 2011 : 7:54:25 AM
 */
public class CusCurrentTermsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	//
	private Long id;//same as customer supplierID
	private double approvedLimit;
	private Date approvalDate = new Date();
	private String termCode;
	private String termDescription;	
	private String acctNum;
    private Long supplierId;
    private String approvalMode; 
    private Long appBasedRefId;
    private String appBasedRefLabel; //same as credit application ID.
    private Long requestId;
    private Long reviewId;
    private Date nextReviewDate = new Date();
    private Date lastReviewDate = new Date();
    //
    private Long noAppModeRefId;
    private String noAppModeRefLabel; //ID for no app.
    //
    private String internalAcctNum="";
	private String riskRating;
	private String riskRatingClass;
    
    public CusCurrentTermsBean(){}

	public double getApprovedLimit() {
		return approvedLimit;
	}

	public void setApprovedLimit(double approvedLimit) {
		this.approvedLimit = approvedLimit;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
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

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getApprovalMode() {
		return approvalMode;
	}

	public void setApprovalMode(String approvalMode) {
		this.approvalMode = approvalMode;
	}

	public Long getAppBasedRefId() {
		return appBasedRefId;
	}

	public void setAppBasedRefId(Long appBasedRefId) {
		this.appBasedRefId = appBasedRefId;
	}

	public String getAppBasedRefLabel() {
		return appBasedRefLabel;
	}

	public void setAppBasedRefLabel(String appBasedRefLabel) {
		this.appBasedRefLabel = appBasedRefLabel;
	}

	public Long getNoAppModeRefId() {
		return noAppModeRefId;
	}

	public void setNoAppModeRefId(Long noAppModeRefId) {
		this.noAppModeRefId = noAppModeRefId;
	}

	public String getNoAppModeRefLabel() {
		return noAppModeRefLabel;
	}

	public void setNoAppModeRefLabel(String noAppModeRefLabel) {
		this.noAppModeRefLabel = noAppModeRefLabel;
	}

	public String getInternalAcctNum() {
		return internalAcctNum;
	}

	public void setInternalAcctNum(String internalAcctNum) {
		this.internalAcctNum = internalAcctNum;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getRiskRating() {
		return riskRating;
	}

	public void setRiskRating(String riskRating) {
		this.riskRating = riskRating;
	}

	public String getRiskRatingClass() {
		return riskRatingClass;
	}

	public void setRiskRatingClass(String riskRatingClass) {
		this.riskRatingClass = riskRatingClass;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public Date getNextReviewDate() {
		return nextReviewDate;
	}

	public void setNextReviewDate(Date nextReviewDate) {
		this.nextReviewDate = nextReviewDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLastReviewDate() {
		return lastReviewDate;
	}

	public void setLastReviewDate(Date lastReviewDate) {
		this.lastReviewDate = lastReviewDate;
	}
    
    

}
