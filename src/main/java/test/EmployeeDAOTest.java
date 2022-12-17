package test;

import java.sql.Date;

import com.tutorials.tms.bo.Employee;
import com.tutorials.tms.dao.EmployeeDAO;
import com.tutorials.tms.dao.EmployeeDAOImpl;

/**
 * @author raghavan.muthu
 *
 */
public class EmployeeDAOTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testRegisterUser();
	}
	
	public static void testRegisterUser() 
	{
		Employee employee = new Employee();
		Date dob = new Date(2000-01-01);
		Date doj = new Date(2022-01-01);
		employee = new Employee();
		employee.setId(548); 
        employee.setFirstName("Pruthvi"); 
        employee.setLastName("Narayan");
        employee.setDateOfBirth(dob);
        employee.setGender('M');
        employee.setAadharId("926342516473");
        employee.setBloodGroup("B+ ve");
        employee.setCity("Hassan");
        employee.setPersonalEmail("pruthvi@gmail.com");
        employee.setOfficialEmail("pruthvi23@gmail.com");
        employee.setPassword("Hassan@123");
        employee.setPrimaryContactNo("9876786545");
        employee.setSecondaryContactNo("9856342341");
        employee.setHighestQualification("B E");  
        employee.setSkillsets("JAVA,PYTHON");
        employee.setDateOfJoining(doj);
        employee.setHobbies("singing");
        employee.setManagerId(140);
		//UserBO userBO = new UserBO(999, "Test2", "Test2 UserDAO", "Test2", "test@2");
		//UserDAO userDAO = new UserDAOImpl();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		try {
			employeeDAO.createEmployee(employee);
		} catch (Exception exception) {
			System.err.println("Exception while obtaining a connection");
			System.err.println("Error Message : " + exception.getMessage());
			//TODO ONLY for Development Purposes, remove it in PROD
			exception.printStackTrace();
		}
	}

}

