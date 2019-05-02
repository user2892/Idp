/**
 * 
 */
package com.bectran.sftp.xml.inbound.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

import com.bectran.attribute.beans.AttributeDefBean;
import com.bectran.attribute.beans.AttributeGroupBean;
import com.bectran.attribute.beans.CustomAppAttrGrpLayout;
import com.bectran.attribute.beans.CustomAppLayout;
import com.bectran.attribute.dao.AttributeGroupDAO;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.customer.beans.CustomAppAttrValueBean;
import com.bectran.b2b.customer.beans.CustomCreditAppValuesBean;
import com.bectran.b2b.customer.beans.CustomCreditAppValuesLayoutBeanBean;
import com.bectran.b2b.customer.beans.PastCreditAppBean;
import com.bectran.b2b.customer.blo.CustomCreditAppValuesBLO;
import com.bectran.b2b.customer.dao.CreditRequestDAO;
import com.bectran.b2b.supplier.beans.GroupCustomAppAttrGrpBean;
import com.bectran.b2b.supplier.beans.GroupCustomAppCategoryBean;
import com.bectran.b2b.supplier.dao.GroupCustomAppAttrGrpDAO;
import com.bectran.b2b.supplier.dao.GroupCustomAppCategoryDAO;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.sftp.xml.inbound.Page2InfoXmlBean;

/**
 * @author LOUIS IFEGUNI
 * @date Nov 19, 2013 : 12:15:33 PM
 */
public class Page2InformationHelper extends CustomerDataLoadBase {
    public List<CustomCreditAppValuesLayoutBeanBean> processPage2(PastCreditAppBean app)
            throws Exception {
        // if(app.getId().longValue()>182){
        // return null;
        // }
        // check for custom app
        List<CustomCreditAppValuesLayoutBeanBean> customCreditAppLayout = null;
        if (app.getCustomAppValueSet() != null
                && app.getCustomAppValueSet().size() > 0) {
            // wkbean.setCustomAppPresent(true);
            CustomCreditAppValuesBLO.decryptValues(app.getCustomAppValueList());
            //
            List<GroupCustomAppCategoryBean> categoryModel = GroupCustomAppCategoryDAO
                    .find(app.getGroupId().longValue());
            customCreditAppLayout = CustomCreditAppValuesBLO.constructAppLayout(
                    app.getCustomAppValueList(), categoryModel);
            // wkbean.setCustomCreditAppLayout(customCreditAppLayout);
        }
        // test(customCreditAppLayout);
        return customCreditAppLayout;
    }

    public List<Page2InfoXmlBean> populateInfoBean(List<CustomCreditAppValuesLayoutBeanBean> customCreditAppLayout)
            throws Exception {
        //
        String category = null;
        String categoryCode = null;
        //
        String name = null;
        String value = null;
        String valueCode = null;
        Page2InfoXmlBean pg = null;
        List<Page2InfoXmlBean> ls = new ArrayList<Page2InfoXmlBean>();
        for (CustomCreditAppValuesLayoutBeanBean bean : customCreditAppLayout) {
            category = bean.getName();
            categoryCode = bean.getId().toString();
            for (CustomCreditAppValuesBean val : bean.getValuesList()) {
                name = val.getQuestion();
                value = val.getValue();
                valueCode = val.getId().toString();
                //
                pg = new Page2InfoXmlBean();
                pg.setCategory(getValueForXml(category));
                pg.setCategoryCode(getValueForXml(categoryCode));
                pg.setName(getValueForXml(name));
                pg.setValue(getValueForXml(value));
                pg.setValueCode(getValueForXml(valueCode));
                //
                ls.add(pg);
                // System.out.println(categoryCode+", "+category+", "+name+",
                // "+value+", "+valueCode);
            }
        }
        return ls;
    }

