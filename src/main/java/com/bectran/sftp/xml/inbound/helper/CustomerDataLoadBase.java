/**
 *
 */
package com.bectran.sftp.xml.inbound.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.constants.WsErrorMessageConstants;
import com.bectran.b2b.customer.beans.AppOtherContactBean;
import com.bectran.b2b.customer.beans.CreditRequestBaseBean;
import com.bectran.b2b.customer.beans.CreditRequestBean;
import com.bectran.b2b.enterprise.beans.EnterpriseAccountByGroupBean;
import com.bectran.b2b.enterprise.beans.WsDataLoadTrackerBean;
import com.bectran.b2b.enterprise.dao.WsDataLoadTrackerDAO;
import com.bectran.b2b.supplier.beans.GroupAccountBean;
import com.bectran.b2b.supplier.beans.SupplierCompanyBean;
import com.bectran.matrix.framework.PassCodeHelper;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.ws.inbound.InboundDataConfirmResult;
import com.bectran.ws.inbound.InboundDataQueryResultBase;
import com.bectran.ws.inbound.InboundDataWsRequest;
import com.bectran.ws.outbound.OutboundDataConfirmResult;
import com.bectran.ws.outbound.OutboundDataWsRequest;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 3, 2013 : 2:15:28 PM
 */
public class CustomerDataLoadBase {
    public static final int DEFAULT_INBOUND_DATA_BEGIN_DAYS = -60;
    public static final int MAX_DATA_QUERY_LOAD_SFTP = 500;
    public static final int MAX_DATA_QUERY_LOAD_WS = 25;

    protected String getValueForXml(String value) {
        return value != null ? value.trim() : "";
    }

    protected List<AppOtherContactBean> shipBillInfo(String contactType,
                                                     Set<AppOtherContactBean> contactSet) {
        List<AppOtherContactBean> ls = new ArrayList<AppOtherContactBean>();
        for (AppOtherContactBean bean : contactSet) {
            if (bean.getContactType().trim().equals(contactType.trim())) {
                ls.add(bean);
            }
        }
        return ls;
    }

    public String determineFileLocation(SupplierCompanyBean supplier,
                                        boolean global,
                                        EnterpriseAccountByGroupBean entBean) {
        String location = supplier.getCorpID().trim();
        if (!global) {
            location = supplier.getCorpID().trim() + entBean.getId();
        }
        return location.trim();
    }

    public String determineInternalAccountID(GroupAccountBean bean,
                                             String accountNum) {
        String id = bean.getSupplierId() + MatrixConstants.ID_SEPARATOR
                + bean.getId() + MatrixConstants.ID_SEPARATOR
                + accountNum.trim();
        //
        return id.trim();
    }

    protected String transactionID(CreditRequestBaseBean creditapp) {
        String id = CreditRequestBean.REQUEST_ID_PREFIX
                + creditapp.getId().longValue();
        if (creditapp.isEnhanchedPaperCreditApp()) {
            id = CreditRequestBean.PAPER_APP_ID_PREFIX
                    + creditapp.getId().longValue();
        }
        else if (creditapp.isRequestIsReviewType()) {
            id = CreditRequestBean.REVIEW_ID_PREFIX
                    + creditapp.getId().longValue();
        }
        return id;
    }

    protected void setStatusMessage(InboundDataQueryResultBase result,
                                    String statusCode) {
        result.setCallStatus(statusCode);
        result.setCallStatusMsg(
                WsErrorMessageConstants.errorDescription(statusCode));
    }

    protected void setStatusMessage(InboundDataConfirmResult result,
                                    String statusCode) {
        result.setCallStatus(statusCode);
        result.setCallStatusMsg(
                WsErrorMessageConstants.errorDescription(statusCode));
    }

    protected void setStatusMessage(OutboundDataConfirmResult result,
                                    String statusCode) {
        result.setCallStatus(statusCode);
        result.setCallStatusMsg(
                WsErrorMessageConstants.errorDescription(statusCode));
    }

    public boolean verifyWSAccess(EnterpriseAccountByGroupBean bean,
                                  InboundDataWsRequest request)
            throws Exception {
        //
        //
        String clearPasscode = PassCodeHelper
                .decryptCode(bean.getPassCode().trim(), bean.getMysalt());
        if (!clearPasscode.trim().equals(request.getPassword().trim())) {
            return false;
        }
        return true;
    }

    public boolean verifyWSAccess(EnterpriseAccountByGroupBean bean,
                                  OutboundDataWsRequest request)
            throws Exception {
        //
        //
        String clearPasscode = PassCodeHelper
                .decryptCode(bean.getPassCode().trim(), bean.getMysalt());
        if (!clearPasscode.trim().equals(request.getPassword().trim())) {
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
        statusBean.setTxnCode(PassCodeHelper
                .computeUniqueId(String.valueOf(groupBean.getId())));
        //
        new WsDataLoadTrackerDAO().saveOrUpdate(statusBean);
        //
        return statusBean;
    }
}
