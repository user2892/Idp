/**
 * 
 */
package com.bectran.sftp.xml.inbound.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.bectran.b2b.customer.beans.AppOfficerBean;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.sftp.xml.inbound.OwnerOfficerInfoXmlBean;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 2, 2013 : 8:17:48 PM
 */
public class OwnerOfficerInfoLoad extends CustomerDataLoadBase {
    public List<OwnerOfficerInfoXmlBean> initializeTrxnBean(Set<AppOfficerBean> officerSet)
            throws DataAccessException {
        List<OwnerOfficerInfoXmlBean> list = new ArrayList<OwnerOfficerInfoXmlBean>();
        for (AppOfficerBean bean : officerSet) {
            OwnerOfficerInfoXmlBean txn = new OwnerOfficerInfoXmlBean();
            //
            txn.setFirstName(getValueForXml(bean.getFirstName()));
            //
            txn.setLastName(getValueForXml(bean.getLastName()));
            //
            txn.setPersTitle(getValueForXml(bean.getPersTitle()));
            //
            txn.setPhone(getValueForXml(bean.getPhone()));
            //
            txn.setSalutation(getValueForXml(bean.getSalutation()));
            //
            list.add(txn);
        }
        return list;
    }
}
