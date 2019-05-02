/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.matrix.framework.email;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;

import com.bectran.b2b.constants.BectranJMSMsgConstants;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.CommunicationFailureException;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.WebSpringContextUtil;

/**
 * @author Shanmu
 * @date Aug 6, 2014 2:50:27 PM
 */
public class JMSEmailHelper {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    private static Map<String, JMSMsgSender> senders = new HashMap<String, JMSMsgSender>();
    // ----------------------------------------------------- Static Initializers
    static {
        senders.put(BectranJMSMsgConstants.ACCOUNT_REVIEW_QUEUE,
                WebSpringContextUtil.getJMSMsgSender(
                        BectranJMSMsgConstants.ACCOUNT_REVIEW_MSG_SENDER));
    }

    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>JMSEmailHelper</code>
     */
    private JMSEmailHelper() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    /**
     * @param toEmail
     * @param title
     * @param mailBody
     * @param fromEmail
     * @param senderName
     * @param emailCategory
     * @return
     * @throws DataAccessException
     * @throws CommunicationFailureException
     */
    public static EmailMsgBean emailOneWithBody(String toEmail, String title,
                                                String mailBody,
                                                String fromEmail,
                                                String senderName,
                                                String emailCategory,
                                                String queueName)
            throws DataAccessException, CommunicationFailureException {
        EmailMsgBean emailBean = new EmailMsgBean();
        emailBean.setMessageType(MatrixConstants.MSG_TYPE_ONE);
        emailBean.setToAddress(toEmail);
        emailBean.setMailTitle(title);
        emailBean.setFromAddress(fromEmail);
        emailBean.setEmailCategory(emailCategory);
        emailBean.setSenderName(senderName);
        emailBean.setMailBody(mailBody);
        emailBean.setToAddressArray(
                EmailMessageBuilder.buildSingleAddressArray(toEmail));
        emailBean.setSendStatus(MatrixConstants.STATUS_FAILED);
        emailBean.setEmailResendProcess(
                MatrixConstants.EMAIL_RESEND_PROCESS_MODE_AUTO);
        try {
            sendMsg(queueName, emailBean);
        }
        catch (JMSException e) {
            e.printStackTrace();
        }
        //
        return emailBean;
    }

    // ----------------------------------------------------------- Inner Classes
    /**
     * @param signupMsgSender
     * @param emailBean
     */
    public static void sendMsg(String queueName, EmailMsgBean emailBean)
            throws JMSException {
        if (senders.containsKey(queueName)) {
            JMSMsgSender jmsMsgSender = senders.get(queueName);
            jmsMsgSender.sendMessage(emailBean);
        }
        else {
            AppLogger.log(AppLogger.INFO, " No queue found in the map ");
        }
    }
}
