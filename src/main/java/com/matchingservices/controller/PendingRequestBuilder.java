/**
 * 
 */
package com.matchingservices.controller;


import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matchingservices.kafka.KafkaProducer;
import com.matchingservices.kafka.ReservationDetails;
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

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
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
	
	@Autowired
	private KafkaProducer producer;

   @RequestMapping(value="/AssignTechnicians", method = RequestMethod.GET)
    public @ResponseBody List<ReservationDetails> submitRequest() {
    logger.info("Entered into submitRequest Method");
    ObjectMapper mapper = new ObjectMapper();
    ReservationDetails reservationDetails=null;
    String ReservationCode="";
    List<ReservationDetails> listOfTechAppended=new ArrayList<ReservationDetails>();
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
         		
           ReservationCode	=	matchingservice.reserveTechnician(issue.getCustIssues().getIssueId(), issue.getCustIssues().getCustEmail(), technician.getTechId());
           reservationDetails=new ReservationDetails();
           reservationDetails.setReservCode(ReservationCode);
           reservationDetails.setCustEmail(issue.getCustIssues().getCustEmail());
           listOfTechAppended.add(reservationDetails);
         	}else {
         		logger.info("No technician available");
         	}
         
         }
         String jsonInString = mapper.writeValueAsString(reservationDetails);
         producer.sendMessage(jsonInString);
         
    } catch (Exception e) {
  			logger.error("Exception in processing Assigned technicians " + e);
  		}
    
    
   
    return listOfTechAppended;
        
        
        
}

}	