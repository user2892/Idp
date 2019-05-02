package com.bectran.b2b.constants;

/**
 * @author Louis Ifeguni Oct 30, 2006: 3:38:10 PM
 */
public class MatrixConstants {
    public final static String FORMULA_SEPARATOR = "#";
    public final static String CURRENCY_USD = "USD";
    //
    public static final String DATA_TYPE_NUMERIC = "NUMERIC";
    public static final String DATA_TYPE_ALPHANUMERIC = "ALPHANUM";
    /**
     * INFO data type, used specifically to capture informational data from
     * third party credit bureau service providers
     */
    public static final String DATA_TYPE_INFO = "INFO";
    public static final String SHORT_NAME_PREFIX_TRADEREF = "T_";
    public static final String SHORT_NAME_PREFIX_BANKREF = "B_";
    public static final String SHORT_NAME_PREFIX_VALUESMETHOD = "V_";
    // constants for general answers
    public static final String ANSWER_YES = "YES";
    public static final String ANSWER_NO = "NO";
    public final static String NOT_APPLICABLE = "N/A";
    public final static String NO_NAME = "NONAME";
    public static final String OBJECT_ID = "OBJECT_ID";
    // model type can either a Financial Institution or Non-Financial
    // Institution
    public static final String FSMODEL_TYPE_FIN_INSTITUTE = "FIN_INST";
    public static final String FSMODEL_TYPE_NON_FIN_INSTITUTE = "NON_FIN_INST";
    //
    public static final String STATUS_APPROVED = "Approved";
    public static final String STATUS_DECLINED = "Declined";
    public static final String STATUS_CANCELLED = "Cancelled";
    public static final String STATUS_INPROGRESS = "InProgress";
    public static final String STATUS_SUBMITTED = "Submitted";
    public static final String STATUS_INPROCESS = "in-Process";
    public static final String STATUS_NOT_APPROVED = "NOT-APPROVED";
    public static final String STATUS_LOCKED = "LOCKED";
    //
    public static final String URL_FORWARD = "URLFORWARD";
    public static final int GENERATED_PWD_LENGTH = 8;
    // constants for financial statement rounding
    public static final String ROUNDING_ZERO = "0";
    public static final String ROUNDING_ONE = "1";
    public static final String ROUNDING_TWO = "2";
    public static final String ROUNDING_THREE = "3";
    public static final String ROUNDING_FOUR = "4";
    public static final String MSG_TYPE_ONE = "ONE";
    public static final String MSG_TYPE_MANY_COPY_ONE = "MANYCOPYONE";
    public static final String MSG_TYPE_MANY_COPY_MANY = "MANYCOPYMANY";
    public static final String MSG_TYPE_MANY = "MANYNOCOPY";
    //
    public static final String MAIL_HOST = "mail.host";
    public static final String MAIL_SSL_USER_ID = "mail.ssl.userid";
    public static final String MAIL_SSL_PASSWORD = "mail.ssl.password";
    public static final String MAIL_SSL_PROTOCOL_FLAG = "mail.ssl.protocol";
    public static final String STATUS_SUCCESS = "SUCCESS";
    public static final String STATUS_FAILED = "FAILED";
    public static final String STATUS_ACTIVE = "ACTIVE";
    public static final String STATUS_INACTIVE = "INACTIVE";
    public static final int EMAIL_RESEND_MAX_COUNT = 20;
    public static final String EMAIL_RESEND_PROCESS_MODE_AUTO = "AUTO";
    public static final String EMAIL_RESEND_PROCESS_MODE_MANUAL = "MANUAL";
    //
    public static final String AUTO = "AUTO";
    public static final String MANUAL = "MANUAL";
    public static final String BANK = "BANK";
    public static final String TRADE = "TRADE";
    public static final int DUNNING_MAX_NO = 5;
    public static final String DUNNING_HIST_STATUS_CURRENT = "CURRENT";
    public static final String DUNNING_HIST_STATUS_HIST = "HIST";
    public static final int DUNNING_LEVEL_PAYMENT_RECEIVED = 10;
    public static final int DUNNING_DEFAULT_DEADLINE_FOR_PAYMENT_DAYS = 30; // 30
                                                                            // DAYS
                                                                            // FROM
                                                                            // TODAY
                                                                            // DEADLINE
    public static final int DUNNING_DEFAULT_DAYS_INTERVAL_FOR_LETTERS = 15;
    public static final String TIMEOUT_PAGE_URL = "/faces/regis/login.jsp";
    public static final String EXT_TIMEOUT_PAGE_URL = "/faces/extpack/signup/expiredLogin.jsp";
    //
    public static final String APPROVAL_TYPE_CUSTOMER_REQUEST = "CUSTOMER_REQUEST";
    public static final String APPROVAL_TYPE_TERM_ADJUSTMENT = "TERM_ADJUSTMENT";
    public static final String APPROVAL_TYPE_IDM_AUTO = "IDM-AUTO";
    public static final String APPROVAL_TYPE_IDM_CREF = "IDM-CREF";
    public static final String APPROVAL_TYPE_IDM_3RDPARTY = "IDM-3RD_PARTY";
    public static final String APPROVAL_TYPE_ALL = "ALL";
    public static final String REFERENCE_CALL_STATUS_NOT_CALLED = "READY-FOR-CALL";
    public static final String REFERENCE_CALL_STATUS_CALLED = "CALLED";
    public static final String REFERENCE_CALL_STATUS_REMINDER = "REMINDER";
    public static final String REFERENCE_CALL_STATUS_REMINDER_LIMIT = "REMINDER-LIMIT";
    public static final String REFERENCE_CALL_STATUS_CANCELED = "CANCELED";
    public static final String REFERENCE_CALL_STATUS_RECEIVED = "RECEIVED";
    public static final String REFERENCE_CALL_STATUS_DECLINED = "DECLINED";
    public static final int CROL_DEFAULT_REMINDER_LIMIT = 5;
    public static final int CROL_DEFAULT_REMINDER_INTERVAL = 2;
    public static final int CROL_DEFAULT_REFERENCE_CHECK_INTERVAL = 20;
    // user class - external or internal
    public static final String USER_CLASS_EXTERNAL = "EXU";
    public static final String USER_CLASS_INTERNAL = "INU";
    // credit request classification
    public static final String CREDIT_REQUEST_CREDITLIMIT_INCREASE = "CLINC";
    public static final String CREDIT_REQUEST_NEW = "NREQ";
    public static final String CREDIT_REQUEST_ADJUSTMENT = "ADJT";
    public static final String CREDIT_REQUEST_ACCT_REVIEW = "AREV";
    // customer sign up status - extension package
    public static final String NEW_CUSTOMER = "NCUST";
    public static final String EXISTING_CUSTOMER = "ECUST";
    public static final String MATRIX_ACCT_PREFIX = "CM#";
    public static final String MANUAL_APPROVAL_PREFIX = "APR";
    public static final String IDM_METHOD_CREDIT_REFERENCE = "IDM Credit Reference";
    public static final String IDM_METHOD_CREDIT_BUREAU = "IDM Credit Bureau";
    public static final String ORDER_STATUS_HOLD = "H";
    public static final String ORDER_STATUS_RELEASED = "R";
    public static final String ORDER_ADDRESS_SHIPTO = "S";
    public static final String ORDER_ADDRESS_BILLTO = "B";
    //
    public static final String STATUS_OPEN = "Open";
    public static final String STATUS_CLOSED = "Closed";
    public static final String APPROVAL_ACTION_LEVEL_VERIFICATION = "VERIFICATION";
    public static final String APPROVAL_ACTION_LEVEL_APPROVAL = "APPROVAL";
    public static final String ACCT_TYPE_CHECKING = "Checking";
    public static final String ACCT_TYPE_SAVING = "Saving";
    public static final String ACCT_TYPE_401k = "401k-Investment";
    public static final String ACCT_TYPE_LOAN = "Loan-Account";
    public static final String ACCT_TYPE_INVESTMENT = "General-Investment";
    public final static String CONTACT_SHIPPING = "SHIPPING";
    public final static String CONTACT_BILLING = "BILLING";
    public final static String CONTACT_APAYABLE = "APAYABLE";
    public final static String CONTACT_OFFICER = "OFFICER";
    public final static String NOTE_SOURCE_CUSTOMER = "CUSTOMER";
    public final static String NOTE_SOURCE_SUPPLIER = "SUPPLIER";
    public final static String NOTE_TYPE_FILENOTE = "FILENOTE";
    public final static String NOTE_TYPE_ISSUESMGT = "ISSUESMGT";
    public final static String USER_LEVEL_ADMIN = "ADMINISTRATOR";
    public final static String USER_LEVEL_ORDINARY = "ORDINARY";
    public final static String INBOX_FILTER_OPEN = "OPEN";
    public final static String INBOX_FILTER_CLOSED = "CLOSED";
    public final static String INBOX_FILTER_ALL = "ALL";
    public final static String INBOX_FILTER_PENDING_DECISION = "PENDINGDECI";
    public final static String INBOX_FILTER_DECISION = "DECISION";
    public final static String REQUEST_NEW_CREDIT = "NCR";
    public final static String REQUEST_CREDIT_LIMIT_INCREASE = "CLI";
    public final static String FS_SCORE_WEAK = "Weak";
    public final static String FS_SCORE_STRONG = "Strong";
    public final static String FS_SCORE_AVERAGE = "Average";
    public final static String ID_SEPARATOR = "#";
    public final static String PARAM_APPROVAL_REDGKEY = "gkey";
    public final static String GROUP_STATUS_GROUP = "GROUP";
    public final static String GROUP_STATUS_NON_GROUP = "NON-GROUP";
    public final static String GROUP_LINK_URL_ID = "glnkid";
    public final static String SUBSCRIPTION_TYPE_TRIAL = "TRIAL";
    public final static String SUBSCRIPTION_TYPE_TRIAL_EXPIRED = "TRIAL-EXPIRED";
    public final static String SUBSCRIPTION_TYPE_PAID = "PAID";
    public final static String PRIMARY_GROUP_NAME = "PRIMARY";
    public final static String PRIMARY = "PRIMARY";
    public final static String CUSTOM = "CUSTOM";
    public final static String DOCUMENT_RECEIVED = "Received";
    public final static String DOCUMENT_NOT_APPLICABLE = "N/A";
    public final static String DOCUMENT_NOT_RECEIVED = "Not-Received";
    public final static String MENU_ACTIVE_TAB_CSS = "here";
    public final static String MENU_ACTIVE_TAB_POINTER = "&#9660;";
    //
    public final static String SUBSCRIPTION_STANDARD = "STANDARD";
    public final static String SUBSCRIPTION_STANDARD_WITH_CAP = "CAP_WORKFLOW";
    public final static String SUBSCRIPTION_ENTERPRISE = "ENTERPRISE";
    public final static String SUBSCRIPTION_ACTION_NEW = "NEW";
    public final static String SUBSCRIPTION_ACTION_ADD_SEAT = "ADDSEAT";
    public final static String SETUP_PROGRESS_NONE = "NONE";
    public final static String SETUP_PROGRESS_INPROGRESS = "INPROGRESS";
    public final static String SETUP_PROGRESS_COMPLETE = "COMPLETE";
    public final static String SEAT_TYPE_COURTESY = "COURTESY";
    public final static String SEAT_TYPE_PAYMENT = "PAYMENT";
    public final static String SEAT_TYPE_MANUAL = "MANUAL";
    public final static String APPROVAL_MODE_CREDIT_REQUEST = "CREDIT-REQUEST";
    public final static String APPROVAL_MODE_NON_CREDIT_REQUEST = "NON-CREDIT-REQUEST";
    public final static String APPROVAL_MODE_CLIENT_RECORD = "CLIENT-RECORD";
    public final static String CUSTOMER_STG_DATA_TYPE_BASIC = "CUSBASIC";
    public final static String CUSTOMER_STG_DATA_TYPE_CREDIT = "CUSCREDIT";
    public final static String CUSTOMER_STG_DATA_TYPE_ACCTOFFICER = "ACCTOFFICER";
    public final static String CUSTOMER_STG_DATA_TYPE_BASIC_CSV = "CUSBASIC-CSV";
    public final static String CUSTOMER_XML_DATA_BASIC_OUT = "OUT_CUSBASIC-XML";
    public final static String CUSTOMER_XML_DATA_FULL_OUT = "OUT_CUSFULL-XML";
    public final static String CUSTOMER_WS_DATA_FULL_OUT = "OUT_CUSFULL-WS";
    public final static String CUSTOMER_XML_DATA_BASIC_INFO_OUT = "OUT_CUSBASIC-INFO-XML";
    public final static String CUSTOMER_XML_DATA_CREDIT_INFO_OUT = "OUT_CUSCREDIT-INFO-XML";
    public final static String CUSTOMER_XML_DATA_OFFICER_OUT = "OUT_ACCTOFFICER-INFO-XML";
    public final static String CUSTOMER_XML_DATA_PORTFOLIO_OUT = "OUT_CUSPORTFOLIO-INFO-XML";
    public final static String CUSTOMER_XML_DATA_CONTACT_OUT = "OUT_CUSCONTACT-INFO-XML";
    public final static String CUSTOMER_XML_DATA_BASIC_IN = "IN_CUSBASIC-XML";
    public final static String CUSTOMER_XML_DATA_DECISION = "CREDIT-DECISION-XML";
    public final static String CUSTOMER_XML_DATA_ACCOUNT_CREATION_NOTIF_OUT = "OUT_ACCT-CREATION-NOTIF-XML";
    public final static String CUSTOMER_WS_DATA_ACCOUNT_CREATION_NOTIF_OUT = "OUT_ACCT-CREATION-NOTIF-WS";
    //
    public final static String CUSTOMER_WEBSERVICES_DATA_BASIC_IN = "IN_CUSBASIC-WS";
    public final static String CUSTOMER_WEBSERVICES_DATA_DECISION = "CREDIT-DECISION-WS";
    public final static String OPTIONAL = "OPTIONAL";
    public final static String REQUIRED = "REQUIRED";
    public final static String NOT_REQUIRED = "NOT-REQUIRED";
    public final static String NO_EMAIL = "NOEMAIL";
    public final static String PARAM_SIG_ID = "stacker";
    public final static String PARAM_SIG_GKEY = "saction";
    public final static String FILE_TYPE_IMAGE = "image";
    public final static String FILE_TYPE_PDF = "pdf";
    public final static String FILE_TYPE_DOC = "doc";
    public final static String FILE_TYPE_XLS = "xls";
    public final static String FILE_TYPE_DOCX = "docx";
    public final static String FILE_TYPE_XLSX = "xlsx";
    public final static String FILE_TYPE_CSV = "csv";
    public final static String PAYMENT_PLAN_AUTO = "AUTO";
    public final static String PAYMENT_PLAN_MANUAL = "MANUAL";
    public final static String CURRENT_TERMS_UPDATE_SOURCE_CREDITAPP = "CREDITAPP";
    public final static String CURRENT_TERMS_UPDATE_SOURCE_REVIEW = "REVIEW";
    public final static String BASIS_TYPE_FIXED = "Fixed";
    public final static String BASIS_TYPE_ATTRIBUTE = "Attribute";
    public final static String DOCUMENT_MGT_TYPE_SIGNABLE = "SIGNABLE";
    public final static String DOCUMENT_MGT_TYPE_UPLOAD = "FOR-UPLOAD";
    public final static String DOCUMENT_MGT_TYPE_DOWNLOAD = "FOR-DOWNLOAD";
    // public final static String DOCUMENT_MGT_TYPE_UPLOAD_PDF=
    // "FOR-UPLOAD-PDF";
    public final static String DOCUMENT_MGT_TYPE_TERMS_ON_FORM = "FOR-TERMS-ON-FORM";
    public final static String DOCUMENT_MGT_TYPE_REQ_REASSIGN = "FOR-REQUEST-REASSIGN";
    public final static String DOCUMENT_MGT_TYPE_MONITORABLE = "MONITORABLE";
    public final static String DOCUMENT_MGT_TYPE_SIGNABLE_ON_EACH_PAGE = "SIGNABLE ON EACH PAGE";
    public final static String EQUIPMENT_STATUS_NEW = "New";
    public final static String EQUIPMENT_STATUS_USED = "Used";
    public final static String EQUIPMENT_STATUS_RECONDITIONED = "Reconditioned";
    public final static String COMPANY_CONFIG_TYPE_TRADE = "TRADE";
    public final static String COMPANY_CONFIG_TYPE_LEASING = "LEASING";
    public final static String EQUIPMENT_DELIVERY_TATUS_DELIVERED = "Delivered";
    public final static String EQUIPMENT_DELIVERY_TATUS_NOTDELIVERED = "Not-Delivered";
    //
    public final static String ACCOUNT_REVIEW_BASIS_RISKCLASS = "RISKCLASS";
    public final static String ACCOUNT_REVIEW_BASIS_CRLIMIT = "CRLIMIT";
    public final static String ENTERPRISE_INTEGRATION_SERVICE_TYPE_WEBSERVICE = "WEBSERVICE";
    public final static String ENTERPRISE_INTEGRATION_SERVICE_TYPE_SECURED_FTP = "SECURED_FTP";
    public final static String ENTERPRISE_INTEGRATION_SERVICE_TYPE_SECURED_FTP_XML = "SECURED_FTP_XML";
    //
    public final static String ENTERPRISE_INTEGRATION_OPS_MODE_PILOT = "PILOT";
    public final static String ENTERPRISE_INTEGRATION_OPS_MODE_PROD = "PROD";
    public final static String USER_TYPE_CREDIT = "CREDIT-USER";
    public final static String USER_TYPE_SALES_CUSTPMER_SERVICE = "SALES-USER";
    public final static String SAME_PAGE = null;
    public final static String GROUP_TYPE_DIVISION = "Division";
    public final static String GROUP_TYPE_SUBSIDIARY = "Subsidiary";
    public final static String GROUP_TYPE_AFFILIATE = "Affiliate";
    public final static String GROUP_TYPE_PARENT = "Parent";
    public final static String CONSOLE_TYPE_MAIN = "MCON";
    public final static String CONSOLE_TYPE_PERF_DASHBOARD = "PBCON";
    public final static String CONSOLE_TYPE_MGT_DASHBOARD = "MGTCON";
    //
    public final static double LOWER_BOUND_CREDIT_LIMIT_DISCOUNT = 0.8;
    public final static String UNKNOWN = "UNKNOWN";
    public final static int TASKCONSOLE_MAX_REQUESTS_DISPLAY = 500;
    public final static String ASSIGNMENT_STATUS_ASSIGNED = "ASSIGNED";
    public final static String ASSIGNMENT_STATUS_NOT_ASSIGNED = "NOTASSIGNED";
    //
    public final static String SCOPE_GLOBAL = "GLOBAL";
    public final static String SCOPE_BY_UNIT = "BY-UNIT";
    public final static String SCOPE_INDIVIDUAL = "INDIVIDUAL";
    //
    public final static String SCOPE_LIMITED = "LIMITED";
    public final static String SCOPE_BUSINESS_GROUP = "BUSINESS-GROUP";
    public final static String GROUP_RULE_BASIC = "BASIC";
    public final static String GROUP_RULE_ALLORONE = "ALL-OR-ONE";
    
  //Instant Data Posting types
    public final static String IDP_TYPE_XML="XML";
    public final static String IDP_TYPE_JSON="JSON";
    
    public final static String ENTERPRISE_INTEGRATION_SERVICE_TYPE_IDP="IDP";
    public final static String IDP_TRANSMIT_TYPE_DIRECT="DIRECT-POST";
    public final static String IDP_TRANSMIT_TYPE_AUTHORIZATION="AUTHORIZATION-POST";
    
    public final static String IDP_ENABLE_TYPE="ENABLE";
    public final static String IDP_DISABLE_TYPE="DISABLE";
    public final static String IDP_START="START";
    public final static String IDP_STOP="STOP";
    public final static String IDP_TRANSMIT_ON="ON";
    public final static String IDP_TRANSMIT_OFF="OFF";
    
    public final static String IDP_TRANSMIT_AT_SUBMIT="SUBMISSION";
    public final static String IDP_TRANSMIT_AT_DECISION="DECISION";
    public static final String IDP_TRANSMIT_AT_PREQAUL_SUBIT="PRE_QUAL_SUBMISSION";
    
}
