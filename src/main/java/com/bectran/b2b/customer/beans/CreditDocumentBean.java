package com.bectran.b2b.customer.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI Apr 30, 2010 : 6:20:18 PM
 */
@Deprecated
public class CreditDocumentBean {
    public final static String ID_PERSONAL_GUARANTY = "PERS-GUARANTEE";
    private Long id;
    private Long requestId;
    private String docId;
    private String status = MatrixConstants.STATUS_INACTIVE; // initialized
    private Date lastUpdate;
    private String acctNum;
    private String docBody;
    private String docBodyPart2 = "";
    //
    //
    //
    public CreditDocumentBean() {
    }

    public String getDocName() {
        //
        return getDocNameFromMap(this.getDocId().trim());
    }

    private static String getDocNameFromMap(String _docId) {
        Map<String, String> docNameMap = new HashMap<String, String>();
        docNameMap.put(ID_PERSONAL_GUARANTY, "Personal Guarantee");
        return (String) docNameMap.get(_docId.trim());
    }

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocBody() {
        return docBody;
    }

    public void setDocBody(String docBody) {
        this.docBody = docBody;
    }

    public String getDocBodyPart2() {
        return docBodyPart2;
    }

    public void setDocBodyPart2(String docBodyPart2) {
        this.docBodyPart2 = docBodyPart2;
    }

    public String getStatusDisplay() {
        if (this.getStatus().trim().equals(MatrixConstants.STATUS_ACTIVE)) {
            return "Submitted";
        }
        return "in-progress";
    }

    public boolean isInprogress() {
        if (this.getStatus().trim().equals(MatrixConstants.STATUS_INACTIVE)) {
            return true;
        }
        return false;
    }

}
