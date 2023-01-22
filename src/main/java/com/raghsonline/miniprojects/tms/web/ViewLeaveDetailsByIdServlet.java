package com.raghsonline.miniprojects.tms.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.bo.LeaveDetailsBO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet({ "/ViewLeaveDetailsByIdServlet", "/ViewLeaveDetailsById" })
public class ViewLeaveDetailsByIdServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewLeaveDetailsByIdServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("ViewLeaveDetailsByIdServlet - doGet() invoked");

		// 1. Get the Leave Details id from the request

		int id = 0;
		String idStr = request.getParameter("id");
		
		if(null!=idStr && idStr.trim().length()>0) {
			id = Integer.parseInt(idStr);
		}
		LeaveDetailsBO leaveDetailsBO = new LeaveDetailsBO();
		LeaveDetailsDAO leaveDetailsDAO = new LeaveDetailsDAOImpl();
		try {
			leaveDetailsBO = leaveDetailsDAO.viewLeaveDetailsById(id);
		} catch (Exception exception) {
			logger.error("Exception occurred while reading the data from the Database Table");
			logger.error("Message : " + exception.getMessage());
			
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			
		}
		logger.info("LeaveDetailsBO object from the database is " + leaveDetailsBO);
		

		// 2. Store it in a way where the data is accessible in the JSP
		request.setAttribute("leaveDetailsBO", leaveDetailsBO);

		// 3. Forward / Delegate the control/flow the required JSP Page
		request.getRequestDispatcher("/manager/viewleavedetails.jsp").forward(request, response);
	}
}
