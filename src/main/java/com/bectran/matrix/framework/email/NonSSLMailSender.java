package com.bectran.matrix.framework.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.matrix.framework.AppConfig;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.CommunicationFailureException;

/**
 * @author LOUIS IFEGUNI Sep 4, 20072:34:55 PM
 */
public class NonSSLMailSender {
    public static void sendMail(EmailMsgBean emailBean)
            throws CommunicationFailureException {
        //
        // Get system properties
        Properties props = System.getProperties();
        // Get session
        Session session = Session.getInstance(props, null);
        // Define message
        MimeMessage message = new MimeMessage(session);
        try {
            // GET MAIL HOST FROM FILE
            String mailhost = AppConfig.getValue(MatrixConstants.MAIL_HOST);
            // Setup mail server
            props.put("mail.smtp.host", mailhost);
            // props.put("mail.smtp.port", Integer.toString(465));
            // props.put("mail.smtps.auth", "true");
            message.setFrom(new InternetAddress(emailBean.getFromAddress(),
                    emailBean.getSenderName()));
            message.addRecipients(Message.RecipientType.TO,
                    emailBean.getToAddressArray());
            if (emailBean.getCopyAddressArray() != null
                    && emailBean.getCopyAddressArray().length > 0) {
                message.addRecipients(Message.RecipientType.CC,
                        emailBean.getCopyAddressArray());
                //
            }
            message.setSubject(emailBean.getMailTitle());
            message.setSentDate(new Date());
            message.setContent(emailBean.getMailBody(), "text/html");
            // Send message
            Transport.send(message);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            AppLogger.log(AppLogger.ERROR, "Email Communication Failed :", ex);
            throw new CommunicationFailureException();
        }
    }
}
