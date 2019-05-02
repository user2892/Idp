package com.bectran.matrix.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * @author Louis Ifeguni
 * @Creation date : Aug 26, 2004
 */
public class FormatUtility {
    //
    //
    public static final String SEPARATOR = ".";
    // date format
    public static final int DATE_FORMAT_SHORT = DateFormat.SHORT;
    public static final int DATE_FORMAT_MEDIUM = DateFormat.MEDIUM;
    public static final int DATE_FORMAT_LONG = DateFormat.LONG;

    public static String formatDate(String _year, String _month, String _day,
                                    int dateFormat) {
        //
        Calendar cal = Calendar.getInstance();
        try {
            cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(_day));
            cal.set(Calendar.MONTH, Integer.parseInt(_month) - 1); // to adjust
                                                                   // for count
                                                                   // of month
                                                                   // from 0
                                                                   // (for
                                                                   // january)
            cal.set(Calendar.YEAR, Integer.parseInt(_year));
        }
        catch (Exception e) {
            return "";
        }
        //
        Date date = cal.getTime();
        DateFormat dateFormatter = DateFormat.getDateInstance(dateFormat);
        return dateFormatter.format(date);
    }

    public static String formatDate(Date _date, int dateFormat) {
        //
        DateFormat dateFormatter = DateFormat.getDateInstance(dateFormat);
        String result = "";
        try {
            result = dateFormatter.format(_date);
        }
        catch (Exception e) {
            result = dateFormatter.format(new Date());
        }
        return result;
    }

    /**
     * @param _date
     * @param dateFormat
     * @param timeFormat
     * @return
     */
    public static String formatDateTime(Date _date, int dateFormat,
                                        int timeFormat) {
        //
        DateFormat dateFormatter = DateFormat.getDateTimeInstance(dateFormat,
                timeFormat, Locale.getDefault());
        String result = "";
        try {
            result = dateFormatter.format(_date);
        }
        catch (Exception e) {
            result = dateFormatter.format(new Date());
        }
        return result;
    }

    public static String formatNumber(double number) {
        NumberFormat numberFormatter = NumberFormat.getNumberInstance();
        if (number == -0.0) {
            number = 0;
        }
        return numberFormatter.format(new Double(number));
    }

    public static String formatNumber(String stringValue) {
        NumberFormat numberFormatter = NumberFormat.getNumberInstance();
        double number;
        try {
            // first parse number before format
            stringValue = numberFormatter.parse(stringValue).toString();
            number = Double.parseDouble(stringValue);
        }
        catch (Exception e) {
            number = 0;
        }
        if (number == -0.0) {
            number = 0;
        }
        return numberFormatter.format(new Double(number));
    }

    public static String formatNumberRounded(double number) {
        NumberFormat numberFormatter = NumberFormat.getNumberInstance();
        if (number == -0.0) {
            number = 0;
        }
        return numberFormatter.format(new Double(Math.round(number)));
    }

    public static String formatNumberRounded(String stringValue) {
        NumberFormat numberFormatter = NumberFormat.getNumberInstance();
        double number;
        try {
            // first parse number before format
            stringValue = numberFormatter.parse(stringValue).toString();
            number = Double.parseDouble(stringValue);
        }
        catch (Exception e) {
            number = 0;
        }
        if (number == -0.0) {
            number = 0;
        }
        return numberFormatter.format(new Double(Math.round(number)));
    }

    public static String formatNumberWithBraces(double number) {
        NumberFormat numberFormatter = NumberFormat.getNumberInstance();
        if (number < 0) {
            return "(" + numberFormatter.format(new Double(-number)) + ")";
        }
        if (number == -0.0) {
            number = 0;
        }
        return numberFormatter.format(new Double(number));
    }

    public static String formatNumberWithBraces(String stringValue) {
        NumberFormat numberFormatter = NumberFormat.getNumberInstance();
        double number;
        try {
            // first parse number before format
            stringValue = numberFormatter.parse(stringValue).toString();
            number = Double.parseDouble(stringValue);
        }
        catch (Exception e) {
            number = 0;
        }
        if (number < 0) {
            return "(" + numberFormatter.format(new Double(-number)) + ")";
        }
        if (number == -0.0) {
            number = 0;
        }
        return numberFormatter.format(new Double(number));
    }

    public static String parseNumberInputString(String valueInput)
            throws ParseException {
        NumberFormat numformat = NumberFormat.getInstance();
        String returnVal = numformat.parse(valueInput).toString();
        return returnVal;
    }

    public static double parseNumberInputDouble(String valueInput)
            throws ParseException {
        NumberFormat numformat = NumberFormat.getInstance();
        // System.out.println("=====>>>> "+valueInput);
        double numericValue = 0;
        try {
            valueInput = numformat.parse(valueInput).toString();
            numericValue = Double.parseDouble(valueInput);
        }
        catch (Exception e) {
            numericValue = 0;
        }
        return numericValue;
    }

    public static String percentFormat(double number) {
        //
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();
        return percentFormatter.format(number);
    }

    public static String percentFormatSmall(double number) {
        //
        String pattern = "###.###";
        DecimalFormat percentFormatter = new DecimalFormat(pattern);
        return percentFormatter.format(number * 100d) + "%";
    }

    /**
     * conversts date string in the format yyyymmdd to DATE Object
     * 
     * @param stmtDate
     * @deprecated - USE METHOD IN DateUtility
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

    public String formatDate(String _year, String _month, String _day) {
        //
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(_day));
        cal.set(Calendar.MONTH, Integer.parseInt(_month) - 1); // to adjust for
                                                               // count of month
                                                               // from 0 (for
                                                               // january)
        cal.set(Calendar.YEAR, Integer.parseInt(_year));
        //
        Date date = cal.getTime();
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.LONG);
        return dateFormatter.format(date);
    }

    public static String formatNumber2Digit(double number) {
        //
        //
        String pattern = "###,###.##";
        DecimalFormat digit2Formatter = new DecimalFormat(pattern);
        return digit2Formatter.format(number);
    }

    public static String formatNumber2Digit(BigDecimal numberBD) {
        //
        double number = numberBD.doubleValue();
        //
        String pattern = "###,###.##";
        DecimalFormat digit2Formatter = new DecimalFormat(pattern);
        return digit2Formatter.format(number);
    }

    public static void main(String[] args) {
        //
        // System.out.println(formatDate("2000", "12", "12", DATE_FORMAT_LONG));
        // System.out.println(percentFormat(0.006));
        // System.out.println(convertDateStringToDate("20030101"));
        // double n = Double.parseDouble("-0");
        // System.out.println("..n.." +formatNumber(-0));
        // System.out.println(formatDate(new Date(),
        // FormatUtility.DATE_FORMAT_MEDIUM));
        // String val = " (0.4*S_Equity)+(0.6*C_OptgCashFlow)" + "\n" +
        // "+(0.3*WC)";
        // stripAllSpaces(val);
        System.out.println(
                "test result---> " + FormatUtility.formatNumber2Digit(23.009));
    }

    public static String stripNameSpace(String nameWithNS) {
        String result = "";
        // System.out.println("????????????????????? "+nameWithNS );
        // CHECK FOR NO NAME SPACE
        int separatorIndex = nameWithNS.indexOf(SEPARATOR);
        if (separatorIndex < 0) {
            return nameWithNS.trim();
        }
        // System.out.println(separatorIndex );
        result = nameWithNS.substring(separatorIndex + 1);
        return result.trim();
    }

    public static String stripAllSpaces(String textOrFormula,
                                        String delimiter) {
        //
        //
        StringTokenizer tokenizer = new StringTokenizer(textOrFormula,
                delimiter, true);
        int arraySize = tokenizer.countTokens();
        String[] tokens = new String[arraySize];
        String token = null;
        int k = 0;
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            tokens[k] = token;
            // System.out.println(tokens[k]);
            k++;
        }
        //
        // reconstruct arithmetic expression with financial values
        StringBuffer answithoutSpace = new StringBuffer();
        for (int i = 0; i < tokens.length; i++) {
            answithoutSpace.append(tokens[i].trim());
        }
        // System.out.println(answithoutSpace.toString());
        return answithoutSpace.toString();
    }

    public static String addNameSpace(String predicate, String name) {
        String result = "";
        result = predicate.trim() + SEPARATOR + name.trim();
        return result.trim();
    }
}
