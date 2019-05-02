/**
 * 
 */
package com.bectran.b2b.supplier.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 1, 2012 : 7:15:24 PM
 */
public class GroupCustomCreditAppModelBean
        extends GroupCustomCreditAppModelBaseBean {
    private Set<GroupCustomCreditAppListContentBean> listContentSet;

    //
    public GroupCustomCreditAppModelBean() {
    }
    //

    public Set<GroupCustomCreditAppListContentBean> getListContentSet() {
        return listContentSet;
    }

    public void setListContentSet(Set<GroupCustomCreditAppListContentBean> listContentSet) {
        this.listContentSet = listContentSet;
    }

    public List<GroupCustomCreditAppListContentBean> getContentList() {
        List<GroupCustomCreditAppListContentBean> ls = new ArrayList<GroupCustomCreditAppListContentBean>();
        for (Iterator<GroupCustomCreditAppListContentBean> i = this
                .getListContentSet().iterator(); i.hasNext();) {
            GroupCustomCreditAppListContentBean doc = (GroupCustomCreditAppListContentBean) i
                    .next();
            ls.add(doc);
        }
        Collections.sort(ls,
                GroupCustomCreditAppListContentBean.ASCENDING_ORDER);
        return ls;
    }

}
