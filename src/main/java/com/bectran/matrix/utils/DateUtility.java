package com.bectran.matrix.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Louis Ifeguni
 * @Creation date : Apr 20, 2005
 */
public final class DateUtility {
    //
    public static final Comparator ASCENDING_ORDER = new Comparator() {
        public int compare(Object o1, Object o2) {
            DateUtility r1 = (DateUtility) o1;
            DateUtility r2 = (DateUtility) o2;
            return r1.getCode().compareTo(r2.getCode());
        }
    };
    //
    public static final long DAY_IN_MILLISEC = 24 * 60 * 60 * 1000;
    //
    private static final Map monthsMap = loadMonths();
    private static final Map monthsMapInCap = loadMonthsInCap();
    private String code;
    private String value;

    /**
     * DEFAULT CONSTRUCTOR
     */
    private DateUtility() {
    }

    /**
     * @param date
     * @return
     */
    public static String getYear(Date date_) {
        //
        String date = reFormatDate(date_);
        String year = date.substring(0, 4);
        //
        return year;
    }

    /**
     * @param date
     * @return
     */
    public static String getMonth(Date date_) {
        //
        String date = reFormatDate(date_);
        String month = date.substring(5, 7);
        //
        return month;
    }

    public static String getYearMonth(Date date_) {
        //
        String date = reFormatDate(date_);
        String month = date.substring(5, 7);
        String year = date.substring(0, 4);
        String yearMonth = year.trim() + month.trim();
        //
        return yearMonth;
    }

    public static String getYearMonthDay(Date date_) {
        //
        String date = reFormatDate(date_);
        String day = date.substring(8, 10);
        String month = date.substring(5, 7);
        String year = date.substring(0, 4);
        String yearMonthDay = year.trim() + month.trim() + day.trim();
        //
        return yearMonthDay;
    }

    public static int getDashboardCutOffYearMonth() {
        // 12 months ago
        Date cutOffDate = DateUtility.dateOfXMonthsFromToday(-12);
        String yearMonth = getYearMonth(cutOffDate);
        //
        return Integer.parseInt(yearMonth);
    }

    public static String getDay(Date date_) {
        //
        String date = reFormatDate(date_);
        String month = date.substring(8, 10);
        //
        return month;
    }

    /**
     * @param month
     * @return
     */
    public static String getMonthDescription(String month) {
        //
        return (String) monthsMap.get(month);
    }

    public static String getMonthDescInCap(String month) {
        //
        return (String) monthsMapInCap.get(month);
    }

    public static String reFormatDate(Date date) {
        //
        SimpleDateFormat formatter;
        String pattern = "yyyy.MM.dd ";
        formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }
    
    public static String reFormatDate(Date date,String pattern) {
        SimpleDateFormat formatter=new SimpleDateFormat(pattern);
       return formatter.format(date);
   }
    
    public static String reFormatDatePlane(Date date) {
        //
        SimpleDateFormat formatter;
        String pattern = "yyyyMMdd ";
        formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static String reFormatDateForXmlSchema(Date date) {
        //
        SimpleDateFormat formatter;
        String pattern = "yyyy-MM-dd ";
        formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    /**
     * @return
     */
    public static Map loadMonths() {
        Map mp = new HashMap(17);
        // SortedMap mp = new HashMap(17);
        //
        mp.put("01", "Jan");
        mp.put("02", "Feb");
        mp.put("03", "Mar");
        mp.put("04", "Apr");
        mp.put("05", "May");
        mp.put("06", "Jun");
        mp.put("07", "Jul");
        mp.put("08", "Aug");
        mp.put("09", "Sep");
        mp.put("10", "Oct");
        mp.put("11", "Nov");
        mp.put("12", "Dec");
        return mp;
    }

    public static Map loadMonthsInCap() {
        Map mp = new HashMap(17);
        // SortedMap mp = new HashMap(17);
        //
        mp.put("01", "JAN");
        mp.put("02", "FEB");
        mp.put("03", "MAR");
        mp.put("04", "APR");
        mp.put("05", "MAY");
        mp.put("06", "JUN");
        mp.put("07", "JUL");
        mp.put("08", "AUG");
        mp.put("09", "SEP");
        mp.put("10", "OCT");
        mp.put("11", "NOV");
        mp.put("12", "DEC");
        return mp;
    }

    public static Map loadMonthsEndDay() {
        Map mp = new HashMap(17);
        // SortedMap mp = new HashMap(17);
        //
        mp.put("01", "31");
        mp.put("02", "28");
        mp.put("03", "31");
        mp.put("04", "30");
        mp.put("05", "31");
        mp.put("06", "30");
        mp.put("07", "31");
        mp.put("08", "31");
        mp.put("09", "30");
        mp.put("10", "31");
        mp.put("11", "30");
        mp.put("12", "31");
        return mp;
    }

    /**
     * @param map
     * @return
     */
    public static List convertMonthsMapToList(Map map) {
        //
        List list = new ArrayList();
        for (Iterator i = map.entrySet().iterator(); i.hasNext();) {
            Map.Entry e = (Map.Entry) i.next();
            DateUtility month = new DateUtility();
            month.setCode(e.getKey().toString());
            month.setValue(e.getValue().toString());
            list.add(month);
        }
        Collections.sort(list, ASCENDING_ORDER);
        return list;
    }

    public static List loadMonthsIntoList() {
        //
        Map mp = loadMonths();
        List list = convertMonthsMapToList(mp);
        return list;
    }

    /**
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int computeDays(Date beginDate, Date endDate) {
        //
        long diff = 0;
        double days = 0;
        try {
            diff = endDate.getTime() - beginDate.getTime();
            days = ((diff * 1d) / (DAY_IN_MILLISEC * 1d));
        }
        catch (Exception e) {
            days = 0;
        }
        int result = (int) Math.round(days);
        return result;
    }

    /**
     * conversts date string in the format yyyymmdd to DATE Object
     * 
     * @param stmtDate
     */
    public static Date convertDateStringToDate(String stmtDate) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,
                Integer.parseInt(stmtDate.substring(6, 8)));
        cal.set(Calendar.MONTH, Integer.parseInt(stmtDate.substring(4, 6)) - 1); // to
                                                                                 // adjust
                                                                                 // for
                                                                                 // count
                                                                                 // of
                                                                                 // month
                                                                                 // from
                                                                                 // 0
                                                                                 // (for
                                                                                 // january)
        cal.set(Calendar.YEAR, Integer.parseInt(stmtDate.substring(0, 4)));
        //
        Date date = cal.getTime();
        return date;
    }

