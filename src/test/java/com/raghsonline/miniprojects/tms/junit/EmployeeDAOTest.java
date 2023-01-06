package com.raghsonline.miniprojects.tms.junit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

/**
 * @author raghavan.muthu
 *
 */
public class EmployeeDAOTest 
{
	static Logger logger = Logger.getLogger(EmployeeDAOTest.class);
	
	static int empId;

	@BeforeEach
	public void before() {
		empId = 1;
		logger.info("Before..., empId = " + empId);
		// TODO: Conditionally insert Balaji -record (EMP ID #81)
	}

	@BeforeAll
	public static void beforeAll() {
		empId = 0;
		logger.info("BeforeAll..., empId = " + empId);
		// TODO: Conditionally insert Raghavan -record (EMP ID #140)
	}

	@AfterEach
	public void after() {
		empId = -1;
		logger.info("after..., empId = " + empId);
		// TODO: Conditionally delete Balaji -record
	}

	@AfterAll
	public static void afterAll() {
		empId = -2;
		logger.info("afterAll, empId = " + empId);
		// TODO: Conditionally delete Raghavan -record
	}

	public static void main(String[] args) {
		EmployeeDAOTest testObj = new EmployeeDAOTest();
		testObj.testCreateEmployee();
		testObj.getCountOfEmployees();
	}

	public void getCountOfEmployees() {
		logger.info("getCountOfEmployees() - invoked");

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		int count = 0;

		try {
			count = employeeDAO.getCount();
		} catch (Exception exception) {
			logger.error("Exception occurred while obtaining the count of employees");
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}

		logger.info("Total # of Employees : " + count);
	}

	public void testCreateEmployee() {
		logger.info("EmployeeDAOTest - testCreateEmployee() invoked");

		EmployeeBO employeeBO = new EmployeeBO();
		Date dob = new Date(2000 - 01 - 01);
		Date doj = new Date(2022 - 01 - 01);
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
		// UserBO userBO = new UserBO(999, "Test2", "Test2 UserDAO", "Test2", "test@2");
		// UserDAO userDAO = new UserDAOImpl();

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();

		try {
			employeeDAO.createEmployee(employeeBO);
			logger.info("EmployeeBO has been successfully created");
			getCountOfEmployees();
		} catch (Exception exception) {
			logger.error("Exception while creating an EmployeeBO");
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}
	}

	public EmployeeBO prepareEmployeeBO() {
		EmployeeBO employeeBO = new EmployeeBO();

		Date dob = new Date(1986 - 9 - 13);
		Date doj = new Date(2014 - 01 - 01);

		employeeBO.setEmpId(81);
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

		return employeeBO;
	}

	@Test
	@DisplayName("Creation of an Employee - based on the count")
	public void createEmployee1() {
		final EmployeeBO employeeBO = prepareEmployeeBO();

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();

		int count = 0;

		try {
			count = employeeDAO.getCount();
			assertTrue(count > 0);
		} catch (Exception exception) {
			logger.error("Exception while creating an EmployeeBO");
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail("Employee getCount() failed - " + exception.getMessage());
		}

		/* --------------- Conditionally decide---------------- */
		if (count == 1) /* Only one employee in the table so far */
		{
			verifyCreationSuccess(employeeDAO, employeeBO);
		} else /* the count is >1, that means this record is existing already */
		{
			verifyCreationFailure(employeeDAO, employeeBO);
		}
	}

	@Test
	@DisplayName("Creation of an Employee - based on the employee data")
	public void createEmployee2() {
		final EmployeeBO employeeBO = prepareEmployeeBO();

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();

		int count = 0;

		try {
			count = employeeDAO.getCount();
			assertTrue(count > 0);
		} catch (Exception exception) {
			logger.error("Exception while creating an EmployeeBO");
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail("Employee getCount() failed - " + exception.getMessage());
		}

		/* Check if the employee is existing in DB or not */
		EmployeeBO targetEmployee = null;

		try {
			targetEmployee = employeeDAO.getEmployeeByEmpId(employeeBO.getEmpId());
			logger.info("targetEmployee : " + targetEmployee);
			assertNotNull(employeeBO);
		} catch (Exception exception) {
			logger.error("Exception while fetching an Employee with the EmpId - " + empId);
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail("Employee getEmployeeByEmpId() failed - " + exception.getMessage());
		}

		if (null == targetEmployee) /* The target employee does NOT exist */
		{
			verifyCreationSuccess(employeeDAO, employeeBO);
		} else /* The target employee exists, so we can assert a Throws/Exception */
		{
			verifyCreationFailure(employeeDAO, employeeBO);
		}
	}

	public void verifyCreationSuccess(EmployeeDAO employeeDAO, EmployeeBO employeeBO) {
		logger.info("verifyCreationSuccess() invoked");

		int lastInsertedId = 0;
		int count = 0;

		try {
			lastInsertedId = employeeDAO.createEmployee(employeeBO);
			assertTrue(lastInsertedId > 1);
			/* You can do this as well, provided you run this in the beginning */
			/*
			 * Issue: What if the test is executed in the middle, and NOT just in the
			 * beginning always?
			 */
			// assertTrue(lastInsertedId ==2);

			assertTrue(employeeDAO.getCount() > count);
		} catch (Exception exception) {
			logger.error("Exception while creating an EmployeeBO");
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail("Employee createEmployee() failed - " + exception.getMessage());
		}
	}

