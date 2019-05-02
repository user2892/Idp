/**
 * 
 */
package com.bectran.sftp.xml.inbound.helper;

import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.opsmgt.beans.OpsUnitDefinitionBean;
import com.bectran.sftp.xml.inbound.OpsUnitInfoXmlBean;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 4, 2013 : 8:17:48 PM
 */
public class OpsUnitInfoLoad extends CustomerDataLoadBase {
    public OpsUnitInfoXmlBean initializeTrxnBean(OpsUnitDefinitionBean bean)
            throws DataAccessException {
        //
        OpsUnitInfoXmlBean txn = new OpsUnitInfoXmlBean();
        //
        txn.setOpsUnitCode(getValueForXml(bean.getInternalCode()));
        //
        txn.setOpsUnitName(getValueForXml(bean.getParentNameLabel()));
        return txn;
    }
}
