/**
 *
 */
package com.bectran.b2b.enterprise.beans;

import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 * @DATE Sep 19, 2011 : 6:38:42 PM
 */
public class EnterpriseAccountBaseBean {
    private Long id;
    private String accountCode;
    private String passCode;
    private String processorEngine;
    private String authToken;
    private String accountStatus = MatrixConstants.STATUS_INACTIVE;
    private Date lastUpdate;
    private Date dateOfActivation;
    private String mysalt;
    private String integrationServiceType = MatrixConstants.ENTERPRISE_INTEGRATION_SERVICE_TYPE_SECURED_FTP_XML;
    private String operationMode = MatrixConstants.ENTERPRISE_INTEGRATION_OPS_MODE_PILOT;
    //
    private Date inboundDataStartDate;
    //
    private String accountId;

    public EnterpriseAccountBaseBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public String getProcessorEngine() {
        return processorEngine;
    }

    public void setProcessorEngine(String processorEngine) {
        this.processorEngine = processorEngine;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public Date getDateOfActivation() {
        return (Date) (dateOfActivation == null ? null : dateOfActivation.clone());
    }

    public void setDateOfActivation(Date dateOfActivation) {
        this.dateOfActivation = (Date) (dateOfActivation == null ? null : dateOfActivation.clone());
    }

    public String getMysalt() {
        return mysalt;
    }

    public void setMysalt(String mysalt) {
        this.mysalt = mysalt;
    }

    public boolean isActive() {
        return this.getAccountStatus().trim()
                .equals(MatrixConstants.STATUS_ACTIVE) ? true : false;
    }

    public String getIntegrationServiceType() {
        return integrationServiceType;
    }

    public void setIntegrationServiceType(String integrationServiceType) {
        this.integrationServiceType = integrationServiceType;
    }

    public Date getInboundDataStartDate() {
        return (Date) (inboundDataStartDate == null ? null : inboundDataStartDate.clone());
    }

    public void setInboundDataStartDate(Date inboundDataStartDate) {
        this.inboundDataStartDate = (Date) (inboundDataStartDate == null ? null : inboundDataStartDate.clone());
    }

    public String getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(String operationMode) {
        this.operationMode = operationMode;
    }

    public boolean isProdInboundMode() {
        return this.getOperationMode().trim()
                .equals(MatrixConstants.ENTERPRISE_INTEGRATION_OPS_MODE_PROD)
                        ? true : false;
    }

    public boolean isWebserviceMethod() {
        return this.getIntegrationServiceType().trim()
                .equals(MatrixConstants.ENTERPRISE_INTEGRATION_SERVICE_TYPE_WEBSERVICE)
                        ? true : false;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
