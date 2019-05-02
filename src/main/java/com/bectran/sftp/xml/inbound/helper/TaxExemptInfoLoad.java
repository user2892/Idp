/**
 * 
 */
package com.bectran.sftp.xml.inbound.helper;

import java.util.ArrayList;
import java.util.List;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.customer.beans.TaxExemptByRequestBean;
import com.bectran.b2b.customer.beans.TaxExemptCertBean;
import com.bectran.b2b.customer.blo.CustomerDocsBLO;
import com.bectran.b2b.customer.dao.TaxExemptByRequestDAO;
import com.bectran.b2b.supplier.beans.SupplierCompanyBean;
import com.bectran.b2b.supplier.dao.SupplierCompanyDAO;
import com.bectran.sftp.xml.inbound.TaxExemptInfoXmlBean;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 26, 2014 : 11:11:20 AM
 */
public class TaxExemptInfoLoad extends CustomerDataLoadBase {
    public List<TaxExemptInfoXmlBean> loadData(Long requestId,
                                               SupplierCompanyBean supplier)
            throws Exception {
        List<TaxExemptByRequestBean> tecLs = new TaxExemptByRequestDAO()
                .findTaxExemptsForRequest(requestId.longValue());
        //
        if (tecLs == null || tecLs.size() < 1) {
            return null;
        }
        //
        List<TaxExemptInfoXmlBean> result = new ArrayList<TaxExemptInfoXmlBean>();
        for (TaxExemptByRequestBean rq : tecLs) {
            TaxExemptCertBean bean = rq.getExemptCertBean();
            if (bean.getStatus() != null && bean.getStatus().trim()
                    .equals(MatrixConstants.STATUS_ACTIVE)) {
                result.add(initializeXmlBean(bean, supplier));
            }
        }
        return result;
    }

    private TaxExemptInfoXmlBean initializeXmlBean(TaxExemptCertBean cert,
                                                   SupplierCompanyBean supplier) {
        TaxExemptInfoXmlBean bean = new TaxExemptInfoXmlBean();
        bean.setCertNum(getValueForXml(cert.getCertNum()));
        bean.setExpiration(getValueForXml(cert.getExpiration().toString()));
        bean.setHasExpirationDate(getValueForXml(cert.getExpirationDateRqd()));
        bean.setStateCode(getValueForXml(cert.getStateCode()));
        //
        String docFileSystemName = cert.getDocFileSystemName();
        String corpId = supplier.getCorpID().trim();
        try {
            bean.setDocImageUrl(getValueForXml(
                    CustomerDocsBLO.documentURL(docFileSystemName, corpId)));
        }
        catch (Exception e) {
            bean.setDocImageUrl(docFileSystemName);
        }
        //
        return bean;
    }

    public static void main(String[] args) throws Exception {
        //
        System.out.println("-------------start----------");
        TaxExemptCertBean cert = TaxExemptByRequestDAO.getTaxExempt(96);
        SupplierCompanyBean supplier = new SupplierCompanyDAO().findCompany(1);
        //
        TaxExemptInfoXmlBean xmlBean = new TaxExemptInfoLoad()
                .initializeXmlBean(cert, supplier);
        System.out.println("URL: " + xmlBean.getDocImageUrl());
        System.out.println("-------------finish----------");
    }
}
