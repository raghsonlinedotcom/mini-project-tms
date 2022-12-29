package com.tutorials.tms.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.tutorials.tms.bo.EmployeeBO;
import com.tutorials.tms.dao.EmployeeDAO;
import com.tutorials.tms.dao.EmployeeDAOImpl;
import com.tutorials.tms.util.AppUtil;

class LogInJUnitTestTest {

	@Test
	void loginTest() {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		EmployeeBO employeeBO = null;
		try {
			employeeBO = employeeDAO.verifyEmployee(137, "Arun@123");
		} catch (Exception exception) {
			System.err.println("Exception occurred while verifying an employee");
			System.err.println("Error Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}
		assertNotNull(employeeBO);
	}

}