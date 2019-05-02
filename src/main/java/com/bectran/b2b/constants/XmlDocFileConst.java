package com.bectran.b2b.constants;

import java.io.File;

import com.bectran.matrix.framework.AppConfig;

/**
 * @Creation date : Apr 30, 2005
 * @author Louis Ifeguni
 */
public class XmlDocFileConst {
    /**
     * XML DOCUMENTS RELATIVE FILE FOLDER
     */
    public static final String XMLDOC_RELATIVE_FOLDER_PATH = "xmldoc";
    /**
     * These are the names of the xml documents in the xml documents folder.
     * Names must end in .xml and must always be the same as the names of the
     * physical files
     */
    public static final String SERVICE_PROVIDER_MAPPING = "serviceprovidermapping.xml";
    public static final String FSMAPDATA_MAPPING = "fsmapdatamapping.xml";
    public static final String QUALMAPDATA_MAPPING = "qualmapdatamapping.xml";
    public static final String COMPANY_QUALDATA_IMPORT_MAPPING = "companyqualmapping.xml";
    public static final String COMPANY_FINANCIAL_MAPPING = "companyfinancialmapping.xml";
    public static final String COMPANY_SEARCH_MAPPING = "companysearchmapping.xml";
    public static final String COMPANY_DETAIL_MAPPING = "companydetailmapping.xml";
    public static final String FX_RATE_SERVICE_MAPPING = "fxrateservicemapping.xml";
    public static final String EMAIL_MESSAGE_MAPPING = "emailmessagemapping.xml";
    //
    public static final String NON_FIN_INST_STATEMENT_FORMAT = "nonfinInstfinstmt.xml";
    public static final String FIN_INST_STATEMENT_FORMAT = "finInstfinstmt.xml";
    public static final String GENERAL_CONSTANT = "generalconstant.xml";
    public static final String GENERAL_CONSTANT_2 = "generalconstant_2.xml";
    public static final String GENERAL_CONSTANT_3 = "generalconstant_3.xml";
    public static final String PROCESS_OPTIONS = "processOptions.xml";
    public static final String COUNTRIES = "country.xml";
    public static final String STATES_US = "states_us.xml";
    public static final String TITLES = "title.xml";
    //
    public static final String SECTOR = "sec.xml";
    public static final String SECTOR_INDUSTRY = "secind.xml";
    public static final String CURRENCY = "currency.xml";
    //
    public static final String JDBC_DRIVERS = "drivers.xml";
    public static final String ECACHE_CONFIG = "ehcache.xml";
    public static final String AUDIT_TRAIL_STRUCTURE = "audittrail.xml";
    public static final String COLLATETRAL = "collateral.xml";
    public static final String LGD_STATUTORY = "lgd-statutory.xml";
    public static final String LOAN_ADMIN_HIERARCHY = "loan-admin-hierarchy.xml";
    public static final String RATING_MAP_SandP = "rating.xml";
    /**
     * XSLT FILE FOR FOP
     */
    public static final String XHTML_TO_XSLFO = "xhtml-to-xslfo.xsl";

    /**
     * @return
     */
    public static String getXmlDocFilePathPrefix() {
        String filepath = AppConfig.getWebContentPath()
                + XMLDOC_RELATIVE_FOLDER_PATH + File.separatorChar;
        return filepath;
    }

    /**
     * @return
     */
    public static String getXmlDocFilePathPrefix(String fileName) {
        String filepath = AppConfig
                .getSystemProperty(AppConfig.WEB_CONTENT_FILE_PATH)
                + XMLDOC_RELATIVE_FOLDER_PATH + File.separatorChar;
        return filepath + fileName;
    }
}
