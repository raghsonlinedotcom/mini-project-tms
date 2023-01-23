package com.raghsonline.miniprojects.tms.web.leave;


import java.io.IOException;
import java.time.LocalDateTime;
import java.sql.Timestamp;
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
 * Servlet implementation class UpdateEmployeeServlet
 */

@WebServlet({ "/UpdateMyTeamsLeaveServlet", "/UpdateMyTeamsLeave" })

public class UpdateMyTeamsLeaveServlet extends HttpServlet 
{

	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(this.getClass());
	
	boolean validationError = false;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMyTeamsLeaveServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("UpdateMyTeamsLeaveServlet - doPost() invoked");
		
		String errorMsgUI = "<ul>";
		LeaveDetailBO leaveDetailBO= new LeaveDetailBO();
		
		String idStr = request.getParameter("id");
		int id = idStr != "" ? Integer.parseInt(idStr) : 0;
		logger.info("Param - id : [" + id + "]");
		errorMsgUI = validateField(leaveDetailBO, id, "id", errorMsgUI);

		String empIdStr = request.getParameter("empId");
		int empId = empIdStr != "" ? Integer.parseInt(empIdStr) : 0;
		logger.info("Param - empId : [" + empId + "]");
		errorMsgUI = validateField(leaveDetailBO, empId, "empId", errorMsgUI);
		
		String managerIdStr = request.getParameter("managerId");
		int managerId = managerIdStr != "" ? Integer.parseInt(managerIdStr) : 0;
		logger.info("Param - managerId : [" + managerId + "]");
		errorMsgUI = validateField(leaveDetailBO, managerId, "managerId", errorMsgUI);
		

		Timestamp fromDate = Timestamp.valueOf(request.getParameter("fromDate"));
		logger.info("Param - fromDate : [" + fromDate + "]");
		errorMsgUI = validateField(leaveDetailBO, fromDate, "fromDate", errorMsgUI);
		
		Timestamp toDate = Timestamp.valueOf(request.getParameter("toDate"));
		logger.info("Param - lastName : [" + toDate + "]");
		errorMsgUI = validateField(leaveDetailBO, toDate, "toDate", errorMsgUI);
		
		
		String leaveReason = request.getParameter("leaveReason");
		logger.info("Param - leaveReason : [" + leaveReason + "]");
		errorMsgUI = validateField(leaveDetailBO, leaveReason, "leaveReason", errorMsgUI);
		
		String status = request.getParameter("status");
		logger.info("Param - status : [" + status + "]");
		errorMsgUI = validateField(leaveDetailBO, status, "bloodGroup", errorMsgUI);
		
		String actionComment = request.getParameter("actionComment");
		logger.info("Param - actionComment : [" + actionComment + "]");
		
		// Action Comment is mandatory only if the leave is Rejected
		if(status.equals("Rejected"))
		{
			errorMsgUI = validateField(leaveDetailBO, actionComment, "actionComment", errorMsgUI);
		}
		
		String altContactNo = request.getParameter("altContactNo");
		logger.info("Param - altContactNo : [" + altContactNo + "]");
		
		Timestamp createdDate = Timestamp.valueOf(request.getParameter("createdDate"));
		logger.info("Param - createdDate : [" + createdDate + "]");
		errorMsgUI = validateField(leaveDetailBO, createdDate, "createdDate", errorMsgUI);
		
		String createdByStr = request.getParameter("createdBy");
		int createdBy = createdByStr != "" ? Integer.parseInt(createdByStr) : 0;
		logger.info("Param - createdBy : [" + createdBy + "]");
		errorMsgUI = validateField(leaveDetailBO, createdBy, "createdBy", errorMsgUI);
		
		LocalDateTime ldt = LocalDateTime.now();
		Timestamp updatedDate =java.sql.Timestamp.valueOf(ldt);
		
		HttpSession session = request.getSession(true);
		EmployeeBO managerInsession = (EmployeeBO) session.getAttribute("managerInsession");
		int updatedBy = managerInsession.getEmpId();
		
		if(validationError) {
        	errorMsgUI += "</ul>";
        	request.setAttribute("errorMsgUI", errorMsgUI);
        	request.setAttribute("leaveDetailBO", leaveDetailBO);
        	validationError = false;
        	request.getRequestDispatcher("/manager/editleavedetails.jsp").forward(request, response);
        	return;
        }
		

