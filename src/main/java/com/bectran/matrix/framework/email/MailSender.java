package com.bectran.matrix.framework.email;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;

import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.CommunicationFailureException;

/**
 * @author LOUIS IFEGUNI Jun 29, 2006:10:20:42 PM
 */
public class MailSender {
    public static void sendMail(EmailMsgBean emailBean)
            throws CommunicationFailureException {
        //
        try {
            // String mailProtocol =
            // AppConfig.getValue(MatrixConstants.MAIL_SSL_PROTOCOL_FLAG);
            // if(mailProtocol.trim().equalsIgnoreCase("YES")){
            // SSLMailSender.sendMail(emailBean);
            // }else{
            NonSSLMailSender.sendMail(emailBean);
            // }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            AppLogger.log(AppLogger.ERROR, "Email Communication Failed :", ex);
            throw new CommunicationFailureException();
        }
    }

    public static void main(String[] args) throws Exception {
        EmailMsgBean info = new EmailMsgBean();
        info.setFromAddress("Account2@creditreferenceonline.com");
        Address[] addr = new Address[1];
        addr[0] = new InternetAddress("lifeguni@gmail.com");
        // addr[0] = new InternetAddress("lifeguni@hotmail.com");
        info.setToAddressArray(addr);
        info.setMailTitle("....sbc-yahoo-test....");
        info.setMailBody("...you are the best .....");
        // info.setSenderName("FROM LOUIS");
        sendMail(info);
        System.out.println("-mail sent----");
    }
}
