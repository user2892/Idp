package com.bectran.matrix.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;

import com.bectran.b2b.constants.XmlDocFileConst;
import com.bectran.matrix.framework.exception.ResourceLoadException;

/**
 * @Creation date : Nov 18, 2004
 * @author Louis Ifeguni
 */
public class GeneralConstantThree {
    // Read the properties file with ResourceBundle
    // public static ResourceBundle resource =
    // ResourceBundle.getBundle("crisk");
    // XML File Location
    //// public static final String GENERAL_CONSTANT_FILE_LOCATION =
    // "generalConst3Loc";
    // public static String fileLocation =
    // resource.getString(GENERAL_CONSTANT_FILE_LOCATION.trim());
    // DOCUMENT ELEMENTS
    public static final String TYPE = "type";
    public static final String NAME = "name";
    public static final String CODE = "code";
    public static final String CONTENT = "content";
    public static final String MEMBER = "member";
    // TYPES
    public static final String TYPE_COLLATERAL = "COLLATERAL";
    public static final String TYPE_FILE_NOTE_SUBJECT = "FNSUBJECT";
    public static final String TYPE_REQUEST_DOC = "REQUESTDOC";
    public static final String TYPE_TITLE_INTERNAL = "TITLE";
    public static final String TYPE_DEPT_INTERNAL = "DEPT";
    public static final String TYPE_TITLE_EXTERNAL = "TITLE-EXT";
    public static final String TYPE_DEPT_EXTERNAL = "DEPT-EXT";
    public static final String TYPE_Z_SCORE_INTERPRETATION = "Z-SCORE-INTERPRETATION";
    /**
     * SPECIAL FILE NOTE FOLDER/SUBJECT -- RESERVED FOR COLLECTION MANAGEMENT
     */
    public static final String RESERVED_COLLECTION_CALLS_CODE = "COLLECTION-CALLS-NOTES";
    public static final String RESERVED_COLLECTION_CALLS_NAME = "Collection Calls Notes";
    // COLLATERAL MEMBERS
    public static final String COLLATERAL_CASH = "CASH";
    public static final String COLLATERAL_REAL_ESTATE = "REALESTATE";
    public static final String COLLATERAL_PERSONAL_GUARANTEE = "PERSONALGUARANTEE";
    public static final String COLLATERAL_CORPORATE_GUARANTEE = "CORPGUARANTEE";
    public static final String COLLATERAL_INSURANCE = "INSURANCE";
    public static final String COLLATERAL_LETTERS_OF_CREDIT = "LETTERSOFCREDIT";
    // FILE NOTE MEMBERS
    public static final String FILE_NOTE_GENERAL = "GENERAL";
    public static final String FILE_NOTE_RISK_ASSESSMENT = "RIKASMT";
    public static final String FILE_NOTE_COLLECTION = "COLLECTION";
    // ISSUES STATE MEMBERS
    // public static final String ISSUE_STATE_AWAITING_RESPONSE = "AWRESPONSE";
    // public static final String ISSUE_STATE_AWAITING_CLOURE = "AWCLOSURE";
    // public static final String ISSUE_STATE_AWAITING_FOLLOW_UP =
    // "FOLLOWUPSET";
    // public static final String ISSUE_STATE_CLOSED = "CLOSED";
    // public static final String ISSUE_STATE_AMENDED = "AMENDED";
    //
    private String name = "";
    private String code = "";
    private String type = "";

    //
    /**
     * Reads the xml document containing the general constants set up
     * information.
     * 
     * @return Document - xml document object.
     */
    public static Document readDocument() throws ResourceLoadException {
        String fileName = XmlDocFileConst.GENERAL_CONSTANT_3;
        Document document = XmlDocUtil.readDocument(fileName);
        //
        return document;
    }

    public static List getConstantType() throws ResourceLoadException {
        Document document = readDocument();
        Element root = document.getRootElement();
        List list = root.getChildren(TYPE);
        List result = new ArrayList();
        Element element = null;
        GeneralConstantThree setUpInfo = null;
        for (Iterator i = list.iterator(); i.hasNext();) {
            element = (Element) i.next();
            List types = element.getChildren(CONTENT);
            for (Iterator j = types.iterator(); j.hasNext();) {
                Element constType = (Element) j.next();
                setUpInfo = new GeneralConstantThree();
                setUpInfo.setName(constType.getChildText(NAME));
                result.add(setUpInfo);
            }
        }
        return result;
    }

    public static List getMember() throws ResourceLoadException {
        Document document = readDocument();
        Element root = document.getRootElement();
        List list = root.getChildren(MEMBER);
        List result = new ArrayList();
        Element element = null;
        GeneralConstantThree setUpInfo = null;
        for (Iterator i = list.iterator(); i.hasNext();) {
            element = (Element) i.next();
            List members = element.getChildren(CONTENT);
            for (Iterator j = members.iterator(); j.hasNext();) {
                Element content = (Element) j.next();
                setUpInfo = new GeneralConstantThree();
                setUpInfo.setType(content.getChildText(TYPE).trim());
                setUpInfo.setName(content.getChildText(NAME).trim());
                setUpInfo.setCode(content.getChildText(CODE).trim());
                result.add(setUpInfo);
            }
        }
        return result;
    }

    //
    public static List getMemberByType(String _type)
            throws ResourceLoadException {
        //
        List members = getMember();
        List result = new ArrayList();
        for (Iterator i = members.iterator(); i.hasNext();) {
            GeneralConstantThree info = (GeneralConstantThree) i.next();
            if (info.getType().equals(_type)) {
                result.add(info);
            }
        }
        return result;
    }

    public static String getName(List members, String _value) {
        String result = "";
        for (Iterator i = members.iterator(); i.hasNext();) {
            GeneralConstantThree info = (GeneralConstantThree) i.next();
            if (info.getCode().equals(_value)) {
                result = info.getName();
            }
        }
        return result;
    }

    //
    public static void main(String[] args) throws ResourceLoadException {
        List list = getMemberByType(TYPE_COLLATERAL);
        // System.out.println(getFullName(list,
        // GeneralConstant.CASH_FLOW_STATEMENT));
        for (Iterator i = list.iterator(); i.hasNext();) {
            GeneralConstantThree info = (GeneralConstantThree) i.next();
            System.out.println("..>" + info.getName() + "  " + info.getCode());
            // System.out.println("..info.getValue()...>" + info.getValue());
        }
        GeneralConstantThree info1 = (GeneralConstantThree) list.get(2);
        System.out.println("value - name  : " + info1.getCode() + "  :  "
                + getName(list, info1.getCode()));
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param string
     */
    public void setName(String string) {
        name = string;
    }

    /**
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * @param string
     */
    public void setType(String string) {
        type = string;
    }

    /**
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * @param string
     */
    public void setCode(String string) {
        code = string;
    }
}
