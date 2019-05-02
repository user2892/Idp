/**
 * 
 */
package com.bectran.sftp.xml.inbound;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author LOUIS IFEGUNI
 * @date April 26, 2014 : 1:59:14 PM
 */
public class InboundTaxExemptInfoXmlBean {
    private List<TaxExemptInfoXmlBean> taxExemptList;

    @XmlElement(name = "entry")
    public List<TaxExemptInfoXmlBean> getTaxExemptList() {
        return taxExemptList;
    }

    public void setTaxExemptList(List<TaxExemptInfoXmlBean> taxExemptList) {
        this.taxExemptList = taxExemptList;
    }
}
