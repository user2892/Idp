package com.bectran.b2b.crol.constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LOUIS IFEGUNI Jul 27, 2006:10:40:39 PM
 */
public class ResponseConstants {
    /**
     * state of customer's account
     */
    public static final String NO_RECORD = "NORECORD";
    public static final String ACCOUNT_CLOSED = "ACCOUNTCLOSED";
    public static final String INACTIVE_ACCOUNT = "INACTIVEACCOUNT";
    public static final String ACTIVE_ACCOUNT = "ACTIVEACCOUNT";
    /**
     * Credit limit in the past one year - by trend
     */
    public static final String INCREASED = "INCREASED";
    public static final String DECREASED = "DECREASED";
    public static final String REMAINED_THE_SAME = "REMAINEDTHESAME";
    /**
     * Credit limit in the past one year - by amount
     */
    public static final String THREE_TO_4FIGURE = "3T04FIGURE";
    public static final String FIVE_TO_6FIGURE = "5TO6FIGURE";
    public static final String SEVEN_TO_8FIGURE = "7TO8FIGURE";
    public static final String NINE_TO_10FIGURE = "9TO10FIGURE";
    public static final String ELEVEN_FIGURE_AND_ABOVE = "11ANDABOVE";
    public static final String NOCHANGE_FIGURE = "NOCHANGE";
    /**
     * Payment terms
     */
    public static final String COD = "COD";
    public static final String NET1TO30 = "1-30";
    public static final String NET31TO40 = "31-40";
    public static final String NET41TO50 = "41-50";
    public static final String NET51TO60 = "51-60";
    public static final String NET61TO90 = "61-90";
    public static final String NET91TO180 = "91-180";
    public static final String NET180PLUS = "180+";
    /**
     * Payment performance
     */
    public static final String ZERO_TO_FIVE = "0-5";
    public static final String SIX_TO_TEN = "6-10";
    public static final String ELEVEN_TO_TWENTY = "11-20";
    public static final String TWENTYONE_TO_THIRTY = "21-30";
    public static final String THIRTYONE_TO_FORTY = "31-40";
    public static final String FORTYONE_TO_SIXTY = "41-60";
    public static final String SIXTY_PLUS = "60+";
    /**
     * Payment performance - BANKS
     */
    public static final String NO_EXPERIENCE = "NoExp";
    public static final String PAYS_ONTIME = "PAYONTIME";
    public static final String LATE_SOMETIME = "LATESOMETIME";
    public static final String LATE_ALWAYS = "LATEALWAYS";
    public static final String FINANCIALLY_DISTRESSED = "FINDISTRESSED";
    /**
     * ACCOUNT OPENED CONSTANTS
     */
    public static final String UNDER_1YEAR = "UNDER1YEAR";
    public static final String ONE_TO_3YEARS = "1TO3YEARS";
    public static final String THREE_TO_6YEARS = "3T06YEARS";
    public static final String SIX_TO_10YEARS = "6TO10YEARS";
    public static final String TEN_TO_15YEARS = "10TO15YEARS";
    public static final String OVER_15YEARS = "OVER15YEARS";
    /**
     * TERMS FOR BANK REFERENCE
     */
    public static final String SHORT_TERM_LOAN = "STLOAN";
    public static final String LONG_TERM_LOAN = "LTLOAN";
    public static final String WORKING_CAPITAL = "WCLOAN";
    public static final String MIXED_TERMS = "MIXEDTERMS";

    public static Map termsForBanks() {
        //
        Map mp = new HashMap(17);
        //
        mp.put(SHORT_TERM_LOAN, "Short Term Loan");
        mp.put(LONG_TERM_LOAN, "Long Term Loan");
        mp.put(WORKING_CAPITAL, "Working Capital");
        mp.put(MIXED_TERMS, "Mixed Terms");
        //
        return mp;
    }

    /**
     * @return
     */
    public static Map acctState() {
        //
        Map mp = new HashMap(17);
        //
        mp.put(NO_RECORD, "No Record");
        mp.put(ACCOUNT_CLOSED, "Account Closed");
        mp.put(INACTIVE_ACCOUNT, "In-Active Account");
        mp.put(ACTIVE_ACCOUNT, "Active Account");
        //
        return mp;
    }

