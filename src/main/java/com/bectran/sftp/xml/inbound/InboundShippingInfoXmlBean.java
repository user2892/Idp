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
public class InboundShippingInfoXmlBean {
    private List<ShippingInfoXmlBean> shippingInfoList;

    @XmlElement(name = "entry")
    public List<ShippingInfoXmlBean> getShippingInfoList() {
        return shippingInfoList;
    }

    public void setShippingInfoList(List<ShippingInfoXmlBean> shippingInfoList) {
        this.shippingInfoList = shippingInfoList;
    }
}
