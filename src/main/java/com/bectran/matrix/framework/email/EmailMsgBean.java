package com.bectran.matrix.framework.email;

import java.io.Serializable;

import javax.mail.Address;

/**
 * @author LOUIS IFEGUNI Created on Jan 18, 2005
 */
public class EmailMsgBean implements Serializable {
    private static final long serialVersionUID = -1L;
    private String emailResendProcess = "";
    private String emailCategory = "";
    //
    private String fromAddress = "";
    private String copyAddress = "";
    private String senderName = "";
    private String toAddressList = "";
    private String copyAddressList = "";
    // private String storedAddressList="";
    private String toAddress = "";
    private String mailTitle = "";
    private String mailBody = "";
    private String sendStatus = "";
    private String messageType = "";
    private int trialCount;
    private Address[] toAddressArray = null;
    private Address[] copyAddressArray = null;
    private Long id;

    /**
     * DEFAULT CONSTRUCTOR
     */
    public EmailMsgBean() {
    }

    /**
     * @return
     */
    public String getFromAddress() {
        return fromAddress;
    }

    /**
     * @return
     */
    public String getMailBody() {
        return mailBody;
    }

    /**
     * @return
     */
    public String getMailTitle() {
        return mailTitle;
    }

    /**
     * @param string
     */
    public void setFromAddress(String string) {
        fromAddress = string;
    }

    /**
     * @param string
     */
    public void setMailBody(String string) {
        mailBody = string;
    }

    /**
     * @param string
     */
    public void setMailTitle(String string) {
        mailTitle = string;
    }

    /**
     * @return
     */
    public Address[] getToAddressArray() {
        return toAddressArray == null ? null : toAddressArray.clone();
    }

    /**
     * @param addresses
     */
    public void setToAddressArray(Address[] addresses) {
        toAddressArray = toAddressArray == null ? null : toAddressArray.clone();
    }

    /**
     * @return
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * @param string
     */
    public void setSenderName(String string) {
        senderName = string;
    }

    /**
     * @return Returns the copyAddressArray.
     */
    public Address[] getCopyAddressArray() {
        return copyAddressArray == null ? null : copyAddressArray.clone();
    }

    /**
     * @param copyAddressArray
     *            The copyAddressArray to set.
     */
    public void setCopyAddressArray(Address[] copyAddressArray) {
        this.copyAddressArray = copyAddressArray == null ? null : copyAddressArray.clone();
    }

    /**
     * @return Returns the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Returns the toAddressList.
     */
    public String getToAddressList() {
        return toAddressList;
    }

    /**
     * @param toAddressList
     *            The toAddressList to set.
     */
    public void setToAddressList(String storedAddressList) {
        this.toAddressList = storedAddressList;
    }

    /**
     * @return Returns the copyAddress.
     */
    public String getCopyAddress() {
        return copyAddress;
    }

    /**
     * @param copyAddress
     *            The copyAddress to set.
     */
    public void setCopyAddress(String copyAddress) {
        this.copyAddress = copyAddress;
    }

    /**
     * @return Returns the toAddress.
     */
    public String getToAddress() {
        return toAddress;
    }

    /**
     * @param toAddress
     *            The toAddress to set.
     */
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    /**
     * @return Returns the sendStatus.
     */
    public String getSendStatus() {
        return sendStatus;
    }

    /**
     * @param sendStatus
     *            The sendStatus to set.
     */
    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }

    /**
     * @return Returns the messageType.
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * @param messageType
     *            The messageType to set.
     */
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    /**
     * @return Returns the trialCount.
     */
    public int getTrialCount() {
        return trialCount;
    }

    /**
     * @param trialCount
     *            The trialCount to set.
     */
    public void setTrialCount(int trialCount) {
        this.trialCount = trialCount;
    }

    /**
     * @return Returns the emailResendProcess.
     */
    public String getEmailResendProcess() {
        return emailResendProcess;
    }

    /**
     * @param emailResendProcess
     *            The emailResendProcess to set.
     */
    public void setEmailResendProcess(String emailResendProcess) {
        this.emailResendProcess = emailResendProcess;
    }

    /**
     * @return Returns the emailCategory.
     */
    public String getEmailCategory() {
        return emailCategory;
    }

    /**
     * @param emailCategory
     *            The emailCategory to set.
     */
    public void setEmailCategory(String emailCategory) {
        this.emailCategory = emailCategory;
    }

    public String getCopyAddressList() {
        return copyAddressList;
    }

    public void setCopyAddressList(String copyAddressList) {
        this.copyAddressList = copyAddressList;
    }
}
