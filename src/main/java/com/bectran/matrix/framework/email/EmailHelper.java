package com.bectran.matrix.framework.email;

import java.util.Map;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.supplier.beans.CompanyInfoBaseBean;
import com.bectran.b2b.supplier.beans.GroupAccountBean;
import com.bectran.b2b.supplier.beans.SupplierCompanyBean;
import com.bectran.b2b.supplier.beans.SupplierUserBean;
import com.bectran.matrix.framework.exception.CommunicationFailureException;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.framework.exception.ResourceLoadException;

/**
 * @author Louis Ifeguni Sep 18, 2006: 4:39:59 PM
 */
public class EmailHelper {
    /**
     * @param toEmail
     * @param title
     * @param values
     * @param emailTemplate
     * @throws ResourceLoadException
     * @throws CommunicationFailureException
     * @throws DataAccessException
     * @throws CommunicationFailureException
     */
    public static EmailMsgBean emailOne(String toEmail, String title,
                                        Map values, String emailTemplate,
                                        String fromEmail, String senderName,
                                        String emailCategory)
            throws ResourceLoadException, DataAccessException,
            CommunicationFailureException {
        //
        EmailMsgBean emailBean = new EmailMsgBean();
        emailBean.setMessageType(MatrixConstants.MSG_TYPE_ONE);
        emailBean.setToAddress(toEmail);
        emailBean.setMailTitle(title);
        emailBean.setFromAddress(fromEmail);
        emailBean.setEmailCategory(emailCategory);
        emailBean.setSenderName(senderName);
        //
        String mailBody = "";
        //
        mailBody = EmailMessageBuilder.reconstrcutMessageBody(emailTemplate,
                values);
        emailBean.setMailBody(mailBody);
        //
        emailBean.setToAddressArray(
                EmailMessageBuilder.buildSingleAddressArray(toEmail));
        // finally send mail - STORE EMAIL
        // THE Email Resender, sends e-mail later
        // in a batch mode
        emailBean.setSendStatus(MatrixConstants.STATUS_FAILED);// fake failed
                                                               // mail - to
                                                               // activate
                                                               // re-send
        emailBean.setEmailResendProcess(
                MatrixConstants.EMAIL_RESEND_PROCESS_MODE_AUTO);
        EmailMsgDAO.storeMessage(emailBean);
        //
        return emailBean;
    }

    public static EmailMsgBean emailOneWithBody(String toEmail, String title,
                                                String mailBody,
                                                String fromEmail,
                                                String senderName,
                                                String emailCategory)
            throws DataAccessException, CommunicationFailureException {
        //
        EmailMsgBean emailBean = new EmailMsgBean();
        emailBean.setMessageType(MatrixConstants.MSG_TYPE_ONE);
        emailBean.setToAddress(toEmail);
        emailBean.setMailTitle(title);
        emailBean.setFromAddress(fromEmail);
        emailBean.setEmailCategory(emailCategory);
        emailBean.setSenderName(senderName);
        emailBean.setMailBody(mailBody);
        //
        emailBean.setToAddressArray(
                EmailMessageBuilder.buildSingleAddressArray(toEmail));
        // finally send mail - STORE EMAIL
        // THE Email Resender, sends e-mail later
        // in a batch mode
        emailBean.setSendStatus(MatrixConstants.STATUS_FAILED);// fake failed
                                                               // mail - to
                                                               // activate
                                                               // re-send
        emailBean.setEmailResendProcess(
                MatrixConstants.EMAIL_RESEND_PROCESS_MODE_AUTO);
        EmailMsgDAO.storeMessage(emailBean);
        //
        return emailBean;
    }

    public static EmailMsgBean prepareEmailOne(String toEmail, String title,
                                               Map values, String emailTemplate,
                                               String fromEmail,
                                               String senderName,
                                               String emailCategory)
            throws ResourceLoadException, CommunicationFailureException {
        //
        EmailMsgBean emailBean = new EmailMsgBean();
        emailBean.setMessageType(MatrixConstants.MSG_TYPE_ONE);
        emailBean.setToAddress(toEmail);
        emailBean.setMailTitle(title);
        emailBean.setFromAddress(fromEmail);
        emailBean.setEmailCategory(emailCategory);
        emailBean.setSenderName(senderName);
        //
        String mailBody = "";
        //
        mailBody = EmailMessageBuilder.reconstrcutMessageBody(emailTemplate,
                values);
        emailBean.setMailBody(mailBody);
        //
        emailBean.setToAddressArray(
                EmailMessageBuilder.buildSingleAddressArray(toEmail));
        // finally send mail - STORE EMAIL
        // THE Email Resender, sends e-mail later
        // in a batch mode
        emailBean.setSendStatus(MatrixConstants.STATUS_FAILED);// fake failed
                                                               // mail - to
                                                               // activate
                                                               // re-send
        emailBean.setEmailResendProcess(
                MatrixConstants.EMAIL_RESEND_PROCESS_MODE_AUTO);
        //
        return emailBean;
    }

