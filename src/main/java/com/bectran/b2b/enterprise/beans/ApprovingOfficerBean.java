package com.bectran.b2b.enterprise.beans;

import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.supplier.beans.SupplierUserBean;

/**
 * @author LOUIS IFEGUNI
 */
public class ApprovingOfficerBean {
    private Long id;
    private Long headerId;
    private String userId;
    private Date dateSigned;
    private byte[] signatureImage; // signature
    //
    private String gkey = "";
    private String action = MatrixConstants.ANSWER_NO; // approved or declined
    private String actionStatus = "";
    private Date dateCreated;
    private String approvalComment = "None.";
    //
    //

    public String getDisplaySigImage() {
        String imageServletUrl = "<img  src=\"/b2bcredit/CrApprovalSignatureServlet?SIG_MENU_ACTION=";
        imageServletUrl = imageServletUrl + this.getId() + "\"" + " >";
        return imageServletUrl;
    }

    //
    private SupplierUserBean userBean;

    public ApprovingOfficerBean() {
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDateSigned() {
        return (Date) (dateSigned == null ? null : dateSigned.clone());
    }

    public void setDateSigned(Date dateSigned) {
        this.dateSigned = (Date) (dateSigned == null ? null : dateSigned.clone());
    }

    public byte[] getSignatureImage() {
        return signatureImage == null ? null : signatureImage.clone();
    }

    public void setSignatureImage(byte[] signatureImage) {
        this.signatureImage = signatureImage == null ? null : signatureImage.clone();
    }

    public String getGkey() {
        return gkey;
    }

    public void setGkey(String gkey) {
        this.gkey = gkey;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(String actionStatus) {
        this.actionStatus = actionStatus;
    }

    public Date getDateCreated() {
        return (Date) (dateCreated == null ? null : dateCreated.clone());
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = (Date) (dateCreated == null ? null : dateCreated.clone());
    }

    public SupplierUserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(SupplierUserBean userBean) {
        this.userBean = userBean;
    }

    public boolean isApproved() {
        return this.getAction().trim().equals(MatrixConstants.ANSWER_YES) ? true
                : false;
    }

    public String getApprovalComment() {
        return approvalComment;
    }

    public void setApprovalComment(String approvalComment) {
        this.approvalComment = approvalComment;
    }
}
