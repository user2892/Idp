/**
 * 
 */
package com.bectran.sftp.xml.inbound;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 3, 2013 : 1:35:14 PM
 */
@XmlType(propOrder = {"businessGroupXmlBean", "customerBasicInfo",
        "taxExemptInfoXmlBean", "salesRepInfoXmlBean", "opsUnitInfoXmlBean",
        "officerInfoXmlBean", "billingInfoXmlBean", "shippingInfoXmlBean",
        "apayInfoXmlBean", "page2InfoXmlBean", "creditRefInfoXmlBean",
        "customDocInfoXmlBean", "creditRequestInfo","customApprovedCreditXMLBean"})
public class InboundCustomerandDecisionDataXmlBean {
    private String accountId;
    private String transactionId;
    private CustomerBasicInfoXmlBean customerBasicInfo;
    //
    private InboundTaxExemptInfoXmlBean taxExemptInfoXmlBean;
    //
    private InboundOwnerOfficerInfoXmlBean officerInfoXmlBean;
    private InboundBillingInfoXmlBean billingInfoXmlBean;
    private InboundShippingInfoXmlBean shippingInfoXmlBean;
    private InboundApayInfoXmlBean apayInfoXmlBean;
    private InboundPage2InfoXmlBean page2InfoXmlBean;
    private SalesRepInfoXmlBean salesRepInfoXmlBean;
    private OpsUnitInfoXmlBean opsUnitInfoXmlBean;
    private BusinessGroupXmlBean businessGroupXmlBean;
    private InboundCreditRefInfoXmlBean creditRefInfoXmlBean;
    private InboundCustomDocInfoXmlBean customDocInfoXmlBean;
    private CustomApprovedCreditXMLBean customApprovedCreditXMLBean;
    
    private CreditRequestInfoXmlBean creditRequestInfo;

    @XmlAttribute(name = "account-id")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @XmlElement(name = "basic-info")
    public CustomerBasicInfoXmlBean getCustomerBasicInfo() {
        return customerBasicInfo;
    }

    public void setCustomerBasicInfo(CustomerBasicInfoXmlBean customerBasicInfo) {
        this.customerBasicInfo = customerBasicInfo;
    }

    @XmlElement(name = "owner-officer-info")
    public InboundOwnerOfficerInfoXmlBean getOfficerInfoXmlBean() {
        return officerInfoXmlBean;
    }

    public void setOfficerInfoXmlBean(InboundOwnerOfficerInfoXmlBean officerInfoXmlBean) {
        this.officerInfoXmlBean = officerInfoXmlBean;
    }

    @XmlElement(name = "billing-info")
    public InboundBillingInfoXmlBean getBillingInfoXmlBean() {
        return billingInfoXmlBean;
    }

    public void setBillingInfoXmlBean(InboundBillingInfoXmlBean billingInfoXmlBean) {
        this.billingInfoXmlBean = billingInfoXmlBean;
    }

    @XmlElement(name = "shipping-info")
    public InboundShippingInfoXmlBean getShippingInfoXmlBean() {
        return shippingInfoXmlBean;
    }

    public void setShippingInfoXmlBean(InboundShippingInfoXmlBean shippingInfoXmlBean) {
        this.shippingInfoXmlBean = shippingInfoXmlBean;
    }

    @XmlElement(name = "apay-info")
    public InboundApayInfoXmlBean getApayInfoXmlBean() {
        return apayInfoXmlBean;
    }

    public void setApayInfoXmlBean(InboundApayInfoXmlBean apayInfoXmlBean) {
        this.apayInfoXmlBean = apayInfoXmlBean;
    }

    @XmlElement(name = "sales-person-info")
    public SalesRepInfoXmlBean getSalesRepInfoXmlBean() {
        return salesRepInfoXmlBean;
    }

    public void setSalesRepInfoXmlBean(SalesRepInfoXmlBean salesRepInfoXmlBean) {
        this.salesRepInfoXmlBean = salesRepInfoXmlBean;
    }

    @XmlElement(name = "operations-unit-info")
    public OpsUnitInfoXmlBean getOpsUnitInfoXmlBean() {
        return opsUnitInfoXmlBean;
    }

    public void setOpsUnitInfoXmlBean(OpsUnitInfoXmlBean opsUnitInfoXmlBean) {
        this.opsUnitInfoXmlBean = opsUnitInfoXmlBean;
    }

    @XmlElement(name = "business-group-info")
    public BusinessGroupXmlBean getBusinessGroupXmlBean() {
        return businessGroupXmlBean;
    }

    public void setBusinessGroupXmlBean(BusinessGroupXmlBean businessGroupXmlBean) {
        this.businessGroupXmlBean = businessGroupXmlBean;
    }

    @XmlElement(name = "page-2-info")
    public InboundPage2InfoXmlBean getPage2InfoXmlBean() {
        return page2InfoXmlBean;
    }

    public void setPage2InfoXmlBean(InboundPage2InfoXmlBean page2InfoXmlBean) {
        this.page2InfoXmlBean = page2InfoXmlBean;
    }

    @XmlAttribute(name = "transaction-id")
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @XmlElement(name = "tax-exempt-info")
    public InboundTaxExemptInfoXmlBean getTaxExemptInfoXmlBean() {
        return taxExemptInfoXmlBean;
    }

    public void setTaxExemptInfoXmlBean(InboundTaxExemptInfoXmlBean taxExemptInfoXmlBean) {
        this.taxExemptInfoXmlBean = taxExemptInfoXmlBean;
    }

    /**
     * @return Returns the creditRefInfoXmlBean.
     */
    @XmlElement(name = "credit-reference-info")
    public InboundCreditRefInfoXmlBean getCreditRefInfoXmlBean() {
        return creditRefInfoXmlBean;
    }

    /**
     * @param creditRefInfoXmlBean
     *            The creditRefInfoXmlBean to set.
     */
    public void setCreditRefInfoXmlBean(InboundCreditRefInfoXmlBean creditRefInfoXmlBean) {
        this.creditRefInfoXmlBean = creditRefInfoXmlBean;
    }

    /**
     * @return Returns the customDocInfoXmlBean.
     */
    @XmlElement(name = "custom-doc-info")
    public InboundCustomDocInfoXmlBean getCustomDocInfoXmlBean() {
        return customDocInfoXmlBean;
    }

    /**
     * @param customDocInfoXmlBean
     *            The customDocInfoXmlBean to set.
     */
    public void setCustomDocInfoXmlBean(InboundCustomDocInfoXmlBean customDocInfoXmlBean) {
        this.customDocInfoXmlBean = customDocInfoXmlBean;
    }
    
    /**
     * @return Returns the customApprovedCreditBean.
     */
   
    @XmlElement(name="credit-request-info" )
    public CreditRequestInfoXmlBean getCreditRequestInfo() {
        return creditRequestInfo;
    }
    public void setCreditRequestInfo(CreditRequestInfoXmlBean creditRequestInfo) {
        this.creditRequestInfo = creditRequestInfo;
    }

    /**
     * @return Returns the customApprovedCreditXMLBean.
     */
    @XmlElement(name = "customer-decision")
    public CustomApprovedCreditXMLBean getCustomApprovedCreditXMLBean() {
        return customApprovedCreditXMLBean;
    }

    /**
     * @param customApprovedCreditXMLBean The customApprovedCreditXMLBean to set.
     */
    public void setCustomApprovedCreditXMLBean(CustomApprovedCreditXMLBean customApprovedCreditXMLBean) {
        this.customApprovedCreditXMLBean = customApprovedCreditXMLBean;
    }

    
    
}
