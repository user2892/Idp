/**
 * 
 */
package com.bectran.b2b.supplier.beans;

import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI Mar 20, 2011 5:10:05 PM
 */
public class OptionalPackageBean {
    private Long id;
    private Long supplierId;
    private String upgradeFailed = MatrixConstants.ANSWER_NO;
    private Date upgradeFailedDate;
    private Date dateCreated;
    private double cost;
    //

    public OptionalPackageBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getUpgradeFailed() {
        return upgradeFailed;
    }

    public void setUpgradeFailed(String upgradeFailed) {
        this.upgradeFailed = upgradeFailed;
    }

    public Date getUpgradeFailedDate() {
        return (Date) (upgradeFailedDate == null ? null : upgradeFailedDate.clone());
    }

    public void setUpgradeFailedDate(Date upgradeFailedDate) {
        this.upgradeFailedDate = (Date) (upgradeFailedDate == null ? null : upgradeFailedDate.clone());
    }

    public Date getDateCreated() {
        return (Date) (dateCreated == null ? null : dateCreated.clone());
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = (Date) (dateCreated == null ? null : dateCreated.clone());
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isFailedState() {
        return this.upgradeFailed.trim().equals(MatrixConstants.ANSWER_YES)
                ? true : false;
    }

}
