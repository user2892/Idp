/**
 * 
 */
package com.bectran.opsmgt.beans;

import java.util.Date;

/**
 * @author LOUIS IFEGUNI
 * @date Jan 1, 2013 : 1:03:59 PM
 */
public class OpsUnitRequestMgtBean {
    private Long id;
    private Long opsUnitId;
    private Date lastUpdate;
    //
    private Long parentId;
    private String parentIdInput;
    private OpsUnitDefinitionBean OpsUnitBean;
    //
    private String opsUnitName;

    public OpsUnitRequestMgtBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long requestId) {
        this.id = requestId;
    }

    public Long getOpsUnitId() {
        return opsUnitId;
    }

    public void setOpsUnitId(Long queueId) {
        this.opsUnitId = queueId;
    }

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public String getOpsUnitName() {
        return opsUnitName;
    }

    public void setOpsUnitName(String opsUnitName) {
        this.opsUnitName = opsUnitName;
    }

    public OpsUnitDefinitionBean getOpsUnitBean() {
        return OpsUnitBean;
    }

    public void setOpsUnitBean(OpsUnitDefinitionBean opsUnitBean) {
        OpsUnitBean = opsUnitBean;
    }

    public String getOpsUnitQualifiedName() {
        return this.getOpsUnitBean().getParent().getName() + " - "
                + this.getOpsUnitBean().getName();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIdInput() {
        return parentIdInput;
    }

    public void setParentIdInput(String parentIdInput) {
        this.parentIdInput = parentIdInput;
    }
}
