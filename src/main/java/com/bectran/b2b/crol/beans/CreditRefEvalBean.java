package com.bectran.b2b.crol.beans;

import java.util.Comparator;

import com.bectran.b2b.crol.constants.ModelConstants;
import com.bectran.matrix.utils.FormatUtility;

/**
 * @author Louis Ifeguni Jan 29, 2007: 11:31:21 AM
 */
public class CreditRefEvalBean extends CreditRefBaseBean {
    public static final Comparator<CreditRefEvalBean> DESCENDING_ORDER_ATTRWEIGHT = new Comparator<CreditRefEvalBean>() {
        public int compare(CreditRefEvalBean r1, CreditRefEvalBean r2) {
            return new Double(r2.getAttrWeight())
                    .compareTo(new Double(r1.getAttrWeight()));
        }
    };
    public static final Comparator<CreditRefEvalBean> DESCENDING_ORDER_WEAKFACTOR = new Comparator<CreditRefEvalBean>() {
        public int compare(CreditRefEvalBean r1, CreditRefEvalBean r2) {
            return Integer.valueOf(r2.getWeakFactor())
                    .compareTo(Integer.valueOf(r1.getWeakFactor()));
        }
    };
    private Long headerId;
    private Long alphaAnsId;
    private int ansScore;
    private double numericValue;
    private String alphaAnsName = "";
    private String alphaAnsCode = "";
    private double attrWeight;
    // private boolean ignoreInEval = false;
    private double weightedScore;
    private double percent;
    private int weakFactor;
    /* added for web services */
    private String rawValue;
    private String answerCode;
    private String numericValueInput;
    private Long id;

    /**
     * @return Returns the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * DEFAULT CONSTRUCTOR
     */
    public CreditRefEvalBean() {
    }

    public CreditRefEvalBean(String code_, String value_, String valueType_) {
        this.shortName = code_;
        this.value = value_;
        if (valueType_.trim().equals(ModelConstants.VALUE_TYPE_NUM)) {
            this.numericValue = Double.parseDouble(value_);
        }
        else if (valueType_.trim().equals(ModelConstants.VALUE_TYPE_ALPHANUM)) {
            this.alphaAnsCode = value_;
        }
        this.dataType = valueType_;
    }
    CreditRefBean refRespHeader; // hibernate

    /**
     * @return Returns the refRespHeader.
     */
    public CreditRefBean getRefRespHeader() {
        return refRespHeader;
    }

    /**
     * @param refRespHeader
     *            The refRespHeader to set.
     */
    public void setRefRespHeader(CreditRefBean refRespHeader) {
        this.refRespHeader = refRespHeader;
    }

    /**
     * @return Returns the headerId.
     */
    public Long getHeaderId() {
        return headerId;
    }

    /**
     * @param headerId
     *            The headerId to set.
     */
    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    /**
     * @return Returns the alphaAnsId.
     */
    public Long getAlphaAnsId() {
        return alphaAnsId;
    }

    /**
     * @param alphaAnsId
     *            The alphaAnsId to set.
     */
    public void setAlphaAnsId(Long alphaAnsId) {
        this.alphaAnsId = alphaAnsId;
    }

    /**
     * @return Returns the alphaScore.
     */
    /**
     * @return Returns the numericValue.
     */
    public double getNumericValue() {
        return numericValue;
    }

    /**
     * @param numericValue
     *            The numericValue to set.
     */
    public void setNumericValue(double numericValue) {
        this.numericValue = numericValue;
    }

    /**
     * @return Returns the alphaAnsName.
     */
    public String getAlphaAnsName() {
        return alphaAnsName;
    }

    /**
     * @param alphaAnsName
     *            The alphaAnsName to set.
     */
    public void setAlphaAnsName(String alphaAnsName) {
        this.alphaAnsName = alphaAnsName;
    }

    /**
     * @return Returns the ansScore.
     */
    public int getAnsScore() {
        return ansScore;
    }

    /**
     * @param ansScore
     *            The ansScore to set.
     */
    public void setAnsScore(int ansScore) {
        this.ansScore = ansScore;
    }

    /**
     * @return Returns the attrWeight.
     */
    public double getAttrWeight() {
        return attrWeight;
    }

    /**
     * @param attrWeight
     *            The attrWeight to set.
     */
    public void setAttrWeight(double attrWeight) {
        this.attrWeight = attrWeight;
    }

    /**
     * @return Returns the weightedScore.
     */
    public double getWeightedScore() {
        return weightedScore;
    }

    /**
     * @param weightedScore
     *            The weightedScore to set.
     */
    public void setWeightedScore(double weightedScore) {
        this.weightedScore = weightedScore;
    }

    /**
     * @return Returns the alphatype.
     */
    public boolean isAlphatype() {
        if (this.getDataType().trim()
                .equals(ModelConstants.VALUE_TYPE_ALPHANUM)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return Returns the numericValueInput.
     */
    public String getNumericValueInput() {
        return numericValueInput;
    }

    /**
     * @param numericValueInput
     *            The numericValueInput to set.
     */
    public void setNumericValueInput(String numericValueInput) {
        this.numericValueInput = numericValueInput;
    }

    /**
     * @return Returns the percent.
     */
    public double getPercent() {
        return percent;
    }

    /**
     * @param percent
     *            The percent to set.
     */
    public void setPercent(double percent) {
        this.percent = percent;
    }

    /**
     * @return Returns the alphaAnsCode.
     */
    public String getAlphaAnsCode() {
        return alphaAnsCode;
    }

    /**
     * @param alphaAnsCode
     *            The alphaAnsCode to set.
     */
    public void setAlphaAnsCode(String alphaAnsCode) {
        this.alphaAnsCode = alphaAnsCode;
    }

    /**
     * @return Returns the weakFactor.
     */
    public int getWeakFactor() {
        return weakFactor;
    }

    /**
     * @param weakFactor
     *            The weakFactor to set.
     */
    public void setWeakFactor(int weakFactor) {
        this.weakFactor = weakFactor;
    }

    /**
     * @return Returns the rawValue.
     */
    public String getRawValue() {
        return rawValue;
    }

    /**
     * @param rawValue
     *            The rawValue to set.
     */
    public void setRawValue(String rawValue) {
        this.rawValue = rawValue;
    }

    /**
     * @return Returns the answerCode.
     */
    public String getAnswerCode() {
        return answerCode;
    }

    /**
     * @param answerCode
     *            The answerCode to set.
     */
    public void setAnswerCode(String answerCode) {
        this.answerCode = answerCode;
    }

    public String getFormattedValue() {
        return FormatUtility.formatNumber2Digit(this.getNumericValue());
    }

}
