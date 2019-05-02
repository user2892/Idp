package com.bectran.b2b.base.beans;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.customer.blo.CustomCreditAppValuesBLO;
import com.bectran.matrix.utils.IndustrySector;

/**
 * @author Louis Ifeguni
 * @date Jan 11, 2007: 4:15:21 PM
 */
public class CustomerBaseBean extends AcctSetupBaseBean {
    public static final String STATUS_ACTIVE = "ACTIVE";
    public static final String STATUS_INACTIVE = "INACTIVE";
    //
    public static final String TYPEOFBIZ_CORPORATION = "CORPORATION";
    public static final String TYPEOFBIZ_GOVT_AGENCY = "GOVT-AGENCY";
    public static final String TYPEOFBIZ_PARTNERSHIP = "PARTNERSHIP";
    public static final String TYPEOFBIZ_SOLE_PROPRIETOR = "SOLE-PROPRIETOR";
    // public static final String TYPEOFBIZ_OTHERS = "Others";
    //
    public static final String STYLEOFBIZ_MFG = "MANUFACTURER";
    public static final String STYLEOFBIZ_DISTRUBUTOR = "DISTRUBUTOR";
    public static final String STYLEOFBIZ_RESELLER = "RE-SELLER";
    public static final String STYLEOFBIZ_SERVICE = "SERVICE";
    public static final String STYLEOFBIZ_OTHERS = "OTHERS";
    /**
     * Relationships
     */
    public static final String PARENT_OF = "PARENT";
    public static final String SUBSIDIARY_OF = "SUBSIDIARY";
    public static final String AFFILIATE_OF = "AFFILIATE";
    /**
     * Tokenizer for related company
     */
    public static final String RELATED_COY_TOKEN = "#";
    /**
     * Related company id prefix
     */
    public static final String RELATED_COY_ID_PREFIX = "RELCO";
    //
    private String name = "";
    private String acctNum = "";
    // related companies (customers) specific
    private String relCoyId;
    private String coyRelationship = "";
    private int numOfCoy;
    private String refAcctNum = "";
    private String subAcctNum = "";
    private String subAcctNumError = "";
    private String relationshipKey = "";
    private Timestamp lastUpdateDate;
    private Date dateCreated;
    private Map relationshipMap;
    private boolean relCoyUpdateFlag = false;
    private List relCoyList;
    private double exposure;
    //
    protected String fedIdNum = "";
    protected String taxId = "";
    protected int yearEstablished;
    protected double annualSales;
    protected double anticipatedMonthlyPurchase;
    protected String fiscalYearEndMonth = "";
    protected String fiscalYearEndDay = "";
    protected String experianFileNum = "";
    protected String typeOfBusiness = "";
    protected String styleOfBusiness = "";
    //
    protected String industryId = "";
    protected String sectorId = IndustrySector.NONE;
    protected String annualSalesRangeID;
    //
    protected String accountLocationID = "";
    private String addressLineOne = "";
    private String addressLineTwo = "";
    private String registrationStatus = "";
    private String city = "";
    private String state = "";
    private String zipCode = "";
    private String countryId = "US"; // initialize to United States
    private String countryName = "";
    private String orgMainPhone = "";
    private String orgMainFax = "";
    private String stateOfIncorporation = "";
    private String numOfEmployee;
    //
    private String customerDBAName; // operating as name
    private String clientIPAddress;
    private String domainName;
    // private String clientIPName;
    private String processId = "";
    private String acctStatus = "";
    // DUNS NUMBER - STANDS FOR D&B Universal Identification number for
    // corporations
    private String dunsNum = "";
    // ID NUMBERS 1,2 & 3 used when needed for other local/international
    // corporate identification number
    private String crolCompanyId = "";
    private String idNum1 = "";
    private String idNum2 = "";
    private String idNum3 = "";

    private String federalTaxIdEncryptValue;
    private String isFederalTaxIdEncrypted=MatrixConstants.ANSWER_NO;
    private String federalTaxIdClear;
    
