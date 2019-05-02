/**
 * 
 */
package com.bectran.b2b.enterprise.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.bectran.b2b.constants.MatrixConstants;

/**
 * @author Louis Ifeguni Jan 20, 2016:3:06:58 PM
 */
public class EnterpriseAccountByGroupBean extends EnterpriseAccountBaseBean {
    private Long supplierId;
    private Set<EnterpriseIntgServiceBean> enterpriseIntgServiceBeans;
    private String paramValue; 
    public EnterpriseAccountByGroupBean() {
    }

    //
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * @return Returns the enterpriseIntgServiceBeans.
     */
    public Set<EnterpriseIntgServiceBean> getEnterpriseIntgServiceBeans() {
        return enterpriseIntgServiceBeans;
    }

    /**
     * @param enterpriseIntgServiceBeans
     *            The enterpriseIntgServiceBeans to set.
     */
    public void setEnterpriseIntgServiceBeans(Set<EnterpriseIntgServiceBean> enterpriseIntgServiceBeans) {
        this.enterpriseIntgServiceBeans = enterpriseIntgServiceBeans;
    }

    /**
     * @return
     */
    public List<EnterpriseIntgServiceBean> getEnterpriseIntgServiceBeansList() {
        List<EnterpriseIntgServiceBean> result = new ArrayList<EnterpriseIntgServiceBean>();
        if (enterpriseIntgServiceBeans != null) {
            result = new ArrayList<EnterpriseIntgServiceBean>(
                    enterpriseIntgServiceBeans);
            Collections.sort(result);
        }
        return result;
    }

    private EnterpriseIntgServiceBean getIntgServiceBean(String intgServiceType) {
        EnterpriseIntgServiceBean intgSvcBean = null;
        List<EnterpriseIntgServiceBean> result = getEnterpriseIntgServiceBeansList();
        if (result != null) {
            for (EnterpriseIntgServiceBean enterpriseIntgServiceBean : result) {
                if (StringUtils.equals(
                        enterpriseIntgServiceBean.getIntegrationServiceType(),
                        intgServiceType)) {
                    intgSvcBean = enterpriseIntgServiceBean;
                    break;
                }
            }
        }
        return intgSvcBean;
    }

    /**
     * @return
     */
    public EnterpriseIntgServiceBean getIntgWsService() {
        return getIntgServiceBean(MatrixConstants.ENTERPRISE_INTEGRATION_SERVICE_TYPE_WEBSERVICE);
    }

    /**
     * @return
     */
    public EnterpriseIntgServiceBean getIntgSftpService() {
        return getIntgServiceBean(MatrixConstants.ENTERPRISE_INTEGRATION_SERVICE_TYPE_SECURED_FTP_XML);
    }

    /**
     * @return
     */
    public EnterpriseIntgServiceBean getIntgIdpService() {
        return getIntgServiceBean(MatrixConstants.ENTERPRISE_INTEGRATION_SERVICE_TYPE_IDP);
    }

    /**
     * @return Returns the paramValue.
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     * @param paramValue The paramValue to set.
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }
}
