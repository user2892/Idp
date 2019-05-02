/**
 * 
 */
package com.bectran.opsmgt.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LOUIS IFEGUNI
 * @date Mar 26, 2013 : 10:00:20 AM
 */
public class OpsMethodBean {
    public static final String ROUND_ROBIN = "ROUND_ROBIN";
    // public static final String DIRECT_SELECTION="DIRECT-SELECTION";
    public static final String SIMPLE_DIRECT_SELECTION = "SIMPLE-SELECTION";
    public static final String MANAGER_UNIT_MAP = "MANAGER-UNIT-MAP";
    public static final String NONE = "NONE";
    //

    private Map<String, String> mapOfMethods() {
        Map<String, String> mp = new HashMap<String, String>();
        mp.put(NONE, NONE);
        mp.put(SIMPLE_DIRECT_SELECTION, SIMPLE_DIRECT_SELECTION);
        mp.put(MANAGER_UNIT_MAP, MANAGER_UNIT_MAP);
        //
        return mp;
    }

    public String queueMethodName(String code) {
        return (String) mapOfMethods().get(code.trim());
    }
}
