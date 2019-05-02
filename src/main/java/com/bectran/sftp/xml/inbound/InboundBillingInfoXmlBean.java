/**
 * 
 */
package com.bectran.sftp.xml.inbound;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 3, 2013 : 1:59:14 PM
 */
public class InboundBillingInfoXmlBean {
    private List<BillingInfoXmlBean> billingInfoList;

    @XmlElement(name = "entry")
    public List<BillingInfoXmlBean> getBillingInfoList() {
        return billingInfoList;
    }

    public void setBillingInfoList(List<BillingInfoXmlBean> billingInfoList) {
        this.billingInfoList = billingInfoList;
    }
}
