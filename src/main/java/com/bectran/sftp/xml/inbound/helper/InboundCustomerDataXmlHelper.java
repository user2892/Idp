/**
 *
 */
package com.bectran.sftp.xml.inbound.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.bectran.attribute.beans.CustomAppLayout;
import com.bectran.b2b.constants.FlatFileUpdateConstant;
import com.bectran.b2b.crol.beans.RefResultBean;
import com.bectran.b2b.crol.blo.AnalyzeReference;
import com.bectran.b2b.cspack.beans.CsPackBean;
import com.bectran.b2b.cspack.dao.CsPackDAO;
import com.bectran.b2b.customer.beans.CustomCreditAppValuesLayoutBeanBean;
import com.bectran.b2b.customer.beans.PastCreditAppBean;
import com.bectran.b2b.customer.beans.RefForRequestBean;
import com.bectran.b2b.enterprise.beans.CrApprovalBean;
import com.bectran.b2b.enterprise.dao.CrApprovalDAO;
import com.bectran.b2b.supplier.beans.GroupAccountBean;
import com.bectran.b2b.supplier.beans.SupplierCompanyBean;
import com.bectran.b2b.supplier.blo.SubsFeatureControlBLO;
import com.bectran.b2b.supplier.dao.GroupAccountDAO;
import com.bectran.b2b.supplier.dao.SupplierCompanyDAO;
import com.bectran.flatfile.load.FlatFileUtilXml;
import com.bectran.matrix.utils.DateUtility;
import com.bectran.opsmgt.beans.OpsUnitDefinitionBean;
import com.bectran.opsmgt.beans.OpsUnitRequestMgtBean;
import com.bectran.opsmgt.dao.OpsMgtDAO;
import com.bectran.sftp.xml.inbound.ApayInfoXmlBean;
import com.bectran.sftp.xml.inbound.BillingInfoXmlBean;
import com.bectran.sftp.xml.inbound.BusinessGroupXmlBean;
import com.bectran.sftp.xml.inbound.CreditRefInfoXmlBean;
import com.bectran.sftp.xml.inbound.CreditRequestConfigHelper;
import com.bectran.sftp.xml.inbound.CreditRequestInfoXmlBean;
import com.bectran.sftp.xml.inbound.CustomApprovedCreditXMLBean;
import com.bectran.sftp.xml.inbound.CustomDocInfoXmlBean;
import com.bectran.sftp.xml.inbound.CustomerBasicInfoXmlBean;
import com.bectran.sftp.xml.inbound.CustomerInboundDataMapperBean;
import com.bectran.sftp.xml.inbound.InboundApayInfoXmlBean;
import com.bectran.sftp.xml.inbound.InboundBillingInfoXmlBean;
import com.bectran.sftp.xml.inbound.InboundCreditRefInfoXmlBean;
import com.bectran.sftp.xml.inbound.InboundCustomDocInfoXmlBean;
import com.bectran.sftp.xml.inbound.InboundCustomerDataXmlBean;
import com.bectran.sftp.xml.inbound.InboundCustomerandDecisionDataXmlBean;
import com.bectran.sftp.xml.inbound.InboundOwnerOfficerInfoXmlBean;
import com.bectran.sftp.xml.inbound.InboundPage2InfoXmlBean;
import com.bectran.sftp.xml.inbound.InboundShippingInfoXmlBean;
import com.bectran.sftp.xml.inbound.InboundTaxExemptInfoXmlBean;
import com.bectran.sftp.xml.inbound.OpsUnitInfoXmlBean;
import com.bectran.sftp.xml.inbound.OwnerOfficerInfoXmlBean;
import com.bectran.sftp.xml.inbound.Page2InfoXmlBean;
import com.bectran.sftp.xml.inbound.SalesRepInfoXmlBean;
import com.bectran.sftp.xml.inbound.ShippingInfoXmlBean;
import com.bectran.sftp.xml.inbound.TaxExemptInfoXmlBean;
import com.bectran.xml.helper.BectranSchemaValidator;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 3, 2013 : 11:11:02 AM
 */
public class InboundCustomerDataXmlHelper extends CustomerDataLoadBase {
    private static final String SCHEMA_LOCATION_RELATIVE = "xml-data-integration/work-schema/inbound/inbound-customer-data.xsd";

     

    

