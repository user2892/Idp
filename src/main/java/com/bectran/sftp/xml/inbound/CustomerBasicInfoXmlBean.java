/**
 * 
 */
package com.bectran.sftp.xml.inbound;

import javax.xml.bind.annotation.XmlType;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 2, 2013 : 8:17:48 PM
 */
@XmlType(propOrder = {"addressLineOne", "addressLineTwo", "annualSalesRange",
        "bectranCustomerId", "city", "contactPersonFirstName",
        "contactPersonLastName", "contactPersonPhone", "contactPersonTitle",
        "countryId", "customerDbaName", "customerLegalName",
        "dateCreatedInBectran", "dunsNumber", "fax", "federalTaxId",
        "numOfEmployee", "phone", "state", "stateOfIncorporation",
        "styleOfBusiness", "typeOfBusiness", "yearEstablished", "zipCode",
        "contactPersonEmail"})
public class CustomerBasicInfoXmlBean {
    private String addressLineOne;
    private String addressLineTwo;
    private String annualSalesRange;
    private String bectranCustomerId;
    private String city;
    private String contactPersonFirstName;
    private String contactPersonLastName;
    private String contactPersonPhone;
    private String contactPersonTitle;
    private String countryId;
    private String customerDbaName;
    private String customerLegalName;
    private String dateCreatedInBectran;
    private String dunsNumber;
    private String fax;
    private String federalTaxId;
    private String numOfEmployee;
    private String phone;
    private String state;
    private String stateOfIncorporation;
    private String styleOfBusiness;
    private String typeOfBusiness;
    private String yearEstablished;
    private String zipCode;
    private String contactPersonEmail;

    //
    /**
     * @return the addressLineOne
     */
    public String getAddressLineOne() {
        return addressLineOne;
    }

    /**
     * @param addressLineOne
     *            the addressLineOne to set
     */
    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    /**
     * @return the addressLineTwo
     */
    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    /**
     * @param addressLineTwo
     *            the addressLineTwo to set
     */
    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    /**
     * @return the annualSalesRange
     */
    public String getAnnualSalesRange() {
        return annualSalesRange;
    }

    /**
     * @param annualSalesRange
     *            the annualSalesRange to set
     */
    public void setAnnualSalesRange(String annualSalesRange) {
        this.annualSalesRange = annualSalesRange;
    }

    /**
     * @return the bectranCustomerId
     */
    public String getBectranCustomerId() {
        return bectranCustomerId;
    }

    /**
     * @param bectranCustomerId
     *            the bectranCustomerId to set
     */
    public void setBectranCustomerId(String bectranCustomerId) {
        this.bectranCustomerId = bectranCustomerId;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the contactPersonFirstName
     */
    public String getContactPersonFirstName() {
        return contactPersonFirstName;
    }

    /**
     * @param contactPersonFirstName
     *            the contactPersonFirstName to set
     */
    public void setContactPersonFirstName(String contactPersonFirstName) {
        this.contactPersonFirstName = contactPersonFirstName;
    }

    /**
     * @return the contactPersonLastName
     */
    public String getContactPersonLastName() {
        return contactPersonLastName;
    }

    /**
     * @param contactPersonLastName
     *            the contactPersonLastName to set
     */
    public void setContactPersonLastName(String contactPersonLastName) {
        this.contactPersonLastName = contactPersonLastName;
    }

    /**
     * @return the contactPersonPhone
     */
    public String getContactPersonPhone() {
        return contactPersonPhone;
    }

    /**
     * @param contactPersonPhone
     *            the contactPersonPhone to set
     */
    public void setContactPersonPhone(String contactPersonPhone) {
        this.contactPersonPhone = contactPersonPhone;
    }

    /**
     * @return the contactPersonTitle
     */
    public String getContactPersonTitle() {
        return contactPersonTitle;
    }

    /**
     * @param contactPersonTitle
     *            the contactPersonTitle to set
     */
    public void setContactPersonTitle(String contactPersonTitle) {
        this.contactPersonTitle = contactPersonTitle;
    }

    /**
     * @return the countryId
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * @param countryId
     *            the countryId to set
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    /**
     * @return the customerDbaName
     */
    public String getCustomerDbaName() {
        return customerDbaName;
    }

    /**
     * @param customerDbaName
     *            the customerDbaName to set
     */
    public void setCustomerDbaName(String customerDbaName) {
        this.customerDbaName = customerDbaName;
    }

    /**
     * @return the customerLegalName
     */
    public String getCustomerLegalName() {
        return customerLegalName;
    }

    /**
     * @param customerLegalName
     *            the customerLegalName to set
     */
    public void setCustomerLegalName(String customerLegalName) {
        this.customerLegalName = customerLegalName;
    }

    /**
     * @return the dateCreatedInBectran
     */
    public String getDateCreatedInBectran() {
        return dateCreatedInBectran;
    }

    /**
     * @param dateCreatedInBectran
     *            the dateCreatedInBectran to set
     */
    public void setDateCreatedInBectran(String dateCreatedInBectran) {
        this.dateCreatedInBectran = dateCreatedInBectran;
    }

    /**
     * @return the dunsNumber
     */
    public String getDunsNumber() {
        return dunsNumber;
    }

    /**
     * @param dunsNumber
     *            the dunsNumber to set
     */
    public void setDunsNumber(String dunsNumber) {
        this.dunsNumber = dunsNumber;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax
     *            the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the federalTaxId
     */
    public String getFederalTaxId() {
        return federalTaxId;
    }

    /**
     * @param federalTaxId
     *            the federalTaxId to set
     */
    public void setFederalTaxId(String federalTaxId) {
        this.federalTaxId = federalTaxId;
    }

    /**
     * @return the numOfEmployee
     */
    public String getNumOfEmployee() {
        return numOfEmployee;
    }

    /**
     * @param numOfEmployee
     *            the numOfEmployee to set
     */
    public void setNumOfEmployee(String numOfEmployee) {
        this.numOfEmployee = numOfEmployee;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     *            the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the stateOfIncorporation
     */
    public String getStateOfIncorporation() {
        return stateOfIncorporation;
    }

    /**
     * @param stateOfIncorporation
     *            the stateOfIncorporation to set
     */
    public void setStateOfIncorporation(String stateOfIncorporation) {
        this.stateOfIncorporation = stateOfIncorporation;
    }

    /**
     * @return the styleOfBusiness
     */
    public String getStyleOfBusiness() {
        return styleOfBusiness;
    }

    /**
     * @param styleOfBusiness
     *            the styleOfBusiness to set
     */
    public void setStyleOfBusiness(String styleOfBusiness) {
        this.styleOfBusiness = styleOfBusiness;
    }

    /**
     * @return the typeOfBusiness
     */
    public String getTypeOfBusiness() {
        return typeOfBusiness;
    }

    /**
     * @param typeOfBusiness
     *            the typeOfBusiness to set
     */
    public void setTypeOfBusiness(String typeOfBusiness) {
        this.typeOfBusiness = typeOfBusiness;
    }

    /**
     * @return the yearEstablished
     */
    public String getYearEstablished() {
        return yearEstablished;
    }

    /**
     * @param yearEstablished
     *            the yearEstablished to set
     */
    public void setYearEstablished(String yearEstablished) {
        this.yearEstablished = yearEstablished;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode
     *            the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }
}
