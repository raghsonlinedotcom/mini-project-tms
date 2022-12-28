package com.tutorials.tms.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.tutorials.tms.bo.EmployeeBO;
import com.tutorials.tms.dao.EmployeeDAO;
import com.tutorials.tms.dao.EmployeeDAOImpl;
import com.tutorials.tms.util.AppUtil;

class EmployeeViewJUnitTest {

	@Test
	public void testEmployeeViewByEmpId() {
		
		System.out.println("EmployeeViewJUnitTest - Invoked");
		
		testEmployeeViewByEmpId(140);
	}
	
	public void testEmployeeViewByEmpId(int empId) {
		
        System.out.println("testEmployeeViewByEmpId()  invoked - empId: " + empId);
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		EmployeeBO employeeBO = null;
		int count = 0;
		
		try {
			employeeBO = employeeDAO.getEmployeeByEmpId(empId);	
			if(employeeBO == null)
			{
				System.out.println("There is NO Matching Records For the Given empId = " + empId);
			}else
			System.out.println("employeeBO : " + employeeBO);
			count = employeeDAO.getCount();
			System.out.println("Count : " + count);
		}catch (Exception exception) {
			System.err.println("Exception while fetching an Employee with the EmpId - " + empId);
			System.err.println("Error Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail("Employee getEmployeeByEmpId() failed - " + exception.getMessage());
		}
		
		if(count > 1) {
			assertNotNull(employeeBO);
		} 
		
	}
}