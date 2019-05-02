package com.bectran.b2b.supplier.beans;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.crol.constants.CrolConstants;
import com.bectran.matrix.utils.IndustrySector;

/**
 * @author LOUIS IFEGUNI
 */
public class CompanyInfoBaseBean {
    //
    private String sizeCategory = "";
    //
    private Long id;
    private String orgType = "";
    private String corpName = "";
    private String corpID = "";
    private String orgPassCode = "";
    private String addressLineOne = "";
    private String addressLineTwo = "";
    private String registrationStatus = "";
    private String city = "";
    private String state = "";
    private String zipCode = "";
    private String countryId = "US"; // initialize to United States
    private String countryName = "";
    private String orgMainEmail = "";
    private String updateMode = "NO";
    private String updateMessage = "";
    private String customerSearchMessage = "";
    private Timestamp lastUpdate;
    private Timestamp dateSignedUp;
    //
    private String tickerSymbol = "";
    private String exchange = "NONE";
    private String annualSalesRange = "";
    private String annualSalesRangeID = "00";
    //
    private String bankAndFinInst = CrolConstants.NO;
    private String sectorId = IndustrySector.NONE; // initialization
    private String sectorName = "";
    private String industryId = "";
    private String industryName = "";
    private String orgMainPhone = "";
    private String orgMainFax = "";
    private String orgUrl = "";
    //
    private List usersInCompany;
    private String companyInfo = "";
    //
    private String inOrOutNetFlag = "";
    //
    protected PricingBean pricingBean;
    private String pageFlowToken = "";
    /*
     * The domain name is extracted from the user e-mail address and it is used
     * as additional identification for the company. Every company has a unique
     * domain name, this is implemented as unique for a company per country
     * location
     */
    private String domainName = "";
    // free subscription info
    private int trialDays;
    private Date trialExpiration;
    private String trialPeriodCoupon;
    //
    private String setupProgress = MatrixConstants.SETUP_PROGRESS_NONE;
    private String numberOfCreditApp;
    // private UserBean refereeContact;

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
     * @return Returns the corpID.
     */
    public String getCorpID() {
        return corpID;
    }

    /**
     * @param corpID
     *            The corpID to set.
     */
    public void setCorpID(String corpID) {
        this.corpID = corpID;
    }

    /**
     * @return Returns the corpName.
     */
    public String getCorpName() {
        return corpName;
    }

    /**
     * @param corpName
     *            The corpName to set.
     */
    public void setCorpName(String corpName) {
        this.corpName = corpName;
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
     * @return Returns the countryName.
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName
     *            The countryName to set.
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return Returns the orgMainEmail.
     */
    public String getOrgMainEmail() {
        return orgMainEmail;
    }

    /**
     * @param orgMainEmail
     *            The orgMainEmail to set.
     */
    public void setOrgMainEmail(String orgMainEmail) {
        this.orgMainEmail = orgMainEmail;
    }

    /**
     * @return Returns the orgType.
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * @param orgType
     *            The orgType to set.
     */
    public void setOrgType(String orgType) {
        this.orgType = orgType;
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
     * @return Returns the orgPassCode.
     */
    public String getOrgPassCode() {
        return orgPassCode;
    }

    /**
     * @param orgPassCode
     *            The orgPassCode to set.
     */
    public void setOrgPassCode(String orgPassCode) {
        this.orgPassCode = orgPassCode;
    }

    /**
     * @return Returns the updateMessage.
     */
    public String getUpdateMessage() {
        return updateMessage;
    }

    /**
     * @param updateMessage
     *            The updateMessage to set.
     */
    public void setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage;
    }

    /**
     * @return Returns the updateMode.
     */
    public String getUpdateMode() {
        return updateMode;
    }

    /**
     * @param updateMode
     *            The updateMode to set.
     */
    public void setUpdateMode(String updateMode) {
        this.updateMode = updateMode;
    }

    /**
     * @return Returns the registrationStatus.
     */
    public String getRegistrationStatus() {
        return registrationStatus;
    }

    /**
     * @param registrationStatus
     *            The registrationStatus to set.
     */
    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
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
     * @return Returns the bankAndFinInst.
     */
    public String getBankAndFinInst() {
        return bankAndFinInst;
    }

    /**
     * @param bankAndFinInst
     *            The bankAndFinInst to set.
     */
    public void setBankAndFinInst(String bankAndFinInst) {
        this.bankAndFinInst = bankAndFinInst;
    }

    /**
     * @return Returns the industryId.
     */
    public String getIndustryId() {
        return industryId;
    }

    /**
     * @param industryId
     *            The industryId to set.
     */
    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }

    /**
     * @return Returns the industryName.
     */
    public String getIndustryName() {
        return industryName;
    }

    /**
     * @param industryName
     *            The industryName to set.
     */
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    /**
     * @return Returns the orgMainPhone.
     */
    public String getOrgMainPhone() {
        return orgMainPhone;
    }

    /**
     * @param orgMainPhone
     *            The orgMainPhone to set.
     */
    public void setOrgMainPhone(String orgMainPhone) {
        this.orgMainPhone = orgMainPhone;
    }

    /**
     * @return Returns the orgUrl.
     */
    public String getOrgUrl() {
        return orgUrl;
    }

    /**
     * @param orgUrl
     *            The orgUrl to set.
     */
    public void setOrgUrl(String orgUrl) {
        this.orgUrl = orgUrl;
    }

    /**
     * @return Returns the sectorId.
     */
    public String getSectorId() {
        if (this.sectorId == null || this.sectorId.trim().length() < 1) {
            sectorId = IndustrySector.NONE;
        }
        return sectorId;
    }

