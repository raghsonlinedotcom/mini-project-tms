package  com.raghsonline.miniprojects.tms.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

public class EmployeeListAllTest {

	public static void main(String[] args) {
		testListAllEmployee();
	}

	public static void testListAllEmployee() {
		System.out.println("verifyEmployee  invoked ");

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		List<EmployeeBO> employeeBO = null;

		try {
			employeeBO = employeeDAO.viewAll();
			System.out.println("EmployeeBO : " + employeeBO);
			if (null == employeeBO) {
				System.out.println("There is NO  Records in Table ");
			}
		} catch (Exception exception) {
			System.err.println("Exception occurred while verifying an employee");
			System.err.println("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail(" EmployeeListAll() failed - " + exception.getMessage());
		}
	}
}
