/**
 * 
 */
package com.bectran.sftp.xml.inbound;

import javax.xml.bind.annotation.XmlType;

/**
 * @author LOUIS IFEGUNI
 * @date April 26, 2014 : 9:20:26 AM
 */
@XmlType(propOrder = {"certNum", "stateCode", "expiration", "hasExpirationDate",
        "docImageUrl"})
public class TaxExemptInfoXmlBean {
    //
    private String certNum;
    private String stateCode;
    private String expiration;
    private String hasExpirationDate;
    private String docImageUrl;

    public String getCertNum() {
        return certNum;
    }

    public void setCertNum(String certNum) {
        this.certNum = certNum;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getHasExpirationDate() {
        return hasExpirationDate;
    }

    public void setHasExpirationDate(String hasExpirationDate) {
        this.hasExpirationDate = hasExpirationDate;
    }

    public String getDocImageUrl() {
        return docImageUrl;
    }

    public void setDocImageUrl(String docImageUrl) {
        this.docImageUrl = docImageUrl;
    }
    //
}
