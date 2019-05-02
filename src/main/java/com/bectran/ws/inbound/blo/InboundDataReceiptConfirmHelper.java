/**
 * 
 */
package com.bectran.ws.inbound.blo;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.constants.WsErrorMessageConstants;
import com.bectran.b2b.customer.dao.CustomerDataDAO;
import com.bectran.b2b.enterprise.beans.EnterpriseAccountByGroupBean;
import com.bectran.b2b.enterprise.beans.WsDataLoadTrackerBean;
import com.bectran.b2b.enterprise.dao.CustomerDataUpdateStatusDAO;
import com.bectran.b2b.enterprise.dao.WsDataLoadTrackerDAO;
import com.bectran.b2b.supplier.beans.GroupAccountBean;
import com.bectran.b2b.supplier.dao.GroupAccountDAO;
import com.bectran.sftp.xml.inbound.helper.CustomerDataLoadBase;
import com.bectran.ws.inbound.InboundDataConfirmResult;

/**
 * LOUIS IFEGUNI Apr 11, 2016 / 7:48:38 AM
 */
public class InboundDataReceiptConfirmHelper extends CustomerDataLoadBase {
    public void executeRequest(EnterpriseAccountByGroupBean entBean,
                               String trxnBatchControlToken, String cusDataType,
                               InboundDataConfirmResult result)
            throws Exception {
        //
        if (!entBean.isProdInboundMode()) {
            return;
        }
        WsDataLoadTrackerBean trackerBean = new WsDataLoadTrackerDAO()
                .findByTxnCode(trxnBatchControlToken.trim());
        if (trackerBean == null) {
            setStatusMessage(result, WsErrorMessageConstants.NO_RESULTS);
            return;
        }
        // UPDATE ONLY ON PRODUCTION MODE
        new CustomerDataDAO().confirmTransmittedData(MatrixConstants.ANSWER_YES,
                trxnBatchControlToken.trim());
        //
        GroupAccountBean groupBean = new GroupAccountDAO()
                .findGroup(trackerBean.getGroupId().longValue());
        new CustomerDataUpdateStatusDAO().updateLoadStatus(groupBean,
                trackerBean.getNumberOfRec(), trackerBean.getStartTime(), 1,
                cusDataType);
    }
}
