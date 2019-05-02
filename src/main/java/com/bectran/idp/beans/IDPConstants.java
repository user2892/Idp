/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.idp.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author santhosh
 * @date 03-Sep-2016 5:38:36 pm
 */
public class IDPConstants {
    // --------------------------------------------------------------- Constants
    public static final String DEC_AMOUNTREQ = "amountRequested";
    public static final String DEC_ANALNAME = "analystName";
    public static final String DEC_APRLDATE = "approvalDate";
    public static final String DEC_APRLIMIT = "approvedLimit";
    public static final String DEC_APROFERNAME = "approvigOfficerName";
    public static final String DEC_BECCUSID = "bectranCustomerId";
    public static final String DEC_CLIENTACCID = "clientAccountId";
    public static final String DEC_CREDITTERM = "creditTerm";
    public static final String DEC_CREDITTERMCODE = "creditTermCode";
    public static final String DEC_CUSTOMERNAME = "customerName";
    public static final String DEC_RISKRATING = "riskRating";
    public static final String DEC_RISKRATINGCLS = "riskRatingClass";
    public static final String DEC_TRANSACTIONID = "transactionId";
    public static final String DEC_CREDITDECISION = "creditDecision";
    public static final String DEC_GROUPNAME = "groupName";
    public static final String DEC_INTRGRPCODE = "internalGroupCode";
    public static final String DEC_BECREFID = "bectranReferenceId";
    public static final String DEC_ACCID = "account-id";
    public static final String CUSTOMERDATA = "CUS_DATA";
    public static final String DECDATA = "DEC_DATA";
    public static final String CUSDATADISPVAL = "Customer Data";
    public static final String DECDATADISPVAL = "Decision Data";
    public static final String ALLWITHPARAM = "ALL_WITH_PARAM";
    public static final String ALL = "ALL";
    //Code change for BEC-496
    public static final String TRANSMIT_MODE_IDP="IDP";
    
