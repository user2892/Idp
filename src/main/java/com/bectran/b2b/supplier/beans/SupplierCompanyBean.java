package com.bectran.b2b.supplier.beans;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.crol.constants.CrolConstants;

/**
 * @author LOUIS IFEGUNI
 */
public class SupplierCompanyBean extends CompanyInfoBaseBean {
    private byte[] companyLogo;
    private String termsAndCondition;
    private int numOfBankRef = 1; // MIN NUMBER
    private int numOfTradeRef = 3;// MIN NUMBER
    private int numOfOfficer = 1;// MIN NUMBER
    private int requiredNumRef = 5;// REQUIRED NUMBER OF REFERENCES
    private String driverLicenseRqdFlag = CrolConstants.NO; // YES or NO
    private String ssnRqdFlag = CrolConstants.NO; // YES or NO
    private int numOfGuarantor = 1;// MIN NUMBER
    private double fsRqmtThreshold;
    private String crefReceiptOption = CrolConstants.CREF_RECEIPT_BATCH;// Batch
                                                                        // Receipt
                                                                        // or
                                                                        // Real
                                                                        // time
    private int daysToProcessBenchmark = 5;
    private SupplierUserBean mainContact;
    //
    private BecSubscriptionBean mySubscription;
    private AccountSetupBean accountSetup;
    private String enterpriseCode = MatrixConstants.ANSWER_NO;
    private String groupStatus = MatrixConstants.GROUP_STATUS_NON_GROUP;
    private String approvalWorkflow = MatrixConstants.ANSWER_YES;
    private UICustomizationBean uiCustombBean;
    //
    private byte[] defaultCompanyLogo;
    private String defaultTOCS;
    /*
     * CUSTOMIZATION CODE
     */
    private int customizationCode = 0; // 0 = basic; 1 - custom
    private String customRootFolder;

    /**
     * DEFAULT CONSTRUCTOR
     */
    public SupplierCompanyBean() {
    }

    public byte[] getCompanyLogo() {
        return companyLogo == null ? null : companyLogo.clone();
    }

    public void setCompanyLogo(byte[] companyLogo) {
        this.companyLogo = companyLogo == null ? null : companyLogo.clone();
    }

    public int getNumOfBankRef() {
        return numOfBankRef;
    }

    public void setNumOfBankRef(int numOfBankRef) {
        this.numOfBankRef = numOfBankRef;
    }

    public int getNumOfTradeRef() {
        return numOfTradeRef;
    }

    public void setNumOfTradeRef(int numOfTradeRef) {
        this.numOfTradeRef = numOfTradeRef;
    }

    public String getTermsAndCondition() {
        return termsAndCondition;
    }

    public void setTermsAndCondition(String termsAndCondition) {
        this.termsAndCondition = termsAndCondition;
    }

    public int getNumOfOfficer() {
        return numOfOfficer;
    }

    public void setNumOfOfficer(int numOfOfficer) {
        this.numOfOfficer = numOfOfficer;
    }

    public boolean isHasLogo() {
        if (this.getCompanyLogo() == null) {
            return false;
        }
        return true;
    }

    public boolean isHasTermsAndCond() {
        if (this.getTermsAndCondition() == null
                || this.getTermsAndCondition().trim().length() < 1) {
            return false;
        }
        return true;
    }

    public int getRequiredNumRef() {
        return requiredNumRef;
    }

    public void setRequiredNumRef(int requiredNumRef) {
        this.requiredNumRef = requiredNumRef;
    }

    public SupplierUserBean getMainContact() {
        return mainContact;
    }

    public void setMainContact(SupplierUserBean mainContact) {
        this.mainContact = mainContact;
    }

    public BecSubscriptionBean getMySubscription() {
        return mySubscription;
    }

    public void setMySubscription(BecSubscriptionBean mySubscription) {
        this.mySubscription = mySubscription;
    }

    public String getDriverLicenseRqdFlag() {
        return driverLicenseRqdFlag;
    }

    public void setDriverLicenseRqdFlag(String driverLicenseRqdFlag) {
        this.driverLicenseRqdFlag = driverLicenseRqdFlag;
    }

