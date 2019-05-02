/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.b2b.idp.beans;

import java.io.Serializable;

/**
 * @author santhosh
 * @date 02-Sep-2016 9:23:46 pm
 */
public class IDPAttribute implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    private Long id;
    private Long headerId;
    private String code;
    private String description;
    private String categoryCode;
    private String nodeName;

    public IDPAttribute() {
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

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * @return Returns the nodeName.
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * @param nodeName
     *            The nodeName to set.
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
    
}