    public static final String DEC_NEXTREVIEWDT = "nextReviewDate";
    //Ajay Veluru - Customer Data selection in IDP process
    public static final String BASIC_INFO = "basic-info";
    public static final String OWNER_OFFICER_INFO = "owner-officer-info";
    public static final String BILLING_INFO="billing-info";
    public static final String SHIPPING_INFO="shipping-info";
    public static final String APAY_INFO="apay-info";
    public static final String SALES_PERSON_INFO="sales-person-info";
    public static final String OPERATIONS_UNIT_INFO="operations-unit-info";
    public static final String BUSINESS_GROUP_INFO="business-group-info";
    public static final String PAGE_2_INFO="page-2-info";
    public static final String TAX_EXEMPT_INFO="tax-exempt-info";
    public static final String CREDIT_REFERENCE_INFO="credit-reference-info";
    public static final String CUSTOM_DOC_INFO="custom-doc-info";
    public static final String CREDIT_REQUEST_INFO="credit-request-info";
    //Basic Info constants
	public static final String CUS_BI_CONTACTPERSONPHONE = "contactPersonPhone";
	public static final String CUS_BI_CITY = "city";
	public static final String CUS_BI_NUMOFEMPLOYEE = "numOfEmployee";
	public static final String CUS_BI_CONTACTPERSONTITLE = "contactPersonTitle";
	public static final String CUS_BI_ZIPCODE = "zipCode";
	public static final String CUS_BI_CONTACTPERSONEMAIL = "contactPersonEmail";
	public static final String CUS_BI_COUNTRYID = "countryId";
	public static final String CUS_BI_CONTACTPERSONFIRSTNAME = "contactPersonFirstName";
	public static final String CUS_BI_BECTRANCUSTOMERID = "bectranCustomerId";
	public static final String CUS_BI_CUSTOMERDBANAME = "customerDbaName";
	public static final String CUS_BI_STATEOFINCORPORATION = "stateOfIncorporation";
	public static final String CUS_BI_STYLEOFBUSINESS = "styleOfBusiness";
	public static final String CUS_BI_CONTACTPERSONLASTNAME = "contactPersonLastName";
	public static final String CUS_BI_CUSTOMERLEGALNAME = "customerLegalName";
	public static final String CUS_BI_STATE = "state";
	public static final String CUS_BI_FAX = "fax";
	public static final String CUS_BI_DATECREATEDINBECTRAN = "dateCreatedInBectran";
	public static final String CUS_BI_FEDERALTAXID = "federalTaxId";
	public static final String CUS_BI_YEARESTABLISHED = "yearEstablished";
	public static final String CUS_BI_PHONE = "phone";
	public static final String CUS_BI_ANNUALSALESRANGE = "annualSalesRange";
	public static final String CUS_BI_DUNSNUMBER = "dunsNumber";
	public static final String CUS_BI_TYPEOFBUSINESS = "typeOfBusiness";
	public static final String CUS_BI_ADDRESSLINEONE = "addressLineOne";
	public static final String CUS_BI_ADDRESSLINETWO = "addressLineTwo";
    //Owner Info
	public static final String CUS_OI_SALUTATION = "salutation";
	public static final String CUS_OI_FIRSTNAME = "firstName";
	public static final String CUS_OI_PHONE = "phone";
	public static final String CUS_OI_PERSTITLE = "persTitle";
	public static final String CUS_OI_LASTNAME = "lastName";
    //Billing Info, Shipping Info, Apay Info, Sales Person Info
	public static final String CUS_BILLINFO_COUNTRYID="countryId";			    					
	public static final String CUS_BILLINFO_SALUTATION="salutation";		    					
	public static final String CUS_BILLINFO_STATE="state"	;		    					
	public static final String CUS_BILLINFO_EMAIL="email"	;		    					
	public static final String CUS_BILLINFO_ADDRESSLINETWO="addressLineTwo";			    					
	public static final String CUS_BILLINFO_CITY="city";			    					
	public static final String CUS_BILLINFO_PHONE="phone"	;		    					
	public static final String CUS_BILLINFO_ZIPCODE="zipCode";			    					
	public static final String CUS_BILLINFO_FAX="fax";			    					
	public static final String CUS_BILLINFO_LASTNAME="lastName";			    					
	public static final String CUS_BILLINFO_FIRSTNAME="firstName";			    					
	public static final String CUS_BILLINFO_ADDRESSLINEONE ="addressLineOne";
	public static final String CUS_SP_INTERNALCODE="internalCode";
	//Operatonal Unit Info
	public static final String CUS_OPS_OPSUNITCODE="opsUnitCode";	
	public static final String CUS_OPS_OPSUNITNAME="opsUnitName";
	//Business Group Info			    						
	public static final String CUS_BG_BECTRANREFID="bectranReferenceId";
	public static final String CUS_BG_GROUPNAME="groupName";
	public static final String CUS_BG_INTERNALGROUPCODE="internalGroupCode";
	//Page2 Info
	public static final String CUS_P2_CATEGORY="category";
	public static final String CUS_P2_CATEGORYCODE="categoryCode";
	public static final String CUS_P2_NAME="name";
	public static final String CUS_P2_VALUE="value";
	public static final String CUS_P2_VALUECODE="valueCode";
    //Tax Exempt Info
	public static final String CUS_TE_CERTNUM="certNum";
	public static final String CUS_TE_DOCIMAGEURL="docImageUrl";
	public static final String CUS_TE_EXPIRATION="expiration" ;
	public static final String CUS_TE_EXPIRATIONDATE="expirationDate";
	public static final String CUS_TE_STATUSCODE="statusCode";
	//Credit Reference Info
	public static final String CUS_CR_ACCOUNTTYPE="accountType";	
	public static final String CUS_CR_COMPANYNAME="companyName";	
	public static final String CUS_CR_CREDITREFATTRINFOLIST="creditRefAttrInfoList";
	public static final String CUS_CR_INTERNALACCTNUM="internalAcctNum";	
	public static final String CUS_CR_REFERENCETYPE="referenceType";
	public static final String CUS_CR_STATUS="status";
	//Custom Doc Info
	public static final String CUS_CUSTOM_DATE="date";
	public static final String CUS_CUSTOM_DOCIMAGEURL="docImageUrl";
	public static final String CUS_CUSTOM_DOCTYPE="documentType";
	public static final String CUS_CUSTOM_ID="id";
	public static final String CUS_CUSTOM_NAME="name";
	//Credit Request Info
	public static final String CUS_CR_AMOUNTREQUESTED="amountRequested";
	public static final String CUS_CR_PLANNEDPURCHASE="plannedPurchase";
	public static final String CUS_CR_REQDATE="requestDate";
	public static final String CUS_CR_REQFORMTYPE="requestFormType";
	public static final String CUS_CR_REQUESTID="requestId";
	public static final String CUS_CR_REQUESTSOURCE="requestSource";
	public static final String CUS_CR_TERMREQCODE="termRequestedCode";
	public static final String CUS_CR_TERMREQDESC="termRequestedDescription";
   
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    public static final List<String> getNodeElimentsList(){
        List<String> list = new ArrayList<String>();
        list.add(DEC_AMOUNTREQ);
        list.add(DEC_ANALNAME);
        list.add(DEC_APRLDATE);
        list.add(DEC_APRLIMIT);
        list.add(DEC_APROFERNAME);
        list.add(DEC_BECCUSID);
        list.add(DEC_CLIENTACCID);
        list.add(DEC_CREDITTERM);
        list.add(DEC_CREDITTERMCODE);
        list.add(DEC_CUSTOMERNAME);
        list.add(DEC_RISKRATING);
        list.add(DEC_RISKRATINGCLS);
        list.add(DEC_TRANSACTIONID);
        list.add(DEC_CREDITDECISION);
        list.add(DEC_GROUPNAME);
        list.add(DEC_INTRGRPCODE);
        list.add(DEC_BECREFID);
        list.add(DEC_ACCID);
        list.add(DEC_NEXTREVIEWDT);
        
        return list;
    }
    public static final List<String> getCustomerNodeElementsList(){
        List<String> list = new ArrayList<String>();
        list.add(BASIC_INFO);
        list.add(OWNER_OFFICER_INFO);
        list.add(BILLING_INFO);
        list.add(SHIPPING_INFO);
        list.add(APAY_INFO);
        list.add(SALES_PERSON_INFO);
        list.add(OPERATIONS_UNIT_INFO);
        list.add(BUSINESS_GROUP_INFO);
        list.add(PAGE_2_INFO);
        list.add(TAX_EXEMPT_INFO);
        list.add(CREDIT_REFERENCE_INFO);
        list.add(CUSTOM_DOC_INFO);
        list.add(CREDIT_REQUEST_INFO);

        
        return list;
    }
    // ----------------------------------------------------------- Inner Classes
}
