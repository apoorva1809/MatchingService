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
@Table(name="criteria",schema = "system")
public class Criteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "criteriaId")
	private int criteriaId;
	
	
	@Column(name = "criteriaName")
	private String criteriaName;


	public int getCriteriaId() {
		return criteriaId;
	}


	public void setCriteriaId(int criteriaId) {
		this.criteriaId = criteriaId;
	}


	public String getCriteriaName() {
		return criteriaName;
	}


	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	




	
	

}
