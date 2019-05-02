/**
 * 
 */
package com.bectran.b2b.customer.beans;

import java.util.Date;

import com.bectran.b2b.base.beans.CustomerBaseBean;
import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI Date: Feb 24, 2012 / 9:05:15 PM
 */
public class ClientCustomerInfoCopyBean extends CustomerBaseBean {
    private Long id; // same as customer-supplier ID
    private Long supplierId;
    private String integrationUpdateFlag = MatrixConstants.NOT_APPLICABLE;// these
                                                                          // are
                                                                          // all
                                                                          // accounts
                                                                          // coming
                                                                          // from
                                                                          // client's
                                                                          // backend
                                                                          // system
    private Date integrationUpdateDate;
    private String trxnBatchControlToken;
    private String transmittedFlag = MatrixConstants.ANSWER_NO; // changed to
                                                                // yes once
                                                                // transmitted
    private String internalAcctNum;

    public ClientCustomerInfoCopyBean() {
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

    public String getIntegrationUpdateFlag() {
        return integrationUpdateFlag;
    }

    public void setIntegrationUpdateFlag(String integrationUpdateFlag) {
        this.integrationUpdateFlag = integrationUpdateFlag;
    }

    public Date getIntegrationUpdateDate() {
        return (Date) (integrationUpdateDate == null ? null : integrationUpdateDate.clone());
    }

    public void setIntegrationUpdateDate(Date integrationUpdateDate) {
        this.integrationUpdateDate = (Date) (integrationUpdateDate == null ? null : integrationUpdateDate.clone());
    }

    public String getTrxnBatchControlToken() {
        return trxnBatchControlToken;
    }

    public void setTrxnBatchControlToken(String trxnBatchControlToken) {
        this.trxnBatchControlToken = trxnBatchControlToken;
    }

    public String getTransmittedFlag() {
        return transmittedFlag;
    }

    public void setTransmittedFlag(String transmittedFlag) {
        this.transmittedFlag = transmittedFlag;
    }

    public String getInternalAcctNum() {
        return internalAcctNum;
    }

    public void setInternalAcctNum(String internalAcctNum) {
        this.internalAcctNum = internalAcctNum;
    }
}
