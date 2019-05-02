package com.bectran.b2b.customer.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.bectran.b2b.constants.CustomScoringConstants;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.supplier.beans.AccountOfficerBean;
import com.bectran.matrix.utils.FormatUtility;

/**
 * @author LOUIS IFEGUNI
 */
public class PastCreditAppBean extends CreditRequestBaseBean {
    private Set<AppOtherContactBean> contactSet;
    private Set<AppOfficerBean> officerSet;
    // private Set<CustomScoringUseTrackerBean> bureauUseTracker;
    private AppCustomerContactBean customerContactInfo;
    private String erefAuthorizationForReferee;
    //
    private AccountOfficerBean accountOfficer;
    private AccountOfficerBean acctOfficerMapped;
    //
    private boolean noPersGty;
    private boolean persGtyInProgress;
    //
    //
    private String acctOfficerId;
    private Set<CustomCreditAppValuesBean> customAppValueSet;
    
    //Custom App - Smart Widgets
    private Set<CustomAppAttrValueBean> customAppAttrValueSet;

    //
    private CreditApplicantByRequestBean creditApplicant;
    
    private boolean bureauUseStatus(String productCode) {
        // if(this.getBureauUseTracker()==null ||
        // this.getBureauUseTracker().size()<1){
        // return false;
        /// }
        // for(CustomScoringUseTrackerBean bean : this.getBureauUseTracker()) {
        // if(bean.getProductCode().trim().equals(productCode)){
        // return true;
        // }
        // }
        return false;
    }

    public boolean isCorteraActive() {
        return bureauUseStatus(CustomScoringConstants.PRODUCT_CORTERA_CPR_ID);
    }

    public boolean isExperianBsumActive() {
        return bureauUseStatus(CustomScoringConstants.PRODUCT_EXPERIAN_BSUM_ID);
    }

    public boolean isExperianIntelliscoreActive() {
        return bureauUseStatus(
                CustomScoringConstants.PRODUCT_EXPERIAN_INTELISOCRE_ID);
    }

    public boolean isCsafeActive() {
        return bureauUseStatus(CustomScoringConstants.PRODUCT_CSAFE_ID);
    }

    public boolean isDnbActive() {
        // LEGACY
        // if(this.getBureauCheckFlag().trim().equals(MatrixConstants.ANSWER_YES)){
        // LEGACY
        // return true;
        // }
        return bureauUseStatus(
                CustomScoringConstants.PRODUCT_DNB_DELINQUENCY_SCORE_ID);
    }

    /**
     * DEFAULT CONSTRUCTOR
     */
    public PastCreditAppBean() {
    }

    public String getAppSignatureImage() {
        String imageServletUrl = "<img  src=\"/b2bcredit/SupplierLogServlet?SIG_MENU_ACTION=CREDIT_APP_SIG&refreshimage="
                + new Date();
        imageServletUrl = imageServletUrl + "\"" + " >";
        return imageServletUrl;
    }

    public Set<AppOtherContactBean> getContactSet() {
        return contactSet;
    }

    public void setContactSet(Set<AppOtherContactBean> contactSet) {
        this.contactSet = contactSet;
    }

    public AppCustomerContactBean getCustomerContactInfo() {
        return customerContactInfo;
    }

    public void setCustomerContactInfo(AppCustomerContactBean customerContactInfo) {
        this.customerContactInfo = customerContactInfo;
    }

    public Set<AppOfficerBean> getOfficerSet() {
        return officerSet;
    }

    public void setOfficerSet(Set<AppOfficerBean> officerSet) {
        this.officerSet = officerSet;
    }

    public String getErefAuthorizationForReferee() {
        return erefAuthorizationForReferee;
    }

    public void setErefAuthorizationForReferee(String erefAuthorizationForReferee) {
        this.erefAuthorizationForReferee = erefAuthorizationForReferee;
    }

    public String getRequestDescription() {
        // PastCreditAppBean app = this;
        String customerName = this.getCustomerContactInfo() != null
                ? this.getCustomerContactInfo().getName() : "";
        String descr = this.getAppId() + " - " + customerName + "|"
                + this.getAmount().toBigInteger() + "|"
                + FormatUtility.formatDate(this.getAppDate(),
                        FormatUtility.DATE_FORMAT_MEDIUM)
                + "|" + this.getDaysLateOpen() + " days";
        return descr;
    }

    public AccountOfficerBean getAccountOfficer() {
        return accountOfficer;
    }

    public void setAccountOfficer(AccountOfficerBean accountOfficer) {
        this.accountOfficer = accountOfficer;
    }

    public AccountOfficerBean getAcctOfficerMapped() {
        return acctOfficerMapped;
    }

    public void setAcctOfficerMapped(AccountOfficerBean acctOfficerMapped) {
        this.acctOfficerMapped = acctOfficerMapped;
    }

    public String getAcctOfficerId() {
        return acctOfficerId;
    }

    public void setAcctOfficerId(String acctOfficerId) {
        this.acctOfficerId = acctOfficerId;
    }

    public boolean isNoPersGty() {
        return noPersGty;
    }

    public void setNoPersGty(boolean noPersGty) {
        this.noPersGty = noPersGty;
    }

    public boolean isPersGtyInProgress() {
        return persGtyInProgress;
    }

    public void setPersGtyInProgress(boolean persGtyInProgress) {
        this.persGtyInProgress = persGtyInProgress;
    }

    public boolean isDecisionReached() {
        if (this.getCreditDecision().trim()
                .equals(MatrixConstants.STATUS_DECLINED)
                || this.getCreditDecision().trim()
                        .equals(MatrixConstants.STATUS_APPROVED)
                || this.getCreditDecision().trim()
                        .equals(MatrixConstants.STATUS_CANCELLED)) {
            return true;
        }
        return false;
    }

    public Set<CustomCreditAppValuesBean> getCustomAppValueSet() {
        return customAppValueSet;
    }

    public void setCustomAppValueSet(Set<CustomCreditAppValuesBean> customAppValueSet) {
        this.customAppValueSet = customAppValueSet;
    }

    public List<CustomCreditAppValuesBean> getCustomAppValueList() {
        List<CustomCreditAppValuesBean> ls = new ArrayList<CustomCreditAppValuesBean>();
        for (Iterator<CustomCreditAppValuesBean> i = this.getCustomAppValueSet()
                .iterator(); i.hasNext();) {
            CustomCreditAppValuesBean doc = (CustomCreditAppValuesBean) i
                    .next();
            ls.add(doc);
        }
        return ls;
    }

    /**
     * @return Returns the customAppAttrValueSet.
     */
    public Set<CustomAppAttrValueBean> getCustomAppAttrValueSet() {
        return customAppAttrValueSet;
    }

    /**
     * @param customAppAttrValueSet The customAppAttrValueSet to set.
     */
    public void setCustomAppAttrValueSet(Set<CustomAppAttrValueBean> customAppAttrValueSet) {
        this.customAppAttrValueSet = customAppAttrValueSet;
    }    
    
    public CreditApplicantByRequestBean getCreditApplicant() {
		return creditApplicant;
	}

	public void setCreditApplicant(CreditApplicantByRequestBean creditApplicant) {
		this.creditApplicant = creditApplicant;
	}
}
