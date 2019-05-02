/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.beans;

import com.bectran.attribute.constants.EnumMatchRuleType;

/**
 * @author shanmu
 * @date 10-May-2016 3:19:56 pm
 */
public class AttrMatchRuleBean extends BaseEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -1548943705787001291L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long attrMatchRuleID;
    private long targetAttributeDefID;
    private Long attributeDefID;
    // Type like is/is not
    private Integer type = EnumMatchRuleType.IS;
    private String value;
    // UI Specific
    private String displayFieldName;
    private String displayFieldValue;
    private AttributeDefBean attributeDef;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>AttrMatchRuleBean</code>
     */
    public AttrMatchRuleBean() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the attrMatchRuleID.
     */
    public Long getAttrMatchRuleID() {
        return attrMatchRuleID;
    }

    /**
     * @param attrMatchRuleID
     *            The attrMatchRuleID to set.
     */
    public void setAttrMatchRuleID(Long attrMatchRuleID) {
        this.attrMatchRuleID = attrMatchRuleID;
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
     * @return Returns the type.
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     *            The type to set.
     */
    public void setType(Integer type) {
        this.type = type;
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
     * @return Returns the targetAttributeDefID.
     */
    public long getTargetAttributeDefID() {
        return targetAttributeDefID;
    }

    /**
     * @param targetAttributeDefID
     *            The targetAttributeDefID to set.
     */
    public void setTargetAttributeDefID(long targetAttributeDefID) {
        this.targetAttributeDefID = targetAttributeDefID;
    }

    /**
     * @return Returns the displayType.
     */
    public String getDisplayType() {
        return EnumMatchRuleType.toString(type);
    }

    /**
     * @return Returns the displayFieldName.
     */
    public String getDisplayFieldName() {
        return displayFieldName;
    }

    /**
     * @param displayFieldName
     *            The displayFieldName to set.
     */
    public void setDisplayFieldName(String displayFieldName) {
        this.displayFieldName = displayFieldName;
    }

    /**
     * @return Returns the displayFieldValue.
     */
    public String getDisplayFieldValue() {
        return displayFieldValue;
    }

    /**
     * @param displayFieldValue
     *            The displayFieldValue to set.
     */
    public void setDisplayFieldValue(String displayFieldValue) {
        this.displayFieldValue = displayFieldValue;
    }

    /**
     * @return Returns the attributeDef.
     */
    public AttributeDefBean getAttributeDef() {
        return attributeDef;
    }

    /**
     * @param attributeDef
     *            The attributeDef to set.
     */
    public void setAttributeDef(AttributeDefBean attributeDef) {
        this.attributeDef = attributeDef;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
