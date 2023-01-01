package com.raghsonline.miniprojects.tms.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

class EmployeeEditJUnitTest {

	@Test
	void test() {
		System.out.println("EmployeeEditJUnitTest - Invoked");
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		EmployeeBO employeeBO = new EmployeeBO();

		employeeBO.setFirstName("ArunJUnit");
		employeeBO.setLastName("Prasad");
		employeeBO.setCity("Kakinada");
		employeeBO.setPersonalEmail("arunJunit@gmail.com");
		employeeBO.setPrimaryContactNo("7288822559");
		employeeBO.setHighestQualification("BTech");
		employeeBO.setSkillsets("Java,JUnit,MYSQL,HTML,JS");
		employeeBO.setEmpId(137);
		int recordsUpdated = 0;

		try {
			recordsUpdated = employeeDAO.updateEmployee(employeeBO);
			System.out.println("EmployeeBO : " + employeeBO);
		} catch (Exception exception) {
			System.err.println("Exception occurred while updating the data into the Database Table");
			System.err.println("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			System.out.println("recordsUpdated  : " + recordsUpdated);
		}
		assertTrue(recordsUpdated>0);
	}
}
