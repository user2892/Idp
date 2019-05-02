package com.bectran.crol.eval.beans;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.bectran.b2b.crol.constants.CrolConstants;
import com.bectran.b2b.crol.constants.ModelConstants;
import com.bectran.b2b.eref.helper.XmlAttributeAnswerBean;

/**
 * @author Louis Ifeguni Oct 28, 2006: 1:08:12 PM
 */
public class AttributeBean extends ModelBaseBean {
    //
    // private String shortNameWithoutNS;
    protected double weight;
    protected double percentWeight;
    protected String dataType = ModelConstants.VALUE_TYPE_ALPHANUM;
    protected String polModelId = "";
    protected String modelId = "";
    protected String modelName = "";
    protected String compFlag = CrolConstants.NO;
    //
    protected List attributeList = null;
    protected List policyModelList = null;
    private String disqualifierType = "";
    /*
     * hibernate mapping
     */
    private Set answerSet;
    private List<XmlAttributeAnswerBean> answerInList;
    private Long id;

    /**
     * DEFAULT CONSTRUCTOR
     */
    public AttributeBean() {
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

    public boolean isDuplicateShortName(List models, String shortname_) {
        String sname_ = null;
        for (Iterator i = models.iterator(); i.hasNext();) {
            AttributeBean model = (AttributeBean) i.next();
            sname_ = model.getShortName();
            if (sname_.equalsIgnoreCase(shortname_)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param string
     */
    public void setWeight(double d) {
        weight = d;
    }

    /**
     * @return Returns the percentWeight.
     */
    public double getPercentWeight() {
        return percentWeight;
    }

    /**
     * @param percentWeight
     *            The percentWeight to set.
     */
    public void setPercentWeight(double percentWeight) {
        this.percentWeight = percentWeight;
    }

    /**
     * @return
     */
    public List getAttributeList() {
        return attributeList;
    }

    /**
     * @return
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @return
     */
    public List getPolicyModelList() {
        return policyModelList;
    }

    /**
     * @return
     */
    public String getPolModelId() {
        return polModelId;
    }

    /**
     * @param list
     */
    public void setAttributeList(List list) {
        attributeList = list;
    }

    /**
     * @param string
     */
    public void setDataType(String string) {
        dataType = string;
    }

    /**
     * @param list
     */
    public void setPolicyModelList(List list) {
        policyModelList = list;
    }

    /**
     * @param string
     */
    public void setPolModelId(String string) {
        polModelId = string;
    }

    /**
     * @return
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * @param string
     */
    public void setModelId(String string) {
        modelId = string;
    }

    /**
     * @return Returns the compFlag.
     */
    public String getCompFlag() {
        return compFlag;
    }

    /**
     * @param compFlag
     *            The compFlag to set.
     */
    public void setCompFlag(String compFlag) {
        this.compFlag = compFlag;
    }

    /**
     * @return
     */
    public String getDisqualifierType() {
        return disqualifierType;
    }

    /**
     * @param string
     */
    public void setDisqualifierType(String string) {
        disqualifierType = string;
    }

    /**
     * @return Returns the modelName.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @param modelName
     *            The modelName to set.
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * @return Returns the answerInList.
     */
    public List<XmlAttributeAnswerBean> getAnswerInList() {
        return answerInList;
    }

    /**
     * @param answerInList
     *            The answerInList to set.
     */
    public void setAnswerInList(List<XmlAttributeAnswerBean> answerInList) {
        this.answerInList = answerInList;
    }

    /**
     * @return Returns the answerSet.
     */
    public Set getAnswerSet() {
        return answerSet;
    }

    /**
     * @param answerSet
     *            The answerSet to set.
     */
    public void setAnswerSet(Set answerSet) {
        this.answerSet = answerSet;
    }

}
