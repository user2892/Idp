/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.sftp.xml.inbound;

import javax.xml.bind.annotation.XmlType;

/**
 * @author Shanmu
 * @date Nov 23, 2015 8:19:01 PM
 */
@XmlType(propOrder = {"attribute", "value", "weaknessFactor"})
public class CreditRefAttrInfoXmlBean {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String attribute;
    private String value;
    private String weaknessFactor;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>CreditRefAttrInfoXmlBean</code>
     */
    public CreditRefAttrInfoXmlBean() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the attribute.
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * @param attribute
     *            The attribute to set.
     */
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    /**
     * @return Returns the value.
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            The value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return Returns the weaknessFactor.
     */
    public String getWeaknessFactor() {
        return weaknessFactor;
    }

    /**
     * @param weaknessFactor
     *            The weaknessFactor to set.
     */
    public void setWeaknessFactor(String weaknessFactor) {
        this.weaknessFactor = weaknessFactor;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
