package com.bectran.b2b.crol.beans;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.crol.constants.CrolConstants;

/**
 * @author LOUIS IFEGUNI
 */
public class BankRefFormBean {
    private Long id;
    private String yearsInBusinessCode;
    private String avgChkgAndSavingsBalCode;
    private String currChkgAndSavingsBalCode;
    private String hasLineOfCredit = CrolConstants.NO;
    private double lineOfCredAmount;
    private double balanceOnLineOfCredit;
    private String highestCreditGivenCode;
    private String creditRepaymentExperienceCode;
    private String overallRatingValue;
    private String refComment = "";
    private String creditLineSecurityCode;
    private String nsfCode = MatrixConstants.ANSWER_NO;
    private Long creditRefHeaderId;
    private Long refRequestId;

    public String getAvgChkgAndSavingsBalCode() {
        return avgChkgAndSavingsBalCode;
    }

    public void setAvgChkgAndSavingsBalCode(String avgChkgAndSavingsBalCode) {
        this.avgChkgAndSavingsBalCode = avgChkgAndSavingsBalCode;
    }

    public double getBalanceOnLineOfCredit() {
        return balanceOnLineOfCredit;
    }

    public void setBalanceOnLineOfCredit(double balanceOnLineOfCredit) {
        this.balanceOnLineOfCredit = balanceOnLineOfCredit;
    }

    public String getCreditRepaymentExperienceCode() {
        return creditRepaymentExperienceCode;
    }

    public void setCreditRepaymentExperienceCode(String creditRepaymentExperienceCode) {
        this.creditRepaymentExperienceCode = creditRepaymentExperienceCode;
    }

    public String getCurrChkgAndSavingsBalCode() {
        return currChkgAndSavingsBalCode;
    }

    public void setCurrChkgAndSavingsBalCode(String currChkgAndSavingsBalCode) {
        this.currChkgAndSavingsBalCode = currChkgAndSavingsBalCode;
    }

    public String getHighestCreditGivenCode() {
        return highestCreditGivenCode;
    }

    public void setHighestCreditGivenCode(String highestCreditGivenCode) {
        this.highestCreditGivenCode = highestCreditGivenCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLineOfCredAmount() {
        return lineOfCredAmount;
    }

    public void setLineOfCredAmount(double lineOfCredAmount) {
        this.lineOfCredAmount = lineOfCredAmount;
    }

    public String getHasLineOfCredit() {
        return hasLineOfCredit;
    }

    public void setHasLineOfCredit(String hasLineOfCredit) {
        this.hasLineOfCredit = hasLineOfCredit;
    }

    public String getOverallRatingValue() {
        return overallRatingValue;
    }

    public void setOverallRatingValue(String overallRatingValue) {
        this.overallRatingValue = overallRatingValue;
    }

    public String getYearsInBusinessCode() {
        return yearsInBusinessCode;
    }

    public void setYearsInBusinessCode(String yearsInBusinessCode) {
        this.yearsInBusinessCode = yearsInBusinessCode;
    }

    public Long getCreditRefHeaderId() {
        return creditRefHeaderId;
    }

    public void setCreditRefHeaderId(Long creditRefHeaderId) {
        this.creditRefHeaderId = creditRefHeaderId;
    }

    public Long getRefRequestId() {
        return refRequestId;
    }

    public void setRefRequestId(Long refRequestId) {
        this.refRequestId = refRequestId;
    }

    public boolean isHasCredit() {
        if (this.getHasLineOfCredit().trim().equals(CrolConstants.YES)) {
            return true;
        }
        return false;
    }

    public String getRefComment() {
        return refComment;
    }

    public void setRefComment(String refComment) {
        this.refComment = refComment;
    }

    public String getCreditLineSecurityCode() {
        return creditLineSecurityCode;
    }

    public void setCreditLineSecurityCode(String creditLineSecurityCode) {
        this.creditLineSecurityCode = creditLineSecurityCode;
    }

    public String getNsfCode() {
        return nsfCode;
    }

    public void setNsfCode(String nsfCode) {
        this.nsfCode = nsfCode;
    }
}
