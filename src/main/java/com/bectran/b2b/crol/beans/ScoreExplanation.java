package com.bectran.b2b.crol.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;

import com.bectran.b2b.crol.constants.CrolConstants;
import com.bectran.matrix.framework.exception.ResourceLoadException;
import com.bectran.matrix.utils.XmlDocUtil;

/**
 * @author LOUIS IFEGUNI Jun 4, 200711:11:53 PM
 */
public class ScoreExplanation {
    private String rangeCode;
    private double lowerBound;
    private double upperBound;
    private String riskRating;
    private String riskLevel;
    private String explanation;

    public List xmlScoreData(int refOrAccount) throws ResourceLoadException {
        // String fileLoc =
        // "E:/radwkspace/b2bcredit/CrolWeb/WebContent/xmldoc/score-int-ref.xml";
        // String fileLoc = null;
        // if(refOrAccount==CrolConstants.ANALYTICS_LEVEL_REFERENCE){
        // fileLoc = AppConfig.getXmlDocFilePathPrefix()+
        // CrolConstants.SCORE_EXPLANATION_REF;
        //// }else if(refOrAccount==CrolConstants.ANALYTICS_LEVEL_ACCOUNT){
        // fileLoc = AppConfig.getXmlDocFilePathPrefix()+
        // CrolConstants.SCORE_EXPLANATION_ACCT;
        // }
        // WSUtility.readDocument(fileLoc);
        String fileName = null;
        if (refOrAccount == CrolConstants.ANALYTICS_LEVEL_REFERENCE) {
            fileName = CrolConstants.SCORE_EXPLANATION_REF;
        }
        else if (refOrAccount == CrolConstants.ANALYTICS_LEVEL_ACCOUNT) {
            fileName = CrolConstants.SCORE_EXPLANATION_ACCT;
        }
        Document document = XmlDocUtil.readDocument(fileName);
        Element root = document.getRootElement();
        List list = root.getChildren("entry");
        List result = new ArrayList();
        ScoreExplanation se = null;
        for (Iterator i = list.iterator(); i.hasNext();) {
            Element attr = (Element) i.next();
            se = new ScoreExplanation();
            se.setRangeCode(attr.getChildText("range-code").trim());
            se.setLowerBound(
                    Double.parseDouble(attr.getChildText("lower-bound")));
            se.setUpperBound(
                    Double.parseDouble(attr.getChildText("upper-bound")));
            se.setRiskRating(attr.getChildText("risk-rating").trim());
            se.setRiskLevel(attr.getChildText("risk-level").trim());
            se.setExplanation(attr.getChildText("explanation").trim());
            // System.out.println(attr.getChildText("range-code"));
            // List entries = attr.getChildren("entry");
            result.add(se);
        }
        return result;
    }

    public ScoreExplanation getScoreExplanation(double score, int refOrAccount,
                                                String sizeCategory)
            throws ResourceLoadException {
        List ls = xmlScoreData(refOrAccount);
        for (Iterator i = ls.iterator(); i.hasNext();) {
            ScoreExplanation exp = (ScoreExplanation) i.next();
            if (score >= exp.getLowerBound() && score < exp.getUpperBound()) {
                /* add rating prefix */
                exp.setRiskRating(
                        ratingPrefix(sizeCategory) + exp.getRiskRating());
                return exp;
            }
        }
        return null;
    }

    private String ratingPrefix(String sizeCategory) {
        String prefix = "";
        if (sizeCategory.equals(CrolConstants.SMALL_SCALE)) {
            prefix = CrolConstants.RATING_PREFIX_SMALL;
        }
        else if (sizeCategory.equals(CrolConstants.MEDIUM_SCALE)) {
            prefix = CrolConstants.RATING_PREFIX_MEDIUM;
        }
        else if (sizeCategory.equals(CrolConstants.LARGE_SCALE)) {
            prefix = CrolConstants.RATING_PREFIX_LARGE;
        }
        return prefix;
    }

    public static void main(String[] args) throws ResourceLoadException {
        // xmlScoreData("");
        ScoreExplanation scoreExplanation = new ScoreExplanation();
        ScoreExplanation exp = scoreExplanation.getScoreExplanation(2.8, 1,
                CrolConstants.SMALL_SCALE);
        System.out.println(exp.getRiskLevel());
        System.out.println(exp.getExplanation());
    }

    /**
     * @return Returns the explanation.
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * @param explanation
     *            The explanation to set.
     */
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    /**
     * @return Returns the lowerBound.
     */
    public double getLowerBound() {
        return lowerBound;
    }

    /**
     * @param lowerBound
     *            The lowerBound to set.
     */
    public void setLowerBound(double lowerBound) {
        this.lowerBound = lowerBound;
    }

    /**
     * @return Returns the rangeCode.
     */
    public String getRangeCode() {
        return rangeCode;
    }

    /**
     * @param rangeCode
     *            The rangeCode to set.
     */
    public void setRangeCode(String rangeCode) {
        this.rangeCode = rangeCode;
    }

    /**
     * @return Returns the riskLevel.
     */
    public String getRiskLevel() {
        return riskLevel;
    }

    /**
     * @param riskLevel
     *            The riskLevel to set.
     */
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    /**
     * @return Returns the riskRating.
     */
    public String getRiskRating() {
        return riskRating;
    }

    /**
     * @param riskRating
     *            The riskRating to set.
     */
    public void setRiskRating(String riskRating) {
        this.riskRating = riskRating;
    }

    /**
     * @return Returns the upperBound.
     */
    public double getUpperBound() {
        return upperBound;
    }

    /**
     * @param upperBound
     *            The upperBound to set.
     */
    public void setUpperBound(double upperBound) {
        this.upperBound = upperBound;
    }
}
