package com.matchingservices.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="technicianassigned",schema = "system")
public class TechnicianAssigned {
	
@EmbeddedId
private AssignedIssue assignedIssues;



@Column(name = "ReservationNumber")
private String reservationCode;



public AssignedIssue getAssignedIssues() {
	return assignedIssues;
}



public void setAssignedIssues(AssignedIssue assignedIssues) {
	this.assignedIssues = assignedIssues;
}



public String getReservationCode() {
	return reservationCode;
}



public void setReservationCode(String reservationCode) {
	this.reservationCode = reservationCode;
}





}
