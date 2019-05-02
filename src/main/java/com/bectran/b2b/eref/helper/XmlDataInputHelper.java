package com.bectran.b2b.eref.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.bectran.b2b.crol.constants.CrolConstants;
import com.bectran.crol.eval.beans.AttributeBean;
import com.bectran.matrix.framework.exception.ResourceLoadException;
import com.bectran.matrix.utils.XmlDocUtil;

/**
 * @author LOUIS IFEGUNI MODIFIED: 04-25-2013 l_bank-attributes.xml
 *         m_bank-attributes.xml s_bank-attributes.xml l_trade-attributes.xml
 *         m_trade-attributes.xml s_trade-attributes.xml
 */
public class XmlDataInputHelper {
    private static String attributeFilePrefix(String companySize) {
        Map<String, String> mp = new HashMap<String, String>();
        //
        mp.put(CrolConstants.SMALL_SCALE, "s");
        mp.put(CrolConstants.MEDIUM_SCALE, "m");
        mp.put(CrolConstants.LARGE_SCALE, "l");
        //
        String filePre = (String) mp.get(companySize);
        if (filePre == null || filePre.trim().length() < 1) {
            filePre = "m";
        }
        return filePre + "_";
    }

    public static List<XmlAttributeAnswerBean> loadAttributeScoreModel(String refType,
                                                                       String companySize)
            throws ResourceLoadException {
        String relativeFileLoc = null;
        String filePrefix = attributeFilePrefix(companySize);
        /*
         * old if(refType.trim().equals(CrolConstants.REFERENCE_TYPE_BANK)){
         * //fileLoc =
         * "E:/RAD7WKSPACE/WKSPACE-B2B-USER/eref/WebContent/xml-ref/bank-attributes.xml";
         * relativeFileLoc = "xml-ref/bank-attributes.xml"; }else {
         * relativeFileLoc = "xml-ref/trade-attributes.xml"; }
         */
        if (refType.trim().equals(CrolConstants.REFERENCE_TYPE_BANK)) {
            // fileLoc =
            // "E:/RAD7WKSPACE/WKSPACE-B2B-USER/eref/WebContent/xml-ref/bank-attributes.xml";
            relativeFileLoc = "xml-ref/" + filePrefix + "bank-attributes.xml";
        }
        else {
            relativeFileLoc = "xml-ref/" + filePrefix + "trade-attributes.xml";
        }
        Document document = XmlDocUtil.readDocumentWithPath(relativeFileLoc);
        Element root = document.getRootElement();
        List<Element> list = root.getChildren("attribute");
        List<XmlAttributeAnswerBean> resultList = new ArrayList<XmlAttributeAnswerBean>();
        // ScoreExplanation se = null;
        List<Element> attributeChildren = null;
        for (Iterator<Element> i = list.iterator(); i.hasNext();) {
            Element attr = (Element) i.next();
            // System.out.println(attr.getChildText("id"));
            // System.out.println(attr.getAttributeValue("id"));
            // List entries = attr.getChildren("entry");
            /// result.add(se);
            String attributeID = attr.getAttributeValue("id").trim();
            attributeChildren = attr.getChildren("entry");
            //
            populateBean(attributeChildren, attributeID, resultList);
        }
        return resultList;
    }

