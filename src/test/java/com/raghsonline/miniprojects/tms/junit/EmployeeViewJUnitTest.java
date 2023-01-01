package com.raghsonline.miniprojects.tms.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

class EmployeeViewJUnitTest {

	@Test
	public void testEmployeeViewByEmpId() 
	{
		System.out.println("EmployeeViewJUnitTest - Invoked");	
		testEmployeeViewByEmpId(140);
	}
	
	public void testEmployeeViewByEmpId(int empId) 
	{
        System.out.println("testEmployeeViewByEmpId() invoked - empId: " + empId);
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		EmployeeBO employeeBO = null;
		
		try {
			employeeBO = employeeDAO.getEmployeeByEmpId(empId);	
			System.out.println("EmployeeBO : " + employeeBO);
			if(null==employeeBO)
			{
				System.out.println("There is NO Matching Record For the given empId : " + empId);
			}
		}catch (Exception exception) {
			System.err.println("Exception while fetching an Employee with the EmpId - " + empId);
			System.err.println("Error Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail("Employee getEmployeeByEmpId() failed - " + exception.getMessage());
		}
		
		assertNotNull(employeeBO);
		assertNotNull(employeeBO.getEmpId());
		assertNotNull(employeeBO.getFirstName());
		assertNotNull(employeeBO.getLastName());
		assertNotNull(employeeBO.getOfficialEmail());
		assertNotNull(employeeBO.getAadharId());
		assertNotNull(employeeBO.getManagerId());
	}
}