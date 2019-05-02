/**
 * 
 */
package com.bectran.b2b.customer.beans;

import java.util.List;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.supplier.beans.GroupCustomCreditAppListContentBean;
import com.bectran.b2b.supplier.beans.GroupCustomCreditAppModelBaseBean;

/**
 * @author LOUIS IFEGUNI Date: Apr 5, 2012 / 2:51:16 PM
 */
public class CustomCreditAppValuesBaseBean
        extends GroupCustomCreditAppModelBaseBean {
    private Long requestId;
    private Long questionId;
    private Long answerId;
    private String value = "";
    private String encSalt = "";
    private String question = "";
    private String ansInputId;
    private String inputError = "";
    //
    private boolean errorPresent;
    private boolean hasPredefinedList;
    //
    private List<GroupCustomCreditAppListContentBean> predefinedListContent;

    //
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnsInputId() {
        return ansInputId;
    }

    public void setAnsInputId(String ansInputId) {
        this.ansInputId = ansInputId;
    }

    public String getInputError() {
        return inputError;
    }

    public void setInputError(String inputError) {
        this.inputError = inputError;
    }

    public boolean isErrorPresent() {
        return errorPresent;
    }

    public void setErrorPresent(boolean errorPresent) {
        this.errorPresent = errorPresent;
    }

    public boolean isHasPredefinedList() {
        return hasPredefinedList;
    }

    public void setHasPredefinedList(boolean hasPredefinedList) {
        this.hasPredefinedList = hasPredefinedList;
    }

    public List<GroupCustomCreditAppListContentBean> getPredefinedListContent() {
        return predefinedListContent;
    }

    public void setPredefinedListContent(List<GroupCustomCreditAppListContentBean> predefinedListContent) {
        this.predefinedListContent = predefinedListContent;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public boolean isFieldIsRquired() {
        return this.getRequired().trim().equals(MatrixConstants.ANSWER_YES)
                ? true : false;
    }

    public boolean isFieldIsEncryptionType() {
        return this.getEncryptData().trim().equals(MatrixConstants.ANSWER_YES)
                ? true : false;
    }

    public String getEncSalt() {
        return encSalt;
    }

    public void setEncSalt(String encSalt) {
        this.encSalt = encSalt;
    }
}
