/**
 * 
 */
package com.bectran.b2b.eref.helper;

import java.util.List;
import java.util.Map;

import com.bectran.matrix.framework.exception.ResourceLoadException;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 27, 2013 : 11:06:34 AM
 */
public class RangeRefAnswerModelHelper {
    public static final String HIGH_BALANCE_TRADE_MODEL_FILE = "hibal-trade-ref-model.xml";

    public static double getInternalValue(String code,
                                          Map<String, RangeRefAnswerModelBean> mapOfCodeBean) {
        //
        RangeRefAnswerModelBean bean = (RangeRefAnswerModelBean) mapOfCodeBean
                .get(code);
        if (bean == null) {
            return 0;
        }
        //
        return bean.getVal();
    }

    public static RangeRefAnswerModelBean getAnswerModel(double val,
                                                         List<RangeRefAnswerModelBean> modelList)
            throws ResourceLoadException {
        for (RangeRefAnswerModelBean bean : modelList) {
            if (val >= bean.getLval() && val < bean.getUval()) {
                return bean;
            }
        }
        return null;
    }

    public static List<RangeRefAnswerModelBean> getHighBalTradeModel()
            throws ResourceLoadException {
        return XmlRangeAnswerModelHelper
                .loadModel(HIGH_BALANCE_TRADE_MODEL_FILE);
    }

    public static Map<String, RangeRefAnswerModelBean> mapOfModel(List<RangeRefAnswerModelBean> modelList)
            throws ResourceLoadException {
        return XmlRangeAnswerModelHelper.mapOfCodeBean(modelList);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
