package com.bectran.b2b.eref.helper;

import java.util.Comparator;

/**
 * @author LOUIS IFEGUNI
 */
public class XmlAttributeAnswerBean {
    public static final Comparator<XmlAttributeAnswerBean> DESCENDING_ORDER = new Comparator<XmlAttributeAnswerBean>() {
        public int compare(XmlAttributeAnswerBean r1,
                           XmlAttributeAnswerBean r2) {
            return Integer.valueOf(r2.getOrder())
                    .compareTo(Integer.valueOf(r1.getOrder()));
        }
    };
    public static final Comparator<XmlAttributeAnswerBean> ASCENDING_ORDER = new Comparator<XmlAttributeAnswerBean>() {
        public int compare(XmlAttributeAnswerBean r1,
                           XmlAttributeAnswerBean r2) {
            return Integer.valueOf(r1.getOrder())
                    .compareTo(Integer.valueOf(r2.getOrder()));
        }
    };
    static final Comparator<XmlAttributeAnswerBean> SENIORITY_ORDER = new Comparator<XmlAttributeAnswerBean>() {
        public int compare(XmlAttributeAnswerBean e1,
                           XmlAttributeAnswerBean e2) {
            return Integer.valueOf(e2.getOrder())
                    .compareTo(Integer.valueOf(e1.getOrder()));
        }
    };
    private int order;
    private String code;
    private String description;
    private int score;
    private int internalValue;
    private String attributeId;
    private double lowerBound;
    private double upperBound;

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInternalValue() {
        return internalValue;
    }

    public void setInternalValue(int internalValue) {
        this.internalValue = internalValue;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(double lowerBound) {
        this.lowerBound = lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(double upperBound) {
        this.upperBound = upperBound;
    }
    //
}
