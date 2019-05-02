/**
 * 
 */
package com.bectran.sftp.xml.inbound;

import javax.xml.bind.annotation.XmlType;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 2, 2013 : 8:17:48 PM
 */
@XmlType(propOrder = {"groupName", "internalGroupCode", "bectranReferenceId"})
public class BusinessGroupXmlBean {
    //
    private String internalGroupCode;
    private String groupName;
    private String bectranReferenceId;

    //
    public String getInternalGroupCode() {
        return internalGroupCode;
    }

    public void setInternalGroupCode(String internalGroupCode) {
        this.internalGroupCode = internalGroupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getBectranReferenceId() {
        return bectranReferenceId;
    }

    public void setBectranReferenceId(String bectranReferenceId) {
        this.bectranReferenceId = bectranReferenceId;
    }
    //
}
