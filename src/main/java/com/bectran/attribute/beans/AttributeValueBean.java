/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author Shanmu
 * @date Jun 28, 2015 3:41:26 PM
 */
public class AttributeValueBean extends BaseEntity implements
        Comparable<AttributeValueBean> {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 1343668995667372198L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String id;
    private Long attributeDefID;
    private Long objectID;
    private String value;
    private String data;
    private Date dateValue;
    private Long listValueID;
    private ListValueBean listValues;
    private Long attributeGroupID;
    private AttributeDefBean attributeDef;
    private boolean booValue;
    // UI Specific
    private List<Long> selectedValues = new ArrayList<Long>();
    private List<String> multiTextValues = new ArrayList<String>();
    private String selectedMultiTextValue;
    private String multiTextValue;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>AttributeValue</code>
     */
    public AttributeValueBean() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the id.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Returns the attributeDefID.
     */
    public Long getAttributeDefID() {
        return attributeDefID;
    }

    /**
     * @param attributeDefID
     *            The attributeDefID to set.
     */
    public void setAttributeDefID(Long attributeDefID) {
        this.attributeDefID = attributeDefID;
    }

    /**
     * @return Returns the objectID.
     */
    public Long getObjectID() {
        return objectID;
    }

    /**
     * @param objectID
     *            The objectID to set.
     */
    public void setObjectID(Long objectID) {
        this.objectID = objectID;
    }

    /**
     * @return Returns the value.
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            The value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return Returns the data.
     */
    public String getData() {
        return data;
    }

    /**
     * @param data
     *            The data to set.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return Returns the dateValue.
     */
    public Date getDateValue() {
        return dateValue;
    }

    /**
     * @param dateValue
     *            The dateValue to set.
     */
    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    /**
     * @return Returns the listValues.
     */
    public ListValueBean getListValues() {
        return listValues;
    }

    /**
     * @param listValues
     *            The listValues to set.
     */
    public void setListValues(ListValueBean listValues) {
        this.listValues = listValues;
    }

    /**
     * @return Returns the listValueID.
     */
    public Long getListValueID() {
        return listValueID;
    }

    /**
     * @param listValueID
     *            The listValueID to set.
     */
    public void setListValueID(Long listValueID) {
        this.listValueID = listValueID;
    }

    /**
     * @return Returns the attributeDef.
     */
    public AttributeDefBean getAttributeDef() {
        return attributeDef;
    }

    /**
     * @param attributeDef
     *            The attributeDef to set.
     */
    public void setAttributeDef(AttributeDefBean attributeDef) {
        this.attributeDef = attributeDef;
    }

    /**
     * @return Returns the booValue.
     */
    public boolean isBooValue() {
        if (StringUtils.isNotBlank(value)) {
            booValue = Boolean.valueOf(value);
        }
        return booValue;
    }

    /**
     * @param booValue
     *            The booValue to set.
     */
    public void setBooValue(boolean booValue) {
        this.booValue = booValue;
        value = String.valueOf(booValue);
    }

    /**
     * @return Returns the attributeGroupID.
     */
    public Long getAttributeGroupID() {
        return attributeGroupID;
    }

    /**
     * @param attributeGroupID
     *            The attributeGroupID to set.
     */
    public void setAttributeGroupID(Long attributeGroupID) {
        this.attributeGroupID = attributeGroupID;
    }

    /**
     * @return Returns the selectedValues.
     */
    public List<Long> getSelectedValues() {
        if (StringUtils.isNotBlank(getValue())) {
            StringTokenizer tokens = new StringTokenizer(value, ",");
            while (tokens.hasMoreTokens()) {
                selectedValues.add(Long.parseLong(tokens.nextToken()));
            }
        }
        return selectedValues;
    }

    /**
     * @param selectedValues
     *            The selectedValues to set.
     */
    public void setSelectedValues(List<Long> selectedValues) {
        this.selectedValues = selectedValues;
        if (selectedValues != null) {
            StringBuilder builder = new StringBuilder();
            Iterator<Long> iterator = selectedValues.iterator();
            boolean first = true;
            while (iterator.hasNext()) {
                if (!first) {
                    builder.append(",");
                }
                builder.append(Long.toString(iterator.next()));
                first = false;
            }
            value = builder.toString();
        }
    }

    /**
     * @return
     */
    public String getDisplayValue() {
        String result = null;
        if (attributeDef.isSingleSelectBoo() || attributeDef.isMultiSelectBoo()) {
            Map<Long, Long> selectedValues = new HashMap<Long, Long>();
            if (StringUtils.isNotBlank(getValue())) {
                StringTokenizer tokens = new StringTokenizer(value, ",");
                while (tokens.hasMoreTokens()) {
                    Long temp = Long.parseLong(tokens.nextToken());
                    selectedValues.put(temp, temp);
                }
                StringBuilder builder = new StringBuilder();
                List<ListValueBean> listValues = attributeDef
                        .getListValueList();
                if (listValues != null) {
                    Iterator<ListValueBean> iterator = listValues.iterator();
                    boolean first = true;
                    while (iterator.hasNext()) {
                        ListValueBean listValueBean = iterator.next();
                        Long temp = listValueBean.getListValueID();
                        if (selectedValues.containsKey(temp)) {
                            if (!first) {
                                builder.append(",");
                            }
                            builder.append(listValueBean.getValue());
                            first = false;
                        }
                    }
                }
                result = builder.toString();
            }
        }
        else if (attributeDef.isBooleanBoo()) {
            if (StringUtils.equals(value, Boolean.TRUE.toString())) {
                result = MatrixConstants.ANSWER_YES;
            }
            else {
                result = MatrixConstants.ANSWER_NO;
            }
        }
        return result;
    }

    /**
     * @return Returns the multiTextValues.
     */
    public List<String> getMultiTextValues() {
        if (StringUtils.isNotBlank(getValue())) {
            multiTextValues = new ArrayList<String>();
            StringTokenizer tokens = new StringTokenizer(value, ",");
            while (tokens.hasMoreTokens()) {
                multiTextValues.add(tokens.nextToken());
            }
        }
        return multiTextValues;
    }

    /**
     * @param multiTextValues
     *            The multiTextValues to set.
     */
    public void setMultiTextValues(List<String> multiTextValues) {
        this.multiTextValues = multiTextValues;
        if (multiTextValues != null) {
            StringBuilder builder = new StringBuilder();
            Iterator<String> iterator = multiTextValues.iterator();
            boolean first = true;
            while (iterator.hasNext()) {
                if (!first) {
                    builder.append(",");
                }
                builder.append(iterator.next());
                first = false;
            }
            value = builder.toString();
        }
    }

    /**
     * @return
     */
    public boolean isHasMultiTextValues() {
        return multiTextValues.size() > 0;
    }

    /**
     * @param value
     */
    public void add2MultiTextValues(String value) {
        multiTextValues.add(value);
        if (multiTextValues != null) {
            StringBuilder builder = new StringBuilder();
            Iterator<String> iterator = multiTextValues.iterator();
            boolean first = true;
            while (iterator.hasNext()) {
                if (!first) {
                    builder.append(",");
                }
                builder.append(iterator.next());
                first = false;
            }
            this.value = builder.toString();
        }
    }

    /**
     * @return Returns the selectedMultiTextValue.
     */
    public String getSelectedMultiTextValue() {
        return selectedMultiTextValue;
    }

    /**
     * @param selectedMultiTextValue
     *            The selectedMultiTextValue to set.
     */
    public void setSelectedMultiTextValue(String selectedMultiTextValue) {
        this.selectedMultiTextValue = selectedMultiTextValue;
    }

    /**
     * remove the selected from list
     */
    public void removeFromMultiTextValues() {
        if (StringUtils.isNotBlank(selectedMultiTextValue)) {
            if (multiTextValues != null && multiTextValues.size() > 0) {
                multiTextValues.remove(selectedMultiTextValue);
                setMultiTextValues(multiTextValues);
            }
        }
    }

    /**
     * @return Returns the multiTextValue.
     */
    public String getMultiTextValue() {
        return multiTextValue;
    }

    /**
     * @param multiTextValue
     *            The multiTextValue to set.
     */
    public void setMultiTextValue(String multiTextValue) {
        this.multiTextValue = multiTextValue;
    }
    //Code Changes for BEC-1797
    public String getInternalCode() {
    	
        String result = null;
        
            Map<Long, Long> selectedValues = new HashMap<Long, Long>();
            if (StringUtils.isNotBlank(getValue())) {
                StringTokenizer tokens = new StringTokenizer(value, ",");
                while (tokens.hasMoreTokens()) {
                    Long temp = Long.parseLong(tokens.nextToken());
                    selectedValues.put(temp, temp);
                }
                StringBuilder builder = new StringBuilder();
                List<ListValueBean> listValues = attributeDef
                        .getListValueList();
                if (listValues != null) {
                    Iterator<ListValueBean> iterator = listValues.iterator();
                    boolean first = true;
                    while (iterator.hasNext()) {
                        ListValueBean listValueBean = iterator.next();
                        Long temp = listValueBean.getListValueID();
                        if (selectedValues.containsKey(temp)) {
                            if (!first) {
                                builder.append(",");
                            }
                            builder.append(getValueOfInternalCode(listValueBean.getInternalCode()));
                            first = false;
                        }
                    }
                }
                result = builder.toString();
            }
        return result;
    }
    private String getValueOfInternalCode(String internalCode) {
    	if(internalCode!=null){
			return internalCode.trim();
		}
		return "";
    }
    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(AttributeValueBean o) {
        return getAttributeDef().compareTo(o.getAttributeDef());
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
