package com.bectran.b2b.customer.beans;

import java.util.Date;

/**
 * @author LOUIS IFEGUNI
 */
public class CustomerSupplierBean {
    private String customerAcctNum;
    private Long id;
    // private String supplierCompanyId;
    private Date lastUpdate;
    private Long supplierId;
    private String acctNumWithUs = "";

    public CustomerSupplierBean() {
    }

    public String getCustomerAcctNum() {
        return customerAcctNum;
    }

    public void setCustomerAcctNum(String acctNum) {
        this.customerAcctNum = acctNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getAcctNumWithUs() {
        return acctNumWithUs;
    }

    public void setAcctNumWithUs(String acctNumWithUs) {
        this.acctNumWithUs = acctNumWithUs;
    }
}
