/**
 * 
 */
package com.bectran.b2b.supplier.beans;

import java.util.Comparator;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 2, 2012 : 8:58:52 PM
 */
public class GroupCustomCreditAppListContentBean {
    public static final Comparator<GroupCustomCreditAppListContentBean> ASCENDING_ORDER = new Comparator<GroupCustomCreditAppListContentBean>() {
        public int compare(GroupCustomCreditAppListContentBean r1,
                           GroupCustomCreditAppListContentBean r2) {
            return r1.getName().compareTo(r2.getName());
        }
    };
    private Long id;
    private Long headerId;
    private String name;

    public GroupCustomCreditAppListContentBean() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
