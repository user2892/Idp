/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.constants;


/**
 * @author shanmu
 * @date 10-May-2016 5:19:59 pm
 */
public class EnumMatchType {
    // --------------------------------------------------------------- Constants
    public static final int ALL = 0;
    public static final int ANY = 1;
    //
    public static final String ALL_STR = "All";
    public static final String ANY_STR = "Any";

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>EnumMatchType</code>
     */
    private EnumMatchType() {
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
        case ALL:
            result = ALL_STR;
            break;
        case ANY:
            result = ANY_STR;
            break;
        }
        return result;
    }

    // ----------------------------------------------------------- Inner Classes
}
