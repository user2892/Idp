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
public class InboundOwnerOfficerInfoXmlBean {
    private List<OwnerOfficerInfoXmlBean> ownerOfficerList;

    @XmlElement(name = "entry")
    public List<OwnerOfficerInfoXmlBean> getOwnerOfficerList() {
        return ownerOfficerList;
    }

    public void setOwnerOfficerList(List<OwnerOfficerInfoXmlBean> ownerOfficerList) {
        this.ownerOfficerList = ownerOfficerList;
    }
}
