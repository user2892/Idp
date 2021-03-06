/**
 * 
 */
package com.bectran.sftp.xml.inbound;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 3, 2013 : 11:17:51 AM
 */
@XmlRootElement(name = "inbound-customer-data")
public class CustomerInboundDataMapperBean {
    private String namesape = "http://www.bectran.com/";
    private InboundCustomerDataXmlBean dataXmlList;

    /**
     * @return the namesape
     */
    @XmlAttribute(name = "xmlns")
    public String getNamesape() {
        return namesape;
    }

    /**
     * @param namesape
     *            the namesape to set
     */
    public void setNamesape(String namesape) {
        this.namesape = namesape;
    }

    @XmlElement(name = "customer")
    public InboundCustomerDataXmlBean getDataXmlList() {
        return dataXmlList;
    }

    public void setDataXmlList(InboundCustomerDataXmlBean dataXmlList) {
        this.dataXmlList = dataXmlList;
    }
}
