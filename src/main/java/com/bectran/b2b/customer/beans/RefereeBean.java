package com.bectran.b2b.customer.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.matrix.utils.IndustrySector;

/**
 * @author Louis Ifeguni Jan 30, 2007: 1:22:57 PM
 */
public class RefereeBean extends ContactInfoBaseBean {
    private String name = "";
    private Long id;
    private String contactPerson = "";
    private RefContactBean refcontact;
    private boolean selected = true;
    private List refContactSel;
    //
    private String industryId = "";
    private String sectorId = IndustrySector.NONE;
    private String industryName = "";
    private String sectorName = "";
    /*
     * CROL SEPCIFIC
     */
    private String crolCompanyId = "";
    private String crolRegStatus = "";
    private boolean registeredForCrol = false;
    private boolean addInUpdateMode = false;
    private boolean assignedSector = false;
    private boolean infoNotInCrol;
    private String lockUpdate = MatrixConstants.ANSWER_NO;
    /*
     * hibernate
     */
    private Set<RefContactBean> refContactSET;

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
     * DEFAULT CONSTRUCTOR
     */
    public RefereeBean() {
    }

    /**
     * @return Returns the referee.
     */
    public String getName() {
        return name;
    }

    /**
     * @param referee
     *            The referee to set.
     */
    public void setName(String referee) {
        this.name = referee;
    }

    /**
     * @return Returns the contactPerson.
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * @param contactPerson
     *            The contactPerson to set.
     */
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    /**
     * @return Returns the refcontact.
     */
    public RefContactBean getRefcontact() {
        return refcontact;
    }

    /**
     * @param refcontact
     *            The refcontact to set.
     */
    public void setRefcontact(RefContactBean refcontact) {
        this.refcontact = refcontact;
    }

    /**
     * @return Returns the refContactSET.
     */
    public Set<RefContactBean> getRefContactSET() {
        return refContactSET;
    }

    /**
     * @param refContactSET
     *            The refContactSET to set.
     */
    public void setRefContactSET(Set<RefContactBean> refContactSET) {
        this.refContactSET = refContactSET;
    }

    /**
     * @return Returns the addr2Present.
     */
    public boolean isAddr2Present() {
        if (this.address2 != null && this.address2.trim().length() > 1) {
            return true;
        }
        return false;
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

    /**
     * @return Returns the refContactInList.
     */
    public List<RefContactBean> getRefContactInList() {
        List<RefContactBean> ls = new ArrayList<RefContactBean>();
        if (this.refContactSET == null) {
            return ls;
        }
        for (Iterator<RefContactBean> i = this.refContactSET.iterator(); i
                .hasNext();) {
            RefContactBean bean = (RefContactBean) i.next();
            ls.add(bean);
        }
        return ls;
    }

    /**
     * @return Returns the refContactSel.
     */
    public List getRefContactSel() {
        return refContactSel;
    }

    /**
     * @param refContactSel
     *            The refContactSel to set.
     */
    public void setRefContactSel(List refContactSel) {
        this.refContactSel = refContactSel;
    }

    /**
     * @return Returns the registeredForCrol.
     */
    public boolean isRegisteredForCrol() {
        return registeredForCrol;
    }

    /**
     * @param registeredForCrol
     *            The registeredForCrol to set.
     */
    public void setRegisteredForCrol(boolean registeredForCrol) {
        this.registeredForCrol = registeredForCrol;
    }

    /**
     * @return Returns the crolCompanyId.
     */
    public String getCrolCompanyId() {
        return crolCompanyId;
    }

    /**
     * @param crolCompanyId
     *            The crolCompanyId to set.
     */
    public void setCrolCompanyId(String crolCompanyId) {
        this.crolCompanyId = crolCompanyId;
    }

    /**
     * @return Returns the crolRegStatus.
     */
    public String getCrolRegStatus() {
        return crolRegStatus;
    }

    /**
     * @param crolRegStatus
     *            The crolRegStatus to set.
     */
    public void setCrolRegStatus(String crolRegStatus) {
        this.crolRegStatus = crolRegStatus;
    }

    /**
     * @return Returns the hasCrolID.
     */
    public boolean isHasCrolID() {
        try {
            if (this.crolCompanyId.trim().substring(0, 2).equals("TN")
                    && this.crolCompanyId.length() > 4) {
                return true;
            }
        }
        catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean isAddInUpdateMode() {
        return addInUpdateMode;
    }

    public void setAddInUpdateMode(boolean addInUpdateMode) {
        this.addInUpdateMode = addInUpdateMode;
    }

    public String getIndustryId() {
        return industryId;
    }

    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }

    public String getSectorId() {
        return sectorId;
    }

    public void setSectorId(String sectorId) {
        this.sectorId = sectorId;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public boolean isAssignedSector() {
        return assignedSector;
    }

    public void setAssignedSector(boolean assignedSector) {
        this.assignedSector = assignedSector;
    }

    public boolean isShowReadOnly() {
        if (this.isUpdateOrDelete() || this.isAssignedSector()) {
            return true;
        }
        return false;
    }

    public boolean isInfoNotInCrol() {
        return infoNotInCrol;
    }

    public void setInfoNotInCrol(boolean infoNotInCrol) {
        this.infoNotInCrol = infoNotInCrol;
    }

    public String getLockUpdate() {
        return lockUpdate;
    }

    public void setLockUpdate(String lockUpdate) {
        this.lockUpdate = lockUpdate;
    }

    public boolean isRefLocked() {
        if (this.getLockUpdate().trim().equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

}