    public static Map trend() {
        //
        Map mp = new HashMap(17);
        //
        mp.put(INCREASED,
                "Customer's credit line increased in the last 12 months");
        mp.put(DECREASED,
                "Customer's credit line decreased in the last 12 months");
        mp.put(REMAINED_THE_SAME,
                "Customer's credit line remained the same in the last 12 months");
        //
        return mp;
    }
    /*
     * public static Map trendByAmount() { // Map mp = new HashMap(17); //
     * mp.put(THREE_FIGURE, "3 figure"); mp.put(FOUR_FIGURE, "4 figure");
     * mp.put(FIVE_FIGURE, "5 figure"); mp.put(SIX_FIGURE, "6 figure");
     * mp.put(SEVEN_FIGURE, "7 figure"); mp.put(EIGHT_FIGURE_AND_ABOVE,
     * "8 and above"); // return mp; }
     */

    public static Map trendByAmount() {
        //
        Map mp = new HashMap(17);
        //
        mp.put(NOCHANGE_FIGURE, "No Change");
        mp.put(THREE_TO_4FIGURE, "3-4 figure");
        mp.put(FIVE_TO_6FIGURE, "5-6 figure");
        mp.put(SEVEN_TO_8FIGURE, "7-8 figure");
        mp.put(NINE_TO_10FIGURE, "9-10 figure");
        mp.put(ELEVEN_FIGURE_AND_ABOVE, "11 figure and above");
        //
        return mp;
    }

    public static Map paymentTerms() {
        //
        Map mp = new HashMap(17);
        //
        mp.put(COD, "COD - Cash on order");
        mp.put(NET1TO30, "Net 1-30 days");
        mp.put(NET31TO40, "Net 31-40 days");
        mp.put(NET41TO50, "Net 41-50 days");
        mp.put(NET51TO60, "Net 51-60 days");
        mp.put(NET61TO90, "Net 61-90 days");
        mp.put(NET91TO180, "Net 91-180 days");
        mp.put(NET180PLUS, "Net 180+ days");
        /*
         * TERMS FOR BANK REFERENCE
         */
        mp.put(SHORT_TERM_LOAN, "Short Term Loan");
        mp.put(LONG_TERM_LOAN, "Long Term Loan");
        mp.put(WORKING_CAPITAL, "Working Capital");
        mp.put(MIXED_TERMS, "Mixed Terms");
        //
        //
        return mp;
    }

    public static List paymentTermsList() {
        //
        List list = new ArrayList();
        //
        // list.add(new ResponseConstantsHelperBean(0,"NONE", ""));
        list.add(
                new ResponseConstantsHelperBean(1, COD, "COD - Cash on order"));
        list.add(new ResponseConstantsHelperBean(2, NET1TO30, "Net 1-30 days"));
        list.add(new ResponseConstantsHelperBean(3, NET31TO40,
                "Net 31-40 days"));
        list.add(new ResponseConstantsHelperBean(4, NET41TO50,
                "Net 41-50 days"));
        list.add(new ResponseConstantsHelperBean(5, NET51TO60,
                "Net 51-60 days"));
        list.add(new ResponseConstantsHelperBean(6, NET61TO90,
                "Net 61-90 days"));
        list.add(new ResponseConstantsHelperBean(7, NET91TO180,
                "Net 91-180 days"));
        list.add(new ResponseConstantsHelperBean(8, NET180PLUS,
                "Net 180+ days"));
        //
        Collections.sort(list, ResponseConstantsHelperBean.ASCENDING_ORDER);
        //
        return list;
    }

    public static List payPerformanceList() {
        //
        List list = new ArrayList();
        //
        // list.add(new ResponseConstantsHelperBean(0,"NONE", ""));
        list.add(new ResponseConstantsHelperBean(1, ZERO_TO_FIVE,
                "Late by 0-5 days"));
        list.add(new ResponseConstantsHelperBean(2, SIX_TO_TEN,
                "Late by 6-10 days"));
        list.add(new ResponseConstantsHelperBean(3, ELEVEN_TO_TWENTY,
                "Late by 11-20 days"));
        list.add(new ResponseConstantsHelperBean(4, TWENTYONE_TO_THIRTY,
                "Late by 21-30 days"));
        list.add(new ResponseConstantsHelperBean(5, THIRTYONE_TO_FORTY,
                "Late by 31-40 days"));
        list.add(new ResponseConstantsHelperBean(6, FORTYONE_TO_SIXTY,
                "Late by 41-60 days"));
        list.add(new ResponseConstantsHelperBean(7, SIXTY_PLUS,
                "Late by 60+ days"));
        //
        Collections.sort(list, ResponseConstantsHelperBean.ASCENDING_ORDER);
        //
        return list;
    }

