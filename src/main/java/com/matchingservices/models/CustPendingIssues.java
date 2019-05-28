package com.matchingservices.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="custPendingIssues")
public class CustPendingIssues implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private customerIssues custIssues;
	
	@Column(name = "criteriaId")
	private int criteriaId;
	
	
	@Column(name = "status")
	private String status;


	public customerIssues getCustIssues() {
		return custIssues;
	}


	public void setCustIssues(customerIssues custIssues) {
		this.custIssues = custIssues;
	}


	public int getCriteriaId() {
		return criteriaId;
	}


	public void setCriteriaId(int criteriaId) {
		this.criteriaId = criteriaId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
