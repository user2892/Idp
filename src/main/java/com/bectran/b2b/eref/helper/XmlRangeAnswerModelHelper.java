/**
 * 
 */
package com.bectran.b2b.eref.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;

import com.bectran.matrix.framework.exception.ResourceLoadException;
import com.bectran.matrix.utils.XmlDocUtil;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 27, 2013 : 10:30:39 AM
 */
public class XmlRangeAnswerModelHelper {
    public static List<RangeRefAnswerModelBean> loadModel(String fileName)
            throws ResourceLoadException {
        String relativeFileLoc = "xml-ref/" + fileName;
        //
        Document document = XmlDocUtil.readDocumentWithPath(relativeFileLoc);
        Element root = document.getRootElement();
        List<Element> list = root.getChildren("entry");
        List<RangeRefAnswerModelBean> resultList = new ArrayList<RangeRefAnswerModelBean>();
        //
        for (Iterator<Element> i = list.iterator(); i.hasNext();) {
            Element elem = (Element) i.next();
            //
            RangeRefAnswerModelBean bean = new RangeRefAnswerModelBean();
            bean.setCode(elem.getAttributeValue("code").trim());
            bean.setVal(Double.parseDouble(elem.getAttributeValue("val")));
            bean.setLval(Double.parseDouble(elem.getAttributeValue("lval")));
            bean.setUval(Double.parseDouble(elem.getAttributeValue("uval")));
            //
            bean.setLowerBound(
                    Double.parseDouble(elem.getAttributeValue("lb")));
            bean.setUpperBound(
                    Double.parseDouble(elem.getAttributeValue("ub")));
            //
            bean.setDescription(elem.getAttributeValue("description").trim());
            //
            resultList.add(bean);
        }
        return resultList;
    }

    public static Map<String, RangeRefAnswerModelBean> mapOfCodeBean(List<RangeRefAnswerModelBean> model)
            throws ResourceLoadException {
        Map<String, RangeRefAnswerModelBean> result = new HashMap<String, RangeRefAnswerModelBean>();
        for (RangeRefAnswerModelBean bean : model) {
            result.put(bean.getCode().trim(), bean);
            //
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
