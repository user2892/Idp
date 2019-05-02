package com.bectran.b2b.customer.beans;

import java.sql.Timestamp;

/**
 * @author Louis Ifeguni Jan 30, 2007: 1:19:23 PM
 */
public class ContactInfoBaseBean {
    //
    // public static final String CONTACT_DETAIL_TYPE_CUSTOMER = "CUSTOMER";
    // public static final String CONTACT_DETAIL_TYPE_TRADE_REFERENCE =
    // "TRADE_REFERENCE";
    //
    protected String acctNum = "";
    protected String name = "";
    protected String refree = "";
    protected String contactType = "";
    protected String address1 = "";
    protected String address2 = "";
    protected String city = "";
    protected String state = "";
    protected String country = "US"; // INITIALIZED-COUNTRY CODE
    protected String zip = "";
    protected String phoneNum = "";
    protected String faxNum = "";
    protected String email = "";
    protected String webAddress = "";
    protected Timestamp lastUpdate;
    private String clientUpdateFlag = "";// set to 'YES' if change needs to be
                                         // updated in client's database
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
     * @return Returns the address1.
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * @param address1
     *            The address1 to set.
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * @return Returns the address2.
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2
     *            The address2 to set.
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
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
     * @return Returns the country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     *            The country to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return Returns the lastUpdate.
     */
    public Timestamp getLastUpdate() {
        return (Timestamp) (lastUpdate == null ? null : lastUpdate.clone());
    }

    /**
     * @param lastUpdate
     *            The dateCreated to set.
     */
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = (Timestamp) (lastUpdate == null ? null : lastUpdate.clone());
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
     * @return Returns the faxNum.
     */
    public String getFaxNum() {
        return faxNum;
    }

    /**
     * @param faxNum
     *            The faxNum to set.
     */
    public void setFaxNum(String faxNum) {
        this.faxNum = faxNum;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the phoneNum.
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param phoneNum
     *            The phoneNum to set.
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * @return Returns the refree.
     */
    public String getRefree() {
        return refree;
    }

    /**
     * @param refree
     *            The refree to set.
     */
    public void setRefree(String refree) {
        this.refree = refree;
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
     * @return Returns the webAddress.
     */
    public String getWebAddress() {
        return webAddress;
    }

    /**
     * @param webAddress
     *            The webAddress to set.
     */
    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    /**
     * @return Returns the zip.
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip
     *            The zip to set.
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getClientUpdateFlag() {
        return clientUpdateFlag;
    }

    public void setClientUpdateFlag(String clientUpdateFlag) {
        this.clientUpdateFlag = clientUpdateFlag;
    }
}
