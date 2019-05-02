package com.bectran.b2b.supplier.beans;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 */
public class GroupAccountBean implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final Comparator<GroupAccountBean> ASCENDING_ORDER = new Comparator<GroupAccountBean>() {
        public int compare(GroupAccountBean r1, GroupAccountBean r2) {
            return r1.getName().compareTo(r2.getName());
        }
    };
    private Long id;
    private Long supplierId;
    private String businessGroupName = "";
    private String userId;
    private String userName;
    private byte[] termsAndCondition;
    protected String termsAndCondReview;
    private Date lastUpdate;
    private String primaryGroup = MatrixConstants.ANSWER_NO;
    private String creditAppSecuredLinkCode;
    private String groupType = MatrixConstants.GROUP_TYPE_DIVISION;
    private String name;
    protected boolean groupIsPrimary;
    //
    private SupplierUserBean groupContact;
    //
    private String termsAndCondText;
    private String updateTermsOption;
    protected boolean uploadNewTerm;
    //
    private String creditAppLink;
    private String creditAppLinkHtmlCode;
    private String creditAppLinkHtmlCodeExistingCus;
    //
    private String customCreditApp = MatrixConstants.ANSWER_NO;
    protected boolean hasCustomCreditApp;
    private String customAppStatus = MatrixConstants.STATUS_INACTIVE;
    protected String customAppStatusDisplay;
    protected boolean customAppStatusActive;
    protected boolean groupIsDivision;
    //
    private byte[] companyLogo;
    protected String displayLogoImageAdmin;
    private String internalGroupCode;
    private String codAppLink;

    public GroupAccountBean() {
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

    public String getBusinessGroupName() {
        return businessGroupName;
    }

    public void setBusinessGroupName(String businessGroupName) {
        this.businessGroupName = businessGroupName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String mainContactUserId) {
        this.userId = mainContactUserId;
    }

    public byte[] getTermsAndCondition() {
        return termsAndCondition == null ? null : termsAndCondition.clone();
    }

    public void setTermsAndCondition(byte[] termsAndCondition) {
        this.termsAndCondition = termsAndCondition == null ? null : termsAndCondition.clone();
    }

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public SupplierUserBean getGroupContact() {
        return groupContact;
    }

    public void setGroupContact(SupplierUserBean groupContact) {
        this.groupContact = groupContact;
    }

    public String getTermsAndCondText() {
        return termsAndCondText;
    }

    public void setTermsAndCondText(String termsAndCondText) {
        this.termsAndCondText = termsAndCondText;
    }

    public String getUpdateTermsOption() {
        return updateTermsOption;
    }

    public void setUpdateTermsOption(String updateTermsOption) {
        this.updateTermsOption = updateTermsOption;
    }

    public boolean isUploadNewTerm() {
        if (this.getUpdateTermsOption().trim()
                .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public void setUploadNewTerm(boolean uploadNewTerm) {
        this.uploadNewTerm = uploadNewTerm;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreditAppLink() {
        return creditAppLink;
    }

    public void setCreditAppLink(String creditAppLink) {
        this.creditAppLink = creditAppLink;
    }

    public String getCreditAppLinkHtmlCode() {
        return creditAppLinkHtmlCode;
    }

    public void setCreditAppLinkHtmlCode(String creditAppLinkHtmlCode) {
        this.creditAppLinkHtmlCode = creditAppLinkHtmlCode;
    }

    public String getPrimaryGroup() {
        return primaryGroup;
    }

    public void setPrimaryGroup(String primaryGroup) {
        this.primaryGroup = primaryGroup;
    }

    public boolean isGroupIsPrimary() {
        if (this.primaryGroup != null && this.primaryGroup.trim()
                .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public void setGroupIsPrimary(boolean groupIsPrimary) {
        this.groupIsPrimary = groupIsPrimary;
    }

    public String getTermsAndCondReview() {
        return String.valueOf(this.getTermsAndCondition()).trim();
    }

    public void setTermsAndCondReview(String termsAndCondReview) {
        this.termsAndCondReview = termsAndCondReview;
    }

    public String getCreditAppSecuredLinkCode() {
        return creditAppSecuredLinkCode;
    }

    public void setCreditAppSecuredLinkCode(String linkCode) {
        this.creditAppSecuredLinkCode = linkCode;
    }

    public String getCustomCreditApp() {
        return customCreditApp;
    }

    public void setCustomCreditApp(String customCreditApp) {
        this.customCreditApp = customCreditApp;
    }

    public boolean isHasCustomCreditApp() {
        return this.getCustomCreditApp().trim()
                .equals(MatrixConstants.ANSWER_YES) ? true : false;
    }

    public void setHasCustomCreditApp(boolean hasCustomCreditApp) {
        this.hasCustomCreditApp = hasCustomCreditApp;
    }

    public String getCustomAppStatus() {
        return customAppStatus;
    }

    public void setCustomAppStatus(String customAppStatus) {
        this.customAppStatus = customAppStatus;
    }

    public String getCustomAppStatusDisplay() {
        return this.getCustomAppStatus().trim()
                .equals(MatrixConstants.STATUS_ACTIVE) ? "ON" : "OFF";
    }

    public void setCustomAppStatusDisplay(String customAppStatusDisplay) {
        this.customAppStatusDisplay = customAppStatusDisplay;
    }

    public boolean isCustomAppStatusActive() {
        return this.getCustomAppStatus().trim()
                .equals(MatrixConstants.STATUS_ACTIVE) ? true : false;
    }

    public void setCustomAppStatusActive(boolean customAppStatusActive) {
        this.customAppStatusActive = customAppStatusActive;
    }

    public byte[] getCompanyLogo() {
        return companyLogo == null ? null : companyLogo.clone();
    }

    public void setCompanyLogo(byte[] companyLogo) {
        this.companyLogo = companyLogo == null ? null : companyLogo.clone();
    }

    public String getDisplayLogoImageAdmin() {
        String imageServletUrl = "<img  src=\"/b2bcredit/SupplierLogServlet?SIG_MENU_ACTION=BIZ_GROUP_LOGO_ADMIN&refreshimage="
                + new Date();
        imageServletUrl = imageServletUrl + "\"" + " >";
        return imageServletUrl;
    }

    public void setDisplayLogoImageAdmin(String displayLogoImageAdmin) {
        this.displayLogoImageAdmin = displayLogoImageAdmin;
    }

    public String getCreditAppLinkHtmlCodeExistingCus() {
        return creditAppLinkHtmlCodeExistingCus;
    }

    public void setCreditAppLinkHtmlCodeExistingCus(String creditAppLinkHtmlCodeExistingCus) {
        this.creditAppLinkHtmlCodeExistingCus = creditAppLinkHtmlCodeExistingCus;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public boolean isGroupIsDivision() {
        if (this.getGroupType() == null) {
            return false;
        }
        return this.getGroupType().trim()
                .equals(MatrixConstants.GROUP_TYPE_DIVISION) ? true : false;
    }

    public void setGroupIsDivision(boolean groupIsDivision) {
        this.groupIsDivision = groupIsDivision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodAppLink() {
        return codAppLink;
    }

    public void setCodAppLink(String codAppLink) {
        this.codAppLink = codAppLink;
    }

    public String getInternalGroupCode() {
        return internalGroupCode;
    }

    public void setInternalGroupCode(String internalGroupCode) {
        this.internalGroupCode = internalGroupCode;
    }
}
