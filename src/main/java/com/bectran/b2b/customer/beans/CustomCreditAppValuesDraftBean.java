/**
 * 
 */
package com.bectran.b2b.customer.beans;

/**
 * @author LOUIS IFEGUNI Date: Apr 5, 2012 / 2:53:26 PM
 */
public class CustomCreditAppValuesDraftBean
        extends CustomCreditAppValuesBaseBean {
    //
    private Long headerId;
    private String draftId;

    //
    public CustomCreditAppValuesDraftBean() {
    }

    //
    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getDraftId() {
        return draftId;
    }

    public void setDraftId(String draftId) {
        this.draftId = draftId;
    }
}
