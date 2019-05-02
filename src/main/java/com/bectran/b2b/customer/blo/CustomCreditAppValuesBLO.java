/**
 *
 */
package com.bectran.b2b.customer.blo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bectran.b2b.customer.beans.CustomCreditAppValuesBean;
import com.bectran.b2b.customer.beans.CustomCreditAppValuesDraftBean;
import com.bectran.b2b.customer.beans.CustomCreditAppValuesLayoutBeanBean;
import com.bectran.b2b.supplier.beans.GroupCustomAppCategoryBean;
import com.bectran.b2b.supplier.beans.GroupCustomAppCntrlBean;
import com.bectran.b2b.supplier.beans.GroupCustomCreditAppListContentBean;
import com.bectran.b2b.supplier.beans.GroupCustomCreditAppModelBean;
import com.bectran.b2b.supplier.dao.GroupCustomAppCategoryDAO;
import com.bectran.b2b.supplier.dao.GroupCustomCreditAppModelDAO;
import com.bectran.matrix.framework.BectranAESUtil;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MatrixPasswordUtil;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 3, 2012 : 5:56:48 PM
 */
public class CustomCreditAppValuesBLO {
    public static List<CustomCreditAppValuesBean> previewAppLayout(List<GroupCustomCreditAppModelBean> list) {
        //
        return buildNewAppContent(list);
    }

    public static List<CustomCreditAppValuesLayoutBeanBean> previewAppLayout(GroupCustomAppCntrlBean bean)
            throws DataAccessException {
        //
        List<GroupCustomCreditAppModelBean> list = GroupCustomCreditAppModelDAO
                .find(bean.getId());
        List<CustomCreditAppValuesBean> vlist = buildNewAppContent(list);
        //
        List<GroupCustomAppCategoryBean> categoryModel = GroupCustomAppCategoryDAO
                .find(bean.getGroupId().longValue());
        //
        return constructAppLayout(vlist, categoryModel);
    }

    public static List<CustomCreditAppValuesLayoutBeanBean> constructAppLayout(List<CustomCreditAppValuesBean> vlist,
                                                                               List<GroupCustomAppCategoryBean> categoryModel) {
        List<CustomCreditAppValuesLayoutBeanBean> layout = new ArrayList<CustomCreditAppValuesLayoutBeanBean>();
        for (GroupCustomAppCategoryBean bean : categoryModel) {
            List<CustomCreditAppValuesBean> ls = getValuesListByCategory(vlist,
                    bean.getId());
            if (ls != null && ls.size() > 0) {
                CustomCreditAppValuesLayoutBeanBean lbean = buildLayout(bean,
                        ls);
                layout.add(lbean);
            }
        }
        Collections.sort(layout,
                CustomCreditAppValuesLayoutBeanBean.ASCENDING_ORDER);
        return layout;
    }

    private static CustomCreditAppValuesLayoutBeanBean buildLayout(GroupCustomAppCategoryBean model,
                                                                   List<CustomCreditAppValuesBean> valuesList) {
        //
        CustomCreditAppValuesLayoutBeanBean bean = new CustomCreditAppValuesLayoutBeanBean();
        bean.setDisplayOrder(model.getDisplayOrder());
        bean.setGroupId(model.getGroupId());
        bean.setId(model.getId());
        bean.setName(model.getName());
        bean.setValuesList(valuesList);
        //
        return bean;
    }

    private static List<CustomCreditAppValuesBean> buildNewAppContent(List<GroupCustomCreditAppModelBean> attrList) {
        //
        List<CustomCreditAppValuesBean> quesList = new ArrayList<CustomCreditAppValuesBean>();
        for (Iterator<GroupCustomCreditAppModelBean> i = attrList.iterator(); i
                .hasNext();) {
            GroupCustomCreditAppModelBean model = i.next();
            CustomCreditAppValuesBean bean = new CustomCreditAppValuesBean();
            if (model.isHasListType()) {
                Set<GroupCustomCreditAppListContentBean> predefinedSet = model
                        .getListContentSet();
                if (predefinedSet != null && predefinedSet.size() > 1) {
                    bean.setPredefinedListContent(model.getContentList());
                    bean.setHasPredefinedList(true);
                    // initilize answer
                    GroupCustomCreditAppListContentBean answer = predefinedSet
                            .iterator().next();
                    bean.setAnswerId(answer.getId());
                    bean.setValue(answer.getName());
                }
            }
            bean.setName(model.getName());
            bean.setQuestionId(model.getId());
            bean.setQuestion(model.getName());
            bean.setAnsInputId(model.getId().toString() + "a"); // for page
                                                                // input
            bean.setDataType(model.getDataType());
            //
            bean.setRequired(model.getRequired());
            bean.setEncryptData(model.getEncryptData());
            bean.setDisplayOrder(model.getDisplayOrder());
            bean.setListType(model.getListType());
            bean.setCatId(model.getCatId());
            bean.setCode(model.getCode());
            //
            quesList.add(bean);
        }
        Collections.sort(quesList, CustomCreditAppValuesBean.ASCENDING_ORDER);
        return quesList;
    }

