package com.bectran.b2b.customer.beans;

import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author Louis Ifeguni Aug 8, 2007: 5:16:45 PM
 */
public class AcctRefereeBean {
    private Long refereeId;
    private Long refereeContactId;
    private String acctNum;
    private Date lastUpdate;
    private boolean selected = true;
    // active or in-active - useful for list maintenance
    private String refereeStatus = MatrixConstants.STATUS_ACTIVE;
    RefereeBean referee; // hibernate
    RefContactBean refereeContact; // hibernate
    private Long id; // hibernate

    /**
     * DEFAULT CONSTRUCTOR
     */
    public AcctRefereeBean() {
    }

    /**
     * @return Returns the acctNum.
     */
    public String getAcctNum() {
        return acctNum;
    }

    /**
     * @param acctNum
     *            The acctNum to set.
     */
    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    /**
     * @return Returns the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return Returns the referee.
     */
    public RefereeBean getReferee() {
        return referee;
    }

    /**
     * @param referee
     *            The referee to set.
     */
    public void setReferee(RefereeBean referee) {
        this.referee = referee;
    }

    /**
     * @return Returns the refereeContact.
     */
    public RefContactBean getRefereeContact() {
        return refereeContact;
    }

    /**
     * @param refereeContact
     *            The refereeContact to set.
     */
    public void setRefereeContact(RefContactBean refereeContact) {
        this.refereeContact = refereeContact;
    }

    /**
     * @return Returns the refereeContactId.
     */
    public Long getRefereeContactId() {
        return refereeContactId;
    }

    /**
     * @param refereeContactId
     *            The refereeContactId to set.
     */
    public void setRefereeContactId(Long refereeContactId) {
        this.refereeContactId = refereeContactId;
    }

    /**
     * @return Returns the refereeId.
     */
    public Long getRefereeId() {
        return refereeId;
    }

    /**
     * @param refereeId
     *            The refereeId to set.
     */
    public void setRefereeId(Long refereeId) {
        this.refereeId = refereeId;
    }

    /**
     * @return Returns the refereeStatus.
     */
    public String getRefereeStatus() {
        return refereeStatus;
    }

    /**
     * @param refereeStatus
     *            The refereeStatus to set.
     */
    public void setRefereeStatus(String refereeStatus) {
        this.refereeStatus = refereeStatus;
    }

    /**
     * @return Returns the selected.
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected
     *            The selected to set.
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
