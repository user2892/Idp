/**
 * 
 */
package com.bectran.b2b.supplier.beans;

import java.io.Serializable;
import java.util.Date;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author LOUIS IFEGUNI May 30, 2011 5:58:57 PM
 */
public class SignupExtBean implements Serializable{
    private static final long serialVersionUID = -6098129620077907854L;
    //
    private String link = "";
    private Long id;
    private String numberOfCreditApp;
    private String userId;
    private Date dateCreated;
    private String activated = MatrixConstants.ANSWER_NO;

    //
    public SignupExtBean() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberOfCreditApp() {
        return numberOfCreditApp;
    }

    public void setNumberOfCreditApp(String numberOfCreditApp) {
        this.numberOfCreditApp = numberOfCreditApp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDateCreated() {
        return (Date) (dateCreated == null ? null : dateCreated.clone());
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = (Date) (dateCreated == null ? null : dateCreated.clone());
    }

    public String getActivated() {
        return activated;
    }

    public void setActivated(String activated) {
        this.activated = activated;
    }
}
