package com.tutorials.tms.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tutorials.tms.bo.EmployeeBO;
import com.tutorials.tms.dao.EmployeeDAO;
import com.tutorials.tms.dao.EmployeeDAOImpl;
import com.tutorials.tms.util.AppUtil;

/**
 * @author raghavan.muthu
 *
 */
public class EmployeeDAOTest 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		EmployeeDAOTest testObj = new EmployeeDAOTest();
		testObj.testCreateEmployee();
		testObj.getCountOfEmployees();
	}
	
	public void getCountOfEmployees()
	{
		System.out.println("getCountOfEmployees() - invoked");
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		int count = 0;
		
		try {
			count = employeeDAO.getCount();
		}catch(Exception exception) {
			System.err.println("Exception occurred while obtaining the count of employees");
			System.err.println("Error Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}
		
		System.out.println("Total # of Employees : " + count);
	}
	
	public void testCreateEmployee() 
	{
		System.out.println("EmployeeDAOTest - testCreateEmployee() invoked");
		
		EmployeeBO employeeBO = new EmployeeBO();
		Date dob = new Date(2000-01-01);
		Date doj = new Date(2022-01-01);
		employeeBO = new EmployeeBO();
		employeeBO.setId(548); 
        employeeBO.setFirstName("Pruthvi"); 
        employeeBO.setLastName("Narayan");
        employeeBO.setDateOfBirth(dob);
        employeeBO.setGender('M');
        employeeBO.setAadharId("926342516473");
        employeeBO.setBloodGroup("B+ve");
        employeeBO.setCity("Hassan");
        employeeBO.setPersonalEmail("pruthvi@gmail.com");
        employeeBO.setOfficialEmail("pruthvi23@gmail.com");
        employeeBO.setPassword("Hassan@123");
        employeeBO.setPrimaryContactNo("9876786545");
        employeeBO.setSecondaryContactNo("9856342341");
        employeeBO.setHighestQualification("B E");  
        employeeBO.setSkillsets("JAVA,PYTHON");
        employeeBO.setDateOfJoining(doj);
        employeeBO.setHobbies("singing");
        employeeBO.setManagerId(140);
		//UserBO userBO = new UserBO(999, "Test2", "Test2 UserDAO", "Test2", "test@2");
		//UserDAO userDAO = new UserDAOImpl();
		
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		try {
			employeeDAO.createEmployee(employeeBO);
			System.out.println("EmployeeBO has been successfully created");
			getCountOfEmployees();
		} catch (Exception exception) {
			System.err.println("Exception while creating an EmployeeBO");
			System.err.println("Error Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}
	}
	
	@Test
	@DisplayName("Creation of an Employee")
	public void createEmployee()
	{
		EmployeeBO employeeBO = new EmployeeBO();
		Date dob = new Date(1986-9-13);
		Date doj = new Date(2014-01-01);
		employeeBO = new EmployeeBO();

        employeeBO.setEmpId("81");
        employeeBO.setFirstName("Balaji"); 
        employeeBO.setLastName("Jayavelu");
        employeeBO.setDateOfBirth(dob);
        employeeBO.setGender('M');
        employeeBO.setAadharId("232323456788");
        employeeBO.setBloodGroup("B+ve");
        employeeBO.setCity("Bengaluru");
        employeeBO.setPersonalEmail("balaji@gmail.com");
        employeeBO.setOfficialEmail("balaji@office.com");
        employeeBO.setPassword("Balaji@123");
        employeeBO.setPrimaryContactNo("9804612341");
        employeeBO.setSecondaryContactNo("9999451111");
        employeeBO.setHighestQualification("BTech");  
        employeeBO.setSkillsets("Java, TOGAF");
        employeeBO.setDateOfJoining(doj);
        employeeBO.setHobbies("Cycling, Coding");
        employeeBO.setManagerId(140);
        
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        int lastInsertedId = 0;
        
		try {
			int count = employeeDAO.getCount();
	        assertTrue(count > 0);	
			lastInsertedId = employeeDAO.createEmployee(employeeBO);
			assertTrue(lastInsertedId > 0);
			assertTrue(employeeDAO.getCount() > count);			
		} catch (Exception exception) {
			System.err.println("Exception while creating an EmployeeBO");
			System.err.println("Error Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail("Employee creation failed - " + exception.getMessage());
		}
	}
}
