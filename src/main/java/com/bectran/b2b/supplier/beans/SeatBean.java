/**
 * 
 */
package com.bectran.b2b.supplier.beans;

import java.io.Serializable;
import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI May 28, 2011 8:56:25 PM
 */
public class SeatBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    //
    private Long supplierId; // added to paypal custom field
    private Long becSubId;
    private String itemNumber; // same as plan code set up in paypal
    private String itemName;
    private String buttonId;
    private String profileId;
    private double grossAmount;
    private Date lastUpdate;
    private String transactionType; // SUBSCR, PAYMENT, ETC
    private String seatType = MatrixConstants.SEAT_TYPE_PAYMENT;
    //
    private String subStatus = MatrixConstants.STATUS_ACTIVE; // ACTIVE or
                                                              // INACTIVE
    private String assignedStatus = MatrixConstants.ANSWER_NO;// YES or NO
    //
    private double amountPaid;
    private Date lastPaymentDate;
    //
    protected boolean seatIsCourtesy;

    public SeatBean() {
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getBecSubId() {
        return becSubId;
    }

    public void setBecSubId(Long becSubId) {
        this.becSubId = becSubId;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public double getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(double grossAmount) {
        this.grossAmount = grossAmount;
    }

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getAssignedStatus() {
        return assignedStatus;
    }

    public void setAssignedStatus(String assignedStatus) {
        this.assignedStatus = assignedStatus;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getLastPaymentDate() {
        return (Date) (lastPaymentDate == null ? null : lastPaymentDate.clone());
    }

    public void setLastPaymentDate(Date lastPaymentDate) {
        this.lastPaymentDate = (Date) (lastPaymentDate == null ? null : lastPaymentDate.clone());
    }

    public boolean isSeatIsCourtesy() {
        return (this.getSeatType().trim()
                .equals(MatrixConstants.SEAT_TYPE_COURTESY)) ? true : false;
    }

    public void setSeatIsCourtesy(boolean seatIsCourtesy) {
        this.seatIsCourtesy = seatIsCourtesy;
    }
}
