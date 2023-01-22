package com.raghsonline.miniprojects.tms.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.bo.LeaveDetailsBO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

/**
 * Servlet implementation class ViewMyLeaveDetailsServlet
 */
@WebServlet({ "/ViewMyLeaveDetailsServlet", "/ViewMyLeaveDetails" })
public class ViewMyLeaveDetailsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewMyLeaveDetailsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("ViewMyLeaveDetailsServlet - doGet() invoked");

		// 1. Get the Employee Data from the request
		//int empId;
		//HttpSession session = request.getSession(true);
		//LeaveDetailsBO leavedetailsBO = (LeaveDetailsBO) session.getAttribute("leavedetailsBO");
		//empId = leavedetailsBO.getEmpId();
		//LeaveDetailsDAO leavedetailsDAO = new LeaveDetailsDAOImpl();
		int id = 0;
		String idStr = request.getParameter("id");
		
		if(null!=idStr && idStr.trim().length()>0) {
			id = Integer.parseInt(idStr);
		}
		LeaveDetailsBO leavedetailsBO = new LeaveDetailsBO();
		LeaveDetailsDAO leavedetailsDAO = new LeaveDetailsDAOImpl();
		try {
			leavedetailsBO = leavedetailsDAO.viewLeaveDetailsById(id);
		} catch (Exception exception) {
			logger.error("Exception occurred while reading the data from the Database Table");
			logger.error("Message : " + exception.getMessage());
			
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			
		}
		logger.info("LeaveDetailsBO object from the database is " + leavedetailsBO);
		

		// 2. Store it in a way where the data is accessible in the JSP
		request.setAttribute("leavedetailsBO", leavedetailsBO);

		// 3. Forward / Delegate the control/flow the required JSP Page
		request.getRequestDispatcher("/member/viewmyleavedetails.jsp").forward(request, response);
	}
}

