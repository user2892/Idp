/**
 * 
 */
package com.bectran.b2b.enterprise.beans;

import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * LOUIS IFEGUNI Apr 12, 2016 / 7:51:01 AM zs_ws_data_load_tracker
 */
public class WsDataLoadTrackerBean {
    private Long id;
    private Long supplierId;
    private Long groupId;
    private String txnCode;
    private String confirmedStatus = MatrixConstants.ANSWER_NO;
    private int numberOfRec;
    private int numberOfBatch;
    private String cusDataType;
    private Date startTime;
    private Date endTime;

    //
    public WsDataLoadTrackerBean() {
    }
    //

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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getTxnCode() {
        return txnCode;
    }

    public void setTxnCode(String txnCode) {
        this.txnCode = txnCode;
    }

    public String getConfirmedStatus() {
        return confirmedStatus;
    }

    public void setConfirmedStatus(String confirmedStatus) {
        this.confirmedStatus = confirmedStatus;
    }

    public int getNumberOfRec() {
        return numberOfRec;
    }

    public void setNumberOfRec(int numberOfRec) {
        this.numberOfRec = numberOfRec;
    }

    public int getNumberOfBatch() {
        return numberOfBatch;
    }

    public void setNumberOfBatch(int numberOfBatch) {
        this.numberOfBatch = numberOfBatch;
    }

    public String getCusDataType() {
        return cusDataType;
    }

    public void setCusDataType(String cusDataType) {
        this.cusDataType = cusDataType;
    }

    public Date getStartTime() {
        return (Date) (startTime == null ? null : startTime.clone());
    }

    public void setStartTime(Date startTime) {
        this.startTime = (Date) (startTime == null ? null : startTime.clone());
    }

    public Date getEndTime() {
        return (Date) (endTime == null ? null : endTime.clone());
    }

    public void setEndTime(Date endTime) {
        this.endTime = (Date) (endTime == null ? null : endTime.clone());
    }
}
