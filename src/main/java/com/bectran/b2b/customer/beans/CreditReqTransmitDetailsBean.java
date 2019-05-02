/**
 * Bectran Inc. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.b2b.customer.beans;

import java.io.Serializable;
import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;
/**
 * @author santhosh
 * @date 11-May-2017 3:18:10 pm
 */
public class CreditReqTransmitDetailsBean implements Serializable {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -4883566644804835578L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long headerId;
    private String transmitEnabled =  MatrixConstants.ANSWER_NO;
    private String transmitStatus = MatrixConstants.ANSWER_NO;
    private Date transmitDate;
    private String transmitMode;

    // ------------------------------------------------------------ Constructors
    /**
     * @return Returns the headerId.
     */
    public Long getHeaderId() {
        return headerId;
    }

    /**
     * @param headerId
     *            The headerId to set.
     */
    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    /**
     * Create a new <code>CreditReqAddnAttrsBean</code>
     */
    public CreditReqTransmitDetailsBean() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    public boolean isTransmittedBoo() {
        if (getTransmitDate() != null) {
            return true;
        }
        return false;
    }

    /**
     * @return Returns the transmitEnabled.
     */
    public String getTransmitEnabled() {
        return transmitEnabled;
    }

    /**
     * @param transmitEnabled
     *            The transmitEnabled to set.
     */
    public void setTransmitEnabled(String transmitEnabled) {
        this.transmitEnabled = transmitEnabled;
    }

    /**
     * @return Returns the transmitStatus.
     */
    public String getTransmitStatus() {
        return transmitStatus;
    }

    /**
     * @param transmitStatus
     *            The transmitStatus to set.
     */
    public void setTransmitStatus(String transmitStatus) {
        this.transmitStatus = transmitStatus;
    }

    /**
     * @return Returns the transmitDate.
     */
    public Date getTransmitDate() {
        return transmitDate;
    }

    /**
     * @param transmitDate
     *            The transmitDate to set.
     */
    public void setTransmitDate(Date transmitDate) {
        this.transmitDate = transmitDate;
    }

    /**
     * @return Returns the transmitMode.
     */
    public String getTransmitMode() {
        return transmitMode;
    }

    /**
     * @param transmitMode
     *            The transmitMode to set.
     */
    public void setTransmitMode(String transmitMode) {
        this.transmitMode = transmitMode;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
