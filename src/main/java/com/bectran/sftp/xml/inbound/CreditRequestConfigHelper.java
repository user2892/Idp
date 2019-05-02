/**
 * 
 */
package com.bectran.sftp.xml.inbound;

import com.bectran.b2b.constants.CustomCreditAppConstant;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.customer.beans.PastCreditAppBean;

/**
 * @author LOUIS IFEGUNI
 *
 * @date Jul 28, 2017 / 3:39:00 PM
 *
 */
public class CreditRequestConfigHelper {
	
	public static final String SOURCE_PAPER_APPLICATION = "PAPER-APPLICATION";
	public static final String SOURCE_CREDIT_REVIEW = "CREDIT-REVIEW";
	public static final String SOURCE_ENHANCED_PAPER_APPLICATION = "ENHANCED-PAPER-APPLICATION";
	public static final String SOURCE_ONLINE_APPLICATION = "ONLINE-APPLICATION";
	
	//
	public static final String FORM_TYPE_CREDIT_APPLICATION = "CREDIT-APPLICATION";
	public static final String FORM_TYPE_COD_NEW_ACCOUNT_APPLICATION = "COD-NEW-ACCT-APPLICATION";
	public static final String FORM_TYPE_SOLE_PROPRIETOR_APPLICATION = "SOLE-PROPRIETOR-APPLICATION";
	
	//
	public static String determineRequestSource(PastCreditAppBean app){
		
		if(app.getPaperCreditAppType().trim().equals(MatrixConstants.ANSWER_YES)){
			return SOURCE_PAPER_APPLICATION;
		}
		
		if(app.getEnhanchedPaperCreditAppType().trim().equals(MatrixConstants.ANSWER_YES)){
			return SOURCE_ENHANCED_PAPER_APPLICATION;
		}
		
		if(app.getReviewType().trim().equals(MatrixConstants.ANSWER_YES)){
			return SOURCE_CREDIT_REVIEW;
		}
		
		
		return SOURCE_ONLINE_APPLICATION;
				

	}
	
	
	
	public static String determineFormType(PastCreditAppBean app){
		
		if(app.getFormType().trim().equals(CustomCreditAppConstant.FORM_TYPE_COD)){
			
			return FORM_TYPE_COD_NEW_ACCOUNT_APPLICATION;
		}
		
		if(app.getFormType().trim().equals(CustomCreditAppConstant.FORM_TYPE_SOLE_PROPRIETOR)){
			
			return FORM_TYPE_SOLE_PROPRIETOR_APPLICATION;
		}
		
		
		
		return FORM_TYPE_CREDIT_APPLICATION;
				

	}
}
