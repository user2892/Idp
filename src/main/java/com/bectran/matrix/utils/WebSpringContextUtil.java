/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.matrix.utils;

import org.apache.commons.lang3.StringUtils;

import com.bectran.b2b.constants.BectranJMSMsgConstants;
import com.bectran.idp.IDPMsgSender;
import com.bectran.matrix.framework.email.JMSMsgSender;

/**
 * @author Shanmu
 * @date Jul 31, 2014 11:37:34 PM
 */
public class WebSpringContextUtil {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>WebSpringContextUtil</code>
     */
    private WebSpringContextUtil() {
        // Nothing
    }
    // ---------------------------------------------------------- Public Methods

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    /**
     * @return
     */
    public static JMSMsgSender getJMSMsgSender(String name) {
        JMSMsgSender jmsMsgSender = new JMSMsgSender(name);
        return jmsMsgSender;
    }

    /**
     * @param msgSenderName
     * @return
     */
    public static String getQueueName(String msgSenderName) {
        String queueName = "";
        if (StringUtils.equals(BectranJMSMsgConstants.IDP_XML_MESSAGE_SENDER,
                msgSenderName)) {
            queueName = BectranJMSMsgConstants.IDP_XML_MESSAGE_QUEUE;
        }
        else if (StringUtils.equals(
                BectranJMSMsgConstants.IDP_JSON_MESSAGE_SENDER,
                msgSenderName)) {
            queueName = BectranJMSMsgConstants.IDP_JSON_MESSAGE_QUEUE;
        }
        return queueName;
    }

    /**
     * @return
     */
    public static IDPMsgSender getIDPMsgSender(String name) {
        IDPMsgSender jmsIDPMsgSender = new IDPMsgSender(name);
        return jmsIDPMsgSender;
    }
    // ----------------------------------------------------------- Inner Classes
}
