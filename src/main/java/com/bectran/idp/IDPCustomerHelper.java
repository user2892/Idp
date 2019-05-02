/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.idp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.constants.WsErrorMessageConstants;
import com.bectran.b2b.customer.beans.CreditReqTransmitDetailsBean;
import com.bectran.b2b.customer.beans.PastCreditAppBean;
import com.bectran.b2b.customer.dao.CustomerDataDAO;
import com.bectran.b2b.enterprise.beans.CrApprovalBean;
import com.bectran.b2b.enterprise.beans.EnterpriseAccountByGroupBean;
import com.bectran.b2b.enterprise.beans.EnterpriseIntgIdpServiceBean;
import com.bectran.b2b.enterprise.beans.EnterpriseIntgServiceBean;
import com.bectran.b2b.enterprise.beans.WsDataLoadTrackerBean;
import com.bectran.b2b.enterprise.dao.CrApprovalDAO;
import com.bectran.b2b.enterprise.dao.EnterpriseAccountByGroupDAO;
import com.bectran.b2b.enterprise.dao.WsDataLoadTrackerDAO;
import com.bectran.b2b.idp.beans.IDPAttribute;
import com.bectran.b2b.supplier.beans.GroupAccountBean;
import com.bectran.b2b.supplier.beans.GroupAccountRuleBean;
import com.bectran.b2b.supplier.beans.SupplierCompanyBean;
import com.bectran.b2b.supplier.dao.GroupAccountDAO;
import com.bectran.b2b.supplier.dao.GroupAccountRuleDAO;
import com.bectran.b2b.supplier.dao.SupplierCompanyDAO;
import com.bectran.flatfile.load.FlatFileUtilXml;
import com.bectran.idp.beans.IDPConstants;
import com.bectran.idp.beans.IDPOnPrequalTransmitLogBean;
import com.bectran.idp.beans.IDPOnSubmutTransmitLogBean;
import com.bectran.idp.beans.IDPTransmitLogBean;
import com.bectran.idp.dao.IDPDataDAO;
import com.bectran.matrix.framework.AppConfig;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.PassCodeHelper;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.framework.exception.ResourceLoadException;
import com.bectran.matrix.framework.idp.IDPMsgBean;
import com.bectran.sftp.xml.inbound.ApprovedCreditBean;
import com.bectran.sftp.xml.inbound.ApprovedCreditMapperBean;
import com.bectran.sftp.xml.inbound.CustomerInboundDataMapperBean;
import com.bectran.sftp.xml.inbound.CustomerandDecisionInboundDataMapperBean;
import com.bectran.sftp.xml.inbound.InboundCustomerDataXmlBean;
import com.bectran.sftp.xml.inbound.InboundCustomerandDecisionDataXmlBean;
import com.bectran.sftp.xml.inbound.helper.ApprovedCreditXmlHelper;
import com.bectran.sftp.xml.inbound.helper.InboundCustomerDataXmlHelper;
import com.bectran.xml.helper.BectranSchemaValidator;

/**
 * @author santhosh
 * @date 27-May-2016 11:34:13 pm
 */
public class IDPCustomerHelper {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    private static final String SCHEMA_LOCATION_RELATIVE = "xml-data-integration/work-schema/inbound/inbound-customer-data.xsd";
    private static final String DECISION_SCHEMA_LOCATION_RELATIVE = "xml-data-integration/work-schema/inbound/inbound-credit-decision.xsd";
    private static final String CUSTOMER_DECISION_SCHEMA_LOCATION_RELATIVE = "xml-data-integration/work-schema/inbound/inbound-customer-decision-data.xsd";

    // ----------------------------------------------------- Static Initializers
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @param idpMsgBean
     * @throws DataAccessException
     */
    public IDPMsgBean getCustomerInformation(IDPMsgBean idpMsgBean)
            throws DataAccessException {
        String response = "";
        String decisionResponse = "";
        String customerAndDecisionResp="";
        try {
            // System.out.println("in getCustomerInfomration ************");
            idpMsgBean = getInboudCustomerData(idpMsgBean);
        }
        catch (Exception e) {
            idpMsgBean.setResponseCode(WsErrorMessageConstants.SYSTEM_ERROR);
            idpMsgBean.setStackTrace(getStackTraceAsString(e));
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, e.getLocalizedMessage());
        }
        //
        if (StringUtils.equals(idpMsgBean.getResponseCode(),WsErrorMessageConstants.SUCCESS)) {
            response = idpMsgBean.getXmlDocument();
            decisionResponse = idpMsgBean.getXmlDecisionDocument();
            customerAndDecisionResp = idpMsgBean.getXmlCustomerAndDecisionDocument();
            if (StringUtils.equals(idpMsgBean.getPostType(),MatrixConstants.IDP_TYPE_JSON)) {
                response = idpMsgBean.getJsonCustomerDocument();
                decisionResponse = convertXMLFileJSON(decisionResponse);
                customerAndDecisionResp = idpMsgBean.getJsonCustomerAndDecisionDocument();
            }
        }else{
            response = WsErrorMessageConstants
                    .errorDescription(idpMsgBean.getResponseCode());
        }
        
        idpMsgBean.setResponseData(response);
        idpMsgBean.setResponseDecisionData(decisionResponse);
        idpMsgBean.setResponseCustomerAndDecisionData(customerAndDecisionResp);
        
