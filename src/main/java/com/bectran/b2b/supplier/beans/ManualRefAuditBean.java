package com.bectran.b2b.supplier.beans;

import java.util.Date;

/**
 * @author LOUIS IFEGUNI
 */
public class ManualRefAuditBean {
    private Long crolRefReqId;
    private Long supplierId;
    private String userId;
    private Date lastUpdate;
    private Long creditRefHeaderId;
    //
    private SupplierUserBean officer;
    //

    public ManualRefAuditBean() {
    }

    public Long getCrolRefReqId() {
        return crolRefReqId;
    }

    public void setCrolRefReqId(Long crolRefReqId) {
        this.crolRefReqId = crolRefReqId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public SupplierUserBean getOfficer() {
        return officer;
    }

    public void setOfficer(SupplierUserBean officer) {
        this.officer = officer;
    }

    public Long getCreditRefHeaderId() {
        return creditRefHeaderId;
    }

    public void setCreditRefHeaderId(Long creditRefHeaderId) {
        this.creditRefHeaderId = creditRefHeaderId;
    }
}
