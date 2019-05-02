/**
 * 
 */
package com.bectran.opsmgt.beans;

import java.util.Comparator;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 * @date Dec 23, 2012 : 1:44:53 PM
 */
public class OpsUnitParentBean {
    public static final Comparator<OpsUnitParentBean> ASCENDING_ORDER = new Comparator<OpsUnitParentBean>() {
        public int compare(OpsUnitParentBean r1, OpsUnitParentBean r2) {
            return r1.getName().compareTo(r2.getName());
        }
    };
    private Long id;
    private Long headerId;
    private String name;
    private String status = MatrixConstants.STATUS_ACTIVE;
    private String globalScope = MatrixConstants.ANSWER_YES;
    private Long categoryId;
    private String internalCode = "N/A";
    //
    private OpsUnitParentCategoryBean category;

    //
    public OpsUnitParentBean() {
    }

    //
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGlobalScope() {
        return globalScope;
    }

    public void setGlobalScope(String globalScope) {
        this.globalScope = globalScope;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public OpsUnitParentCategoryBean getCategory() {
        return category;
    }

    public void setCategory(OpsUnitParentCategoryBean category) {
        this.category = category;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }
}