    public static Map payPerformance() {
        //
        Map mp = new HashMap(17);
        //
        mp.put(ZERO_TO_FIVE, "Late by 0-5 days");
        mp.put(SIX_TO_TEN, "Late by 6-10 days");
        mp.put(ELEVEN_TO_TWENTY, "Late by 11-20 days");
        mp.put(TWENTYONE_TO_THIRTY, "Late by 21-30 days");
        mp.put(THIRTYONE_TO_FORTY, "Late by 31-40 days");
        mp.put(FORTYONE_TO_SIXTY, "Late by 41-60 days");
        mp.put(SIXTY_PLUS, "Late by 60+ days");
        // ADDED - no risk they all have different keys
        mp.put(NO_EXPERIENCE, "No Experience");
        mp.put(PAYS_ONTIME, "Pays on-time");
        mp.put(LATE_SOMETIME, "Pays late sometimes");
        mp.put(LATE_ALWAYS, "Pays late always");
        mp.put(FINANCIALLY_DISTRESSED, "Financially distressed");
        //
        return mp;
    }

    public static Map payPerformanceBank() {
        //
        Map mp = new HashMap(17);
        //
        mp.put(NO_EXPERIENCE, "No Experience");
        mp.put(PAYS_ONTIME, "Pays on-time");
        mp.put(LATE_SOMETIME, "Pays late sometimes");
        mp.put(LATE_ALWAYS, "Pays late always");
        mp.put(FINANCIALLY_DISTRESSED, "Financially distressed");
        //
        return mp;
    }

    public static List payPerformanceBankList() {
        //
        List list = new ArrayList();
        //
        // list.add(new ResponseConstantsHelperBean(0,"NONE", ""));
        list.add(new ResponseConstantsHelperBean(1, NO_EXPERIENCE,
                "No Experience"));
        list.add(new ResponseConstantsHelperBean(2, PAYS_ONTIME,
                "Pays on-time"));
        list.add(new ResponseConstantsHelperBean(3, LATE_SOMETIME,
                "Pays late sometimes"));
        list.add(new ResponseConstantsHelperBean(4, LATE_ALWAYS,
                "Pays late always"));
        list.add(new ResponseConstantsHelperBean(5, FINANCIALLY_DISTRESSED,
                "Financially distressed"));
        //
        Collections.sort(list, ResponseConstantsHelperBean.ASCENDING_ORDER);
        //
        return list;
    }

    public static List acctStateList() {
        //
        List list = new ArrayList();
        //
        list.add(new ResponseConstantsHelperBean(1, ACTIVE_ACCOUNT,
                "Active Account"));
        list.add(new ResponseConstantsHelperBean(2, INACTIVE_ACCOUNT,
                "In-Active Account"));
        list.add(new ResponseConstantsHelperBean(3, ACCOUNT_CLOSED,
                "Account Closed"));
        list.add(new ResponseConstantsHelperBean(4, NO_RECORD, "No Record"));
        //
        Collections.sort(list, ResponseConstantsHelperBean.ASCENDING_ORDER);
        //
        return list;
    }

    public static Map accountsOpened() {
        //
        Map mp = new HashMap(17);
        //
        mp.put(UNDER_1YEAR, "Under 1 year");
        mp.put(ONE_TO_3YEARS, "1-3 Years");
        mp.put(THREE_TO_6YEARS, "3-6 years");
        mp.put(SIX_TO_10YEARS, "6-10 years");
        mp.put(TEN_TO_15YEARS, "10-15 years");
        mp.put(OVER_15YEARS, "Over 15 years");
        //
        return mp;
    }

    public static List accountsAgeList() {
        //
        List list = new ArrayList();
        //
        list.add(new ResponseConstantsHelperBean(1, UNDER_1YEAR,
                "Under 1 year"));
        list.add(
                new ResponseConstantsHelperBean(2, ONE_TO_3YEARS, "1-3 Years"));
        list.add(new ResponseConstantsHelperBean(3, THREE_TO_6YEARS,
                "3-6 years"));
        list.add(new ResponseConstantsHelperBean(4, SIX_TO_10YEARS,
                "6-10 years"));
        list.add(new ResponseConstantsHelperBean(5, TEN_TO_15YEARS,
                "10-15 years"));
        list.add(new ResponseConstantsHelperBean(6, OVER_15YEARS,
                "Over 15 years"));
        //
        Collections.sort(list, ResponseConstantsHelperBean.ASCENDING_ORDER);
        //
        return list;
    }

