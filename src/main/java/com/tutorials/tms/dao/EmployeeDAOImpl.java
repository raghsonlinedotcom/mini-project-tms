package com.tutorials.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		ps.setInt(1, employeeBO.getEmpId());
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

	@Deprecated
	public EmployeeBO unUsedGetEmployeeByEmpId(int empId) 
	throws Exception 
	{
		logger.info("EmployeeDAOImpl - getEmployeeByEmpId() invoked, empId="+empId);
		
		EmployeeBO employeeBO = null;
		
		//1. Need a DB Connection
		Connection conn = DBConnection.getConn();
		
		//2. SQL Query
		String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ? ";
		logger.info("Query : " + query);
		
		//3. Create a Statement Object 
		PreparedStatement pStmt = conn.prepareStatement(query);
		
		//4. Set the arguments/parameter to the PreparedStatement
		pStmt.setInt(1, empId);
		
		//5. Execute the Statement 
		ResultSet rs = pStmt.executeQuery(query);
		
		//6. Extract the value from ResultSet (count in our case)
		while(rs.next()) 
		{
			employeeBO = new EmployeeBO();
			
			employeeBO.setId(rs.getInt("ID")); 
			employeeBO.setEmpId(rs.getInt("EMP_ID"));
	        employeeBO.setFirstName(rs.getString("FIRST_NAME")); 
	        employeeBO.setLastName(rs.getString("LAST_NAME"));
	        employeeBO.setDateOfBirth(rs.getDate("DATE_OF_BIRTH"));
	        employeeBO.setGender(rs.getString("GENDER").charAt(0));
	        employeeBO.setAadharId(rs.getString("AADHAR_ID"));
	        employeeBO.setBloodGroup(rs.getString("BLOOD_GROUP"));
	        employeeBO.setCity(rs.getString("CITY"));
	        employeeBO.setPersonalEmail(rs.getString("PERSONAL_EMAIL"));
	        employeeBO.setOfficialEmail(rs.getString("OFFICIAL_EMAIL"));
	        employeeBO.setPassword(rs.getString("PASSWORD"));
	        employeeBO.setPrimaryContactNo(rs.getString("PRIMARY_CONTACT_NO"));
	        employeeBO.setSecondaryContactNo(rs.getString("SECONDARY_CONTACT_NO"));
	        employeeBO.setHighestQualification(rs.getString("HIGHEST_QUALIFICATION"));  
	        employeeBO.setSkillsets(rs.getString("SKILLSETS"));
	        employeeBO.setDateOfJoining(rs.getDate("DATE_OF_JOINING"));
	        employeeBO.setHobbies(rs.getString("HOBBIES"));
	        employeeBO.setManagerId(rs.getInt("MANAGER_ID"));
		}
		
		logger.info("EmployeeBO : " + employeeBO);
		
		//6. Most Important - Close the Connection
		if(null!=conn) {
			conn.close();
		}
			
		return employeeBO;
	}
	
	@Override
	public EmployeeBO getEmployeeByEmpId(int idParam)
	{
		System.out.println("EmployeeDAOImpl --- getEmployeeById - idParam :: " + idParam);
		
		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID=?";

		System.out.println("SQL Query :: " + sql);
		
		PreparedStatement stmt = null;
		ResultSet rs = null;

		EmployeeBO employeeBO = null;
		Connection conn = null;
		
		try {
			
			conn = DBConnection.getConn();
			
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, idParam);

			rs = stmt.executeQuery();
		
			while(rs.next()) { //read one full row's data - one column at a time

				// makes sense to create an object, so that we don't waste the memory allotted to an Object.
				employeeBO = new EmployeeBO();

				employeeBO.setId(rs.getInt("ID"));
				employeeBO.setEmpId(rs.getInt("EMP_ID"));
				employeeBO.setFirstName(rs.getString("FIRST_NAME")); 
		        employeeBO.setLastName(rs.getString("LAST_NAME"));
		        employeeBO.setDateOfBirth(rs.getDate("DATE_OF_BIRTH"));
		        employeeBO.setGender(rs.getString("GENDER").charAt(0));
		        employeeBO.setAadharId(rs.getString("AADHAR_ID"));
		        employeeBO.setBloodGroup(rs.getString("BLOOD_GROUP"));
		        employeeBO.setCity(rs.getString("CITY"));
		        employeeBO.setPersonalEmail(rs.getString("PERSONAL_EMAIL"));
		        employeeBO.setOfficialEmail(rs.getString("OFFICIAL_EMAIL"));
		        employeeBO.setPassword(rs.getString("PASSWORD"));
		        employeeBO.setPrimaryContactNo(rs.getString("PRIMARY_CONTACT_NO"));
		        employeeBO.setSecondaryContactNo(rs.getString("SECONDARY_CONTACT_NO"));
		        employeeBO.setHighestQualification(rs.getString("HIGHEST_QUALIFICATION"));  
		        employeeBO.setSkillsets(rs.getString("SKILLSETS"));
		        employeeBO.setDateOfJoining(rs.getDate("DATE_OF_JOINING"));
		        employeeBO.setHobbies(rs.getString("HOBBIES"));
		        employeeBO.setManagerId(rs.getInt("MANAGER_ID"));
			}
		}catch(SQLException sqlException) {
			System.err.println("SQLException occurred while reading the data from the Database Table");
			System.err.println("Message : " + sqlException.getMessage());
		}catch(Exception exception) {
			System.err.println("Exception occurred while reading the data from the Database Table");
			System.err.println("Message : " + exception.getMessage());
		}finally {
			try {
				if(null!=rs) rs.close();
				if(null!=stmt) stmt.close();
				if(null!=conn) conn.close();
			}catch(SQLException sqlException) {
				System.err.println("Exception occurred while reading the data from the Database Table");
				System.err.println("Message : " + sqlException.getMessage());
			}finally {
				try {
					if(null!=rs) rs.close();
					if(null!=stmt) stmt.close();
					if(null!=conn) conn.close();
				}catch(SQLException sqlException) {
					System.err.println("Exception occurred while closing the JDBC Resources");
					System.err.println("Message : " + sqlException.getMessage());
				}
			}
		}

		return employeeBO;
	}
}
