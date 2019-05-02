package com.bectran.b2b.crol.beans;

import com.bectran.b2b.supplier.beans.CompanyInfoBaseBean;

/**
 * @author LOUIS IFEGUNI Jun 24, 2006:12:39:22 PM
 */
public class CorpBean extends CompanyInfoBaseBean {
    private String customerDBAName = "";

    /**
     * DEFAULT CONSTRUCTOR
     */
    public CorpBean() {
    }

    public String getCustomerDBAName() {
        return customerDBAName;
    }

    public void setCustomerDBAName(String customerDBAName) {
        this.customerDBAName = customerDBAName;
    }
}
