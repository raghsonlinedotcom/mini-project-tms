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
public class EmployeeDAOJUnitTest 
{
	static Logger logger = Logger.getLogger(EmployeeDAOJUnitTest.class);
	
	static EmployeeDAO employeeDAO = null;
	
	EmployeeBO employeeBO = null;

	@BeforeEach
	public void before()
	{
		logger.info("------- Before Each Invoked ---------");
		//  Conditionally insert Balaji -record (EMP ID #81)
		
		employeeBO = prepareEmployeeBO();
		
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

	@BeforeAll
	public static void beforeAll()
	{
		logger.info("------- Before All Invoked ---------");
		//  Conditionally insert Raghavan -record (EMP ID #140)
		
		employeeDAO = new EmployeeDAOImpl();
		
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

	@AfterEach
	public void after()
	{
		logger.info("------- After Each Invoked ---------");
		// Conditionally delete Balaji -record

		int recordsDeleted = 0;
		int empId = employeeBO.getEmpId();
		
		try 
		{
			recordsDeleted = employeeDAO.deleteData(empId);
			logger.info("recordsDeleted  : " + recordsDeleted);
			logger.info("recordsDeleted with empId =" + empId );
		} 
		catch (Exception exception) 
		{
			logger.error("Exception while deleteing  an Employee with the EmpId - " + empId);
			logger.error("Error Message : " + exception.getMessage());
			
			if (AppUtil.isAppDevMode) 
			{
				exception.printStackTrace();
			}
		}
	}

	@AfterAll
	public static void afterAll() 
	{
		logger.info("------- After All Invoked ---------");
		//Conditionally "delete" Raghavan -record And
		//Conditionally "insert" Raghavan -record (EMP ID #140)
		
		/* Purposefully do NOTHING as this record of Raghavan
		   is being used in the other JUnit Test methods like
		   LoginJUnitTest etc.,
		 *;
		
		/*
		int empId = 140;
		int recordsDeleted = 0;
		
		EmployeeBO employeeBO = new EmployeeBO();
		employeeBO.setEmpId(empId);
		
		try 
		{
			recordsDeleted = employeeDAO.deleteData(empId);
			logger.info("recordsDeleted  : " + recordsDeleted);
			logger.info("recordsDeleted with empId =" + empId );
		} 
		catch (Exception exception) 
		{
			logger.error("Exception while deleting  an Employee with the EmpId - " + empId);
			logger.error("Error Message : " + exception.getMessage());
			
			if (AppUtil.isAppDevMode)
			{
				exception.printStackTrace();
			}
		}
		*/
		
		//though conceptually we should be deleting the data what we created,
		//we are doing an update to keep one record active 
		int empId = 140;
		EmployeeBO employeeBOFromDB = new EmployeeBO();
		
		try {
			employeeBOFromDB = employeeDAO.getEmployeeByEmpId(empId);
		}catch (Exception exception) {
			logger.error("Exception while getting an Employee with the EmpId - " + empId);
			logger.error("Error Message : " + exception.getMessage());
			
			if (AppUtil.isAppDevMode)
			{
				exception.printStackTrace();
			}
		}
		
		employeeBOFromDB.setActive(true);
		employeeBOFromDB.setUpdatedBy(140);
		employeeBOFromDB.setUpdatedDate(new java.sql.Timestamp(System.currentTimeMillis()));
		
		int recordsUpdated = 0;
		
		try {
			recordsUpdated = employeeDAO.updateEmployee(employeeBOFromDB);
			logger.info("recordsUpdated : " + recordsUpdated);
		}catch (Exception exception) {
			logger.error("Exception while updating an Employee with the EmpId - " + empId);
			logger.error("Error Message : " + exception.getMessage());
			
			if (AppUtil.isAppDevMode)
			{
				exception.printStackTrace();
			}
		}
	}

	public void getCountOfEmployees() 
	{
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
		logger.info("EmployeeDAOJUnitTest - testCreateEmployee() invoked");

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

	public EmployeeBO prepareEmployeeBO() 
	{
		EmployeeBO employeeBO = new EmployeeBO();

		Date dob = new Date(1986-9-13);
		Date doj = new Date(2014-01-01);

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
	public void createEmployee2() 
	{
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
		int empId = employeeBO.getEmpId();

		try {
			targetEmployee = employeeDAO.getEmployeeByEmpId(empId);
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

	public void verifyCreationSuccess(EmployeeDAO employeeDAO, EmployeeBO employeeBO) 
	{
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

		EmployeeBO employeeBOFromDB = null;

		try
		{
			employeeBOFromDB = employeeDAO.getEmployeeByEmpId(empId);
			logger.info("employeeBOFromDB : " + employeeBOFromDB);
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

		assertNotNull(employeeBOFromDB);
	}
	
	@Test
	@DisplayName("EmployeeView JUnitTest")
	public void testEmployeeView() 
	{
		logger.info("----------- EmployeeViewJUnitTest - Invoked ------------");	
		testEmployeeView(140);
	}
	
	public void testEmployeeView(int empId) 
	{
		logger.info("testEmployeeView() invoked - empId: " + empId);
		
		EmployeeBO employeeBOFromDB = null;
		
		try 
		{
			employeeBOFromDB = employeeDAO.getEmployeeByEmpId(empId);	
			logger.info("EmployeeBO : " + employeeBOFromDB);
			if(null==employeeBOFromDB)
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
		
		assertNotNull(employeeBOFromDB);
		assertNotNull(employeeBOFromDB.getEmpId());
		assertNotNull(employeeBOFromDB.getFirstName());
		assertNotNull(employeeBOFromDB.getLastName());
		assertNotNull(employeeBOFromDB.getOfficialEmail());
		assertNotNull(employeeBOFromDB.getAadharId());
		assertNotNull(employeeBOFromDB.getManagerId());
	}
	
	@Test
	@DisplayName("EmployeeEdit JUnitTest of an employee")
	public void employeeEditTest() 
	{
		logger.info("----------- EmployeeEditJUnitTest - Invoked --------------");
		
		//We have the employeeBO object from JUnit - after @BeforeEach method

		employeeBO.setFirstName("BalajiJUnit");
		employeeBO.setLastName("Jayavelu Junit");
		employeeBO.setCity("Bengalore");
		employeeBO.setPersonalEmail("balajiJunit@gmail.com");
		employeeBO.setPrimaryContactNo("7296345789");
		employeeBO.setHighestQualification("MTech");
		employeeBO.setSkillsets("Java,JUnit,MYSQL,HTML,JS");
		employeeBO.setEmpId(81);
		
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
		testEmployeeDeleteByEmpId(140);
	}

	public void testEmployeeDeleteByEmpId(int empId) {

		logger.info("testEmployeeDeleteByEmpId() invoked - empId: " + empId);

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
		logger.info("------------- ManagerSelfView JUnitTest - Invoked --------------");	
		testManagerSelfView(140);
	}
	
	public void testManagerSelfView(int empId) 
	{
		logger.info("ManagerSelfView() invoked - empId: " + empId);
		
		EmployeeBO employeeBOFromDB = null;
		
		try 
		{
			employeeBOFromDB = employeeDAO.getEmployeeByEmpId(empId);	
			logger.info("EmployeeBO : " + employeeBOFromDB);
			
			if(null==employeeBOFromDB)
			{
				logger.info("There is NO Matching Record For the given empId : " + empId);
			} 
			else {
				logger.info("ManagerId :" + employeeBOFromDB.getManagerId());
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
		
		assertNotNull(employeeBOFromDB);
		assertTrue(employeeBOFromDB.getManagerId() == 0);
	}
	
	@Test
	@DisplayName("Manager View Member JUnitTest")
	public void testManagerView() 
	{
		logger.info("----------- ManagerView() invoked ----------" );
		
		EmployeeBO employeeBOFromDB = null;
		
		try 
		{
			employeeBOFromDB = employeeDAO.getEmployeeByEmpId(81);	
			logger.info("EmployeeBO : " + employeeBOFromDB);
			if(null==employeeBOFromDB)
			{
				logger.info("There is NO Matching Record For the given empId : " + 81);
			}
		}
		catch (Exception exception) 
		{
			logger.error("Exception while fetching an Employee with the EmpId - " + 81);
			logger.error("Error Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) 
			{
				exception.printStackTrace();
			}
			fail("Employee getEmployeeByEmpId() failed - " + exception.getMessage());
		}
		logger.info("ManagerId :" + employeeBOFromDB.getManagerId());
		assertNotNull(employeeBOFromDB);
		assertTrue(employeeBOFromDB.getManagerId() == 140);
		java.util.Date time = new java.util.Date();
		logger.info("Current Time :"+ time);
		logger.info("Created Time :" + employeeBOFromDB.getCreatedDate());
		assertTrue(employeeBOFromDB.getCreatedDate() !=  time );
	}
	
	
	@Test
	@DisplayName("ManagerEditMember JUnitTest ")
	public void testManagerEdit() 
	{
		logger.info("----------- ManagerEditMemberJUnitTest - Invoked --------------");
		
		int recordsUpdated = 0;
		
		//modify the values
		employeeBO.setUpdatedBy(140);
		employeeBO.setHobbies(employeeBO.getHobbies() +  ", AWS, MicroServices");

		try 
		{
			recordsUpdated = employeeDAO.managerEditMember(employeeBO);
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
		assertTrue(employeeBO.getManagerId() == 140);
		assertTrue(employeeBO.getUpdatedBy() == 140);
	}
}