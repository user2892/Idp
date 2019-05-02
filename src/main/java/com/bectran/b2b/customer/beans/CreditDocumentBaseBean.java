package com.bectran.b2b.customer.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 */
public class CreditDocumentBaseBean {
    public final static String ID_PERSONAL_GUARANTY = "PERS-GUARANTEE";
    public final static String ID_TAX_EXEMPT_CERT = "ID-TAX-EXEMPT-CERT";
    public final static String ID_FS = "ID-FS";
    private Long id;
    private Long docControlId;
    private Long requestId;
    private String docId;
    private Date lastUpdate;
    private String acctNum;
    //
    private String status = MatrixConstants.STATUS_INACTIVE; // initialized
    //
    //

    public String getDocName() {
        //
        return getDocNameFromMap(this.getDocId().trim());
    }

    private static String getDocNameFromMap(String _docId) {
        Map<String, String> docNameMap = new HashMap<String, String>();
        docNameMap.put(ID_PERSONAL_GUARANTY, "Personal Guarantee");
        docNameMap.put(ID_TAX_EXEMPT_CERT, "Tax Exempt Certificate");
        docNameMap.put(ID_FS, "Financial Statement");
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDocControlId() {
        return docControlId;
    }

    public void setDocControlId(Long docControlId) {
        this.docControlId = docControlId;
    }

    public boolean isDocIsPersGty() {
        if (this.getDocId().trim().equals(ID_PERSONAL_GUARANTY)) {
            return true;
        }
        return false;
    }

    public boolean isDocIsTaxExemptCert() {
        if (this.getDocId().trim().equals(ID_TAX_EXEMPT_CERT)) {
            return true;
        }
        return false;
    }

    public boolean isDocIsFs() {
        if (this.getDocId().trim().equals(ID_FS)) {
            return true;
        }
        return false;
    }

    public boolean isSubmittedDoc() {
        if (this.getStatus().trim().equals(MatrixConstants.STATUS_ACTIVE)) {
            return true;
        }
        return false;
    }
}
