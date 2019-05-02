/**
 * 
 */
package com.bectran.b2b.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LOUIS IFEGUNI Date: Sep 11, 2012 - 1:46:20 PM
 */
public class CustomScoringConstants {
    public final static String CUSTOM_MODEL_TYPE_NEW_APP = "NEWAPP";
    public final static String CUSTOM_MODEL_TYPE_CREDIT_REVIEW = "CREDITREV";
    public final static String CUSTOM_MODEL_TYPE_ADV_UDEF = "ADVUDEF";
    public final static String SERVICE_PROVIDER_CORTERA = "CORTERA";
    public final static String SERVICE_PROVIDER_EXPERIAN = "EXPERIAN";
    public final static String SERVICE_PROVIDER_CREDITSAFE = "CREDITSAFE";
    //
    // public final static String BECTRAN_PRODUCT_CODE= "bectran";
    // public final static String BECTRAN_PRODUCT_DESCRIPTION= "Bectran";
    public static final String SERVICE_PROVIDER_BECTRAN = "Bectran";
    public static final String BECTRAN_PRODUCT_CODE_USER_DEFINED = "BectranUserDefined";
    public static final String BECTRAN_PRODUCT_CODE_DEFAULT = "BectranDefault";
    public static final String BECTRAN_PRODUCT_CODE_REVIEW = "BectranReview";
    public static final String BECTRAN_PRODUCT_CODE_ADV_UDEF = "AdvancedUdef";
    //
    public static final String BECTRAN_PRODUCT_DESCRIPTION_DEFAULT = "Default Scoring Model";
    public static final String BECTRAN_PRODUCT_DESCRIPTION_CLR = "Customer Experience Model";
    public static final String BECTRAN_PRODUCT_DESCRIPTION_USER_DEFINED = "User-defined Scoring Model";
    public final static String SERVICE_PROVIDER_DNB = "DNB";
    public static final String PRODUCT_DNB_DELINQUENCY_SCORE_ID = "DecisionSupport";
    public static final String PRODUCT_CORTERA_CPR_ID = "CPRReport";
    public static final String PRODUCT_EXPERIAN_BSUM_ID = "ExperianBSUM";
    public static final String PRODUCT_CSAFE_ID = "CreditSafe";
    public static final String PRODUCT_EXPERIAN_INTELISOCRE_ID = "ExperianIS";
    public static final String ATTRIBUTE_FIXED_AMOUNT_BASIS = "FixedAmountSpec";
    public static final double MAXIMUM_CRLIMIT_PERCENT = 500;

    public static String rangeCodeToRating(String code) {
        Map<String, String> mp = new HashMap<String, String>();
        mp.put("X1", "r1");
        mp.put("X2", "r2");
        mp.put("X3", "r3");
        mp.put("X4", "r4");
        mp.put("X5", "r5");
        return (String) mp.get(code.trim());
    }
    // public static final String FS_CODE ="FSM";
    // public static final String REF_CODE ="REF";
    //
    public static final String BDF_FS_CODE = "FSMT";
    public static final String BDF_TRADE_REF_CODE = "TREF";
    public static final String BDF_BANK_REF_CODE = "BREF";
    public static final String BDF_COMPANY_PROFILE_CODE = "CPRO";
}
