/**
 * 
 */
package com.bectran.sftp.xml.inbound;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author LOUIS IFEGUNI
 * @date Sep 30, 2013 : 4:12:26 PM
 */
@XmlRootElement(name = "customer-data")
public class ApprovedCreditMapperBean {
    private String namesape = "http://www.bectran.com/";
    private List<ApprovedCreditBean> customer;

    //
    public ApprovedCreditMapperBean() {
        customer = new ArrayList<ApprovedCreditBean>();
    }

    /**
     * @return the customer
     */
    public List<ApprovedCreditBean> getCustomer() {
        return customer;
    }

    /**
     * @param customer
     *            the customer to set
     */
    public void setCustomer(List<ApprovedCreditBean> customer) {
        this.customer = customer;
    }

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
}