    public static void emailManyCopyOne(Address[] toAddr, String copyEmail,
                                        String title, Map values,
                                        String emailTemplate, String fromEmail,
                                        String senderName, String emailCategory)
            throws ResourceLoadException, DataAccessException,
            CommunicationFailureException {
        //
        EmailMsgBean emailBean = new EmailMsgBean();
        emailBean.setMessageType(MatrixConstants.MSG_TYPE_MANY_COPY_ONE);
        emailBean.setCopyAddress(copyEmail);
        emailBean.setEmailCategory(emailCategory);
        emailBean.setMailTitle(title);
        emailBean.setFromAddress(fromEmail);
        emailBean.setSenderName(senderName);
        //
        String mailBody = "";
        //
        mailBody = EmailMessageBuilder.reconstrcutMessageBody(emailTemplate,
                values);
        emailBean.setMailBody(mailBody);
        emailBean.setToAddressArray(toAddr);
        //
        emailBean.setCopyAddressArray(
                EmailMessageBuilder.buildSingleAddressArray(copyEmail));
        // finally send mail - STORE EMAIL
        // THE Email Resender, sends e-mail later
        // in a batch mode
        // convert to address array to a string of emmail addaresses
        // emailBean.setToAddressList(computeAddressList(emailBean.getToAddressArray()));
        emailBean.setSendStatus(MatrixConstants.STATUS_FAILED);
        emailBean.setEmailResendProcess(
                MatrixConstants.EMAIL_RESEND_PROCESS_MODE_AUTO);
        EmailMsgDAO.storeMessage(emailBean);
    }

    public static EmailMsgBean prepEmailManyCopyOne(Address[] toAddr,
                                                    String copyEmail,
                                                    String title, Map values,
                                                    String emailTemplate,
                                                    String fromEmail,
                                                    String senderName,
                                                    String emailCategory)
            throws ResourceLoadException, DataAccessException,
            CommunicationFailureException {
        //
        EmailMsgBean emailBean = new EmailMsgBean();
        emailBean.setMessageType(MatrixConstants.MSG_TYPE_MANY_COPY_ONE);
        emailBean.setCopyAddress(copyEmail);
        emailBean.setEmailCategory(emailCategory);
        emailBean.setMailTitle(title);
        emailBean.setFromAddress(fromEmail);
        emailBean.setSenderName(senderName);
        //
        String mailBody = "";
        //
        mailBody = EmailMessageBuilder.reconstrcutMessageBody(emailTemplate,
                values);
        emailBean.setMailBody(mailBody);
        emailBean.setToAddressArray(toAddr);
        //
        emailBean.setCopyAddressArray(
                EmailMessageBuilder.buildSingleAddressArray(copyEmail));
        // convert to address array to a string of emmail addaresses
        emailBean.setToAddressList(
                computeAddressList(emailBean.getToAddressArray()));
        emailBean.setSendStatus(MatrixConstants.STATUS_FAILED);
        emailBean.setEmailResendProcess(
                MatrixConstants.EMAIL_RESEND_PROCESS_MODE_AUTO);
        //
        return emailBean;
    }

    public static void emailMany(Address[] toAddr, String title, Map values,
                                 String emailTemplate, String fromEmail,
                                 String senderName, String emailCategory)
            throws ResourceLoadException, DataAccessException,
            CommunicationFailureException {
        //
        EmailMsgBean emailBean = new EmailMsgBean();
        emailBean.setMessageType(MatrixConstants.MSG_TYPE_MANY);
        // emailBean.setCopyAddress(copyEmail);
        emailBean.setEmailCategory(emailCategory);
        emailBean.setMailTitle(title);
        emailBean.setFromAddress(fromEmail);
        emailBean.setSenderName(senderName);
        //
        String mailBody = "";
        mailBody = EmailMessageBuilder.reconstrcutMessageBody(emailTemplate,
                values);
        emailBean.setMailBody(mailBody);
        emailBean.setToAddressArray(toAddr);
        //
        // emailBean.setCopyAddressArray(EmailMessageBuilder.buildSingleAddressArray(copyEmail));
        // finally send mail - STORE EMAIL
        // THE Email Resender, sends e-mail later
        // in a batch mode
        // convert to address array to a string of emmail addaresses
        // emailBean.setToAddressList(computeAddressList(emailBean.getToAddressArray()));
        emailBean.setSendStatus(MatrixConstants.STATUS_FAILED);
        emailBean.setEmailResendProcess(
                MatrixConstants.EMAIL_RESEND_PROCESS_MODE_AUTO);
        EmailMsgDAO.storeMessage(emailBean);
    }

