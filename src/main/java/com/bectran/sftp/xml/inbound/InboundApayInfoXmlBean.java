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
public class InboundApayInfoXmlBean {
    private List<ApayInfoXmlBean> apayInfoList;

    @XmlElement(name = "entry")
    public List<ApayInfoXmlBean> getApayInfoList() {
        return apayInfoList;
    }

    public void setApayInfoList(List<ApayInfoXmlBean> apayInfoList) {
        this.apayInfoList = apayInfoList;
    }
}
