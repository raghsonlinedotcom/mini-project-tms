package com.tutorials.tms.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.tutorials.tms.bo.EmployeeBO;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet({ "/ViewMyDetailsServlet", "/ViewMyDetails" })
public class ViewMyDetailsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewMyDetailsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("ViewMyDetailsServlet - doGet() invoked");

		// 1. Get the Employee Data from the session

		int empId;
		HttpSession session = request.getSession(true);
		EmployeeBO employeeBO = (EmployeeBO) session.getAttribute("employeeBO");

		empId = employeeBO.getEmpId();
		logger.info("EmployeeBO object from the session is " + employeeBO);
		logger.info("EmpId Parameter from the Request : " + empId);

		// 2. Store it in a way where the data is accessible in the JSP
		request.setAttribute("employeeBO", employeeBO);

		// 3. Forward / Delegate the control/flow the required JSP Page
		request.getRequestDispatcher("member/view.jsp").forward(request, response);
	}
}
