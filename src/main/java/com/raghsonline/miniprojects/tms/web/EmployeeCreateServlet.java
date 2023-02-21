package com.raghsonline.miniprojects.tms.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.bo.EmailConfigBO;
import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl;
import com.raghsonline.miniprojects.tms.exception.MissingConfigException;
import com.raghsonline.miniprojects.tms.util.AppUtil;
import com.raghsonline.miniprojects.tms.util.EmailConfigUtil;
import com.raghsonline.miniprojects.tms.util.EmailUtil;


/**
 * Servlet implementation class EmployeeCreateServlet
 */
@WebServlet({ "/EmployeeCreateServlet", "/EmployeeCreate" })
public class EmployeeCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(this.getClass());

	boolean validationError = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeCreateServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("EmployeeCreateServlet - doPost() invoked");

		// response.setContentType("text/html");
		// response.getWriter().println("RegisterServlet invoked!");

		// 1. Collect the input data
		String errorMsgUI = "<ul>";
		EmployeeBO employeeBO = new EmployeeBO();
		String empIdStr = request.getParameter("empId");
		int empId = empIdStr != null ? Integer.parseInt(empIdStr) : 0;

		// String empId = String.valueOf(request.getParameter("empId"));
		logger.info("Param - empId : [" + empId + "]");
		errorMsgUI = validateField(employeeBO, empId, "empId", errorMsgUI);

		/*
		 * if(null==empId || empId.trim().length()<=0) {
		 * logger.error("EmpId cannot be null"); employeeBO.setEmpId(""); errorMsgUI +=
		 * addError("Employee Id cannot be null"); }
		 */

		String firstName = String.valueOf(request.getParameter("firstName"));
		logger.info("Param - firstName : [" + firstName + "]");
		errorMsgUI = validateField(employeeBO, firstName, "firstName", errorMsgUI);

		String lastName = String.valueOf(request.getParameter("lastName"));
		logger.info("Param - lastName : [" + lastName + "]");
		errorMsgUI = validateField(employeeBO, lastName, "lastName", errorMsgUI);

		Date dateOfBirth = Date.valueOf(request.getParameter("dob"));
		logger.info("Param - dateOfBirth : [" + dateOfBirth + "]");
		errorMsgUI = validateField(employeeBO, dateOfBirth, "dateOfBirth", errorMsgUI);

		String gender = String.valueOf(request.getParameter("gender"));
		logger.info("Param - gender : [" + gender + "]");
		errorMsgUI = validateField(employeeBO, gender, "gender", errorMsgUI);

		String aadharId = String.valueOf(request.getParameter("aadharId"));
		logger.info("Param - aadharId : [" + aadharId + "]");
		errorMsgUI = validateAadharField(employeeBO, aadharId, "aadharId", errorMsgUI);

		String bloodGroup = String.valueOf(request.getParameter("bloodGroup"));
		logger.info("Param - bloodGroup : [" + bloodGroup + "]");
		errorMsgUI = validateField(employeeBO, bloodGroup, "bloodGroup", errorMsgUI);

		String city = String.valueOf(request.getParameter("city"));
		logger.info("Param - city : [" + city + "]");
		errorMsgUI = validateField(employeeBO, city, "city", errorMsgUI);

		String personalEmail = String.valueOf(request.getParameter("personalEmail"));
		logger.info("Param - personalEmail : [" + personalEmail + "]");
		errorMsgUI = validateField(employeeBO, personalEmail, "personalEmail", errorMsgUI);

		String officialEmail = String.valueOf(request.getParameter("officialEmail"));
		logger.info("Param - officialEmail : [" + officialEmail + "]");
		errorMsgUI = validateField(employeeBO, officialEmail, "officialEmail", errorMsgUI);

		String password = String.valueOf(request.getParameter("password"));
		logger.info("Param - password : [" + password + "]");
		errorMsgUI = validateField(employeeBO, password, "password", errorMsgUI);

		String primaryContactNo = String.valueOf(request.getParameter("primaryContactNumber"));
		logger.info("Param - primaryContactNo : [" + primaryContactNo + "]");
		errorMsgUI = validatePrimaryContactNumberField(employeeBO, primaryContactNo, "primaryContactNo", errorMsgUI);

		String secondaryContactNo = String.valueOf(request.getParameter("secondaryContactNumber"));
		logger.info("Param - secondaryContactNo : [" + secondaryContactNo + "]");
		errorMsgUI = validateSecondaryContactNoField(employeeBO, secondaryContactNo, "secondaryContactNo", errorMsgUI);

		String highestQualification = String.valueOf(request.getParameter("highestQualification"));
		logger.info("Param - highestQualification : [" + highestQualification + "]");
		errorMsgUI = validateField(employeeBO, highestQualification, "highestQualification", errorMsgUI);

		String skillsets = String.valueOf(request.getParameter("skillSets"));
		logger.info("Param - skillsets : [" + skillsets + "]");
		errorMsgUI = validateField(employeeBO, skillsets, "skillsets", errorMsgUI);

		Date dateOfJoining = Date.valueOf(request.getParameter("doj"));
		logger.info("Param - dateOfJoining : [" + dateOfJoining + "]");
		errorMsgUI = validateField(employeeBO, dateOfJoining, "dateOfJoining", errorMsgUI);

		String hobbies = String.valueOf(request.getParameter("hobbies"));
		logger.info("Param - hobbies : [" + hobbies + "]");
		errorMsgUI = validateHobbiesField(employeeBO, hobbies, "hobbies", errorMsgUI);

		String manageridStr = request.getParameter("managerId");
		logger.info("Param - managerId : [" + manageridStr + "]");

		int managerid = manageridStr != null ? Integer.parseInt(manageridStr) : 0;

		if (validationError) {
			errorMsgUI += "</ul>";
			request.setAttribute("errorMsgUI", errorMsgUI);
			request.setAttribute("employeeForm", employeeBO);
			validationError = false;
			request.getRequestDispatcher("create.jsp").forward(request, response);
			return;
		}

		// 2. Prepare the BO object
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
		employeeBO.setPassword(password);
		employeeBO.setPrimaryContactNo(primaryContactNo);
		employeeBO.setSecondaryContactNo(secondaryContactNo);
		employeeBO.setHighestQualification(highestQualification);
		employeeBO.setSkillsets(skillsets);
		employeeBO.setDateOfJoining(dateOfJoining);
		employeeBO.setHobbies(hobbies);
		employeeBO.setManagerId(managerid);

		// 3. Save it into the Database
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		int lastInsertedId = -1;
		String errorMsg = "<ul>";
		Exception exceptionObj = null;
		/* MEMS-18, MEMS-19 */
		int sqlErrorCode = -1;
		String sqlState = null;

		boolean isError = false;

		try {
			lastInsertedId = employeeDAO.createEmployee(employeeBO);
		} catch (ClassNotFoundException classNotFoundException) {
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

		if (isError) {
			logger.error("Exception while registering the EmployeeBO");
			errorMsg = exceptionObj.getMessage();
			logger.error("Error Message : " + errorMsg);
			if (exceptionObj instanceof SQLException) {
				logger.error("Error Code : " + sqlErrorCode);
				logger.error("SQL State : " + sqlState);
			}
			if (AppUtil.isAppDevMode) {
				exceptionObj.printStackTrace();
			}
		} 
		else /* Successfully registered, you can send a confirmation email */
		{
			EmailConfigBO emailConfigBO = EmailConfigUtil.loadEmailConfigForTMS();
			emailConfigBO.setEmailTo(employeeBO.getOfficialEmail());
			boolean emailSent = false;
			
			try {
				emailSent = new EmailUtil().sendMail(emailConfigBO);
			} catch (AddressException addressException) {
				logger.error("AddressException while sending an email to the employee");
				String errorMsg2 = addressException.getMessage();
				logger.error("Error Message : " + errorMsg2);
				if (AppUtil.isAppDevMode) {
					addressException.printStackTrace();
				}
			} catch (MessagingException messagingException) {
				logger.error("MessagingException while sending an email to the employee");
				String errorMsg3 = messagingException.getMessage();
				logger.error("Error Message : " + errorMsg3);
				if (AppUtil.isAppDevMode) {
					messagingException.printStackTrace();
				}
			} catch (MissingConfigException missingConfigException) {
				logger.error("MissingConfigException while sending an email to the employee");
				String errorMsg4 = missingConfigException.getMessage();
				logger.error("Error Message : " + errorMsg4);
				if (AppUtil.isAppDevMode) {
					missingConfigException.printStackTrace();
				}
			}
			
			if(emailSent) {
				logger.info("Email has been successfully sent to [" + emailConfigBO.getEmailTo() + "]");	
			} else {
				logger.info("The email was not sent to the employee [" + emailConfigBO.getEmailTo() + "]");
			}
		}
	
		String message = null;
		String url = null;

		if (lastInsertedId <= 0) { /* Error */
			message = "Error while registering the EmployeeBO. ";

			if (exceptionObj instanceof ClassNotFoundException) {
				message = "Error connecting with the Database. Please contact Admin.";
			} else if (exceptionObj instanceof SQLIntegrityConstraintViolationException) {
				message = message + "User already exists";
			} else {
				message = message + " Reason : " + errorMsg;
			}
			url = "create.jsp";
		} else { /* Success */
			message = "Registration successful. Your Id  is : " + lastInsertedId;
			url = "login.jsp";
		}

		logger.info("Last Inserted Id : " + lastInsertedId);
		logger.info("url : " + url);
		logger.info("message : " + message);
		request.setAttribute("message", message);
		request.setAttribute("employeeForm", employeeBO);

		request.getRequestDispatcher(url).forward(request, response);
	}

	private String addError(String errorMsg) {
		return "<li>" + errorMsg + "</li>";
	}

	// Method OverLoading
	public String validateAadharField(EmployeeBO employeeBO, String value, String fieldName, String errorMsgUI) {
		if (value.trim().length() != 12 || value.trim().length() > 12) {
			validationError = true;
			logger.error(fieldName + "aadharId should contain a 12 digits ");
			errorMsgUI += addError(fieldName + "aadharId should contain a 12 digits");
		}

		setField(employeeBO, fieldName, value);

		return errorMsgUI;
	}

	public String validatePrimaryContactNumberField(EmployeeBO employeeBO, String value, String fieldName,
			String errorMsgUI) {
		if (value.trim().length() != 10) {
			validationError = true;
			logger.error(fieldName + "PrimaryContactNumber should contain a 10 digits ");
			errorMsgUI += addError(fieldName + "PrimaryContactNumber should contain a 10 digits");
		}

		setField(employeeBO, fieldName, value);

		return errorMsgUI;
	}

	public String validateSecondaryContactNoField(EmployeeBO employeeBO, String value, String fieldName,
			String errorMsgUI) {
		if (value.trim().length() == 0) {
			logger.info("Secondary contact number is optional and length can be zero");
		}

		else if ((value.trim().length() > 0 && value.trim().length() < 10) || value.trim().length() > 10) {
			validationError = true;
			logger.error(fieldName + " is in invalid format");
			errorMsgUI += addError(fieldName + "  can be optional or must have exactly 10 digits");
		}

		setField(employeeBO, fieldName, value);
		return errorMsgUI;
	}

	public String validateHobbiesField(EmployeeBO employeeBO, String value, String fieldName, String errorMsgUI) {
		if (value.trim().length()>100) {
			validationError = true;
			logger.error(fieldName + "hobbies should contain a 100 or fewer characters");
			errorMsgUI += addError(fieldName + "hobbies should contain a 100 or fewer characters");
		}

		setField(employeeBO, fieldName, value);

		return errorMsgUI;
	}

	// Method OverLoading
	public String validateField(EmployeeBO employeeBO, String value, String fieldName, String errorMsgUI) {
		if (null == value || value.trim().length() <= 0) {
			validationError = true;
			logger.error(fieldName + " cannot be null");
			errorMsgUI += addError(fieldName + " cannot be null");
		}

		setField(employeeBO, fieldName, value);

		return errorMsgUI;
	}

	// Method OverLoading
	public String validateField(EmployeeBO employeeBO, int value, String fieldName, String errorMsgUI) {
		if (value == 0) {
			validationError = true;
			logger.error(fieldName + " cannot be Zero(0)");
			errorMsgUI += addError(fieldName + " cannot be Zero(0)");
		}

		setField(employeeBO, fieldName, value);

		return errorMsgUI;
	}

	// Method OverLoading
	public String validateField(EmployeeBO employeeBO, Date value, String fieldName, String errorMsgUI) {
		if (null == value) {
			validationError = true;
			logger.error(fieldName + " cannot be null");
			errorMsgUI += addError(fieldName + " cannot be null");
		}

		setField(employeeBO, fieldName, value);

		return errorMsgUI;
	}

	public void setField(EmployeeBO employeeBO, String fieldName, String value) {
		switch (fieldName) {
		case "firstName":
			employeeBO.setFirstName(value);
			break;
		case "lastName":
			employeeBO.setLastName(value);
			break;

		case "aadharId":
			employeeBO.setAadharId(value);
			break;
		case "bloodGroup":
			employeeBO.setBloodGroup(value);
			break;
		case "city":
			employeeBO.setCity(value);
			break;
		case "personalEmail":
			employeeBO.setPersonalEmail(value);
			break;
		case "officialEmail":
			employeeBO.setOfficialEmail(value);
			break;
		case "password":
			employeeBO.setPassword(value);
			break;
		case "primaryContactNo":
			employeeBO.setPrimaryContactNo(value);
			break;
		case "secondaryContactNumber":
			employeeBO.setSecondaryContactNo(value);
			break;
		case "highestQualification":
			employeeBO.setHighestQualification(value);
			break;
		case "skillsets":
			employeeBO.setSkillsets(value);
			break;
		case "hobbies":
			employeeBO.setHobbies(value);
			break;
		

		}
	}

	// Method OverLoading
	public void setField(EmployeeBO employeeBO, String fieldName, int value) {
		switch (fieldName) {
		case "empId":
			employeeBO.setEmpId(value);
			break;

		}
	}

	// Method OverLoading
	public void setField(EmployeeBO employeeBO, String fieldName, char value) {
		switch (fieldName) {
		case "gender":
			employeeBO.setGender(value);
			break;

		}
	}

	// Method OverLoading
	public void setField(EmployeeBO employeeBO, String fieldName, Date value) {
		switch (fieldName) {
		case "dateOfBirth":
			employeeBO.setDateOfBirth(value);
			break;
		case "dateOfJoining":
			employeeBO.setDateOfJoining(value);
			break;

		}
	}
}
