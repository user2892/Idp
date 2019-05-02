package com.bectran.b2b.customer.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bectran.b2b.base.beans.CustomerBaseBean;
import com.bectran.b2b.constants.CustomCreditAppConstant;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.crol.constants.CrolConstants;
import com.bectran.matrix.utils.DateUtility;

/**
 * @author LOUIS IFEGUNI
 */
public class CreditRequestBaseBean extends CustomerBaseBean {
    //
    public static final String REQUEST_ID_PREFIX = "REQ0";
    public static final String REVIEW_ID_PREFIX = "REV0";
    public static final String PAPER_APP_ID_PREFIX = "REQP0";
    public static final String DEFAULT_DAYS_TO_PRCESS_APP = "5";
    //
    public static final String APPLICANT_STATUS_NEW = "NEW";
    public static final String APPLICANT_STATUS_EXISTING_RENEWAL = "RENEWAL";
    public static final String APPLICANT_STATUS_EXISTING_INCREASE = "INCREASE";
    //
    public static final Comparator DESCENDING_ORDER_APPLICATION_DATE = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRequestBaseBean r1 = (CreditRequestBaseBean) o1;
            CreditRequestBaseBean r2 = (CreditRequestBaseBean) o2;
            return r2.getAppDate().compareTo(r1.getAppDate());
        }
    };
    public static final Comparator ASCENDING_ORDER_APPLICATION_DATE = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRequestBaseBean r1 = (CreditRequestBaseBean) o1;
            CreditRequestBaseBean r2 = (CreditRequestBaseBean) o2;
            return r1.getAppDate().compareTo(r2.getAppDate());
        }
    };
    //
    public static final Comparator DESCENDING_ORDER_APPROVAL_DATE = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRequestBaseBean r1 = (CreditRequestBaseBean) o1;
            CreditRequestBaseBean r2 = (CreditRequestBaseBean) o2;
            return r2.getApprovalDate().compareTo(r1.getApprovalDate());
        }
    };
    public static final Comparator ASCENDING_ORDER_APPROVAL_DATE = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRequestBaseBean r1 = (CreditRequestBaseBean) o1;
            CreditRequestBaseBean r2 = (CreditRequestBaseBean) o2;
            return r1.getApprovalDate().compareTo(r2.getApprovalDate());
        }
    };
    public static final Comparator ASCENDING_ORDER_YEAR = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRequestBaseBean r1 = (CreditRequestBaseBean) o1;
            CreditRequestBaseBean r2 = (CreditRequestBaseBean) o2;
            return r1.getYear().compareTo(r2.getYear());
        }
    };
    public static final Comparator DESCENDING_ORDER_DAYS_OLD = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRequestBaseBean r1 = (CreditRequestBaseBean) o1;
            CreditRequestBaseBean r2 = (CreditRequestBaseBean) o2;
            return new Double(r2.getDaysOld())
                    .compareTo(new Double(r1.getDaysOld()));
        }
    };
    public static final Comparator DESCENDING_ORDER_YEAR = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRequestBaseBean r1 = (CreditRequestBaseBean) o1;
            CreditRequestBaseBean r2 = (CreditRequestBaseBean) o2;
            return r2.getYear().compareTo(r1.getYear());
        }
    };
    private Long id;
    /*
     * hibernate variables
     */
    private Set<RefForRequestBean> refForRequestSET;
    //
    private String creditDecision = MatrixConstants.ANSWER_NO;
    private String acctNum = "";
    private String customerName = "";
    private double daysOld;
    private String processId = "";
    private String reasonCode = "";
    private String adjRequestNote = "";
    // DUNS NUMBER - STANDS FOR D&B Universal Identification number for
    // corporations
    private String dunsNum = "";
    //
    private String signatureName = "";
    private String signatureFlag = "";
    //
    private Long customerSupplierId; // customer-supplier ID
    //
    private String facId = "";
    private String facName = "";
    private String termName = "";
    private Date appDate;
    private String portId = "";
    private String portName = "";
    private String portIdDisplay = "";
    private String assignedPortId = "";
    private BigDecimal amount;
    private String status = "";
    private String requestor = "";
    private String appId = "";
    private String message = "";
    protected long termId;
    private String daysToProcessApp = "";
    private String requiredDocuments = "";
    private String riskMgrsForDisp;
    private List facilitySEL;
    private List termsSEL;
    private String manualApprovalId;
    private String cancelRequestReason;
    // PROCESS ANALYSTICS SPECIFIC
    private double daysToClose;
    private String daysToCloseDisp;
    private double totalDaysToClose;
    private int totalApps;
    private double avgDaysToClose;
    private String avgDaysToCloseDisp;
    private String year;
    private String month;
    private String monthDescription = "";
    private List portfolioResult;
    private String daysInterval = "";
    //
    private String dateCreatedDisplay = "";
    private String amountDisplay = "";
    private String lastUpdateDisplay;
    private String daysInPhase = ""; // used for analytics
    private String dateInPhase = ""; // used for analytics - date entered into
                                     // phase
    private int repaymentPeriod;
    // house keeping
    private double percentTotal;
    private String percentTotalDisp = "";
    private String totalAppsDisp;
    // BEFORE VALUES
    private String facIdBefore = "";
    private String amountBefore = "";
    private boolean noEmail = false;
    //
    private boolean updateDunsNbr = false;
    // private Timestamp dateCreated;
    private Date approvalDate;
    private double approvedAmount;
    private Date lastUpdate;
    private Date dateClosed;
    private String excludeOrderPendingFlag = MatrixConstants.ANSWER_NO;
    private String excludeCreditTermFlag = MatrixConstants.ANSWER_NO;
    private String addPurchaseOrderRqmntFlag = MatrixConstants.ANSWER_NO;
    //
    private boolean documentRequired = false;
    // request document list
    // private List reqDocumentList = null;
    private List contactPersons;
    // RISK MANAGERS
    List riskMgrs = null;
    // CREDIT FACILITIES
    List facilities;
    // existing customer facilities
    // private List custCreditStdg;
    // pay terms
    private List payterms;
    private String reasonForApp = "";
    private String refCallCompleteFlag = "";
    private boolean closedStatus = false;
    private boolean appIsAdj = false;
    private boolean partOfMgrPortfolio;
    private boolean noEmailMessage;
    private String refCallStatus = MatrixConstants.REFERENCE_CALL_STATUS_NOT_CALLED;
    private String creditTerm = "";
    private String creditTermDetail;
    private String orderPending = MatrixConstants.ANSWER_NO;// YES or NO
    private double orderAmount;
    private String acctNumWithUs;
    private String plannedMonthlyPurchase;
    private String applicantTitle;
    private byte[] signatureImage; // signature
    private String agreedToTerm = MatrixConstants.ANSWER_YES;
    private String supplier;
    private Long supplierId;
    private Long groupId;
    private String appAuthorization;
    private String termsAndCondition;
    private String erefAuthorization;
    private String companySizeCategory;
    private String acctWithUs = CrolConstants.NO; // ANSWER 'YES' or 'NO'
    private String creditRequestTypeCode = MatrixConstants.REQUEST_NEW_CREDIT;
    /*
     * APP UTILIZATION COUNT FOR SUBSCRIPTION TRACKING
     */
    private int subscriptionCount;
    /*
     * documents flags : personal guaranty - docPersGtyFlag corporate guanranty
     * - docCorpGtyFlag financial statements - docFsFlag
     */
    private String docPersGtyFlag = MatrixConstants.ANSWER_NO;
    private String docCorpGtyFlag = MatrixConstants.ANSWER_NO;
    private String docFsFlag = MatrixConstants.ANSWER_NO;
    private String docTaxCertFlag = MatrixConstants.ANSWER_NO;
    private String docEvmFlag = MatrixConstants.ANSWER_NO;
    private String docClrQuestFlag = MatrixConstants.ANSWER_NO;
    private String docPaperAppFlag = MatrixConstants.ANSWER_NO;
    private String multipleShipAndBill = MatrixConstants.ANSWER_NO;
    private String multipleLocationRequest = MatrixConstants.ANSWER_NO;
    // HIBERNATE DATA SETS
    private Set<CrDocControlBean> reqDocumentSet;
     //
    private String fsRequired = MatrixConstants.ANSWER_NO;
    // ADDED 12-11-2011 - LOUIS
    private String subscriptionCover = MatrixConstants.ANSWER_NO; // indicates
                                                                  // if app is
                                                                  // covered by
                                                                  // subscription
    // CS PACK VARIABLES
    private String requestControlCode; // USER-ID+SUPPLIER-ID+CUSTOMER-CODE
    // ADDED: 10/30/2011 - LOUIS
    private String bureauCheckFlag = MatrixConstants.ANSWER_NO;
    private String hasTaxExempt = MatrixConstants.ANSWER_NO;
    private String reviewType = MatrixConstants.ANSWER_NO;
    private String sigPresent = MatrixConstants.ANSWER_NO;
    private String archiveFlag = MatrixConstants.ANSWER_NO;
    private String noRefCallFlag = MatrixConstants.ANSWER_NO;
    private String industryGroupFlag = MatrixConstants.ANSWER_NO;
    private String selectiveRefCall = MatrixConstants.ANSWER_NO;
    //
    private String companyConfigType = MatrixConstants.COMPANY_CONFIG_TYPE_TRADE;
    //
    private String applicantIsGuarantor = MatrixConstants.ANSWER_NO;
    private boolean otherGuarantorAdded;
    //
    // private LeaseEquipmentBean leaseEquipment;
    // private LeaseEquipmentVendorBean leaseEquipmentVendor;
    //
    private String paperCreditAppType = MatrixConstants.ANSWER_NO;
    private String enhanchedPaperCreditAppType = MatrixConstants.ANSWER_NO;
    //
    private String salesRepUserId = MatrixConstants.ANSWER_NO;
    private String poRequired = MatrixConstants.ANSWER_NO;
    private String assignedToQueue = MatrixConstants.ANSWER_NO;
    // private CrMgrWorkAssignmentBean assignmentBean;
    //
    // private String formType = CustomCreditAppConstant.FORM_TYPE_CREDIT_APP;
    private String excludeShippingFromApp = MatrixConstants.ANSWER_NO;
    //
    private String transmittedFlag = MatrixConstants.ANSWER_NO;
    private String trxnBatchControlToken;
    private String transactionCcy;
    //
    private String formType = CustomCreditAppConstant.FORM_TYPE_CREDIT_APP;
    private String discardAppFlag = MatrixConstants.ANSWER_NO;
    private String appProcStatus=MatrixConstants.STATUS_SUCCESS;
    //
    private String getCreditRequestReason(String reasonCode) {
        Map<String, String> mp = new HashMap<String, String>(7);
        mp.put(MatrixConstants.CREDIT_REQUEST_ADJUSTMENT,
                "Adjustment of terms (on existing facility)");
        mp.put(MatrixConstants.CREDIT_REQUEST_CREDITLIMIT_INCREASE,
                "Credit Limit increase (on existing facility)");
        mp.put(MatrixConstants.CREDIT_REQUEST_NEW,
                "New Request (on new credit facility)");
        mp.put(MatrixConstants.CREDIT_REQUEST_ACCT_REVIEW,
                "Account/Facility credit review");
        return (String) mp.get(reasonCode);
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

    /*
     * "Application amount < current credit limit - Application Rejected !"
     */
    /**
     * @return
     */
    public String getAcctNum() {
        return acctNum;
    }

    /**
     * @return
     */
    public String getDunsNum() {
        return dunsNum;
    }

    /**
     * @return
     */
    public String getFacId() {
        return facId;
    }

    /**
     * @param string
     */
    public void setAcctNum(String string) {
        acctNum = string;
    }

    /**
     * @return
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param string
     */
    public void setAmount(BigDecimal string) {
        amount = string;
    }

    /**
     * @param string
     */
    public void setDunsNum(String string) {
        dunsNum = string;
    }

    /**
     * @param string
     */
    public void setFacId(String string) {
        facId = string;
    }

    /**
     * @param string
     */
    public void setStatus(String string) {
        status = string;
    }

    /**
     * @return
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @return
     */
    public Date getApprovalDate() {
        return (Date) (approvalDate == null ? null : approvalDate.clone());
    }

    /**
     * @return
     */
    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    /**
     * @param string
     */
    public void setAppId(String string) {
        appId = string;
    }

    /**
     * @param approvalDate
     */
    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = (Date) (approvalDate == null ? null : approvalDate.clone());
    }

    /**
     * @param lastUpdate
     */
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    /**
     * @return
     */
    public String getRequestor() {
        return requestor;
    }

    /**
     * @param string
     */
    public void setRequestor(String string) {
        requestor = string;
    }

    /**
     * @return
     */
    public List getFacilities() {
        return facilities;
    }

    /**
     * @param list
     */
    public void setFacilities(List list) {
        facilities = list;
    }

    /**
     * @return
     */
    public boolean isUpdateDunsNbr() {
        return updateDunsNbr;
    }

    /**
     * @param b
     */
    public void setUpdateDunsNbr(boolean b) {
        updateDunsNbr = b;
    }

    /**
     * @return
     */
    public double getApprovedAmount() {
        return approvedAmount;
    }

    /**
     * @param d
     */
    public void setApprovedAmount(double d) {
        approvedAmount = d;
    }

    /**
     * @return
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * @param string
     */
    public void setProcessId(String string) {
        processId = string;
    }

    /**
     * @return
     */
    public String getAssignedPortId() {
        return assignedPortId;
    }

    /**
     * @param string
     */
    public void setAssignedPortId(String string) {
        assignedPortId = string;
    }

    /**
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param string
     */
    public void setMessage(String string) {
        message = string;
    }

    /**
     * @return
     */
    public List getRiskMgrs() {
        return riskMgrs;
    }

    /**
     * @param set
     */
    public void setRiskMgrs(List set) {
        riskMgrs = set;
    }

    /**
     * @return
     */
    public boolean isDocumentRequired() {
        return documentRequired;
    }

    /**
     * @param b
     */
    public void setDocumentRequired(boolean b) {
        documentRequired = b;
    }

    /**
     * @return
     */
    public boolean isNoEmail() {
        return noEmail;
    }

    /**
     * @param b
     */
    public void setNoEmail(boolean b) {
        noEmail = b;
    }

    /**
     * @return
     */
    public String getDateCreatedDisplay() {
        return dateCreatedDisplay;
    }

    /**
     * @param string
     */
    public void setDateCreatedDisplay(String string) {
        dateCreatedDisplay = string;
    }

    /**
     * @return
     */
    public String getAmountDisplay() {
        return amountDisplay;
    }

    /**
     * @param string
     */
    public void setAmountDisplay(String string) {
        amountDisplay = string;
    }

    /**
     * @return
     */
    public String getAmountBefore() {
        return amountBefore;
    }

    /**
     * @return
     */
    public String getFacIdBefore() {
        return facIdBefore;
    }

    /**
     * @param string
     */
    public void setAmountBefore(String string) {
        amountBefore = string;
    }

    /**
     * @param string
     */
    public void setFacIdBefore(String string) {
        facIdBefore = string;
    }

    /**
     * @return
     */
    public String getPortId() {
        return portId;
    }

    /**
     * @param string
     */
    public void setPortId(String string) {
        portId = string;
    }

    /**
     * @return
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param string
     */
    public void setCustomerName(String string) {
        customerName = string;
    }

    /**
     * @return
     */
    public String getPortIdDisplay() {
        return portIdDisplay;
    }

    /**
     * @param string
     */
    public void setPortIdDisplay(String string) {
        portIdDisplay = string;
    }

    /**
     * @return
     */
    public String getDaysInterval() {
        return daysInterval;
    }

    /**
     * @param string
     */
    public void setDaysInterval(String string) {
        daysInterval = string;
    }

    /**
     * @return
     */
    public String getLastUpdateDisplay() {
        return lastUpdateDisplay;
    }

    /**
     * @param string
     */
    public void setLastUpdateDisplay(String string) {
        lastUpdateDisplay = string;
    }

    /**
     * @return
     */
    public String getDaysInPhase() {
        return daysInPhase;
    }

    /**
     * @param string
     */
    public void setDaysInPhase(String string) {
        daysInPhase = string;
    }

    /**
     * @return
     */
    public String getDateInPhase() {
        return dateInPhase;
    }

    /**
     * @param string
     */
    public void setDateInPhase(String string) {
        dateInPhase = string;
    }

    /**
     * @return
     */
    public double getDaysToClose() {
        return daysToClose;
    }

    /**
     * @param d
     */
    public void setDaysToClose(double d) {
        daysToClose = d;
    }

    /**
     * @return
     */
    public String getDaysToCloseDisp() {
        return daysToCloseDisp;
    }

    /**
     * @param string
     */
    public void setDaysToCloseDisp(String string) {
        daysToCloseDisp = string;
    }

    /**
     * @return
     */
    public double getAvgDaysToClose() {
        return avgDaysToClose;
    }

    /**
     * @return
     */
    public String getAvgDaysToCloseDisp() {
        return avgDaysToCloseDisp;
    }

    /**
     * @param d
     */
    public void setAvgDaysToClose(double d) {
        avgDaysToClose = d;
    }

    /**
     * @param string
     */
    public void setAvgDaysToCloseDisp(String string) {
        avgDaysToCloseDisp = string;
    }

    /**
     * @return
     */
    public double getTotalDaysToClose() {
        return totalDaysToClose;
    }

    /**
     * @param d
     */
    public void setTotalDaysToClose(double d) {
        totalDaysToClose = d;
    }

    /**
     * @return
     */
    public double getTotalApps() {
        return totalApps;
    }

    /**
     * @param d
     */
    public void setTotalApps(int d) {
        totalApps = d;
    }

    /**
     * @return
     */
    public String getMonth() {
        return month;
    }

    /**
     * @return
     */
    public String getYear() {
        return year;
    }

    /**
     * @param string
     */
    public void setMonth(String string) {
        month = string;
    }

    /**
     * @param string
     */
    public void setYear(String string) {
        year = string;
    }

    /**
     * @return
     */
    public List getPortfolioResult() {
        return portfolioResult;
    }

    /**
     * @param list
     */
    public void setPortfolioResult(List list) {
        portfolioResult = list;
    }

    /**
     * @return
     */
    public String getMonthDescription() {
        return monthDescription;
    }

    /**
     * @param string
     */
    public void setMonthDescription(String string) {
        monthDescription = string;
    }

    /**
     * @return
     */
    public double getPercentTotal() {
        return percentTotal;
    }

    /**
     * @return
     */
    public String getPercentTotalDisp() {
        return percentTotalDisp;
    }

    /**
     * @return
     */
    public String getTotalAppsDisp() {
        return totalAppsDisp;
    }

    /**
     * @param d
     */
    public void setPercentTotal(double d) {
        percentTotal = d;
    }

    /**
     * @param string
     */
    public void setPercentTotalDisp(String string) {
        percentTotalDisp = string;
    }

    /**
     * @param string
     */
    public void setTotalAppsDisp(String string) {
        totalAppsDisp = string;
    }

    /**
     * @return
     */
    public List getPayterms() {
        return payterms;
    }

    /**
     * @param list
     */
    public void setPayterms(List list) {
        payterms = list;
    }

    /**
     * @return
     */
    public long getTermId() {
        return termId;
    }

    /**
     * @param string
     */
    public void setTermId(long string) {
        termId = string;
    }

    /**
     * @return
     */
    public String getDaysToProcessApp() {
        return daysToProcessApp;
    }

    /**
     * @param string
     */
    public void setDaysToProcessApp(String string) {
        daysToProcessApp = string;
    }

    /**
     * @return Returns the applicantStatus.
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * @param applicantStatus
     *            The applicantStatus to set.
     */
    public void setReasonCode(String applicantStatus) {
        this.reasonCode = applicantStatus;
    }

    /**
     * @return Returns the facilitySEL.
     */
    public List getFacilitySEL() {
        return facilitySEL;
    }

    /**
     * @param facilitySEL
     *            The facilitySEL to set.
     */
    public void setFacilitySEL(List facilitySEL) {
        this.facilitySEL = facilitySEL;
    }

    /**
     * @return Returns the termsSEL.
     */
    public List getTermsSEL() {
        return termsSEL;
    }

    /**
     * @param termsSEL
     *            The termsSEL to set.
     */
    public void setTermsSEL(List termsSEL) {
        this.termsSEL = termsSEL;
    }

    /**
     * @return Returns the reasonForApp.
     */
    public String getReasonForApp() {
        /*
         * if(this.reasonCode.trim().equals("NEW")){ return "New facility"; }
         * if(this.reasonCode.trim().equals("RENEWAL")){ return
         * "Facility renewal"; } if(this.reasonCode.trim().equals("INCREASE")){
         * return "Credit Limit increase"; }
         */
        reasonForApp = getCreditRequestReason(this.reasonCode);
        return reasonForApp;
    }

    /**
     * @param reasonForApp
     *            The reasonForApp to set.
     */
    public void setReasonForApp(String reasonForApp) {
        this.reasonForApp = reasonForApp;
    }

    /**
     * @return Returns the facName.
     */
    public String getFacName() {
        return facName;
    }

    /**
     * @param facName
     *            The facName to set.
     */
    public void setFacName(String facName) {
        this.facName = facName;
    }

    /**
     * @return Returns the termName.
     */
    public String getTermName() {
        return termName;
    }

    /**
     * @param termName
     *            The termName to set.
     */
    public void setTermName(String termName) {
        this.termName = termName;
    }

    /**
     * @return Returns the refForRequestSET.
     */
    public Set<RefForRequestBean> getRefForRequestSET() {
        return refForRequestSET;
    }

    /**
     * @param refForRequestSET
     *            The refForRequestSET to set.
     */
    public void setRefForRequestSET(Set<RefForRequestBean> refForRequestSET) {
        this.refForRequestSET = refForRequestSET;
    }

    /**
     * @return Returns the requiredDocuments.
     */
    public String getRequiredDocuments() {
        return requiredDocuments;
    }

    /**
     * @param requiredDocuments
     *            The requiredDocuments to set.
     */
    public void setRequiredDocuments(String requiredDocuments) {
        this.requiredDocuments = requiredDocuments;
    }

    /**
     * @return Returns the riskMgrsForDisp.
     */
    public String getRiskMgrsForDisp() {
        return riskMgrsForDisp;
    }

    /**
     * @param riskMgrsForDisp
     *            The riskMgrsForDisp to set.
     */
    public void setRiskMgrsForDisp(String riskMgrsForDisp) {
        this.riskMgrsForDisp = riskMgrsForDisp;
    }

    /**
     * @return Returns the appDate.
     */
    public Date getAppDate() {
        return (Date) (appDate == null ? null : appDate.clone());
    }

    /**
     * @param appDate
     *            The appDate to set.
     */
    public void setAppDate(Date appDate) {
        this.appDate = (Date) (appDate == null ? null : appDate.clone());
    }

    /**
     * @return Returns the portName.
     */
    public String getPortName() {
        return portName;
    }

    /**
     * @param portName
     *            The portName to set.
     */
    public void setPortName(String portName) {
        this.portName = portName;
    }

    /**
     * @return Returns the daysOld.
     */
    public double getDaysOld() {
        return daysOld;
    }

    /**
     * @param daysOld
     *            The daysOld to set.
     */
    public void setDaysOld(double daysOld) {
        this.daysOld = daysOld;
    }

    /**
     * @return Returns the refCallCompleteFlag.
     */
    public String getRefCallCompleteFlag() {
        return refCallCompleteFlag;
    }

    /**
     * @param refCallCompleteFlag
     *            The refCallCompleteFlag to set.
     */
    public void setRefCallCompleteFlag(String refCallCompleteFlag) {
        this.refCallCompleteFlag = refCallCompleteFlag;
    }

    /**
     * @return Returns the signatureFlag.
     */
    public String getSignatureFlag() {
        return signatureFlag;
    }

    /**
     * @param signatureFlag
     *            The signatureFlag to set.
     */
    public void setSignatureFlag(String signatureFlag) {
        this.signatureFlag = signatureFlag;
    }

    /**
     * @return Returns the signatureName.
     */
    public String getSignatureName() {
        return signatureName;
    }

    /**
     * @param signatureName
     *            The signatureName to set.
     */
    public void setSignatureName(String signatureName) {
        this.signatureName = signatureName;
    }

    /**
     * @return Returns the closedStatus.
     */
    public boolean isClosedStatus() {
        if (this.status.trim().equals(MatrixConstants.STATUS_CLOSED)) {
            return true;
        }
        closedStatus = false;
        return closedStatus;
    }

    /**
     * @param closedStatus
     *            The closedStatus to set.
     */
    public void setClosedStatus(boolean closedStatus) {
        this.closedStatus = closedStatus;
    }

    public String getAdjRequestNote() {
        return adjRequestNote;
    }

    public void setAdjRequestNote(String adjRequestNote) {
        this.adjRequestNote = adjRequestNote;
    }

    public boolean isAppIsAdj() {
        if (this.reasonCode.trim()
                .equals(MatrixConstants.CREDIT_REQUEST_ADJUSTMENT)) {
            appIsAdj = true;
        }
        else {
            appIsAdj = false;
        }
        return appIsAdj;
    }

    public void setAppIsAdj(boolean appIsAdj) {
        this.appIsAdj = appIsAdj;
    }

    public String getManualApprovalId() {
        return manualApprovalId;
    }

    public void setManualApprovalId(String manualApprovalId) {
        this.manualApprovalId = manualApprovalId;
    }

    public boolean isPartOfMgrPortfolio() {
        return partOfMgrPortfolio;
    }

    public void setPartOfMgrPortfolio(boolean partOfMgrPortfolio) {
        this.partOfMgrPortfolio = partOfMgrPortfolio;
    }

    public String getCancelRequestReason() {
        return cancelRequestReason;
    }

    public void setCancelRequestReason(String cancelRequestReason) {
        this.cancelRequestReason = cancelRequestReason;
    }

    public boolean isAcctReviewAction() {
        if (this.reasonCode.trim()
                .equals(MatrixConstants.CREDIT_REQUEST_ACCT_REVIEW)) {
            return true;
        }
        return false;
    }

    public int getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setRepaymentPeriod(int repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    public boolean isNoEmailMessage() {
        return noEmailMessage;
    }

    public void setNoEmailMessage(boolean noEmailMessage) {
        this.noEmailMessage = noEmailMessage;
    }

    public List getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(List contactPersons) {
        this.contactPersons = contactPersons;
    }

    public Long getCustomerSupplierId() {
        return customerSupplierId;
    }

    public void setCustomerSupplierId(Long supplierId) {
        this.customerSupplierId = supplierId;
    }

    public String getRefCallStatus() {
        return refCallStatus;
    }

    public void setRefCallStatus(String refCallStatus) {
        this.refCallStatus = refCallStatus;
    }

    public String getAcctNumWithUs() {
        return acctNumWithUs;
    }

    public void setAcctNumWithUs(String acctNumWithUs) {
        this.acctNumWithUs = acctNumWithUs;
    }

    public String getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(String creditTerm) {
        this.creditTerm = creditTerm;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderPending() {
        return orderPending;
    }

    public void setOrderPending(String orderPending) {
        this.orderPending = orderPending;
    }

    public String getPlannedMonthlyPurchase() {
        return plannedMonthlyPurchase;
    }

    public void setPlannedMonthlyPurchase(String plannedMonthlyPurchase) {
        this.plannedMonthlyPurchase = plannedMonthlyPurchase;
    }

    public String getAgreedToTerm() {
        return agreedToTerm;
    }

    public void setAgreedToTerm(String agreedToTerm) {
        this.agreedToTerm = agreedToTerm;
    }

    public String getApplicantTitle() {
        return applicantTitle;
    }

    public void setApplicantTitle(String applicantTitle) {
        this.applicantTitle = applicantTitle;
    }

    public byte[] getSignatureImage() {
        return signatureImage == null ? null : signatureImage.clone();
    }

    public void setSignatureImage(byte[] signatureImage) {
        this.signatureImage = signatureImage == null ? null : signatureImage.clone();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getAppAuthorization() {
        return appAuthorization;
    }

    public void setAppAuthorization(String appAuthorization) {
        this.appAuthorization = appAuthorization;
    }

    public String getTermsAndCondition() {
        return termsAndCondition;
    }

    public void setTermsAndCondition(String termsAndCondition) {
        this.termsAndCondition = termsAndCondition;
    }

    public String getErefAuthorization() {
        return erefAuthorization;
    }

    public void setErefAuthorization(String erefAuthorization) {
        this.erefAuthorization = erefAuthorization;
    }

    public String getCompanySizeCategory() {
        return companySizeCategory;
    }

    public void setCompanySizeCategory(String companySizeCategory) {
        this.companySizeCategory = companySizeCategory;
    }

    public int getDaysLateOpen() {
        if (this.getAppDate() == null) {
            return 0;
        }
        int late = DateUtility.computeDays(this.getAppDate(), new Date());
        if (late < 0) {
            late = 0;
        }
        return late;
    }

    public int getDaysLateClosed() {
        if (this.getAppDate() == null) {
            return 0;
        }
        int late = DateUtility.computeDays(this.getAppDate(),
                this.getLastUpdate());
        if (late < 0) {
            late = 0;
        }
        return late;
    }

    public int getSubscriptionCount() {
        return subscriptionCount;
    }

    public void setSubscriptionCount(int subscriptionCount) {
        this.subscriptionCount = subscriptionCount;
    }

    public String getAcctWithUs() {
        return acctWithUs;
    }

    public void setAcctWithUs(String acctWithUs) {
        this.acctWithUs = acctWithUs;
    }

    public boolean isHasAcctWithUs() {
        if (this.getAcctWithUs().trim().equals(CrolConstants.YES)) {
            return true;
        }
        return false;
    }

    public String getCreditRequestTypeCode() {
        return creditRequestTypeCode;
    }

    public void setCreditRequestTypeCode(String creditRequestTypeCode) {
        this.creditRequestTypeCode = creditRequestTypeCode;
    }

    public String getCreditRequestTypeDescr() {
        if (this.getCreditRequestTypeCode().trim()
                .equals(MatrixConstants.REQUEST_NEW_CREDIT)) {
            return "New Credit";
        }
        return "Credit Limit Increase";
    }

    public boolean isHasPersonalGty() {
        if (this.getDocPersGtyFlag().trim()
                .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public boolean isHasFs() {
        if (this.getDocFsFlag().trim().equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public boolean isHasEvm() {
        if (this.getDocEvmFlag() == null) {
            return false;
        }
        if (this.getDocEvmFlag().trim().equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public String getDocCorpGtyFlag() {
        return docCorpGtyFlag;
    }

    public void setDocCorpGtyFlag(String docCorpGtyFlag) {
        this.docCorpGtyFlag = docCorpGtyFlag;
    }

    public String getDocFsFlag() {
        return docFsFlag;
    }

    public void setDocFsFlag(String docFsFlag) {
        this.docFsFlag = docFsFlag;
    }

    public String getDocPersGtyFlag() {
        return docPersGtyFlag;
    }

    public void setDocPersGtyFlag(String docPersGtyFlag) {
        this.docPersGtyFlag = docPersGtyFlag;
    }

    public String getDocTaxCertFlag() {
        return docTaxCertFlag;
    }

    public void setDocTaxCertFlag(String docTaxCertFlag) {
        this.docTaxCertFlag = docTaxCertFlag;
    }

    public Set<CrDocControlBean> getReqDocumentSet() {
        return reqDocumentSet;
    }

    public void setReqDocumentSet(Set<CrDocControlBean> reqDocumentSet) {
        this.reqDocumentSet = reqDocumentSet;
    }

    public List<CrDocControlBean> getReqDocumentList() {
        List<CrDocControlBean> ls = new ArrayList<CrDocControlBean>();
        for (Iterator<CrDocControlBean> i = this.getReqDocumentSet()
                .iterator(); i.hasNext();) {
            CrDocControlBean doc = (CrDocControlBean) i.next();
            ls.add(doc);
        }
        // Collections.sort(ls, CrDocControlBean.ASCENDING_ORDER);
        return ls;
    }

    public String getFsRequired() {
        return fsRequired;
    }

    public void setFsRequired(String fsRequired) {
        this.fsRequired = fsRequired;
    }

    public boolean isDocCorpGtyBool() {
        if (this.getDocCorpGtyFlag().trim()
                .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public boolean isDocFsFlagBool() {
        if (this.getDocFsFlag().trim().equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }


    public boolean isDocPersGtyBool() {
        if (this.getDocPersGtyFlag().trim()
                .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public boolean isDocTaxCertFlagBool() {
        if (this.getDocTaxCertFlag().trim()
                .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public boolean isHasPaperApp() {
        if (this.getDocPaperAppFlag() == null) {
            return false;
        }
        if (this.getDocPaperAppFlag().trim()
                .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public String getCreditDecision() {
        return creditDecision;
    }

    public void setCreditDecision(String creditDecision) {
        this.creditDecision = creditDecision;
    }

    public boolean isApproved() {
        if (this.getCreditDecision() == null) {
            return false;
        }
        return this.getCreditDecision().trim()
                .equals(MatrixConstants.STATUS_APPROVED) ? true : false;
    }

    public boolean isDeclined() {
        if (this.getCreditDecision() == null) {
            return false;
        }
        return this.getCreditDecision().trim()
                .equals(MatrixConstants.STATUS_DECLINED) ? true : false;
    }

    public boolean isCancelled() {
        if (this.getCreditDecision() == null) {
            return false;
        }
        return this.getCreditDecision().trim()
                .equals(MatrixConstants.STATUS_CANCELLED) ? true : false;
    }

    public boolean isDeclinedOrCancelled() {
        if (this.isDeclined() || this.isCancelled()) {
            return true;
        }
        return false;
    }

    public boolean isDecisionInProgress() {
        if (this.getCreditDecision() == null
                || this.getCreditDecision().trim().length() < 2) {
            return false;
        }
        if (this.getCreditDecision().trim()
                .equals(MatrixConstants.STATUS_INPROGRESS)) {
            return true;
        }
        return false;
    }

    public boolean isNoDecision() {
        if (this.getCreditDecision() == null
                || this.getCreditDecision().trim().length() < 2
                || this.getCreditDecision().trim()
                        .equals(MatrixConstants.ANSWER_NO)) {
            return true;
        }
        if (this.getCreditDecision().trim()
                .equals(MatrixConstants.STATUS_INPROGRESS)) {
            return true;
        }
        return false;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public boolean isSetupApproval() {
        if (this.getCreditDecision() == null
                || this.getCreditDecision().trim().length() < 2) {
            return true;
        }
        if (this.getCreditDecision().trim()
                .equals(MatrixConstants.STATUS_DECLINED)
                || this.getCreditDecision().trim()
                        .equals(MatrixConstants.STATUS_APPROVED)
                || this.getCreditDecision().trim()
                        .equals(MatrixConstants.STATUS_CANCELLED)
                || this.getCreditDecision().trim()
                        .equals(MatrixConstants.STATUS_INPROGRESS)) {
            return false;
        }
        return true;
    }

    public String getCreditTermDetail() {
        return creditTermDetail;
    }

    public void setCreditTermDetail(String creditTermDetail) {
        this.creditTermDetail = creditTermDetail;
    }

    public String getSubscriptionCover() {
        return subscriptionCover;
    }

    public void setSubscriptionCover(String subscriptionCover) {
        this.subscriptionCover = subscriptionCover;
    }

    public boolean isHasSubscriptionCover() {
        return this.getSubscriptionCover().trim()
                .equals(MatrixConstants.ANSWER_YES) ? true : false;
    }

    public String getRequestControlCode() {
        return requestControlCode;
    }

    public void setRequestControlCode(String requestControlCode) {
        this.requestControlCode = requestControlCode;
    }

    public String getBureauCheckFlag() {
        return bureauCheckFlag;
    }

    public void setBureauCheckFlag(String bureauCheckFlag) {
        this.bureauCheckFlag = bureauCheckFlag;
    }

    public String getHasTaxExempt() {
        return hasTaxExempt;
    }

    public void setHasTaxExempt(String hasTaxExempt) {
        this.hasTaxExempt = hasTaxExempt;
    }

    public boolean isShowExemptWin() {
        if (this.getHasTaxExempt().trim().equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public boolean isHasOrderPending() {
        if (this.getOrderPending().trim().equals(CrolConstants.YES)) {
            return true;
        }
        return false;
    }

    public boolean isStatusInProgress() {
        return this.getStatus().trim().equals(MatrixConstants.STATUS_INPROGRESS)
                ? true : false;
    }

    public String getReviewType() {
        return reviewType;
    }

    public void setReviewType(String reviewType) {
        this.reviewType = reviewType;
    }

    public boolean isRequestIsReviewType() {
        return this.getReviewType().trim().equals(MatrixConstants.ANSWER_YES)
                ? true : false;
    }


    public String getSigPresent() {
        return sigPresent;
    }

    public void setSigPresent(String sigPresent) {
        this.sigPresent = sigPresent;
    }

    public boolean isHasBureauData() {
        return this.getBureauCheckFlag().trim()
                .equals(MatrixConstants.ANSWER_YES) ? true : false;
    }

    public String getArchiveFlag() {
        return archiveFlag;
    }

    public void setArchiveFlag(String archiveFlag) {
        this.archiveFlag = archiveFlag;
    }

    public String getNoRefCallFlag() {
        return noRefCallFlag;
    }

    public void setNoRefCallFlag(String noRefCallFlag) {
        this.noRefCallFlag = noRefCallFlag;
    }

    public boolean isRefCallNotRequired() {
        return this.getNoRefCallFlag().trim().equals(MatrixConstants.ANSWER_YES)
                ? true : false;
    }

    public String getDocEvmFlag() {
        return docEvmFlag;
    }

    public void setDocEvmFlag(String docEvmFlag) {
        this.docEvmFlag = docEvmFlag;
    }

    public Date getDateClosed() {
        return (Date) (dateClosed == null ? null : dateClosed.clone());
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = (Date) (dateClosed == null ? null : dateClosed.clone());
    }

    public String getIndustryGroupFlag() {
        return industryGroupFlag;
    }

    public void setIndustryGroupFlag(String industryGroupFlag) {
        this.industryGroupFlag = industryGroupFlag;
    }

    public boolean isHasClrQuest() {
        if (this.getDocClrQuestFlag() == null) {
            return false;
        }
        if (this.getDocClrQuestFlag().trim()
                .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public String getDocClrQuestFlag() {
        return docClrQuestFlag;
    }

    public void setDocClrQuestFlag(String docClrQuestFlag) {
        this.docClrQuestFlag = docClrQuestFlag;
    }

    public String getSelectiveRefCall() {
        return selectiveRefCall;
    }

    public void setSelectiveRefCall(String selectiveRefCall) {
        this.selectiveRefCall = selectiveRefCall;
    }

    public boolean isSelectiveRefCallActive() {
        return this.getSelectiveRefCall().trim()
                .equals(MatrixConstants.ANSWER_YES) ? true : false;
    }

    public String getCompanyConfigType() {
        return companyConfigType;
    }

    public void setCompanyConfigType(String companyConfigType) {
        this.companyConfigType = companyConfigType;
    }

    public boolean isLeaseCompanyConfig() {
        if (this.companyConfigType == null) {
            return false;
        }
        return this.companyConfigType.trim().equals(
                MatrixConstants.COMPANY_CONFIG_TYPE_LEASING) ? true : false;
    }

    public String getApplicantIsGuarantor() {
        return applicantIsGuarantor;
    }

    public void setApplicantIsGuarantor(String applicantIsGuarantor) {
        this.applicantIsGuarantor = applicantIsGuarantor;
    }

    public boolean isOtherGuarantorAdded() {
        return otherGuarantorAdded;
    }

    public void setOtherGuarantorAdded(boolean otherGuarantorAdded) {
        this.otherGuarantorAdded = otherGuarantorAdded;
    }

    public String getPaperCreditAppType() {
        return paperCreditAppType;
    }

    public void setPaperCreditAppType(String paperCreditAppType) {
        this.paperCreditAppType = paperCreditAppType;
    }

    public boolean isPaperCreditApp() {
        if (this.getPaperCreditAppType() == null) {
            return false;
        }
        return this.getPaperCreditAppType().trim()
                .equals(MatrixConstants.ANSWER_YES) ? true : false;
    }

    public String getDocPaperAppFlag() {
        return docPaperAppFlag;
    }

    public void setDocPaperAppFlag(String docPaperAppFlag) {
        this.docPaperAppFlag = docPaperAppFlag;
    }

    public String getSalesRepUserId() {
        return salesRepUserId;
    }

    public void setSalesRepUserId(String salesRepUserId) {
        this.salesRepUserId = salesRepUserId;
    }

    public String getExcludeOrderPendingFlag() {
        return excludeOrderPendingFlag;
    }

    public void setExcludeOrderPendingFlag(String excludeOrderPendingFlag) {
        this.excludeOrderPendingFlag = excludeOrderPendingFlag;
    }

    public boolean isShowOrderPending() {
        if (this.getExcludeOrderPendingFlag() == null) {
            return true;
        }
        return this.getExcludeOrderPendingFlag().trim()
                .equals(MatrixConstants.ANSWER_YES) ? false : true;
    }

    public String getExcludeCreditTermFlag() {
        return excludeCreditTermFlag;
    }

    public void setExcludeCreditTermFlag(String excludeCreditTermFlag) {
        this.excludeCreditTermFlag = excludeCreditTermFlag;
    }

    public boolean isShowCreditTerm() {
        if (this.getExcludeCreditTermFlag() == null) {
            return true;
        }
        return this.getExcludeCreditTermFlag().trim()
                .equals(MatrixConstants.ANSWER_YES) ? false : true;
    }

    public String getPoRequired() {
        return poRequired;
    }

    public void setPoRequired(String poRequired) {
        this.poRequired = poRequired;
    }

    public String getAddPurchaseOrderRqmntFlag() {
        return addPurchaseOrderRqmntFlag;
    }

    public void setAddPurchaseOrderRqmntFlag(String excludePurchaseOrderRqmntFlag) {
        this.addPurchaseOrderRqmntFlag = excludePurchaseOrderRqmntFlag;
    }

    public boolean isShowPurchaseOrderRqmntEntry() {
        if (this.getAddPurchaseOrderRqmntFlag() == null) {
            return false;
        }
        return this.getAddPurchaseOrderRqmntFlag().trim()
                .equals(MatrixConstants.ANSWER_YES) ? true : false;
    }

    public String getAssignedToQueue() {
        return assignedToQueue;
    }

    public void setAssignedToQueue(String assignedToQueue) {
        this.assignedToQueue = assignedToQueue;
    }

    public boolean isAssignedToQueueActive() {
        if (this.getAssignedToQueue() != null && this.getAssignedToQueue()
                .trim().equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public String getMultipleShipAndBill() {
        return multipleShipAndBill;
    }

    public void setMultipleShipAndBill(String multipleShipAndBill) {
        this.multipleShipAndBill = multipleShipAndBill;
    }

    public String getMultipleLocationRequest() {
        return multipleLocationRequest;
    }

    public void setMultipleLocationRequest(String multipleLocationRequest) {
        this.multipleLocationRequest = multipleLocationRequest;
    }
    // \\\//\\

    public boolean isHasMultipleShipAndBill() {
        if (this.getMultipleShipAndBill() != null
                && this.getMultipleShipAndBill().trim()
                        .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public boolean isHasMultipleLocationRequest() {
        if (this.getMultipleLocationRequest() != null
                && this.getMultipleLocationRequest().trim()
                        .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public String getEnhanchedPaperCreditAppType() {
        return enhanchedPaperCreditAppType;
    }

    public void setEnhanchedPaperCreditAppType(String enhanchedPaperCreditAppType) {
        this.enhanchedPaperCreditAppType = enhanchedPaperCreditAppType;
    }

    public boolean isEnhanchedPaperCreditApp() {
        if (this.getEnhanchedPaperCreditAppType() != null
                && this.getEnhanchedPaperCreditAppType().trim()
                        .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public boolean isShowPaperAppStamp() {
        return this.isPaperCreditApp() || this.isEnhanchedPaperCreditApp()
                ? true : false;
    }

    /**
     * @return the hasSignatureName
     */
    public boolean isHasSignatureName() {
        if (this.getSignatureName() != null
                && this.getSignatureName().trim().length() > 2) {
            return true;
        }
        return false;
    }


    /**
     * @return the excludeShippingFromApp
     */
    public String getExcludeShippingFromApp() {
        return excludeShippingFromApp;
    }

    /**
     * @param excludeShippingFromApp
     *            the excludeShippingFromApp to set
     */
    public void setExcludeShippingFromApp(String excludeShippingFromApp) {
        this.excludeShippingFromApp = excludeShippingFromApp;
    }

    /**
     * @return the shippingExlcudedFromApp
     */
    public boolean isShippingExlcudedFromApp() {
        if (this.getExcludeShippingFromApp() != null
                && this.getExcludeShippingFromApp().trim()
                        .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public String getTransmittedFlag() {
        return transmittedFlag;
    }

    public void setTransmittedFlag(String transmittedFlag) {
        this.transmittedFlag = transmittedFlag;
    }

    public String getTrxnBatchControlToken() {
        return trxnBatchControlToken;
    }

    public void setTrxnBatchControlToken(String trxnBatchControlToken) {
        this.trxnBatchControlToken = trxnBatchControlToken;
    }

    /**
     * @return Returns the transactionCcy.
     */
    public String getTransactionCcy() {
        return transactionCcy;
    }

    /**
     * @param transactionCcy
     *            The transactionCcy to set.
     */
    public void setTransactionCcy(String transactionCcy) {
        this.transactionCcy = transactionCcy;
    }

    /**
     * @return Returns the formType.
     */
    public String getFormType() {
        return formType;
    }

    /**
     * @param formType The formType to set.
     */
    public void setFormType(String formType) {
        this.formType = formType;
    }

    /**
     * @return Returns the discardAppFlag.
     */
    public String getDiscardAppFlag() {
        return discardAppFlag;
    }

    /**
     * @param discardAppFlag The discardAppFlag to set.
     */
    public void setDiscardAppFlag(String discardAppFlag) {
        this.discardAppFlag = discardAppFlag;
    }

    /**
     * @return Returns the appProcStatus.
     */
    public String getAppProcStatus() {
        return appProcStatus;
    }

    /**
     * @param appProcStatus The appProcStatus to set.
     */
    public void setAppProcStatus(String appProcStatus) {
        this.appProcStatus = appProcStatus;
    }
    
}
