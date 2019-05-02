/**
 * 
 */
package com.bectran.b2b.supplier.blo;

import java.util.List;
import java.util.Map;

import com.bectran.b2b.constants.BecOptionalSubConstants;
import com.bectran.b2b.supplier.beans.BecOptionalSubBean;
import com.bectran.b2b.supplier.beans.GroupAccountBean;
import com.bectran.b2b.supplier.dao.GroupAccountDAO;

/**
 * @author LOUIS IFEGUNI
 * @date Jan 11, 2012 : 6:57:06 PM
 */
public class SubsFeatureControlBLO {
    /*
     * private static void updateOptionalPkg(SubsFeatureControlBean bean,
     * Map<String, BecOptionalSubBean> mapOfOptionalSub, Long supplierId) throws
     * DataAccessException{ //Extended document management BecOptionalSubBean
     * sub = (BecOptionalSubBean)mapOfOptionalSub.get(BecOptionalSubConstants.
     * EXTENDED_DOC_MGT); bean.setShowExtendedDocMgt(optionStatus(sub)); //
     * //Custom Scoring Model sub =
     * (BecOptionalSubBean)mapOfOptionalSub.get(BecOptionalSubConstants.
     * CUSTOM_SCORING_MODEL); bean.setShowCustomScoringModel(optionStatus(sub));
     * // //credit review Non-Enterprise sub =
     * (BecOptionalSubBean)mapOfOptionalSub.get(BecOptionalSubConstants.
     * CREDIT_LIMIT_REVIEW_NE);
     * bean.setShowCreditLimitReviewNE(optionStatus(sub)); // //Account review
     * Non-Enterprise sub =
     * (BecOptionalSubBean)mapOfOptionalSub.get(BecOptionalSubConstants.
     * ACCOUNT_REVIEW); bean.setShowAccountReview(optionStatus(sub)); //
     * //INDUSTRY GROUP sub =
     * (BecOptionalSubBean)mapOfOptionalSub.get(BecOptionalSubConstants.
     * INDUSTRY_GROUP); bean.setShowIndustryGroup(optionStatus(sub)); // //CS
     * PACK sub =
     * (BecOptionalSubBean)mapOfOptionalSub.get(BecOptionalSubConstants.CS_PACK)
     * ; bean.setShowCsPack(optionStatus(sub)); // //CUSTOM CREDIT APP sub =
     * (BecOptionalSubBean)mapOfOptionalSub.get(BecOptionalSubConstants.
     * CUSTOM_CREDIT_APP); bean.setShowCustomCreditApp(optionStatus(sub)); //
     * //MULTI-BUSINESS SUPPORT sub =
     * (BecOptionalSubBean)mapOfOptionalSub.get(BecOptionalSubConstants.
     * MULTI_BUSINESS_SUPPORT);
     * bean.setShowMultiBusinessGroup(optionStatus(sub)); // //ENTERPRISE
     * INTEGRATION sub =
     * (BecOptionalSubBean)mapOfOptionalSub.get(BecOptionalSubConstants.
     * ENTERPRISE_INTEGRATION);
     * bean.setShowEnterpriseIntegration(optionStatus(sub)); // //CREDIT BUREAU
     * MANUAL sub =
     * (BecOptionalSubBean)mapOfOptionalSub.get(BecOptionalSubConstants.
     * CREDIT_BUREAU_MANUAL); bean.setShowBureauManual(optionStatus(sub)); //
     * //CREDIT BUREAU AUTO sub =
     * (BecOptionalSubBean)mapOfOptionalSub.get(BecOptionalSubConstants.
     * CREDIT_BUREAU_AUTO); bean.setShowBureauAuto(optionStatus(sub)); //
     * //OPERATIONS MANAGEMNT sub =
     * (BecOptionalSubBean)mapOfOptionalSub.get(BecOptionalSubConstants.
     * OPERATIONS_MANAGEMENT); bean.setShowOpsMgt(optionStatus(sub)); //
     * //ELECTRONIC FAX sub =
     * (BecOptionalSubBean)mapOfOptionalSub.get(BecOptionalSubConstants.
     * ELECTRONIC_FAX); bean.setShowEFAX(optionStatus(sub)); }
     */
    public boolean hasMultipleGroup(Long supplierId) throws Exception {
        Map<String, BecOptionalSubBean> mapOfOptionalSub = BecOptionalSubBLO
                .mapOfSubPkg(supplierId);
        BecOptionalSubBean sub = mapOfOptionalSub
                .get(BecOptionalSubConstants.MULTI_BUSINESS_SUPPORT);
        if (optionStatus(sub)) {
            // check for groups
            List<GroupAccountBean> list = new GroupAccountDAO()
                    .findGroupsForSupplier(supplierId.longValue());
            if (list != null && list.size() > 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean optionStatus(BecOptionalSubBean sub) {
        if (sub == null) {
            return false;
        }
        if (sub.isActiveStatus() && !sub.isExpired()) {
            return true;
        }
        return false;
    }
}
