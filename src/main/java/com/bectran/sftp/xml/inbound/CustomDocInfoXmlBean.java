/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.sftp.xml.inbound;

import javax.xml.bind.annotation.XmlType;

/**
 * @author Shanmu
 * @date Nov 23, 2015 8:32:08 PM
 */
@XmlType(propOrder = {"id", "name", "date", "documentType", "docImageUrl"})
public class CustomDocInfoXmlBean {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String id;
    private String name;
    private String date;
    private String documentType;
    private String docImageUrl;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>CustomDocInfoXmlBean</code>
     */
    public CustomDocInfoXmlBean() {
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
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the date.
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date
     *            The date to set.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return Returns the documentType.
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * @param documentType
     *            The documentType to set.
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * @return Returns the docImageUrl.
     */
    public String getDocImageUrl() {
        return docImageUrl;
    }

    /**
     * @param docImageUrl
     *            The docImageUrl to set.
     */
    public void setDocImageUrl(String docImageUrl) {
        this.docImageUrl = docImageUrl;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
