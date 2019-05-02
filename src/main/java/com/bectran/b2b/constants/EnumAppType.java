/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.b2b.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Shanmu
 * @date Oct 5, 2015 9:55:28 PM
 */
public class EnumAppType {
    // --------------------------------------------------------------- Constants
    public final static String APP_TYPE_CREDIT = "CREDIT";
    public final static String APP_TYPE_CREDIT_APP = "CREDIT-APP";
    public final static String APP_TYPE_COD = "COD";
    public final static String APP_TYPE_SOLE_PROPRIETOR = "SOLE-PROPRIETOR";
    public static final String STR_APP_TYPE_CREDIT = "Credit Application";
    public final static String STR_APP_TYPE_COD = "Credit Card/COD/Account Opening";
    public final static String STR_APP_TYPE_SOLE_PROPRIETOR = "Sole Proprietor";

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>EnumAppType</code>
     */
    private EnumAppType() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    /**
     * @param appType
     * @return
     */
    public static String compatiable(String appType) {
        String result = "";
        if (StringUtils.equals(APP_TYPE_COD, appType)) {
            result = STR_APP_TYPE_COD;
        }
        else if (StringUtils.equals(APP_TYPE_CREDIT_APP, appType)) {
            result = APP_TYPE_CREDIT;
        }
        else if (StringUtils.equals(APP_TYPE_SOLE_PROPRIETOR, appType)) {
            result = APP_TYPE_SOLE_PROPRIETOR;
        }
        return result;
    }

    /**
     * @param appType
     * @return
     */
    public static String decode(String appType) {
        String result = "";
        if (StringUtils.equals(APP_TYPE_COD, appType)) {
            result = STR_APP_TYPE_COD;
        }
        else if (StringUtils.equals(APP_TYPE_CREDIT, appType)) {
            result = STR_APP_TYPE_CREDIT;
        }
        else if (StringUtils.equals(APP_TYPE_SOLE_PROPRIETOR, appType)) {
            result = STR_APP_TYPE_SOLE_PROPRIETOR;
        }
        return result;
    }
    // ----------------------------------------------------------- Inner Classes
}
