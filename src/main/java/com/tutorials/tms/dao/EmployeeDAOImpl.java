package com.tutorials.tms.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tutorials.tms.bo.Employee;
import com.tutorials.tms.db.DBConnection;

/**
 *
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public int createEmployee(Employee Employee) 
	throws Exception
	{
		// 1. Obtain the DB Connection
		
		Connection conn = DBConnection.getConn();
		
		//2. Prepare the SQL Query and Statement Object
		String sql = "INSERT INTO EMPLOYEE(EMP_ID, FIRST_NAME, LAST_NAME,DATE_OF_BIRTH, GENDER,"
				+"AADHAR_ID, BLOOD_GROUP, CITY, PERSONAL_EMAIL, OFFICIAL_EMAIL, PASSWORD, PRIMARY_CONTACT_NO,"
				+"SECONDARY_CONTACT_NO, HIGHEST_QUALIFICATION, SKILLSETS, DATE_OF_JOINING, HOBBIES,MANAGER_NAME , "
				+ "MANAGER_ID)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ? )";
		
		
		PreparedStatement ps = null;
		int rowsAdded = 0;
		
		ResultSet rs = null;
		
		ps = conn.prepareStatement(sql);
		
		//3. Set/ Bind Values to the Prepared Statement
		ps.setInt(1, Employee.getEmp_id());
		ps.setString(2, Employee.getFirst_name());
		ps.setString(3, Employee.getLast_name());
		ps.setDate(4, (java.sql.Date) Employee.getDate_of_birth());
		ps.setString(5,""+ Employee.getGender());
		ps.setString(6, Employee.getAadhar_id());
		ps.setString(7, Employee.getBlood_group());
		ps.setString(8, Employee.getCity());
		ps.setString(9, Employee.getPersonal_email());
		ps.setString(10, Employee.getOffical_email());
		ps.setString(11, Employee.getPassword());
		ps.setString(12, Employee. getPrimary_contact_no());
		ps.setString(13, Employee.getSecondary_contact_no());
		ps.setString(14,Employee.getHighest_qualification());
		ps.setString(15, Employee.getSkillsets());
		ps.setDate(16, (java.sql.Date) Employee.getDate_of_joining());
		ps.setString(17, Employee.getHobbies());
		ps.setString(18, Employee.getManager_name());
		ps.setInt(19, Employee.getManager_id());
		
		
		//4. Execute the Statement
		rowsAdded = ps.executeUpdate();
		
		

	 
		System.out.println("Rows Added : "+ rowsAdded);
	
		
		return rowsAdded;
	}

}