    public List<Page2InfoXmlBean> populateInfoBean2(List<CustomCreditAppValuesLayoutBeanBean> customCreditAppLayout)
            throws Exception {
        //
        String category = null;
        String categoryCode = null;
        //
        String name = null;
        String value = null;
        String valueCode = null;
        Page2InfoXmlBean pg = null;
        List<Page2InfoXmlBean> ls = new ArrayList<Page2InfoXmlBean>();
        for (CustomCreditAppValuesLayoutBeanBean bean : customCreditAppLayout) {
            category = bean.getName();
            categoryCode = bean.getId().toString();
            for (CustomCreditAppValuesBean val : bean.getValuesList()) {
                name = val.getQuestion();
                value = val.getValue();
                valueCode = val.getId().toString();
                //
                pg = new Page2InfoXmlBean();
                pg.setCategory(getValueForXml(category));
                pg.setCategoryCode(getValueForXml(categoryCode));
                pg.setName(getValueForXml(name));
                pg.setValue(getValueForXml(value));
                pg.setValueCode(getValueForXml(valueCode));
                /*
                 * pg = new Page2InfoXmlBean();
                 * pg.setCategory(getValueForXml("a"));
                 * pg.setCategoryCode(getValueForXml("b"));
                 * pg.setName(getValueForXml("c"));
                 * pg.setValue(getValueForXml("d"));
                 * pg.setValueCode(getValueForXml("e"));
                 */
                ls.add(pg);
                // System.out.println(categoryCode+", "+category+", "+name+",
                // "+value+", "+valueCode);
            }
        }
        return ls;
    }

    public static void test(List<CustomCreditAppValuesLayoutBeanBean> customCreditAppLayout)
            throws Exception {
        //
        String category = null;
        String categoryCode = null;
        //
        String name = null;
        String value = null;
        String valueCode = null;
        for (CustomCreditAppValuesLayoutBeanBean bean : customCreditAppLayout) {
            category = bean.getName();
            categoryCode = bean.getId().toString();
            for (CustomCreditAppValuesBean val : bean.getValuesList()) {
                name = val.getQuestion();
                value = val.getValue();
                valueCode = val.getId().toString();
                //
                System.out.println(categoryCode + ", " + category + ", " + name
                        + ", " + value + ", " + valueCode);
            }
        }
    }

    
    /**
     * @param pastCreditApp
     * @return
     * @throws Exception
     */
    public List<CustomAppLayout> processPage2AdvanceConfig(PastCreditAppBean pastCreditApp)
            throws Exception {
        if(pastCreditApp.getCustomAppAttrValueSet() ==null){
            return null;
        }
        List<CustomAppAttrValueBean> customAppAttrValues = new ArrayList<CustomAppAttrValueBean>(
                pastCreditApp.getCustomAppAttrValueSet());
        List<CustomAppLayout> customAppLayouts = previewLayout(customAppAttrValues);
        return customAppLayouts;
    }    
    
    public List<Page2InfoXmlBean> populateInfoBeanWithAdvancePage2(List<CustomAppLayout> customAppLayouts)
            throws Exception {
        //
        String category = null;
        String categoryCode = null;
        //
        
       
        List<Page2InfoXmlBean> ls = new ArrayList<Page2InfoXmlBean>();
        for (CustomAppLayout bean : customAppLayouts) {
            category = bean.getCustomAppAttrGrpLayout().getName();
            categoryCode = bean.getId().toString();
            populatePage2ValueLis(category, categoryCode, ls, bean);
        }
        return ls;
    }
    
    
    /**
	 * @param category
	 * @param categoryCode
	 * @param ls
	 * @param bean
	 */
	private void populatePage2ValueLis(String category, String categoryCode, List<Page2InfoXmlBean> ls,
			CustomAppLayout bean) {
		Page2InfoXmlBean pg = null;
		String name = null;
		String value = null;
		List<CustomAppAttrValueBean> attributeList=bean.getCustomAppAttrGrpLayout().getAttributeValueList();
		Collections.sort(attributeList);
		for (CustomAppAttrValueBean val : attributeList) {
		    if(val==null || val.getAttributeDef()==null || val.getAttributeDef().isSignatureBoo()){
		        continue;
		    }
		    bean.getCustomAppAttrGrpLayout().evaluateValues(val);
		    name = val.getAttributeDef().getName();
		    if(val.getAttributeDef().isSingleSelectBoo()){
		        value=val.getDisplayValue();
		    } else if(val.getAttributeDef().isMultiSelectBoo()){
		        value=val.getDisplayValue();
		    } else if(val.getAttributeDef().isDateBoo()){
		        value=String.valueOf(val.getDateValue());
		    }else if(val.getAttributeDef().isBooleanBoo()){
		         value=val.getDisplayValue();
		    }else{
		        value = val.getValue();
		    }
		    
		    //
			if (val.getAttributeDef().isShowRuleBoo()) {
				pg = new Page2InfoXmlBean();
				pg.setCategory(getValueForXml(category));
				pg.setCategoryCode(getValueForXml(categoryCode));
				pg.setName(getValueForXml(name));
				pg.setValue(getValueForXml(value));
				pg.setValueCode(getValueForXml(val.getValueCode()));
				//
				ls.add(pg);
			}
		}
	}
	/**
     * @param customAppAttrValues
     * @throws DataAccessException
     */
    public List<CustomAppLayout>  previewLayout(List<CustomAppAttrValueBean> customAppAttrValues)
            throws DataAccessException {
        Map<Long, CustomAppLayout> customAppLayoutMap = new HashMap<Long, CustomAppLayout>();
        List<CustomAppLayout> customAppLayoutList = new ArrayList<CustomAppLayout>();
        if (customAppAttrValues != null && customAppAttrValues.size() > 0) {
            Map<Long, CustomAppAttrGrpLayout> customAppAttrGrpLayoutMap = previewCustomAppAttrGrpLayout(customAppAttrValues);
            Set<Entry<Long, CustomAppAttrGrpLayout>> entries = sortMapByValues(
                    customAppAttrGrpLayoutMap).entrySet();
            for (Entry<Long, CustomAppAttrGrpLayout> entry : entries) {
                Long customAppAttrGrpID = entry.getKey();
                CustomAppLayout customAppLayout = null;
                if (customAppLayoutMap.containsKey(customAppAttrGrpID)) {
                    customAppLayout = customAppLayoutMap
                            .get(customAppAttrGrpID);
                } else {
                    customAppLayout = initialize(customAppAttrGrpID);
                }
                CustomAppAttrGrpLayout customAppAttrGrpLayout = entry
                        .getValue();
                 // add the attribute group Layout
                customAppLayout
                        .setCustomAppAttrGrpLayout(customAppAttrGrpLayout);
                customAppLayoutList.add(customAppLayout);
            }
        }
        Collections.sort(customAppLayoutList);
       return customAppLayoutList;
    }
    
