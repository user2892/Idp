/**
 * 
 */
package com.bectran.sftp.xml.inbound;

import javax.xml.bind.annotation.XmlType;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 2, 2013 : 8:17:48 PM
 */
@XmlType(propOrder = {"opsUnitName", "opsUnitCode"})
public class OpsUnitInfoXmlBean {
    //
    private String opsUnitName;
    private String opsUnitCode;

    //
    public String getOpsUnitName() {
        return opsUnitName;
    }

    public void setOpsUnitName(String opsUnitName) {
        this.opsUnitName = opsUnitName;
    }

    public String getOpsUnitCode() {
        return opsUnitCode;
    }

    public void setOpsUnitCode(String opsUnitCode) {
        this.opsUnitCode = opsUnitCode;
    }
    //
}
