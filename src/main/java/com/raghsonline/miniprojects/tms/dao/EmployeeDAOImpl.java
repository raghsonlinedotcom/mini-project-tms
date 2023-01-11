package com.raghsonline.miniprojects.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.db.DBConnection;
import com.raghsonline.miniprojects.tms.util.AppUtil;

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
				+ "AADHAR_ID, BLOOD_GROUP, CITY, PERSONAL_EMAIL, OFFICIAL_EMAIL, "
				+ "PASSWORD, PRIMARY_CONTACT_NO, SECONDARY_CONTACT_NO, HIGHEST_QUALIFICATION, "
				+ "SKILLSETS, DATE_OF_JOINING, HOBBIES, " + "MANAGER_ID)"
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

		logger.info("Rows Added : " + rowsAdded);
		logger.info("Last Inserted Id : " + lastInsertedId);

		// BEST PRACTICE! Added to avoid the resource leakage.
		// TODO : It has got a different overhead such that we may
		// need to frequently obtain/open a physical connection from DB
		// as we directly get the connection from the Database.
		// However, this can be resolved using a Connection Pooling,
		// which we can see later.
		conn.close();

		return lastInsertedId;
	}

	@Override
	public int getCount() 
			throws Exception 
	{
		logger.info("EmployeeDAOImpl - getCount() invoked");

		int count = 0;

		// 1. Need a DB Connection
		Connection conn = DBConnection.getConn();

		// 2. SQL Query
		String query = "SELECT COUNT(*) AS COUNT FROM EMPLOYEE";

		// 3. Create a Statement Object
		Statement stmt = conn.createStatement();

		// 4. Execute the Statement
		ResultSet rs = stmt.executeQuery(query);

		// 5. Extract the value from ResultSet (count in our case)
		while (rs.next()) {
			count = rs.getInt("COUNT");
		}

		logger.info("No of employees : " + count);

		// 6. Most Important - Close the Connection
		if (null != conn) {
			conn.close();
		}

		return count;
	}

	@Deprecated
	public EmployeeBO unUsedGetEmployeeByEmpId(int empId) 
			throws Exception 
	{
		logger.info("EmployeeDAOImpl - getEmployeeByEmpId() invoked, empId=" + empId);

		EmployeeBO employeeBO = null;

		// 1. Need a DB Connection
		Connection conn = DBConnection.getConn();

		// 2. SQL Query
		String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ? ";
		logger.info("Query : " + query);

		// 3. Create a Statement Object
		PreparedStatement pStmt = conn.prepareStatement(query);

		// 4. Set the arguments/parameter to the PreparedStatement
		pStmt.setInt(1, empId);

		// 5. Execute the Statement
		ResultSet rs = pStmt.executeQuery(query);

		// 6. Extract the value from ResultSet (count in our case)
		while (rs.next()) {
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

		// 6. Most Important - Close the Connection
		if (null != conn) {
			conn.close();
		}

		return employeeBO;
	}

	@Override
	public EmployeeBO getEmployeeByEmpId(int idParam) 
	{
		logger.info("EmployeeDAOImpl --- getEmployeeById - idParam :: " + idParam);

		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID=?";

		logger.info("SQL Query :: " + sql);

		PreparedStatement stmt = null;
		ResultSet rs = null;

		EmployeeBO employeeBO = null;
		Connection conn = null;

		try {

			conn = DBConnection.getConn();

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, idParam);

			rs = stmt.executeQuery();

			while (rs.next()) 
			{ // read one full row's data - one column at a time

				// makes sense to create an object, so that we don't waste the memory allotted
				// to an Object.
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
				employeeBO.setActive(rs.getBoolean("IS_ACTIVE"));
				employeeBO.setCreatedDate(rs.getTimestamp("CREATED_DATE"));
				employeeBO.setCreatedBy(rs.getString("CREATED_BY"));
				employeeBO.setUpdatedDate(rs.getTimestamp("UPDATED_DATE"));
				employeeBO.setUpdatedBy(rs.getInt("UPDATED_BY"));
				
			}
		} catch (SQLException sqlException) {
			System.err.println("SQLException occurred while reading the data from the Database Table");
			System.err.println("Message : " + sqlException.getMessage());
		} catch (Exception exception) {
			System.err.println("Exception occurred while reading the data from the Database Table");
			System.err.println("Message : " + exception.getMessage());
		} finally {
			try {
				if (null != rs)
					rs.close();
				if (null != stmt)
					stmt.close();
				if (null != conn)
					conn.close();
			} catch (SQLException sqlException) {
				System.err.println("Exception occurred while reading the data from the Database Table");
				System.err.println("Message : " + sqlException.getMessage());
			} finally {
				try {
					if (null != rs)
						rs.close();
					if (null != stmt)
						stmt.close();
					if (null != conn)
						conn.close();
				} catch (SQLException sqlException) {
					System.err.println("Exception occurred while closing the JDBC Resources");
					System.err.println("Message : " + sqlException.getMessage());
				}
			}
		}

		return employeeBO;
	}

	public EmployeeBO verifyEmployee(int idParam, String passwordParam)
	{
		logger.info("verifyEmployee - idParam :: " 
				+ idParam);

		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID=? AND PASSWORD =?";

		logger.info("SQL Query :: " + sql);

		PreparedStatement stmt = null;
		ResultSet rs = null;

		EmployeeBO employeeBO = null;
		Connection conn = null;

		try {

			conn = DBConnection.getConn();

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, idParam);
			stmt.setString(2, passwordParam);
			rs = stmt.executeQuery();

			while (rs.next())// read one full row's data - one column at a time 
			{ 

				// makes sense to create an object, so that we don't waste the memory allotted
				// to an Object.
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
				employeeBO.setActive(rs.getBoolean("IS_ACTIVE"));
			}
		} catch (SQLException sqlException) {
			logger.error("SQLException occurred while reading the data from the Database Table");
			logger.error("Message : " + sqlException.getMessage());
		} catch (Exception exception) {
			logger.error("Exception occurred while reading the data from the Database Table");
			logger.error("Message : " + exception.getMessage());
		} finally {			
			try {
				if (null != rs)
					rs.close();
				if (null != stmt)
					stmt.close();
				if (null != conn)
					conn.close();
			} catch (SQLException sqlException) {
				System.err.println("Exception occurred while closing the JDBC Resources");
				System.err.println("Message : " + sqlException.getMessage());
			}
		}

		return employeeBO;
	}

	public int updateEmployee(EmployeeBO employeeBO) 
	throws Exception 
	{
		logger.info("updateEmployee :: " + employeeBO);

		String sql = "UPDATE EMPLOYEE SET " + "FIRST_NAME=?, LAST_NAME=?, CITY=?, PERSONAL_EMAIL=?,"
				+ " PRIMARY_CONTACT_NO=?, SECONDARY_CONTACT_NO=?," + " HIGHEST_QUALIFICATION=?, SKILLSETS =?,"
				+ " HOBBIES = ?,UPDATED_DATE=?,UPDATED_BY=? WHERE EMP_ID= ?";

		logger.info("SQL Query :: " + sql);
		Connection conn = null;
		PreparedStatement pStmt = null;
		int recordsUpdated = 0;
		
		try
		{
			conn = DBConnection.getConn();
			
			pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, employeeBO.getFirstName());
			pStmt.setString(2, employeeBO.getLastName());
			pStmt.setString(3, employeeBO.getCity());
			pStmt.setString(4, employeeBO.getPersonalEmail());
			pStmt.setString(5, employeeBO.getPrimaryContactNo());
			pStmt.setString(6, employeeBO.getSecondaryContactNo());
			pStmt.setString(7, employeeBO.getHighestQualification());
			pStmt.setString(8, employeeBO.getSkillsets());
			pStmt.setString(9, employeeBO.getHobbies());
			pStmt.setTimestamp(10, employeeBO.getUpdatedDate());
			pStmt.setInt(11, employeeBO.getUpdatedBy());
			pStmt.setInt(12, employeeBO.getEmpId());
			
			recordsUpdated = pStmt.executeUpdate();
			
			logger.info("recordsUpdated : " + recordsUpdated);
			
		} catch (Exception exception) {
			logger.error("Exception occurred while updating the data into the Database Table");
			logger.error("Message : " + exception.getMessage());
		} finally {
			try {
				if (null != pStmt)
					pStmt.close();
				if (null != conn)
					conn.close();
			} catch (SQLException sqlException) {
				logger.error("Exception occurred while closing the JDBC Resources");
				logger.error("Message : " + sqlException.getMessage());
				if(AppUtil.isAppDevMode) {
					sqlException.printStackTrace();
				}
			}
		}

		logger.info("recordsUpdated  : " + recordsUpdated);
		
		return recordsUpdated;
	}

	@Override
	public List<EmployeeBO> viewAll() 
			throws Exception 
	{	
		logger.info("listAll Invoked");
		
		String sql = "SELECT * FROM EMPLOYEE";
		
		logger.info("SQL Query :: "+ sql);
		
		Statement stmt = null;
		ResultSet rs = null;
		List<EmployeeBO> employeeBOList = new ArrayList<>();
		EmployeeBO employeeBO = null;
		Connection conn = null;
		
		try 
		{
			conn = DBConnection.getConn();
			stmt = conn.createStatement();	
			rs = stmt.executeQuery(sql);
			
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
				employeeBO.setActive(rs.getBoolean("IS_ACTIVE"));				
				employeeBOList.add(employeeBO);	
			}
		} catch (SQLException sqlException) {
			logger.error("SQLException occurred while Obtaining the data from the Database Table");
			logger.error("Message : " + sqlException.getMessage());
		} catch (Exception exception) {
			logger.error("Exception occurred while Obtaining the data from the Database Table");
			logger.error("Message : " + exception.getMessage());
		} finally {
			try {
				if (null != rs)
					rs.close();
				if (null != stmt)
					stmt.close();
				if (null != conn)
					conn.close();
			} catch (SQLException sqlException) {
				System.err.println("Exception occurred while closing the JDBC Resources");
				System.err.println("Message : " + sqlException.getMessage());
				if(AppUtil.isAppDevMode) {
					sqlException.printStackTrace();
				}
			}
		}
		
		logger.info("EmployeeBOList size : " + employeeBOList.size());
		
		return employeeBOList;
	}

	@Override
	public List<EmployeeBO> viewManagers() throws Exception {
		logger.info("viewManagers() Invoked");
		
		String sql = "SELECT * FROM EMPLOYEE WHERE MANAGER_ID IS NULL AND IS_ACTIVE = TRUE";
		
		logger.info("SQL Query :: "+ sql);
		
		Statement stmt = null;
		ResultSet rs = null;
		List<EmployeeBO> managerBOList = new ArrayList<>();
		EmployeeBO employeeBO = null;
		Connection conn = null;
		
		try 
		{
			conn = DBConnection.getConn();
			stmt = conn.createStatement();	
			rs = stmt.executeQuery(sql);
			
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
				
				managerBOList.add(employeeBO);	
			}
		} catch (SQLException sqlException) {
			logger.error("SQLException occurred while Obtaining the data from the Database Table");
			logger.error("Message : " + sqlException.getMessage());
		} catch (Exception exception) {
			logger.error("Exception occurred while Obtaining the data from the Database Table");
			logger.error("Message : " + exception.getMessage());
		} finally {
			try {
				if (null != rs)
					rs.close();
				if (null != stmt)
					stmt.close();
				if (null != conn)
					conn.close();
			} catch (SQLException sqlException) {
				System.err.println("Exception occurred while closing the JDBC Resources");
				System.err.println("Message : " + sqlException.getMessage());
				if(AppUtil.isAppDevMode) {
					sqlException.printStackTrace();
				}
			}
		}
		
		logger.info("ManagerBOList size : " + managerBOList.size());

		return managerBOList;
	}
	
	@Override
	public int deleteEmployee(int empId) throws Exception 
	{
		logger.info("deleteEmployee :: " + empId);

		String sql = "UPDATE EMPLOYEE SET IS_ACTIVE = FALSE WHERE EMP_ID = ?";

		logger.info("SQL Query :: " + sql);
		Connection conn = null;
		PreparedStatement pStmt = null;
		int recordsUpdated = 0;
		
		try
		{
			conn = DBConnection.getConn();
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, empId);
			recordsUpdated = pStmt.executeUpdate();
			
			logger.info("recordsUpdated : " + recordsUpdated);
			
		} catch (Exception exception) {
			logger.error("Exception occurred while deleting employee(updating is_active column) "
					+ "the data from the Database Table");
			logger.error("Message : " + exception.getMessage());
		} finally {
			try {
				if (null != pStmt)
					pStmt.close();
				if (null != conn)
					conn.close();
			} catch (SQLException sqlException) {
				logger.error("Exception occurred while closing the JDBC Resources");
				logger.error("Message : " + sqlException.getMessage());
				if(AppUtil.isAppDevMode) {
					sqlException.printStackTrace();
				}
			}
		}
		
		return recordsUpdated;
	}

	@Override
	public int managerEditMember(EmployeeBO employeeBO) 
	throws Exception 
	{
		logger.info("Manager Edit Memeber :: " + employeeBO);

		String sql = "UPDATE EMPLOYEE SET " + "FIRST_NAME=?, LAST_NAME=?, DATE_OF_BIRTH = ?,"
				+ " GENDER =?, AADHAR_ID = ?, BLOOD_GROUP = ?, CITY=?, PERSONAL_EMAIL=?, OFFICIAL_EMAIL=?,"
				+ " PRIMARY_CONTACT_NO=?, SECONDARY_CONTACT_NO=?, HIGHEST_QUALIFICATION=?, SKILLSETS =?,"
				+ " DATE_OF_JOINING =?, HOBBIES = ?,IS_ACTIVE = ?,UPDATED_DATE=?, UPDATED_BY = ?"
				+ " WHERE MANAGER_ID= ? AND EMP_ID = ?";

		logger.info("SQL Query :: " + sql);
		Connection conn = null;
		PreparedStatement pStmt = null;
		int recordsUpdated = 0;
		
		try
		{
			conn = DBConnection.getConn();
			
			pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, employeeBO.getFirstName());
			pStmt.setString(2, employeeBO.getLastName());
			pStmt.setDate(3, (java.sql.Date) employeeBO.getDateOfBirth());
			pStmt.setString(4, "" + employeeBO.getGender());
			pStmt.setString(5, employeeBO.getAadharId());
			pStmt.setString(6, employeeBO.getBloodGroup());
			pStmt.setString(7, employeeBO.getCity());
			pStmt.setString(8, employeeBO.getPersonalEmail());
			pStmt.setString(9, employeeBO.getOfficialEmail());
			pStmt.setString(10, employeeBO.getPrimaryContactNo());
			pStmt.setString(11, employeeBO.getSecondaryContactNo());
			pStmt.setString(12, employeeBO.getHighestQualification());
			pStmt.setString(13, employeeBO.getSkillsets());
			pStmt.setDate(14, (java.sql.Date) employeeBO.getDateOfJoining());
			pStmt.setString(15, employeeBO.getHobbies());
			pStmt.setBoolean(16, employeeBO.isActive());
			pStmt.setTimestamp(17, employeeBO.getUpdatedDate());
			pStmt.setInt(18, employeeBO.getUpdatedBy());
			pStmt.setInt(19, employeeBO.getManagerId());
			pStmt.setInt(20, employeeBO.getEmpId());
			
			recordsUpdated = pStmt.executeUpdate();
			
			logger.info("recordsUpdated : " + recordsUpdated);
			
		} catch (Exception exception) {
			logger.error("Exception occurred while updating the data into the Database Table");
			logger.error("Message : " + exception.getMessage());
		} finally {
			try {
				if (null != pStmt)
					pStmt.close();
				if (null != conn)
					conn.close();
			} catch (SQLException sqlException) {
				logger.error("Exception occurred while closing the JDBC Resources");
				logger.error("Message : " + sqlException.getMessage());
				if(AppUtil.isAppDevMode) {
					sqlException.printStackTrace();
				}
			}
		}

		logger.info("recordsUpdated  : " + recordsUpdated);
		
		return recordsUpdated;
	}

	@Override
	public int deleteData(int empId) throws Exception {
		logger.info("deleteData :: " + empId);

		String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";

		logger.info("SQL Query :: " + sql);
		Connection conn = null;
		PreparedStatement pStmt = null;
		int rowsDeleted = 0;
		
		try
		{
			conn = DBConnection.getConn();
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, empId);
			rowsDeleted = pStmt.executeUpdate();
			
			logger.info("recordsUpdated : " + rowsDeleted);
			
		} catch (Exception exception) {
			logger.error("Exception occurred while deleting employee"
					+ "the data from the Database Table");
			logger.error("Message : " + exception.getMessage());
		} finally {
			try {
				if (null != pStmt)
					pStmt.close();
				if (null != conn)
					conn.close();
			} catch (SQLException sqlException) {
				logger.error("Exception occurred while closing the JDBC Resources");
				logger.error("Message : " + sqlException.getMessage());
				if(AppUtil.isAppDevMode) {
					sqlException.printStackTrace();
				}
			}
		}
		
		return rowsDeleted;
	}
}