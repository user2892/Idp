/**
 * 
 */
package com.bectran.opsmgt.beans;

import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 * @date Dec 23, 2012 : 1:28:07 PM
 */
public class OpsHeaderBaseBean {
    public static final String MODE_QUEUE_ONLY = "QUEUE-ONLY";
    public static final String MODE_QUEUE_UNIT_PLUS = "QUEUE-UNIT-PLUS";
    private Long id; // same as supplierID
    private String queueMethod = OpsMethodBean.NONE;
    private Date lastUpdate;
    private String status = MatrixConstants.STATUS_ACTIVE;
    private String name;
    private String nameInput;
    //
    private int opsMgtLevel = 2;
    private String levelNameWithPrefix = MatrixConstants.ANSWER_NO;
    private String parentNameLabel;
    private String unitNameLabel;
    private String categoryNameLabel;
    private String internalSalesRepsMgt = MatrixConstants.ANSWER_YES;
    private String multipleShipAndBill = MatrixConstants.ANSWER_NO;
    private String multipleLocationRequest = MatrixConstants.ANSWER_NO;
    //
    private String creditMgtScope = MatrixConstants.SCOPE_GLOBAL;
    private String salesRepsNotificationScope = MatrixConstants.SCOPE_INDIVIDUAL;
    //
    private String opsMgtMode = MODE_QUEUE_UNIT_PLUS;

    public OpsHeaderBaseBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQueueMethod() {
        return queueMethod;
    }

    public void setQueueMethod(String queueMethod) {
        this.queueMethod = queueMethod;
    }

    public Date getLastUpdate() {
        return (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = (Date) (lastUpdate == null ? null : lastUpdate.clone());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActiveStatus() {
        return this.getStatus().trim().equals(MatrixConstants.STATUS_ACTIVE)
                ? true : false;
    }

    public String getNameInput() {
        return nameInput;
    }

    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }

    public int getOpsMgtLevel() {
        return opsMgtLevel;
    }

    public void setOpsMgtLevel(int opsMgtLevel) {
        this.opsMgtLevel = opsMgtLevel;
    }

    public String getLevelNameWithPrefix() {
        return levelNameWithPrefix;
    }

    public void setLevelNameWithPrefix(String levelNameWithPrefix) {
        this.levelNameWithPrefix = levelNameWithPrefix;
    }

    public String getParentNameLabel() {
        return parentNameLabel;
    }

    public void setParentNameLabel(String parentNameLabel) {
        this.parentNameLabel = parentNameLabel;
    }

    public String getUnitNameLabel() {
        return unitNameLabel;
    }

    public void setUnitNameLabel(String unitNameLabel) {
        this.unitNameLabel = unitNameLabel;
    }

    public String getCategoryNameLabel() {
        return categoryNameLabel;
    }

    public void setCategoryNameLabel(String categoryNameLabel) {
        this.categoryNameLabel = categoryNameLabel;
    }

    public String getInternalSalesRepsMgt() {
        return internalSalesRepsMgt;
    }

    public void setInternalSalesRepsMgt(String internalSalesRepsMgt) {
        this.internalSalesRepsMgt = internalSalesRepsMgt;
    }

    public boolean isManageSalesInternally() {
        if (this.getInternalSalesRepsMgt() != null
                && this.getInternalSalesRepsMgt().trim()
                        .equals(MatrixConstants.ANSWER_YES)) {
            return true;
        }
        return false;
    }

    public boolean isSimpleSelectionQueueMethod() {
        if (this.getQueueMethod() != null && this.getQueueMethod().trim()
                .equals(OpsMethodBean.SIMPLE_DIRECT_SELECTION)) {
            return true;
        }
        return false;
    }

    public boolean isOpsHasWorkQueue() {
        if (this.getQueueMethod() != null
                && !this.getQueueMethod().trim().equals(OpsMethodBean.NONE)) {
            return true;
        }
        return false;
    }

    public String getCreditMgtScope() {
        return creditMgtScope;
    }

    public void setCreditMgtScope(String creditMgtScope) {
        this.creditMgtScope = creditMgtScope;
    }

    public String getSalesRepsNotificationScope() {
        return salesRepsNotificationScope;
    }

    public void setSalesRepsNotificationScope(String salesRepsNotificationScope) {
        this.salesRepsNotificationScope = salesRepsNotificationScope;
    }

    public boolean isShowByUnitNotifForRep() {
        if (this.getSalesRepsNotificationScope() != null
                && this.getSalesRepsNotificationScope().trim()
                        .equals(MatrixConstants.SCOPE_BY_UNIT)) {
            return true;
        }
        return false;
    }

    public boolean isUnitCreditMgtScope() {
        if (this.getCreditMgtScope() != null && this.getCreditMgtScope().trim()
                .equals(MatrixConstants.SCOPE_BY_UNIT)) {
            return true;
        }
        return false;
    }

    public String getMultipleShipAndBill() {
        return multipleShipAndBill;
    }

    public void setMultipleShipAndBill(String multipleShipAndBill) {
        this.multipleShipAndBill = multipleShipAndBill;
    }

    public String getMultipleLocationRequest() {
        return multipleLocationRequest;
    }

    public void setMultipleLocationRequest(String multipleLocationRequest) {
        this.multipleLocationRequest = multipleLocationRequest;
    }

    /**
     * @return the managerUnitQueueMapMethod
     */
    public boolean isManagerUnitQueueMapMethod() {
        if (this.getQueueMethod() != null && this.getQueueMethod().trim()
                .equals(OpsMethodBean.MANAGER_UNIT_MAP)) {
            return true;
        }
        return false;
    }

    /**
     * @return the opsMgtMode
     */
    public String getOpsMgtMode() {
        return opsMgtMode;
    }

    /**
     * @param opsMgtMode
     *            the opsMgtMode to set
     */
    public void setOpsMgtMode(String opsMgtMode) {
        this.opsMgtMode = opsMgtMode;
    }

    /**
     * @return the queueOnlyMode
     */
    public boolean isQueueOnlyMode() {
        if (this.getOpsMgtMode() != null
                && this.getOpsMgtMode().trim().equals(MODE_QUEUE_ONLY)) {
            return true;
        }
        return false;
    }

    /**
     * @return the queueUnitPlusMode
     */
    public boolean isQueueUnitPlusMode() {
        if (this.getOpsMgtMode() != null
                && this.getOpsMgtMode().trim().equals(MODE_QUEUE_UNIT_PLUS)) {
            return true;
        }
        return false;
    }

}
