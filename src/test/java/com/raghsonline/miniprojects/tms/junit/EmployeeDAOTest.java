package com.raghsonline.miniprojects.tms.junit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;
import java.util.List;

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
public class EmployeeDAOTest {
	static int empId;

	@BeforeEach
	public void before() {
		empId = 1;
		System.out.println("Before..., empId = " + empId);
		// TODO: Conditionally insert Balaji -record (EMP ID #81)
	}

	@BeforeAll
	public static void beforeAll() {
		empId = 0;
		System.out.println("BeforeAll..., empId = " + empId);
		// TODO: Conditionally insert Raghavan -record (EMP ID #140)
	}

	@AfterEach
	public void after() {
		empId = -1;
		System.out.println("after..., empId = " + empId);
		// TODO: Conditionally delete Balaji -record
	}

	@AfterAll
	public static void afterAll() {
		empId = -2;
		System.out.println("afterAll, empId = " + empId);
		// TODO: Conditionally delete Raghavan -record
	}

	public static void main(String[] args) {
		EmployeeDAOTest testObj = new EmployeeDAOTest();
		testObj.testCreateEmployee();
		testObj.getCountOfEmployees();
	}

	public void getCountOfEmployees() {
		System.out.println("getCountOfEmployees() - invoked");

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		int count = 0;

		try {
			count = employeeDAO.getCount();
		} catch (Exception exception) {
			System.err.println("Exception occurred while obtaining the count of employees");
			System.err.println("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}

		System.out.println("Total # of Employees : " + count);
	}

	public void testCreateEmployee() {
		System.out.println("EmployeeDAOTest - testCreateEmployee() invoked");

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
			System.out.println("EmployeeBO has been successfully created");
			getCountOfEmployees();
		} catch (Exception exception) {
			System.err.println("Exception while creating an EmployeeBO");
			System.err.println("Error Message : " + exception.getMessage());
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
			System.err.println("Exception while creating an EmployeeBO");
			System.err.println("Error Message : " + exception.getMessage());
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
			System.err.println("Exception while creating an EmployeeBO");
			System.err.println("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail("Employee getCount() failed - " + exception.getMessage());
		}

		/* Check if the employee is existing in DB or not */
		EmployeeBO targetEmployee = null;

		try {
			targetEmployee = employeeDAO.getEmployeeByEmpId(employeeBO.getEmpId());
			System.out.println("targetEmployee : " + targetEmployee);
			assertNotNull(employeeBO);
		} catch (Exception exception) {
			System.err.println("Exception while fetching an Employee with the EmpId - " + empId);
			System.err.println("Error Message : " + exception.getMessage());
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
		System.out.println("verifyCreationSuccess() invoked");

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
			System.err.println("Exception while creating an EmployeeBO");
			System.err.println("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail("Employee createEmployee() failed - " + exception.getMessage());
		}
	}

	public void verifyCreationFailure(EmployeeDAO employeeDAO, EmployeeBO employeeBO) {
		System.out.println("verifyCreationFailure() invoked");

		Exception thrown = Assertions.assertThrows(Exception.class, () -> {
			int lastInsertedIdLocal = employeeDAO.createEmployee(employeeBO);
			System.out.println("lastInsertedIdLocal : " + lastInsertedIdLocal);
		});
		System.err.println(thrown.getMessage());
		// assertTrue(lastInsertedId > 0);
		Assertions.assertEquals("Duplicate entry '" + employeeBO.getEmpId() + "' for key 'EMP_ID'",
				thrown.getMessage());
	}

	@Test
	public void getEmployeeByEmpId() {
		System.out.println("getEmployeeByEmpId()  invoked");
		getEmployeeByEmpId(81);
	}

	public void getEmployeeByEmpId(int empId) {
		System.out.println("getEmployeeByEmpId()  invoked - empId:" + empId);

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		EmployeeBO employeeBO = null;

		try {
			employeeBO = employeeDAO.getEmployeeByEmpId(empId);
			System.out.println("employeeBO : " + employeeBO);
		} catch (Exception exception) {
			System.err.println("Exception while fetching an Employee with the EmpId - " + empId);
			System.err.println("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail("Employee getEmployeeByEmpId() failed - " + exception.getMessage());
		}

		assertNotNull(employeeBO);
	}

	@Test
	@DisplayName("Login Test of an employee")
	public void loginTest() {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		EmployeeBO employeeBO = null;
		try {
			employeeBO = employeeDAO.verifyEmployee(140, "Raghavan@muthu");
		} catch (Exception exception) {
			System.err.println("Exception occurred while verifying an employee");
			System.err.println("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}
		assertNotNull(employeeBO);
	}

	@Test
	@DisplayName("ListAll Employee from the Employee table")
	public void employeeListAllTest() {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		List<EmployeeBO> employeeBOList = null;
		try {
			employeeBOList = employeeDAO.viewAll();
			System.out.println("EmployeeBO : " + employeeBOList);
			if (null == employeeBOList) {
				System.out.println("There is NO  Records in Table ");
			}
		} catch (Exception exception) {
			System.err.println("Exception while fetching the Employee List ");
			System.err.println("Error Message : " + exception.getMessage());
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
		System.out.println("EmployeeDeleteJUnitTest - Invoked");
		testEmployeeDeleteByEmpId(137);
	}

	public void testEmployeeDeleteByEmpId(int empId) {

		System.out.println("testEmployeeDeleteByEmpId() invoked - empId: " + empId);
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();

		int recordsUpdated = 0;
		try {
			recordsUpdated = employeeDAO.deleteEmployee(empId);
		} catch (Exception exception) {
			System.err.println("Exception while deleteing  an Employee with the EmpId - " + empId);
			System.err.println("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			System.out.println("recordsUpdated  : " + recordsUpdated);
		}

		assertTrue(recordsUpdated > 0);

	}
}
