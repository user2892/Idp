/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.bectran.attribute.constants.EnumConditionType;
import com.bectran.attribute.constants.EnumMatchType;

/**
 * @author shanmu
 * @date 10-May-2016 3:15:36 pm
 */
public class AttrConditionRuleBean extends BaseEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -1702057077157042867L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long attributeDefID;
    // Type like - show/hide/required/optional
    private Integer type;
    // Match like All/Any
    private Integer match;
    private Set<AttrMatchRuleBean> attrMatchRuleSet;
    private List<AttrMatchRuleBean> attrMatchRules;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>AttrConditionRuleBean</code>
     */
    public AttrConditionRuleBean() {
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
     * @return Returns the match.
     */
    public Integer getMatch() {
        return match;
    }

    /**
     * @param match
     *            The match to set.
     */
    public void setMatch(Integer match) {
        this.match = match;
    }

    /**
     * @return Returns the typeStr.
     */
    public String getTypeStr() {
        return EnumConditionType.toString(type);
    }

    /**
     * @return Returns the matchStr.
     */
    public String getMatchStr() {
        return EnumMatchType.toString(match);
    }

    /**
     * @return Returns the attrMatchRuleSet.
     */
    public Set<AttrMatchRuleBean> getAttrMatchRuleSet() {
        return attrMatchRuleSet;
    }

    /**
     * @param attrMatchRuleSet
     *            The attrMatchRuleSet to set.
     */
    public void setAttrMatchRuleSet(Set<AttrMatchRuleBean> attrMatchRuleSet) {
        this.attrMatchRuleSet = attrMatchRuleSet;
    }

    /**
     * @return Returns the attrMatchRules.
     */
    public List<AttrMatchRuleBean> getAttrMatchRules() {
        if (attrMatchRuleSet != null) {
            attrMatchRules = new ArrayList<AttrMatchRuleBean>(attrMatchRuleSet);
        }
        return attrMatchRules;
    }

    /**
     * @param attrMatchRules
     *            The attrMatchRules to set.
     */
    public void setAttrMatchRules(List<AttrMatchRuleBean> attrMatchRules) {
        this.attrMatchRules = attrMatchRules;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
