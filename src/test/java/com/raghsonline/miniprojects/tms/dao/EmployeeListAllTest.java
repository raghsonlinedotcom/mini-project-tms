package  com.raghsonline.miniprojects.tms.dao;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.util.AppUtil;
import java.util.List;

public class EmployeeListAllTest {

	public static void main(String[] args) {
		testListAllEmployee();
	}

	public static void testListAllEmployee() {
		System.out.println("verifyEmployee  invoked ");

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		List<EmployeeBO> employeeBOList = null;

		try {
			employeeBOList = employeeDAO.viewAll();
			System.out.println("EmployeeBO : " + employeeBOList);
			if (null == employeeBOList) {
				System.out.println("There is NO  Records in Table ");
			}
			
		} catch (Exception exception) {
			System.err.println("Exception while fetching the Employee List - ");
			System.err.println("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			System.out.println("EmployeeList from DAO is " + employeeBOList);
		}
	}
}
