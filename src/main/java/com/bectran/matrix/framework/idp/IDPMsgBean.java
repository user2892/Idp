/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.matrix.framework.idp;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.idp.beans.IDPAttribute;

/**
 * @author Santhosh Voddiraj
 * @date May 21, 2016
 */
public class IDPMsgBean implements Serializable {
    private static final long serialVersionUID = -1L;
    private Long groupId;
    private Long supplierId;
    private Long requestId;
    private String passCode;
    private String mysalt;
    private String userID;
    private String postURL;
    private String responseCode;
    private String responseData;
    private String xmlDocument;
    private String postType;
    private String stackTrace;
    private String externalId;
    private String transmitType;
    private String responseDecisionData;
    private String xmlDecisionDocument;
    private String xmlCustomerAndDecisionDocument;
    private String responseCustomerAndDecisionData;
    // Customer Data or Credit Decision Data or ALL
    private String responseType;
    private Set<IDPAttribute> idpAttributeSet;
    private List<String> deleteNodeNames;
    private String sslCertFlag = MatrixConstants.ANSWER_NO;
    
    private String jsonCustomerDocument;
    private String jsonDecisionDocument;
    private String jsonCustomerAndDecisionDocument;
    
    private String transmitAt;
    /**
     * @return Returns the groupId.
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     *            The groupId to set.
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * @return Returns the supplierId.
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId
     *            The supplierId to set.
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * @return Returns the requestId.
     */
    public Long getRequestId() {
        return requestId;
    }

    /**
     * @param requestId
     *            The requestId to set.
     */
    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }


    /**
     * @return Returns the passCode.
     */
    public String getPassCode() {
        return passCode;
    }

    /**
     * @param passCode
     *            The passCode to set.
     */
    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    /**
     * @return Returns the mysalt.
     */
    public String getMysalt() {
        return mysalt;
    }

    /**
     * @param mysalt
     *            The mysalt to set.
     */
    public void setMysalt(String mysalt) {
        this.mysalt = mysalt;
    }

    /**
     * @return Returns the userID.
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID
     *            The userID to set.
     */
    public void setUserID(String userID) {
        this.userID = userID;
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
     * @return Returns the responseCode.
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * @param responseCode
     *            The responseCode to set.
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * @return Returns the xmlDocument.
     */
    public String getXmlDocument() {
        return xmlDocument;
    }

    /**
     * @param xmlDocument
     *            The xmlDocument to set.
     */
    public void setXmlDocument(String xmlDocument) {
        this.xmlDocument = xmlDocument;
    }

    /**
     * @return Returns the postType.
     */
    public String getPostType() {
        return postType;
    }

    /**
     * @param postType
     *            The postType to set.
     */
    public void setPostType(String postType) {
        this.postType = postType;
    }

    /**
     * @return Returns the stackTrace.
     */
    public String getStackTrace() {
        return stackTrace;
    }

    /**
     * @param stackTrace
     *            The stackTrace to set.
     */
    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
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
     * @return Returns the transmitType.
     */
    public String getTransmitType() {
        return transmitType;
    }

    /**
     * @param transmitType
     *            The transmitType to set.
     */
    public void setTransmitType(String transmitType) {
        this.transmitType = transmitType;
    }

    /**
     * @return Returns the responseData.
     */
    public String getResponseData() {
        return responseData;
    }

    /**
     * @param responseData
     *            The responseData to set.
     */
    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    /**
     * @return Returns the responseDecisionData.
     */
    public String getResponseDecisionData() {
        return responseDecisionData;
    }

    /**
     * @param responseDecisionData
     *            The responseDecisionData to set.
     */
    public void setResponseDecisionData(String responseDecisionData) {
        this.responseDecisionData = responseDecisionData;
    }

    /**
     * @return Returns the xmlDecisionDocument.
     */
    public String getXmlDecisionDocument() {
        return xmlDecisionDocument;
    }

    /**
     * @param xmlDecisionDocument
     *            The xmlDecisionDocument to set.
     */
    public void setXmlDecisionDocument(String xmlDecisionDocument) {
        this.xmlDecisionDocument = xmlDecisionDocument;
    }

    /**
     * @return Returns the responseType.
     */
    public String getResponseType() {
        return responseType;
    }

    /**
     * @param responseType
     *            The responseType to set.
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
     * @param idpAttributeSet
     *            The idpAttributeSet to set.
     */
    public void setIdpAttributeSet(Set<IDPAttribute> idpAttributeSet) {
        this.idpAttributeSet = idpAttributeSet;
    }

    /**
     * @return Returns the deleteNodeNames.
     */
    public List<String> getDeleteNodeNames() {
        return deleteNodeNames;
    }

    /**
     * @param deleteNodeNames
     *            The deleteNodeNames to set.
     */
    public void setDeleteNodeNames(List<String> deleteNodeNames) {
        this.deleteNodeNames = deleteNodeNames;
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

    /**
     * @return Returns the xmlCustomerAndDecisionDocument.
     */
    public String getXmlCustomerAndDecisionDocument() {
        return xmlCustomerAndDecisionDocument;
    }

    /**
     * @param xmlCustomerAndDecisionDocument The xmlCustomerAndDecisionDocument to set.
     */
    public void setXmlCustomerAndDecisionDocument(String xmlCustomerAndDecisionDocument) {
        this.xmlCustomerAndDecisionDocument = xmlCustomerAndDecisionDocument;
    }

    /**
     * @return Returns the responseCustomerAndDecisionData.
     */
    public String getResponseCustomerAndDecisionData() {
        return responseCustomerAndDecisionData;
    }

    /**
     * @param responseCustomerAndDecisionData The responseCustomerAndDecisionData to set.
     */
    public void setResponseCustomerAndDecisionData(String responseCustomerAndDecisionData) {
        this.responseCustomerAndDecisionData = responseCustomerAndDecisionData;
    }

    /**
     * @return Returns the jsonCustomerDocument.
     */
    public String getJsonCustomerDocument() {
        return jsonCustomerDocument;
    }

    /**
     * @param jsonCustomerDocument The jsonCustomerDocument to set.
     */
    public void setJsonCustomerDocument(String jsonCustomerDocument) {
        this.jsonCustomerDocument = jsonCustomerDocument;
    }

    /**
     * @return Returns the jsonDecisionDocument.
     */
    public String getJsonDecisionDocument() {
        return jsonDecisionDocument;
    }

    /**
     * @param jsonDecisionDocument The jsonDecisionDocument to set.
     */
    public void setJsonDecisionDocument(String jsonDecisionDocument) {
        this.jsonDecisionDocument = jsonDecisionDocument;
    }

    /**
     * @return Returns the jsonCustomerAndDecisionDocument.
     */
    public String getJsonCustomerAndDecisionDocument() {
        return jsonCustomerAndDecisionDocument;
    }

    /**
     * @param jsonCustomerAndDecisionDocument The jsonCustomerAndDecisionDocument to set.
     */
    public void setJsonCustomerAndDecisionDocument(String jsonCustomerAndDecisionDocument) {
        this.jsonCustomerAndDecisionDocument = jsonCustomerAndDecisionDocument;
    }

	/**
	 * @return the transmitAt
	 */
	public String getTransmitAt() {
		return transmitAt;
	}

	/**
	 * @param transmitAt the transmitAt to set
	 */
	public void setTransmitAt(String transmitAt) {
		this.transmitAt = transmitAt;
	}
   
    
}