    public InboundCustomerDataXmlBean processForApp(SupplierCompanyBean supplier,
                                                    PastCreditAppBean app)
            throws Exception {
        // PastCreditAppBean app = new CustomerDataDAO().findAppById(205);
        //
        InboundCustomerDataXmlBean dataXmlBean = new InboundCustomerDataXmlBean();
        dataXmlBean.setAccountId(app.getAcctNum());
        dataXmlBean.setTransactionId(String.valueOf(app.getId()));
        //
        // customer basic info
        CustomerBasicInfoXmlBean customerBasicInfo = new CustomerBasicInfoLoad()
                .initializeTrxnBean(app);
        dataXmlBean.setCustomerBasicInfo(customerBasicInfo);
        // Tax Exempt info
        List<TaxExemptInfoXmlBean> taxExemptList = new TaxExemptInfoLoad()
                .loadData(app.getId(), supplier);
        if (taxExemptList != null && taxExemptList.size() > 0) {
            InboundTaxExemptInfoXmlBean taxExemptInfoXmlBean = new InboundTaxExemptInfoXmlBean();
            taxExemptInfoXmlBean.setTaxExemptList(taxExemptList);
            dataXmlBean.setTaxExemptInfoXmlBean(taxExemptInfoXmlBean);
        }
        // owner officer info
        List<OwnerOfficerInfoXmlBean> ownerOfficerList = new OwnerOfficerInfoLoad()
                .initializeTrxnBean(app.getOfficerSet());
        if (ownerOfficerList != null && ownerOfficerList.size() > 0) {
            InboundOwnerOfficerInfoXmlBean officerInfoXmlBean = new InboundOwnerOfficerInfoXmlBean();
            officerInfoXmlBean.setOwnerOfficerList(ownerOfficerList);
            dataXmlBean.setOfficerInfoXmlBean(officerInfoXmlBean);
        }
        // billing information
        List<BillingInfoXmlBean> billingInfoList = new BillingInfoLoad()
                .initializeTrxnBean(app.getContactSet());
        if (billingInfoList != null && billingInfoList.size() > 0) {
            InboundBillingInfoXmlBean billingInfoXmlBean = new InboundBillingInfoXmlBean();
            billingInfoXmlBean.setBillingInfoList(billingInfoList);
            dataXmlBean.setBillingInfoXmlBean(billingInfoXmlBean);
        }
        //
        // shipping information
        List<ShippingInfoXmlBean> shippingInfoList = new ShippingInfoLoad()
                .initializeTrxnBean(app.getContactSet());
        if (shippingInfoList != null && shippingInfoList.size() > 0) {
            InboundShippingInfoXmlBean shippingInfoXmlBean = new InboundShippingInfoXmlBean();
            shippingInfoXmlBean.setShippingInfoList(shippingInfoList);
            dataXmlBean.setShippingInfoXmlBean(shippingInfoXmlBean);
        }
        //
        // apay information
        List<ApayInfoXmlBean> apayInfoList = new ApayInfoLoad()
                .initializeTrxnBean(app.getContactSet());
        if (apayInfoList != null && apayInfoList.size() > 0) {
            InboundApayInfoXmlBean apayInfoXmlBean = new InboundApayInfoXmlBean();
            apayInfoXmlBean.setApayInfoList(apayInfoList);
            dataXmlBean.setApayInfoXmlBean(apayInfoXmlBean);
        }
        // SALES REP
        long id = app.getId().longValue();
        CsPackBean salesRepBean = CsPackDAO.getCsPack(id);
        if (salesRepBean != null) {
            SalesRepInfoXmlBean salesRepInfoXmlBean = new SalesRepInfoLoad()
                    .initializeTrxnBean(salesRepBean.getCsUserDetail());
            dataXmlBean.setSalesRepInfoXmlBean(salesRepInfoXmlBean);
        }
        // ops unit
        OpsUnitRequestMgtBean opsUnitRequest = OpsMgtDAO.findOpsUnitRequest(id);
        if (opsUnitRequest != null) {
            OpsUnitDefinitionBean unit = OpsMgtDAO
                    .findUnit(opsUnitRequest.getOpsUnitId().longValue());
            OpsUnitInfoXmlBean opsUnitInfoXmlBean = new OpsUnitInfoLoad()
                    .initializeTrxnBean(unit);
            dataXmlBean.setOpsUnitInfoXmlBean(opsUnitInfoXmlBean);
        }
        // multiple group
        boolean hasMultipleGroup = new SubsFeatureControlBLO()
                .hasMultipleGroup(supplier.getId());
        if (hasMultipleGroup) {
            GroupAccountBean groupBean = new GroupAccountDAO()
                    .findGroup(app.getGroupId().longValue());
            BusinessGroupXmlBean businessGroupXmlBean = new BusinessGroupInfoLoad()
                    .initializeTrxnBean(groupBean);
            dataXmlBean.setBusinessGroupXmlBean(businessGroupXmlBean);
        }
        
        InboundPage2InfoXmlBean page2InfoXmlBean = new InboundPage2InfoXmlBean();
        //Legacy Page2 Attributes
        List<CustomCreditAppValuesLayoutBeanBean> page2Data = new Page2InformationHelper()
                .processPage2(app);
        if (page2Data != null && page2Data.size() > 0) {
            List<Page2InfoXmlBean> page2InfoList = new Page2InformationHelper()
                    .populateInfoBean(page2Data);
            page2InfoXmlBean.setPage2InfoList(page2InfoList);
        }
        
        //Page2 Advance Config
        List<CustomAppLayout> customAppLayouts = new Page2InformationHelper()
                .processPage2AdvanceConfig(app);
        if (customAppLayouts != null && customAppLayouts.size() > 0) {
//            InboundPage2InfoXmlBean page2InfoXmlBean = dataXmlBean
//                    .getPage2InfoXmlBean();
            List<Page2InfoXmlBean> page2InfoList = page2InfoXmlBean.getPage2InfoList();
            if (page2InfoList == null) {
                page2InfoList = new ArrayList<Page2InfoXmlBean>();
            }
            List<Page2InfoXmlBean> advancedPage2InfoList = new Page2InformationHelper()
                    .populateInfoBeanWithAdvancePage2(customAppLayouts);
            if (advancedPage2InfoList != null) {
                page2InfoList.addAll(advancedPage2InfoList);
            }
            page2InfoXmlBean.setPage2InfoList(page2InfoList);
        }
        if(page2InfoXmlBean.getPage2InfoList() !=null && page2InfoXmlBean.getPage2InfoList().size()>0){
            dataXmlBean.setPage2InfoXmlBean(page2InfoXmlBean);
        }
        
        // Credit References
        Set<RefForRequestBean> references = app.getRefForRequestSET();
        if (references != null) {
            Map<Long, RefResultBean> refResults = new HashMap<Long, RefResultBean>();
            for (RefForRequestBean refForRequestBean : references) {
                RefResultBean refResult = AnalyzeReference.getReference(
                        refForRequestBean.getId(), app.getTransactionCcy());
                refResults.put(refForRequestBean.getId(), refResult);
            }
            List<CreditRefInfoXmlBean> creditRefInfoList = new CreditRefInfoLoad()
                    .initializeTrxnBean(references, refResults,
                            app.getTransactionCcy());
            if (creditRefInfoList != null && creditRefInfoList.size() > 0) {
                InboundCreditRefInfoXmlBean creditRefInfoXmlBean = new InboundCreditRefInfoXmlBean();
                creditRefInfoXmlBean.setCreditRefInfoList(creditRefInfoList);
                dataXmlBean.setCreditRefInfoXmlBean(creditRefInfoXmlBean);
            }
        }
        // Custom Documents
        /*	 */
        // List<CustomDocInfoXmlBean> customDocList = new
        // CustomDocInfoLoad().loadData(app.getId(),
        // DocumentMgtConstant.ID_CUS_DOC_UPLOADABLE,supplier);
        List<CustomDocInfoXmlBean> customDocList = new CustomDocInfoLoad()
                .loadData(app.getId(), supplier);
        if (customDocList != null && customDocList.size() > 0) {
            InboundCustomDocInfoXmlBean customDocInfoXmlBean = new InboundCustomDocInfoXmlBean();
            customDocInfoXmlBean.setCustomDocList(customDocList);
            dataXmlBean.setCustomDocInfoXmlBean(customDocInfoXmlBean);
        }
        // mapperBean.setDataXmlBean(dataXmlBean);
        //
      //Credit Request Info
        CreditRequestInfoXmlBean creditRequestInfo = new CreditRequestInfoXmlBean();
        creditRequestInfo.setRequestId(String.valueOf(app.getId()));
        creditRequestInfo.setAmountRequested(app.getAmount().setScale(1, BigDecimal.ROUND_HALF_EVEN));
        creditRequestInfo.setRequestDate(DateUtility.reFormatDateForXmlSchema(app.getAppDate()));
        creditRequestInfo.setTermRequestedCode(getValueForXml(app.getCreditTerm()));
        creditRequestInfo.setTermRequestedDescription(getValueForXml(app.getCreditTermDetail()));
        creditRequestInfo.setPlannedPurchase(getValueForXml(app.getPlannedMonthlyPurchase()));
        //
        creditRequestInfo.setRequestSource(CreditRequestConfigHelper.determineRequestSource(app));
        creditRequestInfo.setRequestFormType(CreditRequestConfigHelper.determineFormType(app));

        
        dataXmlBean.setCreditRequestInfo(creditRequestInfo);
        return dataXmlBean;
    }

