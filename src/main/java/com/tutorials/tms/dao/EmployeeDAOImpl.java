package com.tutorials.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.tutorials.tms.bo.EmployeeBO;
import com.tutorials.tms.db.DBConnection;

/**
 *
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO 
{
	Logger logger = Logger.getLogger(EmployeeDAOImpl.class);

	@Override
	public int createEmployee(EmployeeBO employeeBO) 
	throws Exception 
	{
		logger.info("EmployeeDAOImpl - createEmployee() invoked");
		
		// 1. Obtain the DB Connection
		Connection conn = DBConnection.getConn();

		// 2. Prepare the SQL Query and Statement Object
		String sql = "INSERT INTO EMPLOYEE(EMP_ID, FIRST_NAME, LAST_NAME,DATE_OF_BIRTH, GENDER,"
				+ "AADHAR_ID, BLOOD_GROUP, CITY, PERSONAL_EMAIL, OFFICIAL_EMAIL, " + 
				"PASSWORD, PRIMARY_CONTACT_NO, SECONDARY_CONTACT_NO, HIGHEST_QUALIFICATION, " + 
				"SKILLSETS, DATE_OF_JOINING, HOBBIES, " + "MANAGER_ID)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?)";

		PreparedStatement ps = null;
		int rowsAdded = 0;
		int lastInsertedId = 0;
		ResultSet rs = null;

		ps = conn.prepareStatement(sql);

		// 3. Set/ Bind Values to the Prepared Statement
		ps.setString(1, employeeBO.getEmpId());
		ps.setString(2, employeeBO.getFirstName());
		ps.setString(3, employeeBO.getLastName());
		ps.setDate(4, (java.sql.Date) employeeBO.getDateOfBirth());
		ps.setString(5, "" + employeeBO.getGender());
		ps.setString(6, employeeBO.getAadharId());
		ps.setString(7, employeeBO.getBloodGroup());
		ps.setString(8, employeeBO.getCity());
		ps.setString(9, employeeBO.getPersonalEmail());
		ps.setString(10, employeeBO.getOfficialEmail());
		ps.setString(11, employeeBO.getPassword());
		ps.setString(12, employeeBO.getPrimaryContactNo());
		ps.setString(13, employeeBO.getSecondaryContactNo());
		ps.setString(14, employeeBO.getHighestQualification());
		ps.setString(15, employeeBO.getSkillsets());
		ps.setDate(16, (java.sql.Date) employeeBO.getDateOfJoining());
		ps.setString(17, employeeBO.getHobbies());

		if (employeeBO.getManagerId() == 0) { /* No Manager */
			ps.setObject(18, null);
		} else {
			ps.setInt(18, employeeBO.getManagerId());
		}

		// 4. Execute the Statement
		rowsAdded = ps.executeUpdate();

		rs = ps.executeQuery("SELECT LAST_INSERT_ID()");

	    if (rs.next()) {
	    	lastInsertedId = rs.getInt(1);
	    } else {
	        logger.error("There was no record inserted in this session!");
	    }
		
		logger.info("Rows Added : "+ rowsAdded);
		logger.info("Last Inserted Id : "+ lastInsertedId);
		
		//BEST PRACTICE! Added to avoid the resource leakage. 
		//TODO : It has got a different overhead such that we may 
		// need to frequently obtain/open a physical connection from DB
		// as we directly get the connection from the Database.
		//However, this can be resolved using a Connection Pooling,
		//which we can see later. 
		conn.close();
		
		return lastInsertedId;
	}
	
	@Override
	public int getCount() throws Exception 
	{
		logger.info("EmployeeDAOImpl - getCount() invoked");
		
		int count = 0;
		
		//1. Need a DB Connection
		Connection conn = DBConnection.getConn();
		
		//2. SQL Query
		String query = "SELECT COUNT(*) AS COUNT FROM EMPLOYEE";
		
		//3. Create a Statement Object 
		Statement stmt = conn.createStatement();
		
		//4. Execute the Statement 
		ResultSet rs = stmt.executeQuery(query);
		
		//5. Extract the value from ResultSet (count in our case)
		while(rs.next()) {
			count = rs.getInt("COUNT");
		}
		
		logger.info("No of employees : " + count);
		
		//6. Most Important - Close the Connection
		if(null!=conn) {
			conn.close();
		}
			
		return count;
	}
}
