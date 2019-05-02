/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.beans;

import com.bectran.b2b.supplier.beans.GroupCustomAppAttrGrpBean;

/**
 * @author shanmu
 * @date 23-May-2016 11:00:30 am
 */
public class CustomAppLayout extends GroupCustomAppAttrGrpBean implements
        Comparable<CustomAppLayout> {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 2946438143119339666L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private CustomAppAttrGrpLayout customAppAttrGrpLayout;
    private boolean readOnly=true;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>CustomAppAttrGroupLayout</code>
     */
    public CustomAppLayout() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the customAppAttrGrpLayout.
     */
    public CustomAppAttrGrpLayout getCustomAppAttrGrpLayout() {
        return customAppAttrGrpLayout;
    }

    /**
     * @param customAppAttrGrpLayout
     *            The customAppAttrGrpLayout to set.
     */
    public void setCustomAppAttrGrpLayout(CustomAppAttrGrpLayout customAppAttrGrpLayout) {
        this.customAppAttrGrpLayout = customAppAttrGrpLayout;
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(CustomAppLayout o) {
        // TODO Auto-generated method stub
        if (getCustomAppAttrGrpLayout() != null) {
            return getCustomAppAttrGrpLayout().compareTo(
                    o.getCustomAppAttrGrpLayout());
        }
        return 0;
    }

    /**
     * @return Returns the readOnly.
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * @param readOnly The readOnly to set.
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }
}
