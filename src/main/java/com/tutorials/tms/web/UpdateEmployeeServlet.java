package com.tutorials.tms.web;

import java.io.IOException;
import java.sql.Date;

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
 * Servlet implementation class UpdateEmployeeServlet
 */

@WebServlet({ "/UpdateEmployeeServlet", "/UpdateEmployee" })

public class UpdateEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(this.getClass());

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

		String empIdStr = request.getParameter("empId");
		int empId = empIdStr != "" ? Integer.parseInt(empIdStr) : 0;
		String errorMsg = null;
		if (empId == 0) {
			errorMsg = "Employee Id missing cannot update the record";
		}
		if (null != errorMsg) {
			request.setAttribute("errorMsg", errorMsg);
		}

		String idStr = request.getParameter("id");
		int id = idStr != "" ? Integer.parseInt(idStr) : 0;

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		System.out.println("dob from request : " + request.getParameter("dob"));
		Date dateOfBirth = Date.valueOf(request.getParameter("dob"));
		String gender = request.getParameter("gender");
		String aadharId = request.getParameter("aadharId");
		String bloodGroup = request.getParameter("bloodGroup");
		String city = request.getParameter("city");
		String personalEmail = request.getParameter("personalEmail");
		String officialEmail = request.getParameter("officialEmail");
		String primaryContactNo = request.getParameter("primaryContactNumber");
		String secondaryContactNo = request.getParameter("secondaryContactNumber");
		String highestQualification = request.getParameter("highestQualification");
		String skillsets = request.getParameter("skillSets");
		Date dateOfJoining = Date.valueOf(request.getParameter("doj"));
		String hobbies = request.getParameter("hobbies");
		logger.info("Hobbies from edit.jsp " +hobbies);

		String manageridStr = request.getParameter("managerId");
		logger.info("Param - managerId : [" + manageridStr + "]");

		int managerid = manageridStr != null ? Integer.parseInt(manageridStr) : 0;

		EmployeeBO employeeBO = new EmployeeBO();
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
		employeeBO.setManagerId(managerid);

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

}
