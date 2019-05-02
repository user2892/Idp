/**
 * 
 */
package com.bectran.sftp.xml.inbound.helper;

import com.bectran.b2b.customer.beans.AppCustomerContactBean;
import com.bectran.b2b.customer.beans.ClientCustomerInfoCopyBean;
import com.bectran.b2b.customer.beans.CreditApplicantByRequestBean;
import com.bectran.b2b.customer.beans.PastCreditAppBean;
import com.bectran.b2b.customer.dao.CustomerDataDAO;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.DateUtility;
import com.bectran.sftp.xml.inbound.CustomerBasicInfoXmlBean;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 2, 2013 : 8:17:48 PM
 */
public class CustomerBasicInfoLoad extends CustomerDataLoadBase {
    public CustomerBasicInfoXmlBean initializeTrxnBean(PastCreditAppBean app)
            throws DataAccessException {
        ClientCustomerInfoCopyBean bean = new CustomerDataDAO()
                .findClientCustomerCopyById(
                        app.getCustomerSupplierId().longValue());
        AppCustomerContactBean appCustomerContact = app.getCustomerContactInfo();
        
        CustomerBasicInfoXmlBean txn = new CustomerBasicInfoXmlBean();
        //
        // String addressLineOne 1/
        txn.setAddressLineOne(getValueForXml(appCustomerContact.getAddressLineOne()));
        // String addressLineTwo 2/
        txn.setAddressLineTwo(getValueForXml(appCustomerContact.getAddressLineTwo()));
        // String annualSalesRange 3/
        txn.setAnnualSalesRange(getValueForXml(bean.getAnnualSalesRangeID()));
        // String bectranCustomerId 4/
        txn.setBectranCustomerId(appCustomerContact.getAcctNum());
        // String city 5/
        txn.setCity(getValueForXml(appCustomerContact.getCity()));
        // String countryId 6/
        txn.setCountryId(getValueForXml(appCustomerContact.getCountryId()));
        // String customerDbaName 7/
        txn.setCustomerDbaName(getValueForXml(appCustomerContact.getCustomerDBAName()));
        // String customerLegalName 8/
        txn.setCustomerLegalName(getValueForXml(appCustomerContact.getName()));
        // String dateCreatedInBectran 9/
        txn.setDateCreatedInBectran(getValueForXml(
                DateUtility.reFormatDateForXmlSchema(appCustomerContact.getDateCreated())));
        // String dunsNumber 10/
        txn.setDunsNumber(getValueForXml(bean.getDunsNum()));
        //
        // String fax 11/
        txn.setFax(getValueForXml(appCustomerContact.getOrgMainFax()));
        // String federalTaxId 12/
        txn.setFederalTaxId(getValueForXml(bean.getFederalTaxIdClear()));
        // String numOfEmployee 13/
        txn.setNumOfEmployee(getValueForXml(bean.getNumOfEmployee()));
        // String phone 14/
        txn.setPhone(getValueForXml(appCustomerContact.getOrgMainPhone()));
        // String state 15/
        txn.setState(getValueForXml(appCustomerContact.getState()));
        // String stateOfIncorporation 16/
        txn.setStateOfIncorporation(
                getValueForXml(bean.getStateOfIncorporation()));
        // String styleOfBusiness 17/
        txn.setStyleOfBusiness(getValueForXml(bean.getStyleOfBusiness()));
        // String typeOfBusiness 18/
        txn.setTypeOfBusiness(getValueForXml(bean.getTypeOfBusiness()));
        // String yearEstablished 19/
        txn.setYearEstablished(
                getValueForXml(String.valueOf(bean.getYearEstablished())));
        // String zipCode 20/
        txn.setZipCode(getValueForXml(appCustomerContact.getZipCode()));
        /*ExtUserBean contact = new CustomerDataDAO()
                .findCustomerContact(app.getRequestor().trim());*/
        CreditApplicantByRequestBean contact = app.getCreditApplicant();
    	if(contact==null){
    		contact = new CreditApplicantByRequestBean();
    	}
        //
        // String contactPersonFirstName 21/
        txn.setContactPersonFirstName(getValueForXml(contact.getFirstName()));
        // String contactPersonLastName 22/
        txn.setContactPersonLastName(getValueForXml(contact.getLastName()));
        // String contactPersonPhone 23/
        txn.setContactPersonPhone(getValueForXml(contact.getPhone()));
        // String contactPersonTitle 24/
        txn.setContactPersonTitle(getValueForXml(contact.getTitle()));
        // email 25/
        txn.setContactPersonEmail(getValueForXml(contact.getUserId()));
        return txn;
    }

    public static void main(String[] args) throws Exception {
        //
        System.out.println("----start---");
        //
        PastCreditAppBean app = new CustomerDataDAO().findAppById(55);
        new CustomerBasicInfoLoad().initializeTrxnBean(app);
        System.out.println("----stop---");
    }
}
