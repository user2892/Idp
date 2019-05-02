package com.bectran.b2b.crol.beans;

import java.util.Date;
import java.util.List;

import com.bectran.b2b.crol.constants.CrolConstants;
import com.bectran.b2b.crol.constants.ResponseConstants;
import com.bectran.b2b.supplier.beans.ManualRefAuditBean;
import com.bectran.matrix.utils.FormatUtility;

/**
 * @author Louis Ifeguni Aug 4, 2006: 5:14:37 PM
 */
public class CreditRefBean {
    //
    private String customerId = "";
    private String referenceType;
    private double crolScore;
    private ScoreExplanation scoreExplanation;
    /**
     * TRADE CREDIT SPECIFIC
     */
    private String stateOfAccount = "";
    private String creditTrend = "";
    private String creditTrendByAmt = "";
    private double lowCreditAmt;
    private double highCreditAmt;
    private double currentExposure;
    private double amtPastDue;
    private String payTermCode = ""; // used in bank credit reference as well
    private String acctAgeCodeTrade = "";// ResponseConstants.UNDER_1YEAR;
    private String sizeCategory = CrolConstants.SMALL_SCALE;
    // checking account
    private String acctAgeCodeChkg = "";// ResponseConstants.UNDER_1YEAR;
    private double avgBalChkg;
    private String returnedItem = "";
    private String satisfactoryChkg = "";
    // loan account
    private String acctAgeCodeLoan = "";// ResponseConstants.UNDER_1YEAR;
    private double highCreditLoan;
    private double highBalanceLoan;
    private String loanSecuredCode = "";
    private String securityDescription = "";
    //
    /**
     * GENERAL
     */
    private Long id;
    protected Long requestID;
    protected String typeOfReference = "";
    // e-mail tracking
    protected String emailSentStatus = "";
    protected int emailSentTrial;
    //
    // protected String refereeUserId = "";
    protected String refereeCorpId = "";
    protected String refComment = "";
    protected String refereeSigned = "";
    protected Date dateOfResponse;
    //
    protected String payPerformanceCode = "";
    //
    private String currency = "USD";
    //
    private String hasChecking = "";
    private String hasLoan = "";
    private String numberOfChkgAcctCode = "";
    private String numberOfLoanAcctCode = "";
    private String stateOfAcctLoan = ResponseConstants.ACTIVE_ACCOUNT; // INITIALIZED
                                                                       // TO
                                                                       // ACTIVE
    private String stateOfAcctChkg = ResponseConstants.ACTIVE_ACCOUNT; // INITIALIZED
                                                                       // TO
    private boolean displayChkgInputs = false;
    private boolean displayLoanInputs = false;
    //
    private String bankRefContentInputVar;
    private int count;
    /*
     * score sheet for credit reference
     */
    private List scoreSheet;
    /* anlytics specific */
    private int numOfReferees;
    private int numOfRefs;
    private Date latestRefDate;
    private BankRefFormBean bankRefBean;
    private TradeRefFormBean tradeRefBean;
    //
    private ManualRefAuditBean manualRefAuditBean;
    //
    private Long creditAppId;
    //
    private boolean updateMode;
    /**
     * DEFAULT CONSTRUCTOR
     */
    private Long refUserId;

    public CreditRefBean() {
    }

    /**
     * @return Returns the amtPastDue.
     */
    public double getAmtPastDue() {
        return amtPastDue;
    }

    /**
     * @param amtPastDue
     *            The amtPastDue to set.
     */
    public void setAmtPastDue(double amtPastDue) {
        this.amtPastDue = amtPastDue;
    }

    /**
     * @return Returns the creditTrend.
     */
    public String getCreditTrend() {
        return creditTrend;
    }

    /**
     * @param creditTrend
     *            The creditTrend to set.
     */
    public void setCreditTrend(String creditTrend) {
        this.creditTrend = creditTrend;
    }

    /**
     * @return Returns the creditTrendByAmt.
     */
    public String getCreditTrendByAmt() {
        return creditTrendByAmt;
    }

    /**
     * @param creditTrendByAmt
     *            The creditTrendByAmt to set.
     */
    public void setCreditTrendByAmt(String creditTrendByAmt) {
        this.creditTrendByAmt = creditTrendByAmt;
    }

