/**
 * 
 */
package com.bectran.sftp.xml.inbound.helper;

import com.bectran.b2b.cspack.beans.CsUserDetailBean;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.sftp.xml.inbound.SalesRepInfoXmlBean;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 2, 2013 : 8:17:48 PM
 */
public class SalesRepInfoLoad extends CustomerDataLoadBase {
    public SalesRepInfoXmlBean initializeTrxnBean(CsUserDetailBean bean)
            throws DataAccessException {
        SalesRepInfoXmlBean txn = new SalesRepInfoXmlBean();
        //
        txn.setFirstName(getValueForXml(bean.getFirstName()));
        //
        txn.setLastName(getValueForXml(bean.getLastName()));
        //
        txn.setInternalCode(getValueForXml(bean.getInternalCode()));
        return txn;
    }
}
