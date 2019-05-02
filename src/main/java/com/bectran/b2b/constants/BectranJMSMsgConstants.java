/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.b2b.constants;

/**
 * @author Shanmu
 * @date Aug 6, 2014 2:59:10 PM
 */
public interface BectranJMSMsgConstants {
    // --------------------------------------------------------------- Constants
    // Queue Names
    String SIGNUP_QUEUE = "BECMSG.JMS.SIGNUP";
    String CREDIT_REFERENCE_QUEUE = "BECMSG.JMS.CREDIT.REFERENCE";
    String CREDIT_REQUEST_REVIEW_QUEUE = "BECMSG.JMS.CREDIT.REQ.REVIEW";
    String ONLINE_CREDIT_APP_QUEUE = "BECMSG.JMS.ONLINE.CREDIT.APP";
    String DASHBOARD_QUEUE = "BECMSG.JMS.DASHBOARD";
    String ACCOUNT_REVIEW_QUEUE = "BECMSG.JMS.ACCOUNT.REVIEW";
    String IDP_XML_MESSAGE_QUEUE = "BECMSG.IDP.XML.MESSAGE";
    String IDP_JSON_MESSAGE_QUEUE = "BECMSG.IDP.JSON.MESSAGE";
    // Message Sender
    String SIGNUP_MSG_SENDER = "signupMsgSender";
    String CREDIT_REFERENCES_MSG_SENDER = "referencesMsgSender";
    String CREDIT_REQUEST_REVIEW_MSG_SENDER = "creditRequestReviewMsgSender";
    String ONLINE_CREDIT_APP_MSG_SENDER = "onlineCreditAppMsgSender";
    String DASHBOARD_MSG_SENDER = "dashboardMsgSender";
    String ACCOUNT_REVIEW_MSG_SENDER = "accountReviewMsgSender";
    String IDP_XML_MESSAGE_SENDER = "idpXMLMessageSender";
    String IDP_JSON_MESSAGE_SENDER = "idpJSONMessageSender";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
