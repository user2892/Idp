/**
 * 
 */
package com.bectran.b2b.cspack.beans;

import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 * @date Jan 12, 2013 : 9:35:06 PM
 */
public class CsPackBean {
    private String userId;
    private Long id; // same as request ID;
    private Date lastUpdate;
    private String assignmentStatus = MatrixConstants.ASSIGNMENT_STATUS_ASSIGNED;
    //
    private String fullName;
    //
    private CsUserDetailBean csUserDetail;

    //
    public CsPackBean() {
    }

    //
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    public boolean isAssigned() {
        if (this.getAssignmentStatus() != null && this.getAssignmentStatus()
                .trim().equals(MatrixConstants.ASSIGNMENT_STATUS_ASSIGNED)) {
            return true;
        }
        return false;
    }

    public CsUserDetailBean getCsUserDetail() {
        return csUserDetail;
    }

    public void setCsUserDetail(CsUserDetailBean csUserDetail) {
        this.csUserDetail = csUserDetail;
    }
}
