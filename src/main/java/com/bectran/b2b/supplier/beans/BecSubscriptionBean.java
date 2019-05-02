package com.bectran.b2b.supplier.beans;

import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.constants.PricingConstants;
import com.bectran.matrix.utils.DateUtility;

/**
 * @author LOUIS IFEGUNI
 */
public class BecSubscriptionBean {
    private Long id;
    private Long supplierId;
    private String corpID = "";
    private Long corpHibernateId;
    private String planCode = "";
    private String planOptionType = "";
    private String currency = "";
    private Date beginingDate;
    private Date endDate;
    private Date lastUpdate;
    private double fullPrice;
    private double amountPaid;
    private double discount;
    private String subStatus = MatrixConstants.STATUS_ACTIVE;
    private String description = "";
    private int renewalCount;
    private int appUtilization; // credit application utilization counter
    private int appCredit;
    private String subscriptionType = MatrixConstants.SUBSCRIPTION_TYPE_TRIAL;
    //
    private String subscriptionAction; // NEW or UPGRADE
    //
    // private String planDescription;
    private double price;
    private int numOfApp;
    private int numOfUser;
    private int trialPeriod;
    private String supportPlan;
    private boolean expired;
    private int daysToExpiration;
    private boolean expiredByAppUtilization;
    private boolean expiredByDate;
    private Long appCutOffId; // for subscription expiration - by application
                              // utilization count
    private Date appCutOffDate; // for subscription expiration - by application
                                // utilization count
    private int appCount;
    //
    private OptionalPackageBean optionalPkgBean;
    private int trialDaysLeft;
    //
    private int numOfActiveSeats;
    private int numOfAvailableSeats;
    private double totalMonthlyBill;

