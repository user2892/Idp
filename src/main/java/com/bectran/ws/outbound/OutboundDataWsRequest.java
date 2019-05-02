/**
 * 
 */
package com.bectran.ws.outbound;

/**
 * LOUIS IFEGUNI Apr 13, 2016 / 9:34:23 AM
 */
public class OutboundDataWsRequest {
    private String userId;
    private String password;
    private String xmlInputDataDocument;

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

    public String getXmlInputDataDocument() {
        return xmlInputDataDocument;
    }

    public void setXmlInputDataDocument(String xmlDataDocument) {
        this.xmlInputDataDocument = xmlDataDocument;
    }
}
