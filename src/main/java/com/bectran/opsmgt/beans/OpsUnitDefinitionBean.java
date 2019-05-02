/**
 * 
 */
package com.bectran.opsmgt.beans;

import java.util.Comparator;
import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 * @date Dec 23, 2012 : 1:44:53 PM
 */
public class OpsUnitDefinitionBean {
    public static final Comparator<OpsUnitDefinitionBean> ASCENDING_ORDER = new Comparator<OpsUnitDefinitionBean>() {
        public int compare(OpsUnitDefinitionBean r1, OpsUnitDefinitionBean r2) {
            return r1.getName().compareTo(r2.getName());
        }
    };
    public static final Comparator<OpsUnitDefinitionBean> ASCENDING_ORDER_DISPLAN_NAME = new Comparator<OpsUnitDefinitionBean>() {
        public int compare(OpsUnitDefinitionBean r1, OpsUnitDefinitionBean r2) {
            return r1.getDisplayName().compareTo(r2.getDisplayName());
        }
    };
    private Long id;
    private Long headerId;
    private String name;
    private Date lastAssignment;
    private String status = MatrixConstants.STATUS_ACTIVE;
    private String globalScope = MatrixConstants.ANSWER_YES;
    private Long parentId;
    private String internalCode = "N/A";
    private OpsUnitParentBean parent;
    //
    private OpsUnitByGroupBean opsUnitGroup;
    //
    private Long groupId;
    //
    private String displayName;
    //

    public boolean isShowBizGroupSelectionWin() {
        return this.getGlobalScope().trim()
                .equalsIgnoreCase(MatrixConstants.ANSWER_NO) ? true : false;
    }

    public OpsUnitDefinitionBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastAssignment() {
        return (Date) (lastAssignment == null ? null : lastAssignment.clone());
    }

    public void setLastAssignment(Date lastAssignment) {
        this.lastAssignment = (Date) (lastAssignment == null ? null : lastAssignment.clone());
    }

    public String getGlobalScope() {
        return globalScope;
    }

    public void setGlobalScope(String globalScope) {
        this.globalScope = globalScope;
    }

    public OpsUnitByGroupBean getOpsUnitGroup() {
        return opsUnitGroup;
    }

    public void setOpsUnitGroup(OpsUnitByGroupBean opsUnitGroup) {
        this.opsUnitGroup = opsUnitGroup;
    }

    public boolean isScopeIsGlobal() {
        return this.getGlobalScope().trim().equals(MatrixConstants.ANSWER_YES)
                ? true : false;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public OpsUnitParentBean getParent() {
        return parent;
    }

    public void setParent(OpsUnitParentBean parent) {
        this.parent = parent;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getParentNameLabel() {
        return this.getParent().getName() + " - " + this.getName();
    }
}
