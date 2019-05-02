package com.bectran.ws.inbound;

/**
 * LOUIS IFEGUNI Apr 10, 2016 / 3:27:47 PM
 */
public class InboundDataWsRequest {
    private String userId;
    private String password;
    private String trxnBatchControlToken;

    //
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTrxnBatchControlToken() {
        return trxnBatchControlToken;
    }

    public void setTrxnBatchControlToken(String trxnBatchControlToken) {
        this.trxnBatchControlToken = trxnBatchControlToken;
    }
}
