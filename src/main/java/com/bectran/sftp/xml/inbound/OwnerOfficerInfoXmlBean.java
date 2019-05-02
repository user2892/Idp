/**
 * 
 */
package com.bectran.sftp.xml.inbound;

import javax.xml.bind.annotation.XmlType;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 3, 2013 : 1:52:26 PM
 */
@XmlType(propOrder = {"salutation", "firstName", "lastName", "phone",
        "persTitle"})
public class OwnerOfficerInfoXmlBean {
    //
    private String salutation;
    private String firstName;
    private String lastName;
    private String phone;
    private String persTitle;

    //
    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersTitle() {
        return persTitle;
    }

    public void setPersTitle(String persTitle) {
        this.persTitle = persTitle;
    }
    //
}