    public static List trendByFigureList() {
        //
        List list = new ArrayList();
        //
        list.add(new ResponseConstantsHelperBean(0, NOCHANGE_FIGURE,
                "No Change"));
        list.add(new ResponseConstantsHelperBean(1, THREE_TO_4FIGURE,
                "3-4 figure"));
        list.add(new ResponseConstantsHelperBean(2, FIVE_TO_6FIGURE,
                "5-6 figure"));
        list.add(new ResponseConstantsHelperBean(3, SEVEN_TO_8FIGURE,
                "7-8 figure"));
        list.add(new ResponseConstantsHelperBean(4, NINE_TO_10FIGURE,
                "9-10 figure"));
        list.add(new ResponseConstantsHelperBean(5, ELEVEN_FIGURE_AND_ABOVE,
                "11 figure and above"));
        //
        Collections.sort(list, ResponseConstantsHelperBean.ASCENDING_ORDER);
        //
        return list;
    }

    public static List numberOfAccountList() {
        //
        List list = new ArrayList();
        //
        list.add(new ResponseConstantsHelperBean(1, "1A", "1"));
        list.add(new ResponseConstantsHelperBean(2, "2A", "2"));
        list.add(new ResponseConstantsHelperBean(3, "3A", "3"));
        list.add(new ResponseConstantsHelperBean(4, "4A", "4"));
        list.add(new ResponseConstantsHelperBean(5, "5A", "5"));
        list.add(new ResponseConstantsHelperBean(6, "6A", "5+"));
        //
        Collections.sort(list, ResponseConstantsHelperBean.ASCENDING_ORDER);
        //
        return list;
    }

    public static Map numberOfAccountMap() {
        //
        Map mp = new HashMap(17);
        //
        mp.put("1A", "1");
        mp.put("2A", "2");
        mp.put("3A", "3");
        mp.put("4A", "4");
        mp.put("5A", "5");
        mp.put("6A", "5+");
        //
        return mp;
    }

    public static Map numberOfAccountMapForScoreSheet() {
        //
        Map mp = new HashMap(17);
        //
        mp.put("1A", "1");
        mp.put("2A", "2");
        mp.put("3A", "3");
        mp.put("4A", "4");
        mp.put("5A", "5");
        mp.put("6A", "6");
        //
        return mp;
    }

    public static List trendIn12months() {
        //
        List list = new ArrayList();
        //
        list.add(new ResponseConstantsHelperBean(1, INCREASED, "Increased"));
        list.add(new ResponseConstantsHelperBean(2, DECREASED, "Decreased"));
        list.add(new ResponseConstantsHelperBean(3, REMAINED_THE_SAME,
                "No change"));
        //
        Collections.sort(list, ResponseConstantsHelperBean.ASCENDING_ORDER);
        //
        return list;
    }

    public static List sizeCategory() {
        //
        List list = new ArrayList();
        //
        list.add(new ResponseConstantsHelperBean(1, CrolConstants.SMALL_SCALE,
                "Small-scale"));
        list.add(new ResponseConstantsHelperBean(2, CrolConstants.MEDIUM_SCALE,
                "Medium-scale"));
        list.add(new ResponseConstantsHelperBean(3, CrolConstants.LARGE_SCALE,
                "Large-scale"));
        //
        Collections.sort(list, ResponseConstantsHelperBean.ASCENDING_ORDER);
        //
        return list;
    }

    public static Map mapOfDescriptions() {
        Map mp = new HashMap();
        mp.putAll(acctState());
        mp.putAll(termsForBanks());
        mp.putAll(trend());
        mp.putAll(trendByAmount());
        mp.putAll(paymentTerms());
        mp.putAll(payPerformance());
        mp.putAll(payPerformanceBank());
        mp.putAll(accountsOpened());
        mp.putAll(numberOfAccountMap());
        mp.put("Yes", "Yes");
        mp.put("No", "No");
        mp.put("YES", "Yes");
        mp.put("NO", "No");
        return mp;
    }
}
