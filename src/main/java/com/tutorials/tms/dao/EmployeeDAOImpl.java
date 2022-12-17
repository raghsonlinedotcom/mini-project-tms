package com.tutorials.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tutorials.tms.bo.Employee;
import com.tutorials.tms.db.DBConnection;

/**
 *
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public int createEmployee(Employee employee) 
	throws Exception
	{
		// 1. Obtain the DB Connection
		
		Connection conn = DBConnection.getConn();

		// 2. Prepare the SQL Query and Statement Object
		String sql = "INSERT INTO EMPLOYEE(ID, FIRST_NAME, LAST_NAME,DATE_OF_BIRTH, GENDER,"
				+ "AADHAR_ID, BLOOD_GROUP, CITY, PERSONAL_EMAIL, OFFICIAL_EMAIL, PASSWORD, PRIMARY_CONTACT_NO,"
				+ "SECONDARY_CONTACT_NO, HIGHEST_QUALIFICATION, SKILLSETS, DATE_OF_JOINING, HOBBIES, "
				+ "MANAGER_ID)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?)";

		PreparedStatement ps = null;
		int rowsAdded = 0;
		
		ps = conn.prepareStatement(sql);
		
		//3. Set/ Bind Values to the Prepared Statement
				ps.setInt(1, employee.getId());
				ps.setString(2, employee.getFirstName());
				ps.setString(3, employee.getLastName());
				ps.setDate(4, (java.sql.Date) employee.getDateOfBirth());
				ps.setString(5,""+ employee.getGender());
				ps.setString(6, employee.getAadharId());
				ps.setString(7, employee.getBloodGroup());
				ps.setString(8, employee.getCity());
				ps.setString(9, employee.getPersonalEmail());
				ps.setString(10, employee.getOfficialEmail());
				ps.setString(11, employee.getPassword());
				ps.setString(12, employee. getPrimaryContactNo());
				ps.setString(13, employee.getSecondaryContactNo());
				ps.setString(14,employee.getHighestQualification());
				ps.setString(15, employee.getSkillsets());
				ps.setDate(16, (java.sql.Date) employee.getDateOfJoining());
				ps.setString(17, employee.getHobbies());
				
		if (employee.getManagerId() == 0) { /* No Manager */
			ps.setObject(18, null);
		} else {
			ps.setInt(18, employee.getManagerId());
		}
		
		
		
		//4. Execute the Statement
		rowsAdded = ps.executeUpdate();
		
		

	 
		System.out.println("Rows Added : "+ rowsAdded);
	
		
		return rowsAdded;
	}

}
