/**
 * 
 */
package com.bectran.b2b.supplier.beans;

import java.util.Comparator;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 3, 2012 : 5:50:15 PM
 */
public class GroupCustomCreditAppModelBaseBean {
    public static final Comparator<GroupCustomCreditAppModelBaseBean> ASCENDING_ORDER = new Comparator<GroupCustomCreditAppModelBaseBean>() {
        public int compare(GroupCustomCreditAppModelBaseBean r1,
                           GroupCustomCreditAppModelBaseBean r2) {
            return Integer.valueOf(r1.getDisplayOrder())
                    .compareTo(Integer.valueOf(r2.getDisplayOrder()));
        }
    };
    public static final Comparator<GroupCustomCreditAppModelBaseBean> ASCENDING_ORDER_CATEGORY = new Comparator<GroupCustomCreditAppModelBaseBean>() {
        public int compare(GroupCustomCreditAppModelBaseBean r1,
                           GroupCustomCreditAppModelBaseBean r2) {
            return r1.getCatId().compareTo(r2.getCatId());
        }
    };
    private Long id;
    private Long groupId;
    private String name;
    private String dataType = MatrixConstants.DATA_TYPE_ALPHANUMERIC;
    private int dataLength;
    private String encryptData = MatrixConstants.ANSWER_NO;
    private String listType = MatrixConstants.ANSWER_NO; // contains list
    private String required = MatrixConstants.ANSWER_YES;
    private int displayOrder;
    private Long catId;
    private String code;
    //
    private String formType;
    private String formTypeId;
    //
    private GroupCustomAppCategoryBean categoryBean;

    //
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    public String getEncryptData() {
        return encryptData;
    }

    public void setEncryptData(String encryptData) {
        this.encryptData = encryptData;
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public boolean isHasListType() {
        return this.getListType().trim().equals(MatrixConstants.ANSWER_YES)
                ? true : false;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public GroupCustomAppCategoryBean getCategoryBean() {
        return categoryBean;
    }

    public void setCategoryBean(GroupCustomAppCategoryBean categoryBean) {
        this.categoryBean = categoryBean;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getFormTypeId() {
        return formTypeId;
    }

    public void setFormTypeId(String formTypeId) {
        this.formTypeId = formTypeId;
    }
}