    private Map<Long, CustomAppAttrGrpLayout> sortMapByValues(Map<Long, CustomAppAttrGrpLayout> aMap) {
        Set<Entry<Long, CustomAppAttrGrpLayout>> mapEntries = aMap.entrySet();
        // used linked list to sort, because insertion of elements in linked
        // list is faster than an array list.
        List<Entry<Long, CustomAppAttrGrpLayout>> aList = new LinkedList<Entry<Long, CustomAppAttrGrpLayout>>(
                mapEntries);
        // sorting the List
        Collections.sort(aList,
                new Comparator<Entry<Long, CustomAppAttrGrpLayout>>() {
                    @Override
                    public int compare(Entry<Long, CustomAppAttrGrpLayout> ele1,
                                       Entry<Long, CustomAppAttrGrpLayout> ele2) {
                        return ele1.getValue().compareTo(ele2.getValue());
                    }
                });
        // Storing the list into Linked HashMap to preserve the order of
        // insertion.
        Map<Long, CustomAppAttrGrpLayout> resultMap = new LinkedHashMap<Long, CustomAppAttrGrpLayout>();
        for (Entry<Long, CustomAppAttrGrpLayout> entry : aList) {
            resultMap.put(entry.getKey(), entry.getValue());
        }

        return resultMap;
    }
    
    public Map<Long, CustomAppAttrGrpLayout> previewCustomAppAttrGrpLayout(List<CustomAppAttrValueBean> attributeValueList)
            throws DataAccessException {
        Map<Long, CustomAppAttrGrpLayout> customAppAttrGrpMap = new HashMap<Long, CustomAppAttrGrpLayout>();
        if (attributeValueList != null) {
            for (CustomAppAttrValueBean attributeValueBean : attributeValueList) {
                String id = attributeValueBean.getId();
                StringTokenizer tokens = new StringTokenizer(id,
                        MatrixConstants.FORMULA_SEPARATOR);
                if (tokens.countTokens() != 4) {
                    return customAppAttrGrpMap;
                }
                // skip the first token - customAppAttrGrp ID
                Long customAppAttrGrpID = Long.parseLong(tokens.nextToken());
                long attributeGroupID = attributeValueBean
                        .getAttributeGroupID();
                CustomAppAttrGrpLayout attrGroupLayout = null;
                if (customAppAttrGrpMap.containsKey(customAppAttrGrpID)) {
                    attrGroupLayout = customAppAttrGrpMap
                            .get(customAppAttrGrpID);
                } else {
                    attrGroupLayout = getAttributeGroupLayout(
                            customAppAttrGrpID, attributeGroupID);
                }
                // add values to the group
                addAttributeDef(attributeValueBean, attrGroupLayout);
                // add attribute values to attr group
                attrGroupLayout.addAttributeValue2List(attributeValueBean);
                // add attribute group layout to customAppAttrGrpID
                customAppAttrGrpMap.put(customAppAttrGrpID, attrGroupLayout);
            }
        }
        return customAppAttrGrpMap;
    }
    
