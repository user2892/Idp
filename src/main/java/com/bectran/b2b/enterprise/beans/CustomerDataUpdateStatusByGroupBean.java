/**
 * 
 */
package com.bectran.b2b.enterprise.beans;

import java.io.Serializable;

/**
 * @author Louis Ifeguni Jan 20, 2016:3:37:00 PM
 */
public class CustomerDataUpdateStatusByGroupBean
        extends CustomerDataUpdateStatusBaseBean implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    private Long groupId;

    //
    public CustomerDataUpdateStatusByGroupBean() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    //
}
