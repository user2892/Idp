package com.bectran.b2b.crol.beans;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;

/**
 * @author LOUIS IFEGUNI
 */
public class CreditRefBaseBean {
    //
    public static final Comparator DESCENDING_ORDER_DATATYPE = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRefBaseBean r1 = (CreditRefBaseBean) o1;
            CreditRefBaseBean r2 = (CreditRefBaseBean) o2;
            return r2.getDataType().compareTo(r1.getDataType());
        }
    };
    public static final Comparator ASCENDING_ORDER_DATATYPE = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRefBaseBean r1 = (CreditRefBaseBean) o1;
            CreditRefBaseBean r2 = (CreditRefBaseBean) o2;
            return r1.getDataType().compareTo(r2.getDataType());
        }
    };
    public static final Comparator DESCENDING_ORDER_DATECREATED = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRefBaseBean r1 = (CreditRefBaseBean) o1;
            CreditRefBaseBean r2 = (CreditRefBaseBean) o2;
            return r2.getDateCreated().compareTo(r1.getDateCreated());
        }
    };
    public static final Comparator ASCENDING_ORDER_DATECREATED = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRefBaseBean r1 = (CreditRefBaseBean) o1;
            CreditRefBaseBean r2 = (CreditRefBaseBean) o2;
            return r1.getDateCreated().compareTo(r2.getDateCreated());
        }
    };
    public static final Comparator DESCENDING_ORDER_VALUE = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRefBaseBean r1 = (CreditRefBaseBean) o1;
            CreditRefBaseBean r2 = (CreditRefBaseBean) o2;
            return new Double(r2.getValue())
                    .compareTo(new Double(r1.getValue()));
        }
    };
    public static final Comparator ASCENDING_ORDER_VALUE = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRefBaseBean r1 = (CreditRefBaseBean) o1;
            CreditRefBaseBean r2 = (CreditRefBaseBean) o2;
            return new Double(r1.getValue())
                    .compareTo(new Double(r2.getValue()));
        }
    };
    public static final Comparator DESCENDING_ORDER_SHORTNAME = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRefBaseBean r1 = (CreditRefBaseBean) o1;
            CreditRefBaseBean r2 = (CreditRefBaseBean) o2;
            return r2.getShortName().compareTo(r1.getShortName());
        }
    };
    public static final Comparator ASCENDING_ORDER_SHORTNAME = new Comparator() {
        public int compare(Object o1, Object o2) {
            CreditRefBaseBean r1 = (CreditRefBaseBean) o1;
            CreditRefBaseBean r2 = (CreditRefBaseBean) o2;
            return r1.getShortName().compareTo(r2.getShortName());
        }
    };
    //
    protected String bankOrTrade;
    protected int detailId;
    protected String attributeId;
    protected String shortName;
    protected String customerId = "";
    protected String refId;
    protected String userId = "";
    protected String customerName = "";
    protected Timestamp dateCreated;
    protected Date lastUpdateDate;
    protected String modelId = "";
    protected String value = "";
    protected String attribute = "";
    protected String dataType = "";
    protected boolean lockChanges = false;
    // used for reference response analysis
    protected String lowValue = "";
    protected String highValue = "";
    protected String avgValueDisplay = "";
    //
    /* evaluation specific variables */
    protected double totalValue = 0;
    protected int count = 0;
    protected double averageValue = 0;
    protected double averageScore = 0;
    // protected int score = 0;
    protected int totalScore = 0;
    protected int minScore = 0;
    protected int maxScore = 0;
    protected double minValue = 0;
    protected double maxValue = 0;
    //
    protected String dateCreatedDisplay = "";
    //
    protected String inputError = "";

    /**
     * @return
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * @return
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @return
     */
    public Timestamp getDateCreated() {
        return (Timestamp) (dateCreated == null ? null : dateCreated.clone());
    }

    /**
     * @return
     */
    public Date getLastUpdateDate() {
        return (Date) (lastUpdateDate == null ? null : lastUpdateDate.clone());
    }

    /**
     * @return
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * @return
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * @return Returns the customerId.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId
     *            The customerId to set.
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @param string
     */
    public void setAttribute(String string) {
        attribute = string;
    }

    /**
     * @param string
     */
    public void setCustomerName(String string) {
        customerName = string;
    }

    /**
     * @param timestamp
     */
    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = (Timestamp) (dateCreated == null ? null : dateCreated.clone());
    }

    /**
     * @param lastUpdateDate
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = (Date) (lastUpdateDate == null ? null : lastUpdateDate.clone());
    }

    /**
     * @param string
     */
    public void setModelId(String string) {
        modelId = string;
    }

    /**
     * @param string
     */
    public void setUserId(String string) {
        userId = string;
    }

    /**
     * @param string
     */
    public void setValue(String string) {
        value = string;
    }

    /**
     * @return
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @param string
     */
    public void setDataType(String string) {
        dataType = string;
    }

    /**
     * @return
     */
    public String getInputError() {
        return inputError;
    }

    /**
     * @param string
     */
    public void setInputError(String string) {
        inputError = string;
    }

    /**
     * @return Returns the refId.
     */
    public String getRefId() {
        return refId;
    }

    /**
     * @param refId
     *            The refId to set.
     */
    public void setRefId(String refId) {
        this.refId = refId;
    }

    /**
     * @return
     */
    public int getDetailId() {
        return detailId;
    }

    /**
     * @param i
     */
    public void setDetailId(int i) {
        detailId = i;
    }

    /**
     * @return
     */
    public String getDateCreatedDisplay() {
        return dateCreatedDisplay;
    }

    /**
     * @param string
     */
    public void setDateCreatedDisplay(String string) {
        dateCreatedDisplay = string;
    }

    /**
     * @return
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param string
     */
    public void setShortName(String string) {
        shortName = string;
    }

    /**
     * @return
     */
    public String getAttributeId() {
        return attributeId;
    }

    /**
     * @param string
     */
    public void setAttributeId(String string) {
        attributeId = string;
    }

    /**
     * @return
     */
    public double getAverageValue() {
        return averageValue;
    }

    /**
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * @return
     */
    public double getTotalValue() {
        return totalValue;
    }

    /**
     * @param d
     */
    public void setAverageValue(double d) {
        averageValue = d;
    }

    /**
     * @param i
     */
    public void setCount(int i) {
        count = i;
    }

    /**
     * @param d
     */
    public void setTotalValue(double d) {
        totalValue = d;
    }

    /**
     * @return
     */
    public String getHighValue() {
        return highValue;
    }

    /**
     * @return
     */
    public String getLowValue() {
        return lowValue;
    }

    /**
     * @param string
     */
    public void setHighValue(String string) {
        highValue = string;
    }

    /**
     * @param string
     */
    public void setLowValue(String string) {
        lowValue = string;
    }

    /**
     * @return
     */
    public String getAvgValueDisplay() {
        return avgValueDisplay;
    }

    /**
     * @param string
     */
    public void setAvgValueDisplay(String string) {
        avgValueDisplay = string;
    }

    /**
     * @return
     */
    public boolean isLockChanges() {
        return lockChanges;
    }

    /**
     * @param b
     */
    public void setLockChanges(boolean b) {
        lockChanges = b;
    }

    /**
     * @return Returns the bankOrTrade.
     */
    public String getBankOrTrade() {
        return bankOrTrade;
    }

    /**
     * @param bankOrTrade
     *            The bankOrTrade to set.
     */
    public void setBankOrTrade(String bankOrTrade) {
        this.bankOrTrade = bankOrTrade;
    }

    /**
     * @return Returns the totalScore.
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * @param totalScore
     *            The totalScore to set.
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * @return Returns the averageScore.
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * @param averageScore
     *            The averageScore to set.
     */
    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * @return Returns the maxScore.
     */
    public int getMaxScore() {
        return maxScore;
    }

    /**
     * @param maxScore
     *            The maxScore to set.
     */
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    /**
     * @return Returns the minScore.
     */
    public int getMinScore() {
        return minScore;
    }

    /**
     * @param minScore
     *            The minScore to set.
     */
    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }

    /**
     * @return Returns the maxValue.
     */
    public double getMaxValue() {
        return maxValue;
    }

    /**
     * @param maxValue
     *            The maxValue to set.
     */
    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * @return Returns the minValue.
     */
    public double getMinValue() {
        return minValue;
    }

    /**
     * @param minValue
     *            The minValue to set.
     */
    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }
}
