package com.bectran.b2b.crol.blo;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.bectran.b2b.bridge.ops.B2BridgeBLO;
import com.bectran.b2b.crol.beans.CreditRefBean;
import com.bectran.b2b.crol.beans.CreditRefEvalBean;
import com.bectran.b2b.crol.beans.CreditRefMetricResultBean;
import com.bectran.b2b.crol.beans.RefRequestBridgeBean;
import com.bectran.b2b.crol.beans.TradeRefFormBean;
import com.bectran.b2b.crol.constants.CrolConstants;
import com.bectran.b2b.crol.dao.CreditRefDAO;
import com.bectran.b2b.customer.beans.RefForRequestBean;
import com.bectran.b2b.customer.dao.RefForRequestDAO;
import com.bectran.b2b.eref.helper.RangeRefAnswerModelBean;
import com.bectran.b2b.eref.helper.RangeRefAnswerModelHelper;
import com.bectran.b2b.eref.helper.XmlDataInputHelper;
import com.bectran.b2b.supplier.dao.CreditReferenceDAO;
import com.bectran.matrix.framework.exception.DataAccessException;

/**
 * @author LOUIS IFEGUNI
 */
public class CreditRefBLO {
    public static List<CreditRefEvalBean> getScoreSheet(long referenceId)
            throws DataAccessException {
        List<CreditRefEvalBean> scoreSheet = CreditRefDAO
                .getScoreSheet(referenceId);
        if (scoreSheet == null || scoreSheet.size() < 1) {
            // implies no score scheet for customer
            return null;
        }
        /* DETERMINE MAX ATTRIBUTE WEIGHT */
        Collections.sort(scoreSheet,
                CreditRefEvalBean.DESCENDING_ORDER_ATTRWEIGHT);
        double maxweight = ((CreditRefEvalBean) scoreSheet.get(0))
                .getAttrWeight();
        /*
         * weakness computed as - ((maxscore[5] - answer-score)/maxscore[5])x
         * 100 x attribute-weight/maxweight
         */
        double weakness = 0;
        for (Iterator i = scoreSheet.iterator(); i.hasNext();) {
            CreditRefEvalBean bean = (CreditRefEvalBean) i.next();
            weakness = ((5d - bean.getAnsScore()) / 5d) * 100d
                    * (bean.getAttrWeight() / maxweight);
            bean.setWeakFactor((int) Math.round(weakness));
            // System.out.println(bean.getAlphaAnsName()+",score
            // "+bean.getAnsScore()+",factor: "+bean.getWeakFactor()+", weight
            // "+bean.getAttrWeight());
            /// System.out.println("bean.getAttrWeight() ----
            // "+bean.getAttrWeight());
            // System.out.println("weakness ---- "+weakness);
        }
        /* sort score sheet by weak factor */
        Collections.sort(scoreSheet,
                CreditRefEvalBean.DESCENDING_ORDER_WEAKFACTOR);
        return scoreSheet;
    }

