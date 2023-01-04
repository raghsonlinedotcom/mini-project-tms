package com.raghsonline.miniprojects.tms.dao;
import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.util.AppUtil;

import java.util.List;

public class ManagerListTest {
	
	public static void main(String[] args) {
		testManagerList();
	}
	
	public static void testManagerList()
	{
		List<EmployeeBO> managerList = null;
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		try {
			managerList = employeeDAO.viewManagers();
		} catch (Exception exception) {
			System.err.println("Exception while fetching the Managers List - " );
			System.err.println("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}
		System.out.println("ManagerList from DAO is " + managerList);
	}
}

