/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.sftp.xml.inbound.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bectran.b2b.crol.beans.CreditRefEvalBean;
import com.bectran.b2b.crol.beans.RefResultBean;
import com.bectran.b2b.customer.beans.RefForRequestBean;
import com.bectran.matrix.utils.FormatUtility;
import com.bectran.sftp.xml.inbound.CreditRefAttrInfoXmlBean;
import com.bectran.sftp.xml.inbound.CreditRefInfoXmlBean;

/**
 * @author Shanmu
 * @date Nov 23, 2015 9:10:09 PM
 */
public class CreditRefInfoLoad extends CustomerDataLoadBase {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>CreditRefInfoLoad</code>
     */
    public CreditRefInfoLoad() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @param refForRequestSet
     * @param refResults
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<CreditRefInfoXmlBean> initializeTrxnBean(Set<RefForRequestBean> refForRequestSet,
                                                         Map<Long, RefResultBean> refResults,
                                                         String currency) {
        List<CreditRefInfoXmlBean> result = new ArrayList<CreditRefInfoXmlBean>();
        if (refForRequestSet != null) {
            for (RefForRequestBean refForRequestBean : refForRequestSet) {
                CreditRefInfoXmlBean bean = new CreditRefInfoXmlBean();
                bean.setCompanyName(getValueForXml(
                        refForRequestBean.getReferee().getName()));
                bean.setAddressLineOne(getValueForXml(
                        refForRequestBean.getReferee().getAddress1()));
                bean.setAddressLineTwo(getValueForXml(
                        refForRequestBean.getReferee().getAddress2()));
                bean.setCity(getValueForXml(
                        refForRequestBean.getReferee().getCity()));
                bean.setState(getValueForXml(
                        refForRequestBean.getReferee().getState()));
                bean.setCountryId(getValueForXml(
                        refForRequestBean.getReferee().getCountry()));
                bean.setZipCode(getValueForXml(
                        refForRequestBean.getReferee().getZip()));
                bean.setFirstName(getValueForXml(
                        refForRequestBean.getRefereeContact().getFirstName()));
                bean.setLastName(getValueForXml(
                        refForRequestBean.getRefereeContact().getLastName()));
                bean.setEmail(getValueForXml(
                        refForRequestBean.getRefereeContact().getEmail()));
                bean.setFax(getValueForXml(
                        refForRequestBean.getRefereeContact().getFax()));
                bean.setPhone(getValueForXml(
                        refForRequestBean.getRefereeContact().getPhone()));
                bean.setReferenceType(
                        getValueForXml(refForRequestBean.getReferenceType()));
                bean.setInternalAcctNum(
                        getValueForXml(refForRequestBean.getInternalAcctNum()));
                // String accountType = refForRequestBean.getAccountType();
                // if (StringUtils.isBlank(accountType)) {
                // bean.setAccountType("");
                // }
                // else {
                bean.setAccountType(
                        getValueForXml(refForRequestBean.getAccountType()));
                // }
                bean.setStatus(
                        getValueForXml(refForRequestBean.getCallStatus()));
                if (refResults != null) {
                    RefResultBean refResultBean = refResults
                            .get(refForRequestBean.getId());
                    if (refResultBean != null) {
                        List<CreditRefAttrInfoXmlBean> creditRefAttrInfoList = loadAttributes(
                                refResultBean.getCreditRef().getScoreSheet(),
                                currency);
                        if (creditRefAttrInfoList != null) {
                            bean.setCreditRefAttrInfoList(
                                    creditRefAttrInfoList);
                        }
                    }
                }
                result.add(bean);
            }
        }
        return result;
    }

    /**
     * @param scoreSheet
     * @param currency
     * @return
     */
    private List<CreditRefAttrInfoXmlBean> loadAttributes(List<CreditRefEvalBean> scoreSheet,
                                                          String currency) {
        List<CreditRefAttrInfoXmlBean> attributes = new ArrayList<CreditRefAttrInfoXmlBean>();
        if (scoreSheet != null) {
            for (CreditRefEvalBean creditRefEvalBean : scoreSheet) {
                CreditRefAttrInfoXmlBean bean = new CreditRefAttrInfoXmlBean();
                bean.setAttribute(creditRefEvalBean.getAttribute());
                if (creditRefEvalBean.isAlphatype()) {
                    bean.setValue(getValueForXml(
                            creditRefEvalBean.getAlphaAnsName()));
                }
                else {
                    bean.setValue(getValueForXml(currency + " "
                            + String.valueOf(FormatUtility.formatNumber2Digit(
                                    creditRefEvalBean.getNumericValue()))));
                }
                bean.setWeaknessFactor(getValueForXml(
                        String.valueOf(creditRefEvalBean.getWeakFactor())));
                attributes.add(bean);
            }
        }
        return attributes;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
