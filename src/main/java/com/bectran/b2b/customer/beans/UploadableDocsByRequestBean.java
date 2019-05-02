/**
 * 
 */
package com.bectran.b2b.customer.beans;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 22, 2012 : 4:04:05 PM
 */
public class UploadableDocsByRequestBean extends CreditDocumentBaseBean {
    private String status = MatrixConstants.STATUS_ACTIVE;
    private Long customerDocId;
    private Long docModelId;
    //
    private String signableContentCompleted = MatrixConstants.ANSWER_NO;
    private CustomerDocsBean customerDoc;

    public UploadableDocsByRequestBean() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCustomerDocId() {
        return customerDocId;
    }

    public void setCustomerDocId(Long customerDocId) {
        this.customerDocId = customerDocId;
    }

    public CustomerDocsBean getCustomerDoc() {
        return customerDoc;
    }

    public void setCustomerDoc(CustomerDocsBean customerDoc) {
        this.customerDoc = customerDoc;
    }

    public String getSignableContentCompleted() {
        return signableContentCompleted;
    }

    public void setSignableContentCompleted(String signableContentCompleted) {
        this.signableContentCompleted = signableContentCompleted;
    }

    public Long getDocModelId() {
        return docModelId;
    }

    public void setDocModelId(Long docModelId) {
        this.docModelId = docModelId;
    }
}
