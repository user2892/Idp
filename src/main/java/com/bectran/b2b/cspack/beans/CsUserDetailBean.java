/**
 * 
 */
package com.bectran.b2b.cspack.beans;

import java.io.Serializable;

import com.bectran.b2b.base.beans.UserBaseBean;

/**
 * @author LOUIS IFEGUNI
 * @date Jul 10, 2013 : 8:57:18 PM
 */
public class CsUserDetailBean extends UserBaseBean implements Serializable {
    private static final long serialVersionUID = 1L;

    public CsUserDetailBean() {
    }
    //
    protected String salesRepNameWithCode;

    //
    public String getSalesRepNameWithCode() {
        if (this.getInternalCode() == null
                || this.getInternalCode().trim().equalsIgnoreCase("N/A")
                || this.getInternalCode().trim().length() < 1) {
            return this.getUserName();
        }
        return this.getUserName() + " - " + this.getInternalCode();
    }

    public void setSalesRepNameWithCode(String salesRepNameWithCode) {
        this.salesRepNameWithCode = salesRepNameWithCode;
    }
}
