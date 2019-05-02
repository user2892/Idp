package com.bectran.b2b.customer.beans;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 */
public class TaxExemptByRequestBean extends CreditDocumentBaseBean {
    private String status = MatrixConstants.STATUS_ACTIVE;
    private Long exemptCertId;
    private TaxExemptCertBean exemptCertBean;

    public TaxExemptByRequestBean() {
    }

    public Long getExemptCertId() {
        return exemptCertId;
    }

    public void setExemptCertId(Long exemptCertId) {
        this.exemptCertId = exemptCertId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TaxExemptCertBean getExemptCertBean() {
        return exemptCertBean;
    }

    public void setExemptCertBean(TaxExemptCertBean exemptCertBean) {
        this.exemptCertBean = exemptCertBean;
    }
}
