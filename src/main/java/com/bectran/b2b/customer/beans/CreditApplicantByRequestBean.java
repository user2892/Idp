/**
 * 
 */
package com.bectran.b2b.customer.beans;

import com.bectran.b2b.base.beans.UserBaseBean;

/**
 * @author LOUIS IFEGUNI
 *
 * Date: Mar 30, 2012 / 11:01:18 AM	
 */
public class CreditApplicantByRequestBean extends UserBaseBean{
	//
	private Long id; //same as request id
//	private String userSupplierId;
//	private Long supplierId;
//	private Long groupId;
//	private String loginCode;

	public CreditApplicantByRequestBean() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
