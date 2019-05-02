package com.bectran.ws.inbound;

/**
 * LOUIS IFEGUNI Apr 10, 2016 / 3:27:20 PM
 */
public class InboundDataQueryResultBase {
    private String callStatus;
    private String callStatusMsg;
    private String trxnBatchControlToken;
    //

    public String getTrxnBatchControlToken() {
        return trxnBatchControlToken;
    }

    public void setTrxnBatchControlToken(String trxnBatchControlToken) {
        this.trxnBatchControlToken = trxnBatchControlToken;
    }

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public String getCallStatusMsg() {
        return callStatusMsg;
    }

    public void setCallStatusMsg(String callStatusMsg) {
        this.callStatusMsg = callStatusMsg;
    }
}
