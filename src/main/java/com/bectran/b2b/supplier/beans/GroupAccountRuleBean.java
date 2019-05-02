/**
 * 
 */
package com.bectran.b2b.supplier.beans;

import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author Louis Ifeguni
 * @date Dec 7, 2013 : 2:17:36 PM
 */
public class GroupAccountRuleBean {
    //
    private Long id; // same as supplier id
    private Date lastUpdate;
    private String groupRule = MatrixConstants.GROUP_RULE_BASIC;
    private String groupSearchScope = MatrixConstants.ANSWER_NO;
    //
    private String enterpriseIntegrationScope = MatrixConstants.SCOPE_GLOBAL;
    
    //
    public GroupAccountRuleBean() {
    }
    //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public String getGroupRule() {
        return groupRule;
    }

    public void setGroupRule(String groupRule) {
        this.groupRule = groupRule;
    }

    public boolean isRuleIsBasic() {
        if (this.getGroupRule() != null && this.getGroupRule().trim()
                .equals(MatrixConstants.GROUP_RULE_BASIC)) {
            return true;
        }
        return false;
    }

    public boolean isRuleIsAllOrOne() {
        if (this.getGroupRule() != null && this.getGroupRule().trim()
                .equals(MatrixConstants.GROUP_RULE_ALLORONE)) {
            return true;
        }
        return false;
    }

    public String getGroupSearchScope() {
        return groupSearchScope;
    }

    public void setGroupSearchScope(String groupSearchScope) {
        this.groupSearchScope = groupSearchScope;
    }

    public boolean isSearchScopdeIsGroup() {
        if (this.getGroupSearchScope() != null && this.getGroupSearchScope()
                .trim().equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public String getEnterpriseIntegrationScope() {
        return enterpriseIntegrationScope;
    }

    public void setEnterpriseIntegrationScope(String enterpriseIntegrationScope) {
        this.enterpriseIntegrationScope = enterpriseIntegrationScope;
    }

    public boolean isIntegrationScopeIsGlobal() {
        if (this.getEnterpriseIntegrationScope() == null) {
            return true;
        }
        if (this.getEnterpriseIntegrationScope() != null
                && this.getEnterpriseIntegrationScope().trim()
                        .equals(MatrixConstants.SCOPE_GLOBAL)) {
            return true;
        }
        return false;
    }

}
