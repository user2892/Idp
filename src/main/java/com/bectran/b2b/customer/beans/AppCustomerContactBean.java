package com.bectran.b2b.customer.beans;

import com.bectran.b2b.base.beans.CustomerBaseBean;

/**
 * @author LOUIS IFEGUNI
 */
public class AppCustomerContactBean extends CustomerBaseBean {
    private Long requestId;

    public AppCustomerContactBean() {
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
}
