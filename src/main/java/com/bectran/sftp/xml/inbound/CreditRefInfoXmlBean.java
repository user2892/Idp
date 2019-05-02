/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.sftp.xml.inbound;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Shanmu
 * @date Nov 23, 2015 8:19:26 PM
 */
@XmlType(propOrder = {"companyName", "addressLineOne", "addressLineTwo", "city",
        "state", "countryId", "zipCode", "firstName", "lastName", "phone",
        "email", "fax", "referenceType", "internalAcctNum", "accountType",
        "status", "creditRefAttrInfoList"})
public class CreditRefInfoXmlBean {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String companyName;
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String state;
    private String countryId;
    private String zipCode;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String fax;
    private String referenceType;
    private String internalAcctNum;
    private String accountType;
    private String status;
    private List<CreditRefAttrInfoXmlBean> creditRefAttrInfoList;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>CreditReferenceInfoXmlBean</code>
     */
    public CreditRefInfoXmlBean() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
    /**
     * @return Returns the companyName.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     *            The companyName to set.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return Returns the addressLineOne.
     */
    public String getAddressLineOne() {
        return addressLineOne;
    }

    /**
     * @param addressLineOne
     *            The addressLineOne to set.
     */
    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    /**
     * @return Returns the addressLineTwo.
     */
    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    /**
     * @param addressLineTwo
     *            The addressLineTwo to set.
     */
    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    /**
     * @return Returns the city.
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     *            The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return Returns the state.
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     *            The state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return Returns the countryId.
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * @param countryId
     *            The countryId to set.
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    /**
     * @return Returns the zipCode.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode
     *            The zipCode to set.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return Returns the firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            The firstName to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return Returns the lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            The lastName to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Returns the phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     *            The phone to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return Returns the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Returns the fax.
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax
     *            The fax to set.
     */
    public void setFax(String fax) {
        this.fax = fax;
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
     * @return Returns the internalAcctNum.
     */
    public String getInternalAcctNum() {
        return internalAcctNum;
    }

    /**
     * @param internalAcctNum
     *            The internalAcctNum to set.
     */
    public void setInternalAcctNum(String internalAcctNum) {
        this.internalAcctNum = internalAcctNum;
    }

    /**
     * @return Returns the accountType.
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType
     *            The accountType to set.
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return Returns the status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     *            The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return Returns the creditRefAttrInfoList.
     */
    @XmlElementWrapper(name = "credit-reference-response-info")
    @XmlElement(name = "entry")
    public List<CreditRefAttrInfoXmlBean> getCreditRefAttrInfoList() {
        return creditRefAttrInfoList;
    }

    /**
     * @param creditRefAttrInfoList
     *            The creditRefAttrInfoList to set.
     */
    public void setCreditRefAttrInfoList(List<CreditRefAttrInfoXmlBean> creditRefAttrInfoList) {
        this.creditRefAttrInfoList = creditRefAttrInfoList;
    }
}