    private boolean writeToXmlFile(CustomerInboundDataMapperBean mapperBean,
                                   String supplierTnNumber)
            throws Exception {
        //
        JAXBContext jaxbContext = JAXBContext
                .newInstance(CustomerInboundDataMapperBean.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File tempWorkFile = new File(new FlatFileUtilXml().tempWorkFileName(
                supplierTnNumber, FlatFileUtilXml.NAMEPREFIX_CUS_SETUP));
        // write XML file to temporrary area
        marshaller.marshal(mapperBean, tempWorkFile);
        // marshaller.marshal(mapperBean, System.out);
        //
        boolean valid = validateXml(tempWorkFile);
        if (valid) {
            // copy file to CLIENT wip folder
            File wipFile = new File(new FlatFileUtilXml().fileNameInWip(
                    supplierTnNumber, FlatFileUtilXml.NAMEPREFIX_CUS_SETUP,
                    FlatFileUpdateConstant.INBOUND_FOLDER));
            new FlatFileUtilXml().renameAndMoveProcessedFile(tempWorkFile,
                    wipFile);
        }
        return valid;
    }

    private boolean validateXml(File file) throws Exception {
        boolean flag=false;
        InputStream in=null;
        try {
            in = new FileInputStream(file);
            //
             String schemaPath ="F://bectran/eworkspaces/othwrkspace/idp/src/main/webapp/"+
             SCHEMA_LOCATION_RELATIVE;
//            String schemaPath = AppConfig.getWebContentPath()
//                    + SCHEMA_LOCATION_RELATIVE;
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
    
    public InboundCustomerandDecisionDataXmlBean processForCustomerAndDecisionApp(SupplierCompanyBean supplier,
                                                    PastCreditAppBean app)
            throws Exception {
        // PastCreditAppBean app = new CustomerDataDAO().findAppById(205);
        //
        InboundCustomerandDecisionDataXmlBean dataXmlBean = new InboundCustomerandDecisionDataXmlBean();
        dataXmlBean.setAccountId(app.getAcctNum());
        dataXmlBean.setTransactionId(String.valueOf(app.getId()));
        //
        // customer basic info
        CustomerBasicInfoXmlBean customerBasicInfo = new CustomerBasicInfoLoad()
                .initializeTrxnBean(app);
        dataXmlBean.setCustomerBasicInfo(customerBasicInfo);
        // Tax Exempt info
        List<TaxExemptInfoXmlBean> taxExemptList = new TaxExemptInfoLoad()
                .loadData(app.getId(), supplier);
        if (taxExemptList != null && taxExemptList.size() > 0) {
            InboundTaxExemptInfoXmlBean taxExemptInfoXmlBean = new InboundTaxExemptInfoXmlBean();
            taxExemptInfoXmlBean.setTaxExemptList(taxExemptList);
            dataXmlBean.setTaxExemptInfoXmlBean(taxExemptInfoXmlBean);
        }
        // owner officer info
        List<OwnerOfficerInfoXmlBean> ownerOfficerList = new OwnerOfficerInfoLoad()
                .initializeTrxnBean(app.getOfficerSet());
        if (ownerOfficerList != null && ownerOfficerList.size() > 0) {
            InboundOwnerOfficerInfoXmlBean officerInfoXmlBean = new InboundOwnerOfficerInfoXmlBean();
            officerInfoXmlBean.setOwnerOfficerList(ownerOfficerList);
            dataXmlBean.setOfficerInfoXmlBean(officerInfoXmlBean);
        }
        // billing information
        List<BillingInfoXmlBean> billingInfoList = new BillingInfoLoad()
                .initializeTrxnBean(app.getContactSet());
        if (billingInfoList != null && billingInfoList.size() > 0) {
            InboundBillingInfoXmlBean billingInfoXmlBean = new InboundBillingInfoXmlBean();
            billingInfoXmlBean.setBillingInfoList(billingInfoList);
            dataXmlBean.setBillingInfoXmlBean(billingInfoXmlBean);
        }
        //
        // shipping information
        List<ShippingInfoXmlBean> shippingInfoList = new ShippingInfoLoad()
                .initializeTrxnBean(app.getContactSet());
        if (shippingInfoList != null && shippingInfoList.size() > 0) {
            InboundShippingInfoXmlBean shippingInfoXmlBean = new InboundShippingInfoXmlBean();
            shippingInfoXmlBean.setShippingInfoList(shippingInfoList);
            dataXmlBean.setShippingInfoXmlBean(shippingInfoXmlBean);
        }
        //
        // apay information
        List<ApayInfoXmlBean> apayInfoList = new ApayInfoLoad()
                .initializeTrxnBean(app.getContactSet());
        if (apayInfoList != null && apayInfoList.size() > 0) {
            InboundApayInfoXmlBean apayInfoXmlBean = new InboundApayInfoXmlBean();
            apayInfoXmlBean.setApayInfoList(apayInfoList);
            dataXmlBean.setApayInfoXmlBean(apayInfoXmlBean);
        }
        // SALES REP
        long id = app.getId().longValue();
        CsPackBean salesRepBean = CsPackDAO.getCsPack(id);
        if (salesRepBean != null) {
            SalesRepInfoXmlBean salesRepInfoXmlBean = new SalesRepInfoLoad()
                    .initializeTrxnBean(salesRepBean.getCsUserDetail());
            dataXmlBean.setSalesRepInfoXmlBean(salesRepInfoXmlBean);
        }
        // ops unit
        OpsUnitRequestMgtBean opsUnitRequest = OpsMgtDAO.findOpsUnitRequest(id);
        if (opsUnitRequest != null) {
            OpsUnitDefinitionBean unit = OpsMgtDAO
                    .findUnit(opsUnitRequest.getOpsUnitId().longValue());
            OpsUnitInfoXmlBean opsUnitInfoXmlBean = new OpsUnitInfoLoad()
                    .initializeTrxnBean(unit);
            dataXmlBean.setOpsUnitInfoXmlBean(opsUnitInfoXmlBean);
        }
        // multiple group
        boolean hasMultipleGroup = new SubsFeatureControlBLO()
                .hasMultipleGroup(supplier.getId());
        if (hasMultipleGroup) {
            GroupAccountBean groupBean = new GroupAccountDAO()
                    .findGroup(app.getGroupId().longValue());
            BusinessGroupXmlBean businessGroupXmlBean = new BusinessGroupInfoLoad()
                    .initializeTrxnBean(groupBean);
            dataXmlBean.setBusinessGroupXmlBean(businessGroupXmlBean);
        }
        
        InboundPage2InfoXmlBean page2InfoXmlBean = new InboundPage2InfoXmlBean();
        //Legacy Page2 Attributes
        List<CustomCreditAppValuesLayoutBeanBean> page2Data = new Page2InformationHelper()
                .processPage2(app);
        if (page2Data != null && page2Data.size() > 0) {
            List<Page2InfoXmlBean> page2InfoList = new Page2InformationHelper()
                    .populateInfoBean(page2Data);
            page2InfoXmlBean.setPage2InfoList(page2InfoList);
        }
        
        //Page2 Advance Config
        List<CustomAppLayout> customAppLayouts = new Page2InformationHelper()
                .processPage2AdvanceConfig(app);
        if (customAppLayouts != null && customAppLayouts.size() > 0) {
//            InboundPage2InfoXmlBean page2InfoXmlBean = dataXmlBean
//                    .getPage2InfoXmlBean();
            List<Page2InfoXmlBean> page2InfoList = page2InfoXmlBean.getPage2InfoList();
            if (page2InfoList == null) {
                page2InfoList = new ArrayList<Page2InfoXmlBean>();
            }
            List<Page2InfoXmlBean> advancedPage2InfoList = new Page2InformationHelper()
                    .populateInfoBeanWithAdvancePage2(customAppLayouts);
            if (advancedPage2InfoList != null) {
                page2InfoList.addAll(advancedPage2InfoList);
            }
            page2InfoXmlBean.setPage2InfoList(page2InfoList);
        }
        if(page2InfoXmlBean.getPage2InfoList() !=null && page2InfoXmlBean.getPage2InfoList().size()>0){
            dataXmlBean.setPage2InfoXmlBean(page2InfoXmlBean);
        }
        
        // Credit References
        Set<RefForRequestBean> references = app.getRefForRequestSET();
        if (references != null) {
            Map<Long, RefResultBean> refResults = new HashMap<Long, RefResultBean>();
            for (RefForRequestBean refForRequestBean : references) {
                RefResultBean refResult = AnalyzeReference.getReference(
                        refForRequestBean.getId(), app.getTransactionCcy());
                refResults.put(refForRequestBean.getId(), refResult);
            }
            List<CreditRefInfoXmlBean> creditRefInfoList = new CreditRefInfoLoad()
                    .initializeTrxnBean(references, refResults,
                            app.getTransactionCcy());
            if (creditRefInfoList != null && creditRefInfoList.size() > 0) {
                InboundCreditRefInfoXmlBean creditRefInfoXmlBean = new InboundCreditRefInfoXmlBean();
                creditRefInfoXmlBean.setCreditRefInfoList(creditRefInfoList);
                dataXmlBean.setCreditRefInfoXmlBean(creditRefInfoXmlBean);
            }
        }
        // Custom Documents
        /*   */
        // List<CustomDocInfoXmlBean> customDocList = new
        // CustomDocInfoLoad().loadData(app.getId(),
        // DocumentMgtConstant.ID_CUS_DOC_UPLOADABLE,supplier);
        List<CustomDocInfoXmlBean> customDocList = new CustomDocInfoLoad()
                .loadData(app.getId(), supplier);
        if (customDocList != null && customDocList.size() > 0) {
            InboundCustomDocInfoXmlBean customDocInfoXmlBean = new InboundCustomDocInfoXmlBean();
            customDocInfoXmlBean.setCustomDocList(customDocList);
            dataXmlBean.setCustomDocInfoXmlBean(customDocInfoXmlBean);
        }
        
      //Credit Request Info
        CreditRequestInfoXmlBean creditRequestInfo = new CreditRequestInfoXmlBean();
        creditRequestInfo.setRequestId(String.valueOf(app.getId()));
        creditRequestInfo.setAmountRequested(app.getAmount().setScale(1, BigDecimal.ROUND_HALF_EVEN));
        creditRequestInfo.setRequestDate(DateUtility.reFormatDateForXmlSchema(app.getAppDate()));
        creditRequestInfo.setTermRequestedCode(getValueForXml(app.getCreditTerm()));
        creditRequestInfo.setTermRequestedDescription(getValueForXml(app.getCreditTermDetail()));
        creditRequestInfo.setPlannedPurchase(getValueForXml(app.getPlannedMonthlyPurchase()));
        //
        creditRequestInfo.setRequestSource(CreditRequestConfigHelper.determineRequestSource(app));
        creditRequestInfo.setRequestFormType(CreditRequestConfigHelper.determineFormType(app));

        
        dataXmlBean.setCreditRequestInfo(creditRequestInfo);
        //
        //Approval Bean
        long requestId = app.getId().longValue();
        CrApprovalBean approvalBean = CrApprovalDAO.findByRequestId(requestId);
        if (approvalBean != null) {
            CustomApprovedCreditXMLBean approvalXMLBean = new ApprovedCustomerCreditXmlHelper()
                    .initializeTrxnBean(approvalBean);
            dataXmlBean.setCustomApprovedCreditXMLBean(approvalXMLBean);
        }
        
        // mapperBean.setDataXmlBean(dataXmlBean);
        //
        return dataXmlBean;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 
        System.out.println("----start---");
         
         SupplierCompanyBean supplier = new SupplierCompanyDAO().findCompany(69);
         //EnterpriseAccountByGroupBean entBean = new EnterpriseAccountByGroupDAO().find(97);
        //new InboundCustomerDataXmlHelper().executeRequest(supplier, DateUtility.dateOfXDaysFromToday(-1),entBean,  true);
         
//         PastCreditAppBean app = new CreditRequestDAO().getPastRequest(17608);
//        new InboundCustomerDataXmlHelper().processForApp(supplier, app);
//      String clearPasscode = PassCodeHelper.decryptCode(entBean.getPassCode().trim(), entBean.getMysalt());
//       System.out.println("id: "+entBean.getAccountId()+" : "+entBean.isProdInboundMode());
//       System.out.println("pcode: "+clearPasscode);

        System.out.println("----stop---");

    }
}