    /**
     * DEFAULT CONSTRUCTOR
     */
    public BecSubscriptionBean() {
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getBeginingDate() {
        return (Date) (beginingDate == null ? null : beginingDate.clone());
    }

    public void setBeginingDate(Date beginingDate) {
        this.beginingDate = (Date) (beginingDate == null ? null : beginingDate.clone());
    }

    public Long getCorpHibernateId() {
        return corpHibernateId;
    }

    public void setCorpHibernateId(Long corpHibernateId) {
        this.corpHibernateId = corpHibernateId;
    }

    public String getCorpID() {
        return corpID;
    }

    public void setCorpID(String corpID) {
        this.corpID = corpID;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getEndDate() {
        return (Date) (endDate == null ? null : endDate.clone());
    }

    public void setEndDate(Date endDate) {
        this.endDate = (Date) (endDate == null ? null : endDate.clone());
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRenewalCount() {
        return renewalCount;
    }

    public void setRenewalCount(int renewalCount) {
        this.renewalCount = renewalCount;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

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

    public boolean isExpired() {
        /*
         * if(this.getEndDate().before(new Date())){ return true; }
         * if(this.getAppUtilization()>this.getAppCredit()){ return true; }
         * return false;
         */
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public String getStatus() {
        if (this.isExpired()) {
            return "EXPIRED";
        }
        return "ACTIVE";
    }

    public int getDaysToExpiration() {
        if (!this.isExpired()) {
            return (DateUtility.computeDays(new Date(), this.getEndDate()) + 1);
        }
        return daysToExpiration;
    }

    public void setDaysToExpiration(int daysToExpiration) {
        this.daysToExpiration = daysToExpiration;
    }

    public int getAppCredit() {
        return appCredit;
    }

    public void setAppCredit(int appCredit) {
        this.appCredit = appCredit;
    }

    public int getAppUtilization() {
        return appUtilization;
    }

    public void setAppUtilization(int appUtilization) {
        this.appUtilization = appUtilization;
    }

    public boolean isExpiredByAppUtilization() {
        return expiredByAppUtilization;
    }

    public void setExpiredByAppUtilization(boolean expiredByAppUtilization) {
        this.expiredByAppUtilization = expiredByAppUtilization;
    }

    public boolean isExpiredByDate() {
        return expiredByDate;
    }

    public void setExpiredByDate(boolean expiredByDate) {
        this.expiredByDate = expiredByDate;
    }

    public Long getAppCutOffId() {
        return appCutOffId;
    }

    public void setAppCutOffId(Long appIdCutOff) {
        this.appCutOffId = appIdCutOff;
    }

    public Date getAppCutOffDate() {
        return (Date) (appCutOffDate == null ? null : appCutOffDate.clone());
    }

    public void setAppCutOffDate(Date appCutOffDate) {
        this.appCutOffDate = (Date) (appCutOffDate == null ? null : appCutOffDate.clone());
    }

    public int getAppCount() {
        return appCount;
    }

    public void setAppCount(int appCount) {
        this.appCount = appCount;
    }

    public boolean isUnderUtilized() {
        if (this.getAppCredit() >= this.getAppCount()) {
            return true;
        }
        return false;
    }

    public int getOverUtilizationCount() {
        return (this.getAppCount() - this.getAppCredit());
    }

    public int getUnderUtilizationCount() {
        return (this.getAppCredit() - this.getAppCount());
    }

    public boolean isUnlimitedApp() {
        if (this.planCode.trim().equals(PricingConstants.ENTERPRISE_PLAN)
                || this.planCode.trim()
                        .equals(PricingConstants.UNLIMITED_PLAN)) {
            return true;
        }
        return false;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String sbscritionType) {
        this.subscriptionType = sbscritionType;
    }

    public boolean isTrialSubType() {
        return this.subscriptionType.trim()
                .equals(MatrixConstants.SUBSCRIPTION_TYPE_TRIAL) ? true : false;
    }

    public boolean isShowSubscriptionBtn() {
        if (isTrialSubType() || !isActiveSubscription()) {
            return true;
        }
        return false;
    }

    public boolean isFreePlan() {
        if (this.getPlanCode().trim().equals(PricingConstants.FREE_PLAN)
                && isActiveSubscription() && !isTrialSubType()) {
            return true;
        }
        return false;
    }

    public boolean isActivateAddSeat() {
        if (!isFreePlan() && !isTrialSubType()) {
            return true;
        }
        return false;
    }

    public boolean isAppOnlyExpiration() {
        if (this.isExpiredByAppUtilization() && !this.expiredByDate) {
            return true;
        }
        return false;
    }

    public boolean isActiveSubscription() {
        return this.subStatus.trim().equals(MatrixConstants.STATUS_ACTIVE)
                ? true : false;
    }

    public int getNumOfAppAnnual() {
        return this.getNumOfApp() * 12;
    }

    public String getPlanOptionType() {
        return planOptionType;
    }

    public void setPlanOptionType(String planOptionType) {
        this.planOptionType = planOptionType;
    }

    public String getSubscriptionAction() {
        return subscriptionAction;
    }

    public void setSubscriptionAction(String subscriptionAction) {
        this.subscriptionAction = subscriptionAction;
    }

    public OptionalPackageBean getOptionalPkgBean() {
        return optionalPkgBean;
    }

    public void setOptionalPkgBean(OptionalPackageBean optionalPkgBean) {
        this.optionalPkgBean = optionalPkgBean;
    }

    public boolean isStandardSubscription() {
        return this.planOptionType.trim()
                .equals(MatrixConstants.SUBSCRIPTION_STANDARD) ? true : false;
    }

    public boolean isCapWkflowSubscription() {
        return this.planOptionType.trim().equals(
                MatrixConstants.SUBSCRIPTION_STANDARD_WITH_CAP) ? true : false;
    }

    public boolean isHasActiveOptionalPkg() {
        if (this.getOptionalPkgBean() != null && this.getOptionalPkgBean()
                .getUpgradeFailed().trim().equals(MatrixConstants.ANSWER_NO)) {
            return true;
        }
        return false;
    }

    public boolean isShowUpgradeButton() {
        if (this.isActiveSubscription() && this.isStandardSubscription()) {
            return true;
        }
        if (this.isActiveSubscription() && this.isCapWkflowSubscription()
                && !this.isHasActiveOptionalPkg()) {
            // ie no active subscription
            return true;
        }
        return false;
    }

    public String getPlanDescription() {
        return "";// BecSubscriptionHelper.planDescription(this.getPlanCode(),
                  // this.getPlanOptionType());
    }

    public int getTrialDaysLeft() {
        return trialDaysLeft;
    }

    public void setTrialDaysLeft(int trialDaysLeft) {
        this.trialDaysLeft = trialDaysLeft;
    }

    public int getAvailableCredit() {
        return (this.getAppCredit() - this.getAppCount());
    }

    public int getNumOfActiveSeats() {
        return numOfActiveSeats;
    }

    public void setNumOfActiveSeats(int numOfActiveSeats) {
        this.numOfActiveSeats = numOfActiveSeats;
    }

    public int getNumOfAvailableSeats() {
        return numOfAvailableSeats;
    }

    public void setNumOfAvailableSeats(int numOfAvailableSeats) {
        this.numOfAvailableSeats = numOfAvailableSeats;
    }

    public double getTotalMonthlyBill() {
        return totalMonthlyBill;
    }

    public void setTotalMonthlyBill(double totalMonthlyBill) {
        this.totalMonthlyBill = totalMonthlyBill;
    }
}
