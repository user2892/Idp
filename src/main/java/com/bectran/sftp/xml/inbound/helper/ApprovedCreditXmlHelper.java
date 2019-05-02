/**
 *
 */
package com.bectran.sftp.xml.inbound.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.bectran.b2b.constants.FlatFileUpdateConstant;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.customer.beans.CusCurrentTermsBean;
import com.bectran.b2b.customer.dao.CusCurrentTermsDAO;
import com.bectran.b2b.enterprise.beans.ApprovingOfficerBean;
import com.bectran.b2b.enterprise.beans.CrApprovalBean;
import com.bectran.b2b.enterprise.beans.EnterpriseAccountByGroupBean;
import com.bectran.b2b.enterprise.dao.CrApprovalDAO;
import com.bectran.b2b.enterprise.dao.CustomerDataUpdateStatusDAO;
import com.bectran.b2b.supplier.beans.GroupAccountBean;
import com.bectran.b2b.supplier.beans.SupplierCompanyBean;
import com.bectran.b2b.supplier.blo.SubsFeatureControlBLO;
import com.bectran.b2b.supplier.dao.GroupAccountDAO;
import com.bectran.flatfile.load.FlatFileUtilXml;
import com.bectran.matrix.framework.AppConfig;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.PassCodeHelper;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.DateUtility;
import com.bectran.sftp.xml.inbound.ApprovedCreditBean;
import com.bectran.sftp.xml.inbound.ApprovedCreditMapperBean;
import com.bectran.xml.helper.BectranSchemaValidator;

/**
 * @author LOUIS IFEGUNI
 * @date Aug 9, 2012 : 10:17:53 PM
 */
public class ApprovedCreditXmlHelper extends CustomerDataLoadBase {
    private static final String SCHEMA_LOCATION_RELATIVE = "xml-data-integration/work-schema/inbound/inbound-credit-decision.xsd";

    public void executeRequest(SupplierCompanyBean supplier,
                               Date inboundDataStartDate,
                               EnterpriseAccountByGroupBean entBean,
                               boolean global) {
        //
        try {
            Date startTime = new Date();
            //
            List<CrApprovalBean> ls = null;
            if (global) {
                ls = new CrApprovalDAO().getApprovalsForTransmission(
                        supplier.getId().longValue(), inboundDataStartDate,
                        CustomerDataLoadBase.MAX_DATA_QUERY_LOAD_SFTP);
            }
            else {
                ls = new CrApprovalDAO().getApprovalsForTransmissionByGroup(
                        entBean.getId().longValue(), inboundDataStartDate,
                        CustomerDataLoadBase.MAX_DATA_QUERY_LOAD_SFTP);
            }
            // List<CrApprovalBean> ls = new
            // CrApprovalDAO().getApprovalsForTransmission(supplier.getId().longValue(),
            // inboundDataStartDate);
            if (ls == null || ls.size() < 1) {
                return;
            }
            List<ApprovedCreditBean> approvedCreditList = getResultsForTransmission(
                    ls);
            /*
             * SFTP STORAGE LOCATION ADDED: JAN 28, 2016 - LOUIS IFEGUNI
             */
            String location = determineFileLocation(supplier, global, entBean);
            // writeToXmlFile(approvedCreditList, supplier.getCorpID().trim());
            boolean valid = writeToXmlFile(approvedCreditList, location);
            if (!valid) {
                return; // FILE FAILED SCHEMA VALIDATION.
            }
            //
            if (entBean.isProdInboundMode()) {// UPDATE ONLY ON PRODUCTION MODE
                //
                GroupAccountBean groupBean = null;
                if (global) {
                    groupBean = new GroupAccountDAO()
                            .getPrimaryGroup(supplier.getId().longValue());
                }
                else {
                    groupBean = new GroupAccountDAO()
                            .findGroup(entBean.getId().longValue());
                }
                new CustomerDataUpdateStatusDAO().updateLoadStatus(groupBean,
                        ls.size(), startTime, 1,
                        MatrixConstants.CUSTOMER_XML_DATA_DECISION);
                String trxnBatchControlToken = PassCodeHelper
                        .computeUniqueId(location);
                new CrApprovalDAO().updateTransmittedApprovals(ls,
                        MatrixConstants.ANSWER_YES,
                        trxnBatchControlToken.trim());
                //
                updateProcessedDataItems(groupBean, ls, startTime, location);
            }
            //
        }
        catch (Exception e) {
            String excpmessage = "Approval Transaction processing FAILED.";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            e.printStackTrace();
        }
    }

