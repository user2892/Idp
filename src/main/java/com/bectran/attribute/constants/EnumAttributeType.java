/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Shanmu
 * @date Sep 22, 2015 4:13:43 PM
 */
public class EnumAttributeType {
    // --------------------------------------------------------------- Constants
    public static final int TEXT = 1;
    public static final int DATE = 2;
    public static final int DECIMAL = 3;
    public static final int LIST = 4;
    public static final int MASKED = 5;
    public static final int MEMO = 6;
    public static final int INTEGER = 7;
    public static final int PASSWORD = 8;
    public static final int ATTACHEMENT = 9;
    public static final int HTML = 10;
    public static final int URL = 11;
    public static final int CURRENCY = 12;
    public static final int BOOLEAN = 13;
    public static final int SIGNATURE = 14;
    // String values
    public static final String TEXT_STR = "Text";
    public static final String DATE_STR = "Date";
    public static final String DECIMAL_STR = "Decimal";
    public static final String LIST_STR = "List";
    public static final String MASKED_STR = "Masked";
    public static final String MEMO_STR = "Memo";
    public static final String INTEGER_STR = "Integer";
    public static final String PASSWORD_STR = "Password";
    public static final String ATTACHEMENT_STR = "Attachment";
    public static final String HTML_STR = "HTML";
    public static final String URL_STR = "URL";
    public static final String CURRENCY_STR = "Currency";
    public static final String BOOLEAN_STR = "Boolean";
    public static final String MULTI_LIST_STR = "MultiList";
    public static final String MULTI_TEXT_STR = "MultiText";
    public static final String SIGNATURE_STR = "Signature";

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>EnumAttributeType</code>
     */
    private EnumAttributeType() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    /**
     * @param value
     * @return
     */
    public static String encode(int value) {
        String result = "unknown";
        switch (value) {
        case TEXT:
            result = TEXT_STR;
            break;
        case DATE:
            result = DATE_STR;
            break;
        case DECIMAL:
            result = DECIMAL_STR;
            break;
        case LIST:
            result = LIST_STR;
            break;
        case MASKED:
            result = MASKED_STR;
            break;
        case MEMO:
            result = MEMO_STR;
            break;
        case INTEGER:
            result = INTEGER_STR;
            break;
        case PASSWORD:
            result = PASSWORD_STR;
            break;
        case ATTACHEMENT:
            result = ATTACHEMENT_STR;
            break;
        case HTML:
            result = HTML_STR;
            break;
        case URL:
            result = URL_STR;
            break;
        case CURRENCY:
            result = CURRENCY_STR;
            break;
        case BOOLEAN:
            result = BOOLEAN_STR;
            break;
        case SIGNATURE:
            result = SIGNATURE_STR;
            break;
        }
        return result;
    }

    /**
     * @param value
     * @return
     */
    public static int decode(String value) {
        int result = -1;
        if (StringUtils.equals(TEXT_STR, value)) {
            result = TEXT;
        } else if (StringUtils.equals(DATE_STR, value)) {
            result = DATE;
        } else if (StringUtils.equals(DECIMAL_STR, value)) {
            result = DECIMAL;
        } else if (StringUtils.equals(LIST_STR, value)) {
            result = LIST;
        } else if (StringUtils.equals(MASKED_STR, value)) {
            result = MASKED;
        } else if (StringUtils.equals(MEMO_STR, value)) {
            result = MEMO;
        } else if (StringUtils.equals(INTEGER_STR, value)) {
            result = INTEGER;
        } else if (StringUtils.equals(PASSWORD_STR, value)) {
            result = PASSWORD;
        } else if (StringUtils.equals(ATTACHEMENT_STR, value)) {
            result = ATTACHEMENT;
        } else if (StringUtils.equals(HTML_STR, value)) {
            result = HTML;
        } else if (StringUtils.equals(URL_STR, value)) {
            result = URL;
        } else if (StringUtils.equals(CURRENCY_STR, value)) {
            result = CURRENCY;
        } else if (StringUtils.equals(BOOLEAN_STR, value)) {
            result = BOOLEAN;
        } else if (StringUtils.equals(SIGNATURE_STR, value)) {
            result = SIGNATURE;
        }
        return result;
    }
    // ----------------------------------------------------------- Inner Classes
}
