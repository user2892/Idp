/**
 * 
 */
package com.bectran.opsmgt.beans;

import java.util.Comparator;

/**
 * @author LOUIS IFEGUNI
 * @date Dec 23, 2012 : 1:44:53 PM
 */
public class OpsUnitParentCategoryBean {
    public static final Comparator<OpsUnitParentCategoryBean> ASCENDING_ORDER = new Comparator<OpsUnitParentCategoryBean>() {
        public int compare(OpsUnitParentCategoryBean r1,
                           OpsUnitParentCategoryBean r2) {
            return r1.getName().compareTo(r2.getName());
        }
    };
    private Long id;
    private Long headerId;
    private String name;
    private String internalCode = "N/A";

    //
    public OpsUnitParentCategoryBean() {
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

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }
}