    private static void populateBean(List<Element> attributeChildren,
                                     String attributeID,
                                     List<XmlAttributeAnswerBean> resultList)
            throws ResourceLoadException {
        for (Iterator<Element> i = attributeChildren.iterator(); i.hasNext();) {
            Element elem = (Element) i.next();
            //
            XmlAttributeAnswerBean bean = new XmlAttributeAnswerBean();
            bean.setAttributeId(attributeID);
            bean.setOrder(
                    Integer.parseInt(elem.getAttributeValue("order").trim()));
            bean.setCode(elem.getAttributeValue("code").trim());
            bean.setDescription(elem.getAttributeValue("description").trim());
            bean.setScore(Integer.parseInt(elem.getAttributeValue("score")));
            bean.setInternalValue(Integer
                    .parseInt(elem.getAttributeValue("internal-value").trim()));
            //
            bean.setLowerBound(
                    Double.parseDouble(elem.getAttributeValue("lb")));
            bean.setUpperBound(
                    Double.parseDouble(elem.getAttributeValue("ub")));
            //
            resultList.add(bean);
            // System.out.println(bean.getAttributeId()+", "+bean.getOrder()+",
            // "+bean.getCode()+", "+bean.getDescription()+",
            // "+bean.getScore()+", "+bean.getInternalValue());
            // System.out.println(bean.getLowerBound()+",
            // "+bean.getUpperBound());
        }
    }

    public static Map<String, String> paymentIndexMap()
            throws ResourceLoadException {
        String relativeFileLoc = "xml-ref/trade-attributes.xml";
        Document document = XmlDocUtil.readDocumentWithPath(relativeFileLoc);
        // Document document = readDocumentTest(relativeFileLoc);
        Element root = document.getRootElement();
        List<Element> list = root.getChildren("attribute");
        List<Element> attributeChildren = null;
        Map<String, String> mapOfIndex = new HashMap<String, String>();
        for (Iterator<Element> i = list.iterator(); i.hasNext();) {
            Element attr = (Element) i.next();
            String attributeID = attr.getAttributeValue("id").trim();
            if (attributeID.trim().equals("PAYMENTEXPERIENCE")) {
                attributeChildren = attr.getChildren("entry");
                for (Iterator<Element> k = attributeChildren.iterator(); k
                        .hasNext();) {
                    Element elem = (Element) k.next();
                    //
                    mapOfIndex.put(elem.getAttributeValue("code").trim(),
                            elem.getAttributeValue("index").trim());
                }
                return mapOfIndex;
            }
        }
        return null;
    }

    public static Map<String, XmlAttributeAnswerBean> mapOfAttributeAnswers(String bankOrTrade,
                                                                            String companySize)
            throws ResourceLoadException {
        List<XmlAttributeAnswerBean> model = loadAttributeScoreModel(
                bankOrTrade, companySize);
        Map<String, XmlAttributeAnswerBean> result = new HashMap<String, XmlAttributeAnswerBean>();
        for (Iterator<XmlAttributeAnswerBean> i = model.iterator(); i
                .hasNext();) {
            XmlAttributeAnswerBean bean = (XmlAttributeAnswerBean) i.next();
            result.put(bean.getCode().trim(), bean);
        }
        return result;
    }

    public static List<XmlAttributeAnswerBean> getAttributeValues(List<XmlAttributeAnswerBean> allValuesList,
                                                                  String attributeID) {
        List<XmlAttributeAnswerBean> result = new ArrayList<XmlAttributeAnswerBean>();
        for (Iterator<XmlAttributeAnswerBean> i = allValuesList.iterator(); i
                .hasNext();) {
            XmlAttributeAnswerBean bean = (XmlAttributeAnswerBean) i.next();
            if (bean.getAttributeId().trim().equals(attributeID)) {
                result.add(bean);
            }
        }
        return result;
    }

    public static List<XmlAttributeAnswerBean> getAttributeValues(String attributeID,
                                                                  String bankOrTrade,
                                                                  String companySize) {
        List<XmlAttributeAnswerBean> result = new ArrayList<XmlAttributeAnswerBean>();
        try {
            List<XmlAttributeAnswerBean> allValuesList = loadAttributeScoreModel(
                    bankOrTrade, companySize);
            for (Iterator<XmlAttributeAnswerBean> i = allValuesList
                    .iterator(); i.hasNext();) {
                XmlAttributeAnswerBean bean = (XmlAttributeAnswerBean) i.next();
                if (bean.getAttributeId().trim().equals(attributeID)) {
                    result.add(bean);
                }
            }
        }
        catch (ResourceLoadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            result = null;
        }
        return result;
    }

