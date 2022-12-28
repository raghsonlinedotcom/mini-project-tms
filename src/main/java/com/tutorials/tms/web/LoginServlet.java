package com.tutorials.tms.web;

import java.io.IOException;

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

@WebServlet(description = "A Servlet to handle the Login Action", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean validationError = false;
	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		logger.info("LoginServlet invoked!");
		
		response.setContentType("text/html");
		
		String errorMessage = null;
		
		EmployeeBO employeeBO = new EmployeeBO();
		
		// 1. Get the Employee Id
		String empIdStr = request.getParameter("empId");
		int empId = empIdStr != "" ? Integer.parseInt(empIdStr) : 0;
		if (empId == 0) {
			errorMessage = "Employee Id missing cannot proceed to login";
		}

		// 2. Get the password
		String password = request.getParameter("password");
		if (null == password || password.trim().length() <= 0) {
			errorMessage += "," + "Password missing cannot proceed to login";
		}
		
		// Authenticate/Validate
		
		if (null != errorMessage) {
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		try {
			employeeBO = employeeDAO.verifyEmployee(empId, password);
		} catch (Exception exception) {
			logger.error("Exception while fetching an Employee with the EmpId, Password - " + empId + password);
			logger.error("Error Message : " + exception.getMessage());
			if (AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}
		
		logger.info("Employee BO Object fetched from Database " +employeeBO);
		String message = null;
		String url = null;
		
		if(null!=employeeBO)
		{
			if (empId == employeeBO.getEmpId() && password.equals(employeeBO.getPassword())) {
				System.out.println("[INFO] Credentials matched!");
				url = "/index.jsp";
				message = "Welcome <b>" + employeeBO.getFirstName() + " " + employeeBO.getLastName() + "</b>";
				request.setAttribute("message", message);
				request.getSession().setAttribute("employeeBO", employeeBO);
			}
		}
		else
		{
			System.out.println("[ERR] Credentials Mismatch!");
			url = "/login.jsp";
			request.setAttribute("errorMessage", "Invalid Credentials. Try again!");
		}
			
		this.getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
