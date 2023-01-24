package com.raghsonline.miniprojects.tms.junit;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.raghsonline.miniprojects.tms.bo.LeaveDetailBO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

public class LeaveDetailsDAOJUnitTest 
{
	static Logger logger = Logger.getLogger(LeaveDetailsDAOJUnitTest.class);

	@Test
	@DisplayName("View My Team Leave Details")
	public void leaveDetailsTest()
	{
		logger.info("leaveDetailsTest() invoked()");
		List<LeaveDetailBO> leaveDetailsList = null;
		LeaveDetailsDAO leaveDetailsDAO = new LeaveDetailsDAOImpl();
		try {
			leaveDetailsList = leaveDetailsDAO.getTeamLeaveDetails(140);
		} catch (Exception exception) {
			logger.error("Exception while fetching the Leave Details List - " );
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			// As of now I am just checking if there are any exceptions
			// and failing test case based on that. 
			// Since we don't have the create leave request method
			// ready in DAO it is not possible to insert sample data 
			// using the lifecycle methods. For testing purpose I have 
			// inserted sample leave data from database and it worked well. 
			
			fail("leaveDetailsTest() failed - " + exception.getMessage());
		}
		
		logger.info("Leave Details List from DAO is " + leaveDetailsList);
		logger.info(leaveDetailsList);
	}
	
	@Test
	@DisplayName("Manager Update Leave Details")
	public void managerUpdateLeaveDetailsTest()
	{
		logger.info("leaveDetailsTest() invoked()");
		LeaveDetailBO leaveDetailBO = new LeaveDetailBO();
		LeaveDetailsDAO leaveDetailsDAO = new LeaveDetailsDAOImpl();
		try {
			leaveDetailBO = leaveDetailsDAO.getLeaveDetailsById(2);
		} catch (Exception exception) {
			logger.error("Exception while fetching the Leave Details List - " );
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}
		
		leaveDetailBO.setStatus("Rejected");
		leaveDetailBO.setActionComment("Tight Deadlines");
		leaveDetailBO.setUpdatedBy(140);
		LocalDateTime ldt = LocalDateTime.now();
		Timestamp updatedDate =java.sql.Timestamp.valueOf(ldt);
		leaveDetailBO.setUpdatedDate(updatedDate);
		int recordsUpdated = 0;
		try {
			recordsUpdated = leaveDetailsDAO.managerUpdateLeaveDetails(leaveDetailBO);
		} catch (Exception exception) {
			logger.error("Exception while updating the Leave Details List - " );
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			
			// As of now I am just checking if there are any exceptions
			// and failing test case based on that. 
			// Since we don't have the create leave request method
			// ready in DAO it is not possible to insert sample data 
			// using the lifecycle methods. For testing purpose I have 
			// inserted sample leave data from database and it worked well.
			
			fail("managerUpdateLeaveDetailsTest() failed - " + exception.getMessage());
		}
		
		logger.info(recordsUpdated);
		
	}
	
	@Test
	@DisplayName(" My Leave Details")
	public void myLeaveDetailsTest()
	{
		logger.info("myLeaveDetailsTest() - Invoked");	
		List<LeaveDetailBO> leaveDetailBOList = null;
		LeaveDetailsDAO leaveDetailsDAO = new LeaveDetailsDAOImpl();
		try {
			leaveDetailBOList = leaveDetailsDAO.getLeaveDetails(140);
		} catch (Exception exception) {
			logger.error("Exception while fetching the Leave Details List - " );
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			// As of now I am just checking if there are any exceptions
			// and failing test case based on that. 
			// Since we don't have the create leave request method
			// ready in DAO it is not possible to insert sample data 
			// using the lifecycle methods. For testing purpose I have 
			// inserted sample leave data from database and it worked well. 
			
			fail("myLeaveDetailsTest() failed - " + exception.getMessage());
		}
		
		logger.info("Leave Details List from DAO is " + leaveDetailBOList);
		logger.info(leaveDetailBOList);
	}	
}