    public static List<CustomCreditAppValuesBean> getValuesListByCategory(List<CustomCreditAppValuesBean> valuesList,
                                                                          Long catId) {
        List<CustomCreditAppValuesBean> ls = new ArrayList<CustomCreditAppValuesBean>();
        for (CustomCreditAppValuesBean bean : valuesList) {
            if (bean.getCatId().equals(catId)) {
                ls.add(bean);
            }
        }
        Collections.sort(ls, CustomCreditAppValuesBean.ASCENDING_ORDER);
        return ls;
    }

    public static String getAnswerDescription(List<GroupCustomCreditAppListContentBean> answersForQuestion,
                                              Long answerId) {
        for (Iterator<GroupCustomCreditAppListContentBean> i = answersForQuestion
                .iterator(); i.hasNext();) {
            GroupCustomCreditAppListContentBean ans = i.next();
            if (ans.getId().equals(answerId)) {
                return ans.getName();
            }
        }
        return "";
    }

    public static Map<Long, CustomCreditAppValuesDraftBean> mapOfExistingAnswers(Set<CustomCreditAppValuesDraftBean> customAppSet) {
        Map<Long, CustomCreditAppValuesDraftBean> mp = new HashMap<Long, CustomCreditAppValuesDraftBean>();
        for (Iterator<CustomCreditAppValuesDraftBean> i = customAppSet
                .iterator(); i.hasNext();) {
            CustomCreditAppValuesDraftBean bean = i.next();
            mp.put(bean.getQuestionId(), bean);
        }
        return mp;
    }

    public static void setExistingAnswers(List<CustomCreditAppValuesBean> valuesList,
                                          Map<Long, CustomCreditAppValuesDraftBean> mapOfValues)
            throws Exception {
        for (Iterator<CustomCreditAppValuesBean> i = valuesList.iterator(); i
                .hasNext();) {
            CustomCreditAppValuesBean bean = i.next();
            CustomCreditAppValuesDraftBean workBean = mapOfValues
                    .get(bean.getQuestionId());
            if (workBean != null) {
                bean.setValue(workBean.getValue());
                if (bean.isFieldIsEncryptionType() && bean.getValue() != null
                        && bean.getValue().trim().length() > 0) {
                    // System.out.println("================
                    // bean.getEncSalt().trim()================>>>"+
                    // bean.getEncSalt().trim());
                    // bean.setEncSalt(workBean.getEncSalt());
                    String clearValue = CustomCreditAppValuesBLO
                            .deCryptValue(bean.getValue());
                    bean.setValue(clearValue);// store value as ecncrypted
                }
                if (bean.isHasPredefinedList()) {
                    bean.setAnswerId(workBean.getAnswerId());
                }
            }
        }
    }

    private static List<CustomCreditAppValuesDraftBean> initializeDrafBean(List<CustomCreditAppValuesBean> appValuesList,
                                                                           Long appProgressId,
                                                                           String draftIdCode) {
        //
        List<CustomCreditAppValuesDraftBean> quesList = new ArrayList<CustomCreditAppValuesDraftBean>();
        for (Iterator<CustomCreditAppValuesBean> i = appValuesList.iterator(); i
                .hasNext();) {
            CustomCreditAppValuesBean valuesBean = i.next();
            CustomCreditAppValuesDraftBean bean = new CustomCreditAppValuesDraftBean();
            //
            bean.setDraftId(draftIdCode + valuesBean.getQuestionId());
            //
            bean.setName(valuesBean.getName());
            bean.setQuestionId(valuesBean.getQuestionId());
            bean.setQuestion(valuesBean.getName());
            // bean.setAnsInputId(valuesBean.getId().toString()+"a"); //for page
            // input
            bean.setDataType(valuesBean.getDataType());
            //
            bean.setRequired(valuesBean.getRequired());
            bean.setEncryptData(valuesBean.getEncryptData());
            bean.setDisplayOrder(valuesBean.getDisplayOrder());
            bean.setListType(valuesBean.getListType());
            //
            bean.setValue(valuesBean.getValue());
            if (bean.isHasPredefinedList()) {
                bean.setAnswerId(valuesBean.getAnswerId());
            }
            bean.setHeaderId(appProgressId);
            //
            quesList.add(bean);
        }
        // Collections.sort(quesList,
        // CustomCreditAppValuesBean.ASCENDING_ORDER);
        return quesList;
    }

    public static String encryptValue(String value) throws Exception {
        String encryPtedVal = BectranAESUtil.encryptKey(value,
                CustomCreditAppValuesBean.ENC_TYPE_SALT);
        return encryPtedVal;
    }

    public static String randomSalt() throws Exception {
        return MatrixPasswordUtil.generatePassword(7);
    }

    public static String deCryptValue(String value) throws Exception {
        String decValue = null;
        try {
            decValue = BectranAESUtil.decryptKey(value,
                    CustomCreditAppValuesBean.ENC_TYPE_SALT);
        }
        catch (Exception e) {
            decValue = value;
        }
        return decValue;
    }

    public static void decryptValues(List<CustomCreditAppValuesBean> valuesList)
            throws Exception {
        for (Iterator<CustomCreditAppValuesBean> i = valuesList.iterator(); i
                .hasNext();) {
            CustomCreditAppValuesBean bean = i.next();
            if (bean.isFieldIsEncryptionType() && bean.getValue() != null
                    && bean.getValue().trim().length() > 0) {
                String clearValue = CustomCreditAppValuesBLO
                        .deCryptValue(bean.getValue());
                bean.setValue(clearValue);// store value as ecncrypted
            }
        }
    }
}
