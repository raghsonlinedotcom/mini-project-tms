package com.raghsonline.miniprojects.tms.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;


public class EmployeeListAllJUnitTest {

	@Test
	void employeeListAllTest() {
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
		assertNotNull(employeeBO);
	}

}