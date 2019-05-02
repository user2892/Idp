/**
 * 
 */
package com.bectran.sftp.xml.inbound;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author LOUIS IFEGUNI
 * @date Nov 19, 2013 : 10:50:43 AM
 */
public class InboundPage2InfoXmlBean {
    private List<Page2InfoXmlBean> page2InfoList;

    @XmlElement(name = "entry")
    public List<Page2InfoXmlBean> getPage2InfoList() {
        return page2InfoList;
    }

    public void setPage2InfoList(List<Page2InfoXmlBean> page2InfoList) {
        this.page2InfoList = page2InfoList;
    }
}
