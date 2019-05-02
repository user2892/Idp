/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.b2b.customer.beans;

import org.apache.commons.lang3.StringUtils;

import com.bectran.attribute.beans.AttributeValueBean;

/**
 * @author shanmu
 * @date 24-May-2016 1:24:46 pm
 */
public class CustomAppAttrValueBean extends AttributeValueBean {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -6341204235462102399L;

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>CustomAppAttrValueDraftBean</code>
     */
    public CustomAppAttrValueBean() {
        super();
    }
    // ---------------------------------------------------------- Public Methods
    /**
     * @return
     */
    public boolean hasValue(){
        if(this.getAttributeDef().isDateBoo()){
            return (getDateValue() !=null);
        }else {
            return StringUtils.isNotBlank(getValue());
        }
    }
    
    public String getValueCode(){
    	String valueCode="";
    	//If attribute type is List the we need to check List value is having internal code
        if((this.getAttributeDef().isSingleSelectBoo() || this.getAttributeDef().isMultiSelectBoo()) 
        		&& StringUtils.isNotBlank(this.getInternalCode())){
        	return this.getInternalCode();
        }
        
        //If the attribute type other than list we need send  attribute internal code
        String attrInternalCode = this.getAttributeDef().getInternalCode();
        valueCode = StringUtils.isNotBlank(attrInternalCode) ? attrInternalCode : this.getId().toString();
        
        return valueCode;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
