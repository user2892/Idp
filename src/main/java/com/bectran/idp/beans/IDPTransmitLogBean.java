package com.bectran.idp.beans;

import java.util.Date;

public class IDPTransmitLogBean {
    private Long requestId;
    private String transmittedFlag;
    private Date lastUpdate;
    private Long groupId;
    private Long supplierId;
    private String processFlag;
    private Integer retryCount;
    

    /**
     * @return Returns the requestId.
     */
    public Long getRequestId() {
        return requestId;
    }

    /**
     * @param requestId
     *            The requestId to set.
     */
    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    /**
     * @return Returns the transmittedFlag.
     */
    public String getTransmittedFlag() {
        return transmittedFlag;
    }

    /**
     * @param transmittedFlag
     *            The transmittedFlag to set.
     */
    public void setTransmittedFlag(String transmittedFlag) {
        this.transmittedFlag = transmittedFlag;
    }

    /**
     * @return Returns the lastUpdate.
     */
    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    /**
     * @param lastUpdate
     *            The lastUpdate to set.
     */
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    /**
     * @return Returns the groupId.
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * @param groupId The groupId to set.
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * @return Returns the supplierId.
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId The supplierId to set.
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * @return Returns the processFlag.
     */
    public String getProcessFlag() {
        return processFlag;
    }

    /**
     * @param processFlag The processFlag to set.
     */
    public void setProcessFlag(String processFlag) {
        this.processFlag = processFlag;
    }

    /**
     * @return Returns the retryCount.
     */
    public Integer getRetryCount() {
        return retryCount;
    }

    /**
     * @param retryCount The retryCount to set.
     */
    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }
    
}
