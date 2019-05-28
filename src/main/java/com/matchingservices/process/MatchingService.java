/**
 * 
 */
package com.matchingservices.process;

import java.util.List;

import org.springframework.stereotype.Component;

import com.matchingservices.models.CustPendingIssues;
import com.matchingservices.models.Technicians;
import com.matchingservices.models.Criteria;

/**
 * @author apoorvatejavanam
 *
 */

@Component
public interface MatchingService {
	
	
	/**
	 * @return
	 */
	int numIssues();
	
	
	/**
	 * @param criteria
	 * @param customerEmail
	 * @return
	 */
	Technicians findAndAssignTecnician(Criteria criteria, String customerEmail);
	
	
	
	/**
	 * @param issueId
	 * @param customerEmail
	 * @param techId
	 * @return
	 */
	String reserveTechnician(int issueId, String customerEmail, int techId);
	
	
	
	public List<CustPendingIssues> processPendingRequests();
	

	public void updateTechnicianStatus(Technicians technician);
	

}