    /**
     * @param sectorId
     *            The sectorId to set.
     */
    public void setSectorId(String sectorId) {
        this.sectorId = sectorId;
    }

    /**
     * @return Returns the sectorName.
     */
    public String getSectorName() {
        return sectorName;
    }

    /**
     * @param sectorName
     *            The sectorName to set.
     */
    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    /**
     * @return Returns the dateSignedUp.
     */
    public Timestamp getDateSignedUp() {
        return (Timestamp) (dateSignedUp == null ? null : dateSignedUp.clone());
    }

    /**
     * @param dateSignedUp
     *            The dateSignedUp to set.
     */
    public void setDateSignedUp(Timestamp dateSignedUp) {
        this.dateSignedUp = (Timestamp) (dateSignedUp == null ? null : dateSignedUp.clone());
    }

    /**
     * @return Returns the registered.
     */
    public boolean isRegistered() {
        if (this.registrationStatus.trim()
                .equals(CrolConstants.STATUS_REGISTERED)) {
            return true;
        }
        return false;
    }

    /**
     * @return Returns the customerSearchMessage.
     */
    public String getCustomerSearchMessage() {
        return customerSearchMessage;
    }

    /**
     * @param customerSearchMessage
     *            The customerSearchMessage to set.
     */
    public void setCustomerSearchMessage(String customerSearchMessage) {
        this.customerSearchMessage = customerSearchMessage;
    }

    /**
     * @return Returns the inOrOutNetFlag.
     */
    public String getInOrOutNetFlag() {
        return inOrOutNetFlag;
    }

    /**
     * @param inOrOutNetFlag
     *            The inOrOutNetFlag to set.
     */
    public void setInOrOutNetFlag(String inOrOutNetFlag) {
        this.inOrOutNetFlag = inOrOutNetFlag;
    }

    /**
     * @return Returns the exchange.
     */
    public String getExchange() {
        return exchange;
    }

    /**
     * @param exchange
     *            The exchange to set.
     */
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    /**
     * @return Returns the tickerSymbol.
     */
    public String getTickerSymbol() {
        return tickerSymbol;
    }

    /**
     * @param tickerSymbol
     *            The tickerSymbol to set.
     */
    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    /**
     * @return Returns the annualSalesRange.
     */
    public String getAnnualSalesRange() {
        return annualSalesRange;
    }

    /**
     * @param annualSalesRange
     *            The annualSalesRange to set.
     */
    public void setAnnualSalesRange(String annualSalesRange) {
        this.annualSalesRange = annualSalesRange;
    }

    /**
     * @return Returns the annualSalesRangeID.
     */
    public String getAnnualSalesRangeID() {
        return annualSalesRangeID;
    }

    /**
     * @param annualSalesRangeID
     *            The annualSalesRangeID to set.
     */
    public void setAnnualSalesRangeID(String annualSalesRangeID) {
        this.annualSalesRangeID = annualSalesRangeID;
    }

    /**
     * @return Returns the pageFlowToken.
     */
    public String getPageFlowToken() {
        return pageFlowToken;
    }

    /**
     * @param pageFlowToken
     *            The pageFlowToken to set.
     */
    public void setPageFlowToken(String pageFlowToken) {
        this.pageFlowToken = pageFlowToken;
    }

    /**
     * @return Returns the domainName.
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * @param domainName
     *            The domainName to set.
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    /**
     * @return Returns the usersInCompany.
     */
    public List getUsersInCompany() {
        return usersInCompany;
    }

    /**
     * @param usersInCompany
     *            The usersInCompany to set.
     */
    public void setUsersInCompany(List usersInCompany) {
        this.usersInCompany = usersInCompany;
    }

    /**
     * @return Returns the companyInfo.
     */
    public String getCompanyInfo() {
        return companyInfo;
    }

    /**
     * @param companyInfo
     *            The companyInfo to set.
     */
    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    /**
     * @return Returns the sizeCategory.
     */
    public String getSizeCategory() {
        return sizeCategory;
    }

    /**
     * @param sizeCategory
     *            The sizeCategory to set.
     */
    public void setSizeCategory(String sizeCategory) {
        this.sizeCategory = sizeCategory;
    }

    public int getTrialDays() {
        return trialDays;
    }

    public void setTrialDays(int trialDays) {
        this.trialDays = trialDays;
    }

    public Date getTrialExpiration() {
        return (Date) (trialExpiration == null ? null : trialExpiration.clone());
    }

    public void setTrialExpiration(Date trialExpiration) {
        this.trialExpiration = (Date) (trialExpiration == null ? null : trialExpiration.clone());
    }

    public String getTrialPeriodCoupon() {
        return trialPeriodCoupon;
    }

    public void setTrialPeriodCoupon(String trialPeriodCoupon) {
        this.trialPeriodCoupon = trialPeriodCoupon;
    }

    public String getOrgMainFax() {
        return orgMainFax;
    }

    public void setOrgMainFax(String orgMainFax) {
        this.orgMainFax = orgMainFax;
    }

    public PricingBean getPricingBean() {
        return pricingBean;
    }

    public void setPricingBean(PricingBean pricingBean) {
        this.pricingBean = pricingBean;
    }

    public String getSetupProgress() {
        return setupProgress;
    }

    public void setSetupProgress(String setupProgress) {
        this.setupProgress = setupProgress;
    }

    public String getNumberOfCreditApp() {
        return numberOfCreditApp;
    }

    public void setNumberOfCreditApp(String numberOfCreditApp) {
        this.numberOfCreditApp = numberOfCreditApp;
    }
}
