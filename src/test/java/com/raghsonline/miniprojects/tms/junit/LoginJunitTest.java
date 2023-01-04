package com.raghsonline.miniprojects.tms.junit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;


public class LoginJunitTest {
	static Logger logger = Logger.getLogger(EmployeeDAOTest.class);
	
	@Test
	@DisplayName("Login Test of an employee")
	public void loginTest() {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		EmployeeBO employeeBO = null;
		try {
			employeeBO = employeeDAO.verifyEmployee(140, "Raghavan@muthu");
		} catch (Exception exception) {
			logger.error("Exception occurred while verifying an employee");
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail("loginTest() failed - " + exception.getMessage());
		}
		assertNotNull(employeeBO);
	}
}