    /**
     * @return Returns the coyRelationship.
     */
    public String getCoyRelationship() {
        return coyRelationship;
    }

    /**
     * @param coyRelationship
     *            The coyRelationship to set.
     */
    public void setCoyRelationship(String coyRelationship) {
        this.coyRelationship = coyRelationship;
    }

    /**
     * @return Returns the dateCreated.
     */
    public Date getDateCreated() {
        return (Date) (dateCreated == null ? null : dateCreated.clone());
    }

    /**
     * @param dateCreated
     *            The dateCreated to set.
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = (Date) (dateCreated == null ? null : dateCreated.clone());
    }

    /**
     * @return Returns the exposure.
     */
    public double getExposure() {
        return exposure;
    }

    /**
     * @param exposure
     *            The exposure to set.
     */
    public void setExposure(double exposure) {
        this.exposure = exposure;
    }

    /**
     * @return Returns the lastUpdateDate.
     */
    public Timestamp getLastUpdateDate() {
        return (Timestamp) (lastUpdateDate == null ? null : lastUpdateDate.clone());
    }

    /**
     * @param lastUpdateDate
     *            The lastUpdateDate to set.
     */
    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = (Timestamp) (lastUpdateDate == null ? null : lastUpdateDate.clone());
    }

    /**
     * @return Returns the numOfCoy.
     */
    public int getNumOfCoy() {
        return numOfCoy;
    }

    /**
     * @param numOfCoy
     *            The numOfCoy to set.
     */
    public void setNumOfCoy(int numOfCoy) {
        this.numOfCoy = numOfCoy;
    }

    /**
     * @return Returns the refAcctNum.
     */
    public String getRefAcctNum() {
        return refAcctNum;
    }

    /**
     * @param refAcctNum
     *            The refAcctNum to set.
     */
    public void setRefAcctNum(String refAcctNum) {
        this.refAcctNum = refAcctNum;
    }

    /**
     * @return Returns the relationshipKey.
     */
    public String getRelationshipKey() {
        return relationshipKey;
    }

    /**
     * @param relationshipKey
     *            The relationshipKey to set.
     */
    public void setRelationshipKey(String relationshipKey) {
        this.relationshipKey = relationshipKey;
    }

    /**
     * @return Returns the relationshipMap.
     */
    public Map getRelationshipMap() {
        return relationshipMap;
    }

    /**
     * @param relationshipMap
     *            The relationshipMap to set.
     */
    public void setRelationshipMap(Map relationshipMap) {
        this.relationshipMap = relationshipMap;
    }

    /**
     * @return Returns the relCoyId.
     */
    public String getRelCoyId() {
        return relCoyId;
    }

    /**
     * @param relCoyId
     *            The relCoyId to set.
     */
    public void setRelCoyId(String relCoyId) {
        this.relCoyId = relCoyId;
    }

    /**
     * @return Returns the relCoyList.
     */
    public List getRelCoyList() {
        return relCoyList;
    }

    /**
     * @param relCoyList
     *            The relCoyList to set.
     */
    public void setRelCoyList(List relCoyList) {
        this.relCoyList = relCoyList;
    }

    /**
     * @return Returns the relCoyUpdateFlag.
     */
    public boolean isRelCoyUpdateFlag() {
        return relCoyUpdateFlag;
    }

    /**
     * @param relCoyUpdateFlag
     *            The relCoyUpdateFlag to set.
     */
    public void setRelCoyUpdateFlag(boolean relCoyUpdateFlag) {
        this.relCoyUpdateFlag = relCoyUpdateFlag;
    }

    /**
     * @return Returns the subAcctNum.
     */
    public String getSubAcctNum() {
        return subAcctNum;
    }

    /**
     * @param subAcctNum
     *            The subAcctNum to set.
     */
    public void setSubAcctNum(String subAcctNum) {
        this.subAcctNum = subAcctNum;
    }

    /**
     * @return Returns the subAcctNumError.
     */
    public String getSubAcctNumError() {
        return subAcctNumError;
    }

    /**
     * @param subAcctNumError
     *            The subAcctNumError to set.
     */
    public void setSubAcctNumError(String subAcctNumError) {
        this.subAcctNumError = subAcctNumError;
    }

    /**
     * @return Returns the annualSales.
     */
    public double getAnnualSales() {
        return annualSales;
    }

    /**
     * @param annualSales
     *            The annualSales to set.
     */
    public void setAnnualSales(double annualSales) {
        this.annualSales = annualSales;
    }

    /**
     * @return Returns the anticipatedMonthlyPurchase.
     */
    public double getAnticipatedMonthlyPurchase() {
        return anticipatedMonthlyPurchase;
    }

    /**
     * @param anticipatedMonthlyPurchase
     *            The anticipatedMonthlyPurchase to set.
     */
    public void setAnticipatedMonthlyPurchase(double anticipatedMonthlyPurchase) {
        this.anticipatedMonthlyPurchase = anticipatedMonthlyPurchase;
    }

    /**
     * @return Returns the experianFileNum.
     */
    public String getExperianFileNum() {
        return experianFileNum;
    }

    /**
     * @param experianFileNum
     *            The experianFileNum to set.
     */
    public void setExperianFileNum(String experianFileNum) {
        this.experianFileNum = experianFileNum;
    }

    /**
     * @return Returns the fedIdNum.
     */
    public String getFedIdNum() {
        return fedIdNum;
    }

    /**
     * @param fedIdNum
     *            The fedIdNum to set.
     */
    public void setFedIdNum(String fedIdNum) {
        this.fedIdNum = fedIdNum;
    }

    /**
     * @return Returns the fiscalYearEndDay.
     */
    public String getFiscalYearEndDay() {
        return fiscalYearEndDay;
    }

    /**
     * @param fiscalYearEndDay
     *            The fiscalYearEndDay to set.
     */
    public void setFiscalYearEndDay(String fiscalYearEndDay) {
        this.fiscalYearEndDay = fiscalYearEndDay;
    }

    /**
     * @return Returns the fiscalYearEndMonth.
     */
    public String getFiscalYearEndMonth() {
        return fiscalYearEndMonth;
    }

    /**
     * @param fiscalYearEndMonth
     *            The fiscalYearEndMonth to set.
     */
    public void setFiscalYearEndMonth(String fiscalYearEndMonth) {
        this.fiscalYearEndMonth = fiscalYearEndMonth;
    }

    /**
     * @return Returns the styleOfBusiness.
     */
    public String getStyleOfBusiness() {
        return styleOfBusiness;
    }

    /**
     * @param styleOfBusiness
     *            The styleOfBusiness to set.
     */
    public void setStyleOfBusiness(String styleOfBusiness) {
        this.styleOfBusiness = styleOfBusiness;
    }

    /**
     * @return Returns the taxId.
     */
    public String getTaxId() {
        return taxId;
    }

    /**
     * @param taxId
     *            The taxId to set.
     */
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    /**
     * @return Returns the typeOfBusiness.
     */
    public String getTypeOfBusiness() {
        return typeOfBusiness;
    }

    /**
     * @param typeOfBusiness
     *            The typeOfBusiness to set.
     */
    public void setTypeOfBusiness(String typeOfBusiness) {
        this.typeOfBusiness = typeOfBusiness;
    }

    /**
     * @return Returns the yearEstablished.
     */
    public int getYearEstablished() {
        return yearEstablished;
    }

    /**
     * @param yearEstablished
     *            The yearEstablished to set.
     */
    public void setYearEstablished(int yearEstablished) {
        this.yearEstablished = yearEstablished;
    }

    public String getIndustryId() {
        return industryId;
    }

    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }

    public String getSectorId() {
        if (this.sectorId == null || this.sectorId.trim().length() < 1) {
            sectorId = IndustrySector.NONE;
        }
        return sectorId;
    }

    public void setSectorId(String sectorId) {
        this.sectorId = sectorId;
    }

    public String getAccountLocationID() {
        return accountLocationID;
    }

    public void setAccountLocationID(String accountLocationID) {
        this.accountLocationID = accountLocationID;
    }

    public String getAnnualSalesRangeID() {
        return annualSalesRangeID;
    }

    public void setAnnualSalesRangeID(String annualSalesRangeID) {
        this.annualSalesRangeID = annualSalesRangeID;
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

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
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

    public String getOrgMainPhone() {
        return orgMainPhone;
    }

    public void setOrgMainPhone(String orgMainPhone) {
        this.orgMainPhone = orgMainPhone;
    }

    public String getStateOfIncorporation() {
        return stateOfIncorporation;
    }

    public void setStateOfIncorporation(String stateOfIncorporation) {
        this.stateOfIncorporation = stateOfIncorporation;
    }

    public String getNumOfEmployee() {
        return numOfEmployee;
    }

    public void setNumOfEmployee(String numOfEmployee) {
        this.numOfEmployee = numOfEmployee;
    }

    public String getOrgMainFax() {
        return orgMainFax;
    }

    public void setOrgMainFax(String orgMainFax) {
        this.orgMainFax = orgMainFax;
    }

    public boolean isHasFaxNum() {
        if (this.getOrgMainFax() != null
                && this.getOrgMainFax().trim().length() > 5) {
            return true;
        }
        return false;
    }

 

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientIPAddress() {
        return clientIPAddress;
    }

    public void setClientIPAddress(String clientIPAddress) {
        this.clientIPAddress = clientIPAddress;
    }

    public String getCustomerDBAName() {
        return customerDBAName;
    }

    public void setCustomerDBAName(String customerDBAName) {
        this.customerDBAName = customerDBAName;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getCrolCompanyId() {
        return crolCompanyId;
    }

    public void setCrolCompanyId(String crolCompanyId) {
        this.crolCompanyId = crolCompanyId;
    }

    public String getDunsNum() {
        return dunsNum;
    }

    public void setDunsNum(String dunsNum) {
        this.dunsNum = dunsNum;
    }

    public String getIdNum1() {
        return idNum1;
    }

    public void setIdNum1(String idNum1) {
        this.idNum1 = idNum1;
    }

    public String getIdNum2() {
        return idNum2;
    }

    public void setIdNum2(String idNum2) {
        this.idNum2 = idNum2;
    }

    public String getIdNum3() {
        return idNum3;
    }

    public void setIdNum3(String idNum3) {
        this.idNum3 = idNum3;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
    
    public String getFederalTaxIdEncryptValue() {
		return federalTaxIdEncryptValue;
	}

	public void setFederalTaxIdEncryptValue(String federalTaxIdEncryptValue) {
		this.federalTaxIdEncryptValue = federalTaxIdEncryptValue;
	}

	public String getIsFederalTaxIdEncrypted() {
		return isFederalTaxIdEncrypted;
	}

	public void setIsFederalTaxIdEncrypted(String isFederalTaxIdEncrypted) {
		this.isFederalTaxIdEncrypted = isFederalTaxIdEncrypted;
	}
	
	public String getFederalTaxIdClear() {
		
		if(federalTaxIdClear!=null ){
			return federalTaxIdClear;
		}
		if (this.federalTaxIdEncryptValue != null) {
			try {
				federalTaxIdClear=CustomCreditAppValuesBLO.deCryptValue(this.federalTaxIdEncryptValue.trim());
				return federalTaxIdClear;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return "";
			}
		} else {
			return taxId;
		}
	}

	public void setFederalTaxIdClear(String federalTaxIdClear) {
		this.federalTaxIdClear = federalTaxIdClear;

	}
}
