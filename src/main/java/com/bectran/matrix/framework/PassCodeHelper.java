/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.matrix.framework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author LOUIS IFEGUNI
 * @DATE Sep 19, 2011 : 8:41:27 PM
 */
public class PassCodeHelper {
    public static String encryptCode(String clearCode, String mysalt)
            throws Exception {
        String coded = BectranAESUtil.generateEncodedSsoKey(clearCode, mysalt);
        return coded;
    }

    public static String decryptCode(String encodedValue, String mysalt)
            throws Exception {
        String clearcode = BectranAESUtil.decryptEncodedSsoKey(encodedValue,
                mysalt);
        return clearcode;
    }

    public static final String computeUniqueId(String accountId) {
        // generate random UUIDs
        UUID id = UUID.randomUUID();
        //
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
        return id.toString() + "-" + accountId.toLowerCase() + "-"
                + formatter.format(new Date());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(computeUniqueId("TN20060903007"));
        // DateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
        // System.out.println(formatter.format(new Date()));
    }
}
