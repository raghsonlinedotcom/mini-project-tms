/**
 * 
 */
package com.raghsonline.miniprojects.tms.junit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

/**
 * @author raghavan.muthu
 *
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeDAOJUnitLifeCycleTest {

	static Logger logger = Logger.getLogger(EmployeeDAOJUnitLifeCycleTest.class);
	
	EmployeeBO employeeBO;
	static EmployeeDAO employeeDAO; 
	
	@BeforeAll
	public static void prepareDAO()
	{
		employeeDAO = new EmployeeDAOImpl();
		logger.info("BeforeAll - EmployeeDAO initialized : " + employeeDAO);
	}

	@BeforeEach
	public void prepareEmployeeBO() 
	{
		employeeBO = new EmployeeBO();
		
		employeeBO.setEmpId(1);
		employeeBO.setFirstName("Rama");
		employeeBO.setLastName("Krisha");
		employeeBO.setDateOfBirth(new java.sql.Date(1990 - 01 - 01));
		employeeBO.setGender('M');
		employeeBO.setAadharId("333666999123");
		employeeBO.setBloodGroup("O+ve");
		employeeBO.setCity("Tirupati");
		employeeBO.setPersonalEmail("rama.krishna@email.com");
		employeeBO.setOfficialEmail("rama.krishna@office.com");
		employeeBO.setPassword("Rama@Krishna");
		employeeBO.setPrimaryContactNo("1234567890");
		employeeBO.setHighestQualification("PhD");
		employeeBO.setSkillsets("Creation, Saving, Destruction");
		employeeBO.setDateOfJoining(new java.sql.Date(2022 - 04 - 01));
		employeeBO.setHobbies("Reading Books, Listening to Music");

		logger.info("BeforeEach - EmployeeBO initialized - " + employeeBO);
	}

	@Test
	@DisplayName("Create an Employee")
	@Order(1)
	void createEmployee() {
		
		int insertedId = 0;

		logger.info("Before Create - CREATED_BY : " + employeeBO.getCreatedBy());
		logger.info("Before Create - CREATED_DATE : " + employeeBO.getCreatedDate());

		try {
			insertedId = employeeDAO.createEmployee(employeeBO);
			logger.info("Employee Created successfully with the ID : " + insertedId);
			assertTrue(insertedId > 0);
		} catch (Exception exception) {
			logger.error("Exception occurred while creating an employee");
			logger.error("Error Message : " + exception.getMessage());

			if (AppUtil.isAppDevMode) {
				exception.getStackTrace();
			}

			assertEquals(exception.getMessage(), "Duplicate entry '1' for key 'EMP_ID'");
		}
		
		// Assert the data that is generated in the Database but we have not supplied from Java
		// How will we check the data generated in the Database?
		
		EmployeeBO employeeBOFromDB = null;
		int empId = employeeBO.getEmpId();
		
		try {
			employeeBOFromDB = employeeDAO.getEmployeeByEmpId(empId);
			assertNotNull(employeeBOFromDB);
			assertTrue(employeeBOFromDB.getId() > 0);
			logger.info("After Create - CREATED_BY : " + employeeBOFromDB.getCreatedBy());
			assertNotNull(employeeBOFromDB.getCreatedBy());
			logger.info("After Create - CREATED_DATE : " + employeeBOFromDB.getCreatedDate());
			assertNotNull(employeeBOFromDB.getCreatedDate());
		}catch(Exception exception) {
			logger.error("Exception occurred while getting an employee with the EmpID - " + empId);
			logger.error("Error Message : " + exception.getMessage());

			if (AppUtil.isAppDevMode) {
				exception.getStackTrace();
			}
		}
	}

	@Test
	@DisplayName("Get an employee by Id")
	@Order(2)
	public void getEmployeeById() {
		int empId = 1;
		
		logger.info("[*] Testing Before Each, employeeBO : " + employeeBO );
		
		EmployeeBO employeeBO = null;
		
		logger.info("[*] Testing After, employeeBO (local) : " + employeeBO );

		try {
			employeeBO = employeeDAO.getEmployeeByEmpId(empId);
		} catch (Exception exception) {
			logger.error("Exception occurred while fetching an employee with the ID : " + empId);
			logger.error("Error Message : " + exception.getMessage());

			if (AppUtil.isAppDevMode) {
				exception.getStackTrace();
			}
		}

		assertNotNull(employeeBO);

		logger.info("EmployeeBO retrieved from the DB is : " + employeeBO);
	}
	
	@Test
	@DisplayName("Update an employee")
	@Order(3)
	//@Disabled
	public void updateEmployee1() 
	{
		int empId = employeeBO.getEmpId();	

		// update some values
		String newHobby = null!= employeeBO.getHobbies() 
					? employeeBO.getHobbies()+ ", Coding" 
					: "Coding";
		
		employeeBO.setHobbies(newHobby);

		logger.info("Before Update - UPDATED_BY : " + employeeBO.getUpdatedBy());
		logger.info("Before Update - UPDATED_DATE : " + employeeBO.getUpdatedDate());
		logger.info("Before Update - Hobbies : " + employeeBO.getHobbies());

		int updatedRows = 0;

		try {
			updatedRows = employeeDAO.updateEmployee(employeeBO);
			assertTrue(updatedRows > 0);
			logger.info("EmployeeBO updated successfully");
		} catch (Exception exception) {
			logger.error("Exception occurred while updating an employee with the ID : " 
						+ employeeBO.getEmpId());
			logger.error("Error Message : " + exception.getMessage());

			if (AppUtil.isAppDevMode) {
				exception.getStackTrace();
			}
		}
		
		EmployeeBO employeeBOFromDB = null;
		
		try {
			employeeBOFromDB = employeeDAO.getEmployeeByEmpId(empId);
			logger.info("employeeBOFromDB Hobbies : " + employeeBOFromDB.getHobbies());
			assertNotNull(employeeBOFromDB);
			assertTrue(employeeBOFromDB.getId() > 0);
			logger.info("After Create - UPDATED_BY : " + employeeBOFromDB.getUpdatedBy());
			assertTrue(employeeBOFromDB.getUpdatedBy()==0);
			logger.info("After Create - UPDATED_DATE : " + employeeBOFromDB.getUpdatedDate());
			assertNotNull(employeeBOFromDB.getCreatedDate());
		
			// Functional Assert - on the actual values we just added
			assertEquals(employeeBOFromDB.getHobbies(), employeeBO.getHobbies());
			assertTrue(employeeBOFromDB.getHobbies().contains("Coding"));
			
		}catch(Exception exception) {
			logger.error("Exception occurred while getting an employee with the EmpID - " + empId);
			logger.error("Error Message : " + exception.getMessage());

			if (AppUtil.isAppDevMode) {
				exception.getStackTrace();
			}
		}
	}

	@Test
	@DisplayName("Update an employee")
	@Order(4)
	//@Disabled
	public void updateEmployee2() 
	{
		int empId = employeeBO.getEmpId();
		
		//Get it from the Database, before you apply the changes
		// so as to retain the latest values in the DB,
		// otherwise you would end up replacing the values in the DB
		// with your test data - as you get it from prepareEmployeeBO()
		// which always give a constant value, by letting you corrupt/tamper
		// the interim updates if any performed on the other columns of the
		// same row. 
		
		try {
			employeeBO = employeeDAO.getEmployeeByEmpId(empId);
		} catch (Exception exception) {
			logger.error("Exception occurred while fetching an employee with the ID : " + empId);
			logger.error("Error Message : " + exception.getMessage());

			if (AppUtil.isAppDevMode) {
				exception.getStackTrace();
			}
		}
		

		// update some values
		String newSkillset = null!= employeeBO.getSkillsets() 
					? employeeBO.getSkillsets()+ ", Swimming" 
					: "Swimming";
		
		employeeBO.setSkillsets(newSkillset);

		logger.info("Before Update - UPDATED_BY : " + employeeBO.getUpdatedBy());
		logger.info("Before Update - UPDATED_DATE : " + employeeBO.getUpdatedDate());
		logger.info("Before Update - Skillset : " + employeeBO.getSkillsets());

		int updatedRows = 0;

		try {
			updatedRows = employeeDAO.updateEmployee(employeeBO);
			assertTrue(updatedRows > 0);
			logger.info("EmployeeBO updated successfully");
		} catch (Exception exception) {
			logger.error("Exception occurred while updating an employee with the ID : " 
						+ employeeBO.getEmpId());
			logger.error("Error Message : " + exception.getMessage());

			if (AppUtil.isAppDevMode) {
				exception.getStackTrace();
			}
		}
		
		EmployeeBO employeeBOFromDB = null;
		
		try {
			employeeBOFromDB = employeeDAO.getEmployeeByEmpId(empId);
			logger.info("employeeBOFromDB Hobbies : " + employeeBOFromDB.getHobbies());
			assertNotNull(employeeBOFromDB);
			assertTrue(employeeBOFromDB.getId() > 0);
			logger.info("After Create - UPDATED_BY : " + employeeBOFromDB.getUpdatedBy());
			assertTrue(employeeBOFromDB.getUpdatedBy()==0);
			logger.info("After Create - UPDATED_DATE : " + employeeBOFromDB.getUpdatedDate());
			assertNotNull(employeeBOFromDB.getCreatedDate());
		
			// Functional Assert - on the actual values we just added
			assertEquals(employeeBOFromDB.getSkillsets(), employeeBO.getSkillsets());
			assertTrue(employeeBOFromDB.getSkillsets().contains("Swimming"));
			
		}catch(Exception exception) {
			logger.error("Exception occurred while getting an employee with the EmpID - " + empId);
			logger.error("Error Message : " + exception.getMessage());

			if (AppUtil.isAppDevMode) {
				exception.getStackTrace();
			}
		}
	}
	
	@AfterEach
	public void reset()
	{
		// set to null because we do NOT need this object for the employeeBO reference!
		employeeBO = null;
	}
	
	@AfterAll
	public static void cleanup()
	{
		int empId = 1;
		int rowsDeleted = 0;
		
		try {
			rowsDeleted = employeeDAO.deleteData(empId);
			assertTrue(rowsDeleted > 0); // generic assertion
			assertTrue(rowsDeleted==1); //clear cut , specific assertion
		}catch(Exception exception) {
			logger.error("Exception occurred while deleting an employee with the EmpID - " + empId);
			logger.error("Error Message : " + exception.getMessage());

			if (AppUtil.isAppDevMode) {
				exception.getStackTrace();
			}
		}
		
		EmployeeBO employeeBOFromDB = null;
		
		try {
			employeeBOFromDB = employeeDAO.getEmployeeByEmpId(empId);
		} catch (Exception exception) {
			logger.error("Exception occurred while fetching an employee with the ID : " + empId);
			logger.error("Error Message : " + exception.getMessage());

			if (AppUtil.isAppDevMode) {
				exception.getStackTrace();
			}
		}
		
		assertNull(employeeBOFromDB);
		
		// set to null because we do NOT need this object for the employeeDAO reference!
		employeeDAO = null;
	}
}
