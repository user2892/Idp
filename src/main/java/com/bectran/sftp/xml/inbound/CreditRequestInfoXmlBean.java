/**
 * 
 */
package com.bectran.sftp.xml.inbound;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author LOUIS IFEGUNI
 *
 * @date Jul 28, 2017 / 2:13:13 PM
 *
 */

@XmlType(propOrder={"requestId", "requestSource", "amountRequested", "termRequestedCode" ,"termRequestedDescription" ,"plannedPurchase", "requestDate", "requestFormType" })
public class CreditRequestInfoXmlBean {
	
	private String requestId;
	private String requestSource;
	private BigDecimal amountRequested;
	private String termRequestedCode;
	private String termRequestedDescription;
	private String plannedPurchase;
	private String requestDate;
	private String requestFormType;

	//
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getRequestSource() {
		return requestSource;
	}
	public void setRequestSource(String requestType) {
		this.requestSource = requestType;
	}
	public BigDecimal getAmountRequested() {
		return amountRequested;
	}
	public void setAmountRequested(BigDecimal amountRequested) {
		this.amountRequested = amountRequested;
	}
	public String getTermRequestedCode() {
		return termRequestedCode;
	}
	public void setTermRequestedCode(String termRequestedCode) {
		this.termRequestedCode = termRequestedCode;
	}
	public String getTermRequestedDescription() {
		return termRequestedDescription;
	}
	public void setTermRequestedDescription(String termRequestedDescription) {
		this.termRequestedDescription = termRequestedDescription;
	}
	public String getPlannedPurchase() {
		return plannedPurchase;
	}
	public void setPlannedPurchase(String plannedPurchase) {
		this.plannedPurchase = plannedPurchase;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getRequestFormType() {
		return requestFormType;
	}
	public void setRequestFormType(String requestFormType) {
		this.requestFormType = requestFormType;
	}

	
	
}
