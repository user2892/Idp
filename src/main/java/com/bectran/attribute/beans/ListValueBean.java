/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.beans;

/**
 * @author Shanmu
 * @date Jun 28, 2015 3:36:15 PM
 */
public class ListValueBean extends BaseEntity implements Comparable<ListValueBean>{
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -5541201559701159762L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long listValueID;
    private Long attributeDefID;
    private String value;
    private Integer showOrder;
    //Code Changes for BEC-1797
    private String internalCode;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>ListValues</code>
     */
    public ListValueBean() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the listValueID.
     */
    public Long getListValueID() {
        return listValueID;
    }

    /**
     * @param listValueID
     *            The listValueID to set.
     */
    public void setListValueID(Long listValueID) {
        this.listValueID = listValueID;
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
     * @return Returns the showOrder.
     */
    public Integer getShowOrder() {
        return showOrder;
    }

    /**
     * @param showOrder
     *            The showOrder to set.
     */
    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    /**
     * @return Returns the attributeDefID.
     */
    public Long getAttributeDefID() {
        return attributeDefID;
    }

    /**
     * @param attributeDefID
     *            The attributeDefID to set.
     */
    public void setAttributeDefID(Long attributeDefID) {
        this.attributeDefID = attributeDefID;
    }
    
    /**
	 * @return the internalCode
	 */
	public String getInternalCode() {
		return internalCode;
	}
	/**
	 * @param internalCode the internalCode to set
	 */
	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	/**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(ListValueBean o) {
        if (o != null) {
            return getShowOrder().compareTo(o.getShowOrder());
        }
        return 0;
    }
    
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
