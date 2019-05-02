/**
 *
 */
package com.bectran.sftp.xml.inbound.helper;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;

import com.bectran.b2b.customer.beans.CusCurrentTermsBean;
import com.bectran.b2b.customer.dao.CusCurrentTermsDAO;
import com.bectran.b2b.enterprise.beans.ApprovingOfficerBean;
import com.bectran.b2b.enterprise.beans.CrApprovalBean;
import com.bectran.b2b.supplier.beans.GroupAccountBean;
import com.bectran.b2b.supplier.blo.SubsFeatureControlBLO;
import com.bectran.b2b.supplier.dao.GroupAccountDAO;
import com.bectran.matrix.utils.DateUtility;
import com.bectran.sftp.xml.inbound.CustomApprovedCreditXMLBean;

/**
 * @author LOUIS IFEGUNI
 * @date Aug 9, 2012 : 10:17:53 PM
 */
public class ApprovedCustomerCreditXmlHelper extends CustomerDataLoadBase {

    public CustomApprovedCreditXMLBean initializeTrxnBean(CrApprovalBean bean)
            throws Exception {
        CustomApprovedCreditXMLBean txn = new CustomApprovedCreditXMLBean();
        //
        txn.setAmountRequested(bean.getCreditRequestSummary().getAmount().setScale(1, BigDecimal.ROUND_HALF_EVEN));
        //
        txn.setApprovalDate(DateUtility.reFormatDateForXmlSchema(bean
                .getApprovalDate()));
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
        txn.setTransactionId(getValueForXml(transactionID(bean
                .getCreditRequestSummary())));
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
            GroupAccountBean groupBean = new GroupAccountDAO().findGroup(bean
                    .getCreditRequestSummary().getGroupId().longValue());
            txn.setBectranReferenceId(groupBean.getId().toString());
            //
            txn.setGroupName(getValueForXml(groupBean.getName()));
            //
            txn.setInternalGroupCode(getValueForXml(groupBean
                    .getInternalGroupCode()));
        }
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
        // / File schemaFile = new
        // File("H:/workspace/myeclipse10/eintg-wspace/b2bentintgbatch/WebRoot/xml-data-integration/work-schema/inbound-credit-approval.xsd");
        // BectranSchemaValidator.validate(schemaFile, in);
        System.out.println("----stop---");
    }
}
