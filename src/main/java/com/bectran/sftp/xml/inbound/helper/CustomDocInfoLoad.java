/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.sftp.xml.inbound.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.customer.beans.CustomerDocsBean;
import com.bectran.b2b.customer.beans.UploadableDocsByRequestBean;
import com.bectran.b2b.customer.blo.CustomerDocsBLO;
import com.bectran.b2b.customer.dao.UploadableDocumentDAO;
import com.bectran.b2b.supplier.beans.SupplierCompanyBean;
import com.bectran.b2b.supplier.dao.SupplierCompanyDAO;
import com.bectran.sftp.xml.inbound.CustomDocInfoXmlBean;

/**
 * @author Shanmu
 * @date Nov 24, 2015 10:20:24 PM
 */
public class CustomDocInfoLoad extends CustomerDataLoadBase {
    //
    public List<CustomDocInfoXmlBean> loadData(long requestId,
                                               SupplierCompanyBean supplier)
            throws Exception {
        List<CustomDocInfoXmlBean> result = null;
        List<UploadableDocsByRequestBean> uploadedDocs = new UploadableDocumentDAO()
                .getUploadableDocsByRequest(requestId);
        if (uploadedDocs == null || uploadedDocs.size() < 1) {
            return result;
        }
        result = new ArrayList<CustomDocInfoXmlBean>();
        for (UploadableDocsByRequestBean uploadableDocsByRequestBean : uploadedDocs) {
            CustomerDocsBean customerDocsBean = uploadableDocsByRequestBean
                    .getCustomerDoc();
            if (StringUtils.equals(MatrixConstants.STATUS_ACTIVE,
                    customerDocsBean.getStatus())) {
                result.add(initializeXmlBean(customerDocsBean, supplier));
            }
        }
        return result;
    }

    private CustomDocInfoXmlBean initializeXmlBean(CustomerDocsBean customerDocsBean,
                                                   SupplierCompanyBean supplier) {
        CustomDocInfoXmlBean bean = new CustomDocInfoXmlBean();
        bean.setId(String.valueOf(customerDocsBean.getId()));
        bean.setDate(customerDocsBean.getLastUpdate().toString());
        bean.setName(customerDocsBean.getDocName());
        bean.setDocumentType(customerDocsBean.getFileType());
        //
        String docFileSystemName = customerDocsBean.getDocFileSystemName();
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

    /*
     * public List<CustomDocInfoXmlBean> loadData2(long requestId, String docId,
     * SupplierCompanyBean supplier) throws Exception {
     * List<CustomDocInfoXmlBean> result = null; List<CreditDocumentBean> docs =
     * CreditDocumentDAO.getDocByRequest( requestId, docId); if (docs == null ||
     * docs.size() < 1) { return result; } List<Long> ids = new
     * ArrayList<Long>(); for (CreditDocumentBean creditDocumentBean : docs) {
     * ids.add(creditDocumentBean.getId()); } List<UploadableDocsByRequestBean>
     * uploadedDocs = new CustomerDocsDAO() .getAllDocsByRequest(ids); if
     * (uploadedDocs == null || uploadedDocs.size() < 1) { return result; }
     * result = new ArrayList<CustomDocInfoXmlBean>(); for
     * (UploadableDocsByRequestBean uploadableDocsByRequestBean : uploadedDocs)
     * { CustomerDocsBean customerDocsBean = uploadableDocsByRequestBean
     * .getCustomerDoc(); if (StringUtils.equals(MatrixConstants.STATUS_ACTIVE,
     * customerDocsBean.getStatus())) {
     * result.add(initializeXmlBean(customerDocsBean, supplier)); } } return
     * result; } private CustomDocInfoXmlBean
     * initializeXmlBean2(CustomerDocsBean customerDocsBean, SupplierCompanyBean
     * supplier) { CustomDocInfoXmlBean bean = new CustomDocInfoXmlBean();
     * bean.setId(String.valueOf(customerDocsBean.getId()));
     * bean.setDate(customerDocsBean.getLastUpdate().toString()); String name =
     * customerDocsBean.getDocLabel(); if (StringUtils.isBlank(name)) { name =
     * customerDocsBean.getDocName(); } bean.setName(name);
     * bean.setDocumentType(customerDocsBean.getFileType()); // String
     * docFileSystemName = customerDocsBean.getDocFileSystemName(); String
     * corpId = supplier.getCorpID().trim(); try {
     * bean.setDocImageUrl(getValueForXml(CustomerDocsBLO.documentURL(
     * docFileSystemName, corpId))); } catch (Exception e) {
     * bean.setDocImageUrl(docFileSystemName); } // return bean; }
     */
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("-----1-----");
        // getUploadableDocsByRequest(1);
        SupplierCompanyBean supplier = new SupplierCompanyDAO().findCompany(1);
        new CustomDocInfoLoad().loadData(545, supplier);
        System.out.println("-----2-----");
    }
}
