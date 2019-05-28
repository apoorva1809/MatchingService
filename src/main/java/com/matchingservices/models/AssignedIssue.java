/**
 * 
 */
package com.matchingservices.models;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author apoorvatejavanam
 *
 */
public class AssignedIssue implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected String customerEmail;
	
	
	protected int issueId;
	
	protected int techId;
	


	public int getTechId() {
		return techId;
	}


	public void setTechId(int techId) {
		this.techId = techId;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public int getIssueId() {
		return issueId;
	}


	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}



	
	
	

}