    public static List<AttributeBean> loadBankModel()
            throws ResourceLoadException {
        String relativeFileLoc = "xml-ref/bankModel.xml";
        return loadModel(relativeFileLoc);
    }

    public static List<AttributeBean> loadTradeModel()
            throws ResourceLoadException {
        String relativeFileLoc = "xml-ref/tradeModel.xml";
        return loadModel(relativeFileLoc);
    }

    /**
     * ECAP MODEL
     * 
     * @return
     * @throws ResourceLoadException
     */
    public static List<AttributeBean> loadAppModel()
            throws ResourceLoadException {
        String relativeFileLoc = "xml-ref/ecapmodel.xml";
        return loadModel(relativeFileLoc);
    }

    public static List<AttributeBean> loadModel(String relativeFileLoc)
            throws ResourceLoadException {
        // String fileLoc =
        // "E:/RAD7WKSPACE/WKSPACE-B2B-USER/eref/WebContent/xml-ref/bankModel.xml";
        Document document = XmlDocUtil.readDocumentWithPath(relativeFileLoc);
        Element root = document.getRootElement();
        List<Element> list = root.getChildren("entry");
        List<AttributeBean> resultList = new ArrayList<AttributeBean>();
        // ScoreExplanation se = null;
        for (Iterator<Element> i = list.iterator(); i.hasNext();) {
            Element attr = (Element) i.next();
            //
            AttributeBean bean = new AttributeBean();
            bean.setShortName(attr.getAttributeValue("code").trim());
            bean.setFullName(attr.getAttributeValue("description").trim());
            bean.setDataType(attr.getAttributeValue("data-type").trim());
            bean.setWeight(
                    Double.parseDouble(attr.getAttributeValue("weight")));
            resultList.add(bean);
            // System.out.println(bean.getShortName()+", "+bean.getWeight());
        }
        return resultList;
    }

    public static List<XmlAttributeAnswerBean> loadEcapAttributeScoreModel()
            throws ResourceLoadException {
        String relativeFileLoc = "xml-ref/ecap-attributes.xml";
        Document document = XmlDocUtil.readDocumentWithPath(relativeFileLoc);
        Element root = document.getRootElement();
        List<Element> list = root.getChildren("attribute");
        List<XmlAttributeAnswerBean> resultList = new ArrayList<XmlAttributeAnswerBean>();
        // ScoreExplanation se = null;
        List<Element> attributeChildren = null;
        for (Iterator<Element> i = list.iterator(); i.hasNext();) {
            Element attr = (Element) i.next();
            // System.out.println(attr.getChildText("id"));
            // System.out.println(attr.getAttributeValue("id"));
            // List entries = attr.getChildren("entry");
            /// result.add(se);
            String attributeID = attr.getAttributeValue("id").trim();
            attributeChildren = attr.getChildren("entry");
            //
            populateBean(attributeChildren, attributeID, resultList);
        }
        return resultList;
    }

    public static Map<String, XmlAttributeAnswerBean> mapOfEcapAttributeAnswers()
            throws ResourceLoadException {
        List<XmlAttributeAnswerBean> model = loadEcapAttributeScoreModel();
        Map<String, XmlAttributeAnswerBean> result = new HashMap<String, XmlAttributeAnswerBean>();
        for (Iterator<XmlAttributeAnswerBean> i = model.iterator(); i
                .hasNext();) {
            XmlAttributeAnswerBean bean = (XmlAttributeAnswerBean) i.next();
            result.put(bean.getCode().trim(), bean);
            //
            // System.out.println("--> "+bean.getCode().trim());
        }
        return result;
    }