    private void addAttributeDef(CustomAppAttrValueBean attributeValueBean,
                                        AttributeGroupBean attributeGroupBean) {
        if (attributeGroupBean != null) {
            List<AttributeDefBean> attributeDefBeans = attributeGroupBean
                    .getAllAttributesList();
            for (AttributeDefBean attributeDefBean : attributeDefBeans) {
                long attributeDefID = attributeDefBean.getAttributeDefID();
                if (attributeDefID == attributeValueBean.getAttributeDefID()
                        .longValue()) {
                    attributeValueBean.setAttributeDef(attributeDefBean);
                }
            }
        }
    }
    
    private CustomAppLayout initialize(long customAppAttrGrpID)
            throws DataAccessException {
        CustomAppLayout customAppLayout = null;
        GroupCustomAppAttrGrpBean grpCustomAppAttrGrp = GroupCustomAppAttrGrpDAO.getInstance().retrieveGroupCustomAppAttrGrp(customAppAttrGrpID);
        customAppLayout = new CustomAppLayout();
        customAppLayout.setAttributeGroupID(grpCustomAppAttrGrp
                .getAttributeGroupID());
        customAppLayout.setEditable(grpCustomAppAttrGrp.getEditable());
        customAppLayout.setViewable(grpCustomAppAttrGrp.getViewable());
        customAppLayout.setCreatedBy(grpCustomAppAttrGrp.getCreatedBy());
        customAppLayout.setCreatedDate(grpCustomAppAttrGrp.getCreatedDate());
        customAppLayout.setFormType(grpCustomAppAttrGrp.getFormType());
        customAppLayout.setGroupID(grpCustomAppAttrGrp.getGroupID());
        customAppLayout.setId(grpCustomAppAttrGrp.getId());
        customAppLayout.setModifiedBy(grpCustomAppAttrGrp.getModifiedBy());
        customAppLayout.setModifiedDate(grpCustomAppAttrGrp.getModifiedDate());
        customAppLayout.setName(grpCustomAppAttrGrp.getName());
        customAppLayout.setStatus(grpCustomAppAttrGrp.getStatus());
        return customAppLayout;
    }
    
    private static CustomAppAttrGrpLayout getAttributeGroupLayout(long wfStepAttrGrpID,
                                                                  long attributeGroupID)
            throws DataAccessException {
        // Prepare the attribute group layout
        CustomAppAttrGrpLayout attrGroupLayout = new CustomAppAttrGrpLayout();
        AttributeGroupBean attrGroup = AttributeGroupDAO
                .retrieveAttributeGroup(attributeGroupID);
        attrGroupLayout.setAccessType(attrGroup.getAccessType());
        attrGroupLayout.setAppType(attrGroup.getAppType());
        attrGroupLayout.setAttributeGroupID(attrGroup.getAttributeGroupID());
        attrGroupLayout.setAttributes(attrGroup.getAttributes());
        attrGroupLayout.setCreatedBy(attrGroup.getCreatedBy());
        attrGroupLayout.setCreatedDate(attrGroup.getCreatedDate());
        attrGroupLayout.setModifiedBy(attrGroup.getModifiedBy());
        attrGroupLayout.setModifiedDate(attrGroup.getModifiedDate());
        attrGroupLayout.setDescription(attrGroup.getDescription());
        attrGroupLayout.setFlags(attrGroup.getFlags());
        attrGroupLayout.setShowOrder(attrGroup.getShowOrder());
        attrGroupLayout.setSupplierID(attrGroup.getSupplierID());
        attrGroupLayout.setGroupID(attrGroup.getGroupID());
        attrGroupLayout.setName(attrGroup.getName());
        attrGroupLayout.setParams(attrGroup.getParams());
        attrGroupLayout.setPreQualReq(attrGroup.getPreQualReq());
        return attrGroupLayout;
    }    
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("----start---");
        //
        PastCreditAppBean app = new CreditRequestDAO().getPastRequest(39556);
        new Page2InformationHelper().processPage2(app);
        System.out.println("----stop---");
    }
}
