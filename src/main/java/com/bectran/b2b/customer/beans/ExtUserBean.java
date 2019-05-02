package com.bectran.b2b.customer.beans;

import com.bectran.b2b.base.beans.TitleAndDeptBean;
import com.bectran.b2b.base.beans.UserBaseBean;
import com.bectran.matrix.utils.GeneralConstantThree;

/**
 * @author LOUIS IFEGUNI Sep 22, 200711:55:26 AM
 */
public class ExtUserBean extends UserBaseBean {
    private String titleName;
    private String departmentName;
    private String acctNum = "";
    private String securityQuestionDetail;
    //
    // private Long supplierId;

    /**
     * DEFAULT CONSTRUCTOR
     */
    public ExtUserBean() {
    }

    public String getDepartmentName() {
        departmentName = new TitleAndDeptBean().getDeptDescription(
                this.department, GeneralConstantThree.TYPE_DEPT_EXTERNAL);
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getTitleName() {
        titleName = new TitleAndDeptBean().getTitleDescription(this.title,
                GeneralConstantThree.TYPE_TITLE_EXTERNAL);
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public String getSecurityQuestionDetail() {
        return securityQuestionDetail;
    }

    public void setSecurityQuestionDetail(String securityQuestionDetail) {
        this.securityQuestionDetail = securityQuestionDetail;
    }
}