    public String getSsnRqdFlag() {
        return ssnRqdFlag;
    }

    public void setSsnRqdFlag(String ssnRqdFlag) {
        this.ssnRqdFlag = ssnRqdFlag;
    }

    public int getCustomizationCode() {
        return customizationCode;
    }

    public void setCustomizationCode(int customizationCode) {
        this.customizationCode = customizationCode;
    }

    public int getNumOfGuarantor() {
        return numOfGuarantor;
    }

    public void setNumOfGuarantor(int numOfGuarantor) {
        this.numOfGuarantor = numOfGuarantor;
    }

    public String getCustomRootFolder() {
        return customRootFolder;
    }

    public void setCustomRootFolder(String customRootFolder) {
        this.customRootFolder = customRootFolder;
    }

    public double getFsRqmtThreshold() {
        return fsRqmtThreshold;
    }

    public void setFsRqmtThreshold(double fsRqmtThreshold) {
        this.fsRqmtThreshold = fsRqmtThreshold;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public boolean isEnterpriseCustomer() {
        if (this.getEnterpriseCode() != null && this.getEnterpriseCode().trim()
                .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public String getCrefReceiptOption() {
        return crefReceiptOption;
    }

    public void setCrefReceiptOption(String crefReceiptOption) {
        this.crefReceiptOption = crefReceiptOption;
    }

    public String getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(String groupStatus) {
        this.groupStatus = groupStatus;
    }

    public UICustomizationBean getUiCustombBean() {
        return uiCustombBean;
    }

    public void setUiCustombBean(UICustomizationBean uiCustombBean) {
        this.uiCustombBean = uiCustombBean;
    }

    public int getDaysToProcessBenchmark() {
        return daysToProcessBenchmark;
    }

    public void setDaysToProcessBenchmark(int daysToProcessBenchmark) {
        this.daysToProcessBenchmark = daysToProcessBenchmark;
    }

    public boolean isSetupIsComplete() {
        if (this.getSetupProgress() == null) {
            return false;
        }
        if (this.getSetupProgress().trim()
                .equals(MatrixConstants.SETUP_PROGRESS_COMPLETE)) {
            return true;
        }
        return false;
    }

    public boolean isSetupInProgress() {
        if (this.getSetupProgress() == null) {
            return false;
        }
        if (this.getSetupProgress().trim()
                .equals(MatrixConstants.SETUP_PROGRESS_INPROGRESS)) {
            return true;
        }
        return false;
    }

    public String getDisplayLogoImage() {
        String imageServletUrl = "<img  src=\"/b2bcredit/SupplierLogServlet?SIG_MENU_ACTION=LOGO_CREDITAPP_INSUP";
        imageServletUrl = imageServletUrl + "\"" + " >";
        return imageServletUrl;
    }

    public String getDisplayDefaultLogo() {
        String imageServletUrl = "<img  src=\"/b2bcredit/SupplierLogServlet?SIG_MENU_ACTION=LOGO_DEFAULT";
        imageServletUrl = imageServletUrl + "\"" + " >";
        return imageServletUrl;
    }

    public AccountSetupBean getAccountSetup() {
        return accountSetup;
    }

    public void setAccountSetup(AccountSetupBean accountSetup) {
        this.accountSetup = accountSetup;
    }

    public String getApprovalWorkflow() {
        return approvalWorkflow;
    }

    public void setApprovalWorkflow(String approvalWorkflow) {
        this.approvalWorkflow = approvalWorkflow;
    }

    public boolean isHasApprovalWorkflow() {
        if (this.getApprovalWorkflow() != null && this.getApprovalWorkflow()
                .trim().equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public byte[] getDefaultCompanyLogo() {
        return defaultCompanyLogo == null ? null : defaultCompanyLogo.clone();
    }

    public void setDefaultCompanyLogo(byte[] defaultCompanyLogo) {
        this.defaultCompanyLogo = defaultCompanyLogo == null ? null : defaultCompanyLogo.clone();
    }

    public String getDefaultTOCS() {
        return defaultTOCS;
    }

    public void setDefaultTOCS(String defaultTOCS) {
        this.defaultTOCS = defaultTOCS;
    }
}
