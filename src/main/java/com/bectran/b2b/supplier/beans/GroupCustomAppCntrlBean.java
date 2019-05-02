/**
 * 
 */
package com.bectran.b2b.supplier.beans;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 * @date Jul 19, 2013 : 2:23:19 PM
 */
public class GroupCustomAppCntrlBean {
    private String id;
    private Long groupId;
    private String formType;
    private String status = MatrixConstants.STATUS_ACTIVE;
    private String name;
    //
    private String page1Status = MatrixConstants.STATUS_ACTIVE;
    private String page2Status = MatrixConstants.STATUS_ACTIVE;
    //
    public GroupCustomAppCntrlBean() {
    }

    //
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActiveStatus() {
        return this.getStatus().trim().equals(MatrixConstants.STATUS_ACTIVE)
                ? true : false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPage1Status() {
        return page1Status;
    }

    public void setPage1Status(String page1Status) {
        this.page1Status = page1Status;
    }

    public String getPage2Status() {
        return page2Status;
    }

    public void setPage2Status(String page2Status) {
        this.page2Status = page2Status;
    }

    public boolean isPage1StatusActive() {
        return this.getPage1Status().trim()
                .equals(MatrixConstants.STATUS_ACTIVE) ? true : false;
    }

    public boolean isPage2StatusActive() {
        return this.getPage2Status().trim()
                .equals(MatrixConstants.STATUS_ACTIVE) ? true : false;
    }

}
