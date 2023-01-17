/**
 * 
 */
package com.raghsonline.miniprojects.tms.dao;

import java.sql.Date;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.util.AppUtil;

/**
 * @author raghavan.muthu
 *
 */
public class EmployeeDAOTest 
{
	static Logger logger = Logger.getLogger(EmployeeDAOTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		createEmployee();
	}
	
	public static void createEmployee()
	{
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		EmployeeBO employeeBO = new EmployeeBO();

		Date dob = new Date(1981-01-01);
		Date doj = new Date(2022-05-9);

		employeeBO.setEmpId(140);
		employeeBO.setFirstName("Raghavan");
		employeeBO.setLastName("Muthu");
		employeeBO.setDateOfBirth(dob);
		employeeBO.setGender('M');
		employeeBO.setAadharId("123456789876");
		employeeBO.setBloodGroup("B+ve");
		employeeBO.setCity("Bengaluru");
		employeeBO.setPersonalEmail("raghavan.muthu@gmail.com");
		employeeBO.setOfficialEmail("raghavan.muthu@milvik.se");
		employeeBO.setPassword("Raghavan@muthu");
		employeeBO.setPrimaryContactNo("8095261616");
		employeeBO.setSecondaryContactNo("9848022338");
		employeeBO.setHighestQualification("MTech");
		employeeBO.setSkillsets("Java, MySQL, Spring, HTML, CSS, TOGAF");
		employeeBO.setDateOfJoining(doj);
		employeeBO.setHobbies("Training young freshers, Playing Cricket, Reading Books");
		employeeBO.setManagerId(0);

		try
		{
			employeeDAO.createEmployee(employeeBO);
			logger.info("EmployeeBO has been successfully created with Emp_Id = " + employeeBO.getEmpId());
		} 
		catch (Exception exception)
		{
			logger.error("Exception while creating an EmployeeBO");
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode)
			{
				exception.printStackTrace();
			}
		}
	}

}
