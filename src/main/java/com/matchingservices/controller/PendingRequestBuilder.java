/**
 * 
 */
package com.matchingservices.controller;


import org.springframework.web.bind.annotation.RestController;

import com.matchingservices.models.Criteria;
import com.matchingservices.models.CustPendingIssues;
import com.matchingservices.models.Technicians;
import com.matchingservices.process.MatchingService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import org.slf4j.Logger;

/**
 * @author apoorvatejavanam
 *
 */

@RestController
public class PendingRequestBuilder {
	
	private static final Logger logger=LoggerFactory.getLogger(PendingRequestBuilder.class);
	
	@Autowired
	private MatchingService matchingservice;

   @RequestMapping(value="/AssignTechnicians", method = RequestMethod.GET)
    public @ResponseBody String submitRequest() {
    logger.info("Entered into submitRequest Method");
    try {
         List<CustPendingIssues> pendingIssuesList=null;
         Technicians technician=null; 
         int NumOfIssues=matchingservice.numIssues();
         pendingIssuesList=matchingservice.processPendingRequests();
         for(CustPendingIssues issue:pendingIssuesList) {
         	Criteria criteria=new Criteria();
         	criteria.setCriteriaId(issue.getCriteriaId());
         	
         	technician=matchingservice.findAndAssignTecnician(criteria, issue.getCustIssues().getCustEmail());
         	
         	if(technician!=null) {
         		//Update the status to unavailable
         		matchingservice.updateTechnicianStatus(technician);
         		
           String ReservationCode	=	matchingservice.reserveTechnician(issue.getCustIssues().getIssueId(), issue.getCustIssues().getCustEmail(), technician.getTechId());
         	}else {
         		logger.info("No technician available");
         	}
         
         }
         
    } catch (Exception e) {
  			logger.error("Exception in processing Assigned technicians " + e);
  		}
    
    
   
    return "Greetings from Spring Boot!";
        
        
        
}

}	