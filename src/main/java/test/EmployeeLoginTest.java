package test;

import java.sql.Date;

import com.tutorials.tms.bo.EmployeeBO;
import com.tutorials.tms.dao.EmployeeDAO;
import com.tutorials.tms.dao.EmployeeDAOImpl;
import com.tutorials.tms.util.AppUtil;

/**
 * @author raghavan.muthu
 *
 */
public class EmployeeLoginTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testLoginEmployee(137);
	}
	
	public static void testLoginEmployee(int empId) 
	{
System.out.println("getEmployeeByEmpId()  invoked - empId:" +empId);
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		EmployeeBO employeeBO = null;
		int count = 0;
		
		try {
			employeeBO = employeeDAO.getEmployeeByEmpId(137);	
			System.out.println("employeeBO : " + employeeBO);
		}catch (Exception exception) {
			System.err.println("Exception while fetching an Employee with the EmpId - " + empId);
			System.err.println("Error Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}

		}
		
		
	}

}

