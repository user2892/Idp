package com.bectran.b2b.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Louis Ifeguni
 * @date : Aug 1, 2007: 10:43:50 AM
 */
public class WsErrorMessageConstants {
    public static final String SUCCESS = "100";
    public static final String SYSTEM_ERROR = "200";
    public static final String EXPIRED_SUBSCRIPTION = "300";
    public static final String VALIDATION_ERROR = "600";
    public static final String NO_RESULTS = "700";
    public static final String AUTHENTICATION_ERROR = "800";
    public static final String ACCOUNT_INACTIVE = "999";
    public static final String INVALID_PARAMETERS = "422";
    public static final String NOT_FOUND = "404";
    
    public static String errorDescription(String code) {
        Map<String, String> mp = new HashMap<String, String>();
        mp.put(SUCCESS, "Success");
        mp.put(AUTHENTICATION_ERROR,
                "Incorrect UserID/Password - Authentication Error ");
        mp.put(VALIDATION_ERROR, "Validation Error - Schema Validation Error");
        mp.put(NO_RESULTS, "No Results");
        mp.put(SYSTEM_ERROR,
                "Application Execution Failed - Please try again later.");
        mp.put(EXPIRED_SUBSCRIPTION,
                "Bectran Subscription has expired or has become inactive.");
        mp.put(ACCOUNT_INACTIVE,
                "Bectran Enterprise Connect account is inactive.");
        mp.put(INVALID_PARAMETERS,
                "Invalid Parameters.");
        mp.put(NOT_FOUND,
                "Server Not Found.");
        //
        return mp.get(code);
    }
}
