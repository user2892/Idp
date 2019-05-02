/**
 * 
 */
package com.bectran.opsmgt.beans;

import com.bectran.b2b.supplier.beans.GroupAccountBean;

/**
 * @author LOUIS IFEGUNI
 * @date Mar 28, 2013 : 3:25:08 PM
 */
public class OpsUnitByGroupBean {
    private Long id; // ops unit id
    private Long businessGroupId;
    private GroupAccountBean businessGroup;

    public OpsUnitByGroupBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessGroupId() {
        return businessGroupId;
    }

    public void setBusinessGroupId(Long businessGroupId) {
        this.businessGroupId = businessGroupId;
    }

    public GroupAccountBean getBusinessGroup() {
        return businessGroup;
    }

    public void setBusinessGroup(GroupAccountBean businessGroup) {
        this.businessGroup = businessGroup;
    }
}
