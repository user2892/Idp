package com.bectran.b2b.bridge.ops;

import com.bectran.b2b.crol.beans.RefRequestBridgeBean;
import com.bectran.b2b.customer.beans.RefForRequestBean;
import com.bectran.b2b.supplier.dao.CreditReferenceDAO;

public class B2BridgeBLO {
    public static RefRequestBridgeBean getRequestBridge(RefForRequestBean refForRequest)
            throws Exception {
        //
        RefRequestBridgeBean bridgeBean = CreditReferenceDAO
                .getRequestBridgeBean(refForRequest.getId().longValue());
        if (bridgeBean == null) {
            // creditRequestBean creditRequest =
            // CreditRequestDAO.getRequest(refForRequest.getRequestId().longValue());
            // CreditRefMgtExtBLO.createRefCallPlaceHolder(refForRequest,
            // creditRequest);
            // refresh bridgebean for normal application flow
            bridgeBean = CreditReferenceDAO
                    .getRequestBridgeBean(refForRequest.getId().longValue());
        }
        return bridgeBean;
    }
}
