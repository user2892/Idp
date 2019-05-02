/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

import com.bectran.attribute.constants.EnumAttributeType;
import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author Shanmu
 * @date Jun 28, 2015 3:28:52 PM
 */
public class AttributeDefBean extends BaseEntity implements
        Comparable<AttributeDefBean> {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -6762230403241237952L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long attributeDefID;
    private String name;
    private String description;
    private String defaultValue;
    private Long attributeGroupID;
    private Integer attributeTypeID;
    // private Long attributeTypeDefID;
    // 0- public , 1- private, 2- system ,3 - internal
    private Integer accessType = 0;
    private Boolean required;
    private Boolean multiple;
    private Integer showOrder;
    private String toolTip;
    private String mask;
    // private AttributeGroupBean attributeGroup;
    // private AttributeTypeBean attributeType;
    // private AttributeTypeDefBean attributeTypeDef;
    private Long supplierID;
    private Long groupID;
    // UI Specific
    private boolean requiredBoo;
    private boolean multipleBoo;
    private boolean maskBoo;
    private boolean listBoo;
    private String value;
    private Date dateValue;
    private boolean booValue;
    private Set<ListValueBean> listValueSet;
    private List<ListValueBean> listValueList;
    private List<String> multiSelectedValues;
    private String status = MatrixConstants.STATUS_ACTIVE;
    private AttrConditionRuleBean attrConditionRuleBean;
    private String id;
    private boolean ruleMatchBoo;
    //
    private boolean showRuleBoo = true;
    private boolean requiredRuleBoo;
    private boolean ajaxEnabled;
    private String targetIDs;
    //Code Changes for BEC-1797
    private String internalCode;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>Attribute</code>
     */
    public AttributeDefBean() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
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

    /**
     * @return Returns the defaultValue.
     */
    public String getDefaultValue() {
        if(StringUtils.isBlank(defaultValue) && isBooleanBoo()){
            defaultValue=String.valueOf(Boolean.FALSE);
        }
        return defaultValue;
    }

    /**
     * @param defaultValue
     *            The defaultValue to set.
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
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
     * @return Returns the accessType.
     */
    public Integer getAccessType() {
        return accessType;
    }

    /**
     * @param accessType
     *            The accessType to set.
     */
    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
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
     * @return Returns the toolTip.
     */
    public String getToolTip() {
        return toolTip;
    }

    /**
     * @param toolTip
     *            The toolTip to set.
     */
    public void setToolTip(String toolTip) {
        this.toolTip = toolTip;
    }

    /**
     * @return Returns the mask.
     */
    public String getMask() {
        return mask;
    }

    /**
     * @param mask
     *            The mask to set.
     */
    public void setMask(String mask) {
        this.mask = mask;
    }

    //
    // /**
    // * @return Returns the attributeGroup.
    // */
    // public AttributeGroupBean getAttributeGroup() {
    // return attributeGroup;
    // }
    //
    // /**
    // * @param attributeGroup
    // * The attributeGroup to set.
    // */
    // public void setAttributeGroup(AttributeGroupBean attributeGroup) {
    // this.attributeGroup = attributeGroup;
    // }
    //
    // /**
    // * @return Returns the attributeType.
    // */
    // public AttributeTypeBean getAttributeType() {
    // return attributeType;
    // }
    //
    // /**
    // * @param attributeType
    // * The attributeType to set.
    // */
    // public void setAttributeType(AttributeTypeBean attributeType) {
    // this.attributeType = attributeType;
    // }
    //
    // /**
    // * @return Returns the attributeTypeDef.
    // */
    // public AttributeTypeDefBean getAttributeTypeDef() {
    // return attributeTypeDef;
    // }
    //
    // /**
    // * @param attributeTypeDef
    // * The attributeTypeDef to set.
    // */
    // public void setAttributeTypeDef(AttributeTypeDefBean attributeTypeDef) {
    // this.attributeTypeDef = attributeTypeDef;
    // }
    /**
     * @return Returns the supplierID.
     */
    public Long getSupplierID() {
        return supplierID;
    }

    /**
     * @param supplierID
     *            The supplierID to set.
     */
    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
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
     * @return Returns the required.
     */
    public Boolean getRequired() {
        return required;
    }

    /**
     * @param required
     *            The required to set.
     */
    public void setRequired(Boolean required) {
        this.required = required;
        if (required != null) {
            requiredBoo = required.booleanValue();
        }
    }

    /**
     * @return Returns the requiredBoo.
     */
    public boolean isRequiredBoo() {
        return requiredBoo;
    }

    /**
     * @param requiredBoo
     *            The requiredBoo to set.
     */
    public void setRequiredBoo(boolean requiredBoo) {
        this.requiredBoo = requiredBoo;
        this.required = requiredBoo;
    }

    /**
     * @return Returns the multiple.
     */
    public Boolean getMultiple() {
        return multiple;
    }

    /**
     * @param multiple
     *            The multiple to set.
     */
    public void setMultiple(Boolean multiple) {
        this.multiple = multiple;
        if (multiple != null) {
            this.multipleBoo = multiple.booleanValue();
        }
    }

    /**
     * @return Returns the multipleBoo.
     */
    public boolean isMultipleBoo() {
        return multipleBoo;
    }

    /**
     * @param multipleBoo
     *            The multipleBoo to set.
     */
    public void setMultipleBoo(boolean multipleBoo) {
        this.multipleBoo = multipleBoo;
        this.multiple = multipleBoo;
    }

    /**
     * @return Returns the maskBoo.
     */
    public boolean isMaskBoo() {
        return maskBoo;
    }

    /**
     * @param maskBoo
     *            The maskBoo to set.
     */
    public void setMaskBoo(boolean maskBoo) {
        reset();
        this.maskBoo = maskBoo;
    }

    /**
     * @return Returns the listBoo.
     */
    public boolean isListBoo() {
        return listBoo;
    }

    /**
     * @param listBoo
     *            The listBoo to set.
     */
    public void setListBoo(boolean listBoo) {
        reset();
        this.listBoo = listBoo;
    }

    /**
     * Reset the list and mask to false
     */
    public void reset() {
        maskBoo = false;
        listBoo = false;
    }

    /**
     * @return
     */
    public String getAttributeTypeStr() {
        return EnumAttributeType.encode(attributeTypeID);
    }

    /**
     * @return
     */
    public boolean isTextBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.TEXT) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @return
     */
    public boolean isDateBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.DATE) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @return
     */
    public boolean isMemoBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.MEMO) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @return
     */
    public boolean isDecimalBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.DECIMAL) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @return
     */
    public boolean isSingleSelectBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.LIST && !isMultipleBoo()) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @return
     */
    public boolean isMultiSelectBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.LIST && isMultipleBoo()) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @return
     */
    public boolean isMaskedBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.MASKED) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @return
     */
    public boolean isIntegerBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.INTEGER) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @return
     */
    public boolean isPasswordBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.PASSWORD) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @return
     */
    public boolean isAttachementBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.ATTACHEMENT) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @return
     */
    public boolean isHtmlBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.HTML) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @return
     */
    public boolean isUrlBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.URL) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @return
     */
    public boolean isCurrencyBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.CURRENCY) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @return
     */
    public boolean isBooleanBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.BOOLEAN) {
                result = true;
            }
        }
        return result;
    }
    
    public boolean isSignatureBoo() {
        boolean result = false;
        if (attributeTypeID != null) {
            int value = attributeTypeID.intValue();
            if (value == EnumAttributeType.SIGNATURE) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @return Returns the value.
     */
    public String getValue() {
        if (StringUtils.isBlank(value)) {
            value = defaultValue;
        }
        //Only for boolean
        if(StringUtils.isBlank(value) && isBooleanBoo()){
            value=String.valueOf(Boolean.FALSE);
        } 
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
     * @return Returns the dateValue.
     */
    public Date getDateValue() {
        if (dateValue == null && StringUtils.isNotBlank(defaultValue)) {
            if (StringUtils.isBlank(mask)) {
                mask = "MM/dd/yyyy";
            }
            try {
                SimpleDateFormat format = new SimpleDateFormat(mask);
                dateValue = format.parse(defaultValue);
            }
            catch (ParseException pe) {
                // Nothing
            }
        }
        return dateValue;
    }

    /**
     * @param dateValue
     *            The dateValue to set.
     */
    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
        if (StringUtils.isBlank(mask)) {
            mask = "MM/dd/yyyy";
        }
        if (dateValue != null) {
            SimpleDateFormat format = new SimpleDateFormat(mask);
            defaultValue = format.format(dateValue);
        }
    }

    /**
     * @return Returns the booValue.
     */
    public boolean isBooValue() {
        return booValue;
    }

    /**
     * @param booValue
     *            The booValue to set.
     */
    public void setBooValue(boolean booValue) {
        this.booValue = booValue;
    }

    /**
     * @return Returns the listValueSet.
     */
    public Set<ListValueBean> getListValueSet() {
        return listValueSet;
    }

    /**
     * @param listValueSet
     *            The listValueSet to set.
     */
    public void setListValueSet(Set<ListValueBean> listValueSet) {
        this.listValueSet = listValueSet;
    }

    /**
     * @return Returns the listValueList.
     */
    public List<ListValueBean> getListValueList() {
        if (listValueSet != null) {
            listValueList = new ArrayList<ListValueBean>(listValueSet);
            Collections.sort(listValueList);
        }
        return listValueList;
    }

    /**
     * @param listValueList
     *            The listValueList to set.
     */
    public void setListValueList(List<ListValueBean> listValueList) {
        this.listValueList = listValueList;
    }

    /**
     * @return Returns the selectedValues.
     */
    public List<Long> getSelectedValues() {
        List<Long> selectedValues = new ArrayList<Long>();
        if (StringUtils.isNotBlank(defaultValue)) {
            StringTokenizer tokens = new StringTokenizer(defaultValue, ",");
            while (tokens.hasMoreTokens()) {
                selectedValues.add(Long.parseLong(tokens.nextToken()));
            }
        }
        return selectedValues;
    }

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(AttributeDefBean o) {
        return getShowOrder().compareTo(o.getShowOrder());
    }

    /**
     * @return the multiSelectedValues
     */
    public List<String> getMultiSelectedValues() {
        if (StringUtils.isNotBlank(defaultValue)) {
            multiSelectedValues = new ArrayList<String>();
            StringTokenizer tokens = new StringTokenizer(defaultValue, ",");
            while (tokens.hasMoreTokens()) {
                multiSelectedValues.add(tokens.nextToken());
            }
        }
        return multiSelectedValues;
    }

    /**
     * @param multiSelectedValues
     *            the multiSelectedValues to set
     */
    public void setMultiSelectedValues(List<String> multiSelectedValues) {
        this.multiSelectedValues = multiSelectedValues;
        if (multiSelectedValues != null && multiSelectedValues.size() > 0) {
            StringBuilder bld = new StringBuilder();
            Iterator<String> iterator = multiSelectedValues.iterator();
            while (iterator.hasNext()) {
                bld.append(iterator.next());
                if (iterator.hasNext()) {
                    bld.append(",");
                }
            }
            defaultValue = bld.toString();
        }
        else {
            defaultValue = "";
        }
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
     * @return Returns the conditionalBoo.
     */
    public boolean isConditionalBoo() {
        boolean conditionalBoo = false;
        if (attrConditionRuleBean != null) {
            conditionalBoo = true;
        }
        return conditionalBoo;
    }

    /**
     * @return Returns the attrConditionRuleBean.
     */
    public AttrConditionRuleBean getAttrConditionRuleBean() {
        return attrConditionRuleBean;
    }

    /**
     * @param attrConditionRuleBean
     *            The attrConditionRuleBean to set.
     */
    public void setAttrConditionRuleBean(AttrConditionRuleBean attrConditionRuleBean) {
        this.attrConditionRuleBean = attrConditionRuleBean;
    }

    /**
     * @return Returns the id.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Returns the ruleMatchBoo.
     */
    public boolean isRuleMatchBoo() {
        return ruleMatchBoo;
    }

    /**
     * @param ruleMatchBoo
     *            The ruleMatchBoo to set.
     */
    public void setRuleMatchBoo(boolean ruleMatchBoo) {
        this.ruleMatchBoo = ruleMatchBoo;
    }

    /**
     * @return Returns the showRuleBoo.
     */
    public boolean isShowRuleBoo() {
        return showRuleBoo;
    }

    /**
     * @param showRuleBoo
     *            The showRuleBoo to set.
     */
    public void setShowRuleBoo(boolean showRuleBoo) {
        this.showRuleBoo = showRuleBoo;
    }

    /**
     * @return Returns the requiredRuleBoo.
     */
    public boolean isRequiredRuleBoo() {
        return requiredRuleBoo;
    }

    /**
     * @param requiredRuleBoo
     *            The requiredRuleBoo to set.
     */
    public void setRequiredRuleBoo(boolean requiredRuleBoo) {
        this.requiredRuleBoo = requiredRuleBoo;
    }

    /**
     * @return Returns the ajaxEnabled.
     */
    public boolean isAjaxEnabled() {
        return ajaxEnabled;
    }

    /**
     * @param ajaxEnabled
     *            The ajaxEnabled to set.
     */
    public void setAjaxEnabled(boolean ajaxEnabled) {
        this.ajaxEnabled = ajaxEnabled;
    }

    /**
     * @return Returns the targetIDs.
     */
    public String getTargetIDs() {
        return targetIDs;
    }

    /**
     * @param targetIDs
     *            The targetIDs to set.
     */
    public void setTargetIDs(String targetIDs) {
        this.targetIDs = targetIDs;
    }

    /**
     * reset rules
     */
    public void resetRules() {
        ruleMatchBoo = false;
        showRuleBoo = true;
        requiredBoo = required != null ? required.booleanValue() : false;
        requiredRuleBoo = requiredBoo;
    }

    /**
     * @param value
     */
    public void add2MultiTextValues(String value) {
        if (multiSelectedValues == null) {
            multiSelectedValues = new ArrayList<String>();
        }
        multiSelectedValues.add(value);
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
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AttributeDefBean [attributeDefID=");
        builder.append(attributeDefID);
        builder.append(", name=");
        builder.append(name);
        builder.append(", description=");
        builder.append(description);
        builder.append(", defaultValue=");
        builder.append(defaultValue);
        builder.append(", attributeGroupID=");
        builder.append(attributeGroupID);
        builder.append(", attributeTypeID=");
        builder.append(attributeTypeID);
        builder.append(", accessType=");
        builder.append(accessType);
        builder.append(", required=");
        builder.append(required);
        builder.append(", multiple=");
        builder.append(multiple);
        builder.append(", showOrder=");
        builder.append(showOrder);
        builder.append(", toolTip=");
        builder.append(toolTip);
        builder.append(", mask=");
        builder.append(mask);
        builder.append(", supplierID=");
        builder.append(supplierID);
        builder.append(", groupID=");
        builder.append(groupID);
        builder.append(", requiredBoo=");
        builder.append(requiredBoo);
        builder.append(", multipleBoo=");
        builder.append(multipleBoo);
        builder.append(", maskBoo=");
        builder.append(maskBoo);
        builder.append(", listBoo=");
        builder.append(listBoo);
        builder.append(", value=");
        builder.append(value);
        builder.append(", dateValue=");
        builder.append(dateValue);
        builder.append(", booValue=");
        builder.append(booValue);
        builder.append(", multiSelectedValues=");
        builder.append(multiSelectedValues);
        builder.append(", status=");
        builder.append(status);
        builder.append(", ruleMatchBoo=");
        builder.append(ruleMatchBoo);
        builder.append("]");
        return builder.toString();
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
