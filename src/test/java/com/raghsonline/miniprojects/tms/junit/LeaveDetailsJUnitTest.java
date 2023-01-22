package com.raghsonline.miniprojects.tms.junit;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.raghsonline.miniprojects.tms.bo.LeaveDetailsBO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

public class LeaveDetailsJUnitTest {
	static Logger logger = Logger.getLogger(LeaveDetailsJUnitTest.class);
	@Test
	@DisplayName("View My Team Leave Details")
	public void leaveDetailsTest()
	{
		List<LeaveDetailsBO> leaveDetailsList = null;
		LeaveDetailsDAO leaveDetailsDAO = new LeaveDetailsDAOImpl();
		try {
			leaveDetailsList = leaveDetailsDAO.viewMyTeamsLeave(140);
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
}