	public void verifyCreationFailure(EmployeeDAO employeeDAO, EmployeeBO employeeBO) {
		logger.info("verifyCreationFailure() invoked");

		Exception thrown = Assertions.assertThrows(Exception.class, () -> {
			int lastInsertedIdLocal = employeeDAO.createEmployee(employeeBO);
			logger.info("lastInsertedIdLocal : " + lastInsertedIdLocal);
		});
		logger.error(thrown.getMessage());
		// assertTrue(lastInsertedId > 0);
		Assertions.assertEquals("Duplicate entry '" + employeeBO.getEmpId() + "' for key 'EMP_ID'",
				thrown.getMessage());
	}

	@Test
	public void getEmployeeByEmpId() 
	{
		logger.info("getEmployeeByEmpId()  invoked");
		getEmployeeByEmpId(81);
	}

	public void getEmployeeByEmpId(int empId) 
	{
		logger.info("getEmployeeByEmpId()  invoked - empId:" + empId);

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		EmployeeBO employeeBO = null;

		try
		{
			employeeBO = employeeDAO.getEmployeeByEmpId(empId);
			logger.info("employeeBO : " + employeeBO);
		} 
		catch (Exception exception) 
		{
			logger.error("Exception while fetching an Employee with the EmpId - " + empId);
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) 
			{
				exception.printStackTrace();
			}
			fail("Employee getEmployeeByEmpId() failed - " + exception.getMessage());
		}

		assertNotNull(employeeBO);
	}
	
	@Test
	@DisplayName("EmployeeView JUnitTest")
	public void testEmployeeView() 
	{
		logger.info("------EmployeeViewJUnitTest - Invoked----------");	
		testEmployeeView(140);
	}
	
	public void testEmployeeView(int empId) 
	{
		logger.info("testEmployeeView() invoked - empId: " + empId);
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		EmployeeBO employeeBO = null;
		
		try 
		{
			employeeBO = employeeDAO.getEmployeeByEmpId(empId);	
			logger.info("EmployeeBO : " + employeeBO);
			if(null==employeeBO)
			{
				logger.info("There is NO Matching Record For the given empId : " + empId);
			}
		}
		catch (Exception exception) 
		{
			logger.error("Exception while fetching an Employee with the EmpId - " + empId);
			logger.error("Error Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) 
			{
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
	
	@Test
	@DisplayName("EmployeeEdit JUnitTest of an employee")
	public void employeeEditTest() 
	{
		logger.info("-------EmployeeEditJUnitTest - Invoked----------");
		
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

		try 
		{
			recordsUpdated = employeeDAO.updateEmployee(employeeBO);
			logger.info("EmployeeBO : " + employeeBO);
		} 
		catch (Exception exception) 
		{
			logger.error("Exception occurred while updating the data into the Database Table");
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) 
			{
				exception.printStackTrace();
			}
		}
		logger.info("recordsUpdated  : " + recordsUpdated);
		assertTrue(recordsUpdated>0);
	}
	
	@Test
	@DisplayName("ListAll Employee from the Employee table")
	public void listAll() 
	{
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		List<EmployeeBO> employeeBOList = null;
		try {
			employeeBOList = employeeDAO.viewAll();
			logger.info("EmployeeBO : " + employeeBOList);
			if (null == employeeBOList) {
				logger.info("There is NO  Records in Table ");
			}
		} catch (Exception exception) {
			logger.error("Exception while fetching the Employee List ");
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail(" EmployeeListAll() failed - " + exception.getMessage());
		}
		assertNotNull(employeeBOList);
	}

	@Test
	@DisplayName("Delete Employee by EmpId")
	public void testEmployeeDeleteByEmpId() {
		logger.info("EmployeeDeleteJUnitTest - Invoked");
		testEmployeeDeleteByEmpId(137);
	}

	public void testEmployeeDeleteByEmpId(int empId) {

		logger.info("testEmployeeDeleteByEmpId() invoked - empId: " + empId);
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();

		int recordsUpdated = 0;
		
		try {
			recordsUpdated = employeeDAO.deleteEmployee(empId);
			logger.info("recordsUpdated  : " + recordsUpdated);
		} catch (Exception exception) {
			logger.error("Exception while deleteing  an Employee with the EmpId - " + empId);
			logger.error("Error Message : " + exception.getMessage());
			
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}
		assertTrue(recordsUpdated > 0);
	}
	
	@Test
	@DisplayName("ManagerSelfView JUnitTest")
	public void testManagerSelfView() 
	{
		logger.info("------ManagerSelfView JUnitTest - Invoked----------");	
		testManagerSelfView(140);
	}
	
	public void testManagerSelfView(int empId) 
	{
		logger.info("ManagerSelfView() invoked - empId: " + empId);
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		EmployeeBO employeeBO = null;
		
		try 
		{
			employeeBO = employeeDAO.getEmployeeByEmpId(empId);	
			logger.info("EmployeeBO : " + employeeBO);
			if(null==employeeBO)
			{
				logger.info("There is NO Matching Record For the given empId : " + empId);
			}
		}
		catch (Exception exception) 
		{
			logger.error("Exception while fetching an Employee with the EmpId - " + empId);
			logger.error("Error Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) 
			{
				exception.printStackTrace();
			}
			fail("Employee getEmployeeByEmpId() failed - " + exception.getMessage());
		}
		logger.info("ManagerId :" + employeeBO.getManagerId());
		assertNotNull(employeeBO);
		assertTrue(employeeBO.getManagerId() == 0);
	}
}
