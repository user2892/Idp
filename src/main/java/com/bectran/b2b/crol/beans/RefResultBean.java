package com.bectran.b2b.crol.beans;

import com.bectran.b2b.customer.beans.RefForRequestBean;
import com.bectran.b2b.supplier.beans.ManualRefAuditBean;

/**
 * @author LOUIS IFEGUNI
 */
public class RefResultBean {
    private CreditRefBean creditRef;
    private RefForRequestBean refForRequest;
    private boolean manualRefType;
    private ManualRefAuditBean refAuditBean;

    public CreditRefBean getCreditRef() {
        return creditRef;
    }

    public void setCreditRef(CreditRefBean creditRef) {
        this.creditRef = creditRef;
    }

    public RefForRequestBean getRefForRequest() {
        return refForRequest;
    }

    public void setRefForRequest(RefForRequestBean refForRequest) {
        this.refForRequest = refForRequest;
    }

    public boolean isManualRefType() {
        return manualRefType;
    }

    public void setManualRefType(boolean manualRefType) {
        this.manualRefType = manualRefType;
    }

    public ManualRefAuditBean getRefAuditBean() {
        return refAuditBean;
    }

    public void setRefAuditBean(ManualRefAuditBean refAuditBean) {
        this.refAuditBean = refAuditBean;
    }
    //
}
