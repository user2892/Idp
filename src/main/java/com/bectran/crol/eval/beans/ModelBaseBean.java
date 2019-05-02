package com.bectran.crol.eval.beans;

import java.sql.Timestamp;
import java.util.Comparator;

import com.bectran.matrix.utils.FormatUtility;

/**
 * @author Louis Ifeguni Oct 30, 2006: 3:40:24 PM
 */
public class ModelBaseBean {
    /*
     * IDENTIFIES ALL MODEL OBJECTS
     */
    private Long id;
    //
    public static final String RESTART = "RESTART";
    // sort by INTERVAL CODE
    public static final Comparator DESCENDING_ORDER_INTERVALCODE = new Comparator() {
        public int compare(Object o1, Object o2) {
            ModelBaseBean r1 = (ModelBaseBean) o1;
            ModelBaseBean r2 = (ModelBaseBean) o2;
            return r2.getIntervalCode().compareTo(r1.getIntervalCode());
        }
    };
    public static final Comparator ASCENDING_ORDER_INTERVALCODE = new Comparator() {
        public int compare(Object o1, Object o2) {
            ModelBaseBean r1 = (ModelBaseBean) o1;
            ModelBaseBean r2 = (ModelBaseBean) o2;
            return r1.getIntervalCode().compareTo(r2.getIntervalCode());
        }
    };
    private String restartVal = "NORESTART";
    //
    private String code = "";
    private String name = "";
    private String modelType = "";
    private String modelTypeName = "";
    private double upperVal;
    private String shortName = "";
    private String fullName = "";
    //
    private String intervalCode = "";
    //
    // time stamp
    private Timestamp createDate;
    private String policyModelId = "";
    private String policyName = "";
    private boolean updateOrDelete = false;
    private boolean fromLeftMenu = false;
    private String selectedModelCode = "";

    /**
     * Get name
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     * 
     * @param <code>String</code>
     */
    public void setName(String n) {
        this.name = n;
    }

    /**
     * Get maxNumberOfScoreRange
     * 
     * @return int
     */
    /**
     * Get id
     * 
     * @return String
     */
    public String getCode() {
        return code;
    }

    /**
     * Set id
     * 
     * @param <code>String</code>
     */
    public void setCode(String i) {
        this.code = i;
    }

    /**
     * @return
     */
    public String getModelType() {
        return modelType;
    }

    /**
     * @param string
     */
    public void setModelType(String string) {
        modelType = string;
    }

    /**
     * @return Returns the createDate.
     */
    public Timestamp getCreateDate() {
        return (Timestamp) (createDate == null ? null : createDate.clone());
    }

    /**
     * @param createDate
     *            The createDate to set.
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = (Timestamp) (createDate == null ? null : createDate.clone());
    }

    /**
     * @return Returns the intervalCode.
     */
    public String getIntervalCode() {
        return intervalCode;
    }

    /**
     * @param intervalCode
     *            The intervalCode to set.
     */
    public void setIntervalCode(String intervalCode) {
        this.intervalCode = intervalCode;
    }

    /**
     * @return Returns the modelTypeName.
     */
    public String getModelTypeName() {
        return modelTypeName;
    }

    /**
     * @param modelTypeName
     *            The modelTypeName to set.
     */
    public void setModelTypeName(String modelTypeName) {
        this.modelTypeName = modelTypeName;
    }

    /**
     * @return Returns the policyModelId.
     */
    public String getPolicyModelId() {
        return policyModelId;
    }

    /**
     * @param policyModelId
     *            The policyModelId to set.
     */
    public void setPolicyModelId(String policyModelId) {
        this.policyModelId = policyModelId;
    }

    /**
     * @return Returns the restartVal.
     */
    public String getRestartVal() {
        return restartVal;
    }

    /**
     * @param restartVal
     *            The restartVal to set.
     */
    public void setRestartVal(String restartVal) {
        this.restartVal = restartVal;
    }

    /**
     * @return Returns the selectedModelCode.
     */
    public String getSelectedModelCode() {
        return selectedModelCode;
    }

    /**
     * @param selectedModelCode
     *            The selectedModelCode to set.
     */
    public void setSelectedModelCode(String selectedModelCode) {
        this.selectedModelCode = selectedModelCode;
    }

    /**
     * @return Returns the updateOrDelete.
     */
    public boolean isUpdateOrDelete() {
        return updateOrDelete;
    }

    /**
     * @param updateOrDelete
     *            The updateOrDelete to set.
     */
    public void setUpdateOrDelete(boolean updateOrDelete) {
        this.updateOrDelete = updateOrDelete;
    }

    /**
     * @return Returns the upperVal.
     */
    public double getUpperVal() {
        return upperVal;
    }

    /**
     * @param upperVal
     *            The upperVal to set.
     */
    public void setUpperVal(double upperVal) {
        this.upperVal = upperVal;
    }

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
     * @return Returns the fullName.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName
     *            The fullName to set.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return Returns the shortName.
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName
     *            The shortName to set.
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * @return Returns the policyName.
     */
    public String getPolicyName() {
        return policyName;
    }

    /**
     * @param policyName
     *            The policyName to set.
     */
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    /**
     * @return Returns the fromLeftMenu.
     */
    public boolean isFromLeftMenu() {
        return fromLeftMenu;
    }

    /**
     * @param fromLeftMenu
     *            The fromLeftMenu to set.
     */
    public void setFromLeftMenu(boolean fromLeftMenu) {
        this.fromLeftMenu = fromLeftMenu;
    }
    
    /**
     * @return Returns the shortNameWithoutNS.
     */
    public String getShortNameWithoutNS() {
        return FormatUtility.stripNameSpace(this.shortName);
    }

}
