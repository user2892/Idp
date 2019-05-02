/**
 * 
 */
package com.bectran.ws.inbound.blo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.FileUtils;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.constants.WsErrorMessageConstants;
import com.bectran.b2b.enterprise.beans.CrApprovalBean;
import com.bectran.b2b.enterprise.beans.EnterpriseAccountByGroupBean;
import com.bectran.b2b.enterprise.beans.WsDataLoadTrackerBean;
import com.bectran.b2b.enterprise.dao.CrApprovalDAO;
import com.bectran.b2b.supplier.beans.GroupAccountBean;
import com.bectran.b2b.supplier.beans.SupplierCompanyBean;
import com.bectran.b2b.supplier.dao.GroupAccountDAO;
import com.bectran.flatfile.load.FlatFileUtilXml;
import com.bectran.matrix.framework.AppConfig;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.sftp.xml.inbound.ApprovedCreditBean;
import com.bectran.sftp.xml.inbound.ApprovedCreditMapperBean;
import com.bectran.sftp.xml.inbound.helper.ApprovedCreditXmlHelper;
import com.bectran.sftp.xml.inbound.helper.CustomerDataLoadBase;
import com.bectran.ws.inbound.InboundCreditDecisionDataQueryResult;
import com.bectran.xml.helper.BectranSchemaValidator;

/**
 * LOUIS IFEGUNI Apr 12, 2016 / 6:45:49 PM
 */
public class ApprovedCreditWsHelper extends CustomerDataLoadBase {
    private static final String SCHEMA_LOCATION_RELATIVE = "xml-data-integration/work-schema/inbound/inbound-credit-decision.xsd";

    public void executeRequest(SupplierCompanyBean supplier,
                               Date inboundDataStartDate,
                               EnterpriseAccountByGroupBean entBean,
                               boolean global,
                               InboundCreditDecisionDataQueryResult result)
            throws Exception {
        Date startTime = new Date();
        //
        List<CrApprovalBean> ls = null;
        if (global) {
            ls = new CrApprovalDAO().getApprovalsForTransmission(
                    supplier.getId().longValue(), inboundDataStartDate,
                    CustomerDataLoadBase.MAX_DATA_QUERY_LOAD_WS);
        }
        else {
            ls = new CrApprovalDAO().getApprovalsForTransmissionByGroup(
                    entBean.getId().longValue(), inboundDataStartDate,
                    CustomerDataLoadBase.MAX_DATA_QUERY_LOAD_WS);
        }
        if (ls == null || ls.size() < 1) {
            setStatusMessage(result, WsErrorMessageConstants.NO_RESULTS);
            return;
        }
        List<ApprovedCreditBean> approvedCreditList = new ApprovedCreditXmlHelper()
                .getResultsForTransmission(ls);
        /*
         * SFTP STORAGE LOCATION ADDED: JAN 28, 2016 - LOUIS IFEGUNI
         */
        String location = determineFileLocation(supplier, global, entBean);
        // writeToXmlFile(approvedCreditList, supplier.getCorpID().trim());
        boolean valid = validateXmlFile(approvedCreditList, location, result);
        if (!valid) {
            setStatusMessage(result, WsErrorMessageConstants.SYSTEM_ERROR);
            return; // FILE FAILED SCHEMA VALIDATION.
        }
        // ---------------------------
        String trxnBatchControlToken = "NOTAPPLICABLE";
        if (entBean.isProdInboundMode()) { // UPDATE ONLY ON PRODUCTION MODE
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
            trxnBatchControlToken = updateProcessedDataItems(groupBean, ls,
                    startTime);
        }
        //
        result.setTrxnBatchControlToken(trxnBatchControlToken);
        setStatusMessage(result, WsErrorMessageConstants.SUCCESS);
        //
    }

    private String updateProcessedDataItems(GroupAccountBean groupBean,
                                            List<CrApprovalBean> ls,
                                            Date startTime)
            throws DataAccessException {
        WsDataLoadTrackerBean trackerBean = updateLoadStatusTracker(groupBean,
                ls.size(), startTime, 1,
                MatrixConstants.CUSTOMER_XML_DATA_DECISION);
        String trxnBatchControlToken = trackerBean.getTxnCode();
        //
        new CrApprovalDAO().updateTransmittedApprovals(ls,
                MatrixConstants.ANSWER_NO, trxnBatchControlToken.trim());
        return trxnBatchControlToken;
    }

    private boolean validateXmlFile(List<ApprovedCreditBean> approvedCreditList,
                                    String supplierTnNumber,
                                    InboundCreditDecisionDataQueryResult result)
            throws Exception {
        //
        boolean flag=false;
        InputStream in=null;
        try {
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
            byte[] data = FileUtils.readFileToByteArray(tempWorkFile);
            String value = new String(data, "UTF-8");
            //
            in = new FileInputStream(tempWorkFile);
            String schemaPath = AppConfig.getWebContentPath()
                    + SCHEMA_LOCATION_RELATIVE;
            File schemaFile = new File(schemaPath);
            //
            result.setXmlDocument(value); // SET XML DOCUMENT
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
}
