package com.bectran.b2b.customer.beans;

import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.matrix.utils.DateUtility;

/**
 * @author LOUIS IFEGUNI
 */
public class TaxExemptCertBaseBean {
    private CustomerSupplierBean customerSupplier;
    private Long id;
    private Long customerSupplierId;
    private String status = MatrixConstants.STATUS_ACTIVE;
    private Date lastUpdate;
    private String stateCode;
    private String stateName;
    private String localJurisdiction = "";
    private byte[] certImage; // image uploaded
    //
    private String certNum;
    private Date expiration;
    private String deleteFlag = MatrixConstants.ANSWER_YES;
    //
    private Date lastUpdateRequestDate;
    private String flaggedForUpdate = MatrixConstants.ANSWER_NO;
    private boolean selected = false;
    private String fileType;
    private String pdfFileLoc;
    //
    private String supplierCorpID; // USED FOR CONTAINER NAMING
    private Long supplierId;
    private String docImageUrl;
    private String acctNum;
    private String docFileSystemName = "";
    private String fileExt;
    //
    private String relativeFileName;
    //
    private String expirationDateRqd = MatrixConstants.ANSWER_YES;
    //
    private Long groupId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getCertImage() {
        return certImage == null ? null : certImage.clone();
    }

    public void setCertImage(byte[] certImage) {
        this.certImage = certImage == null ? null : certImage.clone();
    }

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocalJurisdiction() {
        return localJurisdiction;
    }

    public void setLocalJurisdiction(String localJurisdiction) {
        this.localJurisdiction = localJurisdiction;
    }

    public Long getCustomerSupplierId() {
        return customerSupplierId;
    }

    public void setCustomerSupplierId(Long customerSupplierId) {
        this.customerSupplierId = customerSupplierId;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getCertNum() {
        return certNum;
    }

    public void setCertNum(String certNum) {
        this.certNum = certNum;
    }

    public Date getExpiration() {
        return (Date) (expiration == null ? null : expiration.clone());
    }

    public void setExpiration(Date expiration) {
        this.expiration = (Date) (expiration == null ? null : expiration.clone());
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public boolean isDeleteOn() {
        if (this.getDeleteFlag().trim().equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public boolean isExpired() {
        return this.getExpiration().before(new Date()) ? true : false;
    }

    public int getDaysToExpire() {
        return DateUtility.computeDays(new Date(), this.getExpiration());
    }

    public boolean getDaysToExpireWithin30Day() {
        return this.getDaysToExpire() < 30 ? true : false;
    }

    public int getDaysExpired() {
        return DateUtility.computeDays(this.getExpiration(), new Date());
    }

    public Date getLastUpdateRequestDate() {
        return (Date) (lastUpdateRequestDate == null ? null : lastUpdateRequestDate.clone());
    }

    public void setLastUpdateRequestDate(Date lastUpdateRequestDate) {
        this.lastUpdateRequestDate = (Date) (lastUpdateRequestDate == null ? null : lastUpdateRequestDate.clone());
    }

    public CustomerSupplierBean getCustomerSupplier() {
        return customerSupplier;
    }

    public void setCustomerSupplier(CustomerSupplierBean customerSupplier) {
        this.customerSupplier = customerSupplier;
    }

    public String getFlaggedForUpdate() {
        return flaggedForUpdate;
    }

    public void setFlaggedForUpdate(String flaggedForUpdate) {
        this.flaggedForUpdate = flaggedForUpdate;
    }

    public boolean isSoonToExpire() {
        Date ThirtyDaysFromToday = DateUtility.dateOfXDaysFromToday(30);
        return (this.getExpiration().after(new Date())
                && this.getExpiration().before(ThirtyDaysFromToday)) ? true
                        : false;
    }

    public boolean isNotUnderWatch() {
        Date ThirtyDaysFromToday = DateUtility.dateOfXDaysFromToday(30);
        return (this.getExpiration().after(ThirtyDaysFromToday)) ? true : false;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getPdfFileLoc() {
        return pdfFileLoc;
    }

    public void setPdfFileLoc(String pdfFileLoc) {
        this.pdfFileLoc = pdfFileLoc;
    }

    public String getSupplierCorpID() {
        return supplierCorpID;
    }

    public void setSupplierCorpID(String supplierCorpID) {
        this.supplierCorpID = supplierCorpID;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getDocImageUrl() {
        return docImageUrl;
    }

    public void setDocImageUrl(String docImageUrl) {
        this.docImageUrl = docImageUrl;
    }

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public String getDocFileSystemName() {
        return docFileSystemName;
    }

    public void setDocFileSystemName(String docFileSystemName) {
        this.docFileSystemName = docFileSystemName;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getRelativeFileName() {
        return relativeFileName;
    }

    public void setRelativeFileName(String relativeFileName) {
        this.relativeFileName = relativeFileName;
    }

    public boolean isPdfDoc() {
        return this.getFileType().trim().equals(MatrixConstants.FILE_TYPE_PDF)
                ? true : false;
    }

    public String getExpirationDateRqd() {
        return expirationDateRqd;
    }

    public void setExpirationDateRqd(String expirationDateRqd) {
        this.expirationDateRqd = expirationDateRqd;
    }

    public boolean isShowExpirationWin() {
        if (this.getExpirationDateRqd() == null
                || this.getExpirationDateRqd().trim().length() < 2) {
            return true;
        }
        if (this.getExpirationDateRqd().trim()
                .equals(MatrixConstants.ANSWER_NO)) {
            return false;
        }
        return true;
    }

    /**
     * @return the hasExpiration
     */
    public boolean isHasExpiration() {
        if (this.getExpirationDateRqd() == null
                || this.getExpirationDateRqd().trim().length() < 2) {
            return true;
        }
        if (this.getExpirationDateRqd().trim()
                .equals(MatrixConstants.ANSWER_YES)) {
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
}
