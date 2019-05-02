package com.bectran.b2b.base.beans;

/**
 * @author Louis Ifeguni
 * @date Jan 14, 2007: 12:43:01 PM
 */
public class AcctSetupBaseBean {
    protected Long id;
    public boolean updateOrDelete = false;

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
}