    public static List<XmlAttributeAnswerBean> getEcapAttributeValues(String attributeID) {
        List<XmlAttributeAnswerBean> result = new ArrayList<XmlAttributeAnswerBean>();
        try {
            List<XmlAttributeAnswerBean> allValuesList = loadEcapAttributeScoreModel();
            for (Iterator<XmlAttributeAnswerBean> i = allValuesList
                    .iterator(); i.hasNext();) {
                XmlAttributeAnswerBean bean = (XmlAttributeAnswerBean) i.next();
                if (bean.getAttributeId().trim().equals(attributeID)) {
                    result.add(bean);
                }
            }
        }
        catch (ResourceLoadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            result = null;
        }
        return result;
    }

    public static AppRefScoreModelBean loadAppRefScoringModel()
            throws ResourceLoadException {
        String relativeFileLoc = "xml-ref/app-ref-score.xml";
        Document document = XmlDocUtil.readDocumentWithPath(relativeFileLoc);
        Element root = document.getRootElement();
        List<Element> list = root.getChildren("entry");
        Element elem = (Element) list.get(0);
        //
        AppRefScoreModelBean bean = new AppRefScoreModelBean();
        bean.setAppWeight(Double.parseDouble(elem.getChildText("appweight")));
        bean.setRefWeight(Double.parseDouble(elem.getChildText("refweight")));
        bean.setRefDisc1Ref(
                Double.parseDouble(elem.getChildText("ref-discount-1")));
        bean.setRefDisc2Ref(
                Double.parseDouble(elem.getChildText("ref-discount-2")));
        return bean;
    }

    public static Map<String, String> mapOfCodeCreditLimit()
            throws ResourceLoadException {
        String relativeFileLoc = "xml-ref/ecap-attributes.xml";
        Document document = XmlDocUtil.readDocumentWithPath(relativeFileLoc);
        // Document document = readDocumentTest(relativeFileLoc);
        Element root = document.getRootElement();
        List list = root.getChildren("attribute");
        List attributeChildren = null;
        Map<String, String> codeCreditLimitMap = new HashMap<String, String>();
        for (Iterator i = list.iterator(); i.hasNext();) {
            Element attr = (Element) i.next();
            String attributeID = attr.getAttributeValue("id").trim();
            if (!(attributeID.equals("NUMEMPLOYEES")
                    || attributeID.equals("ANNUALSALES"))) {
                continue;
            }
            attributeChildren = attr.getChildren("entry");
            //
            // populateBean(attributeChildren, attributeID,resultList);
            for (Iterator kk = attributeChildren.iterator(); kk.hasNext();) {
                Element elem = (Element) kk.next();
                //
                codeCreditLimitMap.put(elem.getAttributeValue("code").trim(),
                        elem.getAttributeValue("crlimit").trim());
                // System.out.println(attributeID+",
                // "+elem.getAttributeValue("code").trim()+",
                // "+FormatUtility.formatNumber(elem.getAttributeValue("crlimit").trim()));
                // System.out.println(bean.getLowerBound()+",
                // "+bean.getUpperBound());
            }
        }
        return codeCreditLimitMap;
    }

    public static Map<String, String> mapOfCodeCompanySize()
            throws ResourceLoadException {
        String relativeFileLoc = "xml-ref/ecap-attributes.xml";
        Document document = XmlDocUtil.readDocumentWithPath(relativeFileLoc);
        // Document document = readDocumentTest(relativeFileLoc);
        Element root = document.getRootElement();
        List list = root.getChildren("attribute");
        List attributeChildren = null;
        Map<String, String> codeCreditLimitMap = new HashMap<String, String>();
        for (Iterator i = list.iterator(); i.hasNext();) {
            Element attr = (Element) i.next();
            String attributeID = attr.getAttributeValue("id").trim();
            if (!(attributeID.equals("NUMEMPLOYEES")
                    || attributeID.equals("ANNUALSALES"))) {
                continue;
            }
            attributeChildren = attr.getChildren("entry");
            //
            // populateBean(attributeChildren, attributeID,resultList);
            for (Iterator kk = attributeChildren.iterator(); kk.hasNext();) {
                Element elem = (Element) kk.next();
                //
                codeCreditLimitMap.put(elem.getAttributeValue("code").trim(),
                        elem.getAttributeValue("cat").trim());
                // System.out.println(attributeID+",
                // "+elem.getAttributeValue("code").trim()+",
                // "+elem.getAttributeValue("cat").trim());
                // System.out.println(bean.getLowerBound()+",
                // "+bean.getUpperBound());
            }
        }
        return codeCreditLimitMap;
    }

