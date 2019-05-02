/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.bectran.attribute.constants.EnumConditionType;
import com.bectran.attribute.constants.EnumMatchRuleType;
import com.bectran.attribute.constants.EnumMatchType;
import com.bectran.b2b.customer.beans.CustomAppAttrValueBean;

/**
 * @author shanmu
 * @date 24-May-2016 8:56:09 pm
 */
public class CustomAppAttrGrpLayout extends AttributeGroupBean {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 1875120354061923775L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private List<CustomAppAttrValueBean> attributeValueList = new ArrayList<CustomAppAttrValueBean>();

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>CustomAppAttrGrpLayout</code>
     */
    public CustomAppAttrGrpLayout() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the attributeValueList.
     */
    public List<CustomAppAttrValueBean> getAttributeValueList() {
       // Collections.sort(attributeValueList);
        return attributeValueList;
    }

    /**
     * @param attributeValueList
     *            The attributeValueList to set.
     */
    public void setAttributeValueList(List<CustomAppAttrValueBean> attributeValueList) {
        this.attributeValueList = attributeValueList;
    }

    /**
     * @param customAppAttrValueDraft
     */
    public void addAttributeValue2List(CustomAppAttrValueBean customAppAttrValue) {
        attributeValueList.add(customAppAttrValue);
    }

    //
    // /**
    // * @return Returns the dynaFormModel.
    // */
    // public DynaFormModel getDynaFormModel() {
    // return dynaFormModel;
    // }
    //
    // /**
    // * @param dynaFormModel
    // * The dynaFormModel to set.
    // */
    // public void setDynaFormModel(DynaFormModel dynaFormModel) {
    // this.dynaFormModel = dynaFormModel;
    // }
    /**
     * @param attributeDefBean
     */
    public void evaluateValues(CustomAppAttrValueBean attrValueDraft) {
        AttributeDefBean attributeDefBean = attrValueDraft.getAttributeDef();
        if (attributeDefBean != null) {
            Map<Long, CustomAppAttrValueBean> attrDefsMap = mapOfAttrValueBeans();
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
                    CustomAppAttrValueBean attrDef = attrDefsMap.get(attrDefID);
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
                        attributeDefBean.setRequiredRuleBoo(attributeDefBean
                                .isRequiredBoo());
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
     * @return
     */
    public Map<Long, CustomAppAttrValueBean> mapOfAttrValueBeans() {
        Map<Long, CustomAppAttrValueBean> result = new HashMap<Long, CustomAppAttrValueBean>();
        List<CustomAppAttrValueBean> attributes = getAttributeValueList();
        if (attributes != null) {
            for (CustomAppAttrValueBean attrValueBean : attributes) {
                result.put(attrValueBean.getAttributeDefID(), attrValueBean);
            }
        }
        return result;
    }

    /**
     * @param id
     * @return
     */
    public CustomAppAttrValueBean findByAttrDefID(long attributeDefID, String id) {
        CustomAppAttrValueBean result = null;
        List<CustomAppAttrValueBean> attributes = getAttributeValueList();
        if (attributes != null) {
            for (CustomAppAttrValueBean attrValueBean : attributes) {
                long attrDefID = attrValueBean.getAttributeDefID();
                String attrDefUIId = attrValueBean.getAttributeDef().getId();
                if (attributeDefID == attrDefID
                        && StringUtils.equals(id, attrDefUIId)) {
                    result = attrValueBean;
                    break;
                }
            }
        }
        return result;
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
