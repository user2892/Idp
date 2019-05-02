package com.bectran.b2b.customer.beans;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 26, 2012 : 10:30:04 AM
 */
public class CustomerDocsBaseBean {
    private Long id;
    private Long customerSupplierId;
    private CustomerSupplierBean customerSupplier;
    private Long docModelId;
    private Long supplierId;
    private String status = MatrixConstants.STATUS_ACTIVE;
    private Date lastUpdate;
    private String acctNum;
    //
    private String docFileSystemName = "";
    private Date expiration;
    private String fileType;
    private String fileExt;
    private String docName;
    private String description;
    //
    private String supplierCorpID; // USED FOR CONTAINER NAMING
    private String docImageUrl;
    private String relativeFileName;
    //
    private byte[] fileImage;
    //
    private String cusDocType;
    private String signableContent;
    //
    private boolean uploadSuccessful;
    //
    // for monitorable documents
    private String stateCode;
    private String stateName;
    private String expirationDateRqd = MatrixConstants.ANSWER_YES;
    private String docIdNumber;
    //
    private Date lastUpdateRequestDate;
    private String flaggedForUpdate = MatrixConstants.ANSWER_NO;
    //
    private String docLabel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerSupplierId() {
        return customerSupplierId;
    }

    public void setCustomerSupplierId(Long customerSupplierId) {
        this.customerSupplierId = customerSupplierId;
    }

    public Long getDocModelId() {
        return docModelId;
    }

    public void setDocModelId(Long docModelId) {
        this.docModelId = docModelId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
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

    public Date getExpiration() {
        return (Date) (expiration == null ? null : expiration.clone());
    }

    public void setExpiration(Date expiration) {
        this.expiration = (Date) (expiration == null ? null : expiration.clone());
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getFileImage() {
        return fileImage == null ? null : fileImage.clone();
    }

    public void setFileImage(byte[] fileImage) {
        this.fileImage = fileImage == null ? null : fileImage.clone();
    }

    public String getSupplierCorpID() {
        return supplierCorpID;
    }

    public void setSupplierCorpID(String supplierCorpID) {
        this.supplierCorpID = supplierCorpID;
    }

    public String getDocImageUrl() {
        return docImageUrl;
    }

    public void setDocImageUrl(String docImageUrl) {
        this.docImageUrl = docImageUrl;
    }

    public String getCusDocType() {
        return cusDocType;
    }

    public void setCusDocType(String cusDocType) {
        this.cusDocType = cusDocType;
    }

    public String getSignableContent() {
        return signableContent;
    }

    public void setSignableContent(String signableContent) {
        this.signableContent = signableContent;
    }

    public boolean isDocIsSignable() {
        return this.getCusDocType().trim().equals(
                MatrixConstants.DOCUMENT_MGT_TYPE_SIGNABLE) ? true : false;
    }

    public boolean isUploadSuccessful() {
        return uploadSuccessful;
    }

    public void setUploadSuccessful(boolean uploadSuccessful) {
        this.uploadSuccessful = uploadSuccessful;
    }

    public boolean isPdfDoc() {
        return this.getFileType().trim().equals(MatrixConstants.FILE_TYPE_PDF)
                ? true : false;
    }

    public String getRelativeFileName() {
        return relativeFileName;
    }

    public void setRelativeFileName(String relativeFileName) {
        this.relativeFileName = relativeFileName;
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

    public String getExpirationDateRqd() {
        return expirationDateRqd;
    }

    public void setExpirationDateRqd(String expirationDateRqd) {
        this.expirationDateRqd = expirationDateRqd;
    }

    public String getDocIdNumber() {
        return docIdNumber;
    }

    public void setDocIdNumber(String docIdNumber) {
        this.docIdNumber = docIdNumber;
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

    public boolean isDocumentIsMonitorable() {
        if (this.getCusDocType() != null && this.getCusDocType().trim()
                .equals(MatrixConstants.DOCUMENT_MGT_TYPE_MONITORABLE)) {
            return true;
        }
        return false;
    }

    public boolean isShowDocStateName() {
        if (this.getStateName() != null
                && this.getStateName().trim().length() > 2) {
            return true;
        }
        return false;
    }

    public CustomerSupplierBean getCustomerSupplier() {
        return customerSupplier;
    }

    public void setCustomerSupplier(CustomerSupplierBean customerSupplier) {
        this.customerSupplier = customerSupplier;
    }

    public Date getLastUpdateRequestDate() {
        return (Date) (lastUpdateRequestDate == null ? null : lastUpdateRequestDate.clone());
    }

    public void setLastUpdateRequestDate(Date lastUpdateRequestDate) {
        this.lastUpdateRequestDate = (Date) (lastUpdateRequestDate == null ? null : lastUpdateRequestDate.clone());
    }

    public String getFlaggedForUpdate() {
        return flaggedForUpdate;
    }

    public void setFlaggedForUpdate(String flaggedForUpdate) {
        this.flaggedForUpdate = flaggedForUpdate;
    }

    /**
     * @return Returns the docLabel.
     */
    public String getDocLabel() {
        return docLabel;
    }

    /**
     * @param docLabel
     *            The docLabel to set.
     */
    public void setDocLabel(String docLabel) {
        this.docLabel = docLabel;
    }

    public boolean isMsType() {
        String fileType = getFileType();
        if (StringUtils.equals(MatrixConstants.FILE_TYPE_CSV, fileType)
                || StringUtils.equals(MatrixConstants.FILE_TYPE_DOC, fileType)
                || StringUtils.equals(MatrixConstants.FILE_TYPE_DOCX, fileType)
                || StringUtils.equals(MatrixConstants.FILE_TYPE_XLSX, fileType)
                || StringUtils.equals(MatrixConstants.FILE_TYPE_XLS,
                        fileType)) {
            return true;
        }
        return false;
    }
}
