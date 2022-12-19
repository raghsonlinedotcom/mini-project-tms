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
 * Servlet implementation class EmployeeCreateServlet
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
		
		String idStr = request.getParameter("id");
		if(null==idStr) {
			//TODO Revisit this later
			throw new ServletException("Missing employeeId value, can't Create the records!");
		}
		
		int id = Integer.parseInt(idStr);
		
		
		String firstName = String.valueOf(request.getParameter("firstName"));
		String lastName = String.valueOf(request.getParameter("lastName"));
		Date  dateOfBirth = Date.valueOf(request.getParameter("dob"));
		String gender = String.valueOf(request.getParameter("gender"));
		String aadharId = String.valueOf(request.getParameter("aadharId"));
		String  bloodGroup= String.valueOf(request.getParameter("bloodGroup"));
		String city = String.valueOf(request.getParameter("city"));
		String personaleEmail = String.valueOf(request.getParameter("persoalEmail"));
		String officialEmail = String.valueOf(request.getParameter("officialEmail"));
		String password = String.valueOf(request.getParameter("password"));
		String primaryContactNo = String.valueOf(request.getParameter("primaryContactNumber"));
		String secondaryContactNo = String.valueOf(request.getParameter("secondaryContactNumber"));
		String highestQualification = String.valueOf(request.getParameter("highestQualification"));
		String skillsets= String.valueOf(request.getParameter("skillSets"));
		Date dateOfJoining= Date.valueOf(request.getParameter("doj"));
		
		String hobbies = String.valueOf(request.getParameter("hobbies"));
	
		
		String manageridStr = request.getParameter("managerId");
		System.out.println("Param - managerId : [" + manageridStr + "]");
		
        int managerid = manageridStr!=null ? Integer.parseInt(manageridStr) : 0;

		//2. Prepare the BO object
        employee.setId(id); 
        employee.setFirstName(firstName); 
        employee.setLastName(lastName);
        employee.setDateOfBirth(dateOfBirth);
        employee.setGender(gender.charAt(0));
        employee.setAadharId(aadharId);
        employee.setBloodGroup(bloodGroup);
        employee.setCity(city);
        employee.setPersonalEmail(personaleEmail);
        employee.setOfficialEmail(officialEmail);
        employee.setPassword(password);
        employee.setPrimaryContactNo(primaryContactNo);
        employee.setSecondaryContactNo(secondaryContactNo);
        employee.setHighestQualification(highestQualification);  
        employee.setSkillsets(skillsets);
        employee.setDateOfJoining(dateOfJoining);
        employee.setHobbies(hobbies);
        employee.setManagerId(managerid);
        
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
		} catch(ClassNotFoundException classNotFoundException) { 
			isError = true;
			exceptionObj = classNotFoundException;				
		} catch (SQLException sqlException) {  
			isError = true;
			exceptionObj = sqlException;
			sqlErrorCode = sqlException.getErrorCode();
			sqlState = sqlException.getSQLState();
		} catch (Exception exception) {
			isError = true;			
			exceptionObj = exception;			
		}
		
		/* Handling the error - at once in common for all the different types */
	
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
		
	
		String message = null;
		String flag = null;
		
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
		request.setAttribute("message", message);
		request.setAttribute("flag", flag);
	
		request.setAttribute("employeeForm", employee);
		
		
		response.getWriter().println(message);
		
	}

}