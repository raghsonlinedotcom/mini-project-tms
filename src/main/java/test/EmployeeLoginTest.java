package test;

import com.tutorials.tms.bo.EmployeeBO;
import com.tutorials.tms.dao.EmployeeDAO;
import com.tutorials.tms.dao.EmployeeDAOImpl;
import com.tutorials.tms.util.AppUtil;

public class EmployeeLoginTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testLoginEmployee(137, "Arun@123");
	}

	public static void testLoginEmployee(int empId, String password) {
		System.out.println("verifyEmployee  invoked - empId, password " + empId + ", " + password);

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		EmployeeBO employeeBO = null;

		try {
			employeeBO = employeeDAO.verifyEmployee(empId, password);
			System.out.println("employeeBO : " + employeeBO);
		} catch (Exception exception) {
			System.err.println("Exception while fetching an Employee with the EmpId, Password - " + empId + password);
			System.err.println("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}

		}
	}

}
