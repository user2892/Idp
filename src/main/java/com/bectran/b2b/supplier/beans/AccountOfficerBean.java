/**
 * 
 */
package com.bectran.b2b.supplier.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LOUIS IFEGUNI Mar 5, 2011 8:32:29 AM
 */
public class AccountOfficerBean implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    private Long supplierId;
    private Long groupId; // business group id
    private String customerAcctNum;
    private Date dateAssigned;
    private String userId;
    //
    private SupplierUserBean officer;

    //
    public AccountOfficerBean() {
    }

    //
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getCustomerAcctNum() {
        return customerAcctNum;
    }

    public void setCustomerAcctNum(String customerAcctNum) {
        this.customerAcctNum = customerAcctNum;
    }

    public Date getDateAssigned() {
        return (Date) (dateAssigned == null ? null : dateAssigned.clone());
    }

    public void setDateAssigned(Date dateAssigned) {
        this.dateAssigned = (Date) (dateAssigned == null ? null : dateAssigned.clone());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public SupplierUserBean getOfficer() {
        return officer;
    }

    public void setOfficer(SupplierUserBean officer) {
        this.officer = officer;
    }
}
