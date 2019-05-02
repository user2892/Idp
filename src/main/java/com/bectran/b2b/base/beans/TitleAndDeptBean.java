package com.bectran.b2b.base.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.bectran.matrix.framework.exception.ResourceLoadException;
import com.bectran.matrix.utils.GeneralConstantThree;

/**
 * @author Louis Ifeguni Apr 12, 2007: 11:53:19 AM
 */
public class TitleAndDeptBean {
    
    private String code;
    private String name;
    public static final Comparator DESCENDING_ORDER = new Comparator() {
        public int compare(Object o1, Object o2) {
            TitleAndDeptBean r1 = (TitleAndDeptBean) o1;
            TitleAndDeptBean r2 = (TitleAndDeptBean) o2;
            return r2.getCode().compareTo(r1.getCode());
        }
    };
    public static final Comparator ASCENDING_ORDER = new Comparator() {
        public int compare(Object o1, Object o2) {
            TitleAndDeptBean r1 = (TitleAndDeptBean) o1;
            TitleAndDeptBean r2 = (TitleAndDeptBean) o2;
            return r1.getCode().compareTo(r2.getCode());
        }
    };

    /**
     * @return Returns the titlesInList.
     */
    public List getTitlesInList(String internalOrExternal) {
        List result = new ArrayList();
        try {
            List ls = GeneralConstantThree.getMemberByType(internalOrExternal);
            for (Iterator i = ls.iterator(); i.hasNext();) {
                GeneralConstantThree con = (GeneralConstantThree) i.next();
                TitleAndDeptBean bean = new TitleAndDeptBean();
                bean.setCode(con.getCode());
                bean.setName(con.getName());
                result.add(bean);
            }
        }
        catch (ResourceLoadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Collections.sort(result, DESCENDING_ORDER);
        return result;
    }

    /**
     * @return Returns the titlesInMap.
     */
    public Map getTitlesInMap(String internalOrExternal) {
        Map mp = new HashMap();
        try {
            List ls = GeneralConstantThree.getMemberByType(internalOrExternal);
            for (Iterator i = ls.iterator(); i.hasNext();) {
                GeneralConstantThree con = (GeneralConstantThree) i.next();
                // TitleAndDeptBean bean = new TitleAndDeptBean();
                mp.put(con.getCode(), con.getName());
            }
        }
        catch (ResourceLoadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mp;
    }

    /**
     * @return Returns the deptsInList.
     */
    public List getDeptsInList(String internalOrExternal) {
        List result = new ArrayList();
        try {
            List ls = GeneralConstantThree.getMemberByType(internalOrExternal);
            for (Iterator i = ls.iterator(); i.hasNext();) {
                GeneralConstantThree con = (GeneralConstantThree) i.next();
                TitleAndDeptBean bean = new TitleAndDeptBean();
                bean.setCode(con.getCode());
                bean.setName(con.getName());
                result.add(bean);
            }
        }
        catch (ResourceLoadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @return Returns the deptsInMap.
     */
    public Map getDeptsInMap(String internalOrExternal) {
        Map mp = new HashMap();
        try {
            List ls = GeneralConstantThree.getMemberByType(internalOrExternal);
            for (Iterator i = ls.iterator(); i.hasNext();) {
                GeneralConstantThree con = (GeneralConstantThree) i.next();
                // TitleAndDeptBean bean = new TitleAndDeptBean();
                mp.put(con.getCode(), con.getName());
            }
        }
        catch (ResourceLoadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mp;
    }

    /**
     * @return Returns the deptDescription.
     */
    public String getDeptDescription(String deptCode,
                                     String internalOrExternal) {
        Map mp = getDeptsInMap(internalOrExternal);
        String desc = (String) mp.get(deptCode.trim());
        if (desc == null) {
            return "";
        }
        return desc;
    }

    /**
     * @return Returns the titleDescription.
     */
    public String getTitleDescription(String titleCode,
                                      String internalOrExternal) {
        Map mp = getTitlesInMap(internalOrExternal);
        String desc = (String) mp.get(titleCode.trim());
        if (desc == null) {
            return "";
        }
        return desc;
    }

    /**
     * @return Returns the level.
     */
    public String getCode() {
        return code;
    }

    /**
     * @param level
     *            The level to set.
     */
    public void setCode(String level) {
        this.code = level;
    }

    /**
     * @return Returns the value.
     */
    public String getName() {
        return name;
    }

    /**
     * @param value
     *            The value to set.
     */
    public void setName(String value) {
        this.name = value;
    }

}