        return idpMsgBean;
    }

    /**
     * @param bean
     * @param request
     * @return
     * @throws Exception
     */
    public boolean verifyWSAccess(EnterpriseAccountByGroupBean bean,
                                  IDPMsgBean request) throws Exception {
        //
        //
        String clearPasscode = PassCodeHelper.decryptCode(bean.getPassCode()
                .trim(), bean.getMysalt());
        String requestPasscode = PassCodeHelper.decryptCode(request
                .getPassCode().trim(), request.getMysalt());
        if (!clearPasscode.trim().equals(requestPasscode.trim())) {
            return false;
        }
        return true;
    }

    public WsDataLoadTrackerBean updateLoadStatusTracker(GroupAccountBean groupBean,
                                                         int recordCount,
                                                         Date startTime,
                                                         int batchCount,
                                                         String cusDataType)
            throws DataAccessException {
        //
        WsDataLoadTrackerBean statusBean = new WsDataLoadTrackerBean();
        statusBean.setStartTime(startTime);
        statusBean.setNumberOfBatch(batchCount);
        statusBean.setEndTime(new Date());
        statusBean.setNumberOfRec(recordCount);
        statusBean.setCusDataType(cusDataType);
        statusBean.setSupplierId(groupBean.getSupplierId());
        statusBean.setGroupId(groupBean.getId());
        statusBean.setTxnCode(PassCodeHelper.computeUniqueId(String
                .valueOf(groupBean.getId())));
        //
        new WsDataLoadTrackerDAO().saveOrUpdate(statusBean);
        //
        return statusBean;
    }

    /**
     * @param supplier
     * @param inboundDataStartDate
     * @param entBean
     * @param global
     * @param result
     * @throws Exception
     */
    public IDPMsgBean executeRequest(SupplierCompanyBean supplier,
                                     IDPMsgBean idpMsgBean, boolean global,
                                     EnterpriseAccountByGroupBean entBean)
            throws Exception {
        //
        //
        PastCreditAppBean pastCreditAppBean = new CustomerDataDAO()
                .getAppsForTransmissionByRequestId(supplier.getId(),
                        idpMsgBean.getRequestId());
        if (pastCreditAppBean == null) {
            System.out.println("---NO Results---> ");
            idpMsgBean.setResponseCode(WsErrorMessageConstants.NO_RESULTS);
            return idpMsgBean;
        }
        InboundCustomerDataXmlBean dataXmlBean = new InboundCustomerDataXmlHelper()
                .processForApp(supplier, pastCreditAppBean);
//        List<InboundCustomerDataXmlBean> dataXmlList = new ArrayList<InboundCustomerDataXmlBean>();
//        dataXmlList.add(dataXmlBean);
        CustomerInboundDataMapperBean mapperBean = new CustomerInboundDataMapperBean();
        mapperBean.setDataXmlList(dataXmlBean);
        String location = determineFileLocation(supplier, global, entBean,
                idpMsgBean.getRequestId());
        idpMsgBean = validateXmlFile(mapperBean, location, idpMsgBean);
        //
        return idpMsgBean;
    }

    public static void saveTransmitLogDetails(IDPMsgBean idpMsgBean, String flag)
            throws DataAccessException {
        IDPTransmitLogBean transmitLogBean = new IDPTransmitLogBean();
        transmitLogBean.setRequestId(idpMsgBean.getRequestId());
        transmitLogBean.setTransmittedFlag(flag);
        transmitLogBean.setLastUpdate(Calendar.getInstance().getTime());
        transmitLogBean.setGroupId(idpMsgBean.getGroupId());
        transmitLogBean.setSupplierId(idpMsgBean.getSupplierId());
        transmitLogBean.setProcessFlag(flag);
        
        long supplierID = transmitLogBean.getSupplierId();
        long groupID = transmitLogBean.getGroupId();
        // Check whether integration scope is global or biz group
        GroupAccountRuleBean groupAccountRuleBean = new GroupAccountRuleDAO().find(supplierID);
        // Get the primary group ID
        GroupAccountBean groupAccount = null;
        if (groupAccountRuleBean != null
                && groupAccountRuleBean.isIntegrationScopeIsGlobal()) {
            groupAccount = new GroupAccountDAO().getPrimaryGroup(
                    supplierID);
            groupID = groupAccount.getId();
        }
        
        if (groupAccount != null) {
            EnterpriseIntgServiceBean entgIntgSvcBean = EnterpriseAccountByGroupDAO
                    .getEnterpriseIntgServiceBean(supplierID, groupID);
            if (entgIntgSvcBean != null) {
                entgIntgSvcBean.setLastUpdate(transmitLogBean.getLastUpdate());
                EnterpriseIntgIdpServiceBean idpService = entgIntgSvcBean
                        .getIdpServiceBean();
                if (idpService != null) {
                    idpService.setModifiedDate(transmitLogBean.getLastUpdate());
                    if(StringUtils.equals(idpMsgBean.getResponseCode(),WsErrorMessageConstants.SUCCESS)){
                        idpService.setLastBatchUpdateDt(transmitLogBean.getLastUpdate());
                    }else{
                        idpService.setErrorMsg(WsErrorMessageConstants.errorDescription(idpMsgBean.getResponseCode()));
                    }
                    
                }
                
                //Code to set the retry count from the existing record
                IDPTransmitLogBean transmitSessionBean = new IDPDataDAO().findByRequestID(transmitLogBean.getRequestId());
                if(transmitSessionBean!=null){
                    transmitLogBean.setRetryCount(transmitSessionBean.getRetryCount());
                }else{
                    transmitLogBean.setRetryCount(0);
                }
                
                new IDPDataDAO().saveTransmitLogDetails(transmitLogBean, entgIntgSvcBean);
            }
        }
    }
    
    
    
    public static void saveOnSubmitTransmitLogDetails(IDPMsgBean idpMsgBean, String flag)
            throws DataAccessException {
        IDPOnSubmutTransmitLogBean transmitLogBean = new IDPOnSubmutTransmitLogBean();
        transmitLogBean.setRequestId(idpMsgBean.getRequestId());
        transmitLogBean.setTransmittedFlag(flag);
        transmitLogBean.setLastUpdate(Calendar.getInstance().getTime());
        transmitLogBean.setGroupId(idpMsgBean.getGroupId());
        transmitLogBean.setSupplierId(idpMsgBean.getSupplierId());
        transmitLogBean.setProcessFlag(flag);
        
        long supplierID = transmitLogBean.getSupplierId();
        long groupID = transmitLogBean.getGroupId();
        // Check whether integration scope is global or biz group
        GroupAccountRuleBean groupAccountRuleBean = new GroupAccountRuleDAO().find(supplierID);
        // Get the primary group ID
        GroupAccountBean groupAccount = null;
        if (groupAccountRuleBean != null
                && groupAccountRuleBean.isIntegrationScopeIsGlobal()) {
            groupAccount = new GroupAccountDAO().getPrimaryGroup(
                    supplierID);
            groupID = groupAccount.getId();
        }
        
        if (groupAccount != null) {
            EnterpriseIntgServiceBean entgIntgSvcBean = EnterpriseAccountByGroupDAO
                    .getEnterpriseIntgServiceBean(supplierID, groupID);
            if (entgIntgSvcBean != null) {
                entgIntgSvcBean.setLastUpdate(transmitLogBean.getLastUpdate());
                EnterpriseIntgIdpServiceBean idpService = entgIntgSvcBean
                        .getIdpServiceBean();
                if (idpService != null) {
                    idpService.setModifiedDate(transmitLogBean.getLastUpdate());
                    if(StringUtils.equals(idpMsgBean.getResponseCode(),WsErrorMessageConstants.SUCCESS)){
                        idpService.setLastBatchUpdateDt(transmitLogBean.getLastUpdate());
                    }else{
                        idpService.setErrorMsg(WsErrorMessageConstants.errorDescription(idpMsgBean.getResponseCode()));
                    }
                    
                }
                
                //Code to set the retry count from the existing record
                IDPTransmitLogBean transmitSessionBean = new IDPDataDAO().findByRequestID(transmitLogBean.getRequestId());
                if(transmitSessionBean!=null){
                    transmitLogBean.setRetryCount(transmitSessionBean.getRetryCount());
                }else{
                    transmitLogBean.setRetryCount(0);
                }
                
                new IDPDataDAO().saveOnSubmitTransmitLogDetails(transmitLogBean, entgIntgSvcBean);
            }
        }
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    private String determineFileLocation(SupplierCompanyBean supplier,
                                         boolean global,
                                         EnterpriseAccountByGroupBean entBean,
                                         long requestId) {
        String location = supplier.getCorpID().trim() + requestId;
        if (!global) {
            location = supplier.getCorpID().trim() + entBean.getId()
                    + requestId;
        }
        return location.trim();
    }

    private IDPMsgBean validateXmlFile(CustomerInboundDataMapperBean mapperBean, String supplierTnNumber,
			IDPMsgBean idpMsgBean) throws Exception {

		InputStream in = null;
		//
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(CustomerInboundDataMapperBean.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			File tempDirectory = new File(FlatFileUtilXml.getTempworkPath());
			boolean isCreated = false;
			
			if (!tempDirectory.isDirectory()) {
				isCreated = tempDirectory.mkdirs();
			}
			if (!isCreated) {
				idpMsgBean.setResponseCode(WsErrorMessageConstants.SYSTEM_ERROR);
			}
			File tempWorkFile = new File(
					new FlatFileUtilXml().tempWorkFileName(supplierTnNumber, FlatFileUtilXml.NAMEPREFIX_CUS_SETUP));
			// write XML file to temporary area
			marshaller.marshal(mapperBean, tempWorkFile);
			//
			// marshaller.ma
			//byte[] data = FileUtils.readFileToByteArray(tempWorkFile);
			//String value = new String(data, "UTF-8");
			// System.out.println(value);
			in = new FileInputStream(tempWorkFile);
			//
			String schemaPath = AppConfig.getWebContentPath() + SCHEMA_LOCATION_RELATIVE;
			File schemaFile = new File(schemaPath);
			//
			if (new BectranSchemaValidator().validate(schemaFile, in)) {
				// Ajay Veluru - Customer Data Attr - IDP process				
				idpMsgBean.setResponseCode(WsErrorMessageConstants.SUCCESS);
				
				//differentiating post type JSON and XML 
				if (StringUtils.equals(idpMsgBean.getPostType(), MatrixConstants.IDP_TYPE_JSON)) {
					prepareJSONDATA(mapperBean, supplierTnNumber, idpMsgBean, marshaller);
				}else if(StringUtils.equals(idpMsgBean.getPostType(), MatrixConstants.IDP_TYPE_XML)){
					prepareXMLData(supplierTnNumber, idpMsgBean, tempWorkFile);
				}
			} else {
				idpMsgBean.setResponseCode(WsErrorMessageConstants.VALIDATION_ERROR);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (in != null) {
				in.close();
			}
		}
		//
		return idpMsgBean;
	}

    private IDPMsgBean getInboudCustomerData(IDPMsgBean idpMsgBean) {
        SupplierCompanyBean supplier = null;
        try {
            EnterpriseAccountByGroupBean bean =null;
            GroupAccountRuleBean ruleBean = new GroupAccountRuleDAO().find(idpMsgBean.getSupplierId());
            boolean global = false;
            
            if(ruleBean!=null && ruleBean.isIntegrationScopeIsGlobal()){
                global = true;
                //Getting primary group bean
                GroupAccountBean primaryGroup = new GroupAccountDAO().getPrimaryGroup(idpMsgBean.getSupplierId());
                bean = new EnterpriseAccountByGroupDAO().find(primaryGroup.getId().longValue());
            }else{
                bean = new EnterpriseAccountByGroupDAO().find(idpMsgBean.getGroupId());
            }
            
            
            if (bean == null) {
                idpMsgBean.setResponseCode(WsErrorMessageConstants.INVALID_PARAMETERS);
                return idpMsgBean;
            }
            /*
             * boolean verifyPassword = verifyWSAccess(bean, idpMsgBean); if
             * (!verifyPassword) { idpMsgBean.setResponseCode(
             * WsErrorMessageConstants.AUTHENTICATION_ERROR); return idpMsgBean;
             * }
             */
            supplier = new SupplierCompanyDAO().findCompany(bean
                    .getSupplierId().longValue());
            
            //
            
            if(idpMsgBean.getResponseType()!=null && StringUtils.equals(IDPConstants.DECDATA ,idpMsgBean.getResponseType())){
                //Getting Decision data
                if(idpMsgBean.getIdpAttributeSet()!=null && idpMsgBean.getIdpAttributeSet().size()>0){
                    List<String> nodeNames = new ArrayList<String>();
                    nodeNames = IDPConstants.getNodeElimentsList();
                    for (IDPAttribute attr : idpMsgBean.getIdpAttributeSet()) {
                        if(nodeNames.contains(attr.getNodeName())){
                            nodeNames.remove(attr.getNodeName());
                        }
                    }
                    idpMsgBean.setDeleteNodeNames(nodeNames);
                }
                idpMsgBean = executeDecisionRequest(supplier, idpMsgBean, global, bean);
            }else if (idpMsgBean.getResponseType() != null
					&& StringUtils.equals(IDPConstants.CUSTOMERDATA, idpMsgBean.getResponseType())) {
				// Getting Customer data
				if (idpMsgBean.getIdpAttributeSet() != null && idpMsgBean.getIdpAttributeSet().size() > 0) {
					List<String> custnodeNames = new ArrayList<String>();
					custnodeNames = IDPConstants.getCustomerNodeElementsList();
					for (IDPAttribute attr : idpMsgBean.getIdpAttributeSet()) {
						if (custnodeNames.contains(attr.getNodeName())) {
							custnodeNames.remove(attr.getNodeName());
						}
					}
					idpMsgBean.setDeleteNodeNames(custnodeNames);
				}
				idpMsgBean = executeRequest(supplier, idpMsgBean, global, bean);
			}else if(idpMsgBean.getResponseType()!=null && StringUtils.equals(IDPConstants.ALL ,idpMsgBean.getResponseType())){
                //Getting Customer data
                idpMsgBean = executeCustomerAndDecisionRequest(supplier, idpMsgBean, global, bean);
            }else {
                //Getting Customer data
                idpMsgBean = executeRequest(supplier, idpMsgBean, global, bean);
                //Getting Decision data
                idpMsgBean = executeDecisionRequest(supplier, idpMsgBean, global, bean);
            }
        }
        catch (DataAccessException e) {
            e.printStackTrace();
            idpMsgBean.setResponseCode(WsErrorMessageConstants.SYSTEM_ERROR);
            idpMsgBean.setStackTrace(getStackTraceAsString(e));
            AppLogger.log(AppLogger.ERROR, e.getLocalizedMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            idpMsgBean.setResponseCode(WsErrorMessageConstants.SYSTEM_ERROR);
            idpMsgBean.setStackTrace(getStackTraceAsString(e));
            AppLogger.log(AppLogger.ERROR, e.getLocalizedMessage());
        }
        return idpMsgBean;
    }
    
    
    /**
     * @param supplier
     * @param inboundDataStartDate
     * @param entBean
     * @param global
     * @throws Exception
     */
    public IDPMsgBean executeDecisionRequest(SupplierCompanyBean supplier,
                                     IDPMsgBean idpMsgBean, boolean global,
                                     EnterpriseAccountByGroupBean entBean)
            throws Exception {
        //
        //
        List<CrApprovalBean> ls = null;
        if (global) {
            ls = new CrApprovalDAO().getApprovalsForIDPTransmission(supplier.getId().longValue(),idpMsgBean.getRequestId());
        }
        else {
            ls = new CrApprovalDAO().getApprovalsIDPTransmissionByGroup(entBean.getId().longValue(),idpMsgBean.getRequestId());
        }
        if (ls == null || ls.size() < 1) {
            idpMsgBean.setResponseCode(WsErrorMessageConstants.NO_RESULTS);
            return idpMsgBean;
        }
        
        List<ApprovedCreditBean> approvedCreditList = new ApprovedCreditXmlHelper()
            .getResultsForTransmission(ls);
        
        
        String location = determineFileLocation(supplier, global, entBean,idpMsgBean.getRequestId());
        
        idpMsgBean = validateDecisionXmlFile(approvedCreditList, location, idpMsgBean);
        //
        return idpMsgBean;
    }
    
    private IDPMsgBean validateDecisionXmlFile(List<ApprovedCreditBean> approvedCreditList,
                                    String supplierTnNumber,
                                    IDPMsgBean idpMsgBean) throws Exception {
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
           
            //
            in = new FileInputStream(tempWorkFile);
            String schemaPath = AppConfig.getWebContentPath() + DECISION_SCHEMA_LOCATION_RELATIVE;
            File schemaFile = new File(schemaPath);
            //
            //idpMsgBean.setXmlDecisionDocument(value); // SET XML DOCUMENT
            //
            
            if (new BectranSchemaValidator().validate(schemaFile, in)) {
                String value ="";
                if(idpMsgBean.getDeleteNodeNames()!=null 
                        && idpMsgBean.getDeleteNodeNames().size()>0){
                    
                    value = deleteNodes(supplierTnNumber,idpMsgBean.getDeleteNodeNames(),tempWorkFile);
                } else {
                    byte[] data = FileUtils.readFileToByteArray(tempWorkFile);
                    value = new String(data, "UTF-8");
                }
                
                idpMsgBean.setResponseCode(WsErrorMessageConstants.SUCCESS);
                idpMsgBean.setXmlDecisionDocument(value);
            }
            else {
                idpMsgBean
                        .setResponseCode(WsErrorMessageConstants.VALIDATION_ERROR);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(in!=null){
                in.close();
            }
        }
        
        return idpMsgBean;
    }

    // ---------------------------------------------------------- Static Methods
    
    public static void saveTransmitLogDetailsFromListener(IDPMsgBean idpMsgBean)
            throws DataAccessException {
        IDPTransmitLogBean transmitLogBean = new IDPTransmitLogBean();
        transmitLogBean.setRequestId(idpMsgBean.getRequestId());
        transmitLogBean.setTransmittedFlag(MatrixConstants.ANSWER_NO);
        transmitLogBean.setLastUpdate(Calendar.getInstance().getTime());
        transmitLogBean.setGroupId(idpMsgBean.getGroupId());
        transmitLogBean.setSupplierId(idpMsgBean.getSupplierId());
        transmitLogBean.setProcessFlag(MatrixConstants.ANSWER_NO);
        
      //Code to set the retry count from the existing record
        IDPTransmitLogBean transmitSessionBean = new IDPDataDAO().findByRequestID(transmitLogBean.getRequestId());
        if(transmitSessionBean!=null){
            transmitLogBean.setRetryCount(transmitSessionBean.getRetryCount());
        }else{
            transmitLogBean.setRetryCount(0);
        }
        
        new IDPDataDAO().saveTransmitLogDetailsFromListener(transmitLogBean);
        
    }
    
    /**
     * @param idpMsgBean
     * @throws DataAccessException
     */
    public static void saveOnSubmitTransmitLogDetailsFromListener(IDPMsgBean idpMsgBean)
            throws DataAccessException {
        IDPOnSubmutTransmitLogBean transmitLogBean = new IDPOnSubmutTransmitLogBean();
        transmitLogBean.setRequestId(idpMsgBean.getRequestId());
        transmitLogBean.setTransmittedFlag(MatrixConstants.ANSWER_NO);
        transmitLogBean.setLastUpdate(Calendar.getInstance().getTime());
        transmitLogBean.setGroupId(idpMsgBean.getGroupId());
        transmitLogBean.setSupplierId(idpMsgBean.getSupplierId());
        transmitLogBean.setProcessFlag(MatrixConstants.ANSWER_NO);
        
      //Code to set the retry count from the existing record
        IDPTransmitLogBean transmitSessionBean = new IDPDataDAO().findByRequestID(transmitLogBean.getRequestId());
        if(transmitSessionBean!=null){
            transmitLogBean.setRetryCount(transmitSessionBean.getRetryCount());
        }else{
            transmitLogBean.setRetryCount(0);
        }
        
        new IDPDataDAO().saveOnSubmitTransmitLogDetailsFromListener(transmitLogBean);
        
    }
    
    public String getStackTraceAsString(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

    public static String convertXMLFileJSON(String xmlString) {
        if(StringUtils.isBlank(xmlString)){
            return "";
        }
        int PRETTY_PRINT_INDENT_FACTOR = 4;
        String jsonPrettyPrintString = "";
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
            jsonPrettyPrintString = xmlJSONObj
                    .toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);
        }
        catch (JSONException je) {
            System.out.println(je.toString());
        }
        return jsonPrettyPrintString;
    }
    
    @SuppressWarnings("unchecked")
    private static String deleteNodes(String supplierTnNumber,
                                      List<String> deleteNodesList,
                                      File tempWorkFile) throws Exception {
        String value = "";
        SAXBuilder builder = new SAXBuilder();
        Document document = (Document) builder.build(tempWorkFile);
        Element rootElement = document.getRootElement();
        Element cust = (Element) rootElement.getChildren().get(0);
        cust.removeAttribute(IDPConstants.DEC_ACCID);
        List<Element> elements = cust.getChildren();
        if (elements != null) {
            Iterator<Element> i = elements.iterator();
            while (i.hasNext()) {
                if (deleteNodesList.contains(i.next().getName())) {
                    i.remove();
                }
            }
            value = xmlDocToString(document);
            value = value.replaceAll("\\s+"," ");
        }
        return value;
    }
    
    private static String xmlDocToString(Document doc) {
        // build a string from an XML document
        XMLOutputter outputter = new XMLOutputter();
        String xml = null;
        // outputter.setFormat(Format.getPrettyFormat());
        xml = outputter.outputString(doc);
        return xml;
      }
    
    private IDPMsgBean validateCustomerAndDecisionXmlFile(CustomerandDecisionInboundDataMapperBean mapperBean,
                                       String supplierTnNumber,
                                       IDPMsgBean idpMsgBean) throws Exception {
        
        InputStream in=null;
        //
        try {
            JAXBContext jaxbContext = JAXBContext
                    .newInstance(CustomerandDecisionInboundDataMapperBean.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File tempDirectory = new File(FlatFileUtilXml.getTempworkPath());
            boolean isCreated=false;
            if (!tempDirectory.isDirectory()) {
                isCreated = tempDirectory.mkdirs();
            }
            if(!isCreated){
                idpMsgBean.setResponseCode(WsErrorMessageConstants.SYSTEM_ERROR);
            }
            File tempWorkFile = new File(new FlatFileUtilXml().tempWorkFileName(
                    supplierTnNumber, FlatFileUtilXml.NAMEPREFIX_CREDIT_DECI_CUST_DECI));
            // write XML file to temporrary area
            marshaller.marshal(mapperBean, tempWorkFile);
            //
            // marshaller.ma
            byte[] data = FileUtils.readFileToByteArray(tempWorkFile);
            String value = new String(data, "UTF-8");
            // System.out.println(value);
            in = new FileInputStream(tempWorkFile);
            //
            String schemaPath = AppConfig.getWebContentPath()
                    + CUSTOMER_DECISION_SCHEMA_LOCATION_RELATIVE;
            File schemaFile = new File(schemaPath);
            //
            if (new BectranSchemaValidator().validate(schemaFile, in)) {
                idpMsgBean.setResponseCode(WsErrorMessageConstants.SUCCESS);
                idpMsgBean.setXmlCustomerAndDecisionDocument(value);
                
                if (StringUtils.equals(idpMsgBean.getPostType(),MatrixConstants.IDP_TYPE_JSON)) {
                    //Code to convert JAXB to JSON
                    File tempWorkJson = new File(new FlatFileUtilXml().tempWorkFileName(
                            supplierTnNumber, FlatFileUtilXml.JSON_NAMEPREFIX_CREDIT_DECI_CUST_DECI));
                    marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
                    // Set it to true if you need to include the JSON root element in the JSON output
                    marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
                    // Set it to true if you need the JSON output to formatted
                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    // Marshal the object to JSON 
                    marshaller.marshal(mapperBean, tempWorkJson);
                    byte[] jsonData = FileUtils.readFileToByteArray(tempWorkJson);
                    String jsonValue = new String(jsonData, "UTF-8");
                    idpMsgBean.setJsonCustomerAndDecisionDocument(jsonValue);
                }

            }
            else {
                idpMsgBean
                        .setResponseCode(WsErrorMessageConstants.VALIDATION_ERROR);
            }
        }
        catch (Exception e) {
            throw e;
        }
        finally{
            if(in!=null){
                in.close();
            }
        }
        //
        return idpMsgBean;
    }
    
    public IDPMsgBean executeCustomerAndDecisionRequest(SupplierCompanyBean supplier,
                                     IDPMsgBean idpMsgBean, boolean global,
                                     EnterpriseAccountByGroupBean entBean)
            throws Exception {
        //
        //
        PastCreditAppBean pastCreditAppBean = new CustomerDataDAO()
                .getAppsForTransmissionByRequestId(supplier.getId(),
                        idpMsgBean.getRequestId());
        if (pastCreditAppBean == null) {
            System.out.println("---NO Results---> ");
            idpMsgBean.setResponseCode(WsErrorMessageConstants.NO_RESULTS);
            return idpMsgBean;
        }
        InboundCustomerandDecisionDataXmlBean dataXmlBean = new InboundCustomerDataXmlHelper()
                .processForCustomerAndDecisionApp(supplier, pastCreditAppBean);
//        List<InboundCustomerandDecisionDataXmlBean> dataXmlList = new ArrayList<InboundCustomerandDecisionDataXmlBean>();
//        dataXmlList.add(dataXmlBean);
        CustomerandDecisionInboundDataMapperBean mapperBean = new CustomerandDecisionInboundDataMapperBean();
        mapperBean.setDataXmlList(dataXmlBean);
        String location = determineFileLocation(supplier, global, entBean,
                idpMsgBean.getRequestId());
        //
        
        idpMsgBean = validateCustomerAndDecisionXmlFile(mapperBean, location, idpMsgBean);
        //
        return idpMsgBean;
    }
    
    //Code change for BEC-496
    public static void saveCreditReqTransmitDetails(String idpTransmitStatus,long requestId)
            throws DataAccessException {
        IDPDataDAO dataDao = new IDPDataDAO();
        CreditReqTransmitDetailsBean bean = dataDao.findCreditReqTransmitDetails(requestId);
        if(bean==null){
            bean = new CreditReqTransmitDetailsBean();
            bean.setHeaderId(requestId);
        }
        bean.setTransmitEnabled(MatrixConstants.ANSWER_YES);
        bean.setTransmitDate(Calendar.getInstance().getTime());
        bean.setTransmitStatus(idpTransmitStatus);
        bean.setTransmitMode(IDPConstants.TRANSMIT_MODE_IDP);
        dataDao.saveCreditReqTransmitDetailsBean(bean);
        
    }
    
    /**
     * This method compares selected customer attrs with db values from mapper bean
     * and removes un selected attrs from respective db values in mapper bean.
     * @author Ajay N Reddy Veluru 
     * @param CustomerInboundDataMapperBean
     * @param IDPMsgBean
     * @return CustomerInboundDataMapperBean with selected elements 
     *
     */
    public CustomerInboundDataMapperBean selectedCustomerData(CustomerInboundDataMapperBean mapperBean, IDPMsgBean idpMsgBean) {
    	
    	//set data xml bean to mapper bean after removing unselected nodes    	
    	InboundCustomerDataXmlBean customerDataFrmDBBean = mapperBean.getDataXmlList();
    	List<String> unSelectedSubCats = null;
    	    	
    	//remove account id
    	customerDataFrmDBBean.setAccountId(null);    	
    	
    	//Unselected parent nodes processing - It removes complete elements
    	unSelectedSubCats = idpMsgBean.getDeleteNodeNames();    	    	
    	for (String subCat : unSelectedSubCats){
	    		switch (subCat) {
		    		case IDPConstants.BASIC_INFO: customerDataFrmDBBean.setCustomerBasicInfo(null);break;
		    		case IDPConstants.OWNER_OFFICER_INFO: customerDataFrmDBBean.setOfficerInfoXmlBean(null);break;
		    		case IDPConstants.BILLING_INFO: customerDataFrmDBBean.setBillingInfoXmlBean(null);break;
		    		case IDPConstants.SHIPPING_INFO: customerDataFrmDBBean.setShippingInfoXmlBean(null);break;
		    		case IDPConstants.APAY_INFO: customerDataFrmDBBean.setApayInfoXmlBean(null);break;
		    		case IDPConstants.SALES_PERSON_INFO: customerDataFrmDBBean.setSalesRepInfoXmlBean(null);break;
		    		case IDPConstants.OPERATIONS_UNIT_INFO: customerDataFrmDBBean.setOpsUnitInfoXmlBean(null);break;
		    		case IDPConstants.BUSINESS_GROUP_INFO: customerDataFrmDBBean.setBusinessGroupXmlBean(null);break;
		    		case IDPConstants.PAGE_2_INFO: customerDataFrmDBBean.setPage2InfoXmlBean(null);break;
		    		case IDPConstants.TAX_EXEMPT_INFO: customerDataFrmDBBean.setTaxExemptInfoXmlBean(null);break;
		    		case IDPConstants.CREDIT_REFERENCE_INFO: customerDataFrmDBBean.setCreditRefInfoXmlBean(null);break;
		    		case IDPConstants.CUSTOM_DOC_INFO: customerDataFrmDBBean.setCustomDocInfoXmlBean(null);break;
		    		case IDPConstants.CREDIT_REQUEST_INFO: customerDataFrmDBBean.setCreditRequestInfo(null);break;		    		
	    		}		
    	} 
    	//add updated data bean to mapper bean
    	mapperBean.setDataXmlList(customerDataFrmDBBean);
    	return mapperBean;
    }
    
    /**
     * This method prepares data for JSON file after removing unchecked elements and subelements. If empty, returns empty JSON object.
     * @author Ajay N Reddy Veluru	
     * @param mapperBean
     * @param supplierTnNumber
     * @param idpMsgBean
     * @param marshaller
     * @throws ResourceLoadException
     * @throws PropertyException
     * @throws JAXBException
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    	private void prepareJSONDATA(CustomerInboundDataMapperBean mapperBean, String supplierTnNumber,
    			IDPMsgBean idpMsgBean, Marshaller marshaller)
    			throws ResourceLoadException, PropertyException, JAXBException, IOException, UnsupportedEncodingException {

    		// Ajay Veluru - Customer attributes selection in IDP process
    		if (idpMsgBean.getIdpAttributeSet() != null && idpMsgBean.getIdpAttributeSet().size() > 0) {
    			mapperBean = selectedCustomerData(mapperBean, idpMsgBean);
    		}

    		// Code to convert JAXB to JSON
    		File tempWorkJson = new File(
    				new FlatFileUtilXml().tempWorkFileName(supplierTnNumber, FlatFileUtilXml.JSON_NAMEPREFIX_CUSTOMER));

    		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
    		// Set it to true if you need to include the JSON root
    		// element in the JSON output
    		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
    		// Set it to true if you need the JSON output to formatted
    		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    		// Marshal the object to JSON
    		marshaller.marshal(mapperBean, tempWorkJson);

    		byte[] jsonData = FileUtils.readFileToByteArray(tempWorkJson);
    		String jsonValue = new String(jsonData, "UTF-8");

    		idpMsgBean.setJsonCustomerDocument(jsonValue);
    	}
    /**
     * This method prepares final xml after removing unchecked elements and subelements. If empty, prepare empty xml
     * @author Ajay N Reddy Veluru
     * @param supplierTnNumber
     * @param idpMsgBean
     * @param tempWorkFile
     * @throws Exception
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    	private void prepareXMLData(String supplierTnNumber, IDPMsgBean idpMsgBean, File tempWorkFile)
    			throws Exception, IOException, UnsupportedEncodingException {
    		String value;
    				
    		if (idpMsgBean.getDeleteNodeNames() != null && idpMsgBean.getDeleteNodeNames().size() > 0) {
    			value = deleteCustNodes(supplierTnNumber, idpMsgBean.getDeleteNodeNames(), tempWorkFile);
    		} else {
    			byte[] custData = FileUtils.readFileToByteArray(tempWorkFile);
    			value = new String(custData, "UTF-8");
    		}
    		idpMsgBean.setXmlDocument(value);
    	}

    	
    	/**
    	 * @ This method deletes unselected nodes from xml document
    	 * 
    	 * @return String containing final version xml
    	 */
    	@SuppressWarnings("unchecked")
    	private static String deleteCustNodes(String supplierTnNumber, List<String> deleteNodesList, File tempWorkFile) throws Exception {
    		String value = "";
    		try {
    			//Xml traversing
    			SAXBuilder builder = new SAXBuilder();
    			Document document = (Document) builder.build(tempWorkFile);
    			Element rootElement = document.getRootElement();
    			Element cust = (Element) rootElement.getChildren().get(0);//customer type retrieval
    			List<Element> elements = cust.getChildren();//Parent elements
    			
    			if (elements != null) {
    				Iterator<Element> i = elements.iterator();
    				while (i.hasNext()) {
    					if (deleteNodesList.contains(i.next().getName())) {
    						i.remove();
    					}
    				}
    				value = xmlDocToString(document);
    				value = value.replaceAll("\\s+", " ");
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	return value;		
    	}
   
	public static void saveOnPreqaulTransmitLogDetailsFromListener(IDPMsgBean idpMsgBean)   throws DataAccessException {
		IDPOnPrequalTransmitLogBean transmitLogBean = new IDPOnPrequalTransmitLogBean();
        transmitLogBean.setRequestId(idpMsgBean.getRequestId());
        transmitLogBean.setTransmittedFlag(MatrixConstants.ANSWER_NO);
        transmitLogBean.setLastUpdate(Calendar.getInstance().getTime());
        transmitLogBean.setGroupId(idpMsgBean.getGroupId());
        transmitLogBean.setSupplierId(idpMsgBean.getSupplierId());
        transmitLogBean.setProcessFlag(MatrixConstants.ANSWER_NO);
        
      //Code to set the retry count from the existing record
        IDPOnPrequalTransmitLogBean transmitSessionBean = new IDPDataDAO().findByPrequalTransmitLogBean(transmitLogBean.getRequestId());
        if(transmitSessionBean!=null){
            transmitLogBean.setRetryCount(transmitSessionBean.getRetryCount());
        }else{
            transmitLogBean.setRetryCount(0);
        }
        
        new IDPDataDAO().saveOnPreqaulTransmitLogDetailsFromListener(transmitLogBean);
	}

	public static void saveOnPrequalTransmitLogDetails(IDPMsgBean idpMsgBean, String flag)throws DataAccessException {
		IDPOnPrequalTransmitLogBean transmitLogBean = new IDPOnPrequalTransmitLogBean();
	        transmitLogBean.setRequestId(idpMsgBean.getRequestId());
	        transmitLogBean.setTransmittedFlag(flag);
	        transmitLogBean.setLastUpdate(Calendar.getInstance().getTime());
	        transmitLogBean.setGroupId(idpMsgBean.getGroupId());
	        transmitLogBean.setSupplierId(idpMsgBean.getSupplierId());
	        transmitLogBean.setProcessFlag(flag);
	        
	        long supplierID = transmitLogBean.getSupplierId();
	        long groupID = transmitLogBean.getGroupId();
	        // Check whether integration scope is global or biz group
	        GroupAccountRuleBean groupAccountRuleBean = new GroupAccountRuleDAO().find(supplierID);
	        // Get the primary group ID
	        GroupAccountBean groupAccount = null;
	        if (groupAccountRuleBean != null
	                && groupAccountRuleBean.isIntegrationScopeIsGlobal()) {
	            groupAccount = new GroupAccountDAO().getPrimaryGroup(
	                    supplierID);
	            groupID = groupAccount.getId();
	        }
	        
	        if (groupAccount != null) {
	            EnterpriseIntgServiceBean entgIntgSvcBean = EnterpriseAccountByGroupDAO
	                    .getEnterpriseIntgServiceBean(supplierID, groupID);
	            if (entgIntgSvcBean != null) {
	                entgIntgSvcBean.setLastUpdate(transmitLogBean.getLastUpdate());
	                EnterpriseIntgIdpServiceBean idpService = entgIntgSvcBean
	                        .getIdpServiceBean();
	                if (idpService != null) {
	                    idpService.setModifiedDate(transmitLogBean.getLastUpdate());
	                    if(StringUtils.equals(idpMsgBean.getResponseCode(),WsErrorMessageConstants.SUCCESS)){
	                        idpService.setLastBatchUpdateDt(transmitLogBean.getLastUpdate());
	                    }else{
	                        idpService.setErrorMsg(WsErrorMessageConstants.errorDescription(idpMsgBean.getResponseCode()));
	                    }
	                    
	                }
	                
	                //Code to set the retry count from the existing record
	                IDPOnPrequalTransmitLogBean transmitSessionBean = new IDPDataDAO().findByPrequalTransmitLogBean(transmitLogBean.getRequestId());
	                if(transmitSessionBean!=null){
	                    transmitLogBean.setRetryCount(transmitSessionBean.getRetryCount());
	                }else{
	                    transmitLogBean.setRetryCount(0);
	                }
	                
	                new IDPDataDAO().saveOnPrequalTransmitLogDetails(transmitLogBean, entgIntgSvcBean);
	            }
	        }
	}
 // ----------------------------------------------------------- Inner Classes
    
    public static void main(String []a) throws Exception{
        EnterpriseAccountByGroupBean entBean = new EnterpriseAccountByGroupBean();
        entBean.setId(97l);
        SupplierCompanyBean supplier = new SupplierCompanyBean();
        supplier.setId(69l);
        IDPMsgBean idpMsgBean = new IDPMsgBean();
       idpMsgBean.setPostType(MatrixConstants.IDP_TYPE_JSON);
        idpMsgBean.setRequestId(17608L);
        IDPCustomerHelper helper = new IDPCustomerHelper();
        helper.executeCustomerAndDecisionRequest(supplier, idpMsgBean, true, entBean);
        
    }

}
