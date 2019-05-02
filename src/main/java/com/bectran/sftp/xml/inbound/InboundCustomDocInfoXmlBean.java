/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.sftp.xml.inbound;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Shanmu
 * @date Nov 25, 2015 7:30:48 PM
 */
public class InboundCustomDocInfoXmlBean {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private List<CustomDocInfoXmlBean> customDocList;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>InboundCustomDocInfoXmlBean</code>
     */
    public InboundCustomDocInfoXmlBean() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the customDocList.
     */
    @XmlElement(name = "entry")
    public List<CustomDocInfoXmlBean> getCustomDocList() {
        return customDocList;
    }

    /**
     * @param customDocList
     *            The customDocList to set.
     */
    public void setCustomDocList(List<CustomDocInfoXmlBean> customDocList) {
        this.customDocList = customDocList;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
