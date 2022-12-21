package com.tutorials.tms.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tutorials.tms.bo.EmployeeBO;
import com.tutorials.tms.dao.EmployeeDAO;
import com.tutorials.tms.dao.EmployeeDAOImpl;
import com.tutorials.tms.util.AppUtil;

/**
 * Servlet implementation class EmployeeCreateServlet
 */
@WebServlet({ "/EmployeeCreateServlet", "/EmployeeCreate" })
public class EmployeeCreateServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger(this.getClass());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeCreateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException 
	{
		logger.info("EmployeeCreateServlet - doPost() invoked");
		
		//response.setContentType("text/html");
		//response.getWriter().println("RegisterServlet invoked!");
		
		//1. Collect the input data
		EmployeeBO employeeBO= new EmployeeBO();
		
		
	
		String empId = String.valueOf(request.getParameter("empId"));
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
		logger.info("Param - managerId : [" + manageridStr + "]");
		
        int managerid = manageridStr!=null ? Integer.parseInt(manageridStr) : 0;

		//2. Prepare the BO object
        employeeBO.setEmpId(empId); 
        employeeBO.setFirstName(firstName); 
        employeeBO.setLastName(lastName);
        employeeBO.setDateOfBirth(dateOfBirth);
        employeeBO.setGender(gender.charAt(0));
        employeeBO.setAadharId(aadharId);
        employeeBO.setBloodGroup(bloodGroup);
        employeeBO.setCity(city);
        employeeBO.setPersonalEmail(personaleEmail);
        employeeBO.setOfficialEmail(officialEmail);
        employeeBO.setPassword(password);
        employeeBO.setPrimaryContactNo(primaryContactNo);
        employeeBO.setSecondaryContactNo(secondaryContactNo);
        employeeBO.setHighestQualification(highestQualification);  
        employeeBO.setSkillsets(skillsets);
        employeeBO.setDateOfJoining(dateOfJoining);
        employeeBO.setHobbies(hobbies);
        employeeBO.setManagerId(managerid);
        
		//3. Save it into the Database
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		int lastInsertedId = -1;
		String errorMsg = null;
		Exception exceptionObj = null;
		/* MEMS-18, MEMS-19 */
		int sqlErrorCode = -1;
		String sqlState = null;
		
		boolean isError = false;
		
		try {
			lastInsertedId = employeeDAO.createEmployee(employeeBO);
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
			logger.error("Exception while registering the EmployeeBO");
			errorMsg = exceptionObj.getMessage();
			logger.error("Error Message : " + errorMsg);	
			if(exceptionObj instanceof SQLException) {
				logger.error("Error Code : " + sqlErrorCode);
				logger.error("SQL State : " + sqlState);
			}
			if(AppUtil.isAppDevMode) {
				exceptionObj.printStackTrace();
			}
		}
		
	
		String message = null;
		String flag = null;
		
		if(lastInsertedId<=0) { /* Error */
			message = "Error while registering the EmployeeBO. "; 
			
			if(exceptionObj instanceof ClassNotFoundException) {
				message = "Error connecting with the Database. Please contact Admin.";
			} else if(exceptionObj instanceof SQLIntegrityConstraintViolationException ) {
				message = message + "User already exists";
			} else {
				message = message + " Reason : " + errorMsg;
			}			
		} else { /* Success */ 
			message = "Registration successful. Your Id  is : " + lastInsertedId;
		}
		
		logger.info("Last Inserted Id : " +lastInsertedId);
		request.setAttribute("message", message);
		request.setAttribute("flag", flag);
	
		request.setAttribute("employeeForm", employeeBO);
		
		
		response.getWriter().println(message);
		
	}

}