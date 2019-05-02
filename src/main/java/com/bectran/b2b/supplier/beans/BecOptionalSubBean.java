/**
 * 
 */
package com.bectran.b2b.supplier.beans;

import java.io.Serializable;
import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 28, 2012 : 11:15:52 PM
 */
public class BecOptionalSubBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private Long supplierId;
    private String planCode = "";
    private String optionPlanCode;
    private Date beginingDate;
    private Date endDate;
    private Date lastUpdate;
    private double fullPrice = 0;
    private double amountPaid = 0;
    private double discount = 0;
    private String subStatus = MatrixConstants.STATUS_INACTIVE;
    private String description = "";
    //
    protected boolean activeStatus;
    private boolean expired;

    public BecOptionalSubBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getOptionPlanCode() {
        return optionPlanCode;
    }

    public void setOptionPlanCode(String optionPlanCode) {
        this.optionPlanCode = optionPlanCode;
    }

    public Date getBeginingDate() {
        return (Date) (beginingDate == null ? null : beginingDate.clone());
    }

    public void setBeginingDate(Date beginingDate) {
        this.beginingDate = (Date) (beginingDate == null ? null : beginingDate.clone());
    }

    public Date getEndDate() {
        return (Date) (endDate == null ? null : endDate.clone());
    }

    public void setEndDate(Date endDate) {
        this.endDate = (Date) (endDate == null ? null : endDate.clone());
    }

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActiveStatus() {
        return this.getSubStatus().trim().equals(MatrixConstants.STATUS_ACTIVE)
                ? true : false;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public boolean isExpired() {
        return this.getEndDate().before(new Date()) ? true : false;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
