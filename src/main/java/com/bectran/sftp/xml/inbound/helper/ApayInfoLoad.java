/**
 * 
 */
package com.bectran.sftp.xml.inbound.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.customer.beans.AppOtherContactBean;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.sftp.xml.inbound.ApayInfoXmlBean;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 2, 2013 : 8:17:48 PM
 */
public class ApayInfoLoad extends CustomerDataLoadBase {
    public List<ApayInfoXmlBean> initializeTrxnBean(Set<AppOtherContactBean> contactSet)
            throws DataAccessException {
        List<ApayInfoXmlBean> list = new ArrayList<ApayInfoXmlBean>();
        List<AppOtherContactBean> billingInfoList = shipBillInfo(
                MatrixConstants.CONTACT_APAYABLE, contactSet);
        for (AppOtherContactBean bean : billingInfoList) {
            ApayInfoXmlBean txn = new ApayInfoXmlBean();
            //
            txn.setFirstName(getValueForXml(bean.getFirstName()));
            //
            txn.setLastName(getValueForXml(bean.getLastName()));
            //
            txn.setEmail(getValueForXml(bean.getEmail()));
            //
            txn.setPhone(getValueForXml(bean.getPhone()));
            //
            txn.setSalutation(getValueForXml(bean.getSalutation()));
            //
            txn.setFax(getValueForXml(bean.getFax()));
            //
            list.add(txn);
        }
        return list;
    }
}
