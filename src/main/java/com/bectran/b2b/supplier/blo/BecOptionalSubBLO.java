/**
 * 
 */
package com.bectran.b2b.supplier.blo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;

import com.bectran.b2b.constants.BecOptionalSubConstants;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.supplier.beans.BecOptionalSubBean;
import com.bectran.b2b.supplier.beans.BecSubscriptionBean;
import com.bectran.b2b.supplier.dao.BecOptionalSubDAO;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.framework.exception.ResourceLoadException;
import com.bectran.matrix.utils.XmlDocUtil;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 28, 2012 : 11:50:20 PM
 */
public class BecOptionalSubBLO {
    public static List<BecOptionalSubBean> getOptionalSubPkg(Long supplierId,
                                                             String planCode)
            throws DataAccessException, ResourceLoadException {
        List<BecOptionalSubBean> ls = BecOptionalSubDAO
                .find(supplierId.longValue());
        if (ls == null || ls.size() < 1) {
            ls = loadOptions(supplierId, planCode);
            BecOptionalSubDAO.saveAll(ls);
        }
        return ls;
    }

    public static Map<String, BecOptionalSubBean> mapOfSubPkg(Long supplierId)
            throws DataAccessException, ResourceLoadException {
        List<BecOptionalSubBean> ls = BecOptionalSubDAO
                .find(supplierId.longValue());
        /// if(ls==null || ls.size()<4){
        // ls = loadOptions(supplierId, planCode);
        // BecOptionalSubDAO.saveAll(ls);
        // }
        Map<String, BecOptionalSubBean> mp = new HashMap<String, BecOptionalSubBean>();
        for (Iterator<BecOptionalSubBean> i = ls.iterator(); i.hasNext();) {
            BecOptionalSubBean dt = (BecOptionalSubBean) i.next();
            mp.put(dt.getOptionPlanCode().trim(), dt);
        }
        return mp;
    }

    private static List<BecOptionalSubBean> loadOptions(Long supplierId,
                                                        String planCode)
            throws ResourceLoadException {
        String fileName = "subscr-optional-pkg.xml";
        Document document = XmlDocUtil.readDocument(fileName);
        // Document document = XmlDocUtil.readDocumentTest("xmldoc/" +fileName);
        Element root = document.getRootElement();
        List list = root.getChildren("entry");
        List<BecOptionalSubBean> result = new ArrayList<BecOptionalSubBean>();
        for (Iterator i = list.iterator(); i.hasNext();) {
            Element elem = (Element) i.next();
            BecOptionalSubBean bean = new BecOptionalSubBean();
            //
            bean.setPlanCode(planCode);
            bean.setOptionPlanCode(elem.getAttributeValue("code").trim());
            bean.setDescription(elem.getAttributeValue("planDescr").trim());
            bean.setSupplierId(supplierId);
            bean.setLastUpdate(new Date());
            bean.setBeginingDate(new Date());
            bean.setEndDate(new Date());
            //
            bean.setId(supplierId.toString() + MatrixConstants.FORMULA_SEPARATOR
                    + bean.getOptionPlanCode().trim());
            result.add(bean);
        }
        return result;
    }

    public static boolean hasOpsMgt(Long supplierId)
            throws DataAccessException {
        List<BecOptionalSubBean> ls = BecOptionalSubDAO
                .find(supplierId.longValue());
        if (ls == null || ls.size() < 1) {
            return false;
        }
        Map<String, BecOptionalSubBean> mapOfOptionalSub = mapOfSubPkg(ls);
        // OPERATIONS MANAGEMNT
        BecOptionalSubBean sub = (BecOptionalSubBean) mapOfOptionalSub
                .get(BecOptionalSubConstants.OPERATIONS_MANAGEMENT);
        if (sub.isActiveStatus() && !sub.isExpired()) {
            return true;
        }
        return false;
    }

    private static Map<String, BecOptionalSubBean> mapOfSubPkg(List<BecOptionalSubBean> ls)
            throws DataAccessException {
        Map<String, BecOptionalSubBean> mp = new HashMap<String, BecOptionalSubBean>();
        for (Iterator<BecOptionalSubBean> i = ls.iterator(); i.hasNext();) {
            BecOptionalSubBean dt = (BecOptionalSubBean) i.next();
            mp.put(dt.getOptionPlanCode().trim(), dt);
        }
        return mp;
    }

    private static List<BecOptionalSubBean> LOAD_OPTIONS_WKROUND(Long supplierId,
                                                                 String planCode)
            throws ResourceLoadException {
        // String fileName = "subscr-optional-pkg.xml";
        String fileName = "subscr-optional-pkg-wkaround.xml";
        Document document = XmlDocUtil.readDocument(fileName);
        // Document document = XmlDocUtil.readDocumentTest("xmldoc/" +fileName);
        Element root = document.getRootElement();
        List list = root.getChildren("entry");
        List<BecOptionalSubBean> result = new ArrayList<BecOptionalSubBean>();
        for (Iterator i = list.iterator(); i.hasNext();) {
            Element elem = (Element) i.next();
            BecOptionalSubBean bean = new BecOptionalSubBean();
            //
            bean.setPlanCode(planCode);
            bean.setOptionPlanCode(elem.getAttributeValue("code").trim());
            bean.setDescription(elem.getAttributeValue("planDescr").trim());
            bean.setSupplierId(supplierId);
            bean.setLastUpdate(new Date());
            bean.setBeginingDate(new Date());
            bean.setEndDate(new Date());
            //
            bean.setId(supplierId.toString() + MatrixConstants.FORMULA_SEPARATOR
                    + bean.getOptionPlanCode().trim());
            result.add(bean);
        }
        return result;
    }

    public static void WORKAROUND()
            throws DataAccessException, ResourceLoadException {
        List<BecSubscriptionBean> ls = BecOptionalSubDAO.WORK_AROUND();
        for (Iterator<BecSubscriptionBean> i = ls.iterator(); i.hasNext();) {
            BecSubscriptionBean bean = (BecSubscriptionBean) i.next();
            List<BecOptionalSubBean> myls = LOAD_OPTIONS_WKROUND(
                    bean.getSupplierId(), bean.getPlanCode());
            BecOptionalSubDAO.saveAll(myls);
        }
    }

    public static void main(String[] args) throws Exception {
        //
        // WORKAROUND();
        System.out.println("--done--");
    }
}
