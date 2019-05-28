/**
 * 
 */
package com.matchingservices.oracle.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.matchingservices.models.Criteria;
import com.matchingservices.models.CustPendingIssues;
import com.matchingservices.models.Technicians;

/**
 * @author apoorvatejavanam
 *
 */
@Component
public interface MatchingServiceOracleDao {
	
	
	/**
	 * @return
	 */
	public int getNumOfPendingIssues();
	
	public List<CustPendingIssues> getCustomerPendingIssues();
	
	public Technicians findTechnician(Criteria criteria);
	
	public void updateTechnicianStatus(Technicians technician);

	public void updateTechnicianAssigned(int issueId, String customerEmail, int techId, String uuid);

}