    /**
     * @return Returns the creditTrendByAmtLabel.
     */
    public String getCreditTrendByAmtLabel() {
        return (String) ResponseConstants.trendByAmount()
                .get(this.creditTrendByAmt);
    }

    /**
     * @return Returns the creditTrendLabel.
     */
    public String getCreditTrendLabel() {
        return (String) ResponseConstants.trend().get(this.creditTrend);
    }

    /**
     * @return Returns the currentExposure.
     */
    public double getCurrentExposure() {
        return currentExposure;
    }

    /**
     * @param currentExposure
     *            The currentExposure to set.
     */
    public void setCurrentExposure(double currentExposure) {
        this.currentExposure = currentExposure;
    }

    /**
     * @return Returns the highCreditAmt.
     */
    public double getHighCreditAmt() {
        return highCreditAmt;
    }

    /**
     * @param highCreditAmt
     *            The highCreditAmt to set.
     */
    public void setHighCreditAmt(double highCreditAmt) {
        this.highCreditAmt = highCreditAmt;
    }

    /**
     * @return Returns the lowCreditAmt.
     */
    public double getLowCreditAmt() {
        return lowCreditAmt;
    }

    /**
     * @param lowCreditAmt
     *            The lowCreditAmt to set.
     */
    public void setLowCreditAmt(double lowCreditAmt) {
        this.lowCreditAmt = lowCreditAmt;
    }

    /**
     * @return Returns the payTermCode.
     */
    public String getPayTermCode() {
        return payTermCode;
    }

    /**
     * @param payTermCode
     *            The payTermCode to set.
     */
    public void setPayTermCode(String payTermCode) {
        this.payTermCode = payTermCode;
    }

    /**
     * @return Returns the payTermLabel.
     */
    public String getPayTermLabel() {
        return (String) ResponseConstants.paymentTerms().get(this.payTermCode);
    }

    /**
     * @return Returns the stateOfAccount.
     */
    public String getStateOfAccount() {
        return stateOfAccount;
    }

    /**
     * @param stateOfAccount
     *            The stateOfAccount to set.
     */
    public void setStateOfAccount(String stateOfAccount) {
        this.stateOfAccount = stateOfAccount;
    }

    /**
     * @return Returns the stateOfAccountLabel.
     */
    public String getStateOfAccountLabel() {
        return (String) ResponseConstants.acctState().get(this.stateOfAccount);
    }

    /**
     * @return Returns the acctAgeCodeChkg.
     */
    public String getAcctAgeCodeChkg() {
        return acctAgeCodeChkg;
    }

    /**
     * @param acctAgeCodeChkg
     *            The acctAgeCodeChkg to set.
     */
    public void setAcctAgeCodeChkg(String acctAgeCodeChkg) {
        this.acctAgeCodeChkg = acctAgeCodeChkg;
    }

    /**
     * @return Returns the acctAgeCodeLoan.
     */
    public String getAcctAgeCodeLoan() {
        return acctAgeCodeLoan;
    }

    /**
     * @param acctAgeCodeLoan
     *            The acctAgeCodeLoan to set.
     */
    public void setAcctAgeCodeLoan(String acctAgeCodeLoan) {
        this.acctAgeCodeLoan = acctAgeCodeLoan;
    }

    /**
     * @return Returns the avgBalChkg.
     */
    public double getAvgBalChkg() {
        return avgBalChkg;
    }

