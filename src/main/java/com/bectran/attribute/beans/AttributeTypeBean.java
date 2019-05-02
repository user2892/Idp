/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.beans;

/**
 * @author Shanmu
 * @date Jun 28, 2015 3:33:04 PM
 */
public class AttributeTypeBean extends BaseEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 5484457752064037368L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Integer attributeTypeID;
    private String name;
    private String description;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>AttributeType</code>
     */
    public AttributeTypeBean() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the attributeTypeID.
     */
    public Integer getAttributeTypeID() {
        return attributeTypeID;
    }

    /**
     * @param attributeTypeID
     *            The attributeTypeID to set.
     */
    public void setAttributeTypeID(Integer attributeTypeID) {
        this.attributeTypeID = attributeTypeID;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
