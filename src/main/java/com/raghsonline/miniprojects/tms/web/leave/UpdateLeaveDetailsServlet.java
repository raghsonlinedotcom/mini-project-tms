package com.raghsonline.miniprojects.tms.web.leave;

import java.io.IOException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.bo.LeaveDetailBO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

/**
 * Servlet implementation class UpdateLeaveDetailsServlet
 */

@WebServlet({ "/UpdateLeaveDetailsServlet", "/UpdateLeave" })

public class UpdateLeaveDetailsServlet extends HttpServlet 
{

	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(this.getClass());
	
	boolean validationError = false;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateLeaveDetailsServlet()
	{
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, 
	IOException 
	{
		logger.info("UpdateEmployeeServlet - doPost() invoked");
		
		String errorMsgUI = "<ul>";
		LeaveDetailBO leaveDetailBO = new LeaveDetailBO();
		
		String idStr = request.getParameter("id");
		int id = idStr != "" ? Integer.parseInt(idStr) : 0;
		logger.info("Param - id : [" + id + "]");
		errorMsgUI = validateField(leaveDetailBO, id, "id", errorMsgUI);

		String empIdStr = request.getParameter("empId");
		int empId = empIdStr != "" ? Integer.parseInt(empIdStr) : 0;
		logger.info("Param - empId : [" + empId + "]");
		errorMsgUI = validateField(leaveDetailBO, empId, "empId", errorMsgUI);
		
		String manageridStr = request.getParameter("managerId");
		int managerid = manageridStr != null ? Integer.parseInt(manageridStr) : 0;
		logger.info("Param - managerId : [" + managerid + "]");
		
		String fromDateStr = request.getParameter("fromDate");
		logger.info("Param - fromDateStr From editleave.jsp Page : [" + fromDateStr + "]");
		Timestamp fromDate = timestampFromString(fromDateStr);
		logger.info("Param - fromDate of Timestamp : [" + fromDate + "]");
		errorMsgUI = validateField(leaveDetailBO, fromDate, "fromDate", errorMsgUI);
		
		String toDateStr = request.getParameter("toDate");
		logger.info("Param - toDateStr From editleave.jsp Page : [" + toDateStr + "]");
		Timestamp toDate = timestampFromString(toDateStr);
		logger.info("Param - toDate of Timestamp : [" + fromDate + "]");
		errorMsgUI = validateField(leaveDetailBO, toDate, "toDate", errorMsgUI);
				
		String leaveReason = request.getParameter("leaveReason");
		logger.info("Param - leaveReason : [" + leaveReason + "]");
		errorMsgUI = validateField(leaveDetailBO, leaveReason, "leaveReason", errorMsgUI);
		
		String status = request.getParameter("status");
		logger.info("Param - status : [" + status + "]");
		errorMsgUI = validateField(leaveDetailBO, status, "status", errorMsgUI);
		
		String actionComment = request.getParameter("actionComment");
		logger.info("Param - actionComment : [" + actionComment + "]");
		errorMsgUI = validateField(leaveDetailBO, actionComment, "actionComment", errorMsgUI);
		
		String altContactNo = request.getParameter("altContactNo");
		logger.info("Param - altContactNo : [" + altContactNo + "]");
		errorMsgUI = validateAltContactNoField(leaveDetailBO, altContactNo, "altContactNo", errorMsgUI);
		
		LocalDateTime ldt = LocalDateTime.now();
		Timestamp utilDate =java.sql.Timestamp.valueOf(ldt);
		leaveDetailBO.setUpdatedDate(utilDate);
		
		int updatedBy=  leaveDetailBO.getEmpId();
		logger.info("Param - updatedBy : [" + updatedBy + "]");
		errorMsgUI = validateField(leaveDetailBO, updatedBy, "updatedBy", errorMsgUI);
		
		if(validationError) 
		{
        	errorMsgUI += "</ul>";
        	request.setAttribute("errorMsgUI", errorMsgUI);
        	request.setAttribute("leaveDetailBO", leaveDetailBO);
        	validationError = false;
        	request.getRequestDispatcher("/member/leave/editleave.jsp").forward(request, response);
        	return;
        }

		leaveDetailBO.setId(id);
		leaveDetailBO.setEmpId(empId);
		leaveDetailBO.setManagerId(managerid);
		leaveDetailBO.setFromDate(fromDate);
		leaveDetailBO.setToDate(toDate);
		leaveDetailBO.setLeaveReason(leaveReason);
		leaveDetailBO.setStatus(status);
		leaveDetailBO.setActionComment(actionComment);
		leaveDetailBO.setAltContactNo(altContactNo);
		leaveDetailBO.setUpdatedBy(updatedBy);

		String exceptionMsg = null;
		int recordsUpdated = 0;
		LeaveDetailsDAO leaveDetailsDAO =  new LeaveDetailsDAOImpl();
		String url = null;
		LeaveDetailBO leaveDetailBO1 = null;
		try 
		{
			recordsUpdated = leaveDetailsDAO.updateLeave(leaveDetailBO);
		} 
		catch (Exception exception) 
		{
			exceptionMsg = exception.getMessage();
			logger.error("Exception occurred while updating the data into the Database Table");
			logger.error("Message" + exceptionMsg);

			if (AppUtil.isAppDevMode)
			{
				exception.printStackTrace();
			}
		}
		
		if (null != exceptionMsg) 
		{
			request.setAttribute("exceptionMsg", exceptionMsg);
		} 
		else if (recordsUpdated > 0) 
		{
			request.setAttribute("message", "Record updated successfully!");
			leaveDetailsDAO = new LeaveDetailsDAOImpl();
			try 
			{
				leaveDetailBO1 = leaveDetailsDAO.getLeaveDetailsById(id);
				logger.info("Leave Details :" + leaveDetailBO1);
			} 
			catch (Exception exception) 
			{
				logger.error("Exception occurred while updating the data into the Database Leave Details Table");
				logger.error("Message : " + exceptionMsg);
				
				if (AppUtil.isAppDevMode) 
				{
					exception.printStackTrace();
				}
			}
			logger.info("leaveDetailBO1 : " + leaveDetailBO1);
			request.setAttribute("leaveDetailBO", leaveDetailBO1);
			url = "/member/leave/myleavedetails.jsp";
		}
		else 
		{
			request.setAttribute("errorMsg", "Error while updating the record!");
			request.setAttribute("leaveDetailBO", leaveDetailBO);
			url = "/member/leave/editleave.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private Timestamp timestampFromString(String dateTime) 
	{
		logger.info("Input dateTime : [" + dateTime + "]");
		
		DateTimeFormatter pattern = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		LocalDateTime ldtObj = LocalDateTime.parse(dateTime, pattern);
		
		logger.info("dateTimeObj : [" + ldtObj + "]");
		
		Timestamp timestamp = Timestamp.valueOf(ldtObj);
		logger.info("Timestamp value : [" + timestamp + "]");
		
		return timestamp;
	}

	private String addError(String errorMsg) 
	{
		return "<li>" + errorMsg + "</li>";
	}
	
	public String validateField(LeaveDetailBO leaveDetailBO, int value, String fieldName, String errorMsgUI)
	{
		if(value==0) 
		{	
			validationError = true;
			logger.error(fieldName + " cannot be Zero(0)");			
			errorMsgUI += addError(fieldName + " cannot be Zero(0)");
		} 	
		setField(leaveDetailBO, fieldName, value);
		return errorMsgUI;
	}
	
	public String validateField(LeaveDetailBO leaveDetailBO, String value, String fieldName, String errorMsgUI) 
	{
		if(null==value || value.trim().length()<=0) 
		{	
			validationError = true;
			logger.error(fieldName + " cannot be null");			
			errorMsgUI += addError(fieldName + " cannot be null");
		} 	
		setField(leaveDetailBO, fieldName, value);
		return errorMsgUI;
	}
	
	public String validateField(LeaveDetailBO leaveDetailBO, Timestamp value, String fieldName, String errorMsgUI)
	{
		if(null==value)
		{	
			validationError = true;
			logger.error(fieldName + " cannot be null");			
			errorMsgUI += addError(fieldName + " cannot be null");
		} 	
		setField(leaveDetailBO, fieldName, value);
		return errorMsgUI;
	}
	
	public String validateAltContactNoField(LeaveDetailBO leaveDetailBO, String value, String fieldName, String errorMsgUI) 
	{
		if(null == value)
		{
			logger.info("Alternate Contact Number is optional and length can be zero");
		}
		else if((value.trim().length()>0 && value.trim().length()<10) || value.trim().length()>10) 
		{	
			validationError = true;
			logger.error(fieldName + " is in invalid format");			
			errorMsgUI += addError(fieldName + "  can be optional or must have exactly 10 digits");
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
			case "managerId":
				leaveDetailBO.setManagerId(value);
				break;
			case "updatedBy" :
				leaveDetailBO.setUpdatedBy(value);
				break;
		}
	}
	
	public void setField(LeaveDetailBO leaveDetailBO, String fieldName ,Timestamp value)
	{
		switch(fieldName) 
		{
			case "dateOfBirth":
				leaveDetailBO.setFromDate(value);
				break;
			case "dateOfJoining":
				leaveDetailBO.setToDate(value);
				break;	
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
			case "altContactNo" :
				leaveDetailBO.setAltContactNo(value);
				break;
		}
	}
}