    private void updateProcessedDataItems(GroupAccountBean groupBean,
                                          List<CrApprovalBean> ls,
                                          Date startTime, String location)
            throws DataAccessException {
        //
        new CustomerDataUpdateStatusDAO().updateLoadStatus(groupBean, ls.size(),
                startTime, 1, MatrixConstants.CUSTOMER_XML_DATA_DECISION);
        //
        // String trxnBatchControlToken =
        // PassCodeHelper.computeUniqueId(supplier.getCorpID().trim());
        String trxnBatchControlToken = PassCodeHelper
                .computeUniqueId(location.trim());
        new CrApprovalDAO().updateTransmittedApprovals(ls,
                MatrixConstants.ANSWER_YES, trxnBatchControlToken.trim());
    }

    private boolean writeToXmlFile(List<ApprovedCreditBean> approvedCreditList,
                                   String supplierTnNumber)
            throws Exception {
        ApprovedCreditMapperBean mapperBean = new ApprovedCreditMapperBean();
        //
        mapperBean.setCustomer(approvedCreditList);
        //
        JAXBContext jaxbContext = JAXBContext
                .newInstance(ApprovedCreditMapperBean.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File tempWorkFile = new File(new FlatFileUtilXml().tempWorkFileName(
                supplierTnNumber, FlatFileUtilXml.NAMEPREFIX_CREDIT_DECI));
        // write XML file to temporrary area
        marshaller.marshal(mapperBean, tempWorkFile);
        //
        boolean valid = validateXml(tempWorkFile);
        if (valid) {
            // copy file to CLIENT wip folder
            File wipFile = new File(new FlatFileUtilXml().fileNameInWip(
                    supplierTnNumber, FlatFileUtilXml.NAMEPREFIX_CREDIT_DECI,
                    FlatFileUpdateConstant.INBOUND_FOLDER));
            new FlatFileUtilXml().renameAndMoveProcessedFile(tempWorkFile,
                    wipFile);
        }
        return valid;
    }

    private boolean validateXml(File file) throws Exception {
        boolean flag=false;
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            //
            // String schemaPath =
            // "H:/workspace/myeclipse10/eintg-wspace/b2bentintgbatch/WebRoot/"+
            // SCHEMA_LOCATION_RELATIVE;
            String schemaPath = AppConfig.getWebContentPath()
                    + SCHEMA_LOCATION_RELATIVE;
            File schemaFile = new File(schemaPath);
            flag = new BectranSchemaValidator().validate(schemaFile, in);
        }
        catch (Exception e) {
            throw e;
        }
        finally{
            if(in!=null){
                in.close();
            }
        }
        return flag;
    }

    public List<ApprovedCreditBean> getResultsForTransmission(List<CrApprovalBean> ls)
            throws Exception {
        //
        List<ApprovedCreditBean> trxnList = new ArrayList<ApprovedCreditBean>();
        for (Iterator<CrApprovalBean> i = ls.iterator(); i.hasNext();) {
            CrApprovalBean bean = i.next();
            //
            ApprovedCreditBean trxn = initializeTrxnBean(bean);
            trxnList.add(trxn);
        }
        return trxnList;
    }

