/**
 * 
 */
package com.bectran.b2b.supplier.beans;

import java.util.Comparator;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 12, 2013 : 3:54:06 PM
 */
public class GroupCustomAppCategoryBaseBean {
    public static final Comparator<GroupCustomAppCategoryBaseBean> ASCENDING_ORDER = new Comparator<GroupCustomAppCategoryBaseBean>() {
        public int compare(GroupCustomAppCategoryBaseBean r1,
                           GroupCustomAppCategoryBaseBean r2) {
            return Integer.valueOf(r1.getDisplayOrder())
                    .compareTo(Integer.valueOf(r2.getDisplayOrder()));
        }
    };
    private Long id;
    private String name;
    private Long groupId;
    private int displayOrder;
    private String status = MatrixConstants.STATUS_ACTIVE;
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
