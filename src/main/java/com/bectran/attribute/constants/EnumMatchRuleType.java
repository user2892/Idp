/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.constants;


/**
 * @author shanmu
 * @date 10-May-2016 3:22:30 pm
 */
public class EnumMatchRuleType {
    // --------------------------------------------------------------- Constants
    public static final int IS = 0;
    public static final int IS_NOT = 1;
    public static final String IS_STR = "is";
    public static final String IS_NOT_STR = "is not";

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>EnumMatchRuleType</code>
     */
    private EnumMatchRuleType() {
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
        case IS:
            result = IS_STR;
            break;
        case IS_NOT:
            result = IS_NOT_STR;
            break;
        }
        return result;
    }
    // ----------------------------------------------------------- Inner Classes
}
