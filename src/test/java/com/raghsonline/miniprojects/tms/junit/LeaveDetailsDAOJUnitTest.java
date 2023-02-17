package com.raghsonline.miniprojects.tms.junit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.raghsonline.miniprojects.tms.bo.LeaveDetailBO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LeaveDetailsDAOJUnitTest 
{
	static Logger logger = Logger.getLogger(LeaveDetailsDAOJUnitTest.class);
	
	static LeaveDetailBO leaveDetailBO;
	static LeaveDetailsDAO leaveDetailsDAO; 
	private static int lastInsertedId;
	
	@BeforeAll
	public static void prepareDAO()
	{
		logger.info("------- Before All Invoked ---------");
		
		leaveDetailsDAO = new LeaveDetailsDAOImpl();
		
		logger.info("BeforeAll - LeaveDetailsDAO initialized : " + leaveDetailsDAO);
		
		leaveDetailBO = new LeaveDetailBO();
		
		LocalDateTime toLdt = LocalDateTime.parse("2023-02-05T00:00:00");
		Timestamp ToDate =java.sql.Timestamp.valueOf(toLdt);
		LocalDateTime fromLdt = LocalDateTime.parse("2023-02-07T00:00:00");
		Timestamp FromDate =java.sql.Timestamp.valueOf(fromLdt);
		
		leaveDetailBO.setEmpId(137);
		leaveDetailBO.setManagerId(140);
		leaveDetailBO.setFromDate(FromDate);
		leaveDetailBO.setToDate(ToDate);
		leaveDetailBO.setLeaveReason("Planned Leave");
		leaveDetailBO.setAltContactNo("1234567890");
		leaveDetailBO.setCreatedBy(137);
		
		try
		{
			lastInsertedId = leaveDetailsDAO.createLeaveDetails(leaveDetailBO);
			logger.info("LeaveDetailBO has been successfully created with lastInsertedId  = " + lastInsertedId);
		} 
		catch (Exception exception) 
		{
			logger.error("Exception while creating a Leave");
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) 
			{
				exception.printStackTrace();
			}
		}
	}

	@BeforeEach
	public void prepareLeaveDetailB() 
	{	
		logger.info("------- Before Each Invoked ---------");
		
		leaveDetailBO = new LeaveDetailBO();
		
		LocalDateTime toLdt = LocalDateTime.parse("2023-02-05T00:00:00");
		Timestamp ToDate =java.sql.Timestamp.valueOf(toLdt);
		LocalDateTime fromLdt = LocalDateTime.parse("2023-02-07T00:00:00");
		Timestamp FromDate =java.sql.Timestamp.valueOf(fromLdt);
		
		leaveDetailBO.setEmpId(137);
		leaveDetailBO.setManagerId(140);
		leaveDetailBO.setFromDate(FromDate);
		leaveDetailBO.setToDate(ToDate);
		leaveDetailBO.setLeaveReason("Planned Leave for a family trip");
		leaveDetailBO.setAltContactNo("1234567890");
		leaveDetailBO.setCreatedBy(137);
		
		logger.info("BeforeEach - LeaveDetailBO initialized - " + leaveDetailBO);
			
	}
	
	@AfterEach
	public void resetBO()
	{
		// set to null because we do NOT need this object for the leaveDetailBO reference!
		logger.info("---After Each Invoked---");
		leaveDetailBO = null;
		logger.info("leaveDetailBO : "+ leaveDetailBO);
	}
	
	@AfterAll
	public static void resetDataBase()
	{
		logger.info("---After All Invoked---");
		
		int recordsDeleted = 0;
		
		LeaveDetailBO leaveDetailBO = new LeaveDetailBO();
		leaveDetailBO.setEmpId(lastInsertedId);
		
		try 
		{
			recordsDeleted = leaveDetailsDAO.deleteLeave(lastInsertedId);
			logger.info("recordsDeleted  : " + recordsDeleted);
			logger.info("recordsDeleted with Id =" + lastInsertedId );
		} 
		catch (Exception exception) 
		{
			logger.error("Exception while deleting  a Leave Record with the Id - " + lastInsertedId);
			logger.error("Error Message : " + exception.getMessage());
			
			if (AppUtil.isAppDevMode)
			{
				exception.printStackTrace();
			}
		}
		logger.info("leaveDetailsDAO Before setting it to Null : "+ leaveDetailsDAO);
		//Setting leaveDetailsDAO to Null.
		leaveDetailsDAO = null;
		logger.info("leaveDetailsDAO Afert Setting to Null : "+ leaveDetailsDAO);
	}
	
	@Test
	@DisplayName("View My Team Leave Details")
	@Order(1)
	public void viewMyTeamLeaveDetailsTest()
	{
		logger.info("Order :" + 1);
		logger.info("leaveDetailsTest() invoked()");
		List<LeaveDetailBO> leaveDetailsList = null;
		//LeaveDetailsDAO leaveDetailsDAO = new LeaveDetailsDAOImpl();
		try {
			leaveDetailsList = leaveDetailsDAO.getTeamLeaveDetails(140);
		} catch (Exception exception) {
			logger.error("Exception while fetching the Leave Details List - " );
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail("leaveDetailsTest() failed - " + exception.getMessage());
		}
		
		logger.info("Leave Details List from DAO is " + leaveDetailsList);
		logger.info(leaveDetailsList);
		assertNotNull(leaveDetailsList);
	}
	
	@Test
	@DisplayName("Manager Update Leave Details")
	@Order(4)
	public void managerUpdateLeaveDetailsTest()
	{
		logger.info("Order :" + 4);
		logger.info("managerUpdateLeaveDetailsTest() invoked()");
		
		try {
			leaveDetailBO = leaveDetailsDAO.getLeaveDetailsById(lastInsertedId);
		} catch (Exception exception) {
			logger.error("Exception while fetching the Leave Details List - " );
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}
		
		if(null!=leaveDetailBO)
		{
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
				logger.error("Exception while updating the Leave Details List" );
				logger.error("Error Message : " + exception.getMessage());
				if (AppUtil.isAppDevMode) {
					exception.printStackTrace();
				}	
				fail("managerUpdateLeaveDetailsTest() failed - " + exception.getMessage());
			}
			logger.info(recordsUpdated);
			assertTrue(recordsUpdated>0);
		}
		else
		{
			logger.info("No leave details are available to edit for the given id");
		}	
	}
	
	@Test
	@DisplayName(" My Leave Details")
	@Order(2)
	public void myLeaveDetailsTest()
	{
		logger.info("Order :" + 2);
		logger.info("myLeaveDetailsTest() - Invoked");	
		List<LeaveDetailBO> leaveDetailBOList = null;
		//LeaveDetailsDAO leaveDetailsDAO = new LeaveDetailsDAOImpl();
		try {
			leaveDetailBOList = leaveDetailsDAO.getLeaveDetails(81);
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
	}
	
	@Test
	@DisplayName(" Upadte Leave Details")
	@Order(3)
	public void updateLeaveDetailsTest()
	{
		logger.info("Order :" + 3);
		logger.info("---------updateLeaveDetailsTest() - Invoked-----------");
		
		//Getting the Data From DB.
		try 
		{
			leaveDetailBO = leaveDetailsDAO.getLeaveDetailsById(lastInsertedId);
		} 
		catch (Exception exception) 
		{
			logger.error("Exception occurred while fetching an leave record with the ID : " + lastInsertedId);
			logger.error("Error Message : " + exception.getMessage());

			if (AppUtil.isAppDevMode) 
			{
				exception.getStackTrace();
			}
		}
		
		if(null!=leaveDetailBO)
		{
			int recordsUpdated = 0;
			
			logger.info("Before update the ToDate Record :" + leaveDetailBO.getToDate());
			
			LocalDateTime ldt = LocalDateTime.parse("2023-02-07T00:00:00");
			Timestamp Date =java.sql.Timestamp.valueOf(ldt);
			leaveDetailBO.setUpdatedBy(137);
			leaveDetailBO.setToDate(Date);
			leaveDetailBO.setLeaveReason("Want to Extend the Leave");
			try 
			{
				recordsUpdated = leaveDetailsDAO.updateLeave(leaveDetailBO);
				logger.info("ID :" + leaveDetailBO.getId());
				logger.info("LeaveDetailBO : " + leaveDetailBO);
			} 
			catch (Exception exception) 
			{
				logger.error("Exception occurred while updating the data into the Database Table");
				logger.error("Error Message : " + exception.getMessage());
				if (AppUtil.isAppDevMode) 
				{
					exception.printStackTrace();
				}
			}
			logger.info("recordsUpdated  : " + recordsUpdated);
			assertTrue(recordsUpdated>0);		
			assertTrue(leaveDetailBO.getUpdatedBy() == 137);
			logger.info("Created Date :" + leaveDetailBO.getCreatedDate());
			logger.info("Status :" + leaveDetailBO.getStatus());
			assertTrue(leaveDetailBO.getStatus().equalsIgnoreCase("OPEN"));
			logger.info("After Update ToDate :" + leaveDetailBO.getToDate());
			logger.info("Updated toDate :" + Date);
			assertTrue(leaveDetailBO.getToDate().equals(Date));
		}	
		else
		{
			logger.info("No leave details are available to edit for the given id");
		}
	}

	@Test
	@DisplayName("Get Leave Details By Id")
	@Order(5)
	public void getLeaveDetailsById()
	{
		logger.info("Order :" + 5);
		logger.info(" getLeaveLeaveDetailsTest() - Invoked");
		
		logger.info("lastInsertedId :" + lastInsertedId);
		LeaveDetailBO leaveDetailBO = null;
		
		try {
			leaveDetailBO = leaveDetailsDAO.getLeaveDetailsById(lastInsertedId);
			logger.info("LeaveDetailBO :" +leaveDetailBO);
		} 
		catch (Exception exception)
		{
			logger.error("Exception occurred while fetching an leave record with the ID : " + lastInsertedId);
			logger.error("Error Message : " + exception.getMessage());

			if (AppUtil.isAppDevMode) {
				exception.getStackTrace();
			}
			fail("getLeaveDetailsById() failed - " + exception.getMessage());
		}
		assertNotNull(leaveDetailBO);
	}
}