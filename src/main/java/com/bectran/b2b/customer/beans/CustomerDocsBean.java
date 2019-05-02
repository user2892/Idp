/**
 * 
 */
package com.bectran.b2b.customer.beans;

import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.matrix.utils.DateUtility;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 22, 2012 : 3:34:16 PM
 */
public class CustomerDocsBean extends CustomerDocsBaseBean {

    //
    // private MonitoredDocUpdateTrackerBean docUpdateTracker;
    // protected boolean showDocUpdateTrackerStatus;
    //
    public CustomerDocsBean() {
    }

    public int getDaysExpired() {
        return DateUtility.computeDays(this.getExpiration(), new Date());
    }

    /**
     * @return the hasExpiration
     */
    public boolean isHasExpiration() {
        if (this.getExpirationDateRqd() == null
                || this.getExpirationDateRqd().trim().length() < 2) {
            return true;
        }
        if (this.getExpirationDateRqd().trim()
                .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public int getDaysToExpire() {
        return DateUtility.computeDays(new Date(), this.getExpiration());
    }


    public boolean isExpired() {
        if (this.getExpiration() == null) {
            return false;
        }
        return this.getExpiration().before(new Date()) ? true : false;
    }


    public boolean getDaysToExpireWithin30Day() {
        return this.getDaysToExpire() < 30 ? true : false;
    }

}
