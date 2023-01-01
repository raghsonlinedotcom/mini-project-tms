package com.raghsonline.miniprojects.tms.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

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