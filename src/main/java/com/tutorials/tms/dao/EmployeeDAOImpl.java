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
	public int createEmployee(Employee employee) 
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
		ps.setInt(1, employee.getEmp_id());
		ps.setString(2, employee.getFirst_name());
		ps.setString(3, employee.getLast_name());
		ps.setDate(4, (java.sql.Date) employee.getDate_of_birth());
		ps.setString(5,""+ employee.getGender());
		ps.setString(6, employee.getAadhar_id());
		ps.setString(7, employee.getBlood_group());
		ps.setString(8, employee.getCity());
		ps.setString(9, employee.getPersonal_email());
		ps.setString(10, employee.getOffical_email());
		ps.setString(11, employee.getPassword());
		ps.setString(12, employee. getPrimary_contact_no());
		ps.setString(13, employee.getSecondary_contact_no());
		ps.setString(14,employee.getHighest_qualification());
		ps.setString(15, employee.getSkillsets());
		ps.setDate(16, (java.sql.Date) employee.getDate_of_joining());
		ps.setString(17, employee.getHobbies());
		ps.setString(18, employee.getManager_name()); // TODO: Problematic. Remove it.
		
		if(employee.getManager_id()==0) { /* No Manager */
			ps.setObject(19, null);
		} else {
			ps.setInt(19, employee.getManager_id());
		}
		
		
		
		//4. Execute the Statement
		rowsAdded = ps.executeUpdate();
		
		

	 
		System.out.println("Rows Added : "+ rowsAdded);
	
		
		return rowsAdded;
	}

}
