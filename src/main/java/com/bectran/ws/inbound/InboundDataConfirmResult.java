package com.bectran.ws.inbound;

/**
 * LOUIS IFEGUNI Apr 11, 2016 / 4:16:06 PM
 */
public class InboundDataConfirmResult {
    private String callStatus;
    private String callStatusMsg;

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
