/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.b2b.enterprise.beans;

import java.util.Date;
import java.util.Set;

import com.bectran.attribute.beans.BaseEntity;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.idp.beans.IDPAttribute;

/**
 * @author shanmu
 * @date 01-Jun-2016 12:07:06 am
 */
public class EnterpriseIntgIdpServiceBean extends BaseEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -6875793585195561142L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long id;
    private String postURL;
    private String type;
    private String externalUserID;// This will be provided by the third-party
    // for Authorizing Http post
    private String externalPasscode;
    private String externalPwdSalt;
    private String externalId;// This ID is provided by the third-party for
    // identifying Bectran
    private String clearPassword;
    private String transmitType = MatrixConstants.IDP_TRANSMIT_TYPE_AUTHORIZATION;
    private int thresholdCount = 10;
    private String alertNotification = MatrixConstants.IDP_START;
    private String notificationEmailID;
    private String batchProcess = MatrixConstants.IDP_ENABLE_TYPE;
    private String errorMsg;
    private Date lastBatchUpdateDt;
    private String linkCode;
    private String responseType;
    private Set<IDPAttribute> idpAttributeSet;
    private String sslCertFlag = MatrixConstants.ANSWER_NO;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>EnterpriseIntgIdpServiceBean</code>
     */
    public EnterpriseIntgIdpServiceBean() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
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
     * @return Returns the postURL.
     */
    public String getPostURL() {
        return postURL;
    }

    /**
     * @param postURL
     *            The postURL to set.
     */
    public void setPostURL(String postURL) {
        this.postURL = postURL;
    }

    /**
     * @return Returns the type.
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            The type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return Returns the externalUserID.
     */
    public String getExternalUserID() {
        return externalUserID;
    }

    /**
     * @param externalUserID The externalUserID to set.
     */
    public void setExternalUserID(String externalUserID) {
        this.externalUserID = externalUserID;
    }

    /**
     * @return Returns the externalPasscode.
     */
    public String getExternalPasscode() {
        return externalPasscode;
    }

    /**
     * @param externalPasscode The externalPasscode to set.
     */
    public void setExternalPasscode(String externalPasscode) {
        this.externalPasscode = externalPasscode;
    }

    /**
     * @return Returns the externalPwdSalt.
     */
    public String getExternalPwdSalt() {
        return externalPwdSalt;
    }

    /**
     * @param externalPwdSalt The externalPwdSalt to set.
     */
    public void setExternalPwdSalt(String externalPwdSalt) {
        this.externalPwdSalt = externalPwdSalt;
    }

    /**
     * @return Returns the externalId.
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * @param externalId The externalId to set.
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * @return Returns the clearPassword.
     */
    public String getClearPassword() {
        return clearPassword;
    }

    /**
     * @param clearPassword The clearPassword to set.
     */
    public void setClearPassword(String clearPassword) {
        this.clearPassword = clearPassword;
    }

    /**
     * @return Returns the transmitType.
     */
    public String getTransmitType() {
        return transmitType;
    }

    /**
     * @param transmitType The transmitType to set.
     */
    public void setTransmitType(String transmitType) {
        this.transmitType = transmitType;
    }

    /**
     * @return Returns the thresholdCount.
     */
    public int getThresholdCount() {
        return thresholdCount;
    }

    /**
     * @param thresholdCount The thresholdCount to set.
     */
    public void setThresholdCount(int thresholdCount) {
        this.thresholdCount = thresholdCount;
    }

    /**
     * @return Returns the alertNotification.
     */
    public String getAlertNotification() {
        return alertNotification;
    }

    /**
     * @param alertNotification The alertNotification to set.
     */
    public void setAlertNotification(String alertNotification) {
        this.alertNotification = alertNotification;
    }

    /**
     * @return Returns the notificationEmailID.
     */
    public String getNotificationEmailID() {
        return notificationEmailID;
    }

    /**
     * @param notificationEmailID The notificationEmailID to set.
     */
    public void setNotificationEmailID(String notificationEmailID) {
        this.notificationEmailID = notificationEmailID;
    }

    /**
     * @return Returns the batchProcess.
     */
    public String getBatchProcess() {
        return batchProcess;
    }

    /**
     * @param batchProcess The batchProcess to set.
     */
    public void setBatchProcess(String batchProcess) {
        this.batchProcess = batchProcess;
    }

    /**
     * @return Returns the errorMsg.
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @param errorMsg The errorMsg to set.
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * @return Returns the lastBatchUpdateDt.
     */
    public Date getLastBatchUpdateDt() {
        return (Date) (lastBatchUpdateDt == null ? null : lastBatchUpdateDt.clone());
    }

    /**
     * @param lastBatchUpdateDt The lastBatchUpdateDt to set.
     */
    public void setLastBatchUpdateDt(Date lastBatchUpdateDt) {
        this.lastBatchUpdateDt = (Date) (lastBatchUpdateDt == null ? null : lastBatchUpdateDt.clone());
    }

    /**
     * @return Returns the linkCode.
     */
    public String getLinkCode() {
        return linkCode;
    }

    /**
     * @param linkCode The linkCode to set.
     */
    public void setLinkCode(String linkCode) {
        this.linkCode = linkCode;
    }

    /**
     * @return Returns the responseType.
     */
    public String getResponseType() {
        return responseType;
    }

    /**
     * @param responseType The responseType to set.
     */
    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    /**
     * @return Returns the idpAttributeSet.
     */
    public Set<IDPAttribute> getIdpAttributeSet() {
        return idpAttributeSet;
    }

    /**
     * @param idpAttributeSet The idpAttributeSet to set.
     */
    public void setIdpAttributeSet(Set<IDPAttribute> idpAttributeSet) {
        this.idpAttributeSet = idpAttributeSet;
    }
    /**
     * @return Returns the sslCertFlag.
     */
    public String getSslCertFlag() {
        return sslCertFlag;
    }

    /**
     * @param sslCertFlag The sslCertFlag to set.
     */
    public void setSslCertFlag(String sslCertFlag) {
        this.sslCertFlag = sslCertFlag;
    }
    
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
