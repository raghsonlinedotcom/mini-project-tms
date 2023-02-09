package com.raghsonline.miniprojects.tms.web.leave;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.bo.LeaveDetailBO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

/**
 * Servlet implementation class CreateLeaveDetailsServlet
 */
@WebServlet({ "/CreateLeaveDetailsServlet", "/CreateLeaveDetails" })
public class CreateLeaveDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Logger logger = Logger.getLogger(this.getClass());

	boolean validationError = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateLeaveDetailsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		logger.info("LeaveDetailsCreateServlet - doPost() invoked");

		// 1. Collect the input data
		String errorMsgUI = "<ul>";
		LeaveDetailBO leaveDetailBO = new LeaveDetailBO();
		
		String empIdStr = request.getParameter("empId");
		int empId = empIdStr != null ? Integer.parseInt(empIdStr) : 0;
		logger.info("Param - empId : [" + empId + "]");
		errorMsgUI = validateField(leaveDetailBO, empId, "empId", errorMsgUI);

		String managerIdStr = request.getParameter("managerId");
		logger.info("Param - managerId : [" + managerIdStr + "]");
		int managerId = managerIdStr != null ? Integer.parseInt(managerIdStr) : 0;
		
		HttpSession session = request.getSession(true);
		EmployeeBO managerInsession = (EmployeeBO) session.getAttribute("managerInsession");
		
		if(null==managerInsession)
		{
			errorMsgUI = validateField(leaveDetailBO, managerId, "managerId", errorMsgUI);
		}
		
		if(null!=managerInsession)
		{
			managerId = -1;
		}

		String fromDateStr = request.getParameter("fromDate");
		logger.info("Param - fromDate : [" + fromDateStr + "]");
		Timestamp fromDate = timestampFromString(fromDateStr);
		logger.info("Timestamp - fromDate : [" + fromDate + "]");
		leaveDetailBO.setFromDate(fromDate);
		errorMsgUI = validateField(leaveDetailBO, fromDate, "fromDate", errorMsgUI);
		

		String toDateStr = request.getParameter("toDate");
		logger.info("Param - toDate : [" + toDateStr + "]");
		Timestamp toDate = timestampFromString(toDateStr);
		logger.info("Timestamp - toDate : [" + toDate + "]");
		leaveDetailBO.setToDate(toDate);
		errorMsgUI = validateField(leaveDetailBO, toDate, "toDate", errorMsgUI);

		String leaveReason = String.valueOf(request.getParameter("leaveReason"));
		logger.info("Param - leaveReason : [" + leaveReason + "]");
		errorMsgUI = validateField(leaveDetailBO, leaveReason, "leaveReason", errorMsgUI);

		String altContactNo = String.valueOf(request.getParameter("alternateContactNo"));
		logger.info("Param - altContactNo : [" + altContactNo + "]");
		errorMsgUI = validateAltContactNoField(leaveDetailBO, altContactNo, "altContactNo", errorMsgUI);
		
		String createdByStr = request.getParameter("createdBy");
		int createdBy = createdByStr != null ? Integer.parseInt(createdByStr) : 0;

		logger.info("Param - createdBy : [" + createdBy + "]");
		errorMsgUI = validateField(leaveDetailBO, createdBy, "createdBy", errorMsgUI);


		if (validationError) {
			errorMsgUI += "</ul>";
			request.setAttribute("errorMsgUI", errorMsgUI);
			request.setAttribute("leaveDetailBO", leaveDetailBO);
			validationError = false;
			request.getRequestDispatcher("/member/leave/createleavedetails.jsp").forward(request, response);
			return;
		}

		// 2. Prepare the BO object
		leaveDetailBO.setEmpId(empId);
		logger.info("manager id before setting it in BO object " +managerId);
		leaveDetailBO.setManagerId(managerId);
		leaveDetailBO.setLeaveReason(leaveReason);
		leaveDetailBO.setAltContactNo(altContactNo);
		leaveDetailBO.setCreatedBy(createdBy);
		
		// 3. Save it into the Database
		LeaveDetailsDAO leaveDetailsDAO = new LeaveDetailsDAOImpl();
		int lastInsertedId = -1;
		String errorMsg = "<ul>";
		Exception exceptionObj = null;
		int sqlErrorCode = -1;
		String sqlState = null;

		boolean isError = false;

		try {
			lastInsertedId = leaveDetailsDAO.createLeaveDetails(leaveDetailBO);
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
			logger.error("Exception while registering the LeaveDetailsBO");
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

		String message = null;
		String url = null;

		if (lastInsertedId <= 0) { /* Error */
			message = "Error while Applying the Leave. ";

			if (exceptionObj instanceof ClassNotFoundException) {
				message = "Error connecting with the Database. Please contact Admin.";
			} else if (exceptionObj instanceof SQLIntegrityConstraintViolationException) {
				message = message + "ManagerId Can't be Null";
			} else {
				message = message + " Reason : " + errorMsg;
			}
			url = "member/leave/createleavedetails.jsp";
		} 
		
		else { /* Success */
			try {
				leaveDetailBO = leaveDetailsDAO.getLeaveDetailsById(lastInsertedId);
			} 
			catch (Exception exception) 
			{
				logger.error("Exception occurred while reading the data from the Database Table");
				logger.error("Message : " + exception.getMessage());
				
				if (AppUtil.isAppDevMode) 
				{
					exception.printStackTrace();
				}
			}
			message = "Your leave request has been received. Your Leave Id  is : " + lastInsertedId;
			url = "member/leave/myleavedetails.jsp";
		}

		logger.info("Last Inserted Id : " + lastInsertedId);
		logger.info("url : " + url);
		logger.info("message : " + message);
		request.setAttribute("message", message);
		request.setAttribute("leaveDetailBO", leaveDetailBO);

		request.getRequestDispatcher(url).forward(request, response);
	}

	private String addError(String errorMsg) {
		return "<li>" + errorMsg + "</li>";
	}

	public Timestamp timestampFromString(String dateTime) 
	{
		logger.info("Input dateTime : [" + dateTime + "]");
		
		DateTimeFormatter pattern = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		LocalDateTime ldtObj = LocalDateTime.parse(dateTime, pattern);
		
		logger.info("dateTimeObj : [" + ldtObj + "]");
		
		Timestamp timestamp = Timestamp.valueOf(ldtObj);
		logger.info("Timestamp value : [" + timestamp + "]");
		
		return timestamp;
	}
	
	public String validateAltContactNoField(LeaveDetailBO leaveDetailBO, String value, String fieldName, String errorMsgUI) {
		if(null==value || value.trim().length()!=10) {	
			validationError = true;
			logger.error(fieldName + " is in invalid format");			
			errorMsgUI += addError(fieldName + " must have exactly 10 digits");
		} 
		
		setField(leaveDetailBO, fieldName, value);
		return errorMsgUI;
	}

	// Method OverLoading
	public String validateField(LeaveDetailBO leaveDetailBO, String value, String fieldName, String errorMsgUI) 
	{
		if (null == value || value.trim().length() <= 0)
		{
			validationError = true;
			logger.error(fieldName + " cannot be null");
			errorMsgUI += addError(fieldName + " cannot be null");
		}

		setField(leaveDetailBO, fieldName, value);

		return errorMsgUI;
	}

	// Method OverLoading
	public String validateField(LeaveDetailBO leaveDetailBO, int value, String fieldName, String errorMsgUI) 
	{
		if (value == 0) 
		{
			validationError = true;
			logger.error(fieldName + " cannot be Zero(0)");
			errorMsgUI += addError(fieldName + " cannot be Zero(0)");
		}

		setField(leaveDetailBO, fieldName, value);

		return errorMsgUI;
	}

	// Method OverLoading
	public String validateField(LeaveDetailBO leaveDetailBO, Timestamp value, String fieldName, String errorMsgUI) 
	{
		if (null == value) 
		{
			validationError = true;
			logger.error(fieldName + " cannot be null");
			errorMsgUI += addError(fieldName + " cannot be null");
		}

		setField(leaveDetailBO, fieldName, value);

		return errorMsgUI;
	}
	

	public void setField(LeaveDetailBO leaveDetailBO, String fieldName, String value) 
	{
		switch (fieldName) 
		{
			case "leaveReason":
				leaveDetailBO.setLeaveReason(value);
				break;
			case "status":
				leaveDetailBO.setStatus(value);
				break;
			case "actionComment":
				leaveDetailBO.setActionComment(value);
				break;
			case "altContactNo":
				leaveDetailBO.setAltContactNo(value);
				break;
		}
	}

	// Method OverLoading
	public void setField(LeaveDetailBO leaveDetailBO, String fieldName, int value)
	{
		switch (fieldName) 
		{
			case "empId":
				leaveDetailBO.setEmpId(value);
				break;
			case "managerId":
				leaveDetailBO.setManagerId(value);
				break;
			case "createdBy":
				leaveDetailBO.setCreatedBy(value);
				break;
		}
	}

	// Method OverLoading
	public void setField(LeaveDetailBO leaveDetailBO, String fieldName, Timestamp value) 
	{
		switch (fieldName)
		{
			case "fromDate":
				leaveDetailBO.setFromDate(value);
				break;
			case "toDate":
				leaveDetailBO.setToDate(value);
				break;
		}
	}
}