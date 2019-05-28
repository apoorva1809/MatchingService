/**
 * 
 */
package com.matchingservices.process.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.matchingservices.controller.PendingRequestBuilder;
import com.matchingservices.models.Criteria;
import com.matchingservices.models.CustPendingIssues;
import com.matchingservices.models.Technicians;
import com.matchingservices.oracle.dao.MatchingServiceOracleDao;
import com.matchingservices.process.MatchingService;

/**
 * @author apoorvatejavanam
 *
 */


@Component
public class MatchingServiceImpl implements MatchingService {
	
	private static final Logger logger=LoggerFactory.getLogger(MatchingServiceImpl.class);
	
	
	@Autowired
	MatchingServiceOracleDao matchingServiceOracleDao;
	

	@Override
	public int numIssues() {
		// TODO Auto-generated method stub
		logger.info("Entered into numIssues method");
		int numOfPendingIssues=0;
		try {
		numOfPendingIssues=matchingServiceOracleDao.getNumOfPendingIssues();
		}catch(Exception e) {
			logger.error("Exception found in finding Num of Pending Issues"+e);
		}
		return numOfPendingIssues;
	}

	@Override
	public Technicians findAndAssignTecnician(Criteria criteria, String customerEmail) {
		// TODO Auto-generated method stub
		Technicians technician=null;
		try {
		 technician=matchingServiceOracleDao.findTechnician(criteria);
		}catch(Exception e) {
			logger.error("Exception raised in findAndAssignTecnician"+e);
		}
		return technician;
	}

	@Override
	public String reserveTechnician(int issueId, String customerEmail, int techId) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0,5);
		try {
		matchingServiceOracleDao.updateTechnicianAssigned(issueId,customerEmail,techId,uuid);
		}catch(Exception e) {
			logger.info("Exception caught in reserve Technician "+e);
		}
		return uuid;
	}
	
	
	public List<CustPendingIssues> processPendingRequests() {
		
		List<CustPendingIssues> pendingIssuesList=null;
		
		try {
		pendingIssuesList=matchingServiceOracleDao.getCustomerPendingIssues();
		}catch(Exception e) {
			logger.error("Exception caught in processPendingRequests"+e);
		}
		
		
		return pendingIssuesList;
		
		
	}

	@Override
	public void updateTechnicianStatus(Technicians technician) {
		// TODO Auto-generated method stub
		matchingServiceOracleDao.updateTechnicianStatus(technician);
		
	}


}
