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
import com.bectran.sftp.xml.inbound.ShippingInfoXmlBean;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 2, 2013 : 8:17:48 PM
 */
public class ShippingInfoLoad extends CustomerDataLoadBase {
    public List<ShippingInfoXmlBean> initializeTrxnBean(Set<AppOtherContactBean> contactSet)
            throws DataAccessException {
        List<ShippingInfoXmlBean> list = new ArrayList<ShippingInfoXmlBean>();
        List<AppOtherContactBean> billingInfoList = shipBillInfo(
                MatrixConstants.CONTACT_SHIPPING, contactSet);
        for (AppOtherContactBean bean : billingInfoList) {
            ShippingInfoXmlBean txn = new ShippingInfoXmlBean();
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
            txn.setAddressLineOne(getValueForXml(bean.getAddressLineOne()));
            //
            txn.setAddressLineTwo(getValueForXml(bean.getAddressLineTwo()));
            //
            txn.setCity(getValueForXml(bean.getCity()));
            //
            txn.setState(getValueForXml(bean.getState()));
            //
            txn.setCountryId(getValueForXml(bean.getCountryId()));
            //
            txn.setZipCode(getValueForXml(bean.getZipCode()));
            //
            list.add(txn);
        }
        return list;
    }
}
