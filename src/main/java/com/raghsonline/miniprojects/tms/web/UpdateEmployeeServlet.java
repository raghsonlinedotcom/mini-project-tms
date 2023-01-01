package com.raghsonline.miniprojects.tms.web;


import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */

@WebServlet({ "/UpdateEmployeeServlet", "/UpdateEmployee" })

public class UpdateEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(this.getClass());
	boolean validationError = false;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmployeeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("UpdateEmployeeServlet - doPost() invoked");
		
		String errorMsgUI = "<ul>";
		EmployeeBO employeeBO= new EmployeeBO();
		
		String idStr = request.getParameter("id");
		int id = idStr != "" ? Integer.parseInt(idStr) : 0;
		logger.info("Param - id : [" + id + "]");
		errorMsgUI = validateField(employeeBO, id, "id", errorMsgUI);

		String empIdStr = request.getParameter("empId");
		int empId = empIdStr != "" ? Integer.parseInt(empIdStr) : 0;
		logger.info("Param - empId : [" + empId + "]");
		errorMsgUI = validateField(employeeBO, empId, "empId", errorMsgUI);
		

		String firstName = request.getParameter("firstName");
		logger.info("Param - firstName : [" + firstName + "]");
		errorMsgUI = validateField(employeeBO, firstName, "firstName", errorMsgUI);
		
		String lastName = request.getParameter("lastName");
		logger.info("Param - lastName : [" + lastName + "]");
		errorMsgUI = validateField(employeeBO, lastName, "lastName", errorMsgUI);
		
		
		Date dateOfBirth = Date.valueOf(request.getParameter("dob"));
		logger.info("Param - dateOfBirth : [" + dateOfBirth + "]");
		errorMsgUI = validateField(employeeBO, dateOfBirth, "dateOfBirth", errorMsgUI);
		
		String gender = request.getParameter("gender");
		logger.info("Param - gender : [" + gender + "]");
		errorMsgUI = validateField(employeeBO, gender, "gender", errorMsgUI);
		
		
		String aadharId = request.getParameter("aadharId");
		logger.info("Param - aadharId : [" + aadharId + "]");
		errorMsgUI = validateField(employeeBO, aadharId, "aadharId", errorMsgUI);
		
		String bloodGroup = request.getParameter("bloodGroup");
		logger.info("Param - bloodGroup : [" + bloodGroup + "]");
		errorMsgUI = validateField(employeeBO, bloodGroup, "bloodGroup", errorMsgUI);
		
		String city = request.getParameter("city");
		logger.info("Param - city : [" + city + "]");
		errorMsgUI = validateField(employeeBO, city, "city", errorMsgUI);
		
		String personalEmail = request.getParameter("personalEmail");
		logger.info("Param - personalEmail : [" + personalEmail + "]");
		errorMsgUI = validateField(employeeBO, personalEmail, "personalEmail", errorMsgUI);
		
		String officialEmail = request.getParameter("officialEmail");
		logger.info("Param - officialEmail : [" + officialEmail + "]");
		errorMsgUI = validateField(employeeBO, officialEmail, "officialEmail", errorMsgUI);
		
		
		String primaryContactNo = request.getParameter("primaryContactNumber");
		logger.info("Param - primaryContactNo : [" + primaryContactNo + "]");
		errorMsgUI = validatePrimaryContactNoField(employeeBO, primaryContactNo, "primaryContactNo", errorMsgUI);
		
		
		String secondaryContactNo = request.getParameter("secondaryContactNumber");
		logger.info("Param - secondaryContactNo : [" + secondaryContactNo + "]");
		errorMsgUI = validateSecondaryContactNoField(employeeBO, secondaryContactNo, "secondaryContactNo", errorMsgUI);
		
		String highestQualification = request.getParameter("highestQualification");
		logger.info("Param - highestQualification : [" + highestQualification + "]");
		errorMsgUI = validateField(employeeBO, highestQualification, "highestQualification", errorMsgUI);
		
		
		String skillsets = request.getParameter("skillSets");
		logger.info("Param - skillsets : [" + skillsets + "]");
		errorMsgUI = validateField(employeeBO, skillsets, "skillsets", errorMsgUI);
		
	
		Date dateOfJoining = Date.valueOf(request.getParameter("doj"));
		logger.info("Param - dateOfJoining : [" + dateOfJoining + "]");
		errorMsgUI = validateField(employeeBO, dateOfJoining, "dateOfJoining", errorMsgUI);
		
		
		//Separate validation for Hobbies : as they are optional and max length is 100. 
		//So length can be either 0 or 100
		String hobbies = request.getParameter("hobbies");
		logger.info("Param - hobbies : [" + hobbies + "]");
		errorMsgUI = validateHobbiesField(employeeBO, hobbies, "hobbies", errorMsgUI);
	
		
		String manageridStr = request.getParameter("managerId");
		int managerid = manageridStr != null ? Integer.parseInt(manageridStr) : 0;
		logger.info("Param - managerId : [" + managerid + "]");
		employeeBO.setManagerId(managerid);
		
		if(validationError) {
        	errorMsgUI += "</ul>";
        	request.setAttribute("errorMsgUI", errorMsgUI);
        	request.setAttribute("employeeBO", employeeBO);
        	validationError = false;
        	request.getRequestDispatcher("member/edit.jsp").forward(request, response);
        	return;
        }

		employeeBO.setId(id);
		employeeBO.setEmpId(empId);
		employeeBO.setFirstName(firstName);
		employeeBO.setLastName(lastName);
		employeeBO.setDateOfBirth(dateOfBirth);
		employeeBO.setGender(gender.charAt(0));
		employeeBO.setAadharId(aadharId);
		employeeBO.setBloodGroup(bloodGroup);
		employeeBO.setCity(city);
		employeeBO.setPersonalEmail(personalEmail);
		employeeBO.setOfficialEmail(officialEmail);
		employeeBO.setPrimaryContactNo(primaryContactNo);
		employeeBO.setSecondaryContactNo(secondaryContactNo);
		employeeBO.setHighestQualification(highestQualification);
		employeeBO.setSkillsets(skillsets);
		employeeBO.setDateOfJoining(dateOfJoining);
		employeeBO.setHobbies(hobbies);

		String exceptionMsg = null;
		int recordsUpdated = 0;
		EmployeeDAO employeeDAO = null;
		String url = null;
		EmployeeBO employeeBO1 = null;
		try {
			employeeDAO = new EmployeeDAOImpl();
			recordsUpdated = employeeDAO.updateEmployee(employeeBO);
		} catch (Exception exception) {
			exceptionMsg = exception.getMessage();
			logger.error("Exception occurred while updating the data into the Database Table");
			logger.error("Message" + exceptionMsg);

			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}
		
		if (null != exceptionMsg) {
			request.setAttribute("exceptionMsg", exceptionMsg);
		} else if (recordsUpdated > 0) {
			request.setAttribute("message", "Record updated successfully!");
			employeeDAO = new EmployeeDAOImpl();
			try {
				employeeBO1 = employeeDAO.getEmployeeByEmpId(empId);
			} catch (Exception exception) {
				logger.error("Exception occurred while updating the data into the Database Table");
				logger.error("Message : " + exceptionMsg);
				
				if (AppUtil.isAppDevMode) {
					exception.printStackTrace();
				}
			}
			logger.info("employeeBO1 : " + employeeBO1);
			request.setAttribute("employeeBO", employeeBO1);
			url = "member/view.jsp";
		}

		else {
			request.setAttribute("errorMsg", "Error while updating the record!");
			request.setAttribute("employeeBO", employeeBO);
			url = "member/edit.jsp";
		}
		
		// 5. Redirect/Delegate to the corresponding view
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private String addError(String errorMsg) {
		return "<li>" + errorMsg + "</li>";
	}
	
	public String validateField(EmployeeBO employeeBO, int value, String fieldName, String errorMsgUI) {
		if(value==0) {	
			validationError = true;
			logger.error(fieldName + " cannot be Zero(0)");			
			errorMsgUI += addError(fieldName + " cannot be Zero(0)");
		} 
		
		setField(employeeBO, fieldName, value);
		return errorMsgUI;
	}
	
	public String validateField(EmployeeBO employeeBO, String value, String fieldName, String errorMsgUI) {
		if(null==value || value.trim().length()<=0) {	
			validationError = true;
			logger.error(fieldName + " cannot be null");			
			errorMsgUI += addError(fieldName + " cannot be null");
		} 
		
		setField(employeeBO, fieldName, value);
		return errorMsgUI;
	}
	
	public String validateField(EmployeeBO employeeBO, Date value, String fieldName, String errorMsgUI) {
		if(null==value) {	
			validationError = true;
			logger.error(fieldName + " cannot be null");			
			errorMsgUI += addError(fieldName + " cannot be null");
		} 
		
		setField(employeeBO, fieldName, value);
		return errorMsgUI;
	}
	
	public String validatePrimaryContactNoField(EmployeeBO employeeBO, String value, String fieldName, String errorMsgUI) {
		if(null==value || value.trim().length()!=10) {	
			validationError = true;
			logger.error(fieldName + " is in invalid format");			
			errorMsgUI += addError(fieldName + " must have exactly 10 digits");
		} 
		
		setField(employeeBO, fieldName, value);
		return errorMsgUI;
	}
	
	public String validateSecondaryContactNoField(EmployeeBO employeeBO, String value, String fieldName, String errorMsgUI) {
		if(value.trim().length()==0)
		{
			logger.info("Secondary contact number is optional and length can be zero");
		}
		
		else if((value.trim().length()>0 && value.trim().length()<10) || value.trim().length()>10) {	
				validationError = true;
				logger.error(fieldName + " is in invalid format");			
				errorMsgUI += addError(fieldName + "  can be optional or must have exactly 10 digits");
			} 
		
		setField(employeeBO, fieldName, value);
		return errorMsgUI;
	}
	
	public String validateHobbiesField(EmployeeBO employeeBO, String value, String fieldName, String errorMsgUI) {
		
		if(value.trim().length()>100) {	
				validationError = true;
				logger.error(fieldName + " is in invalid format");			
				errorMsgUI += addError(fieldName + "  can be optional or must contain 100 or fewer characters");
			} 
		
		setField(employeeBO, fieldName, value);
		return errorMsgUI;
	}
	
	public void setField(EmployeeBO employeeBO, String fieldName ,int value)
	{
		switch(fieldName) 
		{
			case "id":
			employeeBO.setId(value);
			break;
			
			case "empId":
				employeeBO.setEmpId(value);
				break;
			
		}
	}
	
	public void setField(EmployeeBO employeeBO, String fieldName ,Date value)
	{
		switch(fieldName) 
		{
			case "dateOfBirth":
				employeeBO.setDateOfBirth(value);
				break;
			case "dateOfJoining":
				employeeBO.setDateOfJoining(value);
				break;
			
		}
	}
	
	public void setField(EmployeeBO employeeBO, String fieldName ,String value)
	{
		switch(fieldName) 
		{
			case "firstName":
				employeeBO.setFirstName(value);
				break;
			case "lastName" :
				employeeBO.setLastName(value);
				break;
			case "gender" :
				employeeBO.setGender(value.charAt(0));
				break;
			case "aadharId" :
				employeeBO.setAadharId(value);
				break;
			case "bloodGroup" :
				employeeBO.setBloodGroup(value);
				break;
			case "city" :
				employeeBO.setCity(value);
				break;
			case "personalEmail" :
				employeeBO.setPersonalEmail(value);
				break;
			case "officialEmail" :
				employeeBO.setOfficialEmail(value);
				break;
			case "password" :
				employeeBO.setPassword(value);
				break;
			case "primaryContactNo" :
				employeeBO.setPrimaryContactNo(value);
				break;
			case "secondaryContactNo" :
				employeeBO.setSecondaryContactNo(value);
				break;
			case "highestQualification" :
				employeeBO.setHighestQualification(value);
			case "skillsets" :
				employeeBO.setSkillsets(value);
			case "hobbies" :
				employeeBO.setHobbies(value);
			
		}
	}
	

}
