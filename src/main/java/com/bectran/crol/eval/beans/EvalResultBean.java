package com.bectran.crol.eval.beans;

import java.util.List;

import com.bectran.b2b.crol.beans.CreditRefEvalBean;
import com.bectran.b2b.crol.beans.RefResultBean;
import com.bectran.b2b.crol.beans.ScoreExplanation;

/**
 * @author LOUIS IFEGUNI Jun 27, 20079:26:40 PM
 */
public class EvalResultBean {
    /**
     * a malformed reference returns a code of 1; 0 - well formed 1- mal-formed
     */
    private int malformedRefCode = 0;
    private List<CreditRefEvalBean> scoreSheet;
    private double score;
    private ScoreExplanation scoreExplanation;
    private int numOfRefs;
    private List<RefResultBean> refEvalResult;

    /**
     * @return Returns the malformedRefCode.
     */
    public int getMalformedRefCode() {
        return malformedRefCode;
    }

    /**
     * @param malformedRefCode
     *            The malformedRefCode to set.
     */
    public void setMalformedRefCode(int malformedRefCode) {
        this.malformedRefCode = malformedRefCode;
    }

    /**
     * @return Returns the scoreSheet.
     */
    public List<CreditRefEvalBean> getScoreSheet() {
        return scoreSheet;
    }

    /**
     * @param scoreSheet
     *            The scoreSheet to set.
     */
    public void setScoreSheet(List<CreditRefEvalBean> scoreSheet) {
        this.scoreSheet = scoreSheet;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNumOfRefs() {
        return numOfRefs;
    }

    public void setNumOfRefs(int numOfRefs) {
        this.numOfRefs = numOfRefs;
    }

    public ScoreExplanation getScoreExplanation() {
        return scoreExplanation;
    }

    public void setScoreExplanation(ScoreExplanation scoreExplanation) {
        this.scoreExplanation = scoreExplanation;
    }

    public List<RefResultBean> getRefEvalResult() {
        return refEvalResult;
    }

    public void setRefEvalResult(List<RefResultBean> refEvalResult) {
        this.refEvalResult = refEvalResult;
    }
}
