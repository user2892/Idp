/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.b2b.supplier.beans;

import org.apache.commons.lang3.StringUtils;

import com.bectran.attribute.beans.BaseEntity;
import com.bectran.b2b.constants.EnumAppType;
import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author shanmu
 * @date 21-May-2016 2:02:18 pm
 */
public class GroupCustomAppAttrGrpBean extends BaseEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 8668059021640330864L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long id;
    private Long groupID;
    private String formType = EnumAppType.APP_TYPE_CREDIT_APP;
    private Long attributeGroupID;
    private String status;
    private String name;
    private String editable = MatrixConstants.ANSWER_NO;
    private String viewable = MatrixConstants.ANSWER_YES;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>GroupCustomAppAttrGrpBean</code>
     */
    public GroupCustomAppAttrGrpBean() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Returns the groupID.
     */
    public Long getGroupID() {
        return groupID;
    }

    /**
     * @param groupID
     *            The groupID to set.
     */
    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }

    /**
     * @return Returns the formType.
     */
    public String getFormType() {
        return formType;
    }

    /**
     * @param formType
     *            The formType to set.
     */
    public void setFormType(String formType) {
        this.formType = formType;
    }

    /**
     * @return Returns the attributeGroupID.
     */
    public Long getAttributeGroupID() {
        return attributeGroupID;
    }

    /**
     * @param attributeGroupID
     *            The attributeGroupID to set.
     */
    public void setAttributeGroupID(Long attributeGroupID) {
        this.attributeGroupID = attributeGroupID;
    }

    /**
     * @return Returns the status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     *            The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
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

    public boolean isActive() {
        return StringUtils.equals(MatrixConstants.STATUS_ACTIVE, status);
    }

    /**
     * @return Returns the editable.
     */
    public String getEditable() {
        return editable;
    }

    /**
     * @param editable
     *            The editable to set.
     */
    public void setEditable(String editable) {
        this.editable = editable;
    }

    /**
     * @return Returns the viewable.
     */
    public String getViewable() {
        return viewable;
    }

    /**
     * @param viewable
     *            The viewable to set.
     */
    public void setViewable(String viewable) {
        this.viewable = viewable;
    }
    
    /**
     * @return
     */
    public boolean isEditableBoo() {
        return StringUtils.equals(MatrixConstants.ANSWER_YES, editable);
    }

    /**
     * @return
     */
    public boolean isViewableBoo() {
        return StringUtils.equals(MatrixConstants.ANSWER_YES, viewable);
    }    
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