    /**
     * @param toAddr
     * @param copyAddr
     * @param title
     * @param values
     * @param emailTemplate
     * @param fromEmail
     * @param senderName
     * @param emailCategory
     * @throws ResourceLoadException
     * @throws DataAccessException
     * @throws CommunicationFailureException
     */
    public static void emailManyCopyMany(Address[] toAddr, Address[] copyAddr,
                                         String title, Map values,
                                         String emailTemplate, String fromEmail,
                                         String senderName,
                                         String emailCategory)
            throws ResourceLoadException, DataAccessException,
            CommunicationFailureException {
        //
        EmailMsgBean emailBean = new EmailMsgBean();
        emailBean.setMessageType(MatrixConstants.MSG_TYPE_MANY_COPY_MANY);
        // emailBean.setCopyAddress(copyEmail);
        emailBean.setEmailCategory(emailCategory);
        emailBean.setMailTitle(title);
        emailBean.setFromAddress(fromEmail);
        emailBean.setSenderName(senderName);
        //
        String mailBody = "";
        mailBody = EmailMessageBuilder.reconstrcutMessageBody(emailTemplate,
                values);
        emailBean.setMailBody(mailBody);
        emailBean.setToAddressArray(toAddr);
        //
        emailBean.setCopyAddressArray(copyAddr);
        // finally send mail - STORE EMAIL
        // THE Email Resender, sends e-mail later
        // in a batch mode
        // convert to address array to a string of emmail addaresses
        // emailBean.setToAddressList(computeAddressList(emailBean.getToAddressArray()));
        // emailBean.setCopyAddressList(computeAddressList(emailBean.getCopyAddressArray()));
        emailBean.setSendStatus(MatrixConstants.STATUS_FAILED);
        emailBean.setEmailResendProcess(
                MatrixConstants.EMAIL_RESEND_PROCESS_MODE_AUTO);
        EmailMsgDAO.storeMessage(emailBean);
    }

    public static String computeAddressList(Address[] toAddr) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < toAddr.length; i++) {
            InternetAddress addr = (InternetAddress) toAddr[i];
            buffer.append(addr.getAddress() + "#");
        }
        return buffer.toString();
    }

    public static Address[] buildAddressArrayFromStoredList(String storedList)
            throws Exception {
        //
        String[] array = storedList.split("#");
        Address[] addr = new Address[array.length];
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            addr[i] = new InternetAddress(array[i]);
        }
        return addr;
    }

    /**
     * SEND PREPARED MAIL
     * 
     * @param emailBean
     * @throws CommunicationFailureException
     */
    public static void sendMail(EmailMsgBean emailBean)
            throws CommunicationFailureException {
        MailSender.sendMail(emailBean);
    }

    public static EmailMsgBean emailOneSubscription(String toEmail,
                                                    String title,
                                                    String fromEmail,
                                                    String senderName,
                                                    String emailCategory,
                                                    String mailBody)
            throws DataAccessException, CommunicationFailureException {
        //
        EmailMsgBean emailBean = new EmailMsgBean();
        emailBean.setMessageType(MatrixConstants.MSG_TYPE_ONE);
        emailBean.setToAddress(toEmail);
        emailBean.setMailTitle(title);
        emailBean.setFromAddress(fromEmail);
        emailBean.setEmailCategory(emailCategory);
        emailBean.setSenderName(senderName);
        emailBean.setMailBody(mailBody);
        //
        emailBean.setToAddressArray(
                EmailMessageBuilder.buildSingleAddressArray(toEmail));
        // finally send mail - STORE EMAIL
        // THE Email Resender, sends e-mail later
        // in a batch mode
        emailBean.setSendStatus(MatrixConstants.STATUS_FAILED);// fake failed
                                                               // mail - to
                                                               // activate
                                                               // re-send
        emailBean.setEmailResendProcess(
                MatrixConstants.EMAIL_RESEND_PROCESS_MODE_AUTO);
        EmailMsgDAO.storeMessage(emailBean);
        //
        return emailBean;
    }

    public static String supplierEmailSignature(SupplierCompanyBean supplier,
                                                SupplierUserBean user) {
        StringBuffer bf = new StringBuffer();
        bf.append("<b>Contact Person:</b><br>");
        bf.append(user.getUserName().trim() + " (" + user.getPhone().trim()
                + ")<br>");
        bf.append("Credit Department<br>");
        bf.append(supplier.getCorpName().trim());
        //
        return bf.toString();
    }

    public static String supplierEmailSignature(CompanyInfoBaseBean supplier,
                                                GroupAccountBean groupBean)
            throws DataAccessException {
        StringBuffer bf = new StringBuffer();
        bf.append("<b>Contact Person:</b><br>");
        SupplierUserBean user = groupBean.getGroupContact();
        bf.append(user.getUserName().trim() + " (" + user.getPhone().trim()
                + ")<br>");
        bf.append("Credit Department<br>");
        bf.append("<i>" + groupBean.getBusinessGroupName().trim() + "</i><br>");
        bf.append(supplier.getCorpName().trim());
        //
        return bf.toString();
    }
}
