/**
 * 
 */
package com.bectran.matrix.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;

import com.bectran.b2b.constants.XmlDocFileConst;
import com.bectran.matrix.framework.exception.ResourceLoadException;

/**
 * @author LOUIS IFEGUNI Jul 12, 2008 : 7:48:20 PM
 */
public class IndustrySectorHelper {
    protected static List getSectors() {
        List result = new ArrayList();
        try {
            //
            Document document = XmlDocUtil.readDocument(XmlDocFileConst.SECTOR);
            Element root = document.getRootElement();
            List list = root.getChildren("sector");
            Element element = null;
            for (Iterator i = list.iterator(); i.hasNext();) {
                element = (Element) i.next();
                IndustrySector bean = new IndustrySector();
                bean.setSectorId(element.getChildText("sector-id").trim());
                bean.setSectorName(element.getChildText("sector-name").trim());
                //
                result.add(bean);
            }
        }
        catch (ResourceLoadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Collections.sort(result, IndustrySector.ASCENDING_SECTOR_ORDER);
        return result;
    }

    protected static List getSectorIndustryData() {
        //
        List result = new ArrayList();
        try {
            Document document = XmlDocUtil
                    .readDocument(XmlDocFileConst.SECTOR_INDUSTRY);
            Element root = document.getRootElement();
            List list = root.getChildren("industry");
            Element element = null;
            //
            for (Iterator i = list.iterator(); i.hasNext();) {
                element = (Element) i.next();
                IndustrySector bean = new IndustrySector();
                bean.setSectorId(element.getChildText("sector-id").trim());
                bean.setSectorName(element.getChildText("sector-name").trim());
                bean.setIndustryId(element.getChildText("ind-id").trim());
                bean.setIndustryName(element.getChildText("ind-name").trim());
                //
                result.add(bean);
                //
            }
            //
        }
        catch (ResourceLoadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Collections.sort(result, IndustrySector.ASCENDING_INDUSTRY_ORDER);
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
