package com.bectran.b2b.crol.constants;

/**
 * @author LOUIS IFEGUNI Jun 28, 2006:6:37:27 AM
 */
public class CrolConstants {
    /**
     * REQUEST SOURCE IS EITHER CROL OR CROLWS
     */
    public static final String REQUEST_SOURCE_CROL = "CROL";
    public static final String REQUEST_SOURCE_CROL_WEBSERVICE = "CROLWS";
    public static final String REQUEST_SOURCE_CROL_B2B = "CROLB2B";
    //
    public static final String PROPERTY_FILE_NAME = "tradenet";
    //
    public static final String REQUEST_ORIGINATOR_CUSTOMER = "CUSTOMER";
    public static final String REQUEST_ORIGINATOR_CREDITOR = "CREDITOR";
    public static final String REFERENCE_TYPE_BANK = "BANKREF";;
    public static final String REFERENCE_TYPE_TRADE = "TRADEREF";
    public static final String STATUS_REGISTERED = "REGISTERED";
    public static final String STATUS_NOT_REGISTERED = "UNREGISTERED";
    public static final String NETWORK_STATUS_IN = "IN-NET";
    public static final String NETWORK_STATUS_OUT = "OUT-NET";
    // public static final String USER_TYPE_ADMINISTRATOR = "ADMINISTRATOR";
    public static final String USER_TYPE_OUT_OF_NETWORK = "OUT-OF-NETWORK";
    public static final String USER_TYPE_CORPUSER = "CORPUSER";
    public static final String ACCT_STATUS_ACTIVE = "ACTIVE";
    public static final String ACCT_STATUS_INACTIVE = "IN-ACTIVE";
    public static final String OBJECT_ID = "OBJECT_ID";
    public static final String REQUEST_STATUS_INPROCESS = "IN-PROCESS";
    public static final String REQUEST_STATUS_PROCESSED = "PROCESSED";
    public static final String REQUEST_STATUS_ACTION_COMPLETED = "COMPLETED";
    public static final String REQUEST_STATUS_ACTION_DECLINED = "DECLINED";
    public static final String INBOX_SUBJECT_REQUEST = "REQUEST";
    public static final String INBOX_SUBJECT_REFERENCE = "REFERENCE";
    public static final String INBOX_SUBJECT_REQUEST_ID = "REQ";
    public static final String INBOX_SUBJECT_REFERENCE_ID = "CREF";
    public static final String NEW_ACCOUNT = "NEWACCOUNT";
    public static final String ESTABLISHED_CUSTOMER = "ESTABCUSTOMER"; // same
                                                                       // as
                                                                       // increase
                                                                       // on
                                                                       // existing
                                                                       // account
    public static final String UPDATING_FILE = "UPDATEFILE";
    //
    public static final String REASON_FOR_REQUEST_NEW_ACCOUNT = NEW_ACCOUNT;
    public static final String REASON_FOR_REQUEST_UPDATE_FILE = UPDATING_FILE;
    public static final String REASON_FOR_REQUEST_INDO_GROUP_INQUIRY = "INDOGROUPINQUIRY";
    //
    public static final int REMINDER_LIMIT = 3; // for request re-sends changed
                                                // from 5 to 3 on
                                                // 11-19-2010(Louis)
    //
    public static final String YES = "YES";
    public static final String NO = "NO";
    //
    public static final String FEEDBACK = "FEEDBACK";
    public static final String SUPPORT = "SUPPORT";
    public static final String MSG_TYPE_ONE = "ONE";
    public static final String MSG_TYPE_MANY_COPY_ONE = "MANYCOPYONE";
    //
    public static final String MAIL_HOST = "mail.host";
    public static final String MAIL_SSL_USER_ID = "mail.ssl.userid";
    public static final String MAIL_SSL_PASSWORD = "mail.ssl.password";
    public static final String MAIL_SSL_PROTOCOL_FLAG = "mail.ssl.protocol";
    public static final String STATUS_SUCCESS = "SUCCESS";
    public static final String STATUS_FAILED = "FAILED";
    public static final int EMAIL_RESEND_MAX_COUNT = 50;
    public static final String EMAIL_RESEND_PROCESS_MODE_AUTO = "AUTO";
    public static final String EMAIL_RESEND_PROCESS_MODE_MANUAL = "MANUAL";
    //
    /**
     * PROPERTIES FILE CONSTANTS
     */
    public static final String ACCOUNT_FROM_EMAIL = "account.email.address";
    public static final String REFERENCE_FROM_EMAIL = "reference.email.address";
    public static final String SUPPORT_FROM_EMAIL = "support.email.address";
    public static final String FEEDBACK_FROM_EMAIL = "feedback.email.address";
    public static final String PROD_OR_TEST = "prod.or.test";
    /**
     * E_MAIL MESSAGE CATEGORY
     */
    public static final String EMAIL_MESSAGE_CATEGORY_SIGNUP = "SIGNUP";
    public static final String EMAIL_MESSAGE_CATEGORY_ONETSIGNUP = "ONETSIGNUP";
    public static final String EMAIL_MESSAGE_CATEGORY_ADDUSER = "ADDUSER";
    public static final String EMAIL_MESSAGE_CATEGORY_ONETREQUEST = "ONETREQUEST";
    public static final String EMAIL_MESSAGE_CATEGORY_INNETREQUEST = "INNETREQUEST";
    public static final String EMAIL_MESSAGE_CATEGORY_PASSWORDCHANGE = "PASSWORDCHANGE";
    public static final String EMAIL_MESSAGE_CATEGORY_FEEDBACKORSUPPORT = "FEEDBACKORSUPPORT";
    public static final String EMAIL_MESSAGE_CATEGORY_SIGNUP_REQUEST = "SIGNUPREQUEST";
    public static final String EMAIL_MESSAGE_CATEGORY_CREDIT_REFERENCE = "CREDITREFERENCE";
    public static final String EMAIL_MESSAGE_CATEGORY_ONETCREDIT_REFERENCE = "ONETCREDITREFERENCE";
    public static final String EMAIL_MESSAGE_CATEGORY_SUBSCRIPTION = "SUBSCRIPTION";
    public static final String REQUEST_MODE_MANUAL = "MANUAL";
    public static final String REQUEST_MODE_REGULAR = "REGULAR";
    public static final String SYSTEM_USER_ID = "SYSTEM_USER@";
    public static final String SYSTEM_COMPANY_ID = "**SYSTEMCOY**";
    /**
     * AUTO - EMAIL ADDRESS NAME
     */
    public static final String AUTO_EMAIL_NAME = "auto.email.name";
    //
    public static final int PASSWORD_GENERATION_LENGTH = 8;
    /**
     * XML DOCUMENTS RELATIVE FILE FOLDER
     */
    public static final String XMLDOC_RELATIVE_FOLDER_PATH = "xmldoc";
    /**
     * These are the names of the xml documents in the xml documents folder.
     * Names must end in .xml and must always be the same as the names of the
     * physical files
     */
    public static final String JDBC_DRIVERS = "drivers.xml";
    //
    public static final String ECACHE_CONFIG = "ehcache.xml";
    public static final String SECTORS = "sec.xml";
    public static final String CURRENCY = "currency.xml";
    public static final String SUBSCRIPTION = "subscription.xml";
    public static final String INDUSTRIES = "secind.xml";
    public static final String COUNTRIES = "country.xml";
    public static final String ANSWER_MAP_TRADE = "answer-map-trade.xml";
    public static final String ANSWER_MAP_BANK = "answer-map-bank.xml";
    public static final String SCORE_EXPLANATION_REF = "score-int-ref.xml";
    public static final String SCORE_EXPLANATION_ACCT = "score-int-acct.xml";
    public static final String AVG_ANSWER_EXPL_BANK = "avg-answer-expln-bank.xml";
    public static final String AVG_ANSWER_EXPL_TRADE = "avg-answer-expln-trade.xml";
    public static final String SCORE_AT_REFERENCE_LEVEL = "SCORE_AT_REFERENCE_LEVEL";
    public static final String SCORE_AT_ACCOUNT_LEVEL = "SCORE_AT_ACCOUNT_LEVEL";
    /**
     * WEB CONTENT RESOURCE LOCATION ROOT PATH -- ..../WebContent/
     */
    public static final String WEB_CONTENT_FILE_PATH = "tredenet.globalcomm.webcontent.file.path";
    /**
     * LOG4J PROPERTY FILE NAME
     */
    public static final String LOG4J_PROPERTY_FILE_NAME = "log4j.properties";
    /**
     * company size categories
     * 
     * @return
     */
    public static final String SMALL_SCALE = "SMALL";
    public static final String MEDIUM_SCALE = "MEDIUM";
    public static final String LARGE_SCALE = "LARGE";
    public static final int ANALYTICS_USAGE_LEVEL_0 = 0;
    public static final int ANALYTICS_USAGE_LEVEL_1 = 1;
    public static final int ANALYTICS_USAGE_LEVEL_2 = 2;
    public static final int ANALYTICS_LEVEL_REFERENCE = 1;
    public static final int ANALYTICS_LEVEL_ACCOUNT = 2;
    public static final String RATING_PREFIX_SMALL = "S";
    public static final String RATING_PREFIX_MEDIUM = "M";
    public static final String RATING_PREFIX_LARGE = "L";
    //
    public static final String UNSUBSCRIBE_FLAG = "U";
    //
    public static final String CREF_RECEIPT_BATCH = "BATCH";
    public static final String CREF_RECEIPT_REAL_TIME = "REAL-TIME";
    //
    public static final String PAYMENT_TERM_COD = "COD";
}
