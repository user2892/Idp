/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.constants;


/**
 * @author shanmu
 * @date 10-May-2016 5:04:45 pm
 */
public class EnumConditionType {
    // --------------------------------------------------------------- Constants
    public static final int SHOW = 0;
    public static final int HIDE = 1;
    public static final int REQUIRED = 2;
    public static final int OPTIONAL = 3;
    // Strings
    public static final String SHOW_STR = "Show";
    public static final String HIDE_STR = "Hide";
    public static final String REQUIRED_STR = "Required";
    public static final String OPTIONAL_STR = "Optional";

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>EnumConditionType</code>
     */
    private EnumConditionType() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    /**
     * @param type
     * @return
     */
    public static String toString(int type) {
        String result = "UNKNOWN";
        switch (type) {
        case SHOW:
            result = SHOW_STR;
            break;
        case HIDE:
            result = HIDE_STR;
            break;
        case REQUIRED:
            result = REQUIRED_STR;
            break;
        case OPTIONAL:
            result = OPTIONAL_STR;
            break;
        }
        return result;
    }

    // ----------------------------------------------------------- Inner Classes
}
