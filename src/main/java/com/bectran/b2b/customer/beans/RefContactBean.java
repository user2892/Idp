package com.bectran.b2b.customer.beans;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 * @Date Feb 21, 2007:10:42:54 AM
 */
public class RefContactBean extends ContactPersonBaseBean {
    private String referenceType = "";
    private String confirmEmail = "";
    private Long refId;
    private String internalAcctNum;
    private String accountType;
    private String signatory;
    private Long id;

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
    public RefContactBean() {
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the refId.
     */
    public Long getRefId() {
        return refId;
    }

    /**
     * @param refId
     *            The refId to set.
     */
    public void setRefId(Long refId) {
        this.refId = refId;
    }

    /**
     * @return Returns the referenceType.
     */
    public String getReferenceType() {
        return referenceType;
    }

    /**
     * @param referenceType
     *            The referenceType to set.
     */
    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    /**
     * @return Returns the hasEmail.
     */
    public boolean isHasEmail() {
        if (this.getEmail() != null && this.getEmail().trim().length() > 1) {
            return true;
        }
        return false;
    }


    /**
     * @return Returns the hasFax.
     */
    public boolean isHasFax() {
        if (this.getFax() != null && this.getFax().trim().length() > 1) {
            return true;
        }
        return false;
    }

    /**
     * @return Returns the hasPhone.
     */
    public boolean isHasPhone() {
        if (this.getPhone() != null && this.getPhone().trim().length() > 1) {
            return true;
        }
        return false;
    }

    /**
     * @return Returns the confirmEmail.
     */
    public String getConfirmEmail() {
        return confirmEmail;
    }

    /**
     * @param confirmEmail
     *            The confirmEmail to set.
     */
    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getInternalAcctNum() {
        return internalAcctNum;
    }

    public void setInternalAcctNum(String internalAcctNum) {
        this.internalAcctNum = internalAcctNum;
    }

    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }

    public boolean isBankRefef() {
        if (this.getReferenceType().equals(MatrixConstants.BANK)) {
            return true;
        }
        return false;
    }

}