    /**
     * @param avgBalChkg
     *            The avgBalChkg to set.
     */
    public void setAvgBalChkg(double avgBalChkg) {
        this.avgBalChkg = avgBalChkg;
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
     * @return Returns the highBalanceLoan.
     */
    public double getHighBalanceLoan() {
        return highBalanceLoan;
    }

    /**
     * @param highBalanceLoan
     *            The highBalanceLoan to set.
     */
    public void setHighBalanceLoan(double highBalanceLoan) {
        this.highBalanceLoan = highBalanceLoan;
    }

    /**
     * @return Returns the highCreditLoan.
     */
    public double getHighCreditLoan() {
        return highCreditLoan;
    }

    /**
     * @param highCreditLoan
     *            The highCreditLoan to set.
     */
    public void setHighCreditLoan(double highCreditLoan) {
        this.highCreditLoan = highCreditLoan;
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
     * @return Returns the loanSecuredCode.
     */
    public String getLoanSecuredCode() {
        return loanSecuredCode;
    }

    /**
     * @param loanSecuredCode
     *            The loanSecuredCode to set.
     */
    public void setLoanSecuredCode(String loanSecuredCode) {
        this.loanSecuredCode = loanSecuredCode;
    }

    /**
     * @return Returns the payPerformanceCode.
     */
    public String getPayPerformanceCode() {
        return payPerformanceCode;
    }

    /**
     * @param payPerformanceCode
     *            The payPerformanceCode to set.
     */
    public void setPayPerformanceCode(String payPerformanceCode) {
        this.payPerformanceCode = payPerformanceCode;
    }

    /**
     * @return Returns the payPerformanceLabel.
     */
    public String getPayPerformanceLabel() {
        return (String) ResponseConstants.payPerformance()
                .get(this.payPerformanceCode);
    }

    /**
     * @return Returns the refComment.
     */
    public String getRefComment() {
        return refComment;
    }

    /**
     * @param refComment
     *            The refComment to set.
     */
    public void setRefComment(String refComment) {
        this.refComment = refComment;
    }

    /**
     * @return Returns the refereeCorpId.
     */
    public String getRefereeCorpId() {
        return refereeCorpId;
    }

    /**
     * @param refereeCorpId
     *            The refereeCorpId to set.
     */
    public void setRefereeCorpId(String refereeCorpId) {
        this.refereeCorpId = refereeCorpId;
    }

    /**
     * @return Returns the refereeSigned.
     */
    public String getRefereeSigned() {
        return refereeSigned;
    }

    /**
     * @param refereeSigned
     *            The refereeSigned to set.
     */
    public void setRefereeSigned(String refereeSigned) {
        this.refereeSigned = refereeSigned;
    }

    /**
     * @return Returns the requestID.
     */
    public Long getRequestID() {
        return requestID;
    }

    /**
     * @param requestID
     *            The requestID to set.
     */
    public void setRequestID(Long requestID) {
        this.requestID = requestID;
    }

    /**
     * @return Returns the returnedItem.
     */
    public String getReturnedItem() {
        return returnedItem;
    }

    /**
     * @param returnedItem
     *            The returnedItem to set.
     */
    public void setReturnedItem(String returnedItem) {
        this.returnedItem = returnedItem;
    }

    /**
     * @return Returns the satisfactoryChkg.
     */
    public String getSatisfactoryChkg() {
        return satisfactoryChkg;
    }

    /**
     * @param satisfactoryChkg
     *            The satisfactoryChkg to set.
     */
    public void setSatisfactoryChkg(String satisfactoryChkg) {
        this.satisfactoryChkg = satisfactoryChkg;
    }

    /**
     * @return Returns the securityDescription.
     */
    public String getSecurityDescription() {
        return securityDescription;
    }

    /**
     * @param securityDescription
     *            The securityDescription to set.
     */
    public void setSecurityDescription(String securityDescription) {
        this.securityDescription = securityDescription;
    }

    /**
     * @return Returns the typeOfReference.
     */
    public String getTypeOfReference() {
        return typeOfReference;
    }

    /**
     * @param typeOfReference
     *            The typeOfReference to set.
     */
    public void setTypeOfReference(String typeOfReference) {
        this.typeOfReference = typeOfReference;
    }

    /**
     * @return Returns the acctAgeCodeChkgLabel.
     */
    public String getAcctAgeCodeChkgLabel() {
        return (String) ResponseConstants.accountsOpened()
                .get(this.acctAgeCodeChkg);
    }

    
    /**
     * @return Returns the acctAgeCodeLoanLabel.
     */
    public String getAcctAgeCodeLoanLabel() {
        return (String) ResponseConstants.accountsOpened()
                .get(this.acctAgeCodeLoan);
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
     * @return Returns the hasChecking.
     */
    public String getHasChecking() {
        return hasChecking;
    }

    /**
     * @param hasChecking
     *            The hasChecking to set.
     */
    public void setHasChecking(String hasChecking) {
        this.hasChecking = hasChecking;
    }

    /**
     * @return Returns the hasLoan.
     */
    public String getHasLoan() {
        return hasLoan;
    }

    /**
     * @param hasLoan
     *            The hasLoan to set.
     */
    public void setHasLoan(String hasLoan) {
        this.hasLoan = hasLoan;
    }

    /**
     * @return Returns the numberOfChkgAcctCode.
     */
    public String getNumberOfChkgAcctCode() {
        return numberOfChkgAcctCode;
    }

    /**
     * @param numberOfChkgAcctCode
     *            The numberOfChkgAcctCode to set.
     */
    public void setNumberOfChkgAcctCode(String numberOfChkgAcctCode) {
        this.numberOfChkgAcctCode = numberOfChkgAcctCode;
    }

    /**
     * @return Returns the numberOfLoanAcctCode.
     */
    public String getNumberOfLoanAcctCode() {
        return numberOfLoanAcctCode;
    }

    /**
     * @param numberOfLoanAcctCode
     *            The numberOfLoanAcctCode to set.
     */
    public void setNumberOfLoanAcctCode(String numberOfLoanAcctCode) {
        this.numberOfLoanAcctCode = numberOfLoanAcctCode;
    }

    /**
     * @return Returns the stateOfAcctChkg.
     */
    public String getStateOfAcctChkg() {
        return stateOfAcctChkg;
    }

    /**
     * @param stateOfAcctChkg
     *            The stateOfAcctChkg to set.
     */
    public void setStateOfAcctChkg(String stateOfAcctChkg) {
        this.stateOfAcctChkg = stateOfAcctChkg;
    }

    /**
     * @return Returns the stateOfAcctLoan.
     */
    public String getStateOfAcctLoan() {
        return stateOfAcctLoan;
    }

    /**
     * @param stateOfAcctLoan
     *            The stateOfAcctLoan to set.
     */
    public void setStateOfAcctLoan(String stateOfAcctLoan) {
        this.stateOfAcctLoan = stateOfAcctLoan;
    }

    /**
     * @return Returns the displayChkgInputs.
     */
    public boolean isDisplayChkgInputs() {
        return displayChkgInputs;
    }

    /**
     * @param displayChkgInputs
     *            The displayChkgInputs to set.
     */
    public void setDisplayChkgInputs(boolean displayChkgInputs) {
        this.displayChkgInputs = displayChkgInputs;
    }

    /**
     * @return Returns the displayLoanInputs.
     */
    public boolean isDisplayLoanInputs() {
        return displayLoanInputs;
    }

    /**
     * @param displayLoanInputs
     *            The displayLoanInputs to set.
     */
    public void setDisplayLoanInputs(boolean displayLoanInputs) {
        this.displayLoanInputs = displayLoanInputs;
    }

    /**
     * @return Returns the acctAgeCodeTrade.
     */
    public String getAcctAgeCodeTrade() {
        return acctAgeCodeTrade;
    }

    /**
     * @param acctAgeCodeTrade
     *            The acctAgeCodeTrade to set.
     */
    public void setAcctAgeCodeTrade(String acctAgeCodeTrade) {
        this.acctAgeCodeTrade = acctAgeCodeTrade;
    }

    /**
     * @return Returns the acctAgeCodeTradeLabel.
     */
    public String getAcctAgeCodeTradeLabel() {
        return (String) ResponseConstants.accountsOpened()
                .get(this.acctAgeCodeTrade);
    }

    /**
     * @return Returns the numberOfChkgAcctLabel.
     */
    public String getNumberOfChkgAcctLabel() {
        return (String) ResponseConstants.numberOfAccountMap()
                .get(this.numberOfChkgAcctCode);
    }

    /**
     * @return Returns the numberOfLoanAcctLabel.
     */
    public String getNumberOfLoanAcctLabel() {
        return (String) ResponseConstants.numberOfAccountMap()
                .get(this.numberOfLoanAcctCode);
    }

    /**
     * @return Returns the stateOfAcctChkgLabel.
     */
    public String getStateOfAcctChkgLabel() {
        return (String) ResponseConstants.acctState().get(this.stateOfAcctChkg);
    }

    /**
     * @return Returns the stateOfAcctLoanLabel.
     */
    public String getStateOfAcctLoanLabel() {
        return (String) ResponseConstants.acctState().get(this.stateOfAcctLoan);
    }

    /**
     * @return Returns the customerId.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId
     *            The customerId to set.
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
     * @return Returns the sizeCategory.
     */
    public String getSizeCategory() {
        return sizeCategory;
    }

    /**
     * @param sizeCategory
     *            The sizeCategory to set.
     */
    public void setSizeCategory(String sizeCategory) {
        this.sizeCategory = sizeCategory;
    }

    /**
     * @return Returns the crolScore.
     */
    public double getCrolScore() {
        return crolScore;
    }

    /**
     * @param crolScore
     *            The crolScore to set.
     */
    public void setCrolScore(double crolScore) {
        this.crolScore = crolScore;
    }

    /**
     * @return Returns the scoreSheet.
     */
    public List getScoreSheet() {
        return scoreSheet;
    }

    /**
     * @param scoreSheet
     *            The scoreSheet to set.
     */
    public void setScoreSheet(List scoreSheet) {
        this.scoreSheet = scoreSheet;
    }

    /**
     * @return Returns the scoreExplanation.
     */
    public ScoreExplanation getScoreExplanation() {
        return scoreExplanation;
    }

    /**
     * @param scoreExplanation
     *            The scoreExplanation to set.
     */
    public void setScoreExplanation(ScoreExplanation scoreExplanation) {
        this.scoreExplanation = scoreExplanation;
    }

    /**
     * @return Returns the count.
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count
     *            The count to set.
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return Returns the latestRefDate.
     */
    public Date getLatestRefDate() {
        return (Date) (latestRefDate == null ? null : latestRefDate.clone());
    }

    /**
     * @param latestRefDate
     *            The latestRefDate to set.
     */
    public void setLatestRefDate(Date latestRefDate) {
        this.latestRefDate = (Date) (latestRefDate == null ? null : latestRefDate.clone());
    }

    /**
     * @return Returns the numOfReferees.
     */
    public int getNumOfReferees() {
        return numOfReferees;
    }

    /**
     * @param numOfReferees
     *            The numOfReferees to set.
     */
    public void setNumOfReferees(int numOfReferees) {
        this.numOfReferees = numOfReferees;
    }

    /**
     * @return Returns the numOfRefs.
     */
    public int getNumOfRefs() {
        return numOfRefs;
    }

    /**
     * @param numOfRefs
     *            The numOfRefs to set.
     */
    public void setNumOfRefs(int numOfRefs) {
        this.numOfRefs = numOfRefs;
    }

    public String getBankRefContentInputVar() {
        return bankRefContentInputVar;
    }

    public void setBankRefContentInputVar(String bankRefContentInputVar) {
        this.bankRefContentInputVar = bankRefContentInputVar;
    }

    public BankRefFormBean getBankRefBean() {
        return bankRefBean;
    }

    public void setBankRefBean(BankRefFormBean bankRefBean) {
        this.bankRefBean = bankRefBean;
    }

    public boolean isTradeReference() {
        if (this.getReferenceType().trim()
                .equals(CrolConstants.REFERENCE_TYPE_TRADE)) {
            return true;
        }
        return false;
    }

    public TradeRefFormBean getTradeRefBean() {
        return tradeRefBean;
    }

    public void setTradeRefBean(TradeRefFormBean tradeRefBean) {
        this.tradeRefBean = tradeRefBean;
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

    public ManualRefAuditBean getManualRefAuditBean() {
        return manualRefAuditBean;
    }

    public void setManualRefAuditBean(ManualRefAuditBean manualRefAuditBean) {
        this.manualRefAuditBean = manualRefAuditBean;
    }

    public boolean isManualRefType() {
        if (this.getManualRefAuditBean() != null) {
            return true;
        }
        return false;
    }

    public String getFormattedDateOfRef() {
        return FormatUtility.formatDate(this.getDateOfResponse(),
                FormatUtility.DATE_FORMAT_MEDIUM);
    }


    /**
     * @return the updateMode
     */
    public boolean isUpdateMode() {
        return updateMode;
    }

    /**
     * @param updateMode
     *            the updateMode to set
     */
    public void setUpdateMode(boolean updateMode) {
        this.updateMode = updateMode;
    }
}
