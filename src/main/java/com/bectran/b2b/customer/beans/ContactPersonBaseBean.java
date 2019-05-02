package com.bectran.b2b.customer.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author LOUIS IFEGUNI
 * @Date Feb 21, 2007:10:47:44 AM
 */
public class ContactPersonBaseBean {
    //
    // public static final String CONTACT_TYPE_CUSTOMER = "CUSTOMER";
    // public static final String CONTACT_TYPE_INHOUSE = "IN-HOUSE";
    //// public static final String CONTACT_TYPE_RISKMANAGER = "RISKMANAGER";
    // public static final String CATEGORY_PRIMARY_CONTACT = "PRIMARY";
    // public static final String CATEGORY_ORDINARY_CONTACT = "ORDINARY";
    protected String acctNum = "";
    // CONTACT PERSONS INFO - FIELDS USED SPECIFICALLY FOR CONTACT PERSONS
    protected String firstName = "";
    protected String lastName = "";
    protected String name = "";
    protected String nameLastFirst = "";
    protected String email = "";
    protected String fax = "";
    protected String phone = "";
    protected String persTitle = "";
    protected String titleDescription = "";
    protected String contactType = ""; // shipping, billing,accounts payable
    protected String department = "";
    protected String deptDescription = "";
    protected Timestamp lastUpdate;
    protected String salutation = "";
    //
    protected String addressLineOne = "";
    protected String addressLineTwo = "";
    protected String city = "";
    protected String state = "";
    protected String zipCode = "";
    protected String countryId = "US"; // initialize to United States
    protected String countryName = "";
    protected Date dateCreated;
    // owner-officer specific
    protected String socSecNum;
    protected double ownerPercentage;
    protected String driverLicense;
    protected Long requestId;
    protected Long id;
    public boolean updateOrDelete = false;

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
     * @return Returns the updateOrDelete.
     */
    public boolean isUpdateOrDelete() {
        return updateOrDelete;
    }

    /**
     * @param updateOrDelete
     *            The updateOrDelete to set.
     */
    public void setUpdateOrDelete(boolean updateOrDelete) {
        this.updateOrDelete = updateOrDelete;
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
     * @return Returns the contactType.
     */
    public String getContactType() {
        return contactType;
    }

    /**
     * @param contactType
     *            The contactType to set.
     */
    public void setContactType(String contactType) {
        this.contactType = contactType;
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
     * @return Returns the lastUpdate.
     */
    public Timestamp getLastUpdate() {
        return (Timestamp) (lastUpdate == null ? null : lastUpdate.clone());
    }

    /**
     * @param lastUpdate
     *            The lastUpdate to set.
     */
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = (Timestamp) (lastUpdate == null ? null : lastUpdate.clone());
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        name = this.firstName + " " + this.lastName + " (" + this.salutation
                + ")";
        return name;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getNameLastFirst() {
        nameLastFirst = this.lastName + ", " + this.firstName;
        return nameLastFirst;
    }

    public void setNameLastFirst(String nameLastFirst) {
        this.nameLastFirst = nameLastFirst;
    }

    /**
     * @return Returns the persTitle.
     */
    public String getPersTitle() {
        return persTitle;
    }

    /**
     * @param persTitle
     *            The persTitle to set.
     */
    public void setPersTitle(String persTitle) {
        this.persTitle = persTitle;
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
     * @return Returns the salutation.
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * @param salutation
     *            The salutation to set.
     */
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    /**
     * @return Returns the department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department
     *            The department to set.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDeptDescription() {
        return deptDescription;
    }

    public void setDeptDescription(String deptDescription) {
        this.deptDescription = deptDescription;
    }

    public String getTitleDescription() {
        return titleDescription;
    }

    public void setTitleDescription(String titleDescription) {
        this.titleDescription = titleDescription;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Date getDateCreated() {
        return (Date) (dateCreated == null ? null : dateCreated.clone());
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = (Date) (dateCreated == null ? null : dateCreated.clone());
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return Returns the addr2Present.
     */
    public boolean isAddr2Present() {
        if (this.getAddressLineTwo() != null
                && this.getAddressLineTwo().trim().length() > 1) {
            return true;
        }
        return false;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public double getOwnerPercentage() {
        return ownerPercentage;
    }

    public void setOwnerPercentage(double ownerPercentage) {
        this.ownerPercentage = ownerPercentage;
    }

    public String getSocSecNum() {
        return socSecNum;
    }

    public void setSocSecNum(String socSecNum) {
        this.socSecNum = socSecNum;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getNameNoSalutation() {
        // return nameNoSalutation;
        return this.firstName + " " + this.lastName;
    }
}
