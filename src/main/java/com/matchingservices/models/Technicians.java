package com.matchingservices.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="technicians",schema = "system")
public class Technicians {

@Id
@Column(name = "techId")
private int techId;
	
@Column(name = "techName")
private String techName;

@JoinColumn(name = "criteriaid", unique = true)
@OneToOne(cascade = CascadeType.ALL)
private Criteria criteria;

@Column(name = "status")
private String status;

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}



public int getTechId() {
	return techId;
}

public void setTechId(int techId) {
	this.techId = techId;
}

public String getTechName() {
	return techName;
}

public void setTechName(String techName) {
	this.techName = techName;
}

public Criteria getCriteria() {
	return criteria;
}

public void setCriteria(Criteria criteria) {
	this.criteria = criteria;
}


	

}
