package com.bectran.b2b.supplier.beans;

import java.io.Serializable;

public class UserGroupBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private Long businessGroupId;
    //
    private GroupAccountBean businessGroup;

    //
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
