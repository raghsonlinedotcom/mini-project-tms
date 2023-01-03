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
import com.raghsonline.miniprojects.tms.dao.EmployeeDAO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet({ "/DeleteEmployeeServlet", "/DeleteEmployee" })
public class DeleteEmployeeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteEmployeeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		logger.info("DeleteEmployeeServlet - doPost() invoked");
		
	
		String decision = request.getParameter("decision");
		String message = null;
		String url = null;
		
		if(decision.equals("No"))
		{
			url = "index.jsp";
			message = "Thank you for staying back!!";
			request.setAttribute("message", message);
		}
		
		else 
		{
			// 1. Get the Employee Data from the session
			int empId;
			HttpSession session = request.getSession(true);
			EmployeeBO employeeBO = (EmployeeBO) session.getAttribute("employeeBO");
	
			empId = employeeBO.getEmpId();
			logger.info("EmployeeBO object from the session is " + employeeBO);
			logger.info("EmpId Parameter from the session : " + empId);
			EmployeeDAO employeeDAO = new EmployeeDAOImpl();
			int recordsUpdated =0;
			String errorMessage = null;
			try {
				recordsUpdated = employeeDAO.deleteEmployee(empId);
			} catch (Exception exception) {
				logger.error("Exception occurred while updating the data into the Database Table");
				logger.error("Message : " + exception.getMessage());
				request.setAttribute("errorMessage", exception.getMessage());
				request.getRequestDispatcher("index.jsp").forward(request, response);
				if (AppUtil.isAppDevMode) {
					exception.printStackTrace();
				}
				return;
			}
			
			
			if(recordsUpdated>0)
			{
				message = "Profile deleted successfully! Please register again to login";
				url = "login.jsp";
				request.setAttribute("message", message);
			}
			else 
			{
				errorMessage = "Error occured while deleting the Profile";
				url = "index.jsp";
				request.setAttribute("errorMessage", errorMessage);
			}
			
			// 5. Redirect/Delegate to the corresponding view
			
		}
		request.getRequestDispatcher(url).forward(request, response);
		

		
	}
}
