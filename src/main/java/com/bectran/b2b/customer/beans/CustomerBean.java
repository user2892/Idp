package com.bectran.b2b.customer.beans;

import com.bectran.b2b.base.beans.CustomerBaseBean;

/**
 * @author LOUIS IFEGUNI Jan 05, 2010: 2:27:38 PM
 */
public class CustomerBean extends CustomerBaseBean {
    private boolean recordFound = false;
    //
    private String clientUpdateFlag = "";// set to 'YES' if change needs to be
                                         // updated in client's database

    /**
     * DEFAULT CONSTRUCTOR
     */
    public CustomerBean() {
    }

    /**
     * Companies relationships map
     * 
     * @return
     */
    /**
     * @return
     */
    public boolean isRecordFound() {
        return recordFound;
    }

    /**
     * @param b
     */
    public void setRecordFound(boolean b) {
        recordFound = b;
    }

    /**
     * @return Returns the hasCrolId.
     */
    public boolean isHasCrolId() {
        try {
            if (this.getCrolCompanyId() != null
                    && this.getCrolCompanyId().trim().substring(0, 2)
                            .equals("TN")
                    && this.getCrolCompanyId().length() > 4) {
                return true;
            }
        }
        catch (Exception e) {
            return false;
        }
        return false;
    }

    public String getClientUpdateFlag() {
        return clientUpdateFlag;
    }

    public void setClientUpdateFlag(String clientUpdateFlag) {
        this.clientUpdateFlag = clientUpdateFlag;
    }
}