    protected static Document readDocumentTest(String path)
            throws ResourceLoadException {
        SAXBuilder builder = new SAXBuilder();
        Document document;
        try {
            String fileLocation = "H:/dev1/wkspace/myeclipse86/b2bcredit-wkspace/b2bcredit/WebRoot/"
                    + path.trim();
            document = builder.build(new File(fileLocation));
            return document;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ResourceLoadException();
        }
    }

    public static void main(String[] args) throws ResourceLoadException {
        // xmlScoreData("");
        // loadScoreValues();
        // loadAttributeScoreModel("");
        // loadBankModel();
        // getAttributeValueSEL(XmlAttributeConstants.AVERAGE_BANK_BALANCE, "");
        // loadTradeModel();
        // loadAttributeScoreModel(CrolConstants.REFERENCE_TYPE_TRADE);
        // mapOfCodeCreditLimit();
        test();
    }

    public static List<String> salesOrEmplRangeList(String salesOrEmpl)
            throws ResourceLoadException {
        String relativeFileLoc = "xml-ref/ecap-attributes.xml";
        Document document = XmlDocUtil.readDocumentWithPath(relativeFileLoc);
        // Document document = readDocumentTest(relativeFileLoc);
        Element root = document.getRootElement();
        List list = root.getChildren("attribute");
        List attributeChildren = null;
        List<String> rangeList = new ArrayList<String>();
        for (Iterator i = list.iterator(); i.hasNext();) {
            Element attr = (Element) i.next();
            String attributeID = attr.getAttributeValue("id").trim();
            if (!(attributeID.equals(salesOrEmpl.trim()))) {
                continue;
            }
            attributeChildren = attr.getChildren("entry");
            for (Iterator kk = attributeChildren.iterator(); kk.hasNext();) {
                Element elem = (Element) kk.next();
                //
                rangeList.add(elem.getAttributeValue("code").trim());
                //
            }
        }
        return rangeList;
    }

    public static void test() throws ResourceLoadException {
        String relativeFileLoc = "xml-ref/trade-attributes.xml";
        Document document = readDocumentTest(relativeFileLoc);
        StringBuffer bf = new StringBuffer();
        Element root = document.getRootElement();
        List<Element> list = root.getChildren("attribute");
        List<Element> attributeChildren = null;
        Map<String, String> mapOfIndex = new HashMap<String, String>();
        for (Iterator<Element> i = list.iterator(); i.hasNext();) {
            Element attr = (Element) i.next();
            String attributeID = attr.getAttributeValue("id").trim();
            if (attributeID.trim().equals("PAYMENTEXPERIENCE")) {
                attributeChildren = attr.getChildren("entry");
                for (Iterator<Element> k = attributeChildren.iterator(); k
                        .hasNext();) {
                    Element elem = (Element) k.next();
                    //
                    mapOfIndex.put(elem.getAttributeValue("code").trim(),
                            elem.getAttributeValue("index").trim());
                    bf.append("<tr><td>" + elem.getAttributeValue("description")
                            + "</td>" + "<td>"
                            + elem.getAttributeValue("index").trim()
                            + "</td></tr>");
                }
                // return mapOfIndex;
            }
        }
        System.out.println(bf.toString());
    }

    public static String stripDollarSignFromInut(String input) {
        String pattern = "[$-+]";
        //
        String strippedInput = input.replaceAll(pattern, "");
        //
        return strippedInput;
    }
}
