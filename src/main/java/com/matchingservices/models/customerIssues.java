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
public class customerIssues implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected String custEmail;
	
	
	protected int issueId;


	


	public String getCustEmail() {
		return custEmail;
	}


	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}


	public int getIssueId() {
		return issueId;
	}


	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}


	
	
	
	
	

}
