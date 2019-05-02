/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.idp;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.bectran.matrix.framework.AppConfig;
import com.bectran.matrix.framework.exception.ResourceLoadException;
import com.bectran.matrix.framework.idp.IDPMsgBean;
import com.bectran.matrix.utils.WebSpringContextUtil;

/**
 * @author Santhosh
 * @date May 21, 2016 14:15:43 PM
 */
public class IDPMsgSender {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String msgSenderName;
    private ActiveMQConnectionFactory connectionFactory = null;

    // ------------------------------------------------------------ Constructors
    /**
     * @param msgSenderName
     */
    public IDPMsgSender(String msgSenderName) {
        super();
        this.msgSenderName = msgSenderName;
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @param idpMsgBean
     * @throws Exception
     */
    public void sendMessage(final IDPMsgBean idpMsgBean) throws Exception {
        Session session = null;
        Connection connection = null;
        try {
            if (connectionFactory == null) {
                init();
            }
            // Create a Connection
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue(
                    WebSpringContextUtil.getQueueName(msgSenderName));
            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            // Create a messages
            ObjectMessage message = session.createObjectMessage(idpMsgBean);
            // Tell the producer to send the message
            producer.send(message);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    /**
     * @throws ResourceLoadException
     */
    private void init() throws ResourceLoadException {
        String brokerURL = AppConfig.getValue(AppConfig.ACTIVEMQ_BROKER_URL);
        String userName = AppConfig.getValue(AppConfig.ACTIVEMQ_USERNAME);
        String password = AppConfig.getValue(AppConfig.ACTIVEMQ_PASSWORD);
       
        // Create a ConnectionFactory
        connectionFactory = new ActiveMQConnectionFactory(brokerURL);
        connectionFactory.setUserName(userName);
        connectionFactory.setPassword(password);
    }
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