    /**
     * LOUIS ---2/28/11
     * 
     * @param requestId
     * @return
     * @throws DataAccessException
     */
    public static CreditRefMetricResultBean computeRefMetrics(Long requestId,
                                                              Map<String, String> paymentIndexMap)
            throws Exception {
        //
        List<RefForRequestBean> refsForReqList = RefForRequestDAO
                .refsForRequest(requestId.longValue());
        //
        List<RangeRefAnswerModelBean> hibalAnsModelList = RangeRefAnswerModelHelper
                .getHighBalTradeModel();
        Map<String, RangeRefAnswerModelBean> mapOfHiBalModel = RangeRefAnswerModelHelper
                .mapOfModel(hibalAnsModelList);
        double totalIndex = 0;
        double count = 0;
        double indexValue = 0;
        /*
         * ADDED: May 1, 2011 -Louis Ifeguni
         */
        double maxCreditLimit = 0;
        double maxBalanceOutstanding = 0;
        double maxBalancePastDue = 0;
        double avgCreditLimit = 0;
        double totalCreditLimit = 0;
        double paymentsWithTerms = 0;
        double slowNegativePayment = 0;
        // String avgHighBalRange=null;
        double totalHighBalRangeValue = 0;
        int countTerms = 0;
        int countSlowPmt = 0;
        boolean hasMetricsResult = false;
        for (Iterator<RefForRequestBean> i = refsForReqList.iterator(); i
                .hasNext();) {
            RefForRequestBean bean = (RefForRequestBean) i.next();
            //
            RefRequestBridgeBean bridge = B2BridgeBLO.getRequestBridge(bean);
            if (bridge == null || bridge.getCrolRefReqId() == null) {
                continue;
            }
            CreditRefBean cref = CreditReferenceDAO
                    .getCreditReference(bridge.getCrolRefReqId().longValue());
            if (cref == null) {
                continue;
            }
            if (cref.isTradeReference()) {
                TradeRefFormBean trade = CreditRefDAO
                        .getTradeReference(cref.getId().longValue());
                if (trade != null) {
                    String valString = (String) paymentIndexMap
                            .get(trade.getPaymentExperienceCode().trim());
                    count = count + 1;
                    try {
                        indexValue = Double.parseDouble(valString);
                        // System.out.println("======indexValue========>>
                        // "+indexValue );
                    }
                    catch (Exception e) {
                        indexValue = 10;// default value
                    }
                    //
                    if (indexValue <= 70) {
                        countSlowPmt = countSlowPmt + 1;
                    }
                    //
                    totalIndex = totalIndex + indexValue;
                    // System.out.println("======totalIndex========>>
                    // "+totalIndex );
                    totalHighBalRangeValue = totalHighBalRangeValue
                            + RangeRefAnswerModelHelper.getInternalValue(
                                    trade.getHighestBalanceCode(),
                                    mapOfHiBalModel);
                    // additional metrics
                    maxCreditLimit = trade.getCreditLimit() > maxCreditLimit
                            ? trade.getCreditLimit() : maxCreditLimit;
                    maxBalanceOutstanding = trade
                            .getBalanceOutstanding() > maxBalanceOutstanding
                                    ? trade.getBalanceOutstanding()
                                    : maxBalanceOutstanding;
                    maxBalancePastDue = trade
                            .getBalancePastDue() > maxBalancePastDue
                                    ? trade.getBalancePastDue()
                                    : maxBalancePastDue;
                    //
                    totalCreditLimit = totalCreditLimit
                            + trade.getCreditLimit();
                    //
                    if (!trade.getCreditTermsCode().trim()
                            .equals(CrolConstants.PAYMENT_TERM_COD)) {
                        countTerms = countTerms + 1;
                    }
                    hasMetricsResult = true;
                }
            }
        }
        avgCreditLimit = count > 0 ? totalCreditLimit / count : 0;
        paymentsWithTerms = count > 0 ? countTerms / count : 0;
        slowNegativePayment = count > 0 ? countSlowPmt / count : 0;
        double avgHiBalValue = count > 0 ? totalHighBalRangeValue / count : 0;
        RangeRefAnswerModelBean avgHighBalBean = RangeRefAnswerModelHelper
                .getAnswerModel(avgHiBalValue, hibalAnsModelList);
        // System.out.println("-maxCreditLimit--"+maxCreditLimit);
        // System.out.println("-maxBalanceOutstanding--"+maxBalanceOutstanding);
        // System.out.println("-maxBalancePastDue--"+maxBalancePastDue);
        // System.out.println("-avgCreditLimit-->>"+avgCreditLimit);
        // System.out.println("-paymentsWithTerms-->>"+paymentsWithTerms);
        // System.out.println("-slowNegativePayment-->>"+slowNegativePayment);
        //
        double payDexValue = count > 0 ? totalIndex / count : 0;
        //
        CreditRefMetricResultBean resultBean = new CreditRefMetricResultBean();
        resultBean.setAvgCreditLimit(avgCreditLimit);
        resultBean.setMaxBalanceOutstanding(maxBalanceOutstanding);
        resultBean.setMaxBalancePastDue(maxBalancePastDue);
        resultBean.setMaxCreditLimit(maxCreditLimit);
        resultBean.setPayDexValue(payDexValue);
        resultBean.setPaymentsWithTerms(paymentsWithTerms);
        resultBean.setSlowNegativePayment(slowNegativePayment);
        //
        if (avgHighBalBean != null) {
            resultBean.setAvgHighBalRange(avgHighBalBean.getDescription());
            resultBean.setAvgHighBalBean(avgHighBalBean);
        }
        //
        resultBean.setHasMetricsResult(hasMetricsResult);
        // System.out.println("======payDexValue========>> "+payDexValue);
        return resultBean;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("---in---");
        Map<String, String> paymentIndexMap = XmlDataInputHelper
                .paymentIndexMap();
        System.out.println(
                "--result---> " + computeRefMetrics(43l, paymentIndexMap));
        System.out.println("---out---");
    }
}
