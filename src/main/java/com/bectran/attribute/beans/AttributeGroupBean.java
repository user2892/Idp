/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.bectran.attribute.constants.EnumConditionType;
import com.bectran.attribute.constants.EnumMatchRuleType;
import com.bectran.attribute.constants.EnumMatchType;
import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author Shanmu
 * @date Jun 28, 2015 3:29:48 PM
 */
public class AttributeGroupBean extends BaseEntity implements Serializable,
        Comparable<AttributeGroupBean> {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 141271424454245562L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long attributeGroupID;
    private String name;
    private String description;
    private Integer showOrder;
    // 0- public , 1- private, 2- system ,3 - internal
    private int accessType = 0;
    private Integer flags = 0;
    private String params;
    private Long supplierID;
    private Long groupID;
    private String appType;
    private Set<AttributeDefBean> attributes;
    private List<AttributeDefBean> attributesList;
    private String status = MatrixConstants.STATUS_ACTIVE;
    private String preQualReq=MatrixConstants.ANSWER_NO;
    // UI specific
    private boolean conditionalBoo;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>AttributeGroup</code>
     */
    public AttributeGroupBean() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
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
     * @return Returns the accessType.
     */
    public int getAccessType() {
        return accessType;
    }

    /**
     * @param accessType
     *            The accessType to set.
     */
    public void setAccessType(int accessType) {
        this.accessType = accessType;
    }

    /**
     * @return Returns the flags.
     */
    public Integer getFlags() {
        return flags;
    }

    /**
     * @param flags
     *            The flags to set.
     */
    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    /**
     * @return Returns the params.
     */
    public String getParams() {
        return params;
    }

    /**
     * @param params
     *            The params to set.
     */
    public void setParams(String params) {
        this.params = params;
    }

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
     * @return Returns the attributes.
     */
    public Set<AttributeDefBean> getAttributes() {
        return attributes;
    }

    /**
     * @param attributes
     *            The attributes to set.
     */
    public void setAttributes(Set<AttributeDefBean> attributes) {
        this.attributes = attributes;
    }

    /**
     * @return Returns the attributesList.
     */
    public List<AttributeDefBean> getAttributesList() {
        if (attributes != null && attributesList == null) {
            attributesList = new ArrayList<AttributeDefBean>();
            for (AttributeDefBean attributeDefBean : attributes) {
                if (StringUtils.equals(MatrixConstants.STATUS_ACTIVE,
                        attributeDefBean.getStatus())) {
                    attributesList.add(attributeDefBean);
                }
            }
            Collections.sort(attributesList);
        }
        return attributesList;
    }

    /**
     * @return Returns the attributesList.
     */
    public List<AttributeDefBean> getAllAttributesList() {
        if (attributes != null && attributesList == null) {
            attributesList = new ArrayList<AttributeDefBean>();
            for (AttributeDefBean attributeDefBean : attributes) {
                attributesList.add(attributeDefBean);
            }
        }
        return attributesList;
    }

    /**
     * @param attributesList
     *            The attributesList to set.
     */
    public void setAttributesList(List<AttributeDefBean> attributesList) {
        this.attributesList = attributesList;
    }

    /**
     * @return Returns the appType.
     */
    public String getAppType() {
        return appType;
    }

    /**
     * @param appType
     *            The appType to set.
     */
    public void setAppType(String appType) {
        this.appType = appType;
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
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(AttributeGroupBean o) {
        return getShowOrder().compareTo(o.getShowOrder());
    }

    /**
     * @return
     */
    public void evaluateConditionalWidgets() {
        List<AttributeDefBean> attributes = getAttributesList();
        if (attributes != null) {
            for (AttributeDefBean attributeDefBean : attributes) {
                if (attributeDefBean.isSingleSelectBoo()
                        || attributeDefBean.isBooleanBoo()
                        || attributeDefBean.isIntegerBoo()) {
                    conditionalBoo = true;
                }
            }
        }
    }

    /**
     * @return Returns the conditionalBoo.
     */
    public boolean isConditionalBoo() {
        evaluateConditionalWidgets();
        return conditionalBoo;
    }

    /**
     * @param conditionalBoo
     *            The conditionalBoo to set.
     */
    public void setConditionalBoo(boolean conditionalBoo) {
        this.conditionalBoo = conditionalBoo;
    }

    /**
     * @return
     */
    public Map<String, AttributeDefBean> mapOfAttrDefWithID() {
        Map<String, AttributeDefBean> result = new HashMap<String, AttributeDefBean>();
        List<AttributeDefBean> attributes = getAttributesList();
        if (attributes != null) {
            for (AttributeDefBean attributeDefBean : attributes) {
                result.put(attributeDefBean.getId(), attributeDefBean);
            }
        }
        return result;
    }

    /**
     * @return
     */
    public Map<Long, AttributeDefBean> mapOfAttrDef() {
        Map<Long, AttributeDefBean> result = new HashMap<Long, AttributeDefBean>();
        List<AttributeDefBean> attributes = getAttributesList();
        if (attributes != null) {
            for (AttributeDefBean attributeDefBean : attributes) {
                result.put(attributeDefBean.getAttributeDefID(),
                        attributeDefBean);
            }
        }
        return result;
    }

    /**
     * @param attrDefID
     * @return
     */
    public AttributeDefBean findByAttrDefID(long attrDefID) {
        Map<Long, AttributeDefBean> attrDefs = mapOfAttrDef();
        return attrDefs.get(attrDefID);
    }

    /**
     * @param uniqueID
     * @return
     */
    public AttributeDefBean getAttributeDefBean(String uniqueID) {
        Map<String, AttributeDefBean> result = mapOfAttrDefWithID();
        return result.get(uniqueID);
    }

    /**
     * @param attributeDefBean
     */
    public void evaluateValues(AttributeDefBean attributeDefBean) {
        if (attributeDefBean != null) {
            Map<Long, AttributeDefBean> attrDefsMap = mapOfAttrDef();
            AttrConditionRuleBean attrConditionRuleBean = attributeDefBean
                    .getAttrConditionRuleBean();
            if (attrConditionRuleBean == null) {
                attributeDefBean.setShowRuleBoo(true);
                attributeDefBean.setRequiredRuleBoo(attributeDefBean
                        .isRequiredBoo());
                return;
            }
            List<AttrMatchRuleBean> rules = attrConditionRuleBean
                    .getAttrMatchRules();
            if (rules == null || rules.size() <= 0) {
                return;
            }
            int shro = attrConditionRuleBean.getType();
            int allOrAny = attrConditionRuleBean.getMatch();
            boolean all = (EnumMatchType.ALL == allOrAny);
            if (rules != null) {
                boolean match = true;
                for (AttrMatchRuleBean attrMatchRuleBean : rules) {
                    long attrDefID = attrMatchRuleBean.getAttributeDefID();
                    int type = attrMatchRuleBean.getType();
                    String value = attrMatchRuleBean.getValue();
                    AttributeDefBean attrDef = attrDefsMap.get(attrDefID);
                    if (attrDef == null) {
                        continue;
                    }
                    switch (type) {
                    case EnumMatchRuleType.IS:
                        match = StringUtils.equals(value, attrDef.getValue());
                        break;
                    case EnumMatchRuleType.IS_NOT:
                        match = !StringUtils.equals(value, attrDef.getValue());
                        break;
                    default:
                        match = true;
                        break;
                    }
                    if (all && match) {
                        continue;
                    } else if (all && !match) {
                        break;
                    } else if (!all && match) {
                        break;
                    }
                }
                attributeDefBean.resetRules();
                attributeDefBean.setRuleMatchBoo(match);
                if (match) {
                    switch (shro) {
                    case EnumConditionType.SHOW:
                        attributeDefBean.setShowRuleBoo(true);
                        attributeDefBean.setRequiredRuleBoo(attributeDefBean.isRequiredBoo());
                        break;
                    case EnumConditionType.REQUIRED:
                        attributeDefBean.setShowRuleBoo(true);
                        attributeDefBean.setRequiredRuleBoo(true);
                        break;
                    case EnumConditionType.HIDE:
                        attributeDefBean.setShowRuleBoo(false);
                        attributeDefBean.setRequiredRuleBoo(false);
                        break;
                    case EnumConditionType.OPTIONAL:
                        attributeDefBean.setShowRuleBoo(true);
                        attributeDefBean.setRequiredRuleBoo(false);
                        break;
                    }
                } else if (!match) {
                    switch (shro) {
                    case EnumConditionType.SHOW:
                        attributeDefBean.setShowRuleBoo(false);
                        break;
                    case EnumConditionType.HIDE:
                        attributeDefBean.setShowRuleBoo(true);
                        attributeDefBean.setRequiredRuleBoo(attributeDefBean
                                .isRequiredBoo());
                        break;
                    case EnumConditionType.REQUIRED:
                        attributeDefBean.setShowRuleBoo(true);
                        attributeDefBean.setRequiredRuleBoo(false);
                        break;
                    case EnumConditionType.OPTIONAL:
                        attributeDefBean.setShowRuleBoo(true);
                        attributeDefBean.setRequiredRuleBoo(true);
                        break;
                    }
                } else {
                    attributeDefBean.setShowRuleBoo(true);
                    attributeDefBean.setRequiredRuleBoo(attributeDefBean
                            .isRequiredBoo());
                }
            }
        }
    }
 
    /**
     * @return Returns the preQualReq.
     */
    public String getPreQualReq() {
        return preQualReq;
    }

    /**
     * @param preQualReq The preQualReq to set.
     */
    public void setPreQualReq(String preQualReq) {
        this.preQualReq = preQualReq;
    }
    
    /**
     * @return
     */
    public boolean isPreQualReqBoo(){
        return StringUtils.equals(MatrixConstants.ANSWER_YES, preQualReq);
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
