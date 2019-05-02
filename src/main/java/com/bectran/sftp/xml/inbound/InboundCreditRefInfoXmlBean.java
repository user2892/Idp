/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.sftp.xml.inbound;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Shanmu
 * @date Nov 23, 2015 9:04:23 PM
 */
public class InboundCreditRefInfoXmlBean {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private List<CreditRefInfoXmlBean> creditRefInfoList;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>InboundCreditRefInfoXmlBean</code>
     */
    public InboundCreditRefInfoXmlBean() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the creditRefInfoList.
     */
    @XmlElement(name = "entry")
    public List<CreditRefInfoXmlBean> getCreditRefInfoList() {
        return creditRefInfoList;
    }

    /**
     * @param creditRefInfoList
     *            The creditRefInfoList to set.
     */
    public void setCreditRefInfoList(List<CreditRefInfoXmlBean> creditRefInfoList) {
        this.creditRefInfoList = creditRefInfoList;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
