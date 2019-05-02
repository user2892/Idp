package com.bectran.b2b.crol.beans;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 */
public class TradeRefFormBean {
    private Long id;
    private Long creditRefHeaderId;
    private Long refRequestId;
    private String yearsInBusinessCode;
    private double creditLimit;
    private double balanceOutstanding;
    private double balancePastDue;
    private String highestBalanceCode;
    private String creditTermsCode;
    private String dateOfLastSaleCode;
    private String paymentExperienceCode;
    private String overallRatingValue;
    private String refComment = "";
    private String nsfCode = MatrixConstants.ANSWER_NO;

    public TradeRefFormBean() {
    }

    public double getBalanceOutstanding() {
        return balanceOutstanding;
    }

    public void setBalanceOutstanding(double balanceOutstanding) {
        this.balanceOutstanding = balanceOutstanding;
    }

    public double getBalancePastDue() {
        return balancePastDue;
    }

    public void setBalancePastDue(double balancePastDue) {
        this.balancePastDue = balancePastDue;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Long getCreditRefHeaderId() {
        return creditRefHeaderId;
    }

    public void setCreditRefHeaderId(Long creditRefHeaderId) {
        this.creditRefHeaderId = creditRefHeaderId;
    }

    public String getCreditTermsCode() {
        return creditTermsCode;
    }

    public void setCreditTermsCode(String creditTermsCode) {
        this.creditTermsCode = creditTermsCode;
    }

    public String getDateOfLastSaleCode() {
        return dateOfLastSaleCode;
    }

    public void setDateOfLastSaleCode(String dateOfLastSaleCode) {
        this.dateOfLastSaleCode = dateOfLastSaleCode;
    }

    public String getHighestBalanceCode() {
        return highestBalanceCode;
    }

    public void setHighestBalanceCode(String highestBalanceCode) {
        this.highestBalanceCode = highestBalanceCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOverallRatingValue() {
        return overallRatingValue;
    }

    public void setOverallRatingValue(String overallRatingValue) {
        this.overallRatingValue = overallRatingValue;
    }

    public String getPaymentExperienceCode() {
        return paymentExperienceCode;
    }

    public void setPaymentExperienceCode(String paymentExperienceCode) {
        this.paymentExperienceCode = paymentExperienceCode;
    }

    public String getRefComment() {
        return refComment;
    }

    public void setRefComment(String refComment) {
        this.refComment = refComment;
    }

    public Long getRefRequestId() {
        return refRequestId;
    }

    public void setRefRequestId(Long refRequestId) {
        this.refRequestId = refRequestId;
    }

    public String getYearsInBusinessCode() {
        return yearsInBusinessCode;
    }

    public void setYearsInBusinessCode(String yearsInBusinessCode) {
        this.yearsInBusinessCode = yearsInBusinessCode;
    }

    public String getNsfCode() {
        return nsfCode;
    }

    public void setNsfCode(String nsfCode) {
        this.nsfCode = nsfCode;
    }
}
