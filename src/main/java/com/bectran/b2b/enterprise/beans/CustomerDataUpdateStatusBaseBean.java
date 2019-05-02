/**
 * 
 */
package com.bectran.b2b.enterprise.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Louis Ifeguni Jan 20, 2016:3:35:10 PM
 */
public class CustomerDataUpdateStatusBaseBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long supplierId;
    private String id;
    private int numberOfRec;
    private int numberOfBatch;
    private String cusDataType;
    private Date startTime;
    private Date endTime;

    //
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumberOfRec() {
        return numberOfRec;
    }

    public void setNumberOfRec(int numberOfRec) {
        this.numberOfRec = numberOfRec;
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

    public int getNumberOfBatch() {
        return numberOfBatch;
    }

    public void setNumberOfBatch(int numberOfBatch) {
        this.numberOfBatch = numberOfBatch;
    }
}
