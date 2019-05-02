/**
 * 
 */
package com.bectran.b2b.customer.beans;

import java.util.List;

import com.bectran.b2b.supplier.beans.GroupCustomAppCategoryBaseBean;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 3, 2012 : 5:49:24 PM
 */
public class CustomCreditAppValuesLayoutBeanBean
        extends GroupCustomAppCategoryBaseBean {
    //
    private List<CustomCreditAppValuesBean> valuesList;

    //
    public CustomCreditAppValuesLayoutBeanBean() {
    }

    //
    public List<CustomCreditAppValuesBean> getValuesList() {
        return valuesList;
    }

    public void setValuesList(List<CustomCreditAppValuesBean> valuesList) {
        this.valuesList = valuesList;
    }
}
