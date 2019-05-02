/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.b2b.enterprise.beans;

import org.apache.commons.lang3.StringUtils;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author shanmu
 * @date 01-Jun-2016 12:00:27 am
 */
public class EnterpriseIntgServiceBean extends EnterpriseAccountByGroupBean
        implements Comparable<EnterpriseIntgServiceBean> {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long headerId;
    private EnterpriseIntgIdpServiceBean idpServiceBean;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>EnterpriseIntgAccountByGroupBean</code>
     */
    public EnterpriseIntgServiceBean() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
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

    /**
     * @return Returns the idpServiceBean.
     */
    public EnterpriseIntgIdpServiceBean getIdpServiceBean() {
        return idpServiceBean;
    }

    /**
     * @param idpServiceBean
     *            The idpServiceBean to set.
     */
    public void setIdpServiceBean(EnterpriseIntgIdpServiceBean idpServiceBean) {
        this.idpServiceBean = idpServiceBean;
    }

    /**
     * @return
     */
    public boolean isIntgWsService() {
        return StringUtils.equals(
                MatrixConstants.ENTERPRISE_INTEGRATION_SERVICE_TYPE_WEBSERVICE,
                getIntegrationServiceType());
    }

    /**
     * @return
     */
    public boolean isIntgSftpService() {
        return StringUtils
                .equals(MatrixConstants.ENTERPRISE_INTEGRATION_SERVICE_TYPE_SECURED_FTP_XML,
                        getIntegrationServiceType());
    }

    /**
     * @return
     */
    public boolean isIntgIdpService() {
        return StringUtils.equals(
                MatrixConstants.ENTERPRISE_INTEGRATION_SERVICE_TYPE_IDP,
                getIntegrationServiceType());
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(EnterpriseIntgServiceBean o) {
        return getHeaderId().compareTo(o.getHeaderId());
    }
    
    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EnterpriseIntgServiceBean other = (EnterpriseIntgServiceBean) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        }
        else if (!getId().equals(other.getId()))
            return false;
        return true;
    }
    
    
}
