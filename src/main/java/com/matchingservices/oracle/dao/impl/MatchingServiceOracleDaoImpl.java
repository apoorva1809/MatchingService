/**
 * 
 */
package com.matchingservices.oracle.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import com.matchingservices.models.Issues;
import com.matchingservices.models.TechnicianAssigned;
import com.matchingservices.models.Technicians;
import com.matchingservices.oracle.dao.MatchingServiceOracleDao;
import com.matchingservices.controller.PendingRequestBuilder;
import com.matchingservices.models.AssignedIssue;
import com.matchingservices.models.CustPendingIssues;

/**
 * @author apoorvatejavanam
 *
 */

@Repository
public class MatchingServiceOracleDaoImpl implements MatchingServiceOracleDao {
	
	private static final Logger logger=LoggerFactory.getLogger(MatchingServiceOracleDaoImpl.class);
	
	
	
	
	//@Autowired
	//@Qualifier("matchServcMongoTemplate")
	//MongoOperations mongoTemplate;
	
	@Autowired
	@Qualifier("matchingServiceSessionFactory")
	private SessionFactory sessionFactory;
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public int getNumOfPendingIssues() {
		// TODO Auto-generated method stub
		//Query query=new Query(Criteria.where("issueId").exists(true));
		//int numOfIssues=(int) mongoTemplate.count(query, Issues.class);
		
		//Object issue=null;
		int count=0;
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		List<CustPendingIssues> q=session.createQuery("select count(*) from CustPendingIssues").list();
		
		return q.size();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<CustPendingIssues> getCustomerPendingIssues(){
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<CustPendingIssues> custPendingIssues=session.createQuery("from CustPendingIssues").list();
		session.close();
		return custPendingIssues;
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public Technicians findTechnician(com.matchingservices.models.Criteria criteria) {
		// TODO Auto-generated method stub
		Technicians technician=null;
		Transaction tx= null;
		Session session=null;
		try {
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		List<Technicians> technicianList=session.createQuery("from Technicians where criteriaId="+criteria.getCriteriaId()+" and status='available'").list();
		
		if(technicianList!=null && technicianList.size()>0 )
			technician=technicianList.get(0);
		
	} catch (Exception e) {
		logger.error("Exception in finding Technician " + e);
	}finally {
		tx.commit();
		session.close();
		
	}
		
		return technician;
	}


	@Override
	public void updateTechnicianStatus(Technicians technician) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session=null;
		try {
		 session=sessionFactory.openSession();
		 tx = session.beginTransaction();
		Query query = session.createQuery("update Technicians set status = 'unavailable' where techId ="+technician.getTechId());
		query.executeUpdate();
	} catch (Exception e) {
		logger.error("Exception in updating Technician status" + e);
	}finally {
		tx.commit();
		session.close();
		
	}
	}


	@Override
	public void updateTechnicianAssigned(int issueId, String customerEmail, int techId, String uuid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session=null;
		try {
		 session=sessionFactory.openSession();
		 tx =	session.beginTransaction();
		AssignedIssue issuetobeAssigned=new AssignedIssue();
		issuetobeAssigned.setCustomerEmail(customerEmail);
		issuetobeAssigned.setIssueId(issueId);
		TechnicianAssigned ta=new TechnicianAssigned();
		ta.setReservationCode(uuid);
		ta.setAssignedIssues(issuetobeAssigned);
		//String hql = "INSERT INTO TechnicianAssigned(issueId,custEmail,techId,reservationCode) values("+issueId+","+customerEmail+","+techId+","+uuid+")";
		//Query query = session.createQuery(hql);
		//query.executeUpdate();
		session.save(ta);
		tx.commit();
		session.close();
		} catch (Exception e) {
			logger.error("Exception in updating assignedTechnician table " + e);
		}finally {
			tx.commit();
			session.close();
			
		}
		
	}
	
	


}
