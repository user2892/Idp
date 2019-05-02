package com.bectran.b2b.supplier.beans;

import java.util.Comparator;

import com.bectran.b2b.constants.PricingConstants;

/**
 * @author LOUIS IFEGUNI
 */
public class PricingBean {
    //
    public static final Comparator<PricingBean> DESCENDING_ORDER = new Comparator<PricingBean>() {
        public int compare(PricingBean r1, PricingBean r2) {
            return Integer.valueOf(r2.getOrder())
                    .compareTo(Integer.valueOf(r1.getOrder()));
        }
    };
    //
    public static final Comparator<PricingBean> ASCENDING_ORDER = new Comparator<PricingBean>() {
        public int compare(PricingBean r1, PricingBean r2) {
            return Integer.valueOf(r1.getOrder())
                    .compareTo(Integer.valueOf(r2.getOrder()));
        }
    };
    private String planCode;
    private String planDescription;
    private double price;
    private int numOfApp;
    private int numOfUser;
    private int trialPeriod;
    private String supportPlan;
    private String payPalCode;
    private int order;

    public int getNumOfApp() {
        return numOfApp;
    }

    public void setNumOfApp(int numOfApp) {
        this.numOfApp = numOfApp;
    }

    public int getNumOfUser() {
        return numOfUser;
    }

    public void setNumOfUser(int numOfUser) {
        this.numOfUser = numOfUser;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupportPlan() {
        return supportPlan;
    }

    public void setSupportPlan(String supportPlan) {
        this.supportPlan = supportPlan;
    }

    public int getTrialPeriod() {
        return trialPeriod;
    }

    public void setTrialPeriod(int trialPeriod) {
        this.trialPeriod = trialPeriod;
    }

    public String getPayPalCode() {
        return payPalCode;
    }

    public void setPayPalCode(String payPalCode) {
        this.payPalCode = payPalCode;
    }

    public double getAnnualCost() {
        return this.getPrice() * 12;
    }

    public boolean isUnlimitedApp() {
        if (this.planCode.trim().equals(PricingConstants.ENTERPRISE_PLAN)
                || this.planCode.trim()
                        .equals(PricingConstants.UNLIMITED_PLAN)) {
            return true;
        }
        return false;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getNumOfAppAnnual() {
        return this.getNumOfApp() * 12;
    }

}
