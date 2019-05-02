package com.bectran.b2b.crol.blo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bectran.b2b.bridge.ops.B2BridgeBLO;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.crol.beans.CreditRefBean;
import com.bectran.b2b.crol.beans.CreditRefEvalBean;
import com.bectran.b2b.crol.beans.RefRequestBridgeBean;
import com.bectran.b2b.crol.beans.RefResultBean;
import com.bectran.b2b.crol.beans.ScoreExplanation;
import com.bectran.b2b.crol.constants.CrolConstants;
import com.bectran.b2b.crol.dao.AcctAnalyticsDAO;
import com.bectran.b2b.customer.beans.PastCreditAppBean;
import com.bectran.b2b.customer.beans.RefForRequestBean;
import com.bectran.b2b.customer.dao.RefForRequestDAO;
import com.bectran.b2b.eref.helper.XmlDataInputHelper;
import com.bectran.b2b.supplier.dao.CreditReferenceDAO;
import com.bectran.crol.eval.beans.EvalResultBean;

/**
 * @author LOUIS IFEGUNI
 */
public class AnalyzeReference {
    public static EvalResultBean analyzeCreditRefs(PastCreditAppBean creditApp)
            throws Exception {
        //
        EvalResultBean refResult = new EvalResultBean();
        long creditAppId = creditApp.getId().longValue();
        double crolscore = AcctAnalyticsDAO.crolScore(creditAppId);
        //
        refResult.setScore(crolscore);
        // overallInfo.setCrolScore(crolscore);
        /* set score explanation */
        ScoreExplanation _scoreExpl = new ScoreExplanation();
        ScoreExplanation scoreExplanation = _scoreExpl.getScoreExplanation(
                crolscore, CrolConstants.ANALYTICS_LEVEL_ACCOUNT,
                creditApp.getCompanySizeCategory());
        refResult.setScoreExplanation(scoreExplanation);
        refResult.setNumOfRefs(AcctAnalyticsDAO.numberOfRefs(creditAppId));
        //
        // ref evaluation result
        List<RefResultBean> refEvalResult = refForAppEvaluation(
                creditApp.getId(), creditApp.getTransactionCcy());
        refResult.setRefEvalResult(refEvalResult);
        return refResult;
    }

    private static List<RefResultBean> refForAppEvaluation(Long requestId,
                                                           String transactionCcy)
            throws Exception {
        //
        List<RefForRequestBean> refsForReqList = RefForRequestDAO
                .refsForRequest(requestId.longValue());
        List<RefResultBean> refAnalysisResult = new ArrayList<RefResultBean>();
        for (Iterator<RefForRequestBean> i = refsForReqList.iterator(); i
                .hasNext();) {
            RefForRequestBean bean = (RefForRequestBean) i.next();
            //
            RefResultBean refresult = getReference(bean.getId().longValue(),
                    transactionCcy);
            if (refresult != null) {
                refAnalysisResult.add(refresult);
            }
        }
        return refAnalysisResult;
    }

    public static RefResultBean getReference(long refForReqId,
                                             String transactionCcy)
            throws Exception {
        // System.out.println("refForReqId-->"+refForReqId);
        RefForRequestBean refForRequest = RefForRequestDAO
                .getRefForRequest(refForReqId);
        RefRequestBridgeBean bridge = B2BridgeBLO
                .getRequestBridge(refForRequest);
        //
        // System.out.println("(bridge==null)-->"+(bridge==null));
        // System.out.println("bridge.getCrolRefReqId()-->"+bridge.getCrolRefReqId());
        if (bridge == null || bridge.getCrolRefReqId() == null) {
            return null;
        }
        CreditRefBean cref = CreditReferenceDAO
                .getCreditReference(bridge.getCrolRefReqId().longValue());
        //
        // System.out.println("(cref==null)-->"+(cref==null));
        if (cref == null) {
            // no credit reference
            return null;
        }
        // GET SCORE SHEET and score explanation
        List<CreditRefEvalBean> scoreSheet = CreditRefBLO
                .getScoreSheet(cref.getId().longValue());
        cref.setScoreSheet(scoreSheet);
        /* set score explanation */
        ScoreExplanation _scoreExpl = new ScoreExplanation();
        ScoreExplanation scoreExplanation = _scoreExpl.getScoreExplanation(
                cref.getCrolScore(), CrolConstants.ANALYTICS_LEVEL_REFERENCE,
                cref.getSizeCategory());
        cref.setScoreExplanation(scoreExplanation);
        RefResultBean refresult = new RefResultBean();
        refresult.setCreditRef(cref);
        refresult.setRefForRequest(refForRequest);
        //
        // LOUIS IFEGUNI: 04-29-2015
        if (transactionCcy != null && !transactionCcy.trim()
                .equalsIgnoreCase(MatrixConstants.CURRENCY_USD)) {
            reformatScoreSheetForCcy(scoreSheet, transactionCcy);
        }
        //
        return refresult;
    }

    private static void reformatScoreSheetForCcy(List<CreditRefEvalBean> scoreSheet,
                                                 String transactionCcy) {
        String reformatedName = null;
        for (CreditRefEvalBean bean : scoreSheet) {
            if (bean.isAlphatype() && bean.getAlphaAnsName().contains("$")) {
                // checkf for currency
                reformatedName = transactionCcy + " " + XmlDataInputHelper
                        .stripDollarSignFromInut(bean.getAlphaAnsName());
                bean.setAlphaAnsName(reformatedName);
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
