package com.raghsonline.miniprojects.tms.dao;
import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.junit.EmployeeDAOJUnitTest;
import com.raghsonline.miniprojects.tms.util.AppUtil;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManagerJUnitTest {
	static Logger logger = Logger.getLogger(EmployeeDAOJUnitTest.class);
	
	@Test
	@DisplayName("Manager test")
	public void managerTest()
	{
		List<EmployeeBO> managerList = null;
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		try {
			managerList = employeeDAO.viewManagers();
		} catch (Exception exception) {
			logger.error("Exception while fetching the Managers List - " );
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail("managerTest() failed - " + exception.getMessage());
		}
		
		logger.info("ManagerList from DAO is " + managerList);
		assertNotNull(managerList);
	}
	
}

