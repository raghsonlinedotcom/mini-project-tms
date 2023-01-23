package com.raghsonline.miniprojects.tms.web.leave;

import java.io.IOException;
import java.util.List;

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


/**
 * Servlet implementation class EmployeeListServlet
 */
@WebServlet("/ViewMyTeamsLeave")
public class MyTeamsLeaveServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyTeamsLeaveServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		logger.info("MyTeamsLeaveServlet - doGet() invoked");
		
		// Get the Manager id from the session
		
		int empId;
		HttpSession session = request.getSession(true);
		EmployeeBO employeeBO = (EmployeeBO) session.getAttribute("managerInsession");
		
		// Manager's emp_id
		empId = employeeBO.getEmpId();
		
		LeaveDetailsDAO leaveDetailsDAO = null;

		leaveDetailsDAO = new LeaveDetailsDAOImpl();
		List<LeaveDetailBO> leaveDetailsBOList = null;
		try 
		{
			leaveDetailsBOList = leaveDetailsDAO.getTeamLeaveDetails(empId);
		} 
		catch (Exception exception)
		{
			logger.error("Exception occurred while Obtaining the data from the Database Table");
			logger.error("Message" + exception);
		}
		request.setAttribute("leaveDetailsBOList", leaveDetailsBOList);

		request.getRequestDispatcher("/manager/teamleavedetails.jsp").forward(request, response);
	}
}