		leaveDetailBO.setId(id);
		leaveDetailBO.setEmpId(empId);
		leaveDetailBO.setManagerId(managerId);
		leaveDetailBO.setFromDate(fromDate);
		leaveDetailBO.setToDate(toDate);
		leaveDetailBO.setLeaveReason(leaveReason);
		leaveDetailBO.setStatus(status);
		leaveDetailBO.setActionComment(actionComment);
		leaveDetailBO.setAltContactNo(altContactNo);
		leaveDetailBO.setCreatedDate(createdDate);
		leaveDetailBO.setCreatedBy(createdBy);
		leaveDetailBO.setUpdatedDate(updatedDate);
		leaveDetailBO.setUpdatedBy(updatedBy);
		

		String exceptionMsg = null;
		int recordsUpdated = 0;
		LeaveDetailsDAO leaveDetailsDAO = null;
		String url = null;
		try {
			leaveDetailsDAO = new LeaveDetailsDAOImpl();
			recordsUpdated = leaveDetailsDAO.managerUpdateLeaveDetails(leaveDetailBO);
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
		} 
		else if (recordsUpdated > 0) {
			request.setAttribute("message", "Record updated successfully!");
			leaveDetailsDAO = new LeaveDetailsDAOImpl();
			try {
				leaveDetailBO = leaveDetailsDAO.getLeaveDetailsById(id);
			} catch (Exception exception) {
				logger.error("Exception occurred while reading the data from the Database Table");
				logger.error("Message : " + exceptionMsg);
				
				if (AppUtil.isAppDevMode) {
					exception.printStackTrace();
				}
			}
			logger.info("leaveDetailBO : " + leaveDetailBO);
			request.setAttribute("leaveDetailBO", leaveDetailBO);
			url = "/manager/viewleavedetails.jsp";
		}

		else {
			request.setAttribute("errorMsg", "Error while updating the record!");
			request.setAttribute("leaveDetailBO", leaveDetailBO);
			url = "/manager/editleavedetails.jsp";
		}
		
		// 5. Redirect/Delegate to the corresponding view
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private String addError(String errorMsg) {
		return "<li>" + errorMsg + "</li>";
	}
	
	public String validateField(LeaveDetailBO leaveDetailBO, int value, String fieldName, String errorMsgUI) {
		if(value==0) {	
			validationError = true;
			logger.error(fieldName + " cannot be Zero(0)");			
			errorMsgUI += addError(fieldName + " cannot be Zero(0)");
		} 
		
		setField(leaveDetailBO, fieldName, value);
		return errorMsgUI;
	}
	
	public String validateField(LeaveDetailBO leaveDetailBO, String value, String fieldName, String errorMsgUI) {
		if(null==value || value.trim().length()<=0) {	
			validationError = true;
			logger.error(fieldName + " cannot be null");			
			errorMsgUI += addError(fieldName + " cannot be null");
		} 
		
		setField(leaveDetailBO, fieldName, value);
		return errorMsgUI;
	}
	
	public String validateField(LeaveDetailBO leaveDetailBO, Timestamp value, String fieldName, String errorMsgUI) {
		if(null==value) {	
			validationError = true;
			logger.error(fieldName + " cannot be null");			
			errorMsgUI += addError(fieldName + " cannot be null");
		} 
		
		setField(leaveDetailBO, fieldName, value);
		return errorMsgUI;
	}
	
	
	public void setField(LeaveDetailBO leaveDetailBO, String fieldName ,int value)
	{
		switch(fieldName) 
		{
			case "id":
				leaveDetailBO.setId(value);
			break;
			
			case "empId":
				leaveDetailBO.setEmpId(value);
				break;
			case "managerId" :
				leaveDetailBO.setManagerId(value);
			case "createdBy" :
				leaveDetailBO.setCreatedBy(value);
			
		}
	}
	
	public void setField(LeaveDetailBO leaveDetailBO, String fieldName ,Timestamp value)
	{
		switch(fieldName) 
		{
			case "fromDate":
				leaveDetailBO.setFromDate(value);
				break;
			case "toDate":
				leaveDetailBO.setToDate(value);
				break;
			case "createdDate" :
				leaveDetailBO.setCreatedDate(value);
			
		}
	}
	
	public void setField(LeaveDetailBO leaveDetailBO, String fieldName ,String value)
	{
		switch(fieldName) 
		{
			case "leaveReason":
				leaveDetailBO.setLeaveReason(value);
				break;
			case "status" :
				leaveDetailBO.setStatus(value);
				break;
			case "actionComment" :
				leaveDetailBO.setActionComment(value);
				break;
		}
	}
	

}
