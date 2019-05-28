/**
 * 
 */
package com.matchingservices.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author apoorvatejavanam
 *
 */

@Entity
@Table(name="customer",schema = "system")
public class Customer {
	
	
	@Id
	@GeneratedValue
	@Column(name = "customerId")
	private int custId;
	
	
	@Column(name = "custEmail")
	private String custEmail;


	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public String getCustEmail() {
		return custEmail;
	}


	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}



	
	
	
	
	

}
