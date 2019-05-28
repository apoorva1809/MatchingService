package com.matchingservices.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author apoorvatejavanam
 *
 */

@Entity
@Table(name="issues",schema = "system")
public class Issues implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "ISSUEID")
	private int issueId;
	
	
	@Column(name = "ISSUENAME")
	private String issueName;
	

	@Column(name = "criteria")
	private Criteria criteria;
	
	
	


	public Criteria getCriteria() {
		return criteria;
	}


	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getIssueId() {
		return issueId;
	}


	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}


	public String getIssueName() {
		return issueName;
	}


	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}
	
	
	

}
