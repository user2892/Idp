/**
 * 
 */
package com.bectran.b2b.crol.beans;

import com.bectran.b2b.eref.helper.RangeRefAnswerModelBean;

/**
 * @author LOUIS IFEGUNI May 1, 2011 2:46:31 PM
 */
public class CreditRefMetricResultBean {
    private double maxCreditLimit = 0;
    private double maxBalanceOutstanding = 0;
    private double maxBalancePastDue = 0;
    private double avgCreditLimit = 0;
    private double PayDexValue;
    private double paymentsWithTerms; // proportion in percentage
    private double slowNegativePayment; // proportion in percentage
    private String avgHighBalRange = "";
    //
    private RangeRefAnswerModelBean avgHighBalBean;
    //
    private boolean hasMetricsResult;

    //
    public double getMaxCreditLimit() {
        return maxCreditLimit;
    }

    public void setMaxCreditLimit(double maxCreditLimit) {
        this.maxCreditLimit = maxCreditLimit;
    }

    public double getMaxBalanceOutstanding() {
        return maxBalanceOutstanding;
    }

    public void setMaxBalanceOutstanding(double maxBalanceOutstanding) {
        this.maxBalanceOutstanding = maxBalanceOutstanding;
    }

    public double getMaxBalancePastDue() {
        return maxBalancePastDue;
    }

    public void setMaxBalancePastDue(double maxBalancePastDue) {
        this.maxBalancePastDue = maxBalancePastDue;
    }

    public double getAvgCreditLimit() {
        return avgCreditLimit;
    }

    public void setAvgCreditLimit(double avgCreditLimit) {
        this.avgCreditLimit = avgCreditLimit;
    }

    public double getPayDexValue() {
        return PayDexValue;
    }

    public void setPayDexValue(double payDexValue) {
        PayDexValue = payDexValue;
    }

    public double getPaymentsWithTerms() {
        return paymentsWithTerms;
    }

    public void setPaymentsWithTerms(double paymentsWithTerms) {
        this.paymentsWithTerms = paymentsWithTerms;
    }

    public double getSlowNegativePayment() {
        return slowNegativePayment;
    }

    public void setSlowNegativePayment(double slowNegativePayment) {
        this.slowNegativePayment = slowNegativePayment;
    }

    public String getAvgHighBalRange() {
        return avgHighBalRange;
    }

    public void setAvgHighBalRange(String avgHighBalRange) {
        this.avgHighBalRange = avgHighBalRange;
    }

    public boolean isHasMetricsResult() {
        return hasMetricsResult;
    }

    public void setHasMetricsResult(boolean hasMetricsResult) {
        this.hasMetricsResult = hasMetricsResult;
    }

    public RangeRefAnswerModelBean getAvgHighBalBean() {
        return avgHighBalBean;
    }

    public void setAvgHighBalBean(RangeRefAnswerModelBean avgHighBalBean) {
        this.avgHighBalBean = avgHighBalBean;
    }
}