    /**
     * COMPUTE THE DATE OF X DAYS FROM TODAY
     * 
     * @param daysFromToday
     * @return
     */
    public static Date dateOfXDaysFromToday(int daysFromToday) {
        Calendar cal = Calendar.getInstance();
        Date today = new Date();
        int year = Integer.parseInt(DateUtility.getYear(today));
        int month = Integer.parseInt(DateUtility.getMonth(today));
        int day = Integer.parseInt(DateUtility.getDay(today));
        cal.set(year, month - 1, day + daysFromToday);
        Date dt = cal.getTime();
        return dt;
    }

    public static Date dateOfXMonthsFromToday(int monthsFromToday) {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        int year = Integer.parseInt(DateUtility.getYear(today));
        int month = Integer.parseInt(DateUtility.getMonth(today));
        int day = Integer.parseInt(DateUtility.getDay(today));
        cal.set(year, month - 1 + monthsFromToday, day);
        Date dt = cal.getTime();
        return dt;
    }

    public static Date dateOfXMonthsFromDate(int monthsFromToday,
                                             Date beginDate) {
        Date today = beginDate;
        Calendar cal = Calendar.getInstance();
        int year = Integer.parseInt(DateUtility.getYear(today));
        int month = Integer.parseInt(DateUtility.getMonth(today));
        int day = Integer.parseInt(DateUtility.getDay(today));
        cal.set(year, month - 1 + monthsFromToday, day);
        Date dt = cal.getTime();
        return dt;
    }

    public static Date dateOfXYearsFromToday(int yearsFromToday) {
        Calendar cal = Calendar.getInstance();
        int year = Integer.parseInt(DateUtility.getYear(new Date()));
        int month = Integer.parseInt(DateUtility.getMonth(new Date()));
        int day = Integer.parseInt(DateUtility.getDay(new Date()));
        cal.set(year + yearsFromToday, month - 1, day);
        Date dt = cal.getTime();
        return dt;
    }

    public static String timeStampLabel() {
        //
        SimpleDateFormat formatter;
        String pattern = "yyyyMMddHHmmss";
        formatter = new SimpleDateFormat(pattern);
        Date date = new Date();
        return formatter.format(date);
    }

    /**
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int computeYearsRounded(Date beginDate, Date endDate) {
        //
        double years = 0;
        try {
            long diff = endDate.getTime() - beginDate.getTime();
            years = ((diff * 1d) / (360 * DAY_IN_MILLISEC * 1d));
        }
        catch (Exception e) {
            years = 0;
        }
        int result = (int) Math.round(years);
        return result;
    }

    public static double computeYears(Date beginDate, Date endDate) {
        //
        double years = 0;
        try {
            long diff = endDate.getTime() - beginDate.getTime();
            years = ((diff * 1d) / (360 * DAY_IN_MILLISEC * 1d));
        }
        catch (Exception e) {
            years = 0;
        }
        return years;
    }

    /**
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * @param string
     */
    public void setCode(String string) {
        code = string;
    }

    /**
     * @param string
     */
    public void setValue(String string) {
        value = string;
    }
}
