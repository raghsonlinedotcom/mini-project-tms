package com.tutorials.tms.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/*import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.tutorials.tms.bo.Employee;
import com.tutorials.tms.dao.EmployeeDAO;
import com.tutorials.tms.dao.EmployeeDAOImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet({ "/EmployeeCreateServlet", "/EmployeeCreate" })
public class EmployeeCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("EmployeeCreateServlet - doPost() invoked");
		
		//response.setContentType("text/html");
		//response.getWriter().println("RegisterServlet invoked!");
		
		//1. Collect the input data
		Employee employee= new Employee();
		
		String emp_idStr = request.getParameter("employeeId");
		System.out.println("Param - empId : [" + emp_idStr + "]");
		
		if(null==emp_idStr) {
			//TODO Revisit this later
			throw new ServletException("Missing employeeId value, can't Create the records!");
		}
		
		int emp_id = Integer.parseInt(emp_idStr);
		
		
		String firstName = String.valueOf(request.getParameter("firstName"));
		String lastName = String.valueOf(request.getParameter("lastName"));
		Date  date_of_birth = Date.valueOf(request.getParameter("dob"));
		String gender = String.valueOf(request.getParameter("gender"));
		String aadhar_id = String.valueOf(request.getParameter("aadharId"));
		String  blood_group= String.valueOf(request.getParameter("bloodGroup"));
		String city = String.valueOf(request.getParameter("city"));
		String personal_email = String.valueOf(request.getParameter("persoalEmail"));
		String offical_email = String.valueOf(request.getParameter("officialEmail"));
		String password = String.valueOf(request.getParameter("password"));
		String primary_contact_no = String.valueOf(request.getParameter("primaryContactNumber"));
		String secondary_contact_no = String.valueOf(request.getParameter("secondaryContactNumber"));
		String highest_qualification = String.valueOf(request.getParameter("highestQualification"));
		String skillsets= String.valueOf(request.getParameter("skillSets"));
		Date date_of_joining= Date.valueOf(request.getParameter("doj"));
		
		String hobbies = String.valueOf(request.getParameter("hobbies"));
		String manager_name = String.valueOf(request.getParameter("managerName"));
		
		String manager_idStr = request.getParameter("managerId");
		System.out.println("Param - managerId : [" + manager_idStr + "]");
		
        int manager_id = manager_idStr!=null ? Integer.parseInt(manager_idStr) : 0;
		
		//2. Prepare the BO object
		 employee = new Employee(emp_id,firstName,lastName, date_of_birth, gender.charAt(0),aadhar_id,
					 blood_group, city, personal_email, offical_email, password,
					 primary_contact_no, secondary_contact_no, highest_qualification, skillsets,
					 date_of_joining, hobbies, manager_name, manager_id);
		System.out.println("Employee : " + employee);
		
		//3. Save it into the Database
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		int rowsAdded = -1;
		String errorMsg = null;
		Exception exceptionObj = null;
		/* MEMS-18, MEMS-19 */
		int sqlErrorCode = -1;
		String sqlState = null;
		
		boolean isError = false;
		
		try {
			rowsAdded = employeeDAO.createEmployee(employee);
		} catch(ClassNotFoundException classNotFoundException) { /* MEMS-18, MEMS-19 */
			isError = true;
			exceptionObj = classNotFoundException;				
		} catch (SQLException sqlException) {  /* MEMS-18, MEMS-19 */
			isError = true;
			exceptionObj = sqlException;
			sqlErrorCode = sqlException.getErrorCode();
			sqlState = sqlException.getSQLState();
		} catch (Exception exception) {
			isError = true;			
			exceptionObj = exception;			
		}
		
		/* Handling the error - at once in common for all the different types */
		/* MEMS-18, MEMS-19 */
		if(isError) 
		{
			System.err.println("Exception while registering the Employee");
			errorMsg = exceptionObj.getMessage();
			System.err.println("Error Message : " + errorMsg);	
			if(exceptionObj instanceof SQLException) {
				System.err.println("Error Code : " + sqlErrorCode);
				System.err.println("SQL State : " + sqlState);
			}
			//TODO ONLY for Development Purposes, remove it in PROD
			exceptionObj.printStackTrace();
		}
		
		//------ MEMS-14 - BugFix - START ----
		String message = null;
		
		if(rowsAdded<=0) { /* Error */
			message = "Error while registering the Employee. "; 
			
			if(exceptionObj instanceof ClassNotFoundException) {
				message = "Error connecting with the Database. Please contact Admin.";
			} else if(exceptionObj instanceof SQLIntegrityConstraintViolationException ) {
				message = message + "User already exists";
			} else {
				message = message + " Reason : " + errorMsg;
			}			
		} else { /* Success */ 
			message = "Registration successful.";
		}
		
		System.out.println("RowsAdded Id : " +rowsAdded);
		
		response.getWriter().println(message);
		//----- MEMS-14 - BugFix - END ------
	}

}