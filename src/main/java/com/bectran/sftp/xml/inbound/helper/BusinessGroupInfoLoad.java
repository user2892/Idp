/**
 * 
 */
package com.bectran.sftp.xml.inbound.helper;

import com.bectran.b2b.supplier.beans.GroupAccountBean;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.sftp.xml.inbound.BusinessGroupXmlBean;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 5, 2013 : 8:17:48 PM
 */
public class BusinessGroupInfoLoad extends CustomerDataLoadBase {
    public BusinessGroupXmlBean initializeTrxnBean(GroupAccountBean bean)
            throws DataAccessException {
        //
        BusinessGroupXmlBean txn = new BusinessGroupXmlBean();
        //
        txn.setBectranReferenceId(bean.getId().toString());
        //
        txn.setGroupName(getValueForXml(bean.getName()));
        //
        txn.setInternalGroupCode(getValueForXml(bean.getInternalGroupCode()));
        return txn;
    }
}
