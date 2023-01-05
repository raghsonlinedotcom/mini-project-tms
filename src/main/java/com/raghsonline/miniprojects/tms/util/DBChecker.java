/**
 * 
 */
package com.raghsonline.miniprojects.tms.util;

import java.sql.Connection;

import com.raghsonline.miniprojects.tms.dao.EmployeeDAO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl;
import com.raghsonline.miniprojects.tms.db.DBConnection;

/**
 * @author raghavan.muthu
 *
 */
public class DBChecker 
{
	public static boolean FLAG_DB_READY = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		checkDB();
		System.out.println("DB Readiness Flag : " + FLAG_DB_READY);
	}
	
	public static void checkDB()
	{
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		int count = 0;
		
		try {
			connectToDB();
			count = employeeDAO.getCount();
		} catch (Exception exception) {
			System.err.println("Exception occurred while verifying the DB Status : ");
			System.err.println("Error Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}
		
		/**
		 * Our TMS, we want to have at least one manager to be
		 * present in the EMPLOYEE table, before any employee can
		 * register himself/herself. If there are no records 
		 * present in the EMPLOYEE table, we are not good to start.
		 */
		if(count > 0) {
			FLAG_DB_READY = true;
		}
	}

	public static void connectToDB() throws Exception
	{
		Connection conn = DBConnection.getConn();
		System.out.println("Connection : " + conn);
	}
}