    private ApprovedCreditBean initializeTrxnBean(CrApprovalBean bean)
            throws Exception {
        ApprovedCreditBean txn = new ApprovedCreditBean();
        //
        txn.setAmountRequested(bean.getCreditRequestSummary().getAmount().setScale(1, BigDecimal.ROUND_HALF_EVEN));
        //
        txn.setApprovalDate(
                DateUtility.reFormatDateForXmlSchema(bean.getApprovalDate()));
        txn.setApprovedLimit(bean.getApprovedLimit().setScale(1, BigDecimal.ROUND_HALF_EVEN));
        txn.setBectranCustomerId(bean.getBectranAcctNum());
        // client account id
        txn.setClientAccountId(getValueForXml(bean.getAcctNum()));
        // customer name
        txn.setCustomerName(getValueForXml(bean.getCustomer().getName()));
        // risk rating
        txn.setRiskRating(getValueForXml(bean.getRiskRating()));
        // risk class
        txn.setRiskRatingClass(getValueForXml(bean.getRiskRatingClass()));
        //
        txn.setTransactionId(
                getValueForXml(transactionID(bean.getCreditRequestSummary())));
        // credit term
        txn.setCreditTerm(getValueForXml(bean.getTermDescription()));
        // credit term Code
        txn.setCreditTermCode(getValueForXml(bean.getTermCode()));
        // analyst name
        txn.setAnalystName(getValueForXml(bean.getAnalyst().getUserName()));
        //
        txn.setAccountId(txn.getBectranCustomerId());
        // credit decision
        txn.setCreditDecision(getValueForXml(bean.getStatus()));
        //
        txn.setApprovigOfficerName(approvingOfficerNames(bean.getOfficerSet()));
        //
        // multiple group
        boolean hasMultipleGroup = new SubsFeatureControlBLO()
                .hasMultipleGroup(bean.getSupplierId());
        if (hasMultipleGroup) {
            GroupAccountBean groupBean = new GroupAccountDAO().findGroup(
                    bean.getCreditRequestSummary().getGroupId().longValue());
            txn.setBectranReferenceId(groupBean.getId().toString());
            //
            txn.setGroupName(getValueForXml(groupBean.getName()));
            //
            txn.setInternalGroupCode(
                    getValueForXml(groupBean.getInternalGroupCode()));
        }
        //
        //
        CusCurrentTermsBean currtTermsBean = new  CusCurrentTermsDAO().getCurrentTerm(bean.getCreditRequestSummary().getCustomerSupplierId().longValue());
        if(currtTermsBean != null && currtTermsBean.getNextReviewDate()!=null){
            txn.setNextReviewDate(DateUtility.reFormatDateForXmlSchema(currtTermsBean.getNextReviewDate()));
        }
        //
        return txn;
    }

    private String approvingOfficerNames(Set<ApprovingOfficerBean> officerSet) {
        String name = "";
        int count = 0;
        String delimeter = " / ";
        for (Iterator<ApprovingOfficerBean> i = officerSet.iterator(); i
                .hasNext();) {
            ApprovingOfficerBean officer = i.next();
            if (officer.isApproved()) {
                if (count > 0) {
                    name = name + delimeter
                            + officer.getUserBean().getUserName();
                }
                else {
                    name = officer.getUserBean().getUserName();
                }
                count = count + 1;
            }
        }
        return name;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //
        System.out.println("----start---");
        // SupplierCompanyBean supplier = SupplierCompanyDAO.findCompany(1);
        // new ApprovedCreditXmlHelper().executeRequest(supplier,
        // DateUtility.dateOfXDaysFromToday(DEFAULT_INBOUND_DATA_BEGIN_DAYS));
        // System.out.println("----supplier.getCorpID()---"+supplier.getCorpID());
        // getResultsForTransmission(1);
        // System.out.println(getResultsForTransmission(1).size());
        // File file = new
        // File("H:/workspace/myeclipse10/eintg-wspace/b2bentintgbatch/src/com/bectran/sftp/xml/helper/textdm.xml");
        // InputStream in = new FileInputStream(file);
        /// File schemaFile = new
        // File("H:/workspace/myeclipse10/eintg-wspace/b2bentintgbatch/WebRoot/xml-data-integration/work-schema/inbound-credit-approval.xsd");
        // BectranSchemaValidator.validate(schemaFile, in);
        System.out.println("----stop---");
    }
}
