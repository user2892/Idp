/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Shanmu
 * @date Jun 28, 2015 3:29:57 PM
 */
public abstract class BaseEntity implements Serializable {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -7840268932111277350L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>BaseEntity</code>
     */
    public BaseEntity() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the createdDate.
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     *            The createdDate to set.
     */
    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return Returns the createdBy.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     *            The createdBy to set.
     */
    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return Returns the modifiedDate.
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate
     *            The modifiedDate to set.
     */
    public void setModifiedDate(final Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * @return Returns the modifiedBy.
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy
     *            The modifiedBy to set.
     */
    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